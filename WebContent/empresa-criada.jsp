<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gerenciador - Empresa criada!</title>
<style>
html,body{
color:white;
background-color:black;
}
</style>
</head>
<body>
	<c:if test="${not empty nome}">
		Empresa: ${ nome } cadastrada com sucesso!
	</c:if>
	<c:if test="${empty nome}">
		Nenhuma empresa cadastrada!
	</c:if>
</body>
</html>