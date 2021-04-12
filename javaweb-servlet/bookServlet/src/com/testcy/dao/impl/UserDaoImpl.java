package com.testcy.dao.impl;

import com.testcy.dao.UserDao;
import com.testcy.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username`= ?";
        User user = queryForOne(User.class, sql, username);
        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username`= ? and `password`= ?";
        User user = queryForOne(User.class, sql, username, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user (`username`,`password`,`email`) values(?,?,?)";
        int count = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return count;
    }
}
