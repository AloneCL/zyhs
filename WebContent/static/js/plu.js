/*HTMLҳ���Զ����¶����б�  ��ʼ*/
function ajax_zxdd($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_zxdd&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_zxdd').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����¶����б� ����*/

/*HTMLҳ���Զ����·����б�  ��ʼ*/
function ajax_fkls($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_fkls&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_fkls').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����·����б� ����*/

/*HTMLҳ���Զ����·�������  ��ʼ*/
function ajax_fk($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_fk&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_fk').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����·������� ����*/

/*HTMLҳ���Զ����¸�������������  ��ʼ*/
function ajax_pl($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_pl&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_pl').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����¸������������� ����*/

/*HTMLҳ���Զ����±���  ��ʼ*/
function ajax_y($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_y&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_y').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����±��� ����*/

/*HTMLҳ���Զ����µ����  ��ʼ*/
function ajax_hits($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_hits&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_hits').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����µ���� ����*/

/*HTMLҳ���Զ����µ����2  ��ʼ*/
function ajax_hits2($LMName, $ID) {
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_hits2&LMName=" + $LMName + "&id=" + $ID + "&time" + new Date().toString(),
        type: 'GET',
        success: function () {
            $('#ajax_hits2').html(arguments[0]);
        }
    });
}
/*HTMLҳ���Զ����µ����2 ����*/

/*��������  ��ʼ*/
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
/*�������� ����*/

function StopButton() {
    document.getElementById(arguments[0]).disabled = true;
    document.getElementById(arguments[0]).value = "�ύ(" + arguments[1] + ")";
    if (--arguments[1] > 0) {
        window.setTimeout("StopButton('" + arguments[0] + "'," + arguments[1] + ")", 1000);
    }
    if (arguments[1] <= 0) {
        document.getElementById(arguments[0]).value = '�ύ';
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
        alert('������д�ǳƣ�');
        $('#CommentUser').focus();
        return false;
    }
    //if ($.trim($CommentValidate)=='')
    //{
    //	alert('������д��֤�룡');
    //	$('#CommentValidate').focus();
    //	return false;
    //}		
    if ($.trim($CommentText) == '') {
        alert('������д�ظ����ݣ�');
        $('#CommentText').focus();
        return false;
    }
    if ($CommentText.length < 5 || $CommentText.length > 200) {
        alert('���ݱ�����5-200��֮�䣡');
        return false;
    }
    StopButton('CommentSubmit', 10);
    $.ajax({
        url: "../inc/Comment.asp?action=ajax_sendcomment&LMName=" + $LMName + "&commentparentid=" + $CommentParentID + "&commentuser=" + escape($CommentUser) + "&commenttext=" + escape($CommentText) + "&commentvalidate=" + escape($CommentValidate) + "&time=" + new Date().toString(),
        type: 'GET',
        success: function () {
            if (arguments[0] == 'ERROR') {
                alert('��֤�����');
            } else {
                GetComment($LMName, $CommentParentID, 0);
                alert(arguments[0]);
                $("#CommentText").val("");
                //��֤�ɹ�ʱ��ˢ����֤��ͼƬ
                //$("#CommentValidateImages").attr("src","../inc/Code.asp?s="+Math.random());
            }
            $("#CommentValidate").val("");
        }
    });
//SetCookie("CommentUser",$CommentUser,3);
}

