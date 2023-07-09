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
        <form action="login" method="post">
            <div class="container">
                
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
                        
                        <div class="error">
                            <p style="color: red">${error}</p>
                        </div>
                        
                        <div class="form-group">
                            <label for="username" class="form-label">Tài Khoản</label><br/>
                            <input id="username" name="username" type="text" required/>
                            <span class="form-message"></span>
                        </div>

                        <div class="form-group">
                            <label for="password" class="form-label">Mật Khẩu</label><br/>
                            <input id="password" name="password" type="password"  required/>
                            <span class="form-message"></span>
                        </div>
                    </div>    
                    
                    <div class="submit">
                        <input type="submit" value="Đăng Nhập" class="submitbottom"/>
                    </div>
                </div>
                
            </div> 
        </form>
    </body>
</html>
