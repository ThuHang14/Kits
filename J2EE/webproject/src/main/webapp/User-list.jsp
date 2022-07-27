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
<%--============= HEADER ===============--%>
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="#">Active</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
    </li>
</ul>

<%--============ TABLE ==============--%>


<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Country</th>
    </tr>
    </thead>
    <tbody>
    <%
        UserDao ud = new UserDao();
        for (User u : ud.selectAllUsers()
        ) {
    %>
    <tr>
        <th> <%=u.getId()%> </th>
        <td> <%=u.getName()%></td>
        <td> <%=u.getEmail()%></td>
        <td> <%=u.getCountry()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
