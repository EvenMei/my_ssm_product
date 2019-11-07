package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色持久层
 */
@Repository(value = "roleDao")
public interface IRoleDao {

    /**
     * 查询所有的 role
     */
    @Select(value = "select * from role")
    List<Role> findAll();

    /**
     * 根据userId 查询所有的 role
     */
    @Results(id = "role_map"  , value = {
            @Result(id = true  , property = "id" , column = "id"),
            @Result(property = "roleName" , column = "roleName"),
            @Result(property = "roleDesc" , column = "roleDesc"),
            @Result(property = "permissions" , column = "id" , many = @Many(select = "com.meiyukai.ssm.dao.IPermissionDao.findPermissionByRoleId" , fetchType = FetchType.LAZY)),
            @Result(property = "users" , column = "id" , many = @Many(select = "com.meiyukai.ssm.dao.IUserDao.findUserByRoleId" , fetchType = FetchType.LAZY))
    })
    @Select(value = "select * from role where id in(select  roleId from users_role where userId  = #{userId})")
    List<Role> findRoleByUserId(String userId);

    /**
     *保存 role
     */
    @Insert(value = "insert into role values(#{id} ,  #{roleName} , #{roleDesc} )")
    void saveRole(Role role);

    /**
     * 根据 roleId 删除 role
     */
    @Delete(value = "delete from role where id = #{roleId}")
     void deleteRole(String roleId);

}
