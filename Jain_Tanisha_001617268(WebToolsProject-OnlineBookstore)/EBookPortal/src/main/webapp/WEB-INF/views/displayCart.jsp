 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        
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

tr:nth-child(even){background-color: grey; color:black;}
tr:nth-child(odd){background-color: darkgrey; color:black;}
th {
    background-color: darkgrey;
    color: black;
}


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

<form:form action="placeorder.htm" commandName="orders" method="post">
    <c:choose>
        <c:when test = "${!empty sessionScope.cart}">
        <h3> Your cart contents</h3>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Remove?</th>
            </tr>
            
            <c:forEach var="b" items="${cart}" varStatus="status">
                <tr id="row${status.index}"> 
                  
                    <td>${b.title}</td>
                    <td>${b.author}</td>
                    <td>${b.price}</td>
                  
                  <td><a href="removeitem.htm?id=${status.index}&action=removeitem">Remove</a></td>
              
                  
                </tr>
             </c:forEach>
                <tr></tr>
                <tr>
                	<td></td>
                    <td>Total</td>
                    <td>${sessionScope.total}</td>
                    <td></td>
                    
                </tr>
        </table>
                <br><br>
                <a href="listbooks.htm"> Continue Shopping </a>
                &nbsp &nbsp
               
                <input type="submit" value="Checkout">
         </c:when>
                
                <c:otherwise>
                    <h2> Your shopping cart is empty </h2>
                    <p> <a href="listbooks.htm">Return to shopping</a></p>
                </c:otherwise>
                    
           </c:choose> 


</form:form>

</div>
</body>
</html>
