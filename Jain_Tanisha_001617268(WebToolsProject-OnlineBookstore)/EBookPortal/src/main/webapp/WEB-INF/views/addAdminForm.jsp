<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Form</title>
<style>

#toCenter
{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
} 

body{
background-color:black;
color:white;
}
</style>
</head>

<body text-align="center" bgcolor="navy">
<div id="toCenter">
<h2 align="center" style="color:white">Admin Registration!</h2>

<form:form action="addadmin.htm" commandName="admin" method="post">

<table align="center" border="1">
<tr>
    <td style="color:white"> First Name:</td>
    <td><form:input path="firstName" size="30" /><font color="red"><form:errors path="firstName"/></font></td>
   
</tr>

<tr>
    <td style="color:white"> Last Name:</td>
    <td><form:input path="lastName" size="30" /><font color="red"><form:errors path="lastName"/></font></td>
</tr>

<tr>
    <td style="color:white">Role :</td>
    <td><form:input path="roleName" size="30" value="admin"/><font color="red"><form:errors path="roleName"/></font> </td>
</tr>

<tr>
    <td style="color:white">Username:</td>
    <td><form:input path="username" size="30" /><font color="red"><form:errors path="username"/></font></td>
</tr>

<tr>
    <td style="color:white">Email ID:</td>
    <td><form:input path="emailID" size="30" /> <font color="red"><form:errors path="emailID"/></font></td>
</tr>


<tr>
    <td style="color:white">Password:</td>
    <td><form:input path="password" size="30" /><font color="red"><form:errors path="password"/></font></td>
</tr>

<tr>
    <td colspan="2" align="center"><input type="submit" value="Confirm" /></td>
</tr>
</table>

</form:form>
</div>
</body>
</html>