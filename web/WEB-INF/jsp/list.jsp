<%@ page import="com.chenyx.entity.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/5
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <%
        List<Book> list = (List<Book>)request.getAttribute("list");
        for (Book book:list){
            out.println(book);
        }
    %>
</body>
</html>
