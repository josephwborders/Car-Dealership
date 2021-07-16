 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <header>
        <!-- Header Start -->
       <div class="header-area">
            <div class="main-header ">
                <div class="header-top top-bg d-none d-lg-block">
                   <div class="container-fluid">
                       <div class="col-xl-12">
                            <div class="row d-flex justify-content-between align-items-center">
                                <div class="header-info-left d-flex">
                                    <div class="flag">
                                        <img src="assets/img/icon/header_icon.png" alt="">
                                    </div>
                                    <div class="select-this">
                                        <form action="#">
                                            <div class="select-itms">
                                                <select name="select" id="select1">
                                                    <option value="">USA</option>
                                                    <option value="">SPN</option>
                                                    <option value="">CDA</option>
                                                    <option value="">USD</option>
                                                </select>
                                            </div>
                                        </form>
                                    </div>
                                    <ul class="contact-now">     
                                        <li>+777 2345 7886</li>
                                    </ul>
                                </div>
                                <div class="header-info-right">
                                   <ul> 
                                       <li><a href="#">Wish List  </a></li>
                                       <li><a href="#">Shopping</a></li>
                                       <li><a href="#">Cart</a></li>
                                       <li><a href="#">Checkout</a></li>
                                       <c:choose>
									    <c:when test="${not empty email}">
										<li><a href="profile">My Profile</a></li>
										<li><a href="logout">Logout</a></li>
										</c:when>
										<c:otherwise>
										<li><a href="signup">Register</a></li>
										<li><a href="login">Login</a></li>
										</c:otherwise>
									   </c:choose>                                       
                                   </ul>
                                </div>
                            </div>
                       </div>
                   </div>
                </div>
               <div class="header-bottom  header-sticky">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-3">
                                <div class="logo">
                                  <a href="index"><img src="assets/img/logo/logo.png" alt=""></a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-8 col-md-7 col-sm-5">
                                <!-- Main-menu -->
                                <div class="main-menu f-right d-none d-lg-block">
                                    <nav>                                                
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="index">Home</a></li>
                                            <li><a href="about">About</a></li>
                                            <li><a href="contact">Contact</a></li>
                                            <li><a href="#">Pages</a>
                                                <ul class="submenu">
                                                    <li><a href="about">About</a></li>
                                                    <li><a href="#">Confirmation</a></li>
                                                    <li><a href="#">Shopping Cart</a></li>
                                                    <li><a href="#">Product Checkout</a></li>                                                    
													<c:if test="${not empty email}">
													<li><a href="profile">My Profile</a></li>
													<li><a href="users">Users</a></li>
													<li><a href="logout">Logout</a></li>
													</c:if>
													<c:if test="${empty email}">
													<li><a href="signup">Register</a></li>
													<li><a href="login">Sign in</a></li>
													</c:if>													
                                                </ul>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div> 
                            <div class="col-xl-5 col-lg-3 col-md-3 col-sm-3 fix-card">
                                <ul class="header-right f-right d-none d-lg-block d-flex justify-content-between">
                                    <li class="d-none d-xl-block">
                                        <div class="form-box f-right ">
                                           <form id="myform" action="search" method="post">
	                                            <input type="text" name="keyword" placeholder="Search Users">
	                                            	<a href="#" onclick="document.getElementById('myform').submit()">
	                                            		<div class="search-icon">
	                                                	<i class="fas fa-search special-tag"></i>
	                                            		</div>
	                                            	</a>
                                            </form>
                                        </div>
                                     </li>
                                    <li class=" d-none d-xl-block">
                                        <div class="favorit-items">
                                            <i class="far fa-heart"></i>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="shopping-card">
                                            <a href="#"><i class="fas fa-shopping-cart"></i></a>
                                        </div>
                                    </li>
                                    
                                   
                                   
                                </ul>
                            </div>
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
               </div>
            </div>
       </div>
        <!-- Header End -->
    </header>