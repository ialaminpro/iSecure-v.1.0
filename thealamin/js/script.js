/*jshint jquery:true */
/*global $:true */

var $ = jQuery.noConflict();

$(document).ready(function($) {
	"use strict";
	/* global google: false */

	// Section - Home

	var windowHeight = $(window).height(),
		topSection = $('#section-home');
	topSection.css('height', windowHeight);

	$(window).resize(function(){
		var windowHeight = $(window).height();
		topSection.css('height', windowHeight);
	});

	// Flexslider
	try {

		var SliderPost = $('.flexslider');

		SliderPost.flexslider({
			animation: "fade"
		});
	} catch(err) {

	}

	// Works

	var winDow = $(window);
		// Needed variables
		var $container=$('.works-container');
		var $filter=$('.filter');

		try{
			$container.imagesLoaded( function(){
				$container.show();
				$container.isotope({
					filter:'*',
					layoutMode:'masonry',
					animationOptions:{
						duration:750,
						easing:'linear'
					}
				});


				$('.triggerAnimation').waypoint(function() {
					var animation = $(this).attr('data-animate');
					$(this).css('opacity', '');
					$(this).addClass("animated " + animation);

				},
					{
						offset: '80%',
						triggerOnce: true
					}
				);

			});
		} catch(err) {
		}

		winDow.bind('resize', function(){
			var selector = $filter.find('a.active').attr('data-filter');

			try {
				$container.isotope({ 
					filter	: selector,
					animationOptions: {
						duration: 750,
						easing	: 'linear',
						queue	: false,
					}
				});
			} catch(err) {
			}
			return false;
		});
		
		// Isotope Filter 
		$filter.find('a').click(function(){
			var selector = $(this).attr('data-filter');

			try {
				$container.isotope({ 
					filter	: selector,
					animationOptions: {
						duration: 750,
						easing	: 'linear',
						queue	: false,
					}
				});
			} catch(err) {

			}
			return false;
		});


	var filterItemA	= $('.filter li a');

		filterItemA.on('click', function(){
			var $this = $(this);
			if ( !$this.hasClass('active')) {
				filterItemA.removeClass('active');
				$this.addClass('active');
			}
		});

		try {

			$('.blog-box').imagesLoaded( function(){
				$('.blog-box').isotope({
					masonry: {
						columnWidth: 1,
						isAnimated: true,
						itemSelector: '.blog-post'
					}
				});
			});

			winDow.bind('resize', function(){
			var selector = $filter.find('a.active').attr('data-filter');

				$('.blog-box').imagesLoaded( function(){
					$('.blog-box').isotope({
						masonry: {
							columnWidth: 1,
							isAnimated: true,
							itemSelector: '.blog-post'
						}
					});
				});
			});
		} catch(err) {

		}
	// Loader
	winDow.load( function(){
		var mainDiv = $('#container'),
			preloader = $('.preloader');

			preloader.fadeOut(400, function(){
				mainDiv.delay(400).addClass('active');
			});
	});

	// Smooth Scroll
	try {
		$.browserSelector();
		// Adds window smooth scroll on chrome.
		if($("html").hasClass("chrome")) {
			$.smoothScroll();
		}
	} catch(err) {

	}

	// Parallax
	
	try{
		$('#section-testimonials, #section-twitter').appear(function() {	
			$.stellar({
				horizontalScrolling: false,
				verticalOffset: 0
			});
		});
	} catch(err) {
	}

	// Testimonials
	try{
		var testimUl = $('.testimonial > ul');

		testimUl.quovolver({
			transitionSpeed:300,
			autoPlay:true
		});
	}catch(err){
	}

	// Stats
	try {
		$('.statistic-post').appear(function() {
			$('.timer').countTo({
				speed: 4000,
				refreshInterval: 60
			});
		});
	} catch(err) {

	}

	// Navbar Collapse
	try {
		$(".navbar-nav li a").click(function(event) {
			$(".navbar-collapse").collapse('hide');
		});
	} catch(err) {

	}
	
	// Animated Content 

	try {
		// Animated Content
		if ($(".animated")[0]) {
			$('.animated').css('opacity', '0');
		}

		$('.triggerAnimation').waypoint(function() {
			var animation = $(this).attr('data-animate');
			$(this).css('opacity', '');
			$(this).addClass("animated " + animation);

		},
			{
				offset: '80%',
				triggerOnce: true
			}
		);
	} catch(err) {

	}

	// Magnific Popup

	try {
		// Example with multiple objects
		$('.zoom').magnificPopup({
			type: 'image'
		});
	} catch(err) {

	}

	try {
		var magnLink = $('.page');
		magnLink.magnificPopup({
			closeBtnInside:true
		});
	} catch(err) {

	}

	// Testimonials

	var slidertestimonial = $('.bxslider');
	try{		
		slidertestimonial.bxSlider({
			mode: 'horizontal'
		});
	} catch(err) {
	}

	// Video Background

	try{
		jQuery(".player").mb_YTPlayer();
	} catch(err) {
	}

	// Carousels
	try {
		$('.carousel').carousel({
			interval: false
		});
	} catch(err) {

	}

	// Contact Form

	var submitContact = $('#submit_contact'),
		message = $('#msg');

	submitContact.on('click', function(e){
		e.preventDefault();

		var $this = $(this);
		
		$.ajax({
			type: "POST",
			url: 'contact.php',
			dataType: 'json',
			cache: false,
			data: $('#contact-form').serialize(),
			success: function(data) {

				if(data.info !== 'error'){
					$this.parents('form').find('input[type=text],textarea,select').filter(':visible').val('');
					message.hide().removeClass('success').removeClass('error').addClass('success').html(data.msg).fadeIn('slow').delay(5000).fadeOut('slow');
				} else {
					message.hide().removeClass('success').removeClass('error').addClass('error').html(data.msg).fadeIn('slow').delay(5000).fadeOut('slow');
				}
			}
		});
	});

});