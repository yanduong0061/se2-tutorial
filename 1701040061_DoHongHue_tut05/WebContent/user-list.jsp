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
 <div class = "container-text">
               <a href = "<%=request.getContextPath() %>/newInsertForm" class = "btn btn-success">Add new user</a>
               
               </div>
<table class = "table table-bordered">
<thead>
<tr>
<th>User ID</th>
<th>Name</th>
<th>Address</th>
<th>Phone Number</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">
<tr>
<td><c:out value = "${user.id}"/></td>
<td><c:out value = "${user.name}"/></td>
<td><c:out value = "${user.address}"/></td>
<td><c:out value = "${user.phoneNumber}"/></td>
<%-- <td><a href = "newUpdateForm?id=<c:out value = "${user.id}"/>">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href = "deleteUser?id = <c:out value = "${user.id}"/>">Delete </a></td> --%>
 <td><a href="newUpdateForm?id=<c:out value='${user.id}'/>" ><i class="fa fa-pencil" aria-hidden="false"></i>Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteUser?id=<c:out value='${user.id}' />" onclick = "return confirm('Are you sure you want to delete this row ?');"><i class="fa fa-trash"></i>Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<div class = "message">
<h3 style = "color: green">${mess}</h3>
<c:remove var ="mess" scope = "session"/>
</div>
</div>
</body>
</html>