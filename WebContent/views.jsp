
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Computer info</h3>
	<p>ID : ${emp.id}</p>
	<p>Name : ${emp.name}</p>

	<c:forEach items="${listComputer}" var="item" varStatus="vs">
   <c:out value="${ pays }"/><br/>
     ${item.compagnie.name}<br>
     count = <c:out value="${vs.count}"/> :
     <hr>
   

	</c:forEach>

</body>
</html>