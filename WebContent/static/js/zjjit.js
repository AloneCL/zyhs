$(function () {
    //下拉
    $("#dropdownBox ul li:eq(0)").hide();
    $("#dropdownBox p").click(function () {
        var ul = $("#dropdownBox ul");
        ul.css('z-index', '999');
        if (ul.css("display") == "none") {
            ul.slideDown("fast");
        } else {
            ul.slideUp("fast");
        }
    });

    $("#dropdownBox ul li a").click(function () {
        var txt = $(this).text();
        $("#dropdownBox p").html(txt);
        var value = $(this).attr("rel"); //获取ID来判断选择的几 在把这个ID放松到后台查询
        $("#caseid").val(value);

        $("#dropdownBox ul").hide();
        if (value != null) {
            $("#dropdownBox ul li:eq(0)").show();
            $(this).attr("rel", 0);
        }

    });

    //去掉焦点
    //focusblur
    jQuery.focusblur = function (focusid) {
        var focusblurid = $(focusid);
        var defval = focusblurid.val();
        focusblurid.focus(function () {
            var thisval = $(this).val();
            if (thisval == defval) {
                $(this).val("");
                $(this).css('color', "#111");
            }
        });
        focusblurid.blur(function () {
            var thisval = $(this).val();
            if (thisval == "") {
                $(this).val(defval);
                $(this).css('color', "#666");
            }
        });

    };
    /*调用方法*/
    $.focusblur("#s_input");

    $(".relineList:gt(0)").addClass('relinemargin20px');
    $(".relineList:eq(0)").css('margin-left', '8px');
    $('.rl_title:eq(0)').css('background', '#48AEEC');
    $('.rl_title:eq(1)').css('background', '#F96043');
    $('.rl_title:eq(2)').css('background', '#2CBA9E');
    $('.rl_title:eq(3)').css('background', '#9627C2');
    $('.h_hotelList:eq(2)').css('margin-right', '0');
    $('.h_hotelList:eq(0)').css('margin-left', '10px');
    $('.h_hotelList:eq(5)').css('margin-right', '0');
    $('.h_hotelList:eq(3)').css('margin-left', '10px');
    $('.hotLineBox .jxline1 img').hover(function () {
        $(this).css({"opacity": "0.8"});
    }, function () {
        $(this).css({"opacity": "1"});
    });
    $('.hotLineBox .jxline2 img').hover(function () {
        $(this).css({"opacity": "0.8"});
    }, function () {
        $(this).css({"opacity": "1"});
    });

    $('.relineList img').hover(function () {
        $(this).css({"opacity": "0.8"});
    }, function () {
        $(this).css({"opacity": "1"});
    });
    $('.h_hotelList img').hover(function () {
        $(this).css({"opacity": "0.8"});
    }, function () {
        $(this).css({"opacity": "1"});
    });


    $("#kandian a:eq(0)").after("&nbsp;|&nbsp;");
    $("#kandian a:eq(1)").after("&nbsp;|&nbsp;");
    $("#kandian a:eq(2)").after("&nbsp;|&nbsp;");
    $("#xianlutuijianok a:eq(0)").after("&nbsp;|&nbsp;");


})

window.onload = function () {
    var oBtnLeft = document.getElementById("goleft");
    var oBtnRight = document.getElementById("goright");
    var oDiv = document.getElementById("indexmaindiv");
    var oDiv1 = document.getElementById("maindiv1");
    var oUl = oDiv.getElementsByTagName("ul")[0];
    var aLi = oUl.getElementsByTagName("li");
    var now = -1 * (aLi[0].offsetWidth + 13);
    oUl.style.width = aLi.length * (aLi[0].offsetWidth + 13) + 'px';
    oBtnRight.onclick = function () {
        var n = Math.floor((aLi.length * (aLi[0].offsetWidth + 13) + oUl.offsetLeft) / aLi[0].offsetWidth);

        if (n <= 1) {
            move(oUl, 'left', 0);
        }
        else {
            move(oUl, 'left', oUl.offsetLeft + now);
        }
    }
    oBtnLeft.onclick = function () {
        var now1 = -Math.floor((aLi.length / 1)) * 1 * (aLi[0].offsetWidth + 13);

        if (oUl.offsetLeft >= 0) {
            move(oUl, 'left', now1);
        }
        else {
            move(oUl, 'left', oUl.offsetLeft - now);
        }
    }
    var timer = setInterval(oBtnRight.onclick, 3000);
    oDiv.onmouseover = function () {
        clearInterval(timer);
    }
    oDiv.onmouseout = function () {
        timer = setInterval(oBtnRight.onclick, 3000);
    }

};

function getStyle(obj, name) {
    if (obj.currentStyle) {
        return obj.currentStyle[name];
    }
    else {
        return getComputedStyle(obj, false)[name];
    }
}

function move(obj, attr, iTarget) {
    clearInterval(obj.timer)
    obj.timer = setInterval(function () {
        var cur = 0;
        if (attr == 'opacity') {
            cur = Math.round(parseFloat(getStyle(obj, attr)) * 100);
        }
        else {
            cur = parseInt(getStyle(obj, attr));
        }
        var speed = (iTarget - cur) / 6;
        speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
        if (iTarget == cur) {
            clearInterval(obj.timer);
        }
        else if (attr == 'opacity') {
            obj.style.filter = 'alpha(opacity:' + (cur + speed) + ')';
            obj.style.opacity = (cur + speed) / 100;
        }
        else {
            obj.style[attr] = cur + speed + 'px';
        }
    }, 30);
}  