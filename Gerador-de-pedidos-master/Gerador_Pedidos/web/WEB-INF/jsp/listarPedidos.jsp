<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de pedidos</title>
</head>
<body>
  <h2>${mensagem}</h2>
  <a href="controller?action=ActionFormEditarPedido">Novo pedido</a>
  <table>
    <thead>
      <tr>
        <th>Id pedido</th>
        <th>Id cliente</th>
        <th>Valor do pedido</th>
        <th>Data do pedido</th>
        <th colspan="2">Acoes</th>
      </tr>
    </thead>
    <c:forEach var="pedido" items="${pedidos}" varStatus="id">
  	  <tr bgcolor="#${id.count %2 == 0 ? 'aaee88' : 'ffffff' }">
  	    <td>${pedido.idPedido}</td>
  	    <td>${pedido.idCliente}</td>
	    <td>${pedido.valorPedido}</td>
	    <td>
	      <fmt:formatDate value="${pedido.dataPedido}" pattern="dd/MM/yyyy" />
	    </td>
	    <td><a href="controller?action=ActionFormEditarPedido&id=${pedido.idPedido}">Editar</a></td>
	    <td><a href="controller?action=ActionRemoverPedido&id=${pedido.idPedido}">Remover</a></td>
  	  </tr>
  	</c:forEach>
  </table>
</body>
</html>