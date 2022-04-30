<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="java.sql.SQLException"
        import="java.sql.ResultSet"
        import="dao.DAO"
        import="acesso.Compania"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Servlet" method="post">
            id: <input type="text" name="id">
            <input type="hidden" name="parent" value="listar">
            <input type="submit" value="Filtrar">
        </form>
        <a href="index.html">Retornar ao início</a>
        <table>
            <thead>
                <tr>
                    <th colspan="1">id</th>
                    <th colspan="1">nome</th>
                    <th colspan="1">dominio</th>
                    <th colspan="1">ano</th>
                    <th colspan="1">industria</th>
                    <th colspan="1">tamanho</th>
                    <th colspan="1">localizacao</th>
                    <th colspan="1">pais</th>
                    <th colspan="1">linkedin</th>
                    <th colspan="1">empregados atuais</th>
                    <th colspan="1">empregados totais</th>
                </tr>
            </thead>
            <tbody>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("companias");
        
        while (rs.next()) {
    %>
                <tr>
    <%
            for (int i = 1; i <= 11; i++) {
    %>
                <td>
    <%=
                rs.getString(i)
    %>
                </td>
    <%
            }
    %>
                </tr>
    <%
        }
    %>
                
            </tbody>
        </table>
    <a href="index.html">Retornar ao início</a>
    </body>
</html>
