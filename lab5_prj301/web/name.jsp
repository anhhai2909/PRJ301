<%-- 
    Document   : Name_arr
    Created on : 21-06-2023, 07:22:54
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
            <h1>${i}</h1>
        </c:forEach>
</body>
</html>
