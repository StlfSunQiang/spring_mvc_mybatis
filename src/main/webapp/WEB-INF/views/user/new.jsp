<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
<title>Spring MVC JPA Starter: New User</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<h1 class="text-center">Create a New User</h1>
	<hr>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Enter user details here..</h3>
			</div>
			<div class="panel-body">
                <%--<input type="text" name="user.userName"/>--%>
				<form:form action="new" method="post" commandName="user">
					<div class="form-group">
						<label for="txtUserName">User-name</label>
						<form:input path="userName" 
							class="form-control" id="txtUserName" placeholder="User Name"/>
					</div>
					<div class="form-group">
						<label for="txtName">Full Name</label> 
						<form:input path="name" 
							class="form-control" id="txtName" placeholder="Full Name"/>
					</div>
					<div class="form-group">
						<label for="txtPassword">Password</label> 
						<form:input path="password" type="password"
							class="form-control" id="txtPassword" placeholder="Password"/>
					</div>
					<div class="form-group">
						<label for="calDob">Date of Birth</label> 
						<form:input path="dateOfBirth" 
							class="form-control" id="calDob" placeholder="dd/MM/yyyy"/>
					</div>
					<button type="submit" class="btn btn-success">Save</button>
					<a href="../new" class="btn btn-danger">Reset</a>
					<a href="../" class="btn btn-primary">Cancel</a>
				</form:form>
			</div>
		</div>

	</div>
</body>
</html>
