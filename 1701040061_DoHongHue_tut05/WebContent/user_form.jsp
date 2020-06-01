<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
              
                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/user-list" class="nav-link">Users</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="updateUser" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insertUser" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}" >
                                    Edit user statistics
                                </c:if>
                                <c:if test="${user == null}" >
                                    Add new user
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label> Name</label> <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="name" >
                           
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Address</label> <input type="text" value="<c:out value='${user.address}' />" class="form-control" name="address" >
                             
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Phone Number </label> <input type="text" value="<c:out value='${user.phoneNumber}' />" class="form-control" name="phoneNumber" >
                            
                        </fieldset>
                        
                       
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                      
                    </div>
                </div>
                  <div class = "message">
                       <h3 style = "color: red">${message}</h3>
                      
                        </div>
            </div>
</body>


</html>