<%-- 
    Document   : login
    Created on : Feb 8, 2020, 1:00:14 AM
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
        <h1>Login</h1>
        <div>
            <form action="login" method="POST">
                Username: <input type="text" name="username"><br>
                Password: <input type="password" name="password"><br>
                <input type="submit" value="Log In"><br>
            </form>
            
            ${message}
        </div>
    </body>
</html>
