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
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
			if(session.getAttribute("username")==null){
				response.sendRedirect("login.jsp");
			}
			
		%>
		<jsp:include page="./managerNavbar.html"/>
		<div class="header" style="padding:5%">
			<h1>Welcome, <%=request.getParameter("name")%></h1>
			<br></br>
			<h3>This Web-Site is built to check Seat allocation</h3>
			<br></br>
			<div class="SeatImage">
				<img class="seatImage" src="Images/IMG20220704182434.jpg"/>
			</div>
		
		</div>
		<jsp:include page="./footer.html"/>
	</body>
</html>