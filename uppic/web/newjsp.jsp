<%-- 
    Document   : newjsp
    Created on : 06-07-2023, 23:16:19
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
        <form action="uploadphoto" method="post" enctype="multipart/form-data">
            <img src="${requestScope.pt}">
            <input type ="file" name="photo"/>
            <button type ="submit">save</button>
        </form>
    </body>
</html>
