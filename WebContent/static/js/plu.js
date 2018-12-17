/*HTML页面自动更新订单列表  开始*/
function ajax_zxdd($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_zxdd&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_zxdd').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新订单列表 结束*/

/*HTML页面自动更新反馈列表  开始*/
function ajax_fkls($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_fkls&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_fkls').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新反馈列表 结束*/

/*HTML页面自动更新反馈条数  开始*/
function ajax_fk($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_fk&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_fk').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新反馈条数 结束*/

/*HTML页面自动更新该文章评论条数  开始*/
function ajax_pl($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pl&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pl').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新该文章评论条数 结束*/

/*HTML页面自动更新本月  开始*/
function ajax_y($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_y&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_y').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新本月 结束*/

/*HTML页面自动更新点击数  开始*/
function ajax_hits($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_hits&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_hits').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新点击数 结束*/

/*HTML页面自动更新点击数2  开始*/
function ajax_hits2($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_hits2&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_hits2').html(arguments[0]);
        }
    });
}
/*HTML页面自动更新点击数2 结束*/

/*评论条数  开始*/
function ajax_pingle($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pingle&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pingle').html(arguments[0]);
        }
    });
}

function ajax_pingle($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pingle&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pingle').html(arguments[0]);
        }
    });
}

function ajax_pingle0($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pingle0&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pingle0').html(arguments[0]);
        }
    });
}

function ajax_pingle1($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pingle1&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pingle1').html(arguments[0]);
        }
    });
}

function ajax_pingle2($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pingle2&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pingle2').html(arguments[0]);
        }
    });
}
/*评论条数 结束*/

function StopButton() {
    document.getElementById(arguments[0]).disabled = true;
    document.getElementById(arguments[0]).value = "提交(" + arguments[1] + ")";
    if (--arguments[1] > 0) {
        window.setTimeout("StopButton('" + arguments[0] + "'," + arguments[1] + ")", 1000);
    }
    if (arguments[1] <= 0) {
        document.getElementById(arguments[0]).value = '提交';
        document.getElementById(arguments[0]).disabled = false;
    }
}
function GetComment($LMName, $ID, $Page) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_getcomment&LMName=" + $LMName + "&id=" + $ID + "&page=" + $Page + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#comment').html(arguments[0]);
        }
    });
}
function GetComment0($LMName, $ID, $Page) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_getcomment0&LMName=" + $LMName + "&id=" + $ID + "&page=" + $Page + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#comment0').html(arguments[0]);
        }
    });
}
function GetComment1($LMName, $ID, $Page) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_getcomment1&LMName=" + $LMName + "&id=" + $ID + "&page=" + $Page + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#comment1').html(arguments[0]);
        }
    });
}
function GetComment2($LMName, $ID, $Page) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_getcomment2&LMName=" + $LMName + "&id=" + $ID + "&page=" + $Page + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#comment2').html(arguments[0]);
        }
    });
}
function SendComment() {
    var $CommentParentID = arguments[0];
    var $CommentUser = $('#CommentUser').val();
    var $CommentText = $('#CommentText').val();
    var $CommentValidate = $('#CommentValidate').val();
    var $LMName = $('#LMName').val();
    //var $commentlx	= $('input[name="commentlx"]:checked').val();
    if ($.trim($CommentUser) == '') {
        alert('请您填写昵称！');
        $('#CommentUser').focus();
        return false;
    }
    //if ($.trim($CommentValidate)=='')
    //{
    //	alert('请您填写验证码！');
    //	$('#CommentValidate').focus();
    //	return false;
    //}		
    if ($.trim($CommentText) == '') {
        alert('请您填写回复内容！');
        $('#CommentText').focus();
        return false;
    }
    if ($CommentText.length < 5 || $CommentText.length > 200) {
        alert('内容必须在5-200字之间！');
        return false;
    }
    StopButton('CommentSubmit', 10);
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_sendcomment&LMName=" + $LMName + "&commentparentid=" + $CommentParentID + "&commentuser=" + escape($CommentUser) + "&commenttext=" + escape($CommentText) + "&commentvalidate=" + escape($CommentValidate) + "&time=" + new Date().toString(),
        type: 'GET',
        success: function () {
            if (arguments[0] == 'ERROR') {
                alert('验证码出错！');
            } else {
                GetComment($LMName, $CommentParentID, 0);
                alert(arguments[0]);
                $("#CommentText").val("");
                //验证成功时，刷新验证码图片
                //$("#CommentValidateImages").attr("src","../inc/Code.asp?s="+Math.random());
            }
            $("#CommentValidate").val("");
        }
    });
//SetCookie("CommentUser",$CommentUser,3);
}

