
    <%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>COmpany info</h3>
<p>ID : ${emp.id}</p>
<p>Name : ${emp.name}</p>

<c:forEach items="${listComputer}" var="item">
    ${item.company.name}<br>
</c:forEach>

</body>
</html>