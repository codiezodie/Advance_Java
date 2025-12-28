<%-- 
    Document   : Login
    Created on : 14 Oct, 2024, 10:47:54 PM
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
        <h1>Login here!!</h1>
        <form action="Login" method="POST">
            UserName: <input type="text" name="UserName"> <br />
            Password: <input type="password" name="Password"> <br />
            
            <input type="submit" name="loginSubmit">
             
        </form>
            
    </body>
</html>