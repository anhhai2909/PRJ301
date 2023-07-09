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
        <link href="css/markavgcss.css" rel="stylesheet">  
        <link href="css/studentlistcss.css" rel="stylesheet"> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="margin-bottom: 100px">
                <div style="background-color: white;border-radius: 15px;padding: 10px 20px 10px 0;margin-bottom: 20px;margin-top: 50px">
                    <form action="marksearch" method="get" style="display:flex">
                        <div>
                            <input type="text" name="searchsid" placeholder=" Tìm theo mã HS" style="margin:20px 20px 15px 20px;line-height: 35px;border-radius: 10px;border:1px solid #DFDFDF"/>
                        </div>
                        
                        <div>
                            <input type="text" name="searchsname" placeholder=" Tìm theo tên" style="margin:20px 20px 15px 20px;line-height: 35px;border-radius: 10px;border:1px solid #DFDFDF"/>
                        </div>
                        
                        <div>
                            <input type="text" name="searchsuid" placeholder=" Tìm theo mã môn" style="margin:20px 20px 15px 20px;line-height: 35px;border-radius: 10px;border:1px solid #DFDFDF"/>
                        </div>
                        
                        <div>
                            <input type="text" name="searchyears" placeholder=" Tìm theo năm học" style="margin:20px 20px 15px 20px;line-height: 35px;border-radius: 10px;border:1px solid #DFDFDF"/>
                        </div>
                        
                        <div class="searchsubmit">
                            <input type="submit"  value="Xác nhận" style="margin:20px 20px 15px 20px;line-height: 35px;border-radius: 10px;border:1px solid #DFDFDF;width: 120px"/>
                        </div>
                    </form>
                </div>
                <div style="background-color: white;border-radius: 15px;padding: 10px 20px 10px 0;margin-bottom: 20px;margin-top: 10px">
                    <div>
                        <div class="pagination" style="margin-left:20px">
                            <p style="width: 100px;text-align: left;font-weight: 500;line-height: 30px;margin:auto 0">Năm học </p>
                            <c:forEach items="${requestScope.list2}" var="i">
                                <a id="page-${i.year}" class="page-link1" href="marklist?y=${i.year}" style="border:1px solid #DFDFDF;padding:5px 10px 2px 10px;border-radius: 5px;line-height: 30px;width:70px">${i.year}</a>
                            </c:forEach>                      
                        </div>
                    </div>

                    <div>
                        <div class="pagination" style="margin-left:20px">
                            <p style="width: 100px;text-align: left;font-weight: 500;line-height: 30px;margin:auto 0">Lớp</p>
                            <c:forEach items="${requestScope.list3}" var="i">
                                <a id="page-${i.cid}" class="page-link2" href="marklist?cid=${i.cid}&y=${requestScope.year}" style="border:1px solid #DFDFDF;padding:5px 10px 2px 10px;border-radius: 5px;line-height: 30px;width:70px">${i.cid}</a>
                            </c:forEach>
                        </div>
                    </div> 

                    <div>
                        <div class="pagination" style="margin-left:20px">
                            <p style="width: 100px;text-align: left;font-weight: 500;line-height: 30px;margin:auto 0">Môn</p>
                            <c:forEach items="${requestScope.list4}" var="i">
                                <a id="page-${i.suid}" class="page-link3" href="marklist?suid=${i.suid}&cid=${requestScope.cid}&y=${requestScope.year}" style="border:1px solid #DFDFDF;padding:5px 10px 2px 10px;border-radius: 5px;line-height: 30px;width:70px">${i.suid}</a>
                            </c:forEach>
                        </div>
                    </div> 
                </div>

                <div style="background-color: white;border-radius: 10px;padding-bottom: 50px;margin-bottom: 80px">
                    <div>
                        <h3 style="padding:20px;width:300px;padding-top: 50px">Danh sách điểm</h3>
                    </div>
                    <div style="padding-top: 10px">
                        <table style="width:95%;margin:0 auto">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                    <th class="col-md-1">Mã HS</th>
                                    <th class="col-md-1">Mã môn</th>
                                    <th class="col-md-2">Năm học</th>
                                    <th class="col-md-1">m1</th>
                                    <th class="col-md-1">m2</th>
                                    <th class="col-md-1">pt1</th>
                                    <th class="col-md-1">pt2</th>
                                    <th class="col-md-1">mt</th>
                                    <th class="col-md-1">fe</th>
                                    <th class="col-md-1">avg</th>         
                                    <th class="col-md-1">Tùy chọn</th>
                                </tr>
                            </thead>

                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="width:100%;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;font-weight: 500;line-height: 40px">
                                        <th class="col-md-1" style="margin: auto 0">${i.sid}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.suid}</th>
                                        <th class="col-md-2" style="margin: auto 0">${i.years}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.m1}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.m2}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.pt1}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.pt2}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.mt}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.fe}</th>
                                        <th class="col-md-1" style="margin: auto 0">${i.avag}</th> 
                                        <td class="col-md-1" style="padding-left: 0;margin: auto 0"><a href="markupdate?sid=${i.sid}&suid=${i.suid}&years=${i.years}" class="option-icon"><i class="fa-solid fa-pen"></i></a></td>
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
                var currentPage1 = "${requestScope.year}";
                var pageLinks1 = document.getElementsByClassName("page-link1");

                var currentPage2 = "${requestScope.cid}";
                var pageLinks2 = document.getElementsByClassName("page-link2");

                var currentPage3 = "${requestScope.suid}";
                var pageLinks3 = document.getElementsByClassName("page-link3");

                for (var i = 0; i < pageLinks1.length; i++) {
                    var pageLink1 = pageLinks1[i];
                    var pageNumber1 = pageLink1.innerHTML;

                    if (pageNumber1 === currentPage1) {
                        pageLink1.classList.add("active");
                    }
                }
                for (var i = 0; i < pageLinks2.length; i++) {
                    var pageLink2 = pageLinks2[i];
                    var pageNumber2 = pageLink2.innerHTML;

                    if (pageNumber2 === currentPage2) {
                        pageLink2.classList.add("active");
                    }
                }
                for (var i = 0; i < pageLinks3.length; i++) {
                    var pageLink3 = pageLinks3[i];
                    var pageNumber3 = pageLink3.innerHTML;

                    if (pageNumber3 === currentPage3) {
                        pageLink3.classList.add("active");
                    }
                }
            });
        </script>
    </body>
</html>
