<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciador - Lista de empresas</title>
<style type="text/css">
html, body {
	color: white;
	background-color: black;
}
a{
	background-color: white;
	text-decoration: none;
	border: 2px solid white;
	border-radius:4px;
}
a:hover {
	color: orange;
}
</style>
</head>
<body>
	Deseja cadastrar nova empresa? <a href="/gerenciador/entrada?acao=CadastrarEmpresaForm">Cadastrar</a><br><br>
	<c:if test="${not empty lista}">
		Lista de empresas: <br>	
	</c:if>
	<ul>
		<c:forEach items="${lista}" var="empresa">
		<fmt:parseDate  value="${empresa.data}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
			<li>${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}"/>
			- <a href="/gerenciador/entrada?id=${empresa.id}&acao=MostraEmpresa">editar</a>
			- <a href="/gerenciador/entrada?id=${empresa.id}&acao=RemoverEmpresa">remover</a></li>
		</c:forEach>
	</ul>
</body>
</html>