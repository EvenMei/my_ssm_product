package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IUserDao;
import com.meiyukai.ssm.domain.Role;
import com.meiyukai.ssm.domain.UserInfo;
import com.meiyukai.ssm.service.IUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service(value = "userService")
public class UserService implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Resource(name = "roleService")
    private RoleService roleService;

    //加密工具类
    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        //对密码进行加密 (或者使用 自定义的加密工具实现 )
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        System.out.println("即将保存 userInfo ：  " + userInfo);
        userDao.saveUserInfo(userInfo);
    }

    @Override
    public UserInfo findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<UserInfo> findUserByRoleId(String roleId) {
        return userDao.findUserByRoleId(roleId);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findUserByUserName(username );
      //  System.out.println("userinfo :  "   +   userInfo );
      //  System.out.println("statusBool :   " + userInfo.getStatusBool());
        //User user  = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user  = new User(userInfo.getUsername() , userInfo.getPassword(),
                userInfo.getStatusBool(),true,true,true ,
                getAuthority(userInfo.getRoles()));

        return user;
    }


    //返回一个list 集合 ， 集合中装入角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles){
            //System.out.println("roleInfo : "  + role.getRoleName());
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }



}
