package com.testcy.utils;

import com.testcy.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamsToBean(Map map, T bean) {
        //使用beanUtils类注入Javabean

//        System.out.println("注入之前：" + bean);
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
