var rowCounter=0;

$('#addRow').on("click", function(){
	rowCounter++;
    if($('#documentTable tr').size() <= 100){
        $('#documentTable tr:last').clone(true).insertAfter("#documentTable tr:last");
        $('#documentTable tr:last input').val("");
        $('.delRow').val("Usuń");
    } else {
        alert("Maksymalna liczba wierszy została osiągnięta!");
    };
});

function removeRow(){
	console.log("Rows: " + $('#documentTable tr').length);
	if($('#documentTable tr').length > 1){
		$(this).parent().parent().remove();
		event.preventDefault();
		return false;
	} else {
		alert("Dokument musi posiadać przynajmniej jeden wiersz");
	}
};

$(document.body).on('click', 'button.delRow', function(){
	console.log("Rows: " + $('#documentTable tr').length);
	if($('#documentTable tr').length > 1){
    	$(this).closest('tr').remove();
    	return false;
	} else {
		alert("Dokument musi posiadać przynajmniej jeden wiersz");
	}
});
/////////////////////////////////////////////////////////////////////////////////////////////////

(function ($) {
  'use strict';

  $.fn.select = function () {
    var $modal = $('#selectArticle');

    $modal.on('hide.bs.modal', function () {
      $('.modal-body', $modal).off('.modal');
    });

    return this.each(function () {
    	console.log("OOO");
      var $el = $(this);

      $el.on('click', '.js_triggerART', handleClick);

      function handleClick() {
    	  console.log("CLICK");
        $modal.modal('show');

        $('.modal-body', $modal).load($el.data('target'), bindEvents);
      }

      function bindEvents() {
          $(this).on('click.modal', '.js_option', handleSelect);
        }
      

      function handleSelect() {
        var $option = $(this);
        console.log($el.attr('id'));
        $('input[name=wareId]').val($option.data('value'));
        dataCustomerLoaded = false;
        selectedAddresLoaded = false;
        var id = $option.data('value');
		console.log("ID: " + id);
        
        $modal.modal('hide');
      }
    });

  };
}(jQuery));
