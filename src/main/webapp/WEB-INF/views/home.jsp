<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
							<h1 class="mb-3">Welcome To Seventeen</h1>
							<h2>Hotels &amp; Resorts</h2>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="slider-item"
			style="background-image: url(${pageContext.request.contextPath}/resources/images/bg_2.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row no-gutters slider-text align-items-center justify-content-center">
					<div class="col-md-12 ftco-animate text-center">
						<div class="text mb-5 pb-3">
							<h1 class="mb-3">Enjoy Luxury Experiences</h1>
							<h2>Join With Us</h2>
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
					<form action="rooms" class="booking-form" method="post">
						<div class="row">
							<div class="col-md-3 d-flex">
								<div
									class="form-group p-4 align-self-stretch d-flex align-items-end">
									<div class="wrap">
										<label for="#">Check-in Date</label> <input type="text"
											id="checkinDate" name="checkinDate" class="form-control checkin_date" placeholder="Check-in date">
									</div>
								</div>
							</div>
							<div class="col-md-3 d-flex">
								<div
									class="form-group p-4 align-self-stretch d-flex align-items-end">
									<div class="wrap">
										<label for="#">Check-out Date</label> <input type="text"
											class="form-control checkout_date"
											placeholder="Check-out date"
											id="checkoutDate"
											name="checkoutDate">
									</div>
								</div>
							</div>
							<div class="col-md d-flex">
								<div
									class="form-group p-4 align-self-stretch d-flex align-items-end">
									<div class="wrap">
										<label for="#">Room</label>
										<div class="form-field">
											<div class="select-wrap">
												<div class="icon">
													<span class="ion-ios-arrow-down"></span>
												</div>
												<select name="roomType" id="roomType" class="form-control">
													
													<option value="Single">Single</option>
													<option value="Double">Double</option>
													<option value="Triple">Triple</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md d-flex">
								<div
									class="form-group p-4 align-self-stretch d-flex align-items-end">
									<div class="wrap">
										<label for="#">Customer</label>
										<div class="form-field">
											<div class="select-wrap">
												<div class="icon">
													<span class="ion-ios-arrow-down"></span>
												</div>
												<select name="numberOfPeople" id="numberOfPeople" class="form-control">
													<option value="1">1 Adult</option>
													<option value="2">2 Adult</option>
													<option value="3">3 Adult</option>
													<option value="4">4 Adult</option>
													<option value="5">5 Adult</option>
													<option value="6">6 Adult</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md d-flex">
								<div class="form-group d-flex align-self-stretch">
									<input type="submit" value="rooms"
										class="btn btn-primary py-3 px-4 align-self-stretch">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section ftc-no-pb ftc-no-pt">
		<div class="container">
			<div class="row">
				<div
					class="col-md-5 p-md-5 img img-2 d-flex justify-content-center align-items-center"
					style="background-image: url(${pageContext.request.contextPath}/resources/images/bg_2.jpg);">
					<a href="https://vimeo.com/45830194"
						class="icon popup-vimeo d-flex justify-content-center align-items-center">
						<span class="icon-play"></span>
					</a>
				</div>
				<div class="col-md-7 py-5 wrap-about pb-md-5 ftco-animate">
					<div
						class="heading-section heading-section-wo-line pt-md-5 pl-md-5 mb-5">
						<div class="ml-md-0">
							<span class="subheading">Welcome to Deluxe Hotel</span>
							<h2 class="mb-4">Welcome To Our Hotel</h2>
						</div>
					</div>
					<div class="pb-md-5">
						<p>On her way she met a copy. The copy warned the Little Blind
							Text, that where it came from it would have been rewritten a
							thousand times and everything that was left from its origin would
							be the word "and" and the Little Blind Text should turn around
							and return to its own, safe country. But nothing the copy said
							could convince her and so it didn’t take long until a few
							insidious Copy Writers ambushed her, made her drunk with Longe
							and Parole and dragged her into their agency, where they abused
							her for their.</p>
						<p>When she reached the first hills of the Italic Mountains,
							she had a last view back on the skyline of her hometown
							Bookmarksgrove, the headline of Alphabet Village and the subline
							of her own road, the Line Lane. Pityful a rethoric question ran
							over her cheek, then she continued her way.</p>
						<ul class="ftco-social d-flex">
							<li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
							<li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
							<li class="ftco-animate"><a href="#"><span class="icon-google-plus"></span></a></li>
							<li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row d-flex">
				<div class="col-md-3 d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services py-4 d-block text-center">
						<div class="d-flex justify-content-center">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="flaticon-reception-bell"></span>
							</div>
						</div>
						<div class="media-body p-2 mt-2">
							<h3 class="heading mb-3">25/7 Front Desk</h3>
							<p>A small river named Duden flows by their place and
								supplies.</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services py-4 d-block text-center">
						<div class="d-flex justify-content-center">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="flaticon-serving-dish"></span>
							</div>
						</div>
						<div class="media-body p-2 mt-2">
							<h3 class="heading mb-3">Restaurant Bar</h3>
							<p>A small river named Duden flows by their place and
								supplies.</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 d-flex align-sel Searchf-stretch ftco-animate">
					<div class="media block-6 services py-4 d-block text-center">
						<div class="d-flex justify-content-center">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="flaticon-car"></span>
							</div>
						</div>
						<div class="media-body p-2 mt-2">
							<h3 class="heading mb-3">Transfer Services</h3>
							<p>A small river named Duden flows by their place and
								supplies.</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services py-4 d-block text-center">
						<div class="d-flex justify-content-center">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="flaticon-spa"></span>
							</div>
						</div>
						<div class="media-body p-2 mt-2">
							<h3 class="heading mb-3">Spa Suites</h3>
							<p>A small river named Duden flows by their place and
								supplies.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section ftco-counter img" id="section-counter"
		style="background-image: url(${pageContext.request.contextPath}/resources/images/bg_1.jpg);">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-10">
					<div class="row">
						<div
							class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<strong class="number" data-number="50000">0</strong> <span>Happy
										Guests</span>
								</div>
							</div>
						</div>
						<div
							class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<strong class="number" data-number="3000">0</strong> <span>Rooms</span>
								</div>
							</div>
						</div>
						<div
							class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<strong class="number" data-number="1000">0</strong> <span>Staffs</span>
								</div>
							</div>
						</div>
						<div
							class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
							<div class="block-18 text-center">
								<div class="text">
									<strong class="number" data-number="100">0</strong> <span>Destination</span>
								</div>
							</div>
						</div>
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
	<!-- <script src="${pageContext.request.contextPath}/resources/js/jquery.timepicker.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/resources/js/scrollax.min.js"></script>
	<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="${pageContext.request.contextPath}/resources/js/google-map.js"></script> -->
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>