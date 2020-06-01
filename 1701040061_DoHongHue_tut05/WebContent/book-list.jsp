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
 <div class = "container-text">
               <a href = "<%=request.getContextPath() %>/newInsertBookForm" class = "btn btn-success">Add new book</a>
               
               </div>
<div class = "table">
<table class = "table table-bordered">
<thead>
<tr>
<th>BookID</th>
<th>Name </th>
<th>Author</th>
<th>Price</th>
<th>Action</th>

</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books}">
<tr>
<td><c:out value = "${book.bookId }"/></td>
<td><c:out value = "${book.name }"/></td>
<td><c:out value = "${book.author }"/></td>
<td><c:out value = "${book.price }"/></td>
<td><a href="showUpdateBookForm?id=<c:out value='${book.bookId}'/>" ><i class="fa fa-pencil" aria-hidden="false"></i>Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteBook?id=<c:out value='${book.bookId}' />" onclick = "return confirm('Are you sure want to delete this ?');"><i class="fa fa-trash"></i>Delete</a></td>
</tr>

</c:forEach>



</tbody>

</table>
<div class = "message">
<h3 style = "color: green">${mess}</h3>
<c:remove var="mess" scope="session" /> 
</div>
</div>


</div>




</body>
</html>