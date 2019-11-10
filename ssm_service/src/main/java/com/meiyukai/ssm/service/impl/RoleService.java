package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IRoleDao;
import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.domain.QueryVo;
import com.meiyukai.ssm.domain.Role;
import com.meiyukai.ssm.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "roleService")
public class RoleService implements IRoleService {
    @Resource(name = "roleDao")
    private IRoleDao roleDao;


    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }


    @Override
    public List<Role> findRoleByUserId(String userId) {
        return roleDao.findRoleByUserId(userId);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public void deleteRole(String roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Role> findAvailableRolesForUser(String userId) {
        return roleDao.findAvailableRolesForUser(userId);
    }

    @Override
    public void userAddNewRoles(QueryVo vo) {
        roleDao.userAddNewRoles(vo);
    }

    @Override
    public Role findRoleById(String roleId) {
        return roleDao.findRoleById(roleId);
    }

    @Override
    public List<Permission> findAvailablePermissions(String roleId) {
        return roleDao.findAvailablePermissions(roleId);
    }


}
