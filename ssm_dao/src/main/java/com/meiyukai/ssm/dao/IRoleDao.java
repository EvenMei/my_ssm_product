package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.domain.QueryVo;
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
            @Result(property = "userInfos" , column = "id" , many = @Many(select = "com.meiyukai.ssm.dao.IUserDao.findUserByRoleId" , fetchType = FetchType.LAZY))
    })
    @Select(value = "select * from role where id in(select  roleId from users_role where userId  = #{userId})")
    List<Role> findRoleByUserId(String userId);


    /**
     * 根据 id 查询 role
     */
    @Select(value="select * from role where id = #{roleId}")
    @ResultMap(value="role_map")
    Role findRoleById( String roleId);

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

    /**
     * 根据useId 查询 user 可用的Roles
     */
    @Select(value = "select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findAvailableRolesForUser(String userId);


    /**
     * 根据 userId 和 roleId 为用户增加一个新的角色
     * mybatis 有两种方式可以实现这种功能！
     */
    @Insert(value = "insert into users_role values(#{userId},#{roleId});")
//    void userAddNewRoles(@Param(value="userId") String userId  , @Param(value = "roleId") String roleId);
    void userAddNewRoles(QueryVo vo);

    /**
     * 根据 roleId 查询可以选择的权限信息
     * @param roleId
     * @return
     */
    @Select(value = "select * from permission where id not in(select permissionId from permission_role where roleId = #{roleId} )")
    List<Permission> findAvailablePermissions(String roleId);


}
