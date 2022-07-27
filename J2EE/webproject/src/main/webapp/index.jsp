<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<%="Welcome to "%>
<br>
5 + 5 = <%=5 + 5%>
<br>
<% int a = 1;
    int b = 2;
    out.println("the number : " + a * b);
%>
<br>

<form action="user.jsp">
<%--<form action="index.jsp">--%>

    <a>Username </a> <input type="text" name="username">
    <br>
    <a>Pass </a> <input type="text" name="password">
    <br>
    <select name="country">
        <option>Ha Noi</option>
        <option>Hai Duong</option>
    </select>
    <br>

    <input type="radio" name="gender" value="Male"> Male
    <input type="radio" name="gender" value="FeMale"> FeMale
    <input type="radio" name="gender" value="Other"> Other

    <br>
    <input type="checkbox" name="favorite" value="java"> Java
    <input type="checkbox" name="favorite" value="C"> C
    <input type="checkbox" name="favorite" value="PHP"> PHP

    <br>
    <input type="submit" value="login">
    <br>
</form>




</body>
</html>