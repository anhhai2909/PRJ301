<%-- 
    Document   : studentlist
    Created on : 14-06-2023, 04:51:51
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.teacher"%>
<%@page import = "model.Student"%>
<%@page import = "java.util.ArrayList"%>
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
            <div class="col-md-10 r123" >
                <div style="margin-top: 30px">
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
                
                <div>
                    <%
                    int num =(int) request.getAttribute("num");
                    %>
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
                                    <th class="col-md-1">Giới tính</th>
                                    <th class="col-md-2">Ngày sinh</th>
                                    <th class="col-md-2">Email</th>
                                    <th class="col-md-2">SDT</th>
                                    <th class="col-md-1" style="padding-left: 0">Tùy chọn</th>
                                </tr>
                            </thead>
                            
                            <tbody style="text-align: center">
                                <%
                                    ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");
                                    for(Student i:list){
                                %>
                                <tr class="row" >
                                    <th class="col-md-1" style="font-weight: 500;margin-bottom: 10px;"><%=i.getsID()%></th>
                                    <th class="col-md-3" style="font-weight: 500;margin-bottom: 10px;"><%=i.getName()%></th>
                                    <%
                                        String g="";
                                        if(i.getGender()==1){
                                            g="Nam";
                                        }else{
                                            g="Nữ";
                                        }
                                    %>
                                    <th class="col-md-1" style="font-weight: 500;margin-bottom: 10px;"><%=g%></th>                                  
                                    <th class="col-md-2" style="font-weight: 500;margin-bottom: 10px;"><%=i.getDob()%></th>
                                    <th class="col-md-2" style="font-weight: 500;margin-bottom: 10px;"><%=i.getEmail()%></th>
                                    <th class="col-md-2" style="font-weight: 500;margin-bottom: 10px;"><%=i.getPhone()%></th>
                                    <th class="col-md-1" style="padding-left: 0">Tùy chọn</th>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
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
        </script>
    </body>
</html>
