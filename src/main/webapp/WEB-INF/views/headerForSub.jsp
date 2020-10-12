<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="../home">Seventeen</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="../home" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="rooms.html" class="nav-link">Rooms</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Rental</a></li>
					<li class="nav-item"><a href="../restaurant" class="nav-link">Restaurant</a></li>
					<c:choose>
					    <c:when test="${accountModel != null && not empty accountModel.username}">
							<li class="nav-item"><a href="../logout" class="nav-link">Logout</a></li>
					    </c:when>
					    <c:otherwise>
							<li class="nav-item"><a href="../login" class="nav-link">Login</a></li>
							<li class="nav-item"><a href="../admin" class="nav-link">Admin</a> </li>
					    </c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
</body>
</html>