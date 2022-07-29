<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUS PC
  Date: 7/27/2022
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>Welcome to </h1>
<%
    String username = request.getParameter("username");
    String pass = request.getParameter("password");
    String home = request.getParameter("country");
    String gender = request.getParameter("gender");
    String[] favorite = request.getParameterValues("favorite");
    out.println(username);
    out.println(home);
    out.println(gender);
    out.println(Arrays.toString(favorite));

%>

</body>
</html>
