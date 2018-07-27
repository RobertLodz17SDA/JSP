<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Contact</title>
</head>
<body>
<h1>Contact</h1>
<jsp:include page="menu.jsp"/>

<form method="POST" action="/contact">
    <table>
        <tr>
            <td>Your name:</td>
            <td><input type="text" size="50" name="name"/></td>
        </tr>
        <tr>
            <td>Your surname:</td>
            <td><input type="text" size="50" name="surname"/></td>
        </tr>
        <tr>
            <td>Your email:</td>
            <td><input type="email" size="50" name="email"/></td>
        </tr>
        <tr>
            <td>Your message:</td>
            <td><textarea type="text" cols="50" rows="30" size="5000" name="message"></textarea></td>
        </tr>
        <tr>
            <td>SEND MESSAGE!</td>
            <td><input type="submit" value="Submit" name="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>