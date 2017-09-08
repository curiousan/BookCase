function sendDeleteRequest(url1,url2) {
    $.ajax({
        url:url1,
        method:"DELETE",
        success: function () {
            window.location = url2;

        },
        error:function () {
            window.location.reload();

        }
    });

}
