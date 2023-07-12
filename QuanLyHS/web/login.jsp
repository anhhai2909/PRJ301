<%-- 
    Document   : login
    Created on : 01-06-2023, 20:06:59
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <style>
        .submitbottom:hover{
            opacity:0.8;
            cursor: pointer;
        }
        body{
            background-color: #F5F5F5
        }
    </style>
    <body>
        <%
            String u="";
            String p="";           
            Cookie[] cookie = request.getCookies();
            if(cookie!=null){    
                for(Cookie c:cookie){
                    if(c.getName().equals("user")){
                        u = c.getValue();
                    }
                    if(c.getName().equals("pass")){
                        p = c.getValue();
                    }   
                }
            }
        %>
        <div style="border:1px solid #ACACAD;width:400px;border-radius: 5px;padding-bottom: 50px;margin:150px auto auto auto;padding-top: 30px;background-color: white">
            <form action="login" method="post">               
                <div class="login">
                    <div class="headl">
                        <h1 style="margin-left: 65px">Login</h1>
                    </div>
                    <div style="margin-bottom: 10px">
                        <div class="error" style="text-align: center">
                            <p style="color: red">${error}</p>
                        </div>

                        <div style="margin-bottom: 5px">
                            <p style="margin-left: 65px;margin-bottom: 0;font-size: 18px">Tài khoản</p>
                            <div style="text-align: center">
                                <input id="username" name="username" type="text" value="<%=u%>" style="width: 250px;line-height: 35px;border:1px solid #CBCBCB;border-radius: 2px;padding-left: 20px" required/>
                            </div>
                        </div>

                        <div>
                            <p style="margin-left: 65px;margin-bottom: 0;font-size: 18px">Mật khẩu</p>
                            <div style="text-align: center">
                                <input id="password" name="password" type="password" value="<%=p%>" style="width: 250px;line-height: 35px;border:1px solid #CBCBCB;border-radius: 2px;padding-left: 20px" required/>
                            </div>
                        </div>

                        <div style="margin-left: 65px">
                            <div style="margin-top: 20px;line-height: 20px">
                                <input type="checkbox" name="remember" style="margin-right: 10px"/>Lưu tài khoản
                            </div>

                        </div>
                    </div>    

                    <div class="submit" style="width: 100%;margin-top: 10px">
                        <button type="submit" class="submitbottom"style="width:120px;border:0;line-height: 40px;background-color: #698FF7;color:white;font-weight: 400;border-radius: 30px;margin-left: 65px;font-size: 16px"/>Đăng nhập</button>
                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
