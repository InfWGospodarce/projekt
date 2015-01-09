	$( document ).ready(function() {
		$( ".addresLine" ).hide();
	});

	function showAddres(id){
		var element = $(document.getElementById(id));
		if($(element).is(":visible")){
			$(element).hide();
		} else {
			$(element).show();
		};
	};
