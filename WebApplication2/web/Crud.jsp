<%-- 
    Document   : Crud
    Created on : 18 Nov, 2024, 6:16:04 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud Operation</title>
    </head>
    <body>
        <h1>User Management</h1>
        <form action="UserServlet" method="Post">
            <input type="hidden" name="action" value="create">
            Name:<input type="text" name="Name"><br><br>
            Email:<input type="email" name="Email"><br><br>
            <button type="submit"> Add User </button>
        </form>
    </body>
</html>
