package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IUserDao;
import com.meiyukai.ssm.domain.User;
import com.meiyukai.ssm.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "userService")
public class UserService implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    //加密工具类
//    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUserInfo(User user) {
        //对密码进行加密 (或者使用 自定义的加密工具实现 )
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDao.saveUserInfo(user);
    }

    @Override
    public User findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> findUserByRoleId(String roleId) {
        return userDao.findUserByRoleId(roleId);
    }


}
