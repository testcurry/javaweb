<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">

        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find(":first").text() + "】吗？");
            });

            $("#clearCart").click(function () {
                return confirm("你确定要清空购物车吗？")
            });

            $("input.updateCount").change(function () {
                var name = $(this).parent().parent().find(":first").text();
                var count = this.value;
                var bookId = $(this).attr("bookId");
                if (confirm("您确定修改商品【" + name + "】的数量为" + count + "吗？")){
                    location.href="${basePath}cartServlet?action=updateItemCount&count="+count+"&id="+bookId;
                }else {
                    this.value=this.defaultValue;
                };

            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">亲，您当前购物车为空，快去浏览自己喜欢的商品吧！</a></td>
            </tr>
        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.value.name}</td>
                    <td>
                        <input class="updateCount" type="text" style="width: 30px"
                               bookId="${item.value.id}" value="${item.value.count}">
                    </td>
                    <td>${item.value.price}</td>
                    <td>${item.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span
                    class="b_count">${empty sessionScope.cart.totalCount?0:sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span
                    class="b_price">${empty sessionScope.cart.totalPrice?0:sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>