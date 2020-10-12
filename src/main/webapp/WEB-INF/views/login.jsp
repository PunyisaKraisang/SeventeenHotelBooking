<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Seventeen Hotel</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/aos.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.timepicker.css">


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flaticon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/icomoon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom-style.css">
</head>
<body>

	<!-- header nav bar -->
	<jsp:include page="header.jsp" />

	<div class="hero-wrap" style="background-image: url('${pageContext.request.contextPath}/resources/images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
				<div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
					<div class="text">
						<p class="breadcrumbs mb-2">
							<span class="mr-2"><a href="home">Home</a></span> <span>Login</span>
						</p>
						<h1 class="mb-4 bread">Login</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 container ftco-animate menu-order">
				
					<c:if test="${ error != null }">
						<div class="alert alert-danger" role="alert">
							<strong>${ error }</strong>
						</div>
					</c:if>
					
					<form:form action="login" method="post" modelAttribute="loginModel">
					
						<div class="col-md-12 properties-single ftco-animate mt-5 fadeInUp ftco-animated">
		          			<div class="row mb-4">
		          				<div class="col-4">Username</div>
								<div class="col-8">
									<input type="text" id="username" name="username" class="form-control" required/>
								</div>
		          			</div>
		          			<div class="row mb-4">
		          				<div class="col-4">Password</div>
								<div class="col-8">
									<input type="password" id="password" name="password" class="form-control" required/>
								</div>
		          			</div>
		          			
		          		</div>

						<div class="form-group" style="padding-top: 1.5rem">
							<span class="signin-link">Do not have account? <a href="signup">Sign up here</a></span>
							<input type="submit" value="Log in" class="btn btn-primary py-3 px-5 buttom-right">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</section>

	<!-- footer -->
	<jsp:include page="footer.jsp" />

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>

	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.waypoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.stellar.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/aos.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.animateNumber.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/scrollax.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/custom-script.js"></script>

</body>
</html>