<%-- 
    Document   : teacherlist
    Created on : 22-06-2023, 16:46:05
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/homecss.css" rel="stylesheet">
        <link href="css/teacherlistcss.css" rel="stylesheet">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp"%>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10" style="background-color: #f7f7fa;margin-bottom: 100px">
                <div style="margin:20px;background-color: white;border-radius: 10px;padding-top:20px">
                    <div>
                        <h3 style="padding:20px;width:200px">Giáo viên</h3>
                    </div>
                    <div style="padding-bottom: 60px">
                        <table style="width:90%;margin:0 auto">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                    <th class="col-md-2">ID</th>
                                    <th class="col-md-3">Tên</th>
                                    <th class="col-md-3">Email</th>
                                    <th class="col-md-4">Ảnh</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="margin-top:10px;width:100%;;margin-left: 0;margin-right: 0;">
                                        <td class="col-md-2">${i.tid}</td>
                                        <td class="col-md-3">${i.name}</td>
                                        <td class="col-md-3">${i.email}</td>
                                        <td class="col-md-4"><img src="${i.imgaddress}"></td>
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
