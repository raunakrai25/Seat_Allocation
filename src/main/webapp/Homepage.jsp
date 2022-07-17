 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Page</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="landingPage.css">
	</head>
	<body>
		<jsp:include page="./NavbarAfterLogin.html"/>
		<div class="header">
			<h1>Welcome, <%=request.getAttribute("Full_name")%></h1>
			<br></br>
			<h3>This Web-Site is built to check Seat allocation</h3>
			<br></br>
			<div class="SeatImage">
				<img class="seatImage" src="Images/IMG20220704182434.jpg"/>
			</div>
		
		</div>
		
	</body>
</html>