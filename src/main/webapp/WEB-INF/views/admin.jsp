<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
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
</head>
<body>
	<!-- header nav bar -->
	<jsp:include page="header.jsp" />

	<section class="home-slider owl-carousel">
		<div class="slider-item"
			 style="background-image: url(${pageContext.request.contextPath}/resources/images/bg_1.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div
						class="row no-gutters slider-text align-items-center justify-content-center">
					<div class="col-md-12 ftco-animate text-center">
						<div class="text mb-5 pb-3">
							<h1 class="mb-3">Admin Login</h1>
							<h2>Hotels &amp; Resorts</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="ftco-booking">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<%
						if (request.getAttribute("adminError") != null) {
					%>
						<div class="alert alert-danger">
							<strong>Error!</strong> ${adminError}
						</div>
					<%
						}
					%>
					<form action="adminLogin" class="booking-form" method="post">
						<div class="row">
							<div class="col-md-3 d-flex">
								<div
										class="form-group p-4 align-self-stretch d-flex align-items-end">
									<div class="wrap">
										<label for="username">Admin</label> <input type="text" id="username" name="username"
																					class="form-control" placeholder="Admin">
									</div>
								</div>
							</div>
							<div class="col-md-3 d-flex">
								<div
										class="form-group p-4 align-self-stretch d-flex align-items-end">
									<div class="wrap">
										<label for="pwd">Password</label> <input type="password" id="pwd" name="password"
																					 class="form-control"
																					 placeholder="Password">
									</div>
								</div>
							</div>
							<div class="col-md d-flex">
								<div class="form-group d-flex align-self-stretch">
									<input type="submit" value="Login"
										   class="btn btn-primary py-3 px-4 align-self-stretch">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>

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
	<!-- <script src="${pageContext.request.contextPath}/resources/js/jquery.timepicker.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/resources/js/scrollax.min.js"></script>
	<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="${pageContext.request.contextPath}/resources/js/google-map.js"></script> -->
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>