<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
<title>Spring MVC JPA Starter: View User</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<h1 class="text-center">User Details</h1>
	<hr>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">User...</h3>
			</div>
			<div class="panel-body">
				<c:if test="${not empty user.profileImage}">
					<div class="panel panel-default">
						<div class="panel-body">
							<img alt="${user.name}" width="200px" height="200px"
								src="<c:url value="/users/${user.id}/profileImage"/>">
						</div>
					</div>
				</c:if>

				<%-- <form:form action="new" method="post" commandName="user"> --%>
					<div class="form-group">
						<label >User-name</label>
						<p>${user.userName}</p>
					</div>
					<div class="form-group">
						<label>Name</label> 
						<p>${user.name}</p>
					</div>
					<div class="form-group">
						<label>Date of Birth</label>
						<p>${user.dateOfBirth}</p>
					</div>
					<a class="btn btn-success glyphicon glyphicon-pencil" href='<c:url value="/users/${user.id}/edit"/>'>Edit</a>
					<a class="btn btn-success glyphicon glyphicon-pencil" href='<c:url value="/users/${user.id}/profileForm"/>'>Upload Profile Picture</a>
					<a href="../users" class="btn btn-primary">Back to User list</a>
				<%-- </form:form> --%>
			</div>
		</div>

	</div>
</body>
</html>
