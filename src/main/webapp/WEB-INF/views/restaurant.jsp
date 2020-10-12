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
					<h2>Our Menu</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-7">
					<div class="row">
						
						<c:if test="${ menuList != null && menuList.size() > 0 }">
						
							<c:forEach items="${menuList}" var="menu" varStatus="status">
								<div class="pricing-entry col-11 d-flex ftco-animate">
									<div class="img" 
										 style="background-image: url(<spring:eval expression="@environment.getProperty('s3.menu.img.url')"/>${menu.menuId}.jpg);"></div>
									<div class="desc pl-3">
										<div class="d-flex text align-items-center">
											<h3>
												<span>
													${menu.name} 
													<c:if test="${menu.recommended}">
														<span class="icon-star-o" style="font-size: 0.75em; padding:0"></span>
													</c:if>
												</span>
											</h3>
											<span class="price"><fmt:formatNumber value = "${menu.price}" type = "currency"/></span>
										</div>
										<div class="d-flex">
											<div class="col-10" style="text-align: justify;">
												<div class="menu-keyword">
													<c:forEach items="${menu.keywords}" var="key" varStatus="loop">
														${ key.value }  
														<c:if test="${!loop.last}"><span class="icon-stop2"></span></c:if>
													</c:forEach>
												</div>
												
												${menu.description}
											</div>
											<p class="col-2" style="text-align: right;">
												<a onClick="addToCart(${menu.menuId}, '${menu.name}', ${menu.price})" title="Add to cart">
													<span class="icon-shopping-cart"></span>
												</a>
											</p>
										</div>
									</div>
								</div>
							</c:forEach>
							
						</c:if>
						
						<c:if test="${ menuList == null || menuList.size() == 0 }">
							<div class="ftco-animate" style="margin: 2rem auto;">0 result matches criteria</div>
						</c:if>
					</div>
				</div>
				<div class="col-lg-5 sidebar">
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">Search</h3>
						<form:form action="restaurant" method="post" modelAttribute="searchModel" id="search-form">
							<div class="fields">
								<div class="form-group">
									<form:input type="text" path="name" id="name"
										class="form-control" placeholder="By name" />
								</div>
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<form:select path="ethnic" class="form-control">
											<option value="">By ethnic</option>
											<c:forEach items="${ keywordList.ethnicKeywords }" var="keyword">
												<option value="${ keyword.keywordId }">${ keyword.value }</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<div class="select-wrap one-third">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<form:select path="dietary" class="form-control">
											<option value="">By dietary</option>
											<c:forEach items="${ keywordList.dietaryKeywords }" var="keyword">
												<option value="${ keyword.keywordId }">${ keyword.value }</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<div class="range-slider">
										<div>By price</div>
										<span> 
											<form:input path="min" type="number" value="5" min="0" max="1200" class="form-number"/> - 
											<form:input path="max" type="number" value="100" min="0" max="1200" class="form-number"/>
										</span> 
									</div>
								</div>
								<div class="form-group" style="padding-top: 1.5rem">
									<input type="submit" value="Search"
										class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</form:form>
					</div>
					
					<div class="sidebar-wrap bg-light ftco-animate">
						<h3 class="heading mb-4">Cart</h3>
						<form:form action="restaurant/checkout" method="post" modelAttribute="checkoutList">
							<div id="cart-result">
							</div>
							
							<div class="form-group" style="padding-top: 1.5rem">
								<input type="submit" value="Checkout" id="checkout-btn"
									class="btn btn-primary py-3 px-5">
							</div>
						</form:form>
					</div>
					
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
	<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/additional-methods.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/custom-script.js"></script>

</body>
</html>