<%-- 
    Document   : sendMessage
    Created on : 15 Oct, 2024, 10:35:16 AM
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
        <h1 style="color:red"><b>Message box</h1>
        <form action="sendMessage" method="POST">
            Sender: <input type="text" name="SenderName"> <br /><br/>
            Receiver:<input type="text" name="ReceiverName"> <br /><br/>
            Message:<input type="text" name="Message"><br/><br/>
             <input type="submit" name="loginSubmit">
             
        </form>
    </body>
</html>
