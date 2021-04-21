<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script type="text/javascript">
        $(function () {

            //使用Ajax请求验证用户名是否可用
            $("#username").blur(function () {
                var username = this.value;
                $.getJSON("${basePath}userServlet","action=ajaxExistUsername&username="+username,function (data) {
                    if (data.existsUser){
                        $("span.errorMsg").text("用户名不可用！");
                    }else {
                        $("span.errorMsg").text("用户名可用！");
                    }
                });
            });

            //给验证码图片绑定单击事件
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d="+new Date();
            });

            //给注册按钮绑定单击事件
            $("#sub_btn").click(function () {

                //1、检查用户名是否合法
                var username = $("#username").val();
                var userpatt = /^\w{5,12}$/;
                if (!userpatt.test(username)) {
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }
                //2、检查密码是否合法
                var password = $("#password").val();
                var pwdpatt = /^\w{5,12}$/;
                if (!pwdpatt.test(password)) {
                    $("span.errorMsg").text("密码不合法！");
                    return false;
                }
                //3、检查密码与确认密码是否一致
                var repwd = $("#repwd").val();
                if (repwd != password) {
                    $("span.errorMsg").text("两次输入的密码不一致！");
                    return false;
                }
                //4、检查邮箱是否合法
                var email = $("#email").val();
                var emailpatt = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if (!emailpatt.test(email)) {
                    $("span.errorMsg").text("邮箱不合法！");
                    return false;
                }
                //5、检查验证码是否为空
                var code = $("#code").val();
                if ($.trim(code) == "") {
                    $("span.errorMsg").text("验证码错误！");
                    return false;
                }

                $("span.errorMsg").text("");
            });
        })
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                        <%--                        value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
                        <%--                               value="${empty requestScope.username ? '' : requestScope.username}"--%>
                               value="${requestScope.username}" "/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                        <%--                               value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
                        <%--                                value="${empty requestScope.email ?'':requestScope.email}--%>
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
                        <img alt="" id="code_img" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px;width:110px;height:30px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--<div id="bottom">--%>
<%--			<span>--%>
<%--				尚硅谷书城.Copyright &copy;2015--%>
<%--			</span>--%>
<%--</div>--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>