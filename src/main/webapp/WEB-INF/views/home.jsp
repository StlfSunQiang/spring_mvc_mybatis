<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
<title>Taskify :: Home</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Welcome to Taskify!</h1>
		<hr />
		<P>There are ${totalOpenTasks}(${totalTasks}) open tasks.</P>
	</div>
 <img src="/resources/imgs/a.jpg">
</body>
</html>
