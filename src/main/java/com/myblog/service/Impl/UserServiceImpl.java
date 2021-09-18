package com.myblog.service.Impl;

import com.myblog.dao.UserDao;
import com.myblog.entity.User;
import com.myblog.service.UserService;
import com.myblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Description: 用户业务层接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * @Description:
     * @Param: username:用户名；password:密码
     * @Return: 返回用户对象
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
