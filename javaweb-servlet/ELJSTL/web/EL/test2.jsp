<%@ page import="com.testcy.bean.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Curry
  Date: 2021/4/13
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出复杂bean对象</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("Curry");
        person.setPhones(new String[]{"15811111111","15811112222","15811113333"});
        ArrayList<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("深圳");
        person.setList(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("p",person);
    %>
    输出person对象：${p}<br>
    //调用了getName()方法,如果没有getName()方法就会报错
    输出p对象name的值：${p.name}<br>
    输出p对象的phone数组：${p.phones}<br>
    输出list集合：${p.list}<br>
    输出map：${p.map}<br>
    输出数组的某一个下标的元素：${p.phones[0]}<br>
    输出list集合某一个下标的元素：${p.list[0]}<br>
    输出map集合对应key的值：${p.map.key2}<br>
</body>
</html>
