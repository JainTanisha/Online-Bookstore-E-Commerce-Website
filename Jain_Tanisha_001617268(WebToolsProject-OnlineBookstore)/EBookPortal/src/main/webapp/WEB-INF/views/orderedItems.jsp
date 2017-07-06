<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

#toCenter{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
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
<div id="toCenter">
<h2>Items have been successfully ordered!</h2>

You paid $${sessionScope.total}.
<br><br>
Your Order id is ${sessionScope.orderId}.
<br><br>

<!-- <a href="report.htm">Generate pdf</a> -->

<a href="orderhistory.htm">View Order History</a>
</div>


</body>
</html>