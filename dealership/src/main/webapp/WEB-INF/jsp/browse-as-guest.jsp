<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Browse Inventory</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: Scaffold - v4.3.0
  * Template URL: https://bootstrapmade.com/scaffold-bootstrap-metro-style-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<!-- ======= Header ======= -->
	<jsp:include page="header.jsp" />
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs ======= -->
		<section id="breadcrumbs" class="breadcrumbs">
			<div class="container">
				<ol>
					<li><a href="/">Home</a></li>
					<li>Browse Inventory</li>
				</ol>
				<c:if test="${not empty user}">
				<h2>Logged in as ${user.firstName}</h2>
				</c:if>
				<c:if test="${empty user}">
				<h2>Welcome, Guest</h2>
				</c:if>
			</div>
		</section>
		<!-- End Breadcrumbs -->
		<main role="main" class="inner cover">
			<section class="inner-page">
				<div class="container">
					<p>
					<h2 class="cover-heading">Vehicles For Sale</h2>
					<br> <br>
					<div class="row align-items-center">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Condition</th>
									<th>Year</th>
									<th>Make</th>
									<th>Model</th>
									<th>Mileage</th>
									<th>Price</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listings}">
									<tr>
										<td><img src="${item.vehicle.imagePath}" width="300px" height="200px"/></td>
										<td>${item.vehicle.newOrUsed}</td>
										<td>${item.vehicle.year}</td>
										<td>${item.vehicle.make}</td>
										<td>${item.vehicle.model}</td>
										<td>${item.vehicle.mileage}</td>
										<td>${item.vehicle.price}</td>
										<td><a href="details?stockNumber=${item.vehicle.stockNumber}" class="text-info"><button class="myButton">View Detail</button></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</section>

		</main>




	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<jsp:include page="footer.jsp" />
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/aos/aos.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>