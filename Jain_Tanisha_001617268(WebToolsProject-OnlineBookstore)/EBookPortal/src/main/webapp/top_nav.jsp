<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<style>
body {
	font-family:verdana,arial,sans-serif;
	font-size:10pt;
	margin:10px;
	background-color:red;
	}
</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="contents.jsp" target="Contents">*Online Bookstore*</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        
  <c:choose>
    		<c:when test="${!empty sessionScope.username}">
      
      <c:choose>
          	<c:when test="${sessionScope.role=='Customer'}"><li>
          	
          	<ul class="nav navbar-nav">
        <li class="active"><a href="contents.jsp" target="Contents">Home</a></li>
      
       <!--   <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Shop <span class="caret"></span></a>
          <ul class="dropdown-menu">
          
            <li><a href="#">Shop</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
            
          </ul>
        </li> -->
      
		<li><a href="listbooks.htm" target="Contents">Show Books</a>
        <li><a href="searchBookPage.htm" target="Contents">Search</a>
        <li><a href="viewcart.htm" target="Contents">My Cart</a></li>
        <li><a href="orderhistory.htm" target="Contents">My Orders</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
          	 <li><a href="logout.htm" target="Contents"><span class="glyphicon glyphicon-log-out"></span> Logout </a></li>    
	  </ul> 
          </c:when>
  
   			<c:otherwise>
             	<ul class="nav navbar-nav">
        <li class="active"><a href="contents.jsp" target="Contents">Home</a></li>
      
        	<li><a href="manageBooks.htm" target="Contents">Manage Books</a></li>
            <li><a href="viewCustomers.htm" target="Contents">View Customers</a></li>
            <li><a href="viewAllOrders.htm" target="Contents">View Orders</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        		 <li><a href="logout.htm" target="Contents"><span class="glyphicon glyphicon-log-out"></span> Logout </a></li>
   				  </ul>
   			</c:otherwise> 
     </c:choose>
     
   			</c:when> 
            <c:otherwise>
             <ul class="nav navbar-nav navbar-right"> 
           <li><a href="addcustomer.htm" target="Contents"><span class="glyphicon glyphicon-user"></span> Sign Up </a></li>
           <li><a href="login.htm" target="Contents"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
           </ul>
            </c:otherwise>
            
           </c:choose>
    </div>
  </div>
</nav>

<c:choose>
         <c:when test="${!empty sessionScope.username}">	
          <div style="float:right">
 			
				Welcome, ${sessionScope.username}! 
		  </div>
		  </c:when>
<c:otherwise>

 <div style="float:right">
 			
				Welcome, Guest! 
		  </div>

</c:otherwise>
</c:choose>


<%-- <div style="float:right">
 <c:choose>
            <c:when test="${!empty sessionScope.username}">
                <jsp:include page="menu.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="menu2.jsp"/>
            </c:otherwise>
        </c:choose>
</div> --%>


</body>
</html>

