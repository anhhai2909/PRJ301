<%-- 
    Document   : addsubject
    Created on : 25-06-2023, 15:05:06
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import = "model.subject"%>
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
                    <h3 style="padding:20px;width:300px">Thêm môn học</h3>
                </div>

                <div style="width: 700px;background-color: white;border-radius: 15px;margin: 0 auto 100px auto;padding-top:40px;padding-bottom:40px">
                    <form action="" method="get">
                        <div style="margin-bottom: 20px">
                            <p style="margin-left: 150px;margin-bottom: 0;font-weight: 500;font-size: 20px;">Mã môn</p>
                            <div style="text-align: center">
                                <input type="text" name="id" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF;width:400px"/>
                            </div>
                        </div>

                        <div style="margin-bottom: 20px">
                            <p style="margin-left: 150px;margin-bottom: 0;font-weight: 500;font-size: 20px">Tên môn</p>
                            <div style="text-align: center">
                                <input type="text" name="name" style="line-height: 40px;border-radius: 10px;border:1px solid #DFDFDF;width:400px"/>
                            </div>
                        </div>

                        <div style="margin-bottom: 20px">
                            <p style="margin-left: 150px;margin-bottom: 0;font-weight: 500;font-size: 20px">Mô tả</p>
                            <div style="text-align: center">
                                <textarea rows="5" cols="50" name="descript"style="border-radius: 10px;border:1px solid #DFDFDF;width:400px;"> 
                                </textarea>
                            </div>
                        </div>


                        <div style="text-align: center">
                            <input class="submitbut" type="submit" value="Xác nhận" style="line-height: 40px;width: 150px;border-radius: 10px;border: 1px solid #DFDFDF;background-color: #3d5ee1;color: white"/>
                        </div>
                    </form>

                </div>

            </div>
        </div>
    </body>
</html>
