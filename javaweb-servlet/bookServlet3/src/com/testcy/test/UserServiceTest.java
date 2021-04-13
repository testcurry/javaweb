package com.testcy.test;

import com.testcy.pojo.User;
import com.testcy.service.UserService;
import com.testcy.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"testcy","123456","testcy@gmail.com"));
    }

    @Test
    public void login() {
        User curry = userService.login(new User(null, "admin", "123456", "test@vip.com"));
        System.out.println(curry);
    }

    @Test
    public void existsUser() {
        boolean flag = userService.existsUser("manager");
        if (flag){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}