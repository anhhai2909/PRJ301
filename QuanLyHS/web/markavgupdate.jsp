<%-- 
    Document   : markavgupdate
    Created on : 03-07-2023, 09:22:07
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
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="margin-bottom: 100px">

                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px;margin-bottom: 40px;margin-top: 50px">
                    <div>
                        <h3 style="padding:20px;width:300px;padding-top: 30px">Sửa điểm</h3>
                    </div>
                    <div>
                        <form action="" meethod="">
                            <table style="width:90%;margin:0 auto">
                                <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                    <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                        <th class="col-md-2">Mã HS</th>
                                        <th class="col-md-2">Mã lớp</th>
                                        <th class="col-md-3">Trung bình</th>
                                        <th class="col-md-3">Năm học</th>       
                                        <th class="col-md-2"></th>   
                                    </tr>
                                </thead>

                                <tbody style="text-align: center">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;line-height: 50px;font-weight: 500">
                                        <th class="col-md-2"><input type="text" name="sid" value="${requestScope.m.sid}" readonly style="text-align: center;width: 60px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-2"><input type="text" name="cid" value="${requestScope.m.cid}" readonly style="text-align: center;width: 60px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-3"><input type="text" name="avg"  placeholder="${requestScope.m.avg}" style="text-align: center;width: 50px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th>
                                        <th class="col-md-3"><input type="text" name="y" value="${requestScope.m.years}" readonly style="text-align: center;width: 60px;line-height: 35px;border-radius: 5px;border:1px solid #E4E4E4"/></th> 
                                        <th class="col-md-2"><input type="submit" value="Xác nhận" style="text-align: center;width: 90%;line-height: 35px"/></th> 
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div> 

            </div>
        </div>

    </body>
</html>
