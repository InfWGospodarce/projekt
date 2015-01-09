$get_lastID = function(){
    var $id = $('#documentTable tr:last-child td:first-child input').attr("name");
    $lastChar = parseInt($id.substr($id.length - 2), 10);
    $lastChar = $lastChar + 1;
    $newRow = "<tr> \
                <td><input type='text' name='reg_no_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='text' name='subjects_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='number' name='max_marks_0"+$lastChar+"' maxlength='11' /></td> \
                <td><input type='number' name='max_obtained_0"+$lastChar+"' maxlength='11' /></td> \
                <td><input type='text' name='precentage_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='text' name='attempts_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='text' name='exam_year_0"+$lastChar+"' maxlength='255' /></td> \
                <td><input type='button' value='Delete' class='btn btn-primary' class='form-control' class='delRow' /></td> \
            </tr>"
    return $newRow;
}
$('#addRow').live("click", function(){
    if($('#documentTable tr').size() <= 100){
        $get_lastID();
        $('#documentTable tbody').append($newRow);
    } else {
        alert("Maksymalna liczba wierszy została osiągnięta!");
    };
});

$(".delRow").live("click", function(){
    $(this).closest('tr').remove();
    $lastChar = $lastChar-2;
});

