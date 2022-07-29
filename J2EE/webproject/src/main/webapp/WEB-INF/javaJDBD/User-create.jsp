<%@ page import="com.example.webproject.dao.UserDao" %>
<%@ page import="com.example.webproject.model.User" %>
<%--
  Java Bean Core
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<%
    UserDao ud = new UserDao();
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("address");

    User user = new User(name,email,country);

    if (ud.insertNewUser(user)) {
        response.sendRedirect("User-list.jsp");
    }
%>
</body>
</html>
