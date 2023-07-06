<%-- 
    Document   : addclass
    Created on : 23-06-2023, 00:35:15
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
        <link href="css/addstudentcss.css" rel="stylesheet">
        <link href="css/studentlistcss.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="homepageheader.jsp" %>
        <div class="row">
            <%@include file="homepagemenu.jsp" %>
            <div class="col-md-10 r123"  style="margin-bottom: 100px">
                <div>
                    <div style="background-color: white;width:900px;padding:20px 40px 20px 40px;border-radius: 15px;margin:50px auto 150px auto">
                        <div>
                            <h3 style="padding:20px;width:300px">Thêm lớp học</h3>
                        </div>
                        <div style="text-align: center">
                            <p style="color:red">${Error}</p>
                        </div>
                        <div style="text-align: center">
                            <p style="color:green">${txt}</p>
                        </div>
                        <form action="addclass" method="post">
                            <div style="margin: 20px;display: flex">
                                <p style="margin-left: 80px;margin-bottom: 0;font-weight: 500;font-size: 20px;line-height: 40px;margin-right: 50px;width: 85px">Mã lớp</p>
                                <div style="text-align: center">
                                    <input  type="text" name="cid" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF;width:400px" required/>
                                </div>
                            </div>

                            <div style="margin: 20px;display: flex">
                                <p style="margin-left: 80px;margin-bottom: 0;font-weight: 500;font-size: 20px ;line-height: 40px;margin-right: 50px;width: 85px">Tên lớp</p>
                                <div style="text-align: center">
                                    <input type="text" name="name" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF;width:400px" required/>
                                </div>
                            </div>
                            
                            <div style="margin: 20px;display: flex">
                                <p style="margin-left: 80px;margin-bottom: 0;font-weight: 500;font-size: 20px ;line-height: 40px;margin-right: 50px;width: 85px">Năm học</p>
                                <div style="text-align: center">
                                    <input type="text" name="year" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF;width:400px"required/>
                                </div>
                            </div>
                            
                            <div style="margin: 20px;display: flex">
                                <p style="margin-left: 80px;margin-bottom: 0;font-weight: 500;font-size: 20px ;line-height: 40px;margin-right: 50px;width: 85px">GVCN</p>
                                <div>
                                    <select name="tid" style="width: 80px;text-align: center;height: 35px;margin-top: 6px;margin-left: 30px;border-radius: 10px">
                                        <c:forEach items="${requestScope.list}" var="i">
                                            <option value="${i.tid}">${i.tid}</option>
                                        </c:forEach>
                                    </select>                           
                                </div>
                            </div>
                            <div style="text-align: center;margin-bottom: 30px">
                                <input class="submitbut" type="submit" value="Xác nhận" style="line-height: 40px;width: 150px;border-radius: 10px;border: 1px solid #DFDFDF;background-color: #3d5ee1;color: white"/>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
    </body>
</html>
