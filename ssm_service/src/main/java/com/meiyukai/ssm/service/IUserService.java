package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.User;

import java.util.List;

public interface IUserService {
    /**
     * 查询所有的 User
     * @return
     */
    List<User> findAll();



    /**
     * 保存用户信息
     */
    void saveUserInfo(User user);


    /**
     * 根据指定user表中的id 查询 user
     */
    User findUserById(String userId);

    /**
     * 根据 roleId 查询uses
     */
    List<User> findUserByRoleId(String roleId);



}
