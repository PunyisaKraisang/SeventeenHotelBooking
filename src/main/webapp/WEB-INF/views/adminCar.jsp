<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="t"%>
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
<jsp:include page="adminHeader.jsp" />
<div class="hero-wrap" style="background-color: #4c463b; height: 90px; width:100%">
    <div class="overlay"></div>
    <div class="container">
    </div>
</div>
<section class="ftco-section">
    <div class="container">
        <div
                class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-12 ftco-animate text-center">
                <div class="text mb-5 pb-3">
                    <h1 class="mb-3">Car Management</h1>
                    <h2>View & Edit Car</h2>
                </div>
            </div>
        </div>
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section text-center ftco-animate">
                <h2>Car Provided for Rental</h2>
            </div>
        </div>
    </div>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section text-center ftco-animate">
                        <h3>Car Rental</h3>
                    </div>
                </div>
            </tr>
            <tr>
                <th scope="col">Car Id</th>
                <th scope="col">Car Name</th>
                <th scope="col">Price</th>
                <th scope="col">Type</th>
                <th scope="col">Mileage</th>
                <th scope="col">AC</th>
                <th scope="col">Manual</th>
                <th scope="col">Trunk Size</th>
                <th scope="col">Status</th>
                <th scope="col">Change Availability</th>
                <th scope="col">Edit Information</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="car" items="${carList}">
                <c:url var="changeAvailability" value="/adminCar/availability">
                    <c:param name="carId" value="${car.carId}"/>
                </c:url>
                <c:url var="editLink" value="/adminCar/edit">
                    <c:param name="carId" value="${car.carId}"/>
                </c:url>
                <c:url var="deleteLink" value="/adminCar/delete">
                    <c:param name="carId" value="${car.carId}"/>
                </c:url>
                <tr>
                    <td>${car.carId}</td>
                    <td>${car.carName}</td>
                    <td>${car.carPrice}</td>
                    <td>${car.carType}</td>
                    <td>${car.mileage}</td>
                    <td>${car.ac}</td>
                    <td>${car.manual}</td>
                    <td>${car.trunkSize}</td>
                    <td>${car.carStatus}</td>
                    <c:choose>
                        <c:when test="${car.carStatus.equals('Available')}">
                            <td><a class="btn" href="${changeAvailability}">Disable</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a class="btn" href="${changeAvailability}">Enable</a></td>
                        </c:otherwise>
                    </c:choose>
                    <td><a class="btn" href="${editLink}">Edit</a></td>
                    <td><a class="btn" href="${deleteLink}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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
