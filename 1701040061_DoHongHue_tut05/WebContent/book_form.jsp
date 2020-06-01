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
                        <li><a href="<%=request.getContextPath()%>/book-list" class="nav-link">Books</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${book != null}">
                            <form action="updateBook" method="post">
                        </c:if>
                        <c:if test="${book == null}">
                            <form action="insertBook" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${book != null}" >
                                    Edit book statistics
                                </c:if>
                                <c:if test="${book == null}" >
                                    Add new book
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${book != null}">
                            <input type="hidden" name="id" value="<c:out value='${book.bookId}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label> Name</label> <input type="text" value="<c:out value='${book.name}' />" class="form-control" name="name" >
                           
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Author</label> <input type="text" value="<c:out value='${book.author}' />" class="form-control" name="author" >
                             
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Price </label> <input type="text" value="<c:out value='${book.price}' />" class="form-control" name="price">
                            
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