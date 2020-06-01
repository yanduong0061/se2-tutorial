<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class = "container">
<br>
<h2 class = "text-center"> User List</h2>
<br>
<table class = "table table-bordered">
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Phone Number</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">
<tr>
<td><c:out value = "${user.id}"/></td>
<td><c:out value = "${user.name}"/></td>
<td><c:out value = "${user.address}"/></td>
<td><c:out value = "${user.phoneNumber}"/></td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
</html>