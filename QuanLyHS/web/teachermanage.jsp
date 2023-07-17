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
        .add-but{
            color:black;
        }
        .add-but:hover{
            color: #007bff;
            cursor: pointer;
        }
        .submitbut:hover{
            opacity: 0.8;
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
                        <p style="color: green;text-align: center">${requestScope.txt}</p>
                    </div>
                    <div style="background-color: #FFE9F0;line-height: 60px;border-radius: 10px">
                        <p style="color: red;text-align: center">${error}</p>
                    </div>

                    <div class="row">
                        <div class="col-md-9" style="text-align: center">
                            <table style="margin:10px 10px 60px 10px;padding:0 0 30px 0;" >
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                        <th class="col-md-2">Mã GV</th>
                                        <th class="col-md-3">Tên GV</th>
                                        <th class="col-md-4">Email</th>
                                        <th class="col-md-2">Bộ môn</th>
                                        <th class="col-md-1"></th>
                                    </tr>
                                </thead>

                                <tbody style="text-align: center;padding-bottom: 20px">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;font-weight: 500;line-height: 40px">
                                        <c:forEach items="${requestScope.teacherlist}" var="i">
                                            <td class="col-md-2" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.tid}</td>
                                            <td class="col-md-3" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.name}</td>
                                            <td class="col-md-4" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">${i.email}</td>   
                                            <td class="col-md-2" style="border-bottom: 1px solid #F3F3F3;border-right: 1px solid #F3F3F3">
                                                <c:forEach items="${i.list}" var="j">
                                                    <div style="width: 60px;border:1px solid #ACACAD;border-radius: 5px;margin:5px">
                                                        <div style="text-align: right;line-height: 10px">
                                                            <a href="#" onclick="Warning2('${i.tid}', '${j}')" style="height: 15px"><i class="fa-solid fa-xmark fa-2xs"></i></a>
                                                        </div>
                                                        <p style="margin:0;line-height: 20px">${j}</p>
                                                    </div>
                                                </c:forEach>
                                            </td>
                                            <td class="col-md-1" style="border-bottom: 1px solid #F3F3F3"><a href="#" onclick="Warning('${i.tid}')" ><i class="fa-solid fa-trash add-but" ></i></a> </td>
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
                <div class="row">  
                    <div class="col-md-4" >
                        <div style="background-color: white;border-radius: 10px;width: 400px;padding:40px 20px 40px 20px;text-align: center;margin-bottom: 60px">
                            <div style="text-align: left;font-size: 18px;font-weight: 500">
                                <p>Bổ sung môn học được phụ trách</p>
                                <form action="addsubjectmanaged" method="get" >
                                    <div>
                                        <input type="text" name="tid" placeholder="Mã GV" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px"required/>
                                    </div>
                                    <div>
                                        <input type="text" name="suid" placeholder="Mã môn" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px"required/>
                                    </div>
                                    <div>
                                        <input type="submit" value="Xác nhận" style="width: 100px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;color:white;background-color:  #3d5ee1;border:0" class="submitbut"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div style="background-color: white;border-radius: 10px;width: 400px;padding:40px 20px 40px 20px;text-align: center;margin-bottom: 60px">
                            <div style="text-align: left;font-size: 18px;font-weight: 500">
                                <p>Chỉnh sửa tài khoản</p>
                                <form action="teacheraccountupdate" method="post">
                                    <div>
                                        <input type="text" name="user" placeholder="Tài khoản" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px"required/>
                                    </div>
                                    <div>
                                        <input type="text" name="pass" placeholder="Mật khẩu mới" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px"required/>
                                    </div>
                                    <div>
                                        <input type="text" name="repass" placeholder="Nhập lại mật khẩu" style="width: 250px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;margin-bottom: 5px;padding-left: 10px"required/>
                                    </div>
                                    <div>
                                        <input type="submit" value="Xác nhận" style="width: 100px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;color:white;background-color:  #3d5ee1;border:0" class="submitbut"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4" >
                        <div style="background-color: white;border-radius: 10px;width: 400px;padding:40px 20px 40px 20px;text-align: center;margin-bottom: 60px">
                            <div style="text-align: left;font-size: 18px;font-weight: 500">
                                <p>Thêm tài khoản</p>
                            </div>
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
                                    <input type="submit" value="Xác nhận" style="width: 100px;line-height: 30px;border-radius: 10px;border:1px solid #ACACAD;color:white;background-color:  #3d5ee1;border:0" class="submitbut"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>               
        </div>
        <script type="text/javascript">
            function showdropdown1(id) {
                var a = document.getElementById(id);
                if (a.style.display !== 'block') {
                    a.style.display = 'block';
                } else {
                    a.style.display = 'none';
                }
            }
            function Warning(tid) {
                var option = confirm("Xóa giáo viên?");
                if (option === true) {
                    window.location.href = 'deleteteacher?tid=' + tid;
                }
            }
            function Warning2(tid, suname) {
                var option = confirm("Bỏ bộ môn?");
                if (option === true) {
                    window.location.href = 'deletesubjectmanage?tid=' + tid + '&suname=' + suname;
                }
            }
            function showdropdown() {
                var a = document.getElementById('dropdown');
                if (a.style.display !== 'block') {
                    a.style.display = 'block';

                } else {
                    a.style.display = 'none';
                }
            }

        </script>
    </body>
</html>
