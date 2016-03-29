<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Cadastrar produtos</title>
        <link href="css/jquery-ui.css" rel="stylesheet"> <%-- baixe o projeto no git, se quiser botar o css,
                                                         se nao quiser exclua essas importacoes att.Fabiano--%>
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
    </head>
    <body>
        <h1>Adiciona produtos</h1>
        <hr/>
        <form action="controller?action=ActionCriarProduto" method="POST">
            Nome do produto: <input type="text" name="nomeproduto" value="${produto.nomeProduto}"><br>
            Quantidade: <input type="text" name="quantidadeproduto" value="${produto.quantidade}"><br>
            Valor unitário: <input type="text" name="valorproduto" value="${produto.valorProduto}"><br>

            <c:if test="${ produto.idProduto != 0 }">
                <input type="hidden" name="id" value="${produto.idProduto}">
            </c:if>
            <input type="submit" value="Gravar">
        </form>
    </body>
</html>