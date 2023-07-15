<%-- 
    Document   : home
    Created on : 04-06-2023, 20:43:04
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import="model.beststudent"%>
<%@page import="model.bestclasses"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/homecss.css" rel="stylesheet">
        <link href="./font/cssfont/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <%
                    int stlsize =(int) request.getAttribute("stlistsize");
                    int tlsize =(int) request.getAttribute("teacherlistsize");
                    int clsize =(int) request.getAttribute("classlistsize");
                    ArrayList<beststudent> bstlist = (ArrayList<beststudent>) request.getAttribute("bestst");
                    ArrayList<bestclasses> bcllist = (ArrayList<bestclasses>) request.getAttribute("bestclasses");
            %>
            <div class="col-md-10 r123">
                <div>
                    <h3 style="margin: 20px">Welcome admin</h3>
                </div>
                <div style="background-color: #FFE9F0;line-height: 60px;border-radius: 10px">
                    <p style="color: red;text-align: center">${error}</p>
                </div>
                <div style="width:100%;">
                    <div class="row rightpart" >
                        <div class="col-md-4">
                            <div class=" spart">
                                <i class="fa-solid fa-users fa-3x"></i>
                                <div>
                                    <p>Số học sinh: <%=stlsize%></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class=" spart">
                                <i class="fa-solid fa-person-chalkboard fa-3x"></i>
                                <div>
                                    <p>Số giáo viên: <%=tlsize%></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="spart">
                                <i class="fa fa-book-open-reader fa-3x"></i>
                                <div>
                                    <p>Số lớp học: <%=clsize%></p>
                                </div>
                            </div>
                        </div>              
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 student-box">
                        <div class="box2">
                            <h4>Học sinh xuất sắc</h4>
                            <table class="sttable">
                                <tr class="thead">
                                    <th style="width:70px">Mã HS</th>
                                    <th style="width:200px">Họ & Tên</th>
                                    <th style="width:80px">Lớp</th>
                                    <th style="width:80px">Điểm</th>
                                    <th style="width:74px">Năm học</th>
                                </tr>
                                <%for(beststudent i: bstlist){%>
                                <tr>
                                    <th><%=i.getSid()%></th>
                                    <th><%=i.getName()%></th>
                                    <th><%=i.getClassname()%></th>
                                    <th><%=i.getAvg()%></th>
                                    <th><%=i.getYears()%></th>
                                </tr>
                                <%}%>
                            </table>
                        </div>
                    </div>

                    <div class="col-md-6 class-box">
                        <div class="box2">
                            <h4>Lớp học xuất sắc</h4>
                            <table class="cltable">
                                <tr class="thead">
                                    <th style="width:80px">Mã lớp</th>
                                    <th style="width:100px">Tên lớp</th>
                                    <th style="width:110px">Tổng số HS</th>
                                    <th style="width:70px">Số HSG</th>
                                    <th style="width:70px">Năm học</th>
                                </tr>
                                <%for(bestclasses u: bcllist){%>
                                <tr>
                                    <th><%=u.getcID()%></th>
                                    <th><%=u.getClassname()%></th>
                                    <th><%=u.getNumofst()%></th>
                                    <th><%=u.getNumofgoodst()%></th>
                                    <th><%=u.getYears()%></th>
                                </tr>
                                <%}%>
                            </table>
                        </div>
                    </div>
                </div>
                <%@include file="homepagefooter.jsp" %>
            </div>

        </div>

        <script>
            function showdropdown() {
                var a = document.getElementById('dropdown');
                if (a.style.display !== 'block') {
                    a.style.display = 'block';

                } else {
                    a.style.display = 'none';
                }
            }
            function menudown(id) {
                var b = document.getElementById(id);
                if (b.style.display !== 'block') {
                    b.style.display = 'block';
                } else {
                    b.style.display = 'none';
                }
            }
        </script>
    </body>


</html>
