<%-- 
    Document   : login
    Created on : 8 Feb, 2025, 11:18:47 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
        <!--<link href="css/loginstyle.css" rel="stylesheet" type="text/css"/>!-->
        <link href="WEB-INF/loginstyle.css" rel="stylesheet" type="text/css"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <div class="wrapper">
            <form action="Login" method="POST">
                <h1>Login</h1>
                <div class="input-box">
                    <input type="text" placeholder="Enter Your Name" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Enter Your Password" required>
                    <i class='bx bxs-lock-alt'></i>
                   
                </div>
            
                <div class="remember-forgot">
                    <label><input type="checkbox">Remember me</label>
                    <a href="#">Forgot password?</a></div>
                <button type="submit" class="btn">Login</button>
                <div class="register-link">
                    <p>Don't have an account?<a href="#">Register</a></p>
                </div>
            </form>
        </div>       
        
    </body>
</html>
