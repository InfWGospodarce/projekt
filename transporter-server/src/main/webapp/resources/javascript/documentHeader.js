var dataCustomerLoaded = false;
var selectedAddresLoaded = false;

$( document ).ready(function() {
	$( "#clientData" ).hide();
	$( "#customerSelectedAddress").hide();
	loadClientDetails($("#customerId").val());
});

function showClient(){
	var element = $("#clientData");
	if($(element).is(":visible")){
		console.log("hide");
		$(element).hide();
	} else {
		if(!dataCustomerLoaded)loadClientDetails($("#customerId").val());
		$(element).show();
		console.log("show");
	};
};

function showClientSelectedAddress(){
	var element = $("#customerSelectedAddress");
	if($(element).is(":visible")){
		console.log("hide");
		$(element).hide();
	} else {
		if(!selectedAddresLoaded)loadClientSelectedAddress();
		$(element).show();
		console.log("show");
	};
};

(function ($) {
  'use strict';

  $.fn.select = function () {
    var $modal = $('#selectCustomer');

    $modal.on('hide.bs.modal', function () {
      $('.modal-body', $modal).off('.modal');
    });

    return this.each(function () {
      var $el = $(this);

      $el.on('click', '.js_triggerDOC', handleClick);

      function handleClick() {
        $modal.modal('show');

        $('.modal-body', $modal).load($el.data('target'), bindEvents);
      }

      function bindEvents() {
        $(this).on('click.modal', '.js_optionDOC', handleSelect);
      }

      function handleSelect() {
        var $option = $(this);
        $('input[name=customerId]').val($option.data('value'));
        dataCustomerLoaded = false;
        selectedAddresLoaded = false;
        var id = $option.data('value');
		console.log("ID: " + id);
		loadClientDetails(id);
        
        $modal.modal('hide');
      }
    });

  };
}(jQuery));

function loadClientDetails(id){
	if(id == '') return;
	$("#clientData").html("");
	$("#devAddress").html("");
	console.log("cd load: ");
	if(!dataCustomerLoaded){
		$("#clientData").load("/transporter-server/seller/customerSimple?id="+id);
		$("#devAddress").load("/transporter-server/seller/customerSelectAddress?id="+id);
	}
	dataCustomerLoaded = true;
}

function loadClientSelectedAddress(){
	id = $("#deliveryAddressSelector").val();
	if(id == '') return;
	$('input[name=deliveryAddressId]').val(id);
	$("#customerSelectedAddress").html("");
	console.log("cd load: ");
	if(!selectedAddresLoaded){
		$("#customerSelectedAddress").load("/transporter-server/seller/customerSelectedAddress?id="+id);
	}
	selectedAddresLoaded = true;
}

function selectedDevAdrChanged(){
	selectedAddresLoaded = false;
	loadClientSelectedAddress();
}