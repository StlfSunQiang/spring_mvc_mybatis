<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
    <title>Taskify :: List of Users</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<div class="container">
    <h1>List of Users</h1>

    <hr/>
    <p class="text-right">
        <a class="btn btn-primary" href="users/new" role="button">Create New
            User</a>
    </p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>User name</th>
            <th>Name</th>
            <th>Date Of Birth</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty users}">

            <ul>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><a href='<c:url value="/users/${user.id}"/>'>${user.id}</a></td>
                        <td>${user.userName}</td>
                        <td>${user.name}</td>
                        <td>${user.dateOfBirth}</td>
                    </tr>
                </c:forEach>
            </ul>

        </c:if>

        </tbody>
    </table>
</div>
</body>
</html>
