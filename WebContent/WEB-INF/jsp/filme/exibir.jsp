<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movy | Filme [exibir]</title>
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

	<h2>${filme.titulo}</h2>

	(${filme.tituloOriginal} - ${filme.genero} - ${filme.ano})
	
	<br />
	 
	${filme.sinopse}

	<form action="${pageContext.request.contextPath}/filme/${filme.id}" method="get">
		<input type="submit" value="exibir" />
	</form>

	<form
		action="${pageContext.request.contextPath}/filme/${filme.id}/editar" method="get">
		<input type="submit" value="editar" />
	</form>

	<form action="${pageContext.request.contextPath}/filme/${filme.id}" method="post">
		<input type="hidden" name="_method" value="delete" /> 
		<input type="submit" value="remover" />
	</form>
</body>
</html>