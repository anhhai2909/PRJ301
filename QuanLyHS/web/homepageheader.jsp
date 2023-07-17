<%-- 
    Document   : homepageheader
    Created on : 14-06-2023, 11:21:40
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import = "model.teacher"%>
<%@page import = "java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="logo">
                <c:if test="${sessionScope.role==1}">
                    <a href="home"><i class="fa-solid fa-school fa-2x" style="color:black"></i></a>  
                </c:if>
                <c:if test="${sessionScope.role==2}">
                    <a href="studentlist"><i class="fa-solid fa-school fa-2x" style="color:black"></i></a>  
                </c:if>
            </div>

            <div>
                <div class="tprofile" onclick="showdropdown()">
                    <div>
                        <img class="tphoto" src =${sessionScope.teacher.getImgaddress()}>
                    </div>
                    <div class="tpro">
                        <p>${sessionScope.teacher.getName()}</p>
                    </div>

                </div>

                <div class="dropdown" id="dropdown">
                    <a href="tprofile?tid=${sessionScope.teacher.getTid()}">Profile</a>
                    <a href="login.jsp" id="logout">Đăng xuất</a>
                </div>
            </div>

        </div>

        <script>
            function showdropdown() {
                var a = document.getElementById('dropdown');
                if (a.style.display !== 'block') {
                    a.style.display = 'block';

                } else {
                    a.style.display = 'none';
                }
            }
            function menudown(id) {
                var b = document.getElementById(id);
                if (b.style.display !== 'block') {
                    b.style.display = 'block';
                } else {
                    b.style.display = 'none';
                }
            }
        </script>
    </body>
</html>
