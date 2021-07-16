<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Create New Listing</title>
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
	<!-- ======= Breadcrumbs ======= -->
	<section id="breadcrumbs" class="breadcrumbs">
		<div class="container">

			<ol>
				<li><a href="index.html">Home</a></li>
				<li>Create Listing</li>
			</ol>
			<h2>Logged in as ${user.firstName}</h2>

		</div>
	</section>
	<!-- End Breadcrumbs -->
	<!-- ======= Hero Section ======= -->
	<section id="hero">

		<div class="container">
			<div class="row">
				<div
					class="col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column justify-content-center"
					data-aos="fade-up">
					<div>
						<h2>Create a New Listing</h2>
						<form:form action="/newListing" modelAttribute="listing"
							method="post">
							<label for="inputNewOrUsed">New or Used</label>
							<form:select path="vehicle.newOrUsed" id="inputNewOrUsed"
								class="form-control" required="ON">
								<option selected>Choose...</option>
								<option value="New">New</option>
								<option value="Used">Used</option>
							</form:select>
							<label for="inputType">Vehicle Type</label>
							<form:select path="vehicle.type" id="inputType"
								class="form-control" required="ON">
								<option selected>Choose...</option>
								<option value="Car">Car</option>
								<option value="Truck">Truck</option>
								<option value="Van">Van</option>
								<option value="Motorcycle">Motorcycle</option>
							</form:select>
							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="inputPrice">Price</label>
									<form:input path="vehicle.price" type="double"
										class="form-control" id="inputPrice" required="ON" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputYear">Year</label>
									<form:input path="vehicle.year" type="int" class="form-control"
										id="inputYear" required="ON" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputMake">Make</label>
									<form:input path="vehicle.make" type="text"
										class="form-control" id="inputMake" required="ON" />
								</div>
							</div>
							<div class="form-group col-md-12">
								<label for="inputModel">Model</label>
								<form:input path="vehicle.model" type="text"
									class="form-control" id="inputModel" required="ON" />
							</div>


							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="inputColor">Color</label>
									<form:input path="vehicle.color" type="text"
										class="form-control" id="inputColor" required="ON" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputMileage">Mileage</label>
									<form:input path="vehicle.mileage" type="int"
										class="form-control" id="inputMileage" required="ON" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputEngine">Engine</label>
									<form:input path="vehicle.engine" type="text"
										class="form-control" id="inputEngine" required="ON" />
								</div>
							</div>
							<div class="form-group col-md-12">
								<label for="inputTransmission">Transmission</label>
								<form:input path="vehicle.transmission" type="text"
									class="form-control" id="inputTransmission" required="ON" />
							</div>

							<div class="form-row">
								<div class="form-group col-md-12">
									<label for="inputfeatures">Features</label>
									<form:input path="vehicle.features" type="text"
										class="form-control" id="inputFeatures" required="ON" />
								</div>
							</div>
							<button class="myButton">Upload Image</button><br>
							<button type="submit" class="myButton">Create Listing</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- End Hero -->

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