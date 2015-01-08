(function ($) {
  'use strict';

  $.fn.select = function () {
    var $modal = $('#selectCustomer');

    $modal.on('hide.bs.modal', function () {
      $('.modal-body', $modal).off('.modal');
    });

    return this.each(function () {
      var $el = $(this);

      $el.on('click', '.js_trigger', handleClick);

      function handleClick() {
        $modal.modal('show');

        $('.modal-body', $modal).load($el.data('target'), bindEvents);
      }

      function bindEvents() {
        $(this).on('click.modal', '.js_option', handleSelect);
      }

      function handleSelect() {
        var $option = $(this);
        $('#customerId', $el).data($option.val('value'));
        $('input[name=customerId]').val($option.data('value'));
        $modal.modal('hide');
      }
    });

  };
}(jQuery));
