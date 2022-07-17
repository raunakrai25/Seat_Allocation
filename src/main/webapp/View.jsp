<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.ResultSet" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%String floor = request.getParameter("Floor_no"); %>
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
		<div class="header">
			<h1>View Seats</h1>
			<div class="SeatImage">
				<img class="seatImage" src="Images/Hall-seats.jpg"/>
			</div>
		</div>
		<form action=getSeatCount method="post">
			<div class="input-group"  >
		    	<input type="text" class="form-control" name="Floor_no" placeholder="Enter the Floor...">
		 		<button class="btn btn-warning btn-block" type="submit" onClick="AddDetails()">OK</button>
		  	</div>
	  	</form>
			<div class="card" style="width: 40rem;">
			  	<div class="card-body">
			    <h4 class="card-title">Allocated Seats</h4>
			    <p class="card-text"><%=request.getAttribute("Allocated") %></p>
		   		</div>
		   		<div class="card-body">
			    <h4 class="card-title">Available seats</h4>
			    <p class="card-text"><%=request.getAttribute("Available") %></p>
		   		</div>
		    </div>
		    <h1>Details</h1>
<table border="1">
<tr>
<td>first name</td>
<td>last name</td>
<td>City name</td>
<td>Email</td>

</tr>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
	PreparedStatement preparedStatement = connection.prepareStatement("select emp_id, full_name, seat_row, seat_col from seatDetails where floor=?;");
	preparedStatement.setString(1, floor);
	ResultSet resultSet2 = preparedStatement.executeQuery();
	while(resultSet2.next()){

%>
<tr>
<td><%=resultSet2.getString("emp_id") %></td>
<td><%=resultSet2.getString("full_name") %></td>
<td><%=resultSet2.getString("seat_row") %></td>
<td><%=resultSet2.getString("seat_col") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
		    	
	</body>
</html>