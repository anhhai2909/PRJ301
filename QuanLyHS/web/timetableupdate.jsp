<%-- 
    Document   : timetableupdate
    Created on : 03-07-2023, 16:22:28
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.timetable"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/homecss.css" rel="stylesheet">
        <link href="css/markavgcss.css" rel="stylesheet">
        <link href="css/studentlistcss.css" rel="stylesheet">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp"%>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10" style="background-color: #f7f7fa;margin-bottom: 100px">

                <div>
                    <h3 style="padding:20px;width:300px">Sửa TKB</h3>
                </div>
                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px;padding-top: 30px;margin-bottom: 70px;margin-right: 10px">
                    <div style="padding-top: 20px">
                        <form action="" method="">
                            <div style="text-align: right;margin-bottom: 10px">
                                <input type="submit" value="Xác nhận" style="margin-right: 65px"/>
                            </div>
                            <table style="width:90%;margin:0 auto">
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                        <th class="col-md-1">Slot</th>
                                        <th class="col-md-2">T2</th>
                                        <th class="col-md-2">T3</th>
                                        <th class="col-md-2">T4</th>      
                                        <th class="col-md-2">T5</th>
                                        <th class="col-md-2">T6</th>       
                                        <th class="col-md-1"></th>
                                    </tr>
                                </thead>

                                <tbody style="text-align: center">
                                    <c:forEach var="i" begin="0" end="5">
                                        <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;border-bottom: 1px solid #DFDFDF">
                                            <th class="col-md-1" style="border-right: 1px solid #DFDFDF;font-weight: 500">${i+1}</th>
                                            <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500"><input type="text" name="t2slot+${i+1}" value="${requestScope.listt2[i]}" style="text-align: center;border: none;width:80%"></th>
                                            <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500"><input type="text" name="t2slot+${i+1}" value="${requestScope.listt3[i]}" style="text-align: center;border: none;width:80%"></th>
                                            <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500"><input type="text" name="t2slot+${i+1}" value="${requestScope.listt4[i]}" style="text-align: center;border: none;width:80%"></th>      
                                            <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500"><input type="text" name="t2slot+${i+1}" value="${requestScope.listt5[i]}" style="text-align: center;border: none;width:80%"></th>
                                            <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500"><input type="text" name="t2slot+${i+1}" value="${requestScope.listt6[i]}" style="text-align: center;border: none;width:80%"></th>       
                                            <th class="col-md-1"></th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
