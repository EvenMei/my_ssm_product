package com.meiyukai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meiyukai.ssm.domain.QueryVo;
import com.meiyukai.ssm.domain.Role;
import com.meiyukai.ssm.domain.UserInfo;
import com.meiyukai.ssm.service.IRoleService;
import com.meiyukai.ssm.service.IUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/userInfo")

public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @Resource(name = "roleService")
    private IRoleService roleService;



    /**
     *  保存用户信息
     */
    @RequestMapping(value = "/save.do")
    @PreAuthorize(value = "authentication.principal.username=='meiyukai'")
    public String saveUserInfo( UserInfo userInfo){
//        System.out.println("保存用户信息 ：   " + userInfo);
        userInfo.setId(UUID.randomUUID().toString().replace("-",""));
        userService.saveUserInfo(userInfo);
        return "forward:findAll.do";
    }

    /**
     * 查询所有的用户信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/findAll.do")
    @PreAuthorize(value ="hasRole('ROLE_ADMIN')")
    public String  findAllUserInfo(ModelMap model){
        List<UserInfo> userInfos =  userService.findAll();
//        System.out.println("查找到的所有的 UserInfo    :   "  + userInfos);
        model.addAttribute("userInfos"  , userInfos);
        return "userInfo-list";
    }

    //@RequestMapping(value = "/findAll.do")
    //@PreAuthorize(value ="hasRole('ROLE_ADMIN')")
    /*public ModelAndView findAllUserInf(){
        ModelAndView mav = new ModelAndView();
        List<UserInfo> userInfos =  userService.findAll();
        mav.addObject("userInfos" , userInfos);
        mav.setViewName("userInfo-list");
        return mav;
    }*/


    /**
     * 根据指定的id 查询user
     */
    @RequestMapping(value = "/findById.do")
    public String findById(String id , ModelMap model){
        UserInfo userInfo = userService.findUserById(id);
//        System.out.println("userinfo :    " + userInfo);
        model.addAttribute("userInfo" , userInfo);
        return "userInfo-detail";

    }

    /**
     * 查出用户的id  以及 用户可以添加的 角色信息
     */

    @RequestMapping(value = "/findUserByIdAndAllRoles.do")
    public String findUserByIdAndAllRoles(@RequestParam(value = "id") String userId , ModelMap model){
        //根据 userId 查询用户
        UserInfo userInfo  = userService.findUserById(userId);
//        System.out.println("查询的用户信息是 ：  " + userInfo);
        //根据 userId 查询可以使用的 role信息
        List<Role> roles = roleService.findAvailableRolesForUser(userId);
//        System.out.println("可用的 role 信息是 ：  "+  roles);

        model.addAttribute("userInfo", userInfo);
        model.addAttribute("availableRoles"  , roles);
        return "user-addRoles" ;
    }

    /**
     * 为用户添加新的角色
     */

    @RequestMapping(value="/addNewRoles.do", produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String addNewRoles(@RequestBody String params){
        String message = "feedback";
        if(params!=null){
            JSONObject jsonData = JSON.parseObject(params);
            String userId = (String) jsonData.get("userId");
            List<String>roleIds  = (List<String>) jsonData.get("selectList");
            /*System.out.println("userId :    "+ userId);
            System.out.println("roleId    :   " + roleIds.get(0)  );*/
            try{
                for(String roleId : roleIds){
                    QueryVo vo = new QueryVo(userId,roleId);
                    roleService.userAddNewRoles(vo);
                }
                message="添加成功！";
            }catch(Exception e){
                e.printStackTrace();
                message = "添加失败！";
            }

        }else{
            message = "添加失败！";
        }


        return message;
    }









}
