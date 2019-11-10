package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限的持久层
 */
@Repository(value = "permissionDao")
public interface IPermissionDao  {

    /**
     * 查询所有权限
     * @return
     */
    @Select(value = "select * from permission ")
    List<Permission> findAll();

    /**
     * 根据roleId 查询所有的 Permission
     */
    @Select(value = "select * from permission where id in(select permissionId from permission_role where roleId = #{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);

    /**
     * 保存 permission
     */
    @Insert(value = "insert into permission values(#{id}  , #{permissionName} , #{url})")
    void savePermission(Permission permission);

    /**
     * 根据ID 删除 permission
     */
    @Delete(value = "delete from permission where id = #{permissionId}")
    void deletePermission(String permissionId);

    /**
     * 根据permissionId 和 roleId 关联permission 和role
     */
    @Insert(value = "insert into permission_role values(#{permissionId} , #{roleId})")
    void addNewPermissions(@Param(value = "permissionId")String permissionId,  @Param(value="roleId") String roleId);



}
