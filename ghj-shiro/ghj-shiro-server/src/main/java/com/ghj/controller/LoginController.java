package com.ghj.controller;

import com.google.gson.Gson;
import com.ghj.entity.Token;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sso")
public class LoginController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) throws UnsupportedEncodingException {
        String backUrl = request.getParameter("backUrl");
        return "redirect:/sso/login?backUrl=" + URLEncoder.encode(backUrl, "utf-8");
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,Model model) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String token = session.getId().toString();
        String tokenResult = stringRedisTemplate.opsForValue().get("sso-server-token" + token);
        if (!StringUtils.isEmpty(tokenResult)) {
            String backUrl = request.getParameter("backUrl");
            String userName = (String) subject.getPrincipal();
            if (backUrl.contains("?")) {
                return "redirect:"+backUrl+"serverToken:"+tokenResult+"userName:"+userName;
            } else {
                return "redirect:"+backUrl+"?serverToken:"+tokenResult+"userName:"+userName;
            }

        }
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Token login(HttpServletRequest request, String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("参数不可为空");
        }
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username, password));
        String backUrl = request.getParameter("backUrl");
        String token = UUID.randomUUID().toString().replace("-", "");
        stringRedisTemplate.opsForValue().set("sso-server-token" + token, token, subject.getSession().getTimeout());
        return new Token(true);
    }

    @RequestMapping("/validate")
    @ResponseBody
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
