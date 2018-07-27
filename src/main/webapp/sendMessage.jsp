<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Zadanie 4: POST</title>
</head>
<body>
<jsp:include page="menu.jsp" />

<table border="1">
    <tr>
        <td>
            <h4>Hello, ${requestScope.user}!</h4>
            <p>Thank you for contact.</p>
            <p>Your email was: ${requestScope.email}</p>
            <p>This is a confirmation that you have sent
                the following message to the JSP server:</p>
            <p>${requestScope.message}</p>
            <br>

            <h5>Thank you, ${requestScope.user}!<br>
                JSP Server</h5>
        </td>
    </tr>
</table>
</body>
</html>