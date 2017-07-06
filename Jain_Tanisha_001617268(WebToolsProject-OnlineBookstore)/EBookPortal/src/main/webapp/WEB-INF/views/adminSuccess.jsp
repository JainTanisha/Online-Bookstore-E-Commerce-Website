<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

parent.frames.TopNav.document.location.reload();

</script>
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

a{color:white;}
	
</style>


</head>
<body>
<div id="toCenter">
<h2>Welcome to Online Bookstore Administrator Page!</h2>

<a href="manageBooks.htm" target="Contents"> Manage Books </a><br><br>

<a href="viewCustomers.htm" target="Contents">View Customers</a><br><br>

<a href="viewAllOrders.htm" target="Contents">View Orders</a>
</div>
</body>
</html>