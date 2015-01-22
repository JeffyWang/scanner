var scroll = true;

$(function() {
    loadData()
})

$('.system').on('click', function() {

})

$(window).scroll( function() {
    if(scroll)
        loadData()
})

var loadData = function() {
    for (var i = 0; i < 15; i ++)
        $('#systemList').append('<div class="system col-xs-6 col-md-3"><a href="#" class="thumbnail"><img src="img/demo.jpg"></a></div>')
}

