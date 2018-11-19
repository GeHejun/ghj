package filter;

import com.ghj.common.OkHttpUtil;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

@ConfigurationProperties(prefix = "shiro")
public class ShiroFilter extends AuthorizationFilter {

    public String backUrl;

    public String ssoValidateUrl;


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
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //地址
        String ssoServerLoginUrl = "";
        return false;
    }

    public void toLogin() {

    }
}
