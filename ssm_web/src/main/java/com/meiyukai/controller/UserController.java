package com.meiyukai.controller;

import com.meiyukai.ssm.domain.UserInfo;
import com.meiyukai.ssm.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user")

public class UserController {
    @Resource(name = "userService")
    private UserService userService;


    /**
     * 查询所有的用户信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll.do")
    public String  findAll(Model model){
        List<UserInfo> userInfos =  userService.findAll();
        model.addAttribute("users"  , userInfos);
        return "user-list";
    }


    /**
     *  保存用户信息
     */
    @RequestMapping(value = "/save.do")
    public String saveUserInfo( UserInfo userInfo){
        System.out.println("userInfo :  " + userInfo);
        userInfo.setId(UUID.randomUUID().toString().replace("-",""));
        userService.saveUserInfo(userInfo);
        return "forward:findAll.do";
    }



    /**
     * 根据指定的id 查询user
     */
    @RequestMapping(value = "/findById.do")
    public String findById(String id , Model model){
        UserInfo userInfo = userService.findUserById(id);
        System.out.println("userinfo :    " + userInfo);
        model.addAttribute("user" , userInfo);
        return "user-detail";

    }







}
