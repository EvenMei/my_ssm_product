package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 查询所有的 role
     */
    List<Role> findAll();

    /**
     * 根据userId 查询所有的 role
     */
    List<Role> findRoleByUserId(String userId);


    /**
     *保存 role
     */
    void saveRole(Role role);

    /**
     * 根据 roleId 删除 role
     */
    void deleteRole(String roleId);




}
