<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Congratulations!</title>
<meta content="" name="description">
<meta content="" name="keywords">
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,
400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|
Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
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
<jsp:include page="header.jsp"/>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs ======= -->
		<section id="breadcrumbs" class="breadcrumbs">
			<div class="container">
				<ol>
					<li><a href="/welcome">Home</a></li>
					<li>Successful Bid</li>
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
		<section class="inner-page">
			<div class="container">
				<h3 class="cover-heading">Congratulations!</h3>
				<br>
				<h4 class="text-success">${msg}</h4>
				<br>
				<div class="row align-items-center">
				<h5>${listing.vehicle.year} ${listing.vehicle.make} ${listing.vehicle.model} <del>$${listing.vehicle.price}</del></h5>
				</div>
				<div>
				<img alt="" src="${listing.vehicle.imagePath}"/>
				<br>
				<br>
				<p>You are bidding on a ${listing.vehicle.newOrUsed} ${listing.vehicle.year} ${listing.vehicle.make} ${listing.vehicle.model}</p>
				<ul>
				<li><em>Mileage: </em>${listing.vehicle.mileage}</li>
				<li><em>Engine: </em>${listing.vehicle.engine}</li>
				<li><em>Transmission: </em>${listing.vehicle.transmission}</li>
				<li><em>Color: </em>${listing.vehicle.color}</li>
				<li><em>Features: </em>${listing.vehicle.features}</li>
				</ul>
				<br>
				<h5 class="text-success"><em><del>Price: $${listing.vehicle.price}</del></em></h5>
				<br>
				<p><em>Your price: $${msg1}</em></p>
				<p class="text-danger"><em>*Clicking Pay Now will finalize your transaction.</em></p>
				<a href="payment?stockNumber=${listing.vehicle.stockNumber}&id=${user.id}&sellPrice=${bid}&saleType=Auction" class="text-info"><button class="myButton">Pay Now</button></a>
				
				<!--<button type="submit" value="submit" class="myButton">Bid Now!</button>  -->
				
			</div>
			</div>
		</section>

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