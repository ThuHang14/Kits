<%--
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
<form action="formSave.jsp">


<table style="width:100%">
    <tr>
        <td>Ma hoc vien</td>
        <td >
            <input name="id" value="HV01">
        </td>

    </tr>
    <tr>
        <td>ho ten </td>
        <td >
            <input name="name" value="Nguyen Thanh Tam">
        </td>

    </tr>
    <tr>
        <td>Lop </td>
        <td>
            <select name="class">
            <option selected>14TH1</option>
            <option>15TH1</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>gioi tinh </td>
        <td>
            <input type="radio" name="gender" value="Male" checked> Male
            <input type="radio" name="gender" value="FeMale"> FeMale
            <input type="radio" name="gender" value="Other"> Other
        </td>
    </tr>

    <tr>
        <td>Mon Hoc </td>
        <td>
            <input type="checkbox" name="favorite" value="java"> Java
            <input type="checkbox" name="favorite" value="C" checked> C
            <input type="checkbox" name="favorite" value="PHP" checked> PHP
        </td>
    </tr>

</table>
    <br>
    <input type="submit" value="Check">
    <br>
</form>


</body>
</html>
