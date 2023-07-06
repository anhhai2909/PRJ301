<%-- 
    Document   : studentlist
    Created on : 14-06-2023, 04:51:51
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123"  style="margin-bottom: 100px">
                <div style="margin-top: 30px">
                    <form action="stsearch" method="get">
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
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px">
                                    <th class="col-md-1">ID</th>
                                    <th class="col-md-3">Tên</th>
                                    <th class="col-md-1">Giới tính</th>
                                    <th class="col-md-2">Ngày sinh</th>
                                    <th class="col-md-2">Email</th>
                                    <th class="col-md-2">SDT</th>
                                    <th class="col-md-1" style="padding-left: 0">Tùy chọn</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="margin-top:10px">
                                        <td class="col-md-1">${i.sID}</td>
                                        <td class="col-md-3">${i.name}</td>
                                        <c:set var = "g" scope = "request" value = "${i.gender}"/>
                                        <c:if test="${g==1}">
                                            <td class="col-md-1">Nam</td>
                                        </c:if>
                                        <c:if test="${g==0}">
                                            <td class="col-md-1">Nữ</td>
                                        </c:if>
                                        <td class="col-md-2">${i.dob}</td>
                                        <td class="col-md-2">${i.email}</td>
                                        <td class="col-md-2">${i.phone}</td>
                                        <td class="col-md-1" style="padding-left: 0"><a href="stprofile?id=${i.sID}" class="option-icon"><i class="fa-solid fa-eye"></i></a><a href="#" class="option-icon"><i class="fa-solid fa-trash"></i></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                
                
                <div style="margin-bottom:100px">
                    <c:set var="page" value="${requestScope.page}"/>
                    <div class="pagination">
                        <c:forEach items="${requestScope.pagelist}" var="i">
                            <a id="page-${i}" class="page-link" href="studentlist?page=${i}">${i}</a>
                        </c:forEach>
                    </div>
                </div>

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
