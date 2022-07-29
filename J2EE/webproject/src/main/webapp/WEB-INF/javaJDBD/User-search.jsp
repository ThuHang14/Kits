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

<%--============ SEACH ==============--%>
<form action="User-search.jsp">
    <div class="input-group mb-3  container">
        <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username"
               aria-describedby="basic-addon2" id="search-input" name="name">
        <span class="input-group-text" id="basic-addon2"><button class="btn" type="submit">Search</button></span>
    </div>
</form>
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
        String name = request.getParameter("name");
        if (name != null) {
            for (User u : ud.findUserByName(name)
            ) {
    %>
    <tr>
        <th><%=u.getId()%>
        </th>
        <td><%=u.getName()%>
        </td>
        <td><%=u.getEmail()%>
        </td>
        <td><%=u.getCountry()%>
        </td>
    </tr>
    <%
            }
        } else {
            out.println("Khong Tim Thay Ket Qua Phu Hop");
        }
    %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
