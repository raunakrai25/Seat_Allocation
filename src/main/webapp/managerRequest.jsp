<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="manager.dao.*"%>
<%@page import= "manager.model.*"%>
<%@page import= "com.connection.*"%>
<%@page import= "java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.ResultSet" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%

	RequestDao rq = new RequestDao(DBcon.getConnection());
	List<Request> req = rq.getAllRequest();
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View Seats</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<c:url value = "View.css" />" /> 
	</head>
	<body>
	<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
			if(session.getAttribute("username")==null){
				response.sendRedirect("login.jsp");
			}
			
			
			
			
		%>
		<jsp:include page="./NavbarAfterLogin.html"></jsp:include>
		
		<div class="container" style="padding-top: 5%">
			<div class="card-header my-3"><h1>All Request :- </h1></div>
			<div class="row">
			<% 
				if(!req.isEmpty()){
					for (Request r: req){%>
						<div class="col-md-3 my-3" >
	  					<div class="card w-100" style="width: 18rem;">
	  						<div class="card-body" >
	  							<h3 class="card-title"><%=r.getManager_name() %></h3>
	  							<h6 class="Employee name">Employee Name:<%=r.getEmp_name() %></h6>
	  							<h6 class="Employee ID">Employee ID: <%=r.getEmp_id() %> </h6>
	  							<h6 class="emp_email">Email: <%=r.getEmp_email() %> </h6>
	  							<h6 class="floor">Floor: <%=r.getFloor() %></h6>
	  							<h6 class="seat_no">Seat_no: <%=r.getSeat_row() %><%=r.getSeat_col() %></h6>
	  							<div>
	  								<a href="#" class="btn btn-warning">Allocate Seat</a>
	  							</div>
	  						</div>
	  					</div>
					</div>
					<%}
				}
			%>
				
			</div>
		</div>	
			
		
		
			<br>
		</body>	
</html>