package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IUserDao;
import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.domain.Role;
import com.meiyukai.ssm.domain.UserInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service(value = "securityService")
public class SecurityService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    public boolean accessible(UsernamePasswordAuthenticationToken authentication , HttpServletRequest request){
        List<String> urls = new ArrayList<String >();
        String uri = request.getRequestURI();       // 例如, localhost:8085/findAll.do
        String path=request.getContextPath();   //lcoalhost:8085
        String url =request.getRequestURL().toString(); //http:lcoalhost:8085/findAll.do
//        System.out.println("-------path :  -----" +   path  +"  " + "url   : "  + url  );
        uri = uri.replace(path,"");
        System.out.println("uri :  "+ uri);
        //因为认证的时候已经将 authentication 替换为自己的userInfo 因此可以强转为 userInfo
        try{
            Object obj = authentication.getPrincipal();
            if(obj instanceof User){
                 User user  = (User) obj;
                 String username = user.getUsername();
                UserInfo  userInfo = userDao.findUserByUserName(username);
                List<Role> roles  = userInfo.getRoles();
                for(Role role:roles){
                    List<Permission> permissions = role.getPermissions();
                    for(Permission permission:permissions ){
                        urls.add(permission.getUrl());
                    }
               }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return urls.contains(uri);
    }


}
