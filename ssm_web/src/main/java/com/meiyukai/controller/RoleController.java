package com.meiyukai.controller;

import com.meiyukai.ssm.domain.Role;
import com.meiyukai.ssm.service.impl.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Resource(name = "roleService")
    private RoleService roleService;

    @RequestMapping(value = "/findAll.do")
    public String findAll(Model model){
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles"  ,  roles) ;
        return "role-list";
    }


    @RequestMapping(value = "/save.do")
    public String saveRole(Role role){
        role.setId(UUID.randomUUID().toString().replace("-",""));
        roleService.saveRole(role);
        return "forward:findAll.do";
    }

    @RequestMapping(value = "/deleteRole.do" , produces = ("text/html;charset=utf-8"))
    @ResponseBody
    public String  deleteRole(@RequestBody  List<String> list ){

         String message = "";
         System.out.println("selectList :     " + list );
         try {
             for(String roleId : list ){
                 roleService.deleteRole(roleId);  // 删除之前需要删除 与之关联的其他表的字段内容
             }
             message = "删除成功！" ;
         }catch(Exception e){
             message="删除失败！" ;
         }

        return message;

    }




}
