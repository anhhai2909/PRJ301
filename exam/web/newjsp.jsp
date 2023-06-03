<%-- 
    Document   : newjsp
    Created on : 03-06-2023, 21:02:38
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
            String[] student = {"Student1", "Student2", "Student3"};
            request.setAttribute("data",student);
        %>
        <p>Student no1: ${data[0]}</p>
        <p>Student no2: ${data[1]}</p>
        <p>Student no3: ${data[2]}</p>
        
        
        
    </body>
</html>
