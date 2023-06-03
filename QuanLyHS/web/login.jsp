<%-- 
    Document   : login
    Created on : 01-06-2023, 20:06:59
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/logincss.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <form action="loginservlet" method="post">
            <div class="container">
                <div class="slogan">
                    <p>Trường THPT Yên Tân số 1</p>
                    <p></p>
                </div>
                <div class="login">
                    <div class="headl">
                        <h1>Đăng Nhập</h1>
                    </div>
                    <div class="mktk">
                        <div clas="logo">
                            <div class="logo2">
                                <img src="img/login.jpeg" class="loginimg">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="form-label">Nhập Tài Khoản</label><br/>
                            <input id="username" name="username" type="text" placeholder="Tài khoản" required/>
                            <span class="form-message"></span>
                        </div>

                        <div class="form-group">
                            <label for="password" class="form-label">Nhập Mật Khẩu</label><br/>
                            <input id="password" name="password" type="password" placeholder="Mật khẩu" required/>
                            <span class="form-message"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="role" class="form-label">Bạn là: </label>
                        <select class="opt">
                            <option>Học Sinh</option>
                            <option>Giáo Viên</option>
                        </select>
                    </div>
                    <div class="submit">
                        <input type="submit" value="Đăng Nhập" class="submitbottom"/>
                    </div>
                </div>
                
            </div> 
        </form>
    </body>
</html>
