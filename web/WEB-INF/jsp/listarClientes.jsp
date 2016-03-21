<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Clientes</title>
</head>
<body>
  <h2>${mensagem}</h2>
  <a href="controller?action=ActionFormEditContato">Novo cliente</a>
  <table>
    <thead>
      <tr>
        <th>Nome</th>
        <th>E-Mail</th>
       
        <th colspan="2">attribute</th>
      </tr>
    </thead>
    <c:forEach var="cliente" items="${clientes}" varStatus="idcliente">
  	  <tr bgcolor="#${id.count %2 == 0 ? 'aaee88' : 'ffffff' }">
  	    <td>${cliente.nomecliente}</td>
  	    <td>
  	      <c:choose>
			<c:when test="${not empty cliente.email}">
  			  <a href="mailto:${cliente.email}">${cliente.email}</a>
			</c:when>
			<c:otherwise>
			  E-mail nao informado
			</c:otherwise>
		  </c:choose>
            </td>
	    
	    <td><a href="controller?action=ActionFormEditarCliente&id=${cliente.idcliente}">Editar</a></td>
	    <td><a href="controller?action=ActionRemoverCliente&id=${cliente.idcliente}">Remover</a></td>
  	  </tr>
  	</c:forEach>
  </table>
</body>
</html>