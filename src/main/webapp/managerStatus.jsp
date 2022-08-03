<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.ResultSet" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Status</title>
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
		<jsp:include page="./managerNavbar.html"></jsp:include>
		<div>
		<div class="header" style="padding-top: 5%">
			<h1>Status</h1>
			
		</div>
		<form action="StatusServlets" method="post">
			<div class="input-group"  >
		    	<input type="text" class="form-control" name="managerid" placeholder="Enter the your Manager_ID..." required>
		 		<button class="btn btn-warning btn-block" type="submit" >Check status</button>
		  	</div>
	  	</form>
		  	<hr class= "mb-4" style="font-weight: 900;">
		   
			<h1 align= center>You have requested for ...</h1>
			<table class="table table-sm table-hover" align= center style="Width:90%">
				<thead class="thead-dark">
				<tr>
					<th scope="col">Manager ID</th>
					<th scope="col">Manager Name</th>
					<th scope="col">Employee ID</th>
					<th scope="col">Employee Name</th>
					<th scope="col">Floor</th>
					<th scope="col">Seat Number</th>
				</tr>
				</thead>
				<%
					Class.forName("com.mysql.cj.jdbc.Driver");
					String manager_id = (String)request.getAttribute("manager-id");
					
					try{
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from  managerRequest where Manager_ID=? ;");
						preparedStatement.setString(1, manager_id);
						ResultSet resultSet = preparedStatement.executeQuery();
	
						while(resultSet.next()){
				%>
				<tbody>
				<tr class="table-warning">
					<td><%=resultSet.getString("Manager_ID") %></td>
					<td><%=resultSet.getString("Manager_Name") %></td>
					<td><%=resultSet.getString("employee_ID") %></td>
					<td><%=resultSet.getString("employee_fullName") %></td>
					<td><%=resultSet.getString("floor") %></td>
					<td><%=resultSet.getString("seat_row") %><%=resultSet.getString("seat_col") %></td>
				</tr>
				</tbody>
				<%
					}
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
			</table> 
			</div>
			<br>
			
	</body>
</html>

