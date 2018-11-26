package com.ghj.filter;

import com.ghj.config.OkHttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.omg.CORBA.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.net.www.http.HttpClient;

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
        String sessionId = session.getId().toString();
        String token = stringRedisTemplate.opsForValue().get("sso-client-sessionId_" + sessionId);
        if (!StringUtils.isEmpty(token)) {
            stringRedisTemplate.opsForValue().set("sso-client-sessionId_" + sessionId,token);
            return true;
        }
        String serverToken = request.getParameter("serverToken");
        if (!StringUtils.isEmpty(serverToken)) {
            OkHttpClient okHttpClient = new OkHttpClient();
            FormBody formBody = new FormBody.Builder().add("token",serverToken).build();
            Request okRequest = new Request.Builder().post(formBody).url(ssoValidateUrl).build();
            Response execute = okHttpClient.newCall(okRequest).execute();
            String s = execute.body().toString();
            if (s != null) {
//                Boolean isValid = jsonObject.get("isValid").getAsBoolean();
//                if (isValid) {
                    stringRedisTemplate.opsForValue().set("sso-client-sessionId_" + sessionId,token);
                    return  true;
//                }
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