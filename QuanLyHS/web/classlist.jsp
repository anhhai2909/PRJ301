<%-- 
    Document   : classlist
    Created on : 22-06-2023, 22:04:20
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
        <link href="css/classlistcss.css" rel="stylesheet">     
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123" style="padding-right: 25px;margin-bottom: 100px" >
                <div style="background-color: white;border-radius: 10px;width: 90%;margin: 50px auto 10px auto;padding: 20px 0 20px 0">
                    <div>
                        <div class="pagination" style="margin-left:20px">
                            <p style="width: 100px;text-align: left;font-weight: 500;line-height: 30px;margin:auto 0">Năm học </p>
                            <c:forEach items="${requestScope.list2}" var="i">
                                <a id="page-${i.year}" class="page-link" href="classlist?y=${i.year}" style="border:1px solid #DFDFDF;padding:5px 10px 2px 10px;border-radius: 5px;line-height: 30px;width:70px">${i.year}</a>
                            </c:forEach>                      
                        </div>
                    </div>
                </div>

                <div style="background-color: white;border-radius: 10px;margin-bottom: 100px;padding-bottom: 50px;width: 90%;margin: 10px auto 70px auto">
                    <div>
                        <h3 style="padding:20px;width:200px;padding-top: 40px">Lớp học</h3>
                    </div>
                    <div style="padding-top: 20px">
                        <table style="width:80%;margin:0 auto">
                            <thead style="text-align: center;width:100%;background-color: #FBFBFB">
                                <tr class="row" style="margin-top:10px;margin-bottom: 10px;margin-left: 0;margin-right: 0;">
                                    <th class="col-md-2">Mã lớp</th>
                                    <th class="col-md-3">Tên lớp</th>
                                    <th class="col-md-3">Số HS</th>
                                    <th class="col-md-2">GVCN</th>
                                    <th class="col-md-2">Tùy chọn</th>
                                </tr>
                            </thead>

                            <tbody style="text-align: center">
                                <c:forEach items="${requestScope.list}" var="i">
                                    <tr class="row table-body" style="width:100%;;margin-left: 0;margin-right: 0;border-bottom: 1px solid #E4E4E4;line-height: 50px;font-weight: 500">
                                        <td class="col-md-2">${i.cid}</td>
                                        <td class="col-md-3">${i.name}</td>
                                        <td class="col-md-3">${i.numofst}</td>
                                        <td class="col-md-2">${i.tid}</td>
                                        <td class="col-md-2" style="padding-left: 0"><a href="classprofile?cid=${i.cid}&y=${requestScope.y}" class="option-icon"><i class="fa-solid fa-eye"></i></a><a href="#" onclick="Warning('${requestScope.y}', '${i.cid}','${requestScope.page}')" class="option-icon"><i class="fa-solid fa-trash"></i></a></td>
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
                var currentPage = "${requestScope.y}";
                var pageLinks = document.getElementsByClassName("page-link");
                for (var i = 0; i < pageLinks.length; i++) {
                    var pageLink = pageLinks[i];
                    var pageNumber = pageLink.innerHTML;

                    if (pageNumber === currentPage) {
                        pageLink.classList.add("active");
                    }
                }
            });
            function Warning(y, cid,page) {
                var option = confirm("Xóa lớp học?");
                if (option === true) {
                    window.location.href = 'deleteclass?cid=' + cid + '&y=' + y+'&page='+page;
                }
            }
        </script>
    </body>
</html>
