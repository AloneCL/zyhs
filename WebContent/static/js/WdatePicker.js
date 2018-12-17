/*
 * My97 DatePicker 4.5 Beta
 * SITE: http://dp.my97.net
 * BLOG: http://my97.cnblogs.com
 * MAIL: smallcarrot@163.com
 */
var $dp, WdatePicker;
(function (R) {
    var $ = {
        $wdate: true,
        $dpPath: "",
        $crossFrame: true,
        position: {},
        lang: "auto",
        skin: "default",
        dateFmt: "yyyy-MM-dd",
        realDateFmt: "yyyy-MM-dd",
        realTimeFmt: "HH:mm:ss",
        realFullFmt: "%Date %Time",
        minDate: "1900-01-01 00:00:00",
        maxDate: "2099-12-31 23:59:59",
        startDate: "",
        alwaysUseStartDate: false,
        yearOffset: 1911,
        isShowWeek: false,
        highLineWeekDay: true,
        isShowClear: true,
        isShowToday: true,
        isShowOthers: true,
        readOnly: false,
        errDealMode: 0,
        autoPickDate: null,
        qsEnabled: true,

        disabledDates: null,
        disabledDays: null,
        opposite: false,
        onpicking: null,
        onpicked: null,
        onclearing: null,
        oncleared: null,
        eCont: null,
        vel: null,
        errMsg: "",
        quickSel: [],
        has: {}
    };
    WdatePicker = V;
    var Y = window, P = "document", J = "documentElement", C = "getElementsByTagName", W, A, U, I, c, Q = [], O;
    switch (navigator.appName) {
        case"Microsoft Internet Explorer":
            U = true;
            break;
        case"Opera":
            c = true;
            break;
        default:
            I = true;
            break
    }
    A = L();
    if ($.$wdate) M(A + "skin/WdatePicker.css");
    W = Y;
    if ($.$crossFrame) {
        try {
            while (W.parent[P] != W[P] && W.parent[P][C]("frameset").length == 0)W = W.parent
        } catch (R) {
        }
    }
    if (!W.$dp) W.$dp = {
        ff: I,
        ie: U,
        opera: c,
        el: null,
        win: Y,
        status: 0,
        defMinDate: $.minDate,
        defMaxDate: $.maxDate
    };
    $dp = W.$dp;
    if ($dp.status == 0) a(Y, function () {
        V(null, true)
    });
    if (!Y[P].docMD) {
        E(Y[P], "onmousedown", D);
        Y[P].docMD = true
    }
    if (!W[P].docMD) {
        E(W[P], "onmousedown", D);
        W[P].docMD = true
    }
    E(Y, "onunload", function () {
        if ($dp.dd) $dp.dd.style.display = "none"
    });
    function B() {
        W.$dp = W.$dp || {};
        obj = {
            $: function ($) {
                return (typeof $ == "string") ? this.win[P].getElementById($) : $
            }, $D: function ($, _) {
                return this.$DV(this.$($).value, _)
            }, $DV: function (_, $) {
                if (_ != "") {
                    this.dt = $dp.cal.splitDate(_, $dp.cal.dateFmt);
                    if ($)for (var A in $) {
                        if (this.dt[A] === undefined) this.errMsg = "invalid property:" + A;
                        this.dt[A] += $[A]
                    }
                    if (this.dt.refresh())return this.dt
                }
                return ""
            }, show: function () {
                if (this.dd) this.dd.style.display = "block"
            }, hide: function () {
                if (this.dd) this.dd.style.display = "none"
            }, attachEvent: E
        };
        for (var $ in obj)W.$dp[$] = obj[$];
        $dp = W.$dp
    }

    function E(A, $, _) {
        if (U) A.attachEvent($, _); else {
            var B = $.replace(/on/, "");
            _._ieEmuEventHandler = function ($) {
                return _($)
            };
            A.addEventListener(B, _._ieEmuEventHandler, false)
        }
    }

    function L() {
        var _, A, $ = document.getElementsByTagName("script");
        for (var B = 0; B < $.length; B++) {
            _ = $[B].src.substring(0, $[B].src.toLowerCase().indexOf("wdatepicker.js"));
            A = _.lastIndexOf("/");
            if (A > 0) _ = _.substring(0, A + 1);
            if (_)break
        }
        return _
    }

    function F(F) {
        var E, C;
        if (F.substring(0, 1) != "/" && F.indexOf("://") == -1) {
            E = W.location.href;
            C = location.href;
            if (E.indexOf("?") > -1) E = E.substring(0, E.indexOf("?"));
            if (C.indexOf("?") > -1) C = C.substring(0, C.indexOf("?"));
            var _ = "", D = "", A = "", H, G, B = "";
            for (H = 0; H < Math.max(E.length, C.length); H++)if (E.charAt(H).toLowerCase() != C.charAt(H).toLowerCase()) {
                G = H;
                while (E.charAt(G) != "/") {
                    if (G == 0)break;
                    G -= 1
                }
                _ = E.substring(G + 1, E.length);
                _ = _.substring(0, _.lastIndexOf("/"));
                D = C.substring(G + 1, C.length);
                D = D.substring(0, D.lastIndexOf("/"));
                break
            }
            if (_ != "")for (H = 0; H < _.split("/").length; H++)B += "../";
            if (D != "") B += D + "/";
            F = B + F
        }
        $.$dpPath = F
    }

    function M(B, $, D) {
        var A = Y[P], E = A[C]("HEAD").item(0), _ = A.createElement("link");
        _.href = B;
        _.rel = "stylesheet";
        _.type = "text/css";
        if ($) _.title = $;
        if (D) _.charset = D;
        E.appendChild(_)
    }

    function a($, _) {
        E($, "onload", _)
    }

    function G($) {
        $ = $ || W;
        var A = 0, _ = 0;
        while ($ != W) {
            var D = $.parent[P][C]("iframe");
            for (var F = 0; F < D.length; F++) {
                try {
                    if (D[F].contentWindow == $) {
                        var E = X(D[F]);
                        A += E.left;
                        _ += E.top;
                        break
                    }
                } catch (B) {
                }
            }
            $ = $.parent
        }
        return {"leftM": A, "topM": _}
    }

    function X(E) {
        if (U)return E.getBoundingClientRect(); else {
            var A = {ROOT_TAG: /^body|html$/i, OP_SCROLL: /^(?:inline|table-row)$/i}, G = null, _ = E.offsetTop,
                F = E.offsetLeft, D = E.offsetWidth, B = E.offsetHeight, C = E.offsetParent;
            if (C != E)while (C) {
                F += C.offsetLeft;
                _ += C.offsetTop;
                if (C.tagName.toLowerCase() == "body") G = C.ownerDocument.defaultView;
                C = C.offsetParent
            }
            C = E.parentNode;
            while (C.tagName && !A.ROOT_TAG.test(C.tagName)) {
                if (C.scrollTop || C.scrollLeft)if (!A.OP_SCROLL.test(C.style.display))if (!c || C.style.overflow !== "visible") {
                    F -= C.scrollLeft;
                    _ -= C.scrollTop
                }
                C = C.parentNode
            }
            var $ = b(G);
            F -= $.left;
            _ -= $.top;
            D += F;
            B += _;
            return {"left": F, "top": _, "right": D, "bottom": B}
        }
    }

    function N($) {
        $ = $ || W;
        var _ = $[P];
        _ = _[J] && _[J].clientHeight && _[J].clientHeight <= _.body.clientHeight ? _[J] : _.body;
        return {"width": _.clientWidth, "height": _.clientHeight}
    }

    function b($) {
        $ = $ || W;
        var B = $[P], A = B[J], _ = B.body;
        B = (A && A.scrollTop != null && (A.scrollTop > _.scrollLeft || A.scrollLeft > _.scrollLeft)) ? A : _;
        return {"top": B.scrollTop, "left": B.scrollLeft}
    }

    function D($) {
        src = $ ? ($.srcElement || $.target) : null;
        if ($dp && !$dp.eCont && $dp.dd && $dp.dd.style.display == "block" && src != $dp.el) $dp.cal.close()
    }

    function Z() {
        $dp.status = 2;
        H()
    }

    function H() {
        if (Q.length > 0) {
            var $ = Q.shift();
            $.el = {innerHTML: ""};
            $.eCont = $dp.$($.eCont);
            $.autoPickDate = true;
            $.qsEnabled = false;
            K($)
        }
    }

    var T, _;

    function V(F, $) {
        B();
        $dp.win = Y;
        F = F || {};
        if ($) {
            if ($dp.status == 2)return;
            $dp.status = 1;
            if (!D()) {
                _ = _ || setInterval(function () {
                        if (W[P].readyState == "complete") clearInterval(_); else V(null, true)
                    }, 50);
                return
            }
            K({el: {innerHTML: ""}}, true)
        } else if (F.eCont) {
            Q.push(F);
            if ($dp.status == 2) H()
        } else {
            if ($dp.status == 0) $dp.status = 1;
            if ($dp.status != 2)return;
            var E, C = A();
            if (C) {
                E = C.srcElement || C.target;
                C.cancelBubble = true
            }
            F.el = $dp.$(F.el || E);
            if (!F.el || F.el && F.el.disabled || (F.el == $dp.el && $dp.dd.style.display != "none" && $dp.dd.style.left != "-1970px"))return;
            K(F)
        }
        function D() {
            if (U && W != Y && W[P].readyState != "complete")return false;
            return true
        }

        function A() {
            if (I) {
                func = A.caller;
                while (func != null) {
                    var $ = func.arguments[0];
                    if ($ && ($ + "").indexOf("Event") >= 0)return $;
                    func = func.caller
                }
                return null
            }
            return event
        }
    }

    function K(E, _) {
        for (var D in $)if (D.substring(0, 1) != "$") $dp[D] = $[D];
        for (D in E)if ($dp[D] === undefined) $dp.errMsg = "invalid property:" + D; else $dp[D] = E[D];
        $dp.elProp = $dp.el && $dp.el.nodeName == "INPUT" ? "value" : "innerHTML";
        if ($dp.el[$dp.elProp] == null)return;
        if ($dp.lang == "auto") $dp.lang = U ? navigator.browserLanguage.toLowerCase() : navigator.language.toLowerCase();
        if (!$dp.dd || $dp.eCont || ($dp.lang && $dp.realLang && $dp.realLang.name != $dp.lang && $dp.getLangIndex && $dp.getLangIndex($dp.lang) >= 0)) {
            if ($dp.dd && !$dp.eCont) W[P].body.removeChild($dp.dd);
            if ($.$dpPath == "") F(A);
            var B = "<iframe src=\"" + $.$dpPath + "My97DatePicker.htm\" frameborder=\"0\" border=\"0\" scrolling=\"no\"></iframe>";
            if ($dp.eCont) {
                $dp.eCont.innerHTML = B;
                a($dp.eCont.childNodes[0], Z)
            } else {
                $dp.dd = W[P].createElement("DIV");
                $dp.dd.style.cssText = "position:absolute;z-index:19700";
                $dp.dd.innerHTML = B;
                W[P].body.appendChild($dp.dd);
                a($dp.dd.childNodes[0], Z);
                if (_) $dp.dd.style.left = $dp.dd.style.top = "-1970px"; else {
                    $dp.show();
                    C()
                }
            }
        } else if ($dp.cal) {
            $dp.show();
            $dp.cal.init();
            if (!$dp.eCont) C()
        }
        function C() {
            var E = $dp.position.left, B = $dp.position.top, F = X($dp.el), $ = G(Y), C = N(W), A = b(W),
                D = $dp.dd.offsetHeight, _ = $dp.dd.offsetWidth;
            if (isNaN(B)) {
                if (B == "above" || (B != "under" && (($.topM + F.bottom + D > C.height) && ($.topM + F.top - D > 0)))) B = A.top + $.topM + F.top - D - 3; else B = A.top + $.topM + F.bottom;
                B += U ? -1 : 1
            } else B += A.top + $.topM;
            if (isNaN(E)) E = A.left + Math.min($.leftM + F.left, C.width - _ - 5) - (U ? 2 : 0); else E += A.left + $.leftM;
            $dp.dd.style.top = B + "px";
            $dp.dd.style.left = E + "px"
        }
    }
})($dp)