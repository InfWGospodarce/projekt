$get_lastID = function(){
    var $id = $('#documentTable tr:last-child td:first-child input').attr("id");
    $lastChar = parseInt($id);
    $lastChar = $lastChar + 1;
    $newRow = "<tr> \
                <td><input type='text' name='reg_no_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='text' name='subjects_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='number' name='max_marks_0"+$lastChar+"' maxlength='11' /></td> \
                <td><input type='number' name='max_obtained_0"+$lastChar+"' maxlength='11' /></td> \
                <td><input type='text' name='precentage_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='text' name='attempts_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='text' name='exam_year_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='button' value='Usuń' class='btn btn-primary' class='form-control' class='delRow' /></td> \
            </tr>";
    return $newRow;
};

$('#addRow').on("click", function(){
    if($('#documentTable tr').size() <= 100){
        $get_lastID();
        $('#documentTable tbody').append($newRow);
    } else {
        alert("Maksymalna liczba wierszy została osiągnięta!");
    };
});

$(".delRow").on("click", function(){
    $(this).closest('tr').remove();
    $lastChar = $lastChar-2;
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
        $('input[name=customerId]').val($option.data('value'));
        dataCustomerLoaded = false;
        selectedAddresLoaded = false;
        var id = $option.data('value');
		console.log("ID: " + id);
        
        $modal.modal('hide');
      }
    });

  };
}(jQuery));
