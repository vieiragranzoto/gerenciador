<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gerenciador - Lista de empresas</title>
<style>
html, body {
	color: white;
	background-color: black;
}
</style>
</head>
<body>
	<ul>
		<c:forEach items="${lista}" var="empresa">
		<fmt:parseDate  value="${empresa.data}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
			<li>${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}"/></li>
		</c:forEach>
	</ul>
</body>
</html>