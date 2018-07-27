<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>About</title>
</head>
<body>
<h1>About</h1>
<jsp:include page="menu.jsp"/>
<c:set var="peopleListInJSP" value="${requestScope.people.size()}" />
<c:out value="Mamy ${peopleListInJSP} osób"/>
<table border=1>
    <tr>
        <th width="100"><b>Name:</b></th>
        <th width="100"><b>Surname:</b></th>
        <th width="100"><b>Born year:</b></th>
        <th width="100"><b>Phone number:</b></th>
        <th width="100"><b>Sex:</b></th>
    </tr>
    <c:forEach items="${requestScope.people}" var="person">
        <tr>
            <td>${person.getName()}</td>
            <td>${person.getSurname()}</td>
            <td>${person.getBornYear()}</td>
            <td>${person.getPhoneNumber()}</td>
            <td>${person.getSex()}</td>
        </tr>
    </c:forEach>
</table>

<br>

<table border=1>
    <tr>
        <th width="100"><b>Name:</b></th>
        <th width="100"><b>Surname:</b></th>
        <th width="100"><b>Born year:</b></th>
        <th width="100"><b>Phone number:</b></th>
        <th width="100"><b>Sex:</b></th>
    </tr>
    <c:forEach items="${requestScope.people}" var="person">
        <c:if test="${person.getSex() == 'FEMALE'}">
            <tr>
                <td>${person.getName()}</td>
                <td>${person.getSurname()}</td>
                <td>${person.getBornYear()}</td>
                <td>${person.getPhoneNumber()}</td>
                <td>${person.getSex()}</td>
            </tr>
        </c:if>
    </c:forEach>
    <c:forEach items="${requestScope.people}" var="person">
        <c:if test="${person.getSex() == 'MALE'}">
            <tr>
                <td>${person.getName()}</td>
                <td>${person.getSurname()}</td>
                <td>${person.getBornYear()}</td>
                <td>${person.getPhoneNumber()}</td>
                <td>${person.getSex()}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<br>

<table border=1>
    <tr>
        <th width="100"><b>Name:</b></th>
        <th width="100"><b>Surname:</b></th>
        <th width="100"><b>Born year:</b></th>
        <th width="100"><b>Phone number:</b></th>
        <th width="100"><b>Sex:</b></th>
    </tr>
    <c:forEach items="${requestScope.people}" var="person">
        <c:if test="${(2018 - person.getBornYear()) > 30}">
            <c:choose>
                <c:when test="${fn:startsWith(person.getSurname(), 'K') && person.getSex() == 'MALE'}">
                    <tr style="background-color: green">
                </c:when>
                <c:otherwise>
                    <tr>
                </c:otherwise>
            </c:choose>
            <td>${person.getName()}</td>
            <td>${person.getSurname()}</td>
            <td>${person.getBornYear()}</td>
            <td>${person.getPhoneNumber()}</td>
            <td>${person.getSex()}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>