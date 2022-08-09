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
		
		<div class="header" style="padding-top: 5%">
			<h1>View Seats</h1>
			<div class="SeatImage">
				<img class="seatImage" src="Images/Hall-seats.jpg"/>
			</div>
		</div>
		<form action=getSeatCount method="post">
			<div class="input-group"  >
		    	<input type="text" class="form-control" name="Floor_no" placeholder="Enter the Floor..." required>
		 		<button class="btn btn-warning btn-block" type="submit" onclick="changeColor()" >Check</button>
		  	</div>
	  	</form>
			<div class="card" style="width: 40rem;" >
			  	<div class="card-body">
			    <h4 class="card-title">Allocated Seats</h4>
			    <p class="card-text" id="textValue"><%
			    String allocated = (String)request.getAttribute("Allocated");
			    if (allocated == null){
			    	allocated = "Select Floor";%>
			    	<p class="card-text" id="textValue"  style="color:#A9A9A9">
			    <%	
			    }
			     %>
			     
			     <strong><%=allocated %></strong></p>
		   		</div>
		   		<div class="card-body">
			    <h4 class="card-title">Available seats</h4>
			    <p class="card-text" id="textValue"><% String available = (String)request.getAttribute("Available");
			    if (available == null){
			    	available = "Select Floor";%>
			    	<p class="card-text" id="textValue"  style="color:#A9A9A9"><%
			    }
			    %><strong><%=available %></strong></p>
		   		</div>
		    </div>
		  	<hr class= "mb-4" style="font-weight: 900;">
		   
			<h1 align= center>Present Allocated Seats</h1>
			
			<div class="innerscroller" style="overflow: auto; height: 230px">
			<table class="table table-sm table-hover" align= center style="Width:90%">
				<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Full Name</th>
					<th scope="col">Floor</th>
					<th scope="col">Seat Number</th>
				</tr>
				</thead>
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
				<tbody>
				<tr class="table-warning">
					<td><%=resultSet.getString("emp_id") %></td>
					<td><%=resultSet.getString("full_name") %></td>
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
		<script type="text/javascript">
			function changeColor(){
				document.getElementById('textValue').style.color='black';
				document.getElementById('textValue').style.color='black';
			}
		
		</script>
	</body>
</html>

