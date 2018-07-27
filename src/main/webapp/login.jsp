<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Person</title>
</head>
<body>
<h1>Add Person</h1>
<jsp:include page="menu.jsp"/>

<form method="POST" action="/login">
    <table>
        <tr>
            <td>Podaj nazwę użytkownika :</td>
            <td><input type="text" size="50" name="name"/></td>
        </tr>
        <tr>
            <td>Hasło :</td>
            <td><input type="password" size="30" name="password"/></td>
        </tr>
        <tr>
            <td>Enter person</td>
            <td><input type="submit" value="Zaloguj" name="Zaloguj"/></td>
        </tr>
    </table>
</form>
</body>
</html>