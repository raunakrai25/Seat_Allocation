<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
	<nav class="navbar navbar-inverse" style="position: fixed; width: 100%;">
	  		<div class="container-fluid">
	    		<div class="navbar-header">
	      			<a class="navbar-brand" href="#"><img width="160px" height="45px"src="Images/Logo.jpg" style="position:relative;top:-10px"></a>
	    		</div>
	    		<ul class="nav navbar-nav">
	      			<li class="active"><a href="/Seat-Allocation/Homepage.jsp">Home</a></li>
	      			<li><a href="/Seat-Allocation/View.jsp">View Seats</a></li>
	      			<li><a href="/Seat-Allocation/allocateSeat.jsp">Allocate Seat</a></li>
	      			<li><a href="/Seat-Allocation/deallocateSeat.jsp">Deallocate Seat</a></li>
	    		</ul>
	    		<ul class="nav navbar-nav navbar-right">
	      			<li><a href="/Seat-Allocation/SignUp.jsp"><span class="glyphicon glyphicon-user"></span> New Account</a></li>
	      			<li><form class="glyphicon glyphicon-log-in" action="LogoutServlet" method="get" style="padding-top:20%"><button type="submit" ><%=request.getParameter("name")%></button></form></li>
	    		</ul>
	  		</div>
		</nav>
</body>
</html>