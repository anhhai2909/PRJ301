<%-- 
    Document   : timetable
    Created on : 26-06-2023, 10:18:31
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

                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px;margin-bottom: 40px;margin-right: 10px;margin-top: 50px">
                    <div>
                        <h3 style="padding:20px;width:300px">Thời khóa biểu</h3>
                    </div>
                    <div>
                        <div class="pagination" style="margin-left:20px;padding: 10px 0 0px 50px">
                            <p style="width: 100px;text-align: left;font-weight: 500;line-height: 30px;margin:auto 0">Chọn lớp</p>
                            <c:forEach items="${requestScope.list2}" var="i">
                                <a id="page-${i.cid}" class="page-link" href="timetable?cid=${i.cid}" style="border:1px solid #DFDFDF;padding:5px 10px 2px 10px;border-radius: 5px;line-height: 30px;width:70px">${i.cid}</a>
                            </c:forEach>

                            <div style="margin: auto 0;margin-left: 540px">
                                <a href="timetableupdate?cid=${requestScope.cid}" class="option-icon"><i class="fa-solid fa-pen"></i></a><a href="#" class="option-icon"><i class="fa-solid fa-trash"></i></a>
                            </div>

                        </div>
                    </div>
                    <div style="padding-top: 20px">
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
                                        <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500">${requestScope.listt2[i]}</th>
                                        <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500">${requestScope.listt3[i]}</th>
                                        <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500">${requestScope.listt4[i]}</th>      
                                        <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500">${requestScope.listt5[i]}</th>
                                        <th class="col-md-2" style="border-right: 1px solid #DFDFDF;font-weight: 500">${requestScope.listt6[i]}</th>       
                                        <th class="col-md-1"></th>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var currentPage = "${requestScope.cid}";
                var pageLinks = document.getElementsByClassName("page-link");

                for (var i = 0; i < pageLinks.length; i++) {
                    var pageLink = pageLinks[i];
                    var pageNumber = pageLink.innerHTML;

                    if (pageNumber === currentPage) {
                        pageLink.classList.add("active");
                    }
                }

            });
        </script>
    </body>
</html>
