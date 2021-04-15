<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/16
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--公共分页条--%>
<div id="page_nav">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <c:if test="${requestScope.page.pageNo gt 1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <%--        页码输出的开始--%>
    <%--        需求：要显示5个连续的页码，当前页码在中间，每个页码都可以点击，并且页码可以跳转--%>

    <%--            情况一：总页码小于等于5，页码的范围是 1--总页码  --%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5 }">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>

        <%--                情况2总页码大于5，--%>

        <c:when test="${requestScope.page.pageTotal > 5}">
            <%--                假设总页码为10页     当前页码为前三个1,2,3,页码范围为1-5 --%>
            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>

                <%--     假设总页码为10页     当前页码为后面三个8,9,10,页码范围为【总页码-4】--总页码              --%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>

                <%--     假设总页码为10页     当前页码为中间4个4-7的情况,页码范围为【当前页码-2】--【当前页码+2】              --%>

                <c:when test="${requestScope.page.pageNo>3 && requestScope.page.pageNo<=requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
                    <%--<c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${requestScope.page.pageNo == i}">
                            【${i}】
                        </c:if>
                        <c:if test="${requestScope.page.pageNo != i}">
                            <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>--%>
                </c:when>

            </c:choose>

        </c:when>
    </c:choose>

    <%--            优化：将遍历的语句抽取出来，每次判断只记录begin和end的值即可--%>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${requestScope.page.pageNo == i}">
            【${i}】
        </c:if>
        <c:if test="${requestScope.page.pageNo != i}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <%--        页码输出的结束--%>

    <%--  <a href="#">3</a>
    【${requestScope.page.pageNo}】
    <a href="#">5</a>--%>

    <c:if test="${requestScope.page.pageNo lt requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录

    <%-- <c:if test="${param.pageNo > requestScope.page.pageTotal}">
         到第<input value="${requestScope.page.pageTotal}" name="pn" id="pn_input"/>页
     </c:if>
     <c:if test="${param.pageNo<1}">
         到第<input value="1" name="pn" id="pn_input"/>页
     </c:if>--%>

    <%--        到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页--%>
    <c:choose>
        <c:when test="${empty param.pageNo}">
            到第<input value="" name="pn"
            id="pn_input"/>页
        </c:when>
        <c:when test="${param.pageNo > requestScope.page.pageTotal}">
            到第<input value="${requestScope.page.pageTotal}" name="pn" id="pn_input"/>页
        </c:when>
        <c:when test="${param.pageNo<1}">
            到第<input value="1" name="pn" id="pn_input"/>页
        </c:when>
        <%--   <c:when test="${param.pageNo ge 1 && param.pageNo le requestScope.page.pageTotal}">
               到第<input value="${param.pageNo}" name="pn"
               id="pn_input"/>页
           </c:when>--%>
        <c:otherwise>
            到第<input value="${param.pageNo}" name="pn"
            id="pn_input"/>页
        </c:otherwise>
    </c:choose>
    <input id="targetPageBtn" type="button" value="确定">

</div>
