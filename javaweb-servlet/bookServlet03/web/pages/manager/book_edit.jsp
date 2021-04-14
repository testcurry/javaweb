<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑图书</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>
<%--${empty requestScope.bookEdit ? "add":"update"}--%>
<div id="main">
    <form action="manager/bookServlet" method="post">
        <%--				方案一：添加method参数
                        <input type="hidden" name="action" value="${param.method}">--%>
        <%--				方案二判断id参数的值是否为空，不为空则为update操作--%>
<%--        <input type="hidden" name="action" value="${empty param.id ? "add":"update"}">--%>
<%--            通过request域中有没有book对象判断。如果bookEdit不为空，则为update操作--%>
        <input type="hidden" name="action" value="${empty requestScope.bookEdit ? "add":"update"}">
        <input type="hidden" name="id" value="${requestScope.bookEdit.id}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.bookEdit.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.bookEdit.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.bookEdit.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.bookEdit.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.bookEdit.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>