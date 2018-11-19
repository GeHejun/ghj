package filter;

import com.ghj.common.OkHttpUtil;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.util.StringUtils;

public class ShiroFilter extends AccessControlFilter {

    ${"backUrl"}
    public String backUrl;

    //允许访问
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        String token = servletRequest.getParameter("token");
        String systemType = servletRequest.getParameter("systemType");
        if ("sso-server".equals(systemType)) {
            return true;
        }
        String backUrl = "";
        if (!StringUtils.isEmpty(token) && !StringUtils.isEmpty(systemType)) {
            return validate(token, systemType);
        }
        return false;
    }
    //服务器端验证
    private boolean validate(String token, String systemId) throws IOException {
        String ssoValidateUrl = "http://localhost:8083/sso/validate?token="+token;
        Map<String, String> params = new HashMap<>();
        params.put("token", token);
        params.put("systemId", systemId);
        JsonObject jsonObject = OkHttpUtil.syncGet(ssoValidateUrl, params);
        if (jsonObject != null) {
            Boolean isValid = jsonObject.get("isValid").getAsBoolean();
            if (isValid) {
                return  true;
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
