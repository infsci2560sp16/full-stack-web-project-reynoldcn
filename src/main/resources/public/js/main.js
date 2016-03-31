/*author: Zhuoqun*/
/*for search*/

$(document).ready(function(){




	/*  Search Menu & Icon  */
	$('.hamburger').on('click', function(e){
		
		e.preventDefault();
		$(this).toggleClass('opned');
		$('header nav').toggleClass('active');
		
	});




	/*  Advanced search form & Icon  */
	$('#advanced_search_btn').on("click", function(e){
		e.preventDefault();

		var ads_box =$('.advanced_search');
		
		if(!ads_box.hasClass('advanced_displayed')){

			$(this).addClass('active');
			ads_box.stop().fadeIn(200).addClass('advanced_displayed');

		}else{

			$(this).removeClass('active');
			ads_box.stop().fadeOut(200).removeClass('advanced_displayed');

		}

	});




});

function browseByMake () {
    var obj = JSON.stringify({"make" : $( "#make" ).val()});
    $.ajax({
           contentType:'application/json',
           url : "/upload/recipe",
           type : "post",
           dataType: "json",
           data : obj,
           success : function(recipe) {
           console.log(recipe);
           $("#inv").html("");
           for ( var i = 0; i < cars.length; i++) {
           $("#inv").prepend(
                             '<div class="row" id="' + cars[i].id + '">' +
                             '<div class="col-md-7">' +
                             '<a href="/item">' +
                             '<img class="img-responsive img-hover" src="/img/inventory/' + cars[i].path + '" alt="car picture"> </a>' +
                             '</div>' +
                             '<div class="col-md-5">' +
                             '<h3>' + cars[i].make + ' ' + cars[i].model + ' ' + cars[i].year + '</h3>' +
                             '<h4>$' + cars[i].price + '</h4>' +
                             '<h4>' + cars[i].bodytype + '</h4>' +
                             '<a class="btn btn-primary" href="/item">View Details</a>' +
                             '</div>' +
                             '</div>' +
                             '<hr>'
                             );
           }
           }
           });
}