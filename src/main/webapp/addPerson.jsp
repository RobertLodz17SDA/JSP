<
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Person</title>
</head>
<body>
<h1>${requestScope.logInfo} </h1>
<h1>Add Person</h1>
<jsp:include page="menu.jsp"/>

<form method="POST" action="/addPerson">
    <table>
        <tr>
            <td>Person name:</td>
            <td><input type="text" size="50" name="name"/></td>
        </tr>
        <tr>
            <td>Person surname:</td>
            <td><input type="text" size="50" name="surname"/></td>
        </tr>
        <tr>
            <td>Person Born :</td>
            <td><input type="number" size="4" name="bornYear"/></td>
        </tr>
        <tr>
            <td>Phone :</td>
            <td><input type="number" size="10" name="phone"/></td>
        </tr>
        <tr>
            <td>Sex:</td>
            <td>
                <select name="sex">
                    <option value="MALE">Male</option>
                    <option value="FEMALE">Female</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Enter person</td>
            <td><input type="submit" value="Submit" name="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>