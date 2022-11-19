<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="recurso"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciador - Editar Empresas</title>
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
	<c:import url="logout-parcial.jsp"/>
	<form method="post" action="${recurso}">
		Informe o nome:
		<input class="valor" type="text" name="nome" value="${empresa.nome}"></input>
		Informe a data:
		<input class="valor" type="date" name="data" value="${empresa.data}"></input>
		<input type="hidden" name="id" value="${empresa.id}">
		<input type="hidden" name="acao" value="EditarEmpresa">
		<input class="botao" type="submit" value="Enviar" ></input>
	</form>
</body>
</html>