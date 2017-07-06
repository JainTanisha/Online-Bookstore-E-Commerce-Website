<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
//get the genre list
       com.ebookportal.spring.dao.CustomerDAO customerDao = new com.ebookportal.spring.dao.CustomerDAO();
        java.util.List customerList = customerDao.listCustomers();
        pageContext.setAttribute("custs", customerList);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Customers</title>
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
color:white;
}
</style>
</head>
<body>


<h2 align="center">View all the customers registered to Online Bookstore!</h2>

<table>
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Username</th>
    <th>CustomerId</th>
    <th>Email Id</th>
    <th>Gender</th>
    <th>Address</th>
    <th>Phone</th>
  </tr>
  
    <c:forEach var="c" items="${custs}" >
    <tr>
    <td>${c.firstName}</td>
    <td>${c.lastName}</td>
    <td>${c.username}</td>
    <td>${c.userID}</td>
    <td>${c.emailID}</td>
    <td>${c.customerGender}</td>
    <td>${c.customerAddress}, ${c.customerCity}, ${c.customerState}, ${c.customerCountry} (${c.customerZip})</td>
    <td>${c.customerPhone}</td>
    </tr>
    </c:forEach>

</table>



</body>
</html>