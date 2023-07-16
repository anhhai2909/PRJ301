<%-- 
    Document   : classprofile
    Created on : 01-07-2023, 20:24:21
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

                <div style="background-color: white;padding-bottom: 40px;margin-bottom: 60px;border-radius: 15px;margin-right: 10px;margin-top: 50px">
                    <div>
                        <h3 style="padding:40px 20px 30px 20px;width:300px;margin-bottom: 5px">Thông tin lớp học</h3>
                    </div>
                    <div style="background-color: #E1FFEA;line-height: 60px;border-radius: 10px">
                        <p style="color: green;text-align: center">${txt}</p>
                    </div>
                    <div style="background-color: #FFE9F0;line-height: 60px;border-radius: 10px">
                        <p style="color: red;text-align: center">${error}</p>
                    </div>

                    <div style="margin-left: 50px;display: flex">
                        <div id="classinfo" style="display:flex;visibility: visible;">
                            <div  style="width: 200px;font-size: 17px;font-weight: 600">
                                <p>Mã lớp: ${requestScope.classes.cid}</p>
                            </div>

                            <div style="width: 200px;font-size: 17px;font-weight: 600">
                                <p>Tên lớp: ${requestScope.classes.name}</p>
                            </div>

                            <div style="width: 200px;font-size: 17px;font-weight: 600">
                                <p>Số HS: ${requestScope.classes.numofst}</p>
                            </div>

                            <div style="width: 200px;font-size: 17px;font-weight: 600">
                                <p>GVCN: ${requestScope.classes.tid}</p>
                            </div>
                        </div>

                        <div style="text-align: right;padding:0 35px 10px 0;width: 400px">
                            <a nohref onclick="showupdatebox()" class="updatebutton"><i class="fa-solid fa-pen fa-xl"></i></a>
                            <a href="loaddata?year=${requestScope.y}&cid=${requestScope.classes.cid}" class="option-icon"><i class="fa-solid fa-square-plus fa-2xl"></i></a>
                        </div>
                    </div>

                    <div style="margin-left: 50px;margin-bottom: 10px">
                        <div id="updatebox" style="visibility: hidden">
                            <form action="classprofileupdate" method="get" style="display: flex">
                                <div  style="width: 200px;font-size: 17px;font-weight: 600;display: flex">
                                    <p style="margin: auto 10px auto 0">Mã lớp: </p>
                                    <input type="text" name="cid" value="${requestScope.classes.cid}"style="width: 70px;text-align: center;border-radius: 10px;border:1px solid #E6E6E6;line-height: 30px" readonly/>
                                </div>

                                <div style="width: 200px;font-size: 17px;font-weight: 600;display: flex">
                                    <p style="margin: auto 10px auto 0">Tên lớp: </p>
                                    <input type="text" name="updatename" value="${requestScope.classes.name}"style="width: 70px;text-align: center;border-radius: 10px;border:1px solid #E6E6E6;line-height: 30px"/>
                                </div>

                                <div style="width: 200px;font-size: 17px;font-weight: 600;display: flex">
                                    <p style="margin: auto 10px auto 0">Số HS: </p>
                                    <input type="text" name="updatenumofst" value="${requestScope.classes.numofst}"style="width: 70px;text-align: center;border-radius: 10px;border:1px solid #E6E6E6;line-height: 30px" readonly/>
                                </div>

                                <div style="width: 200px;font-size: 17px;font-weight: 600;display: flex">
                                    <p style="margin: auto 10px auto 0">GVCN: </p>
                                    <select name="updatetid" style="width: 70px;text-align: center;border-radius: 10px;border:1px solid #E6E6E6;line-height: 30px">
                                        <c:forEach items="${requestScope.list2}" var="i">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div style="width: 200px;font-size: 17px;font-weight: 600;display: flex">
                                    <p style="margin: auto 10px auto 0">Năm học: </p>
                                    <input type="text" name="y" value="${requestScope.y}"style="width: 70px;text-align: center;border-radius: 10px;border:1px solid #E6E6E6;line-height: 30px" readonly/>
                                </div>

                                <div>
                                    <input style="border-radius: 10px;border:1px solid #E6E6E6;line-height: 30px;background-color: #3d5ee1;color:white" type="submit" value="Xác nhận"/>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div style="width: 95%;margin:0 auto">
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
                                    <tr class="row table-body" style="margin-top:15px;border-bottom: 1px solid #E6E6E6;margin-bottom: 0">
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
                                        <td class="col-md-1" style="padding-left: 0"><a href="stprofile?id=${i.sID}" class="option-icon"><i class="fa-solid fa-eye"></i></a><a  href="#" onclick="Warning('${i.sID}', '${requestScope.y}', '${requestScope.classes.cid}')" class="option-icon"><i class="fa-solid fa-trash" ></i></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function showupdatebox() {
                var a = document.getElementById('updatebox');
                var b = document.getElementById('classinfo');
                if (a.style.visibility !== 'visible') {
                    a.style.visibility = 'visible';
                    b.style.visibility = 'hidden';
                } else {
                    a.style.visibility = 'hidden';
                    b.style.visibility = 'visible';
                }
            }
            function Warning(sid, y, cid) {
                var option = confirm("Xóa học sinh?");
                if (option === true) {
                    window.location.href = 'deletestudentinclass?sid=' + sid + '&y=' + y + '&cid=' + cid;
                }
            }
        </script>
    </body>
</html>
