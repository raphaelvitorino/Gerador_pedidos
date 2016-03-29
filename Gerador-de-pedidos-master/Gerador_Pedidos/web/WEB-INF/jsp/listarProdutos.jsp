<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de produtos</title>
</head>
<body>
  <h2>${mensagem}</h2>
  <a href="controller?action=ActionFormEditarProduto">Novo produto</a>
  <table>
    <thead>
      <tr>
        <th>Id do produto</th>
        <th>Nome do produto</th>
       <th>Quantidade de produtos</th>
         <th>Valor do produto</th>
        <th colspan="2">attribute</th>
      </tr>
    </thead>
    <c:forEach var="produto" items="${produtos}" varStatus="id">
  	  <tr bgcolor="#${id.count %2 == 0 ? 'aaee88' : 'ffffff' }">
  	    <td>${produto.idProduto}</td>
  	    <td>${produto.nomeProduto}</td>
	    <td>${produto.quantidade}</td>
              <td>${produto.valorProduto}</td>
	    <td><a href="controller?action=ActionFormEditarProduto&id=${produto.idProduto}">Editar</a></td>
	    <td><a href="controller?action=ActionRemoverProduto&id=${produto.idProduto}">Remover</a></td>
  	  </tr>
  	</c:forEach>
  </table>
</body>
</html>