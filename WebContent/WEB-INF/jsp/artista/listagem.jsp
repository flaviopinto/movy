<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movy | Artista [listagem.jsp]</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/">Inicio</a> |
	<a href="${pageContext.request.contextPath}/filme">Filmes</a> |
	<a href="${pageContext.request.contextPath}/filme/novo">Novo Filme</a> |
	<a href="${pageContext.request.contextPath}/artista">Artistas</a> |
	<a href="${pageContext.request.contextPath}/artista/novo">Novo Artista</a> |
	<a href="${pageContext.request.contextPath}/usuario">Usuarios</a> |
	<a href="${pageContext.request.contextPath}/usuario/novo">Novo Usuario</a>
	
	<br />
	<br />

	<c:if test="${not empty message}">
		${message}
		<br />
		<br />
	</c:if>

	<c:forEach items="${artistaList}" var="artista">
		<h2>${artista.imagem}</h2>

		(${artista.nome})
		
		<br />

		<form action="${pageContext.request.contextPath}/artista/${artista.id}" method="get">
			<input type="submit" value="exibir" />
		</form>

		<form
			action="${pageContext.request.contextPath}/artista/${artista.id}/editar" method="get">
			<input type="submit" value="editar" />
		</form>

		<form action="${pageContext.request.contextPath}/artista/${artista.id}" method="post">
			<input type="hidden" name="_method" value="delete" /> 
			<input type="submit" value="remover" />
		</form>
	</c:forEach>
</body>
</html>