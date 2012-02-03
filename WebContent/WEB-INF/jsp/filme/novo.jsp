<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movy | Filme [novo.jsp]</title>
	</head>
</head>
	<body>
		<a href="${pageContext.request.contextPath}/">Inicio</a> |
		<a href="${pageContext.request.contextPath}/filme">Filmes</a> |
		<a href="${pageContext.request.contextPath}/filme/novo">Novo Filme</a> |
		<a href="${pageContext.request.contextPath}/artista">Artistas</a> |
		<a href="${pageContext.request.contextPath}/artista/novo">Novo Artista</a> |
		<a href="${pageContext.request.contextPath}/usuario">Usuarios</a> |
		<a href="${pageContext.request.contextPath}/usuario/novo">Novo Usuario</a><br/><br/>

		<fieldset style="width: 390px;">
			<legend>Filme</legend>

			<form action="${pageContext.request.contextPath}/filme" method="post">
				<input type="hidden" name="filme.id" value="${filme.id}"/>

				<label>Titulo:</label>
				<input type="text" name="filme.titulo" value="${filme.titulo}"/><br/>

				<label>Titulo Original:</label>
				<input type="text" name="filme.tituloOriginal" value="${filme.tituloOriginal}"/><br/>

				<label>Ano:</label>
				<input type="text" name="filme.ano" value="${filme.ano}"/><br/>

				<label>Genero:</label>
				<input type="text" name="filme.genero" value="${filme.genero}"/><br/>

				<label>Sinopse:</label>
				<textarea rows="6" cols="45" name="filme.sinopse">${filme.sinopse}</textarea><br/><br/>

				<input type="submit" value="salvar"/>
			</form>
		</fieldset>
	</body>
</html>