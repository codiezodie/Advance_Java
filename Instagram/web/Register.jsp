<%-- 
    Document   : Register
    Created on : 1 Oct, 2024, 11:25:57 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <h1>Register</h1>
            <!-- Added form element -->
            <form action="submit_registration.jsp" method="post"> <!-- Adjust action as per your requirement -->
                <div class="input-box">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="Username" placeholder="Enter your name" required>
                </div>
                
                <div class="input-box">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="Password" placeholder="Enter the password" required>
                </div>
                
                <div class="input-box">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="Email" placeholder="Enter your E-mail" required>
                </div>
                
                <div class="input-box">
                    <label for="confirmpassword">Confirm Password:</label>
                    <input type="password" id="confirmpassword" name="confirmpassword" placeholder="Confirm Password" required>
                </div>

                <div class="sub-btn">
                    <input type="submit" class="btn" value="Submit">
                </div>
            </form>
        </div>  
    </body>
</html>