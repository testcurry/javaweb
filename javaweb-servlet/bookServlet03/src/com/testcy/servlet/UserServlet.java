package com.testcy.servlet;

import com.google.gson.Gson;
import com.testcy.pojo.User;
import com.testcy.service.UserService;
import com.testcy.service.impl.UserServiceImpl;
import com.testcy.test.UserServletTest;
import com.testcy.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 使用Ajax验证用户名是否可用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUser = userService.existsUser(username);
        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("existsUser",existsUser);
        Gson gson = new Gson();
        String userMapjson = gson.toJson(userMap);
        resp.getWriter().write(userMapjson);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        req.setAttribute("username", username);
        req.setAttribute("email", email);

        //测试getParameterMap()方法
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + Arrays.asList(entry.getValue()));
        }
        //使用beanUtils类注入Javabean
        User user = WebUtils.copyParamsToBean(req.getParameterMap(), new User());
        System.out.println("注入之后：" + user);
        //检查验证码是否正确 先写死abcde检查
        if (token!=null&&token.equalsIgnoreCase(code)) {
            //检查用户名是否可用
            if (userService.existsUser(username)) {
                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在!");
                System.out.println("用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                System.out.println("用户名可用！");
                //调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
                System.out.println("用户" + username + "保存数据库成功！");
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //如果验证码错误，跳回注册页面，请求转发
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误！");
            System.out.println("验证码" + code + ",错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //把回显信息保存到request域中
        req.setAttribute("msg", "用户名或密码错误！");
        req.setAttribute("username", username);
        //根据用户名和密码查询数据库比对
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            System.out.println("用户名或密码错误！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登录成功！");
            req.getSession().setAttribute("loginUser",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 注销方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath());

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*    String action = req.getParameter("action");
        //利用反射技术优化
        Method declaredMethod = null;
        try {
            declaredMethod = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    //方式一：
     /*   if ("regist".equals(action)) {
            regist(req,resp);

        } else if ("login".equals(action)) {
           login(req,resp);
        }*/
//    }
}
