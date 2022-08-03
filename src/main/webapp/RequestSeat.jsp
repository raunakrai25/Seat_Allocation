<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Request Seats</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<c:url value = "allocateSeat.css" />" /> 
		<link rel="stylesheet" type="text/css" href="<c:url value = "login.css" />" />
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
			if(session.getAttribute("username")==null){
				response.sendRedirect("ManagerLogin.jsp");
			}
			
		%>
		<jsp:include page="./managerNavbar.html"></jsp:include>
		<div class="header" align=center style="padding-top: 5%">
			<h1>Select Seat</h1>
			<div class="SeatImage">
				<img class="seatImage" src="Images/Hall-seats.jpg"/>
			</div>
		</div>
	
		<div class="container">
		<div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4 form-container">
                <form action=ManagerRequest method="post">
                	<div class="mb-3">
                      <label class="col-6 form-label"> Manager ID</label>
                      <input type="text" name=textManagerId class="form-control" required>
                    </div>
					<br/>
					<div class="mb-3">
                      <label class="col-6 form-label"> Manager Name</label>
                      <input type="text" name=textManagerName class="form-control" required>
                    </div>
					<br/>
					<div class="mb-3">
                      <label class="col-6 form-label"> Manager Email</label>
                      <input type="email" name=textManagerEmail class="form-control" required>
                    </div>
					<br/>
                    <div class="mb-3">
                      <label class="col-6 form-label"> Employee ID</label>
                      <input type="text" name=textEmpId class="form-control" required>
                    </div>
					<br/>
					<div class="mb-3">
                      <label class="col-6 form-label">Employee Full Name</label>
                      <input type="text" name=textName class="form-control" required>
                    </div>
					<br/>
					<div class="mb-3">
                      <label class="col-6 form-label">Email address</label>
                      <input type="email" name=textEmail class="form-control" required>
                    </div>
					<br/>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-6 form-label" style="padding-left: 15px">Select Floor</div>
                        </div>
                      <select name="floorNo" class="form-select" aria-label=".form-select-lg example" style="color:black" required>
						  <option value="">Open this select menu</option>
						  <option value="1">1</option>
						  <option value="2">2</option>
						  <option value="3">3</option>
						  <option value="4">4</option>
						  <option value="5">5</option>
					  </select>
                    </div>
                    <br>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-6 form-label" style="padding-left: 15px">Select Row</div>
                        </div>
                      <select name="row_no" class="form-select" aria-label=".form-select-lg example" style="color:black" required>
						  <option value="">Open this select menu</option>
						  <option value="1">1</option>
						  <option value="2">2</option>
						  <option value="3">3</option>
						  <option value="4">4</option>
						  <option value="5">5</option>
						  <option value="6">6</option>
						  <option value="7">7</option>
						  <option value="8">8</option>
					  </select>
                    </div>
                    <br>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-6 form-label" style="padding-left: 15px">Select Column</div>
                        </div>
                      <select name="col_no" class="form-select" aria-label=".form-select-lg example" style="color:black" required	 >
						  <option value="">Open this select menu</option>
						  <option value="A">A</option>
						  <option value="B">B</option>
						  <option value="C">C</option>
						  <option value="D">D</option>
						  <option value="E">E</option>
						  <option value="F">F</option>
						  <option value="G">G</option>
						  <option value="H">H</option>
						  <option value="I">I</option>
						  <option value="J">J</option>
						  <option value="K">K</option>
					  </select>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-warning btn-lg btn-block w-200">Ask</button>
                  </form>
            </div>
                        
        </div>

        
    </div>
	<jsp:include page="./footer.html"/>
	</body>
</html>