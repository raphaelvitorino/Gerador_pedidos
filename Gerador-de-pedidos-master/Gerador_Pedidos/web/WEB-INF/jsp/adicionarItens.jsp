<%-- 
    Document   : adicionarItens
    Created on : 22/03/2016, 20:20:54
    Author     : fabiano.eger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Cadastrar Itens</title>
    <link href="css/jquery-ui.css" rel="stylesheet"> 
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
  </head>
  <body>
    <h1>Adiciona Itens</h1>
    <hr/>
    <form action="controller?action=ActionCriarItem" method="POST">
    	Quantidade: <input type="text" name="quantidade" value="${item.quantidade}"><br>
    	Código do Pedido: <input type="text" name="idpedido" value="${item.idPedido}"><br>
   
    	<c:if test="${ item.idItem != 0 }">
    		<input type="hidden" name="id" value="${item.idItem}">
    	</c:if>
    	<input type="submit" value="Gravar">
    </form>
  </body>
</html>
