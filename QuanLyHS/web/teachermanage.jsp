<%-- 
    Document   : teachermanage
    Created on : 13-07-2023, 22:23:23
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link href="css/homecss.css" rel="stylesheet">    
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <style>
        .add-but:hover{
            color: #007bff;
            cursor: pointer;
        }
        .submitbut:hover{
            opacity: 0.8;
        }
        .add-box{
            display:none;
        }
    </style>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="margin-bottom: 100px">

                <div style="padding-top: 10px;width: 100%;background-color: white;margin:70px 20px 20px 0" >
                    <div>
                        <h3 style="padding:20px;width:300px;padding-top: 50px">Quản lý</h3>
                    </div>
                    <div style="background-color: #E1FFEA;line-height: 60px;border-radius: 10px">
                        <p style="color: green;text-align: center">${txt}</p>
                    </div>
                    <div style="background-color: #FFE9F0;line-height: 60px;border-radius: 10px">
                        <p style="color: red;text-align: center">${error}</p>
                    </div>
                    <div style="text-align: right;margin-right:30px">
                        <i class="fa-solid fa-square-plus fa-2x add-but" onclick="showdropdown()"></i>
                    </div>
                    <div class="row">
                        <div class="col-md-9" style="text-align: center">
                            <table style="margin:10px 10px 60px 10px;padding:0 0 30px 0;" >
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                        <th class="col-md-3">Mã GV</th>
                                        <th class="col-md-4">Tên GV</th>
                                        <th class="col-md-4">Email</th>
                                        <th class="col-md-1"></th>
                                    </tr>
                                </thead>

                                <tbody style="text-align: center;padding-bottom: 20px">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;font-weight: 500;line-height: 40px">
                                        <c:forEach items="${requestScope.teacherlist}" var="i">
                                            <th class="col-md-3" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.tid}</th>
                                            <th class="col-md-4" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.name}</th>
                                            <th class="col-md-4" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.email}</th>   
                                            <th class="col-md-1" style="border-bottom: 1px solid #F3F3F3">Tùy </th>
                                            </c:forEach>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-3">
                            <table style="width:90%;margin:10px 0px 10px 0px;padding:0;" >
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                        <th class="col-md-7">Tài khoản</th>
                                        <th class="col-md-5">Mật khẩu</th>
                                    </tr>
                                </thead>

                                <tbody style="text-align: center">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;font-weight: 500;line-height: 40px">
                                        <c:forEach items="${requestScope.accountlist}" var="i">
                                            <th class="col-md-7" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.user}</th>
                                            <th class="col-md-5" style="border-bottom: 1px solid #F3F3F3">${i.pass}</th>                             
                                            </c:forEach>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div style="background-color: white;border-radius: 20px;width: 400px;padding:40px 20px 40px 20px;text-align: center;margin-bottom: 60px" class="add-box" id="add-box">
                    <form action="teacherandaccountmanage" method="post" enctype="multipart/form-data">
                        <div>
                            <input type="text" name="name" placeholder="Họ và tên" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px"required/>
                        </div>
                        <div>
                            <input type="text" name="email" placeholder="Email" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px" required/>
                        </div>
                        <div>
                            <div class="row" style="width: 300px;margin-left: 40px">
                                <p class="col-md-4">Chức vụ </p>
                                <div class="col-md-8">
                                    <input type="radio" name="role" value="1" checked/>admin
                                    <input type="radio" name="role" value="2"/>Giáo viên
                                </div>
                            </div>
                        </div>
                        <div>
                            <input type ="file" name="photo" style="margin-bottom: 10px;margin-left: 45px" required/>
                        </div>
                        <div>
                            <input name="photo" type="submit" value="Xác nhận" style="width: 100px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;color:white;background-color:  #3d5ee1;border:0" class="submitbut"/>
                        </div>
                    </form>
                </div>
            </div>               
        </div>
        <script>
            function showdropdown() {
                var a = document.getElementById('add-box');
                if (a.style.display !== 'block') {
                    a.style.display = 'block';

                } else {
                    a.style.display = 'none';
                }
            }
        </script>
    </body>
</html>
