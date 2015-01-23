define(['jquery'], function ($) {
    $(function() {
        loadData()
    })

    $(window).scroll(function () {
        loadData()
    })

    var loadData = function () {
        var totalHeight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());     //浏览器的高度加上滚动条的高度
        if ($(document).height() <= totalHeight) { //当文档的高度小于或者等于总的高度的时候，开始动态加载数据
            for (var i = 0; i < 15; i++)
                $('#systemList').append('<div class="system col-xs-6 col-md-3"><a href="#" class="thumbnail"><img src="img/demo.jpg"></a></div>')
        }
    }
})
