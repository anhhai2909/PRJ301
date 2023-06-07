<%-- 
    Document   : home
    Created on : 04-06-2023, 20:43:04
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import="DAL.teacherDAO"%>
<%@page import="model.beststudent"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/homecss.css" rel="stylesheet">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
            <div class="col-md-2 menu">
                <p class="menutitle" style="margin-left: 20px">Menu</p>
                <ul>
                    <li class="menu-element"  onclick="menudown('menudropdown')">
                        <i class="fa fa-graduation-cap"></i>
                        <p>Học Sinh</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown">
                        <li>Danh sách học sinh</li>
                        <li>Thông tin học sinh</li>
                        <li>Thêm học sinh</li>
                        <li>Sửa thông tin</li>
                    </ul>

                    <li class="menu-element" onclick="menudown('menudropdown1')">
                        <i class="fa fa-chalkboard-user"></i>
                        <p>Giáo Viên</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown1">
                        <li>Danh sách giáo viên</li>
                        <li>Thông tin giáo viên</li>
                        <li>Thêm giáo viên</li>
                        <li>Sửa thông tin</li>

                    </ul>

                    <li class="menu-element" onclick="menudown('menudropdown2')">
                        <i class="fa fa-chalkboard"></i>
                        <p>Lớp Học</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown2">
                        <li>Danh sách lớp</li>
                        <li>Thông tin lớp</li>
                        <li>Thêm lớp</li>
                        <li>Sửa thông tin</li>
                    </ul>

                    <li class="menu-element" onclick="menudown('menudropdown3')">
                        <i class="fa fa-book"></i>
                        <p>Môn Học</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown3">
                        <li>Danh sách môn học</li>
                        <li>Thêm môn học</li>
                        <li>Sửa thông tin</li>
                    </ul>

                    <li class="menu-element" onclick="menudown('menudropdown4')">
                        <i class="fa fa-square-poll-vertical"></i>
                        <p>Điểm</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown4">
                        <li>Danh sách điểm</li>
                        <li>Sửa điểm</li>
                    </ul>

                    <li class="menu-element" onclick="menudown('menudropdown5')">
                        <i class="fa-solid fa-shapes"></i>
                        <p>Thời Khóa Biểu</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown5">
                        <li>Xem TKB</li>
                        <li>Thêm TKB</li>
                        <li>Sửa</li>
                    </ul>

                    <li class="menu-element" onclick="menudown('menudropdown6')">
                        <i class="fa-solid fa-calendar-days"></i>
                        <p>Sự Kiện</p>
                    </li>
                    <ul class="stlist-option" id ="menudropdown6">
                        <li>Danh sách sự kiện</li>
                        <li>Thêm sự kiện</li>
                        <li>Sửa</li>
                    </ul>

                </ul>
            </div>
            <%
                    int stlsize =(int) request.getAttribute("stlistsize");
                    int tlsize =(int) request.getAttribute("teacherlistsize");
                    int clsize =(int) request.getAttribute("classlistsize");
                    ArrayList<beststudent> bstlist = (ArrayList<beststudent>) request.getAttribute("bestst");
            %>
            <div class="col-md-10">
                <div style="width:100%;">
                    <div class="row rightpart" >
                        <div class="col-md-4">
                            <div class=" spart">
                                <i class="fa-solid fa-users fa-3x"></i>
                                <div>
                                    <p>Số học sinh: <%=stlsize%></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class=" spart">
                                <i class="fa-solid fa-person-chalkboard fa-3x"></i>
                                <div>
                                    <p>Số giáo viên: <%=tlsize%></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="spart">
                                <i class="fa fa-book-open-reader fa-3x"></i>
                                <div>
                                    <p>Số lớp học: <%=clsize%></p>
                                </div>
                            </div>
                        </div>              
                    </div>
                </div>

                <div class="student-box">
                    <h4>Học sinh xuất sắc</h4>
                    <table>
                        <tr>
                            <th>Mã HS</th>
                            <th>Họ & Tên</th>
                            <th>Lớp</th>
                            <th>Điểm</th>
                            <th>Năm học</th>
                        </tr>
                        
                    </table>
                </div>
            </div>

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

        </script>
    </body>


</html>
