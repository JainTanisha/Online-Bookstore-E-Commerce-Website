<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add Customer Form</title>
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
    color: white;
}

body{

background-color: black; 
text-align:center;
}

#toCenter
{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
} 		  

/* [type:submit]{
align:center;
} */

</style>
</head>
<body>

<h2 align="center" style="color:white">Registration Form for new Customer!</h2>
<div id="toCenter">
<form:form action="addcustomer.htm" commandName="customer" method="post">

<table>


<tr>
    <td style="color:white">Role :</td>
    <td><form:select path="roleName" >
    <form:option path="roleName" value="Customer" /> 
   <%--  <form:option path="roleName" value="Bookseller" /> --%>
    </form:select></td>
</tr>

<tr>
    <td style="color:white">First Name:</td>
    <td><form:input path="firstName" size="30" pattern='[a-zA-Z ]{2,}' title="No special characters allowed. Atleast longer than 2 letters." /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td style="color:white">Last Name:</td>
    <td><form:input path="lastName" size="30" pattern='[a-zA-Z ]{2,}' title="No special characters allowed. Atleast longer than 2 letters."/> <font color="red"><form:errors path="lastName"/></font></td>
</tr>

<tr>
    <td style="color:white">Email ID:</td>
    <td><form:input path="emailID" size="30" pattern="^[^@]+@[^@]+\.[^@]+$" title="Please enter a valid email address."/> <font color="red"><form:errors path="emailID"/></font></td>
</tr>

<tr>
    <td style="color:white">Username:</td>
    <td><form:input path="username" size="30" pattern='[a-zA-Z0-9 ]{2,}' title="No special characters allowed. Atleast longer than 2 letters."/> <font color="red"><form:errors path="username"/></font></td>
</tr>

<tr>
    <td style="color:white">Password:</td>
    <td><form:input path="password" size="30" pattern='[a-zA-Z0-9 ]{2,}' title="No special characters allowed. Atleast longer than 2 letters." /> <font color="red"><form:errors path="password"/></font></td>
</tr>

<tr>
    <td style="color:white">Address: </td>
    <td><form:input path="customerAddress" size="30" pattern='[a-zA-Z0-9,. ]{2,}' title="No special characters allowed. Atleast longer than 2 letters."/> <font color="red"><form:errors path="customerAddress"/></font></td>
</tr>

<tr>
    <td style="color:white">City:</td>
    <td><form:input path="customerCity" size="30" pattern='[a-zA-Z ]{2,}' title="No special characters allowed. Atleast longer than 2 letters."/> <font color="red"><form:errors path="customerCity"/></font></td>
</tr>

<tr>
    <td style="color:white">Zip:</td>
    <td><form:input path="customerZip" size="30" pattern="[0-9]{3,6}" title="Enter a valid zip code."/> <font color="red"><form:errors path="customerZip"/></font></td>
</tr>

<tr>
    <td style="color:white">State:</td>
    <td><form:input path="customerState" size="30" pattern="[a-zA-Z ]{2,}" title="No special characters allowed. Atleast longer than 2 letters." /> <font color="red"><form:errors path="customerState"/></font></td>
</tr>

<tr>
    <td style="color:white">Country:</td>
    <td><form:input path="customerCountry" size="30" pattern="[a-zA-Z ]{2,}" title="No special characters allowed. Atleast longer than 2 letters." /> <font color="red"><form:errors path="customerCountry"/></font></td>
</tr>

 <tr>
    <td style="color:white">Gender:</td>
    <td><form:radiobutton path="customerGender" value="Male" checked="true"/>Male
        <form:radiobutton path="customerGender" value="Female" />Female</td>
</tr>

<tr>
    <td style="color:white">Phone :</td>
    <td><form:input path="customerPhone" size="30" pattern="\b\d{3}[-.]?\d{3}[-.]?\d{4}\b" title="Please enter a valid phone number"/> <font color="red"><form:errors path="customerPhone"/></font></td>
</tr>

<tr>
	<td></td>
    <td colspan="2" align="center"><input type="submit" value="Confirm" /></td>
</tr>
</table>

</form:form>
</div>
</body>
</html>