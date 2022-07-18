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
		<title>View Seats</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="View.css">
	</head>
	<body>
		<jsp:include page="./NavbarAfterLogin.html"></jsp:include>
		<div class="header" style="padding-top: 5%">
			<h1>View Seats</h1>
			<div class="SeatImage">
				<img class="seatImage" src="Images/Hall-seats.jpg"/>
			</div>
		</div>
		<form action=getSeatCount method="post">
			<div class="input-group"  >
		    	<input type="text" class="form-control" name="Floor_no" placeholder="Enter the Floor...">
		 		<button class="btn btn-warning btn-block" type="submit" >Check</button>
		  	</div>
	  	</form>
			<div class="card" style="width: 40rem;" align="center">
			  	<div class="card-body">
			    <h4 class="card-title">Allocated Seats</h4>
			    <p class="card-text"><%=request.getAttribute("Allocated") %></p>
		   		</div>
		   		<div class="card-body">
			    <h4 class="card-title">Available seats</h4>
			    <p class="card-text"><%=request.getAttribute("Available") %></p>
		   		</div>
		    </div>
		 <div class ="details" style=""> 
		   
			<h1 align= center>Present Allocated Seats</h1>
	
			<table border="1" align=center >
				<tr>
					<th>ID</th>
					<th>Full Name</th>
					<th>Floor</th>
					<th>Seat Number</th>
				</tr>
	
				<%
					Class.forName("com.mysql.cj.jdbc.Driver");
					String floor = (String)request.getAttribute("floorNo");
					
					try{
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from  seatDetails where floor=? ;");
						preparedStatement.setString(1,floor);
						ResultSet resultSet = preparedStatement.executeQuery();
	
						while(resultSet.next()){
				%>
				<tr>
					<td><%=resultSet.getString("emp_id") %></td>
					<td><%=resultSet.getString("full_name") %></td>
					<td><%=resultSet.getString("floor") %></td>
					<td><%=resultSet.getString("seat_row") %><%=resultSet.getString("seat_col") %></td>
				</tr>
				<%
					}
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
			</table> 
			
</div>
	</body>
</html>