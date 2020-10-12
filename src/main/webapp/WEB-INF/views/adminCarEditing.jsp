<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"></head>
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
                        <h1 class="mb-3">Editing Car Details</h1>
                        <h2>Car Editing</h2>
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
                <h3>Editing Information</h3>
            </div>
        </div>
        <c:url var="editLink" value="/adminCar/edit">
            <c:param name="carId" value="${updatingCar.carId}"/>
        </c:url>
        <%--@elvariable id="updatingDish" type="com.spring.entity.CarEntity"--%>
        <f:form action="${editLink}" method="post" modelAttribute="updatingCar">
            <div class="row justify-content-center mb-5 pb-3">
                <div class="col-md-7 heading-section text-center ftco-animate">
                    <h3>Edit Car Information</h3>
                </div>
            </div>
            <div class="form-group">
                <f:label for="carName" path="carName">Car Name</f:label>
                <f:input path="carName" type="text" class="form-control" id="carName" value="${updatingCar.carName}"/>
            </div>
            <div class="form-group">
                <f:label path="carType" for="carType">Type</f:label>
                <f:input path="carType" type="text" class="form-control" id="carType" value="${updatingCar.carType}"/>
            </div>
            <div class="form-group">
                <f:label path="carPrice" for="carPrice">Price</f:label>
                <f:input path="carPrice" type="text" class="form-control" id="foodRecommendation" value="${updatingCar.carPrice}"/>
            </div>
            <div class="form-group">
                <f:label path="carStatus" for="carStatus">Status</f:label>
                <f:input path="carStatus" type="text" class="form-control" id="carStatus" value="${updatingCar.carStatus}"/>
            </div>
            <div class="form-group">
                <f:label path="mileage" for="mileage">Mileage</f:label>
                <f:input path="mileage" type="text" class="form-control" id="mileage" value="${updatingCar.mileage}"/>
            </div>
            <div class="form-group">
                <f:label path="ac" for="ac">AC</f:label>
                <f:input path="ac" type="text" class="form-control" id="ac" value="${updatingCar.ac}"/>
            </div>
            <div class="form-group">
                <f:label path="manual" for="manual">Manual</f:label>
                <f:input path="manual" type="text" class="form-control" id="manual" value="${updatingCar.manual}"/>
            </div>
            <div class="form-group">
                <f:label path="trunkSize" for="trunkSize">Trunk Size</f:label>
                <f:input path="trunkSize" type="text" class="form-control" id="trunkSize" value="${updatingCar.trunkSize}"/>
            </div>
            <button type="submit" class="btn btn-info">Update</button>
        </f:form>
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
