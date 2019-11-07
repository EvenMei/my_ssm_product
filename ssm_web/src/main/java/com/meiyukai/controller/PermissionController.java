package com.meiyukai.controller;

import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.service.IPermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller()
@RequestMapping("/permission")
public class PermissionController {

    @Resource(name="permissionService")
    private IPermissionService permissionService;


    @RequestMapping(value = "/findAll.do")
    public String findAll(Model model){
        List<Permission> permissions =  permissionService.findAll();
        model.addAttribute("permissions"  , permissions) ;

        return "permission-list";
    }


    @RequestMapping(value = "/save.do")
    public String savePermission(Permission permission){
        System.out.println("permission :  " + permission);
        permission.setId(UUID.randomUUID().toString().replace("-",""));
        permissionService.savePermission(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping(value = "/deletePermission.do" , produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deletePermission(@RequestBody List<String> selectList){
        String message = "";
        System.out.println("selectList :  " + selectList);
        try{

            for(String permissionId :  selectList) {
                permissionService.deletePermission(permissionId);
                message = "删除成功！";
            }

        }catch(Exception e){
            message = "删除失败 ！";
        }

      return message;
    }

}
