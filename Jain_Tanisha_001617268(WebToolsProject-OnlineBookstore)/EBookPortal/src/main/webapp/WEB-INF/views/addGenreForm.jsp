<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Genre Form</title>
</head>
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

th {
    background-color: grey;
    color: black;
}

body{
color: white;
background-color: black; 
}

#toCenter
{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
} 


a{color:white;}

</style>
<body>
<div id="toCenter">
<form:form action="addgenre.htm" commandName="genre" method="post">
<h2 align="center" > Please provide the name of the Genre </h2>
<table>

<tr align="center">
    <td>Genre Name</td>
    <td><form:input path="genreName" size="30" pattern='[a-zA-Z ]{2,}' title="No special characters allowed. Atleast longer than 2 letters." /> <font color="red"> <form:errors path="genreName"/> </font></td>
</tr>

<tr align="center">
	<td></td>
    <td colspan="2" align="center"><input type="submit" value="Add Genre" /></td>
</tr>

</table>
</form:form>
</div>
</body>
</html>