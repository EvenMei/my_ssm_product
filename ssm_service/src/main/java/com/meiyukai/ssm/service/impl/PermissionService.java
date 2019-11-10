package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IPermissionDao;
import com.meiyukai.ssm.domain.Permission;
import com.meiyukai.ssm.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "permissionService")
public class PermissionService implements IPermissionService {
    @Resource(name = "permissionDao")
    private IPermissionDao permissionDao;


    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findPermissionByRoleId(String roleId) {
        return permissionDao.findPermissionByRoleId(roleId);
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    @Override
    public void deletePermission(String permissionId) {
        permissionDao.deletePermission(permissionId);
    }

    @Override
    public void addNewPermissions(String permissionId, String roleId) {
        permissionDao.addNewPermissions(permissionId,roleId);
    }
}
