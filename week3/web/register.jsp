<%-- 
    Document   : register
    Created on : 14 Oct, 2024, 9:03:51 PM
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
        <h1 style='color: seagreen'>Registration Page</h1>
        <form action="register" method="POST">
            UserName: <input type="text" name="UserName">
            <br /> <br /> <!-- For line change -->
            Email: <input type="email" name="UserEmail">
            <br /> <br />
            Password: <input type="password" name="Password">
            <br /> <br />
            Confirm Password: <input type="password" name="confirmPassword">
            <br /> <br />
            <input type="submit" name="loginSubmit">   
        </form>
    </body>
</html>