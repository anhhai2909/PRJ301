<%-- 
    Document   : subjectslist
    Created on : 25-06-2023, 14:17:21
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
        <link href="css/studentlistcss.css" rel="stylesheet"> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="margin-bottom: 100px">

                <div style="margin-top: 30px;margin-bottom: 20px">
                    <form action="subjectsearch" method="get">
                        <div class="row">
                            <div class="col-md-4 search" style="text-align: center">
                                <input type="text" name="suid" placeholder="Tìm theo mã..."/>
                            </div>

                            <div class="col-md-4 search" style="text-align: center">
                                <input type="text" name="name" placeholder="Tìm theo tên..."/>
                            </div>

                            <div class="col-md-4 searchsubmit">
                                <input type="submit" value="Tìm kiếm"/>
                            </div>
                        </div>
                    </form>
                </div>

                <div style="background-color: white;border-radius: 10px;margin-bottom: 100px;padding-bottom: 50px">

                    <div>
                        <h3 style="padding:20px;width:200px;padding-top: 50px">Môn học</h3>
                    </div>
                    <div style="background-color: #E1FFEA;line-height: 60px;border-radius: 10px">
                        <p style="color: green;text-align: center">${txt}</p>
                    </div>
                    <div style="padding-top: 20px">
                        <table style="width:90%;margin:0 auto">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                    <th class="col-md-2">Mã môn</th>
                                    <th class="col-md-2">Tên môn</th>
                                    <th class="col-md-6">Nội dung</th>
                                    <th class="col-md-2">Tùy chọn</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="width:100%;;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;line-height: 50px;font-weight: 500">
                                        <td class="col-md-2" style="text-align: center">${i.suid}</td>
                                        <td class="col-md-2" style="text-align: center">${i.name}</td>
                                        <td class="col-md-6">${i.descript}</td>     
                                        <th class="col-md-2" style="text-align: center"><a href="deletesubject?suid=${i.suid}" class="option-icon"><i class="fa-solid fa-trash"></i></a></th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
