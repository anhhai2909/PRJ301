<%-- 
    Document   : MyExam.jsp
    Created on : 16-07-2023, 15:11:23
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="execute" method="post">
            Enter an integer n: <input type="text" name="n" value="${requestScope.n}"/><br/>
            Result: <input type="text" value="${requestScope.sum}" readonly style="margin-left: 73px"/><br/>
            <div style="display: flex">
                <input type="submit" value="Execute" style="height: 30px;margin:auto 0"><p>${requestScope.error}</p>
            </div>
        </form>
    </body>
</html>
