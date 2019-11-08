package com.meiyukai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    /**
     * 避免直接跳转 某个jsp
     * @return
     */
    @RequestMapping(value = "/toLogin.do")
    public String  toLogin(){
        System.out.println("------------------come to the login jsp !-------------");
        return "main";
    }





}
