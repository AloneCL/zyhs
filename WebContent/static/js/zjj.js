$(function () {
    $("img.lazy").lazyload({effect: "fadeIn"});
});
/*第一种形式 第二种形式 更换显示样式*/
function setTab(name, cursel, n) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var con = document.getElementById("con_" + name + "_" + i);
        menu.className = i == cursel ? "hoverb" : "";
        con.style.display = i == cursel ? "block" : "none";
    }
}
// 设为首页 <a href="javascript:void(0)" onclick="SetHome(this,window.location)">设为首页</a>
function SetHome(obj, vrl) {
    try {
        obj.style.behavior = 'url(#default#homepage)';
        obj.setHomePage(vrl);
    }
    catch (e) {
        if (window.netscape) {
            try {
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }
            catch (e) {
                alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
            }
            var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
            prefs.setCharPref('browser.startup.homepage', vrl);
        } else {
            alert("您的浏览器不支持，请按照下面步骤操作：1.打开浏览器设置。2.点击设置网页。3.输入：" + vrl + "点击确定。");
        }
    }
}
//加入收藏 <a onClick="AddFavorite(window.location,document.title)" href="javascript:void(0)">收藏本站</a>
function AddFavorite(sURL, sTitle) {
    sURL = encodeURI(sURL);
    try {
        window.external.addFavorite(sURL, sTitle);
    } catch (e) {
        try {
            window.sidebar.addPanel(sTitle, sURL, "");
        } catch (e) {
            alert("加入收藏失败，请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");
        }
    }
}

//图片缩放 开始
function DrawImage(ImgD, FitWidth) {
    var image = new Image();
    image.src = ImgD.src;
    if (image.width > 0) {
        if (image.width >= FitWidth) {
            ImgD.width = FitWidth;
            ImgD.height = (image.height * FitWidth) / image.width;
        }
        else {
            ImgD.width = image.width;
            ImgD.height = image.height;
        }
    }

}
//图片缩放 结束
//商品分类开始
$(function () {
    $('.all-goods .item').hover(function () {
        $(this).addClass('active').find('s').hide();
        $(this).find('.product-wrap').show();
    }, function () {
        $(this).removeClass('active').find('s').show();
        $(this).find('.product-wrap').hide();
    });
});
/*flash调用,<script type="text/javascript">LoadFlash('transparent','images/ad01.swf', 182, 361,"","","");</script>*/
function LoadFlash(wmode, url, width, Height, urls, Vars, titles) {
    document.write(
        '<embed src="' + url + '" wmode=' + wmode +
        ' quality="high" pluginspage=http://www.macromedia.com/go/getflashplayer type="application/x-shockwave-flash" width="' + width +
        '" height="' + Height + '" FlashVars="myUrl=' + urls + '&myVar=' + Vars + '&mytitle=' + titles + '"></embed>');
}
function ILoadFlash(obj, wmode, url, width, Height, urls, Vars, titles) {
    document.getElementById('' + obj + '').innerHTML += '<embed src="' + url + '" wmode=' + wmode +
        ' quality="high" pluginspage=http://www.macromedia.com/go/getflashplayer type="application/x-shockwave-flash" width="' + width +
        '" height="' + Height + '" FlashVars="myUrl=' + urls + '&myVar=' + Vars + '&mytitle=' + titles + '"></embed>';
}

//滚动插件Marquee
//mfkiqpl
//2014.1.14
//http://www.tbp.com.cn/lab/marquee.html
(function ($) {
    $.fn.mMarquee = function (options) {
        var opt = $.extend({
            bcont: 'ul',//滚动元素的父元素
            icont: 'li',//滚动元素
            dirct: 'up',//向左滚动 up=向上滚动
            speed: 4 //滚动速度
        }, options);
        var _this, _thisb, timer, worh, bc = 0;
        return this.each(function () {
            _this = $(this);
            _thisb = _this.find(opt.bcont);
            worh = abb();
            _thisb.css({"display": "block", "overflow": "hidden"});
            if (opt.dirct == 'left') {
                _thisb.css("width", worh * 2);
            } else {
                _thisb.css("height", worh);
            }
            _this.hover(function () {
                clearInterval(timer)
            }, function () {
                timer = setInterval(scroll_, opt.speed * 10);
            }).mouseleave();

        });
        function scroll_() {
            if (Math.abs(bc) >= worh) {
                bc = 0;
            }
            if (opt.dirct == 'left') {
                _thisb.css("margin-left", --bc);
            } else {
                _thisb.scrollTop(++bc);
            }
        }

        function abb() {
            var wh = 0;
            _thisb.find(opt.icont).each(function () {
                if (opt.dirct == 'left') {
                    wh += $(this).outerWidth(true);
                } else {
                    wh += $(this).outerHeight(true);
                }
                $(this).clone().appendTo(_thisb);
            });
            return wh;
        }
    }
})(jQuery);


