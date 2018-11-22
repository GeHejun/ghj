package com.ghj.filter;

import com.ghj.config.OkHttpUtil;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

@PropertySource(value = "classpath:shiro.properties")
@Component("xx")
public class ShiroFilter extends AccessControlFilter {


    @Value("${sso.server.login.url}")
    public String ssoServerLoginUrl;

    @Value("${sso.validate.url}")
    public String ssoValidateUrl;

    @Value("${sso.type}")
    private String ssoType;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //允许访问
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws IOException {
        if ("server".equals(ssoType)) {
            return true;
        }
        return this.validate(servletRequest,servletResponse);

    }
    //服务器端验证
    private boolean validate(ServletRequest request,ServletResponse response) throws IOException {
        Session session = getSubject(request,response).getSession();
        String token = session.getId().toString();
        String loginMark = stringRedisTemplate.opsForValue().get("sso-client-token" + token);
        if (!StringUtils.isEmpty(loginMark)) {
            stringRedisTemplate.opsForValue().set("sso-client-token" + token,token,SecurityUtils.getSubject().getSession().getTimeout() / 1000);
            return true;
        }
        String serverToken = request.getParameter("serverToken");
        if (!StringUtils.isEmpty(serverToken)) {
            Map<String, String> params = new HashMap<>();
            params.put("token", serverToken);
            JsonObject jsonObject = OkHttpUtil.syncGet(ssoValidateUrl, params);
            if (jsonObject != null) {
                Boolean isValid = jsonObject.get("isValid").getAsBoolean();
                if (isValid) {
                    return  true;
                }
            }
        }
        return false;

    }

    //不允许访问
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        String index;
        //地址
        String backUrl = ((HttpServletRequest)servletRequest).getRequestURL().toString();
        index = ssoServerLoginUrl+"?backUrl="+backUrl;
        org.apache.shiro.web.util.WebUtils.toHttp(servletResponse).sendRedirect(index);
        return false;
    }

}