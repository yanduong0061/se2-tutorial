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
<h2 class = "text-center">
<br>
Ordered List
</h2>
<table class = "table table-bordered">
<thead>

<tr>
<th>Ordered ID</th>
<th>Time ordered</th>
<th>Quantity</th>
<th>Book number</th>
<th>User number</th>

</tr>
</thead>
<tbody>
<c:forEach var="ordered" items="${ordereds}">
<tr>
<td><c:out value = "${ordered.orderedId}"/></td>
<td><c:out value = "${ordered.orderedAt }"/></td>
<td><c:out value = "${ordered.quantity }"/></td>
<td><c:out value = "${ordered.bookId }"/></td>
<td><c:out value = "${ordered.userId }"/></td>
</tr>
</c:forEach>



</tbody>
</table>

</div>

</body>

</html>