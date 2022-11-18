<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="recurso"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gerenciador - Efetuar login</title>
<style type="text/css">
html, body {
	color: white;
	background-color: black;
	text-align: center;
}

form {
	heigth: 500px;
	margin: 0 auto;
	width: 400px;
}

#mensagem {
	background-color: red;
	padding:10px;
	display:block;
	border: 2px solid red;
	border-radius:4px;
}

.valor {
	display: block;
	padding: 10px;
	margin: 0 auto;
	width: 40%;
}

.botao {
	width: 45%;
	display: block;
	padding: 10px;
	margin: 10px auto;
}
</style>
</head>
<body>
	<form method="post" action="${recurso}">
		<c:if test="${incorreto}">
			<label id="mensagem">Nome de usuario ou senha incorreto!</label>
		</c:if>
		<label for="nome">Informe o nome de usuario:</label>
		<input id="nome" class="valor" type="text" name="nome"></input>
		<label for="senha">Informe a senha:</label>
		<input id="senha" class="valor" type="password" name="senha"></input>
		<input type="hidden" name="acao" value="EfetuarLoginUsuario">
		<input class="botao" type="submit" value="Logar" ></input>
	</form>
</body>
</html>
