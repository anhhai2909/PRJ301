<%-- 
    Document   : studentlist
    Created on : 14-06-2023, 04:51:51
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import = "model.teacher"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link href="css/homecss.css" rel="stylesheet">
        <link href="css/studentlistcss.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="row">



            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" >
                <div>
                    <form action="" method="get">
                        <div class="row">
                            <div class="col-md-4 search" style="text-align: center">
                                <input type="text" name="id" placeholder="Tìm theo mã HS..."/>
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
                <div class="stlist">
                    <div>
                        <h3 style="padding:20px;width:200px">Học sinh</h3>
                    </div>
                    <div>
                        <table style="width:100%;">
                            <thead style="text-align: center">
                                <tr class="row" >
                                    <th class="col-md-1">ID</th>
                                    <th class="col-md-3">Tên</th>
                                    <th class="col-md-1">Lớp</th>
                                    <th class="col-md-2">Ngày sinh</th>
                                    <th class="col-md-2">Email</th>
                                    <th class="col-md-2">SDT</th>
                                    <th class="col-md-1" style="padding-left: 0">Tùy chọn</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
