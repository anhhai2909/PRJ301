<%-- 
    Document   : markavg
    Created on : 25-06-2023, 23:19:26
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
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
                    <h3 style="padding:20px;width:300px">Điểm trung bình</h3>
                </div>
                
                <div>
                    <select>
                        <c:forEach items="${requestScope.list2}" var="i">
                            <option><a href="markavg?cid=${i.cid}">${i.cid}</a></option>
                        </c:forEach>
                    </select>
                </div>
                
                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px">
                    <div style="padding-top: 40px">
                        <table style="width:90%;margin:0 auto">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                    <th class="col-md-3">Mã HS</th>
                                    <th class="col-md-3">Mã lớp</th>
                                    <th class="col-md-3">Trung bình</th>
                                    <th class="col-md-3">Năm học</th>                                  
                                </tr>
                            </thead>

                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;line-height: 50px;font-weight: 500">
                                        <th class="col-md-3">${i.sid}</th>
                                        <th class="col-md-3">${i.cid}</th>
                                        <th class="col-md-3">${i.avg}</th>
                                        <th class="col-md-3">${i.years}</th> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>          
            </div>
        </div>
    </div>
</body>
</html>
