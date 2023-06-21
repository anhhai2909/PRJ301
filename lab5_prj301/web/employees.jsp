<%-- 
    Document   : employees
    Created on : 21-06-2023, 07:56:40
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
    <c:forEach var="i" items="${data}">
        <p>First Name: ${i.name.fname} </p>
        <p>Last Name: ${i.name.lname} </p>
        <p>Street: ${i.address.street} </p>
        <p>City: ${i.address.city} </p>
        <p>Zip Code: ${i.address.zipCode} </p>
        <br/>
    </c:forEach>  
</body>
</html>
