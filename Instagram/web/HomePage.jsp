<%-- 
    Document   : HomePage
    Created on : 1 Oct, 2024, 11:26:11 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1 style="background-color: pink">HOMEPAGE
        </h1>
        <h2 style="color:blue;">Welcome:<%=request.getAttribute("UserName")%>;</h2>
                
    </body>
</html>
