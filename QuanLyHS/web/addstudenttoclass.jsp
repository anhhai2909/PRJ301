<%-- 
    Document   : addstudenttoclass
    Created on : 01-07-2023, 22:41:43
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
        <link href="css/classlistcss.css" rel="stylesheet">   
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="padding-right: 25px;margin-bottom: 100px" >

                <div style="background-color: white;padding:10px 30px 60px 30px;margin: 50px 10px 60px 10px;border-radius: 15px">
                    <div>
                        <h3 style="padding:20px;width:250px">Thêm học sinh</h3>
                    </div> 
                    
                    <div style="margin-top: 10px;margin-bottom: 30px">
                        <form action="" method="get">
                            <div class="row" style="width: 50%" >
                                <div class="col-md-8" style="text-align: center">
                                    <input type="text" name="id" placeholder="  Tìm theo mã HS..." style="line-height: 35px;width: 70%;border-radius: 10px;border: 1px solid black"/>
                                </div>

                                <div class="col-md-4">
                                    <input type="submit" class="submit-but" value="Tìm kiếm"/>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="row" >
                        <div class="col-md-4" style="padding: 0 5px 0 5px">
                            <table style="width:100%;">
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">                       
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px">
                                        <th class="col-md-3">ID</th>
                                        <th class="col-md-6">Tên</th>
                                        <th class="col-md-3" style="padding-left: 0">Tùy chọn</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center">
                                    <c:forEach items="${requestScope.list1}" var="i">
                                        <tr class="row table-body" style="margin-top:15px;">
                                            <td class="col-md-3">${i.sID}</td>
                                            <td class="col-md-6">${i.name}</td>                                 
                                            <td class="col-md-3" style="padding-left: 0"><a href="stprofile?id=${i.sID}" class="option-icon"><i class="fa-solid fa-plus"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="col-md-4" style="padding: 0 5px 0 5px">
                            <table style="width:100%;">
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">                       
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px">
                                        <th class="col-md-3">ID</th>
                                        <th class="col-md-6">Tên</th>
                                        <th class="col-md-3" style="padding-left: 0">Tùy chọn</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center">
                                    <c:forEach items="${requestScope.list2}" var="i">
                                        <tr class="row table-body" style="margin-top:15px">
                                            <td class="col-md-3">${i.sID}</td>
                                            <td class="col-md-6">${i.name}</td>                                 
                                            <td class="col-md-3" style="padding-left: 0"><a href="stprofile?id=${i.sID}" class="option-icon"><i class="fa-solid fa-plus"></i></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="col-md-4" style="padding: 0 5px 0 5px">
                            <table style="width:100%;">
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">                       
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px">
                                        <th class="col-md-3">ID</th>
                                        <th class="col-md-6">Tên</th>
                                        <th class="col-md-3" style="padding-left: 0">Tùy chọn</th>
                                    </tr>
                                </thead>
                                <tbody style="text-align: center">
                                    <c:forEach items="${requestScope.list3}" var="i">
                                        <tr class="row table-body" style="margin-top:15px">
                                            <td class="col-md-3">${i.sID}</td>
                                            <td class="col-md-6">${i.name}</td>                                 
                                            <td class="col-md-3" style="padding-left: 0"><a href="stprofile?id=${i.sID}" class="option-icon"><i class="fa-solid fa-plus"></i></a></td>
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
