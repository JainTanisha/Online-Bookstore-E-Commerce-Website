<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <%
//get the genre list
       com.ebookportal.spring.dao.GenreDAO genreDao = new com.ebookportal.spring.dao.GenreDAO();
        java.util.List genreList = genreDao.list();
        pageContext.setAttribute("genres", genreList);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(odd){background-color: grey;
color:black;}
tr:nth-child(even){background-color: lightgrey;
color:black;}

th {
    background-color: grey;
    color: black;
}

body{
color: white;
background-color: black; 
}

a{
color:black;
}
</style>
</head>
<body>
<h2 align="center" > Collection of books at Online Bookstore </h2>
<table>
            <tr>
                <th><b>Photo</b></th>
                <th><b>ISBN</b></th>
                <th><b>Title</b></th>
                <th><b>Genre</b></th>
                <th><b>Author</b></th>
                <th><b>Price</b></th>
                <th><b>Description</b></th>
                <th><b>Delete</b></th>
               <!--  <td><b>Update</b></td> -->
      
            </tr>
            
      		<c:forEach var="book" items="${books}">
            
                <tr>
                
                	<td><img height="150" width="150" src="${book.photoName}" /></td> 
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    
                    <c:forEach var="genre" items="${genres}" >
                    <c:if test ="${book.genreId==genre.genreID}"> 
                    <td>${genre.genreName}</td>
                    </c:if>
                    </c:forEach>
                
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.description}</td>
                   
                    <td ><a href="deleteBook.htm?id=${book.bookID}&action=deleteBook">Delete Book</a></td>
                
                
                
                    <%-- <td><img height="150" width="150" src="${book.photoName}" /></td> 
                    <td><input type="text" value="${book.isbn}"></td>
                    <td><input type="text" value="${book.title}"></td>
                    
                    <c:forEach var="genre" items="${genres}" >
                    <c:if test ="${book.genreId==genre.genreID}"> 
                    <td><input type="text" value="${genre.genreName}"></td>
                    </c:if>
                    </c:forEach>
                
                    <td><input type="text" value="${book.author}"></td>
                    <td><input type="text" value="${book.price}"></td>
                    <td><input type="text" value="${book.description}"></td>
                   
                    <td><a href="deleteBook.htm?id=${book.bookID}&action=deleteBook">Delete Book</a></td> --%>
                   <%--  <td><a href="updateBook.htm?id=${book.bookID}&action=updateBook" >Update Book</a></td> --%>
                   
                   
                   
                   
                   
                   
                 </tr>
            </c:forEach>
       </table>



</body>
</html>