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

<form method="POST" action="/instagram">
    <table>
        <tr>
            <td>Name of Instagram User:</td>
            <td><input type="text" size="50" name="instUserName"/></td>
        </tr>
        <tr>
            <td>Number of returned images:</td>
            <td><input type="text" size="50" name="noOfImages"/></td>
        </tr>
        <tr>
            <td>SEND MESSAGE!</td>
            <td><input type="submit" value="Submit" name="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>