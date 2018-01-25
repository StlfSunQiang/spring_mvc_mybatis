<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/theme.jsp"></jsp:include>
    <title>Spring MVC JPA Starter: Edit User</title>
    <script type="text/javascript">
        function deleteUser(id) {
            if (confirm("Delete... PID = " + id + " ??? ")) {
                //document.forms[0].method
                with (document.forms[0]) {
                    _method.value = "DELETE";
                    submit();
                }
            }

        }
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/views/navbar.jsp"></jsp:include>
<h1 class="text-center">Edit User</h1>
<hr>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Enter user details here..</h3>
        </div>
        <div class="panel-body">
            <!--方式一-->
            <%--<form:form action="../${user.id}" method="PUT" modelAttribute="user" commandName="user">--%>
            <!--方式二-->
            <form:form action="../${user.id}" method="PUT" modelAttribute="user">
                <div class="form-group">
                    <label for="txtUserName">User-name</label>
                    <form:input path="userName" class="form-control" id="txtUserName"
                                placeholder="User Name"/>
                </div>
                <div class="form-group">
                    <label for="txtName">First Name</label>
                    <form:input path="name" class="form-control"
                                id="txtName" placeholder="Full Name"/>
                </div>
                <div class="form-group">
                    <label for="calDob">Date of Birth</label>
                    <form:input path="dateOfBirth" class="form-control" id="calDob"
                                placeholder="dd/MM/yyyy"/>
                </div>

                <button type="submit" class="btn btn-success">Save</button>
                <a href='<c:url value="/users/${user.id}"/>'
                   class="btn btn-primary">Cancel</a>
                <a href="javascript:deleteUser('${user.id}');"
                   class="btn btn-danger">Delete</a>
            </form:form>
        </div>
    </div>

</div>
</body>
</html>
