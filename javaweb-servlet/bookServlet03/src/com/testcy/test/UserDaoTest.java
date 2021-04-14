package com.testcy.test;

import com.testcy.dao.UserDao;
import com.testcy.dao.impl.UserDaoImpl;
import com.testcy.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    private UserDao userdao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userdao.queryUserByUsername("Curry")==null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User curry = userdao.queryUserByUsernameAndPassword("admin", "123456");
        if (curry==null){
            System.out.println("用户名或者密码错误！");
        }else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        int admin = userdao.saveUser(new User(null, "manager", "123456", "testcy@vip.com"));
        System.out.println("插入记录成功：" + admin);
    }
}