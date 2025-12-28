<%-- 
    Document   : Homepage
    Created on : 14 Oct, 2024, 10:49:46 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <h2 style="color:blue;">User:<%=request.getAttribute("UserName")%></h2>
        
    </body>
</html>