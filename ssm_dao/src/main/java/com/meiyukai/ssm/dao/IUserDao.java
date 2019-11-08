package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实现User的持久层
 */
@Repository(value = "userDao")
public interface IUserDao {

    /**
     * 查询所有的 UserInfo
     * @return
     */
    @ResultMap(value = {"user_map"})
    @Select(value = "select * from users ")
    List<UserInfo> findAll();

    /**
     * 保存用户信息
     */
    @Insert(value = "insert into users values(#{id}, #{username} , #{password},#{email} ,#{phoneNum},#{status}   )")
    void saveUserInfo(UserInfo userInfo);

    /**
     * 根据指定user表中的id 查询 user
     */
    @Results(id = "user_map" , value = {
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "email" , column = "email"),
            @Result(property = "username" , column ="username" ),
            @Result(property = "password" , column = "password"),
            @Result(property = "phoneNum"  , column = "phoneNum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roles" , column = "id" , many = @Many(select = "com.meiyukai.ssm.dao.IRoleDao.findRoleByUserId" , fetchType = FetchType.LAZY))
    })
    @Select(value = "select * from users where id =  #{id}")
    UserInfo findUserById(String userId);

    /**
     * 根据 roleId 查询uses
     */
    @ResultMap(value = {"user_map"})
    @Select(  value = "select * from users where id in (select userId from users_role where roleId = #{roleId})" )
    List<UserInfo> findUserByRoleId(String roleId);

    /**
     * 根据 username 查询 user
     */
    @Select(value = "select * from users where username = #{username}")
    UserInfo findUserByUserName(String username);


}
