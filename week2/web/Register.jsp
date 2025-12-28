<%-- 
    Document   : demoregister
    Created on : 7 Oct, 2024, 2:31:53 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
        <head>
            <title>registration page</title>
        </head>
        <body>
            <form action="Register" method="Post">
                <h1><br>Register here!!</h1>
                Name:<input type="text" name="name1"/><br/><br/>
                Email:<input type="text" name="email"/><br/><br/>
                Password:<input type="password" name="pass1"/><br/><br/>
                Gender:<input type="radio" name="gender1" value="Male"/>Male
                <input type="radio" name="gender1" value="Female"/>Female<br/><br/>
                City:<select name="city1">
                    <option>Select city</option>
                    <option>Delhi</option>
                    <option>Mumbai</option>
                    <option>Pune</option>
                    <option>Bangalore</option>
                </select><br/><br/>
                <input type="submit" value="Register"/>
            </form>
        </body>
    </html>
