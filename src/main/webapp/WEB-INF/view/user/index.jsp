<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${message}
<table class = "table table-hover">
	<tr>
		<th>Username</th>
		<th>Password</th>
		<th>Fullname</th>
		<th></th>
		<th></th>
	</tr>
<c:forEach var="u" items="${users}">
	<tr>
		<td>${u.username}</td>
		<td>${u.password}</td>
		<td>${u.fullname}</td>
		<td><a href="delete.htm?username=${u.username}">Delete</a></td>
		<td><a href="update.htm?username=${u.username}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>