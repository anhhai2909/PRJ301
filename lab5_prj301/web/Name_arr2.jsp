<%-- 
    Document   : Name_ar2
    Created on : 21-06-2023, 07:45:46
    Author     : anhha
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:forEach var="i" items="${data}" >
        <p>First Name: ${ i.fname }</p>
        <p>Last Name: ${ i.lname }</p><br/>
    </c:forEach>
</body>
</html>
