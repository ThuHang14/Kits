<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Java JSTL
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
<sql:setDataSource var="dbSv" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:7000/Users" user="root"
                   password="123"/>
<sql:query dataSource="${dbSv}" var="rs">SELECT * FROM users</sql:query>

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
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="table" items="${rs.rows}">
        <tr>
            <th><c:out value="${table.id}"/>
            </th>
            <td><c:out value="${table.name}"/>
            </td>
            <td><c:out value="${table.email}"/>
            </td>
            <td><c:out value="${table.country}"/>
            </td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
