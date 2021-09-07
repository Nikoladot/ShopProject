$(document).ready(function () {

    function animation() {

        var windowHeight = $(window).height();
        var scrollDown = $(window).scrollTop();

        $('.animation').each(function () {
            var position = $(this).offset().top;

            if (position < scrollDown + windowHeight - 100) {
                var animacija = $(this).attr('data-animation');
                $(this).addClass(animacija);
            }
        });
    }

    animation();

    $(window).scroll(function () {
        animation();
    });


    //ANIMATE HAMBURGER BUTTON

    $('.navbar-toggler').click(function () {
        $(this).toggleClass('active');
    });



  


    //    SHOW/HIDE SEARCH

    $('.search-mobile .fa').click(function (e) {
        e.preventDefault();
        $('.search-toggle').slideToggle(function () {
        });
    });

    //SHOW/HIDE SUBMENU

    $('.nav-link .fa').click(function (e) {
        e.preventDefault();
        if (screen.width <= 992) {
            $(this).parent().next('.submenu').slideToggle();
            $(this).toggleClass('fa-chevron-down fa-chevron-up');
        }
    });
    $(window).resize(function () {
        if (screen.width >= 992) {
            $('.nav-link .fa').removeClass('fa fa-chevron-up').addClass('fa fa-chevron-down');
        }
    });

    //SHOW/HIDE  SHOP SIDEBAR SUBMENU

    $('.sidebar-list-link .sidebar-fa').click(function (e) {
        e.preventDefault();
        $(this).parent().next('.sidebar-submenu').slideToggle();
        $(this).toggleClass('fa-plus fa-minus');
    });


    //SHOW/HIDE  SHOP SIDEBAR ON CLICK
    $('.side-nav-button .fa').click(function (e) {
        e.preventDefault();
        $('.sidebar').addClass('sidebar-clicked');
        $('.sidebar-list-link').addClass('text-blur-out');
    });
    $('.close-sidebar-icon').click(function (e) {
        e.preventDefault();
        $('.sidebar').removeClass('sidebar-clicked');
        $('.sidebar-list-link').removeClass('text-blur-out');
    });
    $(window).resize(function () {
        if (screen.width >= 992) {
            $('.sidebar').removeClass('sidebar-clicked');
            $('.sidebar-list-link').removeClass('text-blur-out');
        }
    });



    //EASE SCROLL

    $(document).on('click', 'a[href^="#"]', function (event) {
        event.preventDefault();

        $('html, body').animate({
            scrollTop: $($.attr(this, 'href')).offset().top
        }, 1000);
    });



    //SLIDER

    if ($('.owl-carousel').length > 0) {

        $('.lead-slider-1').owlCarousel({
            loop: true,
            margin: 0,
            responsiveClass: true,
            dots: false,
            autoplay: true,
            nav: true,
            items: 1
        });


        $('.popular-products-slider').owlCarousel({
            loop: true,
            margin: 30,
            responsiveClass: true,
            dots: false,
            nav: true,
            autoplay: true,

            responsive: {
                0: {
                    items: 1
                },
                520: {
                    items: 2
                },
                992: {
                    items: 3
                },
                1200: {
                    items: 4
                }
            }
        });

        $('.lead-slider-3').owlCarousel({
            loop: true,
            margin: 0,
            responsiveClass: true,
            dots: true,
            autoplay: true,
            nav: false,
            items: 1
        });
    }

    // SETTING POSITION OF BUTTON ON FOOTER

    var footer = $('footer').outerHeight() + 'px';
    $('#footerButton').css("bottom", footer);

    $(window).resize(function () {
        var footer = $('footer').outerHeight() + 'px';
        $('#footerButton').css("bottom", footer);
    });


    // ZOOM IMG


    $('.product-img').zoom({
        url: 'img/product/product-img.png',
        magnify: 1.3,
        on: 'click'
    });
    $('.location-main .location-zoom-img').zoom({
        url: 'img/services/service-3-img.png',
        magnify: 1.3,
        on: 'click'
    });
    $('.services-3--bottom-article .services-img').zoom({
        url: 'img/services/service-3-img.png',
        magnify: 1.3,
        on: 'click'
    });


    //GALLERY NAV SHOW/HIDE

    $('.gallery-toggle').click(function () {

        if (screen.width <= 768) {
            $('.gallery-list').slideToggle();
            $('.gallery-toggle').toggleClass('fa-plus fa-minus');
        }
    });

    //GALLERY NAV ADD CLASS

    $('.gallery-list li').click(function (e) {
        e.preventDefault();
        $('.gallery-list a').removeClass('active');
        $(this).children('a').addClass('active');
    });


    //GALLERY FILTER

    var filterizd = $('.filtr-container').filterizr({

    });
    //fltr.filterizr('setOptions', {layout: 'packed'});
    // Default options
    var options = {
        animationDuration: 0.5, // in seconds
        filter: 'all', // Initial filter
        callbacks: {
            onFilteringStart: function () { },
            onFilteringEnd: function () { },
            onShufflingStart: function () { },
            onShufflingEnd: function () { },
            onSortingStart: function () { },
            onSortingEnd: function () { }
        },
        controlsSelector: '', // Selector for custom controls
        delay: 0, // Transition delay in ms
        delayMode: 'progressive', // 'progressive' or 'alternate'
        easing: 'ease-out',
        filterOutCss: {// Filtering out animation
            opacity: 0,
            transform: 'scale(0.5)'
        },
        filterInCss: {// Filtering in animation
            opacity: 0,
            transform: 'scale(1)'
        },
        layout: 'packed', // See layouts
        multifilterLogicalOperator: 'or',
        selector: '.filtr-container',
        setupControls: true // Should be false if controlsSelector is set 
    };
    // You can override any of these options and then call...
    var filterizd = $('.filtr-container').filterizr(options);
    // If you have already instantiated your Filterizr then call...
    filterizd.filterizr('setOptions', options);



    //GALLERY IMG LOOP ON CLICK HIDE


    $('.overlay').click(function () {
        $(this).hide();
        setTimeout(function () {
            $('.overlay').show();
        }, 1000);
    });









});


