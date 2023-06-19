<%-- 
    Document   : homepageheader
    Created on : 14-06-2023, 11:21:40
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <%
                teacher t = (teacher) session.getAttribute("teacher");
            %>
            <div class="logo">
                <i class="fa-solid fa-school fa-2x"></i>           
            </div>

            <div>
                <div class="tprofile" onclick="showdropdown()">
                    <div >
                        <img class="tphoto" src =<%=t.getImgaddress()%>>
                    </div>
                    <div class="tpro">
                        <p><%=t.getName()%></p>
                    </div>

                </div>

                <div class="dropdown" id="dropdown">
                    <a href="tprofile?tid=<%=t.getTid()%>">Profile</a>
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
