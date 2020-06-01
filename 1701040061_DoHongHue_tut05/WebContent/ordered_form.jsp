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
                        <li><a href="<%=request.getContextPath()%>/ordered-list" class="nav-link">Ordereds</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${ordered != null}">
                            <form action="updateOrdered" method="post">
                        </c:if>
                        <c:if test="${ordered == null}">
                            <form action="insertOrdered" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${ordered != null}" >
                                    Edit ordered statistics
                                </c:if>
                                <c:if test="${ordered == null}" >
                                    Add new ordered
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${ordered != null}">
                            <input type="hidden" name="id" value="<c:out value='${ordered.orderedId}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label> Ordered At</label> <input type="text" value="<c:out value='${ordered.orderedAt}' />" class="form-control" name="orderedAt">
                           
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Quantity</label> <input type="number" value="<c:out value='${ordered.quantity}' />" class="form-control" name="quantity">
                             
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Book ID</label> <input type="number" value="<c:out value='${ordered.bookId}' />" class="form-control" name="bookId">
                            
                        </fieldset>
                                            <fieldset class="form-group">
                            <label>User ID</label> <input type="number" value="<c:out value='${ordered.userId}' />" class="form-control" name="userId">
                            
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