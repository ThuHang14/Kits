<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUS PC
  Date: 7/27/2022
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Form JSP</title>
</head>
<style>
  table, th, td {
    border:1px solid black;
  }
</style>
<body>

<h2>them moi hoc vien </h2>
<form action="formCheck.jsp">


  <table style="width:100%">
    <tr>
      <td>Ma hoc vien</td>
      <td>
        <%
          String id = request.getParameter("id");
          out.println(id);
        %>
      </td>

    </tr>
    <tr>
      <td>ho ten </td>
      <td>
        <%
          String name = request.getParameter("name");
          out.println(name);
        %>
      </td>

    </tr>
    <tr>
      <td>Lop </td>
      <td>
        <%
          String classa = request.getParameter("class");
          out.println(classa);
        %>
      </td>
    </tr>
    <tr>
      <td>gioi tinh </td>
      <td>
        <%
          String gender = request.getParameter("gender");
          out.println(gender);
        %>
      </td>
    </tr>

    <tr>
      <td>Mon Hoc </td>
      <td>
        <%
          String[] favorite = request.getParameterValues("favorite");
          out.println(Arrays.toString(favorite));
        %>
      </td>
    </tr>

  </table>
  <br>
  <input type="submit" value="Save">
  <br>
</form>


</body>
</html>
