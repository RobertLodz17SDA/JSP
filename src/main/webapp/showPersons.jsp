<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>People list</title>
</head>
<body>
<h1>People list</h1>
<jsp:include page="menu.jsp"/>
<c:set var="peopleListInJSP" value="${requestScope.people.size()}" />
<c:out value="Mamy ${peopleListInJSP} osób w bazie danych"/>
<table border=1>
    <tr>
        <th width="100"><b>Name:</b></th>
        <th width="100"><b>Surname:</b></th>
        <th width="100"><b>Born year:</b></th>
        <th width="100"><b>Phone number:</b></th>
        <th width="100"><b>Sex:</b></th>
    </tr>
    <c:forEach items="${requestScope.peopleList}" var="person">
        <tr>
            <td>${person.getName()}</td>
            <td>${person.getSurname()}</td>
            <td>${person.getBornYear()}</td>
            <td>${person.getPhoneNumber()}</td>
            <td>${person.getSex()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>