package com.ghj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ghj.service.LoginService;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void login(@RequestParam(required = false) String token, String redirectUrl) {

    }
}
