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
	<jsp:include page="headerForSub.jsp" />

	<div class="hero-wrap" style="background-image: url('${pageContext.request.contextPath}/resources/images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
				<div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
					<div class="text">
						<p class="breadcrumbs mb-2">
							<span class="mr-2"><a href="home">Home</a></span> <span>Restaurants</span>
						</p>
						<h1 class="mb-4 bread">Restaurants</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-3">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<h2>Checkout Orders</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-7 container ftco-animate">
						
					<c:forEach items="${checkoutList.items}" var="item" varStatus="status">
						<div class="row">
							<div class="col-8">${ item.name }</div>
							<div class="col-2">x ${ item.qtt }</div>
							<div class="col-2"><span class="text-right"><fmt:formatNumber value = "${item.price}" type = "currency"/></span></div>
						</div>
					</c:forEach>
					
					<hr>
					<div class="row">
						<div class="col-8">Tax 6%</div>
						<div class="col-2"></div>
						<div class="col-2"><span class="text-right"><fmt:formatNumber value = "${checkoutList.totalPrice*0.06}" type = "currency"/></span></div>
					</div>
					<div class="row">
						<div class="col-8">Service Fee 15%</div>
						<div class="col-2"></div>
						<div class="col-2"><span class="text-right"><fmt:formatNumber value = "${checkoutList.totalPrice*0.15}" type = "currency"/></span></div>
					</div>
					
					<hr>
					<div class="row total-price">
						<div class="col-8"></div>
						<div class="col-2">Total</div>
						<div class="col-2"><span class="text-right"><fmt:formatNumber value = "${checkoutList.totalPrice*1.21}" type = "currency"/></span></div>
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="col-lg-7 container ftco-animate menu-order">
					<form:form action="">
						<c:forEach items="${checkoutList.items}" var="item" varStatus="loop" >
							<div class="row">
								<input name="items[${loop.index}].menuId" value="${item.id}" type="hidden" />
								<input name="items[${loop.index}].quantity" value="${item.qtt}" type="hidden"/>
							</div>
						</c:forEach>
						<input name="tax" value="${checkoutList.totalPrice*0.06}" type="hidden" />
						<input name="serviceCharge" value="${checkoutList.totalPrice*0.15}" type="hidden" />
						<input name="totalBill" value="${checkoutList.totalPrice*1.21}" type="hidden" />
						
						<div class="col-md-12 properties-single ftco-animate mt-5 fadeInUp ftco-animated">
							<h5 class="mb-4">Deliver Detail</h5>
		          			<div class="row mb-4">
		          				<div class="col-4">Pick reservation</div>
								<div class="col-8">
									<div class="form-check">
										<input type="radio" id="no-rev" name="reservationId" value="" class="form-check-input" checked />
										<label class="form-check-label" for="no-rev">
											no reservation
										</label>
									</div>
								</div>
		          			</div>
		          			
		          			<div class="row mb-4">
		          				<div class="col-4">Pick deliver date</div>
								<div class="col-8">
									<input type="text" id="deliverDate" name="deliverDate" class="form-control deliver-date" />
								</div>
		          			</div>
		          			
		          			<c:set var="timeList" value="${[ 6, 8, 10, 12, 14, 16, 18, 20]}" scope="application" />
		          			<div class="row mb-4">
		          				<div class="col-4">Pick deliver time</div>
								<div class="col-8">
									<c:forEach items="${timeList}" var="time" varStatus="loop" >
										<div class="form-check">
											<c:if test="${ loop.first }">
												<input type="radio" id="time${time}" name="time" value="${time}" class="form-check-input" checked />
											</c:if>
											<c:if test="${ !loop.first }">
												<input type="radio" id="time${time}" name="time" value="${time}" class="form-check-input" />
											</c:if>
											<label class="form-check-label" for="time${time}">
												${time}:00 - ${time+2}:00
											</label>
										</div>
									</c:forEach>
								</div>
		          			</div>
		          			
		          		</div>

						<div class="form-group" style="padding-top: 1.5rem">
							<input type="submit" value="Place Order" class="btn btn-primary py-3 px-5">
						</div>
					</form:form>
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
	<script src="${pageContext.request.contextPath}/resources/js/scrollax.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/custom-script.js"></script>

</body>
</html>