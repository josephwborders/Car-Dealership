<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<header id="header" class="fixed-top d-flex align-items-center">
		<div class="container d-flex align-items-center">

			<div class="logo me-auto">
				<h1>
					<a href="/">Online Car Dealer</a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>
			<nav id="navbar" class="navbar order-last order-lg-0">
				<c:choose>
					<c:when test="${user.role == 'customer'}">
						<ul>
							<li><a class="nav-link scrollto active" href="/welcome">Home</a></li>
							<li><a class="nav-link scrollto active" href="/search">Search Vehicles</a></li>
							<li class="dropdown"><a href="#"><span>My Account</span>
									<i class="bi bi-chevron-down"></i></a>
								<ul>
									<li><a href="/logout">Logout</a></li>

								</ul></li>
						</ul>
					</c:when>
					<c:when test="${user.role == 'admin'}">
						<ul>
							<li><a class="nav-link scrollto active" href="/welcome">Home</a></li>
							<li class="dropdown"><a href="#"><span>Manage
										Inventory</span> <i class="bi bi-chevron-down"></i></a>
								<ul>
									<li><a href="/welcome">View Active Listings</a></li>
									<li><a href="/search">Search Listings</a></li>
									<li><a href="/transactions">View Transactions</a></li>
									<li><a href="/newListing">Create New Listing</a></li>
								</ul></li>
							<li class="dropdown"><a href="#"><span>Manage
										Customers</span> <i class="bi bi-chevron-down"></i></a>
								<ul>
									<li><a href="/customers">Customer List</a></li>
								</ul></li>
							<li><a class="nav-link scrollto active" href="/logout">Logout</a></li>

						</ul>
					</c:when>
					<c:otherwise>
						<ul>
							<li><a class="nav-link scrollto active" href="/">Home</a></li>
							<li><a class="nav-link scrollto" href="/search">Search Vehicles</a></li>
							<li><a class="nav-link scrollto" href="#about">About</a></li>
							<li><a class="nav-link scrollto" href="#contact">Contact</a></li>
							<li><a class="nav-link scrollto" href="/login">Login</a></li>
							<li><a class="nav-link scrollto" href="/register">Register</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- .navbar -->

			<div class="header-social-links d-flex align-items-center">
				<a href="https://www.twitter.com" class="twitter"><i
					class="bi bi-twitter"></i></a> <a href="https://www.facebook.com"
					class="facebook"><i class="bi bi-facebook"></i></a> <a
					href="https://www.instagram.com" class="instagram"><i
					class="bi bi-instagram"></i></a> <a href="https://www.linkedin.com"
					class="linkedin"><i class="bi bi-linkedin"></i></a>
			</div>


		</div>
	</header>
</body>
</html>