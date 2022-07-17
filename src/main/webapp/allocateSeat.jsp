<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Allocate Seat</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="allocateSeat.css">
	</head>
	<body>
		<jsp:include page="./NavbarAfterLogin.html"></jsp:include>
		<div class="header">
			<h1>Allocate Seat</h1>
			<div class="SeatImage">
				<img class="seatImage" src="Images/Hall-seats.jpg"/>
			</div>
		</div>
		<div class="input-group">
	    	<input type="text" class="form-control" placeholder="Enter the Floor...">
	 		<button class="btn btn-warning btn-block" type="button">OK</button>
	  	</div>
	
	</body>
</html>