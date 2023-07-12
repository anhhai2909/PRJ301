<%-- 
    Document   : stprofile
    Created on : 27-06-2023, 07:43:06
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
        <link href="css/markavgcss.css" rel="stylesheet">  
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <style></style>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="margin-bottom: 100px">

                <div>
                    <div class="row" style="margin-top:50px;margin-bottom: 90px;">
                        <div class="col-md-3">
                            <div style="text-align: center">
                                <div style="background-color: white;border-radius: 15px;width: 100%;margin: 0 auto 0 auto">
                                    <h3 style="padding:20px;width:300px">Thông tin học sinh</h3>
                                </div>
                                <img src="${requestScope.student.imgaddress}" style="width:230px;height:270px;object-fit: cover;margin-top: 30px"/>

                                <div style="margin:40px auto 20px auto; background-color: white;border-radius: 15px;width: 300px;padding: 10px 0 10px 0">
                                    <form action="updateimg?sid=${requestScope.student.sID}" method="post" enctype="multipart/form-data" style="padding:0 0 0 10px">
                                        <div style="text-align:left; margin-bottom: 5px ">
                                            <input type ="file" name="photo" style="margin:auto 0;width: 300px" />
                                        </div>
                                        <div style="text-align: center ">
                                            <input type ="submit" style="margin:auto 0;" value="Save"/>
                                        </div>
                                    </form>
                                </div>
                            </div>                           
                        </div>

                        <div class="col-md-9">

                            <div style="background-color: white;border-radius: 15px;width:95%;padding:15px 20px 30px 10px">
                                <div style="text-align: right;margin-bottom: 20px">
                                    <a href="stprofileupdate?sid=${requestScope.student.sID}"><i class="fa-solid fa-pen-to-square"></i></a>
                                </div>
                                <div class="row" style="margin-left: 10px;margin-right: 10px">
                                    <div class="col-md-5">
                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-4" style="font-weight: 500">Mã HS </p>
                                            <p class="col-md-8" style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px;">${requestScope.student.sID}</p>
                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-4" style="font-weight: 500">Họ & Tên </p>
                                            <p class="col-md-8"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.name}</p>
                                        </div>

                                        <!--                                        <div class="row" style="margin-bottom: 15px">
                                                                                    <p class="col-md-4" style="font-weight: 500">Lớp </p>
                                                                                    <p class="col-md-8"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.cID}</p>
                                                                                </div>-->

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-4" style="font-weight: 500">Ngày sinh </p>
                                            <p class="col-md-8"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.dob}</p>
                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-4" style="font-weight: 500">Giới tính </p>
                                            <c:set var = "g" scope = "request" value = "${requestScope.student.gender}"/>
                                            <c:if test="${g==1}">
                                                <p class="col-md-8"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">Nam</p>
                                            </c:if>
                                            <c:if test="${g==0}">
                                                <p class="col-md-8"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">Nữ</p>
                                            </c:if>
                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-4" style="font-weight: 500">Quê quán </p>
                                            <p class="col-md-8"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.homeaddress}</p>
                                        </div>

                                    </div>

                                    <div class="col-md-7">
                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-5" style="font-weight: 500;padding-left: 40px">CCCD </p>
                                            <p class="col-md-7"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.idnumber}</p>
                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-5" style="font-weight: 500;padding-left: 40px">Email </p>
                                            <p class="col-md-7"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.email}</p>
                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-5" style="font-weight: 500;padding-left: 40px">SDT </p>
                                            <p class="col-md-7"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.phone}</p>
                                        </div>

                                        <div class="row" style="margin-bottom: 27px">
                                            <p class="col-md-5" style="font-weight: 500;padding-left: 40px">Niên khóa </p>
                                            <div class="col-md-7" style="padding:0">
                                                <div class="row" style="width:100%;margin:0">
                                                    <p class="col-md-5" style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.learntime.getformatDatein()}</p>
                                                    <p class="col-md-2" style="line-height: 35px">~</p>
                                                    <p class="col-md-5" style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.learntime.getformatDateout()}</p>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-5" style="font-weight: 500;padding-left: 40px">Họ & tên cha/mẹ </p>
                                            <p class="col-md-7"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.prname}</p>
                                        </div>

                                        <div class="row" style="margin-bottom: 15px">
                                            <p class="col-md-5" style="font-weight: 500;padding-left: 40px">SDT của cha/mẹ </p>
                                            <p class="col-md-7"style="border: 1px solid #D2D2D2;border-radius: 5px;line-height: 35px">${requestScope.student.prphone}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
