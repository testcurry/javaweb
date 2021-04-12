package com.testcy.service.impl;

import com.testcy.dao.UserDao;
import com.testcy.dao.impl.UserDaoImpl;
import com.testcy.pojo.User;
import com.testcy.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUser(String username) {
        User user = userDao.queryUserByUsername(username);
        if (user==null){
            return false;
        }
        return true;
    }
}
