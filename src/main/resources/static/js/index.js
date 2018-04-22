$(function() {
    var table = $('#example').DataTable( {
        "ajax": {
            "url": "/mock/range.json",
            "dataSrc": ""
        },
        "columns": [
            { "data": "id" },
            { "data": "name" },
            { "data": "position" },
            { "data": "office" },
            { "data": "extn" },
            { "data": "start_date" },
            { "data": "salary" }
        ],
        "pagingType": "full"
    } );
    $('#example').on( 'click', 'tbody td', function () {
        var idx = table.cell(this).index().column;
        alert( 'Data source: '+table.column( idx ).dataSrc() );
    } );
});