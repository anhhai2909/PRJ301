<%-- 
    Document   : addstudent
    Created on : 21-06-2023, 11:56:17
    Author     : anhha
--%>

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

                <div style="margin-top: 50px">
                    <form action="" method="get" style="width: 90%; background-color: white;margin-left: auto ;margin-right: auto;margin-bottom: 50px;border-radius: 10px;padding:10px 0  40px 0;">
                        <div>
                            <h3 style="padding: 20px">Sửa thông tin</h3>
                        </div>
                        <div class="row" ">
                            <div class="col-md-6">
                                <div style="width:80%" >
                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Mã HS </p><input class="col-md-8" type="text" name="sid" value="${requestScope.student.sID}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Họ và tên </p><input class="col-md-8" type="text" name="name" value="${requestScope.student.name}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Niên khóa </p>
                                        <div class="col-md-8" style="padding:0">
                                            <input  type="date" name="datein" value="${requestScope.learntime.datein}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF;width:48%"/>~<input  type="date" name="dateout" value="${requestScope.learntime.dateout}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF;width:48%"/>
                                        </div>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Giới Tính</p><input class="col-md-8" type="text" name="gender" value="${requestScope.student.gender}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Ngày sinh </p><input class="col-md-8" type="date" name="dob" value="${requestScope.student.dob}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Quê quán </p><input class="col-md-8" type="text" name="address" value="${requestScope.student.homeaddress}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>                                   
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div style="width:80%">                       
                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Email </p><input class="col-md-8" type="text" name="email" value="${requestScope.student.email}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">SDT </p><input class="col-md-8" type="text" name="sdt" value="${requestScope.student.phone}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">CCCD </p><input class="col-md-8" type="text" name="idnum" value="${requestScope.student.idnumber}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Họ tên cha/mẹ </p><input class="col-md-8" type="text" name="prname" value="${requestScope.student.prname}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">SDT cha/mẹ </p><input class="col-md-8" type="text" name="prphone" value="${requestScope.student.prphone}" style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
                                    </div>

                                    <div class="row" style="margin:20px 0">
                                        <p class="col-md-4" style="text-align: right;margin:auto 0">Ảnh thẻ </p><input class="col-md-8" type="text" name="idnum" value="${requestScope.student.imgaddress}"style="line-height: 40px;border-radius: 6px;border:1px solid #DFDFDF"/>
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
