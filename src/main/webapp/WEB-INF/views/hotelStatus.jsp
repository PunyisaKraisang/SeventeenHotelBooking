<%--
  Created by IntelliJ IDEA.
  User: Osrio
  Date: 10/7/2020
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
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
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-12 ftco-animate text-center">
                <div class="text mb-5 pb-3">
                    <h1 class="mb-3">Hotel Status</h1>
                    <h2>Summary Information of Hotel</h2>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section text-center ftco-animate">
                <h2>Hotel Room Information</h2>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="container">
            <table class="table table-hover">
                <tbody>
                    <tr>
                        <th>Total Rooms</th>
                        <td>${roomInfo.get("totalNum")}</td>
                    </tr>
                    <tr>
                        <th>Available Rooms</th>
                        <td>${roomInfo.get("avaNum")}</td>
                    </tr>
                    <tr>
                        <th>Occupied Room</th>
                        <td>${roomInfo.get("occNum")}</td>
                    </tr>
                    <tr>
                        <th>Room with Cleaning</th>
                        <td>${roomInfo.get("cleanNum")}</td>
                    </tr>
                    <tr>
                        <th>Room with Maintaining</th>
                        <td>${roomInfo.get("maintainNum")}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section text-center ftco-animate">
                <h2>Hotel Menu Information</h2>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="container">
            <table class="table table-hover">
                <tbody>
                <tr>
                    <th>Total Foods</th>
                    <td>${foodInfo.get("totalNum")}</td>
                </tr>
                <tr>
                    <th>Average Cost</th>
                    <td>${foodInfo.get("avgCost")}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section text-center ftco-animate">
                <h2>Hotel Car Rental Information</h2>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="container">
            <table class="table table-hover">
                <tbody>
                <tr>
                    <th>Total Car</th>
                    <td>${carInfo.get("totalNum")}</td>
                </tr>
                <tr>
                    <th>Available Cars</th>
                    <td>${carInfo.get("avaNum")}</td>
                </tr>
                <tr>
                    <th>Non-available Cars</th>
                    <td>${carInfo.get("unavaNum")}</td>
                </tr>
                <tr>
                    <th>Average cost pre day</th>
                    <td>${carInfo.get("avgCost")}</td>
                </tr>
                </tbody>
            </table>
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
