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
<title>Display Books</title>
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
<!-- <form action="addtocart.htm" method="post"> -->
<table>
            <tr>
                <td><b>Photo</b></td>
                <td><b>ISBN</b></td>
                <td><b>Title</b></td>
                <td><b>Genre</b></td>
                <td><b>Author</b></td>
                <td><b>Price</b></td>
                <td><b>Description</b></td>
                
                <td><b>Select Item</b></td>
                
            </tr>
      <c:forEach var="book" items="${books}">
            
                <tr>
                    <td><img height="150" width="150" src="${book.photoName}" /></td> 
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    
                    <c:forEach var="genre" items="${genres}" >
                    <c:if test = "${book.genreId==genre.genreID}"> 
                    <td>${genre.genreName}</td>
                    </c:if>
                    </c:forEach>
                    
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>${book.description}</td>
                     <td><a href="addtocart.htm?id=${book.bookID}&action=addtocart">Add To Cart</a></td>
                 </tr>
            </c:forEach>
       </table>
     <br><br>
     
     <a href="viewcart.htm">View Cart</a>

</body>
</html>