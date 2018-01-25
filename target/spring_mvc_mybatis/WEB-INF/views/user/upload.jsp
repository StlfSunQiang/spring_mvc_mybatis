<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
<title>Spring MVC JPA Starter: Upload Profile Picture</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<h1 class="text-center">Upload Your Profile Picture</h1>
	<hr>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Upload here..</h3>
			</div>
			<div class="panel-body">
				<form:form action="../${user.id}/profileForm" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<%--@declare id="txtusername"--%><label for="txtUserName">Choose File</label>
						<input type="file" name="profileImage"/>
					</div>
					<button type="submit" class="btn btn-success">Upload</button>
					<a href="../${user.id}" class="btn btn-primary">Cancel</a>
				</form:form>
			</div>
		</div>

	</div>
</body>
</html>
