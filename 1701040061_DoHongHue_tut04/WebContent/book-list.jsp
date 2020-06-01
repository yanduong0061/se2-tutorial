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
<h2 class = "text-center">Book List</h2>
<table class = "table table-bordered">
<thead>
<tr>
<th>Book ID</th>
<th>Name </th>
<th>Author</th>
<th>Price</th>

</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books}">
<tr>
<td><c:out value = "${book.bookId}"/></td>
<td><c:out value = "${book.name }"/></td>
<td><c:out value = "${book.author }"/></td>
<td><c:out value = "${book.price }"/></td>
</tr>

</c:forEach>

</tbody>

</table>



</div>


</body>
</html>