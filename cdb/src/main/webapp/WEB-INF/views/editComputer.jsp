
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->


<link href="css/bootstrap.min.css" rel="stylesheet" media="screen"
	type="text/css">
<link href="css/font-awesome.css" rel="stylesheet" media="screen"
	type="text/css">
<link href="css/main.css" rel="stylesheet" media="screen"
	type="text/css">

</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a class="navbar-brand" href="dashboard"> Application - Computer
				Database </a>
		</div>
	</header>
	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-xs-8 col-xs-offset-2 box">
					<div class="label label-default pull-right">id: 0</div>
					<h1>Edit Computer</h1>
					<c:if test="${erreur==false}">
						<p class="alert alert-success">
							<c:out value="${message}"></c:out>
						</p>
					</c:if>

					<c:if test="${erreur==true}">
						<p class="alert alert-danger">
							<c:out value="${message}"></c:out>
						</p>
					</c:if>

					<form action="editComputer" method="POST">
						<input type="hidden" value="0" id="id" />
						<!-- TODO: Change this value with the computer id -->
						<fieldset>
							<div class="form-group">
								<label for="computerName">Computer name</label> <input
									type="text" class="form-control" id="computerName"
									placeholder="name" value="${param.name}"
									name="name">
							</div>
							<div class="form-group">
								<label for="introduced">Introduced date</label> <input
									type="date" class="form-control" id="introduced"
									placeholder="Introduced date" value="${param.introduced}"
									name="introduced">
							</div>
							<div class="form-group">
								<label for="discontinued">Discontinued date</label> <input
									type="date" class="form-control" id="discontinued"
									placeholder="Discontinued date" value="${param.discontinued}"
									name="discontinued">
							</div>
							<div class="form-group">
								<label for="companyId">Company</label> <select
									class="form-control" id="companyId" name="nameCompany">

									<c:forEach items="${listCompany}" var="item">
										<option>${item.name}</option>
									</c:forEach>

								</select>
							</div>
							
						</fieldset>
						<div class="actions pull-right">
							<input type="submit" value="Edit" class="btn btn-primary">
							or <a href="dashboard" class="btn btn-default">Cancel</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>