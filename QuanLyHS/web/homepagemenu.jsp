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


            </ul>
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
