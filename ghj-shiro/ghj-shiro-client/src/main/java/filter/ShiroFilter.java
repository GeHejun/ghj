package filter;

import com.google.gson.JsonObject;
import config.OkHttpUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

@PropertySource(value = "classpath:shiro.properties")
public class ShiroFilter extends AuthorizationFilter {

    @Value("${sso.validate.url}")
    public String ssoValidateUrl;

    @Value("${sso.server.login.url}")
    public String ssoServerLoginUrl;


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //允许访问
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        if (!StringUtils.isEmpty(servletRequest)) {
            return validate(servletRequest);
        }
        return false;
    }
    //服务器端验证
    private boolean validate(ServletRequest request) throws IOException {
        Session session = SecurityUtils.getSubject().getSession();
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
        //地址
        String backUrl = ((HttpServletRequest)servletRequest).getRequestURL().toString();
        ssoServerLoginUrl = ssoValidateUrl+"&backUrl="+backUrl;
        OkHttpUtil.syncGet(ssoServerLoginUrl,null);
        return false;
    }

}
