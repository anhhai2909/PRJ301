<%-- 
    Document   : home
    Created on : 04-06-2023, 20:43:04
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import="DAL.teacherDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/homecss.css" rel="stylesheet">
    </head>
    <body>
        <%
            teacherDAO d = new teacherDAO();
            String tid = (String) request.getAttribute("teacherid");
            teacher t = d.get1teacher(tid);
        %>
        <div class="header">
            <div class="logo">
                <img class="logo" src="img/logo2.png">
            </div>
            <div class="tprofile" onclick="showdropdown()">
                <div >
                    <img class="tphoto" src =<%= t.getImgaddress()%>>
                </div>
                <div class="tpro">
                    <p><%=t.getName()%></p>
                </div>

            </div>

            <div class="dropdown" id="dropdown">
                <div class="dropdown-element">
                    <a href="#">Profile</a><br/>
                </div>

                <div class="dropdown-element">
                    <a href="#">Cài đặt</a><br/>
                </div>

                <div class="dropdown-element" id="logout">
                    <a href="login.jsp">Đăng xuất</a>
                </div>
            </div>
        </div>

    <script>
        function showdropdown() {
            var a = document.getElementById('dropdown');
                if(a.style.display === 'none'){
                    a.style.display = 'block';
                }else{
                    a.style.display = 'none';
                }
        }
    </script>
    </body>
    

</html>
