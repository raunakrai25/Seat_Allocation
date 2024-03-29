<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta charset="ISO-8859-1">
		<title>SignUp</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="SignUp.css">
		
		
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
			if(session.getAttribute("username")==null){
				response.sendRedirect("login.jsp");
			}
			
		%>
		<jsp:include page="./NavbarAfterLogin.html"></jsp:include>
		<div class="container" style="padding-top:6%">
        <div class="title" style="color:red">Add More Operational Team Member </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4 form-container">
                <form action=RegisterServlet method="post" >
                	<div class="mb-3">
                      <label class="col-6 form-label">Full Name</label>
                      <input type="text" name=textName class="form-control" required>
                    </div>
					<br/>
					<div class="mb-3">
                      <label class="col-6 form-label">Employee ID</label>
                      <input type="text" name=textEmp_id class="form-control" required>
                    </div>
					<br/>
                    <div class="mb-3">
                      <label class="col-6 form-label">Email address</label>
                      <input type="email" name=textEmail class="form-control" required>
                    </div>
					<br/>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-6 form-label" style="padding-left: 15px">Password</div>
                        </div>
                      <input type="password" name=textPassword class="form-control" id="changePasswordForm" required >
                      <div class="col-6 form-label" id="displayError" style="padding-left: 15px; color: red; "><% String displayError = (String)request.getAttribute("displayError");
			   			 if (displayError == null){
			    			displayError = "";
			   			 }
			    		%><%=displayError %></div>
                    </div>
                    <br>
                    <button type="submit" id="click" class="btn btn-warning btn-lg btn-block w-200">Sign Up</button>
                  </form>
            </div>
                        
        </div>

        
    </div>
    
    <jsp:include page="./footer.html"/>
		
	</body>
	
	
</html>