<%-- 
    Document   : classprofile
    Created on : 01-07-2023, 20:24:21
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
                <div>
                    <h3 style="padding:20px;width:300px">Thông tin lớp học</h3>
                </div>
                
                <div style="background-color: white;padding-bottom: 40px;margin-bottom: 60px;border-radius: 15px;margin-right: 10px">
                    <div style="text-align: right;padding:30px 35px 10px 0">
                        <a href="addstudenttoclass"><i class="fa-solid fa-square-plus fa-2xl" style="color:#6C71FF"></i></a>
                    </div>
                    <div style="width: 95%;margin:0 auto">
                        <table style="width:100%;">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px">
                                    <th class="col-md-1">ID</th>
                                    <th class="col-md-3">Tên</th>
                                    <th class="col-md-1">Giới tính</th>
                                    <th class="col-md-2">Ngày sinh</th>
                                    <th class="col-md-2">Email</th>
                                    <th class="col-md-2">SDT</th>
                                    <th class="col-md-1" style="padding-left: 0">Tùy chọn</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="margin-top:15px;border-bottom: 1px solid #E6E6E6;margin-bottom: 0">
                                        <td class="col-md-1">${i.sID}</td>
                                        <td class="col-md-3">${i.name}</td>
                                        <c:set var = "g" scope = "request" value = "${i.gender}"/>
                                        <c:if test="${g==1}">
                                            <td class="col-md-1">Nam</td>
                                        </c:if>
                                        <c:if test="${g==0}">
                                            <td class="col-md-1">Nữ</td>
                                        </c:if>
                                        <td class="col-md-2">${i.dob}</td>
                                        <td class="col-md-2">${i.email}</td>
                                        <td class="col-md-2">${i.phone}</td>
                                        <td class="col-md-1" style="padding-left: 0"><a href="stprofile?id=${i.sID}" class="option-icon"><i class="fa-solid fa-eye"></i></a></td>
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
