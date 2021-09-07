<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <meta name="description" content="Online garden shop">
    <meta name="keywords" content="garden, shop, plants, decorate,
            decoration">


    <!--ios compatibility-->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-title" content="garden Shop">
    <link rel="apple-touch-icon" href="apple-icon-144x144.png">


    <!--Android compatibility-->

    <meta name="mobile-web-app-capable" content="yes">
    <meta name="application-name" content="Garden Shop">
    <link rel="icon" type="image/png" href="android-icon-192x192.png">

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />


    <!--FONTS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/front/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!--THEME CSS-->
    <link href="${pageContext.request.contextPath}/front/css/theme.css" rel="stylesheet" type="text/css" />




    <title>Garden Shop</title>
</head>

<body>
   
   	<!-- Header and Navigation -->
	<jsp:include page="include-front-header.jsp"/>

<main>

    <!--BREADCRUMBS START-->
    <div class="container">
        <section class="product-breadcrumb d-none d-lg-block" style="background: #fff;">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="homepage">Homepage</a></li>
                    <li class="breadcrumb-item"><a href="shop-list">Shop</a></li>
                    <li class="breadcrumb-item"><a href="shop-list?category=${product.category.id}">${product.category.name}</a></li>
                   
                </ol>
            </nav>
        </section>
    </div>
    <!--BREADCRUMBS ENDS-->


    <!--SINGLE PRODUCT START-->
    <section class="single-product" style="background-color: #fff;">
        <div class="container">
            <div class="row">
                <div class="col-md-6 mb-3 mb-md-0">
                    <figure class="text-center product-img d-inline-block">
                        <img src="${product.image}" alt="" />
                        <span class="zoom-img">
                            <img src="${pageContext.request.contextPath}/front/img/zoom/icon.png" alt="" />
                        </span>
                    </figure>
                </div>
                <div class="col-md-6 mb-4 mb-md-0">
                    <div class="single-product-details">
                        <h3><a class="text-uppercase" href="#">${product.title }</a></h3>
                        <a class="category">${product.category.name}</a>
                        <div class="sticker-wrapper">
                        
                        <c:forEach var="sticker" items="${product.stickers}">
                        
                            <span class="sticker" style="background-color: ${sticker.color};">${sticker.title}</span>
                           
                            </c:forEach>
                        </div>
                        <h6 class="text-uppercase">${product.category.name} - ${product.id}</h6>
                         <iframe
                            src="https://www.facebook.com/plugins/like.php?href=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&width=340&layout=standard&action=like&size=small&show_faces=false&share=false&height=35&appId"
                            width="340" height="25" style="border:none;overflow:hidden" scrolling="no" frameborder="0"
                            allowTransparency="true"></iframe>       
                            <h5 class="text-uppercase">${product.price} din</h5>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--SINGLE PRODUCT ENDS-->


    <!--SPECIFICATIONS START-->
    <section class="specifications-table" style="background-color: #fff">
        <div class="container">
            <h5 class="text-uppercase text-success mb-3">description</h5>
            
            ${product.description}
            
        </div>
    </section>
    <!--SPECIFICATIONS ENDS-->



    <!--MOST POPULAR PRODUCTS START-->
    <section class="popular-products recently-viewed-products mb-2 mb-lg-4" style="background-color: #fff;">
        <div class="container text-center">
            <h3 class="text-uppercase mb-0">PRODUCTS FROM CATEGORY ${product.category.name}</h3>
            <ul class="list-unstyled owl-carousel popular-products-slider pb-3 pb-lg-4">
             
              <c:forEach var="product" items="${products}">
                 <li>
                
               
                    <article class="popular-products-item mb-2 mb-lg-0">
                        <figure class="mb-3 d-flex justify-content-center align-items-center">
                            <a href="shop-detail?id=${product.id}" class="d-block"><img src="${product.image}" alt="" /></a>
                          
                        </figure>
                        <div class="popular-products-details text-center text-lg-left">
                            <h5 class="mb-1"><a href="shop-detail?id=${product.id}" class="text-uppercase">${product.title}</a></h5>
                            <p class="text-uppercase mb-2">${product.category.name}</p>
                            <p class="text-uppercase">${product.price} din</p>
                        </div>
                    </article>
              
              
                </li>
                
                </c:forEach>
            </ul>
        </div>
    </section>
    <!--MOST POPULAR PRODUCTS ENDS-->

</main>


<!--FOOTER START-->
<footer style="background-color: #404040">
    <div class="container">
        <a href="#header" id="footerButton" class="d-inline-block text-uppercase btn btn-warning">back to top<span
                class="d-inline-block fa fa-angle-up"></span></a>
        <div class="row text-center d-flex align-items-center">
            <div class="col-12 col-md-6 col-xl-4 text-md-left mb-3 mb-md-0">
                <a class="footer-brand d-inline-block">
                    <img src="${pageContext.request.contextPath}/front/img/logo.png" alt="" />
                </a>
            </div>
            <div class="col-12 col-md-6 col-xl-4 text-md-right">
                <div class="footer-info-wrapper mb-1 mb-md-0">
                    <a class="d-inline-block mr-2 mr-lg-4 mr-xl-5" href="#"><img class="mobile"
                            src="img/icons/mobile.png" alt="" />(+01) 123 456 7896</a>
                    <a class="d-inline-block" href="mailto:gardenshop@gmail.com"><img class="mail"
                            src="${pageContext.request.contextPath}/front/img/icons/mail.png" alt="" />gardenshop@gmail.com</a>
                </div>
            </div>
            <div class="col-12 col-md-12 col-xl-4 text-md-right align-self-lg-center">
                <p><img class="clock" src="${pageContext.request.contextPath}/front/img/icons/clock.png" alt="" />Monday-Friday : 9:00 AM to 7:00 PM Sunday :
                    Closed</p>
            </div>
        </div>
    </div>
</footer>
<!--FOOTER ENDS-->









<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/front/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/popper.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/owl.carousel.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/jquery.zoom.min.js" type="text/javascript"></script>



<script src="${pageContext.request.contextPath}/front/js/main.js" type="text/javascript"></script>


</body>

</html>