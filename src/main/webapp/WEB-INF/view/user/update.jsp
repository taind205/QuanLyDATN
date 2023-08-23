<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action = "update.htm" modelAttribute="user" method="post">
${message}
<div>
	<label>Username: ${username}</label>
	<form:input type="hidden" value="${username}" path="username"/>
</div>
<div>
	<label>Password</label>
	<form:input path="password"/>
</div>
<div>
	<label>Fullname</label>
	<form:input path="fullname"/>
</div>

<div>
	<button class="btn btn-default">Cập nhật</button>
	 <%
        session.invalidate();
     %>
</div>
</form:form>
</body>
</html>