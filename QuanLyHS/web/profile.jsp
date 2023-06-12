<%-- 
    Document   : profile
    Created on : 11-06-2023, 15:08:54
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import = "model.account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link href="css/homecss.css" rel="stylesheet">
        <link href="css/tprofilecss.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            teacher t = (teacher) request.getAttribute("tdata");     
            account a = (account) request.getAttribute("taccount");
        %>
        <div class="header">
            <div class="logo">
                <i class="fa-solid fa-school fa-2x"></i>         
            </div>

            <div>
                <div class="tprofile" onclick="showdropdown()">
                    <div >
                        <img class="tphoto" src =<%= t.getImgaddress()%>>
                    </div>
                    <div class="tpro">
                        <p><%=t.getName()%></p>
                    </div>

                </div>

                <div class="dropdown" id="dropdown">
                    <a href="#">Profile</a>
                    <a href="#">Cài đặt</a>
                    <a href="login.jsp" id="logout">Đăng xuất</a>
                </div>
            </div>

        </div>
        <div class="row">

            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123">
                <div>
                    <h3 style="margin: 20px">Profile</h3>
                </div>
                <div class="fpart">
                    <div class="fpart-1">
                        <div>
                            <img class="prophoto" src="<%=t.getImgaddress()%>">
                        </div>

                        <div class="textbox">
                            <h4><%=t.getName()%></h4>
                            <h5><%=a.getUser()%></h5>
                        </div>
                    </div>
                    <div class="fpart-2">
                        <div class="fpart-22">
                            <div class="p1" id="p1" onclick="showdiv1()">
                                <p>Cá nhân</p>
                            </div>

                            <div class="p1" id="p2" onclick="showdiv()" >
                                <p>Tài khoản</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="width:95%" class="pd" id="pd">
                    <div class="pdhead">
                        <h3>Thông tin cá nhân</h3>
                        <div>                        
                            <a href="#"><i class="fa-solid fa-pen-to-square"></i>Edit</a>
                        </div>
                    </div>

                    <div style="padding-bottom: 30px">
                        <div class="row">                         
                            <p class="col-md-3 pdl">Mã giáo viên</p>
                            <p class="col-md-9 pdr"><%=t.getTid()%></p>
                        </div>

                        <div class="row">
                            <p class="col-md-3 pdl">Họ và tên</p>
                            <p class="col-md-9 pdr"><%=t.getName()%></p>
                        </div>

                        <div class="row">
                            <p class="col-md-3 pdl">Email</p>
                            <p class="col-md-9 pdr"><%=t.getEmail()%></p>
                        </div>
                    </div>
                </div>

                <div style="width:95%" class="pd2" id="pd2">
                    <div class="pdhead">
                        <h3>Tài khoản</h3>
                        <div>                       
                            <a href="#"><i class="fa-solid fa-pen-to-square"></i>Đổi mật khẩu</a>
                        </div>

                    </div>
                    <div style="padding-bottom: 30px">
                        <div class="row" style="width: 60%; margin-bottom: 15px">
                            <p class="col-md-4" style="text-align: right;color:#7B7B7B">Tài khoản</p>
                            <input class="col-md-8" type="text" value="<%=a.getUser()%>" readonly="true"/><br/>
                        </div>

                        <div class="row" style="width: 60%">
                            <p class="col-md-4" style="text-align: right;color:#7B7B7B"">Mật khẩu</p>
                            <input class="col-md-8" type="text" value="<%=a.getPass()%>" readonly="true"/><br/>
                        </div>
                    </div>
                </div>
                <%@include file="homepagefooter.jsp" %>
            </div>
            <script>
                function showdropdown() {
                    var a = document.getElementById('dropdown');
                    if (a.style.display === 'none') {
                        a.style.display = 'block';

                    } else {
                        a.style.display = 'none';
                    }
                }
                function menudown(id) {
                    var b = document.getElementById(id);
                    if (b.style.display === 'none') {
                        b.style.display = 'block';
                    } else {
                        b.style.display = 'none';
                    }
                }
                function showdiv() {
                    var b = document.getElementById('pd');
                    var c = document.getElementById('pd2');
                    var d = document.getElementById('p2');
                    var e = document.getElementById('p1');
                    b.style.display = 'none';
                    c.style.display = 'block';
                    d.style.border = "2px solid #CFCFCF";
                    e.style.border = "none";

                }
                function showdiv1() {
                    var b = document.getElementById('pd2');
                    var c = document.getElementById('pd');
                    var d = document.getElementById('p1');
                    var e = document.getElementById('p2');
                    b.style.display = 'none';
                    c.style.display = 'block';
                    d.style.border = "2px solid #CFCFCF";
                    e.style.border = "none";
                }
            </script>
    </body>
</html>