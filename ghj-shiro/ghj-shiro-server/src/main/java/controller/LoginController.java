package controller;

import com.ghj.entity.shiro.Token;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sso")
public class LoginController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String userName, String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("参数不可为空");
        }
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(userName, password));
        String backUrl = request.getParameter("backUrl");
        String token = UUID.randomUUID().toString().replace("-", "");
//        String sessionId = subject.getSession().getId().toString();
//        stringRedisTemplate.opsForValue().set("sso-server-session" + sessionId, token, subject.getSession().getTimeout());
        stringRedisTemplate.opsForValue().set("sso-server-token" + token, token, subject.getSession().getTimeout() / 1000);
        return "redirect:/" + backUrl;
    }

    @RequestMapping("/validate")
    public String validate(HttpServletRequest request) {
        String tokenParam = request.getParameter("token");
        String token = stringRedisTemplate.opsForValue().get("sso-server-token" + tokenParam);
        Gson gson = new Gson();
        if (!StringUtils.isEmpty(token)) {
            gson.toJson(new Token(true));
        }
        return gson.toJson(new Token(false));
    }

}
