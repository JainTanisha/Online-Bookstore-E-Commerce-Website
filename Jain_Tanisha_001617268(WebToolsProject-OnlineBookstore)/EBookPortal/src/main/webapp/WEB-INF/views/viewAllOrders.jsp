<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
//get the genre list
       com.ebookportal.spring.dao.OrderDetailsDAO odDao = new com.ebookportal.spring.dao.OrderDetailsDAO();
        java.util.List odList = odDao.listOrders();
        pageContext.setAttribute("ordetails", odList);
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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


<h2 align="center">View all the details of orders made to Online Bookstore!</h2>

<table>
  <tr>
  	
    <th>Order Id</th>
    <th>Customer Id</th>
    <th>Book Id</th>
    <th>Book Name</th>
    <th>Book Author</th>
    <th>Book Price</th>
    <th>Order Date</th>
    
  </tr>
  
    <c:forEach  var="o" items="${ordetails}">
    <tr>
    <td>${o.orderId}</td>
    <td>${o.customerId}</td>
    <td>${o.bookId}</td>
    <td>${o.bookName}</td>
    <td>${o.bookAuthor}</td>
    <td>${o.price}</td>
    <td>${o.date}</td>
   
    </tr>
    </c:forEach>
    

</table>
</html>