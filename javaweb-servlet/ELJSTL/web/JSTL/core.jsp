<%@ page import="com.testcy.bean.Person" %>
<%@ page import="com.testcy.bean.Student" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL表达式</title>
</head>
<body>
<%--替换jsp的代码脚本--%>
保存之前：${pageScope.key}<br>
<%--c:set 设置域对象中的值--%>
<c:set scope="page" var="key" value="value"></c:set>
保存之后：${pageScope.key}<br>

<hr>
<%--c:if 条件判断语句，但不支持多种条件--%>
<c:if test="${12==12}">
    <h3>12==12</h3>
</c:if>
<c:if test="${12!=12}">
    <h3>12!=12</h3>
</c:if>
<hr>
<%--c:choose 多条件判断--%>
<%
    request.setAttribute("height", 145);
%>
<c:choose>
    <c:when test="${requestScope.height>190}">
        <h3>身高大于于190</h3>
    </c:when>
    <c:when test="${requestScope.height>180}">
        <h3>身高大于180</h3>
    </c:when>
    <c:when test="${requestScope.height>170}">
        <h3>身高大于170</h3>
    </c:when>
    <c:when test="${requestScope.height>170}">
        <h3>身高小于170</h3>

    </c:when>
    <c:otherwise>
        <%--            c:when父标签一定要是c:choose--%>
        <%--            <h3>身高小于170</h3>--%>
        <c:choose>


            <c:when test="${requestScope.height gt 160}">
                <h3>身高大于160</h3>
            </c:when>
            <c:when test="${requestScope.height gt 150}">
                <h3>身高大于150</h3>
            </c:when>
            <c:when test="${requestScope.height gt 140}">
                <h3>身高大于140</h3>
            </c:when>
        </c:choose>

    </c:otherwise>
</c:choose>

<%--for循环遍历--%>
<table border="1">
    <c:forEach begin="0" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>
</table>
<hr>
<%--遍历数组--%>
<%
    request.setAttribute("array", new String[]{"12345666543", "1235345654", "15821321312"});
%>
<c:forEach items="${requestScope.array}" var="arr">
    ${arr}<br>
</c:forEach>

<%--遍历map--%>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
//    Set<Map.Entry<String, String>> entries = map.entrySet();
//    Iterator<Map.Entry<String, String>> iterator = entries.iterator();
//    while (iterator.hasNext()) {
//        System.out.println(iterator.next().getKey());
//    }
    request.setAttribute("map", map);
%>
<hr>
<c:forEach items="${requestScope.map}" var="entry">
    <h3>${entry}</h3>
    <h3>${entry.key}</h3>
    <h3>${entry.value}</h3>
</c:forEach>

<%--遍历list集合，list中有一个Person对象--%>
<%
    ArrayList<Student> students = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        Student student = new Student(i+1, "name" + i, "passsword" + i, 1 + i, "1581111111" + i);
        students.add(student);
    }
    request.setAttribute("stuList", students);
%>
<hr>
<table width="500" border="1" style="border: lightblue solid 1px">
    <tr style="border: 1px red solid">
        <th style="border: 1px red solid">id</th>
        <th style="border: 1px red solid">姓名</th>
        <th style="border: 1px red solid">密码</th>
        <th style="border: 1px red solid">年龄</th>
        <th style="border: 1px red solid">电话</th>
        <th style="border: 1px red solid">操作</th>
    </tr>
    <c:forEach begin="2" end="8" step="2" varStatus="status"  items="${stuList}" var="stu">

        <tr style="border: 1px red solid">
            <td style="border: 1px red solid">${stu.id}</td>
            <td style="border: 1px red solid">${stu.name}</td>
            <td style="border: 1px red solid">${stu.password}</td>
            <td style="border: 1px red solid">${stu.age}</td>
            <td style="border: 1px red solid">${stu.phone}</td>
            <td style="border: 1px red solid">${status.count}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
