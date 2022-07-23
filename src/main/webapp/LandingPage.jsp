<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
<link rel="stylesheet" href="landingPage.css">
<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="./loginNavbar.html"/>
	<div class="header">
		<h1>Welcome to IN TIME TEC</h1>
		<br></br>
		<h3>This Web-Site is built to check Seat allocation</h3>
		<br></br>
		<div class="SeatImage">
			<img class="seatImage" src="Images/IMG20220704182434.jpg"/>
		</div>
		<br>
	</div>
	<jsp:include page="./footer.html"/>
</body>
</html>