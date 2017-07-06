<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Online Bookstore</title>
</head>

<frameset rows="100,*,80" frameborder="0" border="0" framespacing="0">
  <frame name="TopNav" src="top_nav.jsp">
<!-- <frameset cols="200,*" frameborder="0" border="0" framespacing="0">
	<frame name="Menu" src="menu.jsp" marginheight="0" marginwidth="0" scrolling="auto" noresize> -->
	

	<frame name="Contents" src="contents.jsp" marginheight="0" marginwidth="0" scrolling="auto" noresize>

<!-- </frameset> -->

  <frame name="Footer" src="footer.jsp">

<noframes>
<p>This browser does not support frames which is used for building this website. Please try to change the browser and re-run the code.</p>
</noframes>
</frameset>
</html>
