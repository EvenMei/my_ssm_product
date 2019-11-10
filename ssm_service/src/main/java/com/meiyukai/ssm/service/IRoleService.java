package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.domain.QueryVo;
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

    /**
     * 根据useId 查询 user 可用的Roles
     */
    List<Role> findAvailableRolesForUser(String userId);

    /**
     * 根据 userId 和 roleId 为用户增加一个新的角色
     */
    void userAddNewRoles(QueryVo vo);

    /**
     * 根据 id 查询 role
     */
    Role findRoleById( String roleId);


    /**
     * 根据 roleId 查询可以选择的权限信息
     * @param roleId
     * @return
     */
    List<Permission> findAvailablePermissions(String roleId);




}
