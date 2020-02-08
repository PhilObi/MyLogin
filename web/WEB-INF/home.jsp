<%-- 
    Document   : home
    Created on : Feb 8, 2020, 12:24:30 PM
    Author     : Phillip Obiora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Page!</h1>
        Hello ${sessionScope.username}.<br>
        <a href="login?logout=true">Logout</a>
    </body>
</html>
