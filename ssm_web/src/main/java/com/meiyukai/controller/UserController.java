package com.meiyukai.controller;

import com.meiyukai.ssm.domain.User;
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
        List<User> users =  userService.findAll();
        model.addAttribute("users"  ,  users);
        return "user-list";
    }


    /**
     *  保存用户信息
     */
    @RequestMapping(value = "/save.do")
    public String saveUserInfo( User user){
        System.out.println("userInfo :  " +  user);
        user.setId(UUID.randomUUID().toString().replace("-",""));
        userService.saveUserInfo(user);
        return "forward:findAll.do";
    }



    /**
     * 根据指定的id 查询user
     */
    @RequestMapping(value = "/findById.do")
    public String findById(String id , Model model){
        User user = userService.findUserById(id);
        System.out.println("userinfo :    " + user);
        model.addAttribute("user" , user);
        return "user-detail";

    }







}
