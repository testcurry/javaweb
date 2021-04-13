package com.testcy.service;

import com.testcy.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return true表示用户名已存在，false表示用户名可用
     */
    public boolean existsUser(String username);
}
