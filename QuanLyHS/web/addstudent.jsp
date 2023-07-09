<%-- 
    Document   : addstudent
    Created on : 21-06-2023, 11:56:17
    Author     : anhha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/homecss.css" rel="stylesheet">
        <link href="css/addstudentcss.css" rel="stylesheet">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10" style="background-color: #f7f7fa;margin-bottom: 100px">
                <div>
                    <form action="addstudent" method="post"  enctype="multipart/form-data" style="width: 90%; background-color: white;margin-left: auto ;margin-right: auto;margin-bottom: 50px;border-radius: 10px;padding:20px 0;margin-top: 50px">
                        <div>
                            <h3 style="margin-left: 30px">Thêm Học Sinh</h3>
                        </div>

                        <div style="background-color: #E1FFEA;line-height: 60px;border-radius: 10px">
                            <p style="color: green;text-align: center">${txt}</p>
                        </div>
                        
                        <div style="background-color: #FFE9F0;line-height: 60px;border-radius: 10px">
                            <p style="color: red;text-align: center">${error}</p>
                        </div>
                        <div class="row" ">
                            <div class="col-md-6">
                                <div style="width:80%" >
                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Mã HS </p><input class="col-md-8" type="text" name="sid" placeholder="st0**" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF" required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Họ và tên </p><input class="col-md-8" type="text" name="name" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Niên khóa </p><div class="col-md-8" style="padding:0"><input  type="date" name="datein" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF;width:48%"required/>~<input  type="date" name="dateout" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF;width:48%"required/></div>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Giới Tính</p><input class="col-md-8" type="text" name="gender" placeholder="1-Nam | 0-Nữ" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Ngày sinh </p><input class="col-md-8" type="date" name="dob" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Quê quán </p><input class="col-md-8" type="text" name="address" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>       


                                </div>
                            </div>

                            <div class="col-md-6">
                                <div style="width:80%">                       
                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Email </p><input class="col-md-8" type="text" name="email" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">SDT </p><input class="col-md-8" type="text" name="phone" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">CCCD </p><input class="col-md-8" type="text" name="idnum" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Họ tên cha/mẹ </p><input class="col-md-8" type="text" name="prname" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">SDT cha/mẹ </p><input class="col-md-8" type="text" name="prphone" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"required/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Ảnh thẻ </p>
                                        <div  class="col-md-8" style=";border-radius: 6px;border:1px solid #DFDFDF;padding:10px 0 10px 0">
                                            <input type ="file" name="photo" style="margin:auto 0" required/>
                                        </div>
                                    </div>
                                </div>                            
                            </div>
                        </div>
                        <div style="text-align: center">
                            <input class="submitbut" type="submit" value="Xác nhận" >
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
