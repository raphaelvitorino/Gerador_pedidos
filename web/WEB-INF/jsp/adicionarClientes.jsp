<%-- 
    Document   : cadastrarClientes
    Created on : 15/03/2016, 21:37:52
    Author     : fabiano.eger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="agenda" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Cadastrar clientes</title>
    <link href="css/jquery-ui.css" rel="stylesheet"> <%-- baixe o projeto no git, se quiser botar o css,
                                                     se nao quiser exclua essas importacoes att.Fabiano--%>
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
  </head>
  <body>
    <h1>Adiciona clientes</h1>
    <hr/>
    <form action="controller?action=ActionCadastrarCliente" method="POST">
    	Nome: <input type="text" name="nomecliente" value="${cliente.nomecliente}"><br>
    	E-mail: <input type="text" name="email" value="${cliente.email}"><br>
   
    	<c:if test="${ cliente.idcliente != 0 }">
    		<input type="hidden" name="id" value="${cliente.idcliente}">
    	</c:if>
    	<input type="submit" value="Gravar">
    </form>
  </body>
</html>