<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<style type="text/css">
  #container
  {
  	margin: 0 auto;
  	width: 600px;
  	background:#fff;
  }
  </style>
</head>
<body>
	<h1>Message : ${msg}</h1>
	<FORM action="proxy.html" method="post"">
	<INPUT type="radio" name="sex" value="Male"> Male<BR>
    <INPUT type="radio" name="sex" value="Female"> Female<BR>
    <INPUT type="submit" value="Send"> <INPUT type="reset">
	</FORM>
	<div class="container" ><img src="http://localhost:10000/hello/iris.jpg"/></div>
</body>
</html>