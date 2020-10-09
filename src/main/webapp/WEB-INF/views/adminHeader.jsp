<%--
  Created by IntelliJ IDEA.
  User: Osrio
  Date: 10/7/2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Header</title>
</head>
<body>
    <nav
        class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
        id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="home">Hotel Administration</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#ftco-nav" aria-controls="ftco-nav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="hotelStatus" class="nav-link">Hotel</a></li>
                <li class="nav-item"><a href="adminRoom" class="nav-link">Room</a></li>
                <li class="nav-item"><a href="carStatus" class="nav-link">Car</a></li>
                <li class="nav-item"><a href="foodStatus" class="nav-link">Food</a></li>
                <li class="nav-item"><a href="home" class="nav-link">Logout</a> </li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->
</body>
</html>
