package com.meiyukai.ssm.domain;

import java.io.Serializable;

/**
 * QueryVo 封装 userId 和 roleId 的信息
 */
public class QueryVo implements Serializable {
    private String userId; // 用户的id
    private String roleId; // 角色Id

    public QueryVo(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public QueryVo() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
