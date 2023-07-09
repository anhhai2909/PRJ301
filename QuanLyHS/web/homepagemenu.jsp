<%-- 
    Document   : homepagemenu
    Created on : 12-06-2023, 09:06:57
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
        <div class="col-md-2 menu">
            <p class="menutitle" style="margin-left: 20px">Menu</p>
            <ul>
                <li class="menu-element"  onclick="menudown('menudropdown')">
                    <i class="fa fa-graduation-cap"></i>
                    <p>Học Sinh</p>
                </li>
                <ul class="stlist-option" id ="menudropdown">
                    <li><a href="studentlist" style="color:black;text-decoration: none;">Danh sách học sinh</a></li>
                    <li><a href="addstudent.jsp" style="color:black;text-decoration: none;">Thêm học sinh</a></li>
                </ul>

                <li class="menu-element" onclick="menudown('menudropdown1')">
                    <i class="fa fa-chalkboard-user"></i>
                    <p>Giáo Viên</p>
                </li>
                <ul class="stlist-option" id ="menudropdown1">
                    <li><a href="teacherlist" style="color:black;text-decoration: none;">Danh sách giáo viên</a></li>
                </ul>

                <li class="menu-element" onclick="menudown('menudropdown2')">
                    <i class="fa fa-chalkboard"></i>
                    <p>Lớp Học</p>
                </li>
                <ul class="stlist-option" id ="menudropdown2">
                    <li><a href="classlist" style="color:black;text-decoration: none;">Danh sách lớp</a></li>
                    <li><a href="addclass" style="color:black;text-decoration: none;">Thêm lớp</a></li>
                </ul>

                <li class="menu-element" onclick="menudown('menudropdown3')">
                    <i class="fa fa-book"></i>
                    <p>Môn Học</p>
                </li>
                <ul class="stlist-option" id ="menudropdown3">
                    <li><a href="subject" style="color:black;text-decoration: none;">Danh sách môn học</a></li>
                    <li><a href="addsubject.jsp" style="color:black;text-decoration: none;">Thêm môn học</a></li>
                </ul>

                <li class="menu-element" onclick="menudown('menudropdown4')">
                    <i class="fa fa-square-poll-vertical"></i>
                    <p>Điểm</p>
                </li>
                <ul class="stlist-option" id ="menudropdown4">
                    <li><a href="marklist" style="color:black;text-decoration: none;">Danh sách điểm</a></li>
                    <li><a href="markavg" style="color:black;text-decoration: none;">Điểm trung bình</a></li>
                     
                </ul>

                <li class="menu-element" onclick="menudown('menudropdown5')">
                    <i class="fa-solid fa-shapes"></i>
                    <p>Thời Khóa Biểu</p>
                </li>
                <ul class="stlist-option" id ="menudropdown5">
                    <li><a href="timetable" style="color:black;text-decoration: none;">TKB</a></li>
                </ul>


            </ul>
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
