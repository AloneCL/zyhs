$(function () {
    $("img.lazy").lazyload({effect: "fadeIn"});
});
/*��һ����ʽ �ڶ�����ʽ ������ʾ��ʽ*/
function setTab(name, cursel, n) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var con = document.getElementById("con_" + name + "_" + i);
        menu.className = i == cursel ? "hoverb" : "";
        con.style.display = i == cursel ? "block" : "none";
    }
}
// ��Ϊ��ҳ <a href="javascript:void(0)" onclick="SetHome(this,window.location)">��Ϊ��ҳ</a>
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
                alert("�˲�����������ܾ���\n�����������ַ�����롰about:config�����س�\nȻ�� [signed.applets.codebase_principal_support]��ֵ����Ϊ'true',˫�����ɡ�");
            }
            var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
            prefs.setCharPref('browser.startup.homepage', vrl);
        } else {
            alert("�����������֧�֣��밴�����沽�������1.����������á�2.���������ҳ��3.���룺" + vrl + "���ȷ����");
        }
    }
}
//�����ղ� <a onClick="AddFavorite(window.location,document.title)" href="javascript:void(0)">�ղر�վ</a>
function AddFavorite(sURL, sTitle) {
    sURL = encodeURI(sURL);
    try {
        window.external.addFavorite(sURL, sTitle);
    } catch (e) {
        try {
            window.sidebar.addPanel(sTitle, sURL, "");
        } catch (e) {
            alert("�����ղ�ʧ�ܣ���ʹ��Ctrl+D�������,���ֶ�����������������.");
        }
    }
}

//ͼƬ���� ��ʼ
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
//ͼƬ���� ����
//��Ʒ���࿪ʼ
$(function () {
    $('.all-goods .item').hover(function () {
        $(this).addClass('active').find('s').hide();
        $(this).find('.product-wrap').show();
    }, function () {
        $(this).removeClass('active').find('s').show();
        $(this).find('.product-wrap').hide();
    });
});
/*flash����,<script type="text/javascript">LoadFlash('transparent','images/ad01.swf', 182, 361,"","","");</script>*/
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

//�������Marquee
//mfkiqpl
//2014.1.14
//http://www.tbp.com.cn/lab/marquee.html
(function ($) {
    $.fn.mMarquee = function (options) {
        var opt = $.extend({
            bcont: 'ul',//����Ԫ�صĸ�Ԫ��
            icont: 'li',//����Ԫ��
            dirct: 'up',//������� up=���Ϲ���
            speed: 4 //�����ٶ�
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


