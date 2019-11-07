package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 根据roleId 查询所有的 Permission
     */
    List<Permission> findPermissionByRoleId(String roleId);

    /**
     * 保存 permission
     */
    void savePermission(Permission permission);

    /**
     * 根据ID 删除 permission
     */
    void deletePermission(String permissionId);

}
