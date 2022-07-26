<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login Page</title>
		<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="login.css">
		
	</head>
	<body>
		<jsp:include page="./loginNavbar.html"/>
		<div class="container">
        <img src="github.png" alt="" class="logo">
        <div class="title" style="color:red">Login Page for Only Operational Team</div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4 form-container">
                <form action=LoginServlets method="post" >
                    <div class="mb-3">
                      <label class="col-6 form-label">Email address</label>
                      <input type="email" name=textEmail class="form-control">
                    </div>
					<br/>
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-6 form-label" style="padding-left: 15px">Password</div>
                        </div>
                      <input type="password" name=textPassword class="form-control">
                    </div>
                     
                    <br>
                    <button  type="submit" class="btn btn-warning btn-lg btn-block w-200">Login</button>
                  </form>
            </div>
                        
        </div>

        
    </div>
    <jsp:include page="./footer.html"/>
	</body>
</html>