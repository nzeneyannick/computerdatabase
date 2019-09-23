<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<title>list computers</title>
<link type="text/css" rel="stylesheet" href="#" />
</head>
<body>
	<br>
	<center>
		<c:out value="Affichage de la liste des computers" />
	</center>
	<hr>
	<%-- Puis affichage des données enregistrées dans la liste  transmis par la servlet --%>
	<p>

		<c:forEach var="listCom" items="${listComputer}">
			<c:out value="${listCom}" /><br>
		</c:forEach>
	</p>
</body>
</html>