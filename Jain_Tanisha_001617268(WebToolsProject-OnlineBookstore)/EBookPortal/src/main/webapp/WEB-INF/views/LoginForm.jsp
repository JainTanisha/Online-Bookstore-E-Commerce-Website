<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(odd){
background-color: grey;
padding: 8px;
}
tr:nth-child(even){
background-color: darkgrey;
padding: 8px;
}

th {
    background-color: grey;
    color: black;
}

#toCenter
{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
} 

body{
color: white;
background-color: black; 
}

a{color:black;
}

</style>
</head>

<body>
<div id="toCenter">
<h2 align="center" style="color:white">Login Form!</h2>

<form:form action="login.htm" commandName="user" method="post">

<table align="center" border="1">

<tr>
    <td style="color:white">Username:</td>
    <td><form:input path="username" size="30" /><font color="red"><form:errors path="username"/></font>
    </td>
</tr>

<tr>
    <td style="color:white">Password:</td>
    <td><form:input path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

<tr>
	<td></td>
    <td colspan="2" align="center"><input type="submit" value="Confirm" /></td>
</tr>
</table>

</form:form>
</div>
<div style="float:left"><a href="addadmin.htm" target="Contents">Add Admin</a></div>
</body>
</html>