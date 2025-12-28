<%-- 
    Document   : register
    Created on : 13 Oct, 2024, 9:21:33 PM
    Author     : HP
--%>

<%-- 
    Document   : Register
    Created on : 1 Oct 2024, 9:50:08 am
    Author     : Prabhakar Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Page</h1>
        <form action="Register" method="POST">
            UserName: <input type="text" name="userName">
            <br /> <br /> <!-- For line change -->
            Email: <input type="email" name="userEmail">
            <br /> <br />
            Password: <input type="password" name="password">
            <br /> <br />
            Confirm Password: <input type="password" name="confirmPassword">
            <br /> <br />
            <input type="submit" name="loginSubmit">   
        </form>
    </body>
</html>