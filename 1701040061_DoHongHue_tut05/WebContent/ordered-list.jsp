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
 <div class = "container-text">
               <a href = "<%=request.getContextPath() %>/newInsertOrderedForm" class = "btn btn-success">Add new ordered</a>
               
               </div>
<table class = "table table-bordered">
<thead>

<tr>
<th>Ordered ID</th>
<th>Time ordered</th>
<th>Quantity</th>
<th>Book number</th>
<th>User number</th>
<th>Actions</th>

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
<td><a href = "showUpdateOrderedForm?id=<c:out value = '${ordered.orderedId}'/>">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href = "deleteOrdered?id=<c:out value = '${ordered.orderedId}'/>" onclick = "return confirm('Are you sure want to delete row ?');">Delete</a>
</tr>
</c:forEach>



</tbody>
</table>
<div class = "message">
<h3 style = "color: green">${mess}</h3>
<c:remove var = "mess" scope = "session"/>
</div>
</div>

</body>

</html>