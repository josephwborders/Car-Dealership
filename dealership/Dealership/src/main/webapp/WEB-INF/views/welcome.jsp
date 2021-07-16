<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html class="no-js" lang="eng">

<head>
    <meta http-equiv="refresh"  CONTENT="<%= session.getMaxInactiveInterval() %>;URL='<%= session.getServletContext().getContextPath() %>/login?expired=true" />
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Profile </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>
    
    <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/logo.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start-->

    <jsp:include page="components/header.jsp"/>

    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/category.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Welcome ${account.fname} ${account.lname}!!</h2>
                            <p>${msg} ${success} <span class="text-danger">${error}</span></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

    <!--================Blog Area =================-->
    <section class="blog_area section-padding">
        <div class="container">
            <div class="row">                
                <div class="col-lg-3">
                <aside class="single_sidebar_widget instagram_feeds">                     
                     <div class="d-flex justify-content-center">
                     <c:if test="${not empty account.image}">
                     <img class="img-fluid rounded-circle" src="assets/uploads/users/${account.id}/profile/${account.image}" alt="" >
                     </c:if>
                     </div>
                     <div class="d-flex justify-content-center">
                     <a href="#" data-toggle="modal" data-target="#add-images">
                      <i class="fa fa-upload text-body"></i></a>
                     </div>
                  </aside>
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget post_category_widget">
                            <h4 class="widget_title">Category</h4>
                            <ul class="list cat-list">
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>Resaurant food</p>
                                        <p>(37)</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>Travel news</p>
                                        <p>(10)</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>Inspiration</p>
                                        <p>21</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex">
                                        <p>Health Care (21)</p>
                                        <p>09</p>
                                    </a>
                                </li>
                            </ul>
                        </aside>
                    </div>
                </div>
                <div class="col-lg-9 mb-5 mb-lg-0">
                    <div class="blog_left_sidebar">
                        <article class="blog_item">
                            <div class="blog_details">
                                <a class="d-inline-block" href="single-blog.html">
                                    <h2>Google inks pact for new 35-storey office</h2>
                                </a>
                                <p>That dominion stars lights dominion divide years for fourth have don't stars is that
                                    he earth it first without heaven in place seed it second morning saying.</p>
                                <ul class="blog-info-link">
                                    <li><a href="#"><i class="fa fa-user"></i> ${account.fname} ${account.lname}</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> ${account.email}</a></li>
                                    <li><a href="#"><i class="fa fa-phone"></i> ${account.phone}</a></li>
                                    <li><a href="#" data-toggle="modal" data-target="#add-images">
                                    <i class="fa fa-upload text-center"></i>Add Image</a></li>
                                </ul>
                            </div>
                        </article>
                        
                        <div class="col-lg-12 col-md-12">		                    
		                            <h3>${msg} <br>
		                            <small class="text-danger">${error} ${param.error}</small></h3>
		                            <form:form action="updateuser" modelAttribute="account" method="Post" class="row">
									<div class="col-md-12 form-group p_star">
									<form:input path="id" type="hidden" />
									<form:input path="fname" type="text" class="form-control" placeholder="Enter First Name"/>
									</div>
									<div class="col-md-12 form-group">
									<form:input path="lname" type="text" class="form-control" placeholder="Enter First Name"/>
									</div>
									<div class="col-md-12 form-group p_star">
									<form:input path="phone" type="text" class="form-control" placeholder="Enter First Phone"/>
									</div>									
									<div class="col-md-12 form-group p_star">
									<form:input path="age" type="date" class="form-control" placeholder="Enter Age"/>
									</div>							
									<div class="col-md-12 form-group">
		                               <form:checkbox path="grade" value="Junior"/> 
		                              <label>Junior</label>
		                                <form:checkbox path="grade" value="Senior"/> 
		                               <label>Senior</label>
		                             <button type="submit" value="submit" class="btn_3">
		                               Submit
		                             </button>
		                            </div>
									</form:form>
							
		                </div>

                        <nav class="blog-pagination justify-content-center d-flex">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a href="#" class="page-link" aria-label="Previous">
                                        <i class="ti-angle-left"></i>
                                    </a>
                                </li>
                                <li class="page-item">
                                    <a href="#" class="page-link">1</a>
                                </li>
                                <li class="page-item active">
                                    <a href="#" class="page-link">2</a>
                                </li>
                                <li class="page-item">
                                    <a href="#" class="page-link" aria-label="Next">
                                        <i class="ti-angle-right"></i>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->

    <footer>
        <!-- Footer Start-->
        <div class="footer-area footer-padding2">
            <div class="container">
                <div class="row d-flex justify-content-between">
                    <div class="col-xl-3 col-lg-3 col-md-5 col-sm-6">
                       <div class="single-footer-caption mb-50">
                         <div class="single-footer-caption mb-30">
                              <!-- logo -->
                             <div class="footer-logo">
                                 <a href="index.html"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
                             </div>
                             <div class="footer-tittle">
                                 <div class="footer-pera">
                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit sed do eiusmod tempor incididunt ut labore.</p>
                                </div>
                             </div>
                         </div>
                       </div>
                    </div>
                    <div class="col-xl-2 col-lg-3 col-md-3 col-sm-5">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Quick Links</h4>
                                <ul>
                                    <li><a href="#">About</a></li>
                                    <li><a href="#"> Offers & Discounts</a></li>
                                    <li><a href="#"> Get Coupon</a></li>
                                    <li><a href="#">  Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-4 col-sm-7">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>New Products</h4>
                                <ul>
                                    <li><a href="#">Woman Cloth</a></li>
                                    <li><a href="#">Fashion Accessories</a></li>
                                    <li><a href="#"> Man Accessories</a></li>
                                    <li><a href="#"> Rubber made Toys</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-5 col-sm-7">
                        <div class="single-footer-caption mb-50">
                            <div class="footer-tittle">
                                <h4>Support</h4>
                                <ul>
                                 <li><a href="#">Frequently Asked Questions</a></li>
                                 <li><a href="#">Terms & Conditions</a></li>
                                 <li><a href="#">Privacy Policy</a></li>
                                 <li><a href="#">Privacy Policy</a></li>
                                 <li><a href="#">Report a Payment Issue</a></li>
                             </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer bottom -->
                <div class="row">
                 <div class="col-xl-7 col-lg-7 col-md-7">
                     <div class="footer-copy-right">
                         <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>                   </div>
                 </div>
                  <div class="col-xl-5 col-lg-5 col-md-5">
                     <div class="footer-copy-right f-right">
                         <!-- social -->
                         <div class="footer-social">
                             <a href="#"><i class="fab fa-twitter"></i></a>
                             <a href="#"><i class="fab fa-facebook-f"></i></a>
                             <a href="#"><i class="fab fa-behance"></i></a>
                             <a href="#"><i class="fas fa-globe"></i></a>
                         </div>
                     </div>
                 </div>
             </div>
            </div>
        </div>
        <!-- Footer End-->
      </footer>
      
      <div class="modal fade" id="add-images" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-scrollable" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form method="POST" action="addimages" enctype="multipart/form-data"  >			
	      <div class="modal-body">
	          <img id="output_image" class="col-md-10 rounded-circle"/>
                <div class="custom-file mb-3">
				  <input type="file" name="file" class="custom-file-input" id="customFile" onchange="preview_image(event)">
				      <label class="custom-file-label" for="customFile">File Input</label>
				  </div>
				<input name="id" type="hidden" value="${account.id}" >
	      </div>
	      <div class="modal-footer">
	        <button type="submit" class="btn btn-primary btn-sm">Save</button>
            <a href="#" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</a>
                                                                        
	      </div>
	      </form>
	    </div>
	  </div>
	</div>


      
     
      
     											 <div class="modal fade show"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                                                    <div class="modal-dialog modal-md" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Add Profile Image</h5>
                                                                <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                                   <span aria-hidden="true">×</span>
                                                                </a>
                                                            </div>
                                                           <form method="POST" action="addimages" enctype="multipart/form-data"  >
			               
                                                           <div class="modal-body">
                                                           <img id="output_image" class="col-md-10 rounded-circle"/>
                                                         
                                                           <div class="custom-file mb-3">
				                                                <input type="file" name="file" class="custom-file-input" id="customFile" onchange="preview_image(event)">
				                                                <label class="custom-file-label" for="customFile">File Input</label>
				                                           </div>
												            <input name="id" type="hidden" value="${account.id}" >
												           </div>
                                                            <div class="modal-footer">
                                                                <button type="submit" class="btn btn-primary btn-sm">Save</button>
                                                                <a href="#" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</a>
                                                                
                                                            </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>

<!-- JS here -->
		<!-- All JS Custom Plugins Link Here here -->
        <script src="assets/js/vendor/modernizr-3.5.0.min.js"></script>
		
		<!-- Jquery, Popper, Bootstrap -->
		<script src="assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
	    <!-- Jquery Mobile Menu -->
        <script src="assets/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/slick.min.js"></script>

		<!-- One Page, Animated-HeadLin -->
        <script src="assets/js/wow.min.js"></script>
		<script src="assets/js/animated.headline.js"></script>
		
		<!-- Scrollup, nice-select, sticky -->
        <script src="assets/js/jquery.scrollUp.min.js"></script>
        <script src="assets/js/jquery.nice-select.min.js"></script>
		<script src="assets/js/jquery.sticky.js"></script>
        <script src="assets/js/jquery.magnific-popup.js"></script>

        <!-- contact js -->
        <script src="assets/js/contact.js"></script>
        <script src="assets/js/jquery.form.js"></script>
        <script src="assets/js/jquery.validate.min.js"></script>
        <script src="assets/js/mail-script.js"></script>
        <script src="assets/js/jquery.ajaxchimp.min.js"></script>
        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
 		<script>
        function confirmed(){
            if (confirm('You are about to delete, Do you want to proceed?')) {
                  document.getElementById("del").submit();
                  return true;
            } else {
               return false;
            }
         }
            
    $("#searchnow").keyup(function () {
        var value = this.value.toLowerCase().trim();

        $("table tr").each(function (index) {
            if (!index) return;
            $(this).find("td").each(function () {
                var id = $(this).text().toLowerCase().trim();
                var not_found = (id.indexOf(value) == -1);
                $(this).closest('tr').toggle(!not_found);
                return not_found;
            });
        });
    });
    
    function preview_image(event)
    {
     var reader = new FileReader();
     reader.onload = function()
     {
      var output = document.getElementById('output_image');
      output.classList.add("preview");
      output.src = reader.result;
     }
     reader.readAsDataURL(event.target.files[0]);
    }
    
   </script>
</body>
</html>