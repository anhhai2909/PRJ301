<%-- 
    Document   : marklist
    Created on : 25-06-2023, 20:06:04
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
                    <h3 style="padding:20px;width:300px">Danh sách điểm</h3>
                </div>
                <div style="padding-left: 40px;background-color: white;height: 80px;border-radius: 15px;margin:0 auto 20px auto">
                    <form action="" method="" style="text-align: center;padding-top:25px">
                        <div class="row">
                            <div class="col-md-3">
                                <div style="display:flex">
                                    <p style="margin: auto 0;font-weight: 500;font-size: 20px;margin-right: 20px">Năm học</p>
                                    <select style="text-align: center;width:100px;height: 30px">
                                        <c:forEach items="${requestScope.list2}" var="i">
                                            <option>${i.year}</option>>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div style="display:flex">
                                    <p style="margin: auto 0;font-weight: 500;font-size: 20px;margin-right: 20px">Lớp</p>
                                    <select style="text-align: center;width:100px;height: 30px">
                                        <c:forEach items="${requestScope.list3}" var="i">
                                            <option>${i.cid}</option>>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div style="display:flex">
                                    <p style="margin: auto 0;font-weight: 500;font-size: 20px;margin-right: 20px">Lựa chọn</p>
                                    <select style="text-align: center;width:100px;height: 30px">
                                        <c:forEach items="${requestScope.list4}" var="i">
                                            <option>${i.suid}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-3" style="text-align: left">
                                <input type="submit" value="Tìm kiếm"style="line-height: 30px;width: 100px;border-radius: 10px;border: 1px solid #DFDFDF;background-color: #3d5ee1;color: white"/>
                            </div>
                        </div>

                    </form>
                </div>

                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px">
                    <div style="padding-top: 40px">
                        <table style="width:90%;margin:0 auto">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                    <th class="col-md-2">Mã HS</th>
                                    <th class="col-md-1">m1</th>
                                    <th class="col-md-1">m2</th>
                                    <th class="col-md-1">pt1</th>
                                    <th class="col-md-1">pt2</th>
                                    <th class="col-md-1">mt</th>
                                    <th class="col-md-2">fe</th>
                                    <th class="col-md-1">avg</th>         
                                    <th class="col-md-2">Tùy chọn</th>
                                </tr>
                            </thead>

                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;font-weight: 500;line-height: 40px">
                                        <th class="col-md-2" style="margin: auto 0">${i.sid}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.m1}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.m2}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.pt1}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.pt2}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.mt}</th>
                                        <th class="col-md-2" style="margin: auto 0">${i.fe}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.avag}</th> 
                                        <td class="col-md-2" style="padding-left: 0;margin: auto 0"><a href="markupdate?sid=${i.sid}&suid=${i.suid}&years=${i.years}" class="option-icon"><i class="fa-solid fa-pen"></i></a><a href="#" class="option-icon"><i class="fa-solid fa-trash"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div style="margin-bottom:100px;">
                    <c:set var="page" value="${requestScope.page}"/>
                    <div class="pagination" style="margin-left: 30px">
                        <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                            <a id="page-${i}" class="page-link" href="marklist?page=${i}">${i}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var currentPage = "${requestScope.page}";
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
