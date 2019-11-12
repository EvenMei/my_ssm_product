package com.meiyukai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.domain.Role;
import com.meiyukai.ssm.service.IPermissionService;
import com.meiyukai.ssm.service.impl.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @Resource(name = "permissionService")
    private IPermissionService permissionService;

    @RequestMapping(value = "/findAll.do")
    public String findAllRoles(ModelMap model){
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

    /**
     * 根据 roleId 查询 role
     */
    @RequestMapping(value = "/findById.do")
    public String findRoleById(String id , ModelMap model){
        Role role = roleService.findRoleById(id);
        System.out.println("get ---  role :  " + role);
        model.addAttribute("role" , role);
        return "role-detail";
    }

    /**
     * 根据 传入的roleId 添加可以添加的权限信息
     */
    @RequestMapping(value = "/findPermissionAndRoles.do")
    public String findRoleIdAndAvailableRoles(String id , ModelMap model){
        Role role = roleService.findRoleById(id);
       List<Permission> permissions = roleService.findAvailablePermissions(id);
       model.addAttribute("role" , role);
       model.addAttribute("availablePermissions", permissions);
        return "role-addPermissions";
    }

    @RequestMapping(value = "/addNewPermissions.do",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String savePermissions(@RequestBody String params){
        String message = "";
        System.out.println("params:  "  + params);
        if(params!=null){
            JSONObject jsonData = JSON.parseObject(params);
            String roleId = (String) jsonData.get("roleId");
            List<String> permissionIds = (List<String>) jsonData.get("selectList");
            try{
                for(String permissionId : permissionIds){
                    System.out.println("permissionIds :   "+permissionId);
                    permissionService.addNewPermissions(permissionId,roleId);
                    message = "保存成功！";
                }
            }catch(Exception e){
                e.printStackTrace();
                message="保存失败！";
            }

        }else{
            message = "保存失败！";
        }



        return message;
    }






}
