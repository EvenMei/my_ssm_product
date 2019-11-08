package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    /**
     * 查询所有的 UserInfo
     * @return
     */
    List<UserInfo> findAll();



    /**
     * 保存用户信息
     */
    void saveUserInfo(UserInfo userInfo);


    /**
     * 根据指定user表中的id 查询 user
     */
    UserInfo findUserById(String userId);

    /**
     * 根据 roleId 查询uses
     */
    List<UserInfo> findUserByRoleId(String roleId);



}
