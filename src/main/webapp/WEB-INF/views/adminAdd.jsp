<%--
  Created by IntelliJ IDEA.
  User: Osrio
  Date: 10/10/2020
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Admin Add Service</title>
</head>
<body>
    <!-- header nav bar -->
    <jsp:include page="adminHeader.jsp" />

    <section class="home-slider owl-carousel">
        <div class="slider-item"
             style="background-image: url(${pageContext.request.contextPath}/resources/images/bg_1.jpg);">
            <div class="overlay"></div>
            <div class="container">
                <div
                        class="row no-gutters slider-text align-items-center justify-content-center">
                    <div class="col-md-12 ftco-animate text-center">
                        <div class="text mb-5 pb-3">
                            <h1 class="mb-3">Add Services</h1>
                            <h2>Add New Room, Food, or Car</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center mb-5 pb-3">
                <div class="col-md-7 heading-section text-center ftco-animate">
                    <h2>Add Services</h2>
                </div>
            </div>
            <div class="container">
                <form action="${pageContext.request.contextPath}/adminAdd/addRoom" method="post">
                    <div class="row justify-content-center mb-5 pb-3">
                        <div class="col-md-7 heading-section text-center ftco-animate">
                            <h3>Add New Room</h3>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="roomFloor">Room Floor</label>
                        <input type="text" class="form-control" id="roomFloor" placeholder="e.g 1">
                    </div>
                    <div class="form-group">
                        <label for="roomNumber">Room Number</label>
                        <input type="text" class="form-control" id=roomNumber placeholder="e.g 101">
                    </div>
                    <div class="form-group">
                        <label for="roomPrice">Price</label>
                        <input type="text" class="form-control" id="roomPrice" placeholder="e.g 86.3">
                    </div>
                    <div class="form-group">
                        <label for="roomType">Type</label>
                        <input type="text" class="form-control" id="roomType" placeholder="e.g Single">
                    </div>
                    <div class="form-group">
                        <label for="roomStatus" class="form-group">Status</label>
                        <input type="text" class="form-control" id="roomStatus" placeholder="e.g Available">
                    </div>
                    <div class="form-group">
                        <label for="hotelId" class="form-group">Hotel ID</label>
                        <input type="text" class="form-control" id="hotelId" placeholder="e.g 1">
                    </div>
                    <div class="form-group">
                        <label for="bedNumber" class="form-group">Number of Beds</label>
                        <input type="text" class="form-control" id="bedNumber" placeholder="e.g 1">
                    </div>
                    <div class="form-group">
                        <label for="roomView" class="form-group">Outside View</label>
                        <input type="text" class="form-control" id="roomView" placeholder="e.g City">
                    </div>
                    <div class="form-group">
                        <label for="maxCapacity" class="form-group">Max Capacity</label>
                        <input type="text" class="form-control" id="maxCapacity" placeholder="e.g 1">
                    </div>
                    <div class="form-group">
                        <label for="bathtub" class="form-group">Bathtub</label>
                        <input type="text" class="form-control" id="bathtub" placeholder="e.g 1">
                    </div>
                    <button type="submit" class="btn btn-info">Add New Room</button>
                </form>
            </div>
            <div class="container">
                <form action="${pageContext.request.contextPath}/adminAdd/addFood" method="post">
                    <div class="row justify-content-center mb-5 pb-3">
                        <div class="col-md-7 heading-section text-center ftco-animate">
                            <h3>Add New Food</h3>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="foodName">Food Name</label>
                        <input type="text" class="form-control" id="foodName" placeholder="e.g Mashed Potato">
                    </div>
                    <div class="form-group">
                        <label for="foodPrice">Price</label>
                        <input type="text" class="form-control" id=foodPrice placeholder="e.g 6.99">
                    </div>
                    <div class="form-group">
                        <label for="foodRecommendation">Recommendation</label>
                        <input type="text" class="form-control" id="foodRecommendation" placeholder="e.g 0">
                    </div>
                    <div class="form-group">
                        <label for="foodDesc">Type</label>
                        <input type="text" class="form-control" id="foodDesc" placeholder="e.g Mashed potato with butter, milk, salt and pepper">
                    </div>
                    <button type="submit" class="btn btn-info">Add New Dish</button>
                </form>
            </div>
        </div>
    </section>
    <!-- footer -->
    <jsp:include page="footer.jsp"/>

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
