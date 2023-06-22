<%-- 
    Document   : addclass
    Created on : 23-06-2023, 00:35:15
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import = "model.Student"%>
<%@page import = "java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link href="css/homecss.css" rel="stylesheet">
        <link href="css/addstudentcss.css" rel="stylesheet">
        <link href="css/studentlistcss.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123"  style="margin-bottom: 100px">
                <div>
                    <h3 style="padding:20px;width:300px">Thêm lớp học</h3>
                </div>
                <div style="width: 700px">
                    <div style="background-color: white">
                        <form action="" method="get">
                            <div class="row" style="margin: 20px">
                                <p class="col-md-4" style="text-align: right;margin:auto 0;font-weight: 500">Mã lớp</p>
                                <input class="col-md-8" type="text" name="cid" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF "/>
                            </div>

                            <div class="row" style="margin: 20px">
                                <p class="col-md-4" style="text-align: right;margin:auto 0;font-weight: 500">Tên lớp</p>
                                <input class="col-md-8" type="text" name="name" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF "/>
                            </div>

                            <div class="row" style="margin: 20px">
                                <p class="col-md-4" style="text-align: right;margin:auto 0;font-weight: 500">GVCN</p>
                                <div class="col-md-8"  style="padding:0">
                                    <div>
                                        <select>
                                            <c:forEach items="${requestScope.list}" var="i">
                                                <option>${i.tid}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div style="margin-left: 500px">
                                <input class="submitbut" type="submit" value="Xác nhận" style="line-height: 40px;width: 150px;border-radius: 10px;border: 1px solid #DFDFDF;background-color: #3d5ee1;color: white"/>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
    </body>
</html>
