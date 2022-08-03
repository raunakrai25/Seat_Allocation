<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Deallocate Seat</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="login.css">
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
			if(session.getAttribute("username")==null){
				response.sendRedirect("login.jsp");
			}
			
		%>
		<jsp:include page="./NavbarAfterLogin.html"/>
		<div class="container">
        
        <div class="title" >Deallocate Seat</div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4 form-container">
                <form action=DeallocateSeat method="post">
                    <div class="mb-3">
                      <label class="col-6 form-label">Employee ID</label>
                      <input type="text" name=textEmpId class="form-control" required>
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
                    <button type="submit" class="btn btn-warning btn-lg btn-block w-200">Deallocate Seat</button>
                  </form>
            </div>
                        
        </div>

        
    </div>
    <jsp:include page="./footer.html"/>
	</body>
</html>