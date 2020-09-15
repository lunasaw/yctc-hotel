/*
 * Copyright (c) 2019 Marketify
 * Author: Marketify
 * This file is made for CURRENT TEMPLATE
*/


jQuery(document).ready(function(){

	"use strict";
	
	// here all ready functions
	
	wantam_tm_waypoints();
	wantam_tm_function();
	ajaxCustom();
	wantam_tm_menu();
	wantam_tm_down();
	wantam_tm_popup();
	wantam_tm_about_hero();
	wantam_tm_imgtosvg();
	wantam_tm_partners();
	wantam_tm_portfolio();
	wantam_tm_hero_overlay();
	wantam_tm_jarallax();
	wantam_tm_data_images();
	wantam_tm_isotope();
	wantam_tm_contact_form();
	wantam_tm_kenburn_slider();
	wantam_tm_ripple();
	wantam_tm_animate_text();
	wantam_tm_scrollable();
	
	jQuery(window).on('resize',function(){
		wantam_tm_waypoints();
		wantam_tm_about_hero();
		wantam_tm_isotope();
		wantam_tm_scrollable();		
	});
	
	jQuery(window).load('body', function(){
		
		setTimeout(function(){wantam_tm_preloader();},1000);
		
	});
	
});

// -----------------------------------------------------
// ---------------   WAYPOINTS    ----------------------
// -----------------------------------------------------

function wantam_tm_waypoints(){
	
	"use strict";
	
	var div		= jQuery('.wantam_tm_waypoint_effect');
	
	div.each(function(){
		
		var element	= jQuery(this);
		
		element.waypoint({
			handler:function(){
				element.addClass('load');
			},
			offset:"75%"
		});
		
	});
	
}

// -----------------------------------------------------
// ----------    RIGHTPART PADDING    ------------------
// -----------------------------------------------------

function wantam_tm_function(){
	
	"use strict";
	
	var button			= jQuery('.wantam_tm_sidebar_wrap .info_wrap .inner_wrap .link');
	var rightpart		= jQuery('.wantam_tm_mainpart_wrap .mainpart_inner');
	button.on('click',function(){
		var element = jQuery(this);
		if(element.hasClass('opened')){
			setTimeout(function(){
				element.removeClass('opened');
			rightpart.removeClass('opened');
			},1000);
			
		}else{
			element.addClass('opened');
			rightpart.addClass('opened');
		}
	});
	
}
	
// -----------------------------------------------------
// --------------    AJAX CUSTOM    --------------------
// -----------------------------------------------------

function ajaxCustom(){
	
	"use strict";
	
	jQuery('.wantam_tm_load_more a').on('click', function(){
		
		var element 	= jQuery(this);
		var shape		= jQuery('.wantam_tm_load_more .svg');
		var span		= element.find('span');
		
		if(!element.hasClass('opened')){
			element.addClass('opened');
			shape.addClass('animate');
			span.addClass('change');
			jQuery.ajax({
				type: 'POST',
				url: 'js/portfolio.json',
				dataType: 'json',
				success: function(data) {
										
					setTimeout(function(){
						
						for(var i = 0; i<data.portfolio.length; i++){
					
						var list = '<li><div class="list_inner"><div class="image_wrap"><img src="img/portfolio/600x600.jpg" alt="" /><div class="main_image" style="background-image: url('+data.portfolio[i].imgUrl+')"></div></div><div class="overlay"></div><div class="overlay_text"><h3>'+data.portfolio[i].title+'</h3><span>'+data.portfolio[i].subTitle+'</span></div><a class="full_link" href="'+data.portfolio[i].pageURL+'"></a></div></li>';
													
						jQuery('.wantam_tm_portfolio_list').append(list);
						shape.removeClass('animate');
					    span.removeClass('change');
					}
					
					},1500);

				},
				error: function(a,b,c){
					
				}

			});
		}
		else{
			alert('No more images !!!');
		}
		
		return false;
	});
}
	
// -----------------------------------------------------
// -----------------    NENU    ------------------------
// -----------------------------------------------------	
	
function wantam_tm_menu(){
	
	"use strict";
	
	var t1			= new TimelineMax({paused:true});
	
	t1.to(".wantam_tm_sidebar_wrap .trigger_wrap .trigger .one", 0.2,{
		y:6,
		rotation:45,
		ease:Expo.easeinOut
	});
	t1.to(".wantam_tm_sidebar_wrap .trigger_wrap .trigger .two", 0.2,{
		y:- 6,
		rotation:-45,
		ease:Expo.easeinOut,
		delay:-0.2
	});	
	t1.to(".wantam_tm_sidebar_wrap .menu_wrap",0.2,{
		left:"90px",
		ease:Expo.easeinOut,
		delay:-0.2
	});
	t1.staggerFrom(".wantam_tm_sidebar_wrap .menu_wrap .menu_inner .nav_list > ul > li", 0.1, {y:25, opacity:0, ease:Expo.easeinOut},0.1);
	t1.reverse();
	
	jQuery('.wantam_tm_sidebar_wrap .trigger_wrap .link').on('click',function(){
		t1.reversed(!t1.reversed());
		return false;
	});
	
	
	var aaaa = jQuery('.wantam_tm_sidebar_wrap .menu_wrap .menu_inner .nav_list > ul > li > a');
	aaaa.off().on('click',function(e){
		e.stopPropagation();
		var element = jQuery(this);
		var url			= element.attr('href');
		if(url !== '#' && url.charAt(0) === '#'){
			aaaa.parent().removeClass('active');
			element.parent().addClass('active');
			$('html, body').animate({
				scrollTop: $(url).offset().top-115
			}, 1000);
		}
		return false;
	});	
}

$(".glitch").mgGlitch({
		destroy: false,
		glitch: true,
		scale: true,
		blend: true,
		blendModeType: "hue",
		glitch1TimeMin: 200,
		glitch1TimeMax: 400,
		glitch2TimeMin: 10,
		glitch2TimeMax: 100
	});

// -----------------------------------------------------
// -----------------    POPUP    ------------------------
// -----------------------------------------------------

function wantam_tm_popup(){
	
		jQuery('.gallery_zoom').each(function() { // the containers for all your galleries
			jQuery(this).magnificPopup({
				delegate: 'a.zoom', // the selector for gallery item
				type: 'image',
				gallery: {
				  enabled:true
				},
				removalDelay: 300,
				mainClass: 'mfp-fade'
			});

		});
	}

// -----------------------------------------------------
// -----------------    DOWN    ------------------------
// -----------------------------------------------------

function wantam_tm_down(){
	
	"use strict";
	
	jQuery('.wantam_tm_button.explore a').on('click',function(){
		if($.attr(this, 'href') !== '#'){
			$('html, body').animate({
				scrollTop: $($.attr(this, 'href')).offset().top-140
			}, 1000);
		}
		return false;
	});
}

// -----------------------------------------------------
// -----------------    ABOUT HERO    ------------------
// -----------------------------------------------------

function wantam_tm_about_hero(){
	
	"use strict";
	
	var wh		= jQuery(window).height();
	var box		= jQuery('.wantam_tm_samebox_wrap .leftbox');
	
	box.css({height:wh-90});
}

// -----------------------------------------------------
// ---------------    HERO OVERLAY    ------------------
// -----------------------------------------------------

function wantam_tm_hero_overlay(){
	
	"use strict";
	
	jQuery(window).on('scroll',function(){
		var currentScroll		= window.pageYOffset;
		var scrollOpacity       = 1 - (currentScroll / 550);
		jQuery(".wantam_tm_home_hero").css({opacity: scrollOpacity });
	});
	
}
	
// -----------------------------------------------------
// ---------------    IMAGE TO SVG    ------------------
// -----------------------------------------------------

function wantam_tm_imgtosvg(){
	
	"use strict";
	
	jQuery('img.svg').each(function(){
		
		var jQueryimg 		= jQuery(this);
		var imgClass		= jQueryimg.attr('class');
		var imgURL			= jQueryimg.attr('src');

		jQuery.get(imgURL, function(data) {
			// Get the SVG tag, ignore the rest
			var jQuerysvg = jQuery(data).find('svg');

			// Add replaced image's classes to the new SVG
			if(typeof imgClass !== 'undefined') {
				jQuerysvg = jQuerysvg.attr('class', imgClass+' replaced-svg');
			}

			// Remove any invalid XML tags as per http://validator.w3.org
			jQuerysvg = jQuerysvg.removeAttr('xmlns:a');

			// Replace image with new SVG
			jQueryimg.replaceWith(jQuerysvg);

		}, 'xml');

	});
}	

// -----------------------------------------------------
// --------------------    JARALLAX    -----------------
// -----------------------------------------------------

function wantam_tm_jarallax(){
	
	"use strict";
	
	jQuery('.jarallax').each(function(){
		var element			= jQuery(this);
		var	customSpeed		= element.data('speed');
		
		if(customSpeed !== "undefined" && customSpeed !== ""){
			customSpeed = customSpeed;
		}else{
			customSpeed 	= 0.5;
		}
		
		element.jarallax({
			speed: customSpeed,
			automaticResize: true
		});
	});
}

// -----------------------------------------------------
// ---------------   DATA IMAGES    --------------------
// -----------------------------------------------------

function wantam_tm_data_images(){
	
	"use strict";
	
	var data			= jQuery('*[data-img-url]');
	
	data.each(function(){
		var element		= jQuery(this);
		var url			= element.data('img-url');
		element.css({backgroundImage: 'url('+url+')'});
	});
}

// -----------------------------------------------------
// --------------------   SKILLS    --------------------
// -----------------------------------------------------

function tdProgress(container){
	
	"use strict";
		
	container.find('.progress_inner').each(function(i) {
		var progress 		= jQuery(this);
		var pValue 			= parseInt(progress.data('value'), 10);
		var pColor			= progress.data('color');
		var pBarWrap 		= progress.find('.bar');
		var pBar 			= progress.find('.bar_in');
		pBar.css({width:pValue+'%', backgroundColor:pColor});
		setTimeout(function(){pBarWrap.addClass('open');},(i*300));
	});
}

	jQuery('.wantam_progress').each(function() {

		"use strict";

		var pWrap 			= jQuery(this);
		pWrap.waypoint({handler: function(){tdProgress(pWrap);},offset:'90%'});	
	});

// -----------------------------------------------------
// --------------    ISOTOPE MASONRY    ----------------
// -----------------------------------------------------

function wantam_tm_isotope(){
	
	"use strict";
	
	jQuery('.masonry').isotope({
		itemSelector: '.masonry_item',
		masonry: {
			
		}
	});
}

// -----------------------------------------------------
// ----------------    OWL CAROUSEL    -----------------
// -----------------------------------------------------

function wantam_tm_partners(){
	
	"use strict";
	
		var carousel4			= jQuery('.wantam_tm_partners .owl-carousel');
		carousel4.owlCarousel({
				loop: true,
				items: 4,
				lazyLoad: true,
				margin: 40,
				autoplay: true,
				autoplayTimeout: 4000,
				smartSpeed: 2000,
				dots: true,
				nav: false,
				navSpeed: true,
				responsive:{
					0:{items:1},
					480:{items:2},
					768:{items:3},
					1040:{items:3},
					1200:{items:4},
					1600:{items:4},
					1920:{items:4}
				}
		});
		
	}


// -----------------------------------------------------
// ------------    PORTFOLIO FILTER    -----------------
// -----------------------------------------------------

function wantam_tm_portfolio(){

	"use strict";

	if(jQuery().isotope) {

		// Needed variables
		var list 		 = jQuery('.wantam_tm_portfolio_list');
		var filter		 = jQuery('.wantam_tm_portfolio_filter');

		if(filter.length){
			// Isotope Filter 
			filter.find('a').on('click', function(){
				var selector = jQuery(this).attr('data-filter');
				list.isotope({ 
					filter				: selector,
					animationOptions	: {
						duration			: 750,
						easing				: 'linear',
						queue				: false
					}
				});
				return false;
			});	

			// Change active element class
			filter.find('a').on('click', function() {
				filter.find('a').removeClass('current');
				jQuery(this).addClass('current');
				return false;
			});	
		}
	}
}

// -----------------------------------------------------
// ----------------    CONTACT FORM    -----------------
// -----------------------------------------------------

function wantam_tm_contact_form(){
	
	"use strict";
	
	jQuery(".contact_form #send_message").on('click', function(){
		
		var name 		= jQuery(".contact_form #name").val();
		var email 		= jQuery(".contact_form #email").val();
		var message 	= jQuery(".contact_form #message").val();
		var subject 	= jQuery(".contact_form #subject").val();
		var success     = jQuery(".contact_form .returnmessage").data('success');
	
		jQuery(".contact_form .returnmessage").empty(); //To empty previous error/success message.
		//checking for blank fields	
		if(name===''||email===''||message===''){
			
			jQuery('div.empty_notice').slideDown(500).delay(2000).slideUp(500);
		}
		else{
			// Returns successful data submission message when the entered information is stored in database.
			jQuery.post("modal/contact.php",{ ajax_name: name, ajax_email: email, ajax_message:message, ajax_subject: subject}, function(data) {
				
				jQuery(".contact_form .returnmessage").append(data);//Append returned message to message paragraph
				
				
				if(jQuery(".contact_form .returnmessage span.contact_error").length){
					jQuery(".contact_form .returnmessage").slideDown(500).delay(2000).slideUp(500);		
				}else{
					jQuery(".contact_form .returnmessage").append("<span class='contact_success'>"+ success +"</span>");
					jQuery(".contact_form .returnmessage").slideDown(500).delay(4000).slideUp(500);
				}
				
				if(data===""){
					jQuery("#contact_form")[0].reset();//To reset form fields on success
				}
				
			});
		}
		return false; 
	});
}


function wantam_tm_preloader(){
	
	"use strict";
	
	var mainPreloader	 = $(".wantam_tm_loader-wrapper .loader");
	var WinWidth 		 = $(window).width();
    var WinHeight		 = $(window).height();
    var zero = 0;

    mainPreloader.css({
        top: WinHeight / 2 - 2.5,
        left: WinWidth / 2 - 200
    });

    do {
        mainPreloader.animate({
            width: zero
        }, 10);
        zero += 3;
    } while (zero <= 400);
    if (zero === 402) {
        mainPreloader.animate({
            left: 0,
            width: '100%'
        });
        mainPreloader.animate({
            top: '0',
            height: '100vh'
        });
    }

    setTimeout(function() {
        $(".wantam_tm_loader-wrapper").fadeOut('fast');
        (mainPreloader).fadeOut('fast');
    }, 4500);
}

// -------------------------------------------------
// -------------  SLIDER KENBURN  ------------------
// -------------------------------------------------

function wantam_tm_kenburn_slider(){
	
	"use strict";
	
		jQuery(function() {
			jQuery('.wantam_hero_wrap_kenburn .overlay_slider').vegas({
			timer:false,	
			animation: [ 'kenburnsUp',  'kenburnsLeft', 'kenburnsRight'],
			delay:7000,

			slides: [
				{ src: 'img/slider/1.jpg' },
				{ src: 'img/slider/2.jpeg' },
				{ src: 'img/slider/4.jpeg' },
			]

		});
	});
}

// -------------------------------------------------
// -------------  RIPPLE  --------------------------
// -------------------------------------------------

function wantam_tm_ripple(){
	
	"use strict";
	
	jQuery('#ripple').ripples({
			resolution: 500,
			dropRadius: 20,
			perturbance: 0.04
		});
}

$(".youtube-bg").mb_YTPlayer();

// -------------------------------------------------
// -------------   ANIMATE TEXT  -------------------
// -------------------------------------------------

function wantam_tm_animate_text(){
	
	"use strict";
	
	var animateSpan			= jQuery('.wantam_tm_animation_text_word');
	var animateSpan2		= jQuery('.wantam_tm_animation_text_word_2');
	
		animateSpan.typed({
			strings: ["Wantam", "Creative", "Effective"],
			loop: true,
			startDelay: 1e3,
			backDelay: 2e3
		});
	
		animateSpan2.typed({
			strings: ["Alexander", "Developer", "Designer"],
			loop: true,
			startDelay: 1e3,
			backDelay: 2e3
		});
}

// -------------------------------------------------
// --------------   MENU SCROLL  -------------------
// -------------------------------------------------

function wantam_tm_scrollable(){
	
	"use strict";
	
	var H				= jQuery(window).height();
	var scrollable		= jQuery('.scrollable');
	
	
	var verMenu			= jQuery('.wantam_tm_menu .nav_list');
	verMenu.css({height:H-200});
	
	scrollable.each(function(){
		var element		= jQuery(this);
		
		element.css({height: H-200});
		
		element.niceScroll({
			touchbehavior:false,
			cursorwidth:0,
			autohidemode:true,
			cursorborder:"0px solid #eee"
		});
	});
}


