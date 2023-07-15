<%-- 
    Document   : markupdate
    Created on : 02-07-2023, 21:36:37
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

                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px;margin-top: 50px;margin-bottom: 90px">
                    <div>
                        <h3 style="padding:20px;width:300px;padding-top: 30px">Sửa điểm</h3>
                    </div>

                    <div style="background-color: #E1FFEA;line-height: 60px;border-radius: 10px">
                        <p style="color: green;text-align: center">${txt}</p>
                    </div>

                    <div style="background-color: #FFE9F0;line-height: 60px;border-radius: 10px">
                        <p style="color: red;text-align: center">${error}</p>
                    </div>
                    <div>
                        <form action="markupdate" method="post">
                            <table style="width:90%;margin:0 auto">
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                        <th class="col-md-1">Mã HS</th>
                                        <th class="col-md-1">m1</th>
                                        <th class="col-md-1">m2</th>
                                        <th class="col-md-1">pt1</th>
                                        <th class="col-md-1">pt2</th>
                                        <th class="col-md-1">mt</th>
                                        <th class="col-md-1">fe</th>                                        
                                        <th class="col-md-1">Môn</th> 
                                        <th class="col-md-2">Năm học</th>
                                        <th class="col-md-2"></th>

                                    </tr>
                                </thead>

                                <tbody style="text-align: center">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;line-height: 50px;font-weight: 500">
                                        <th class="col-md-1"><input type="text" name="sid" value="${requestScope.m.sid}" readonly style="text-align: center;width: 60px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-1"><input type="text" name="m1" value="${requestScope.m.m1}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-1"><input type="text" name="m2" value="${requestScope.m.m2}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-1"><input type="text" name="pt1" value="${requestScope.m.pt1}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-1"><input type="text" name="pt2" value="${requestScope.m.pt2}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-1"><input type="text" name="mt" value="${requestScope.m.mt}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-1"><input type="text" name="fe" value="${requestScope.m.fe}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>                                           
                                        <th class="col-md-1"><input type="text" name="suid" value="${requestScope.m.suid}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4" readonly/></th>
                                        <th class="col-md-2"><input type="text" name="years" value="${requestScope.years}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4" readonly/></th>
                                        <th class="col-md-2"><input type="submit" value="Xác nhận" style="text-align: center;width: 90%;line-height: 35px"/></th>  
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>                   
                </div>
            </div>
    </body>
</html>
