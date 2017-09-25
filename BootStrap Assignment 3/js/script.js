$(document).ready(function () {
	$('#menu-item-dashboard').css('background-color','#ba5e5e').siblings().css('background-color', '#222');
	
	$('#navbar-menuitems .nav li').click(function () {
		$(this).css('background-color','#ba5e5e').siblings().css('background-color', '#222');
	});
	
	$('#notification').click(function () {
		$('#navModal').modal();
	});
	
	$(function () {
		$('a').tooltip();
	});
	
	$('.collapse').on('shown.bs.collapse', function () {	
		$(this).parent().find(".glyphicon-plus").removeClass("glyphicon-plus").addClass("glyphicon-minus");
		$(this).parent().find(".bottom-radius").removeClass("bottom-radius").addClass("bottom-radius-zero");
	}).on('hidden.bs.collapse', function () {
			$(this).parent().find(".glyphicon-minus").removeClass("glyphicon-minus").addClass("glyphicon-plus");
			$(this).parent().find(".bottom-radius-zero").removeClass("bottom-radius-zero").addClass("bottom-radius");
		});		
});

