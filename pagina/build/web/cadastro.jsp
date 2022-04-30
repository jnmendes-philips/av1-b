<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Servlet" method="post">
            Nome: <input type="text" name="name"> <br>
            Dominio: <input type="text" name="domain"> <br>
            Ano: <input type="text" name="year"> <br>
            Industria: <input type="text" name="industry"> <br>
            Tamanho: <input type="text" name="size"> <br>
            Localizacao: <input type="text" name="locality"> <br>
            Pais: <input type="text" name="country"> <br>
            Linkedin: <input type="text" name="linkedin"> <br>
            Empregados atuais: <input type="text" name="actual"> <br>
            Empregados totais: <input type="text" name="total"> <br>
            <input type="hidden" name="parent" value="cadastro">
            <input type="submit" value="Cadastrar">
        </form>
        <a href="index.html">Retornar ao início</a>
    </body>
</html>
