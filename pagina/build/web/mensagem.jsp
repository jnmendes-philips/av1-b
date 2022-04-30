<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3> <%= (String) request.getAttribute("msg") %> </h3>
        <a href="index.html">Retornar ao início</a>
    </body>
</html>
