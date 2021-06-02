$(function(){
    $('.btn-delete').on('click', function (e) {
        e.preventDefault();
        const href = $(this).attr('href');
        $('#archivePopup #btnDeleteYes').attr('href',href);
        $('#archivePopup').modal();
    });
});
