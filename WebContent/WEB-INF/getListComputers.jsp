<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<title>Affichage d'un client</title>
<link type="text/css" rel="stylesheet" href="#" />
</head>
<body>
	<c:out value="test" />
	<%-- Puis affichage des données enregistrées dans la liste  transmis par la servlet --%>
	<p>

		<c:forEach var="listCom" items="${listComputer}">
			<c:out value="${listCom}" />
		</c:forEach>
	</p>
</body>
</html>