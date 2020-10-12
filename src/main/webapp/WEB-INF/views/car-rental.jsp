<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
  <head>
    <title>Seventeen Hotel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
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
 
 <!-- Body -->
  <body>
  
  	<!-- Header Section -->
  	<jsp:include page="header.jsp" />

    <div class="hero-wrap" style="background-image: url('${pageContext.request.contextPath}/resources/images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2">
	            	<span class="mr-2"><a href="home">Home</a></span> <span>Car Rental</span>
	            </p>
	            <h1 class="mb-4 bread">Rent a Car</h1>
            </div>
          </div>
        </div>
      </div>
    </div>

	<!-- Section includes Room Display and Advanced Search box -->
    <section class="ftco-section bg-light">
    	<div class="container">
    		<div class="row">
	        <!-- Bootstrap column specification for the display of rooms -->
	        <div class="col-lg-9">
		    		<!-- Row of rooms -->
		    		<div class="row">
		    			<!-- Iterate through car list and display them -->
		    			<c:if test="${ carList != null && carList.size() > 0 }">
		    			<c:forEach items="${carList}" var="car" varStatus="status">
		    				<div class="col-sm col-md-6 col-lg-4 ftco-animate">
		    					<div class="room">
		    					<c:if test="${car.carStatus == 'available' || car.carStatus == 'Available'}">
		    						<a class="img d-flex justify-content-center align-items-center"
		    							style="background-image: url('${pageContext.request.contextPath}/resources/images/car_${car.carId}.jpg');">
		    						</a>
									<div class="text p-3 text-center">
										<h3 class="mb-3">${car.carName}</h3>
										<p>
											<span class="per">$</span>
											<span class="price mr-2">${car.carPrice}</span>
											<span class="per">per day</span>
										</p>
										<ul class="list">
			    							<li><span>Type:</span>${car.carType}</li>
			    							<li><span>Mileage:</span>${car.mileage}</li>
			    							<li><span>AC:</span>${car.ac}</li>
			    							<li><span>Manual:</span>${car.manual}</li>
			    							<li><span>Trunk Size:</span>${car.trunkSize}</li>
			    						</ul>
			    						<hr>
			    						<c:url var="changeCarAvailability" value="/car-rental/car-availability">
	                    					<c:param name="carId" value="${car.carId}"/>
	               			 			</c:url>
										<p class="pt-1"><a class="btn-custom" href="${changeCarAvailability}">Rent<span class="icon-long-arrow-right"></span></a></p>
									</div>
								</c:if>
								</div>
							</div>	
		    			</c:forEach>
		    			</c:if>
		    		</div>
		    </div>
		    	
		    	<!-- Bootstrap column specification for the display of advanced search box -->
		    	<div class="col-lg-3 sidebar">
	      		<div class="sidebar-wrap bg-light ftco-animate">
	      			<h3 class="heading mb-4">Search</h3>
	      			<form:form action="car-rental" method="post" modelAttribute="searchCarModel">
	      				<div class="fields">
		              		<div class="form-group">
		                		<form:input type="text" path="carName" class="form-control" placeholder="Search Car"/>
		              		</div>
		              		<div class="form-group">
		                		<input type="submit" value="Search" class="btn btn-primary py-3 px-5">
		              		</div>
		            	</div>
	            	</form:form>
	            	<p>--------------------</p>
	            	<h3 class="heading mb-4">Rented Car</h3>
	            	<div class="fields">
		      			<c:forEach items="${carList}" var="car" varStatus="status">
		      			
		      				<!-- Show car rented -->
			      			<c:if test="${car.carStatus == 'unavailable' || car.carStatus == 'Unavailable'}">
			      				<p>${car.carName}</p>
			      				<!-- Define functionality for Remove button -->
				      			<c:url var="changeCarAvailability" value="/car-rental/car-availability">
	                    			<c:param name="carId" value="${car.carId}"/>
	               			 	</c:url>
	               			 	
	               			 	<div class="form-group">
			                		<a class="btn btn-primary py-3 px-5" href="${changeCarAvailability}">Remove</a>
			                	</div>
			      			</c:if>
			            </c:forEach>  	
		            </div>
		            
	      		</div>
	        	</div> 	
		    </div>
    	</div>
    </section>

	<!-- Footer Section -->
	<jsp:include page="footer.jsp"></jsp:include>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen">
  	<svg class="circular" width="48px" height="48px">
  		<circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
  		<circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/>
  	</svg>
  </div>

  <!-- Script Code -->
  <script>
  	function clickMe(id) {
		alert(id);
	}
  	
  	function booleanChanger(val) {
  		if (val == true) {
  			return "Yes";
  		} else {
  			return "False";
  		}
  	}
  	
  	function clickRent() {
  		car.carStatus = 'unavailable';
  	}
  </script>
  
  <!-- Script Source -->
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