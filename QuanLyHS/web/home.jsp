<%-- 
    Document   : home
    Created on : 01-06-2023, 21:11:04
    Author     : anhha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.news"%>
<jsp:include page="/newsservlet" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/homecss.css"  rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">     
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div class="header">
                <div>
                    <img src="img/logo2.png" class="logo2">
                </div>

                <a href="#">THPT Yên Tân số 1</a>

            </div>

            <div class="body-info">
                <div class="news">
                    <%
                        ArrayList<news> list = (ArrayList<news>) request.getAttribute("newslist");
                        
                    %>
                    <div class="new">
                        <div class="new-header">
                            <p class="tb">Thông Báo</p>
                        </div>

                        <div class="new-info">
                            <%                          
                                for(int i =list.size()-1; i>=0;i-- ){
                            %>

                            <p class="shorttb"><%=list.get(i).getShortd()%></p>         
                            
                            <div class="npopup">
                                <p><%=list.get(i).getShortd()%></p>
                                <p><%=list.get(i).getInfo()%></p>
                            </div>
                            <%
                                }
                            %>
                        </div>                                                               
                    </div>


                </div>
                        
                <div class="info" >
                    <p >asd</p>
                </div>
                        
                        
                <%
                    application.setAttribute("appName","My App");
                %>
                <p>App Name: ${applicationScope.appname}</p>
                

            </div>
        </div>

    </body>
</html>
