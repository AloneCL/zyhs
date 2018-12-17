<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="static/css/testOnline-programmer.css"/>
    <script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>轮播图片</title>
</head>
<body style="background-color: #E5E5E5;padding: 0px;">
<jsp:include page="include-mainNavbar.jsp"/>
<div>
    <style>
        * {color: #262626;}
        .questionCont {
            border-radius: 5px;
            margin-top: 20px;
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            background-color: white;
            height: 1120px;
        }
        .cont-right {
            width: 85%;
            float: left;
            color: #737373;
            padding-left: 33px;
            padding-right: 33px;
        }
        .test {
            border-radius: 6px;
            padding-top: 10px;
            float: left;
            text-align: center;
            width: 100px;
            height: 70px;
        }
        .test:hover {background-color: #66AFE9;color: white;cursor: pointer;}
        .test-button {margin-top: 10px;font-size: 17px;height: 70px;}
        .tableImg {display: none;position: absolute;}
        #edui1_iframeholder,#edui1{width: 100%!important;}
        #add > div > div > div.modal-body > form > table > tbody > tr > td:nth-child(1){width: 100px}
    </style>
    <div class="questionCont">
        <jsp:include page="include-mainTab.jsp"/>
        <script>
            $('#nav-ul').find('li:nth-child(3)').addClass('visiting');
            $('#nav-il-2').find('li:nth-child(3)').removeClass('visiting');
        </script>

        <div class="cont-right">
<!--             <div class="test-button"> -->
<!--                 <div class="test" data-target="#add" data-toggle="modal" > -->
<!--                     <img src="static/icon/question-add.png"/><br/>添加 -->
<!--                 </div> -->
<!--                 <div class="test" data-toggle="modal" data-target="#delete"> -->
<!--                     <img src="static/icon/question-delete.png"/><br/>删除 -->
<!--                 </div> -->
<!--             </div> -->
         
            <hr/>
            <!-- <input type="text" class="form-input" placeholder="关键字"/>
            <button class="form-button">搜索</button>
            <button class="form-button-default">重置</button>
            <hr /> -->
            
            <form action="deleteHotArticle.action" id="form" method="post">
                <table class="table table-striped ">
                    <thead style="font-weight: bold;">
                    <td></td>
                    <td>轮播图片1</td>
                    <td>轮播图片2</td>
                    <td>轮播图片3</td>
                    </thead>
                    
                        <tr>
                            <td><input name="id" type="checkbox" value="${hotImage.id}"/></td>
                            <td>
                                <input type="button" class="modifyImg1 form-button2 tableButton1" value="设置轮播图片1"/>
                                <img class="tableImg img1" src="${hotImage.image1URL }" width="200" height="130" name="flag1"/>
                                <input type="text" name="imgurl" hidden>
                            </td>
                            
                            <td>
                                <input type="button" class="modifyImg2 form-button2 tableButton2" value="设置轮播图片2"/>
                                <img class="tableImg img2" src="${hotImage.image2URL }" width="200" height="130" name="flag2"/>
                                <input type="text" name="imgurl" hidden>
                            </td>
                            
                            <td>
                                <input type="button" class="modifyImg3 form-button2 tableButton3" value="设置轮播图片3"/>
                                <img class="tableImg img3" src="${hotImage.image3URL }" width="200" height="130" name="flag3"/>
                                <input type="text" name="imgurl" hidden>
                            </td>
                        </tr>
                   
                </table>
            </form>
        </div>
    </div>


</div>

<div hidden>
<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
    <input type="file" name="upfile1" id="file1" accept="image/*" onchange="upload1()">
</div>

<div hidden>
<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
    <input type="file" name="upfile2" id="file2" accept="image/*" onchange="upload2()">
</div>

<div hidden>
<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
    <input type="file" name="upfile3" id="file3" accept="image/*" onchange="upload3()">
</div>
<script>
    var imgTarget;
    var inputTarget;

    $('.modifyImg1').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file1').click();
    });

    function upload1() {
        var fd = new FormData();
        fd.append( 'upfile1', $( '#file1' )[0].files[0] );
        $.ajax({
            url: 'ueditor/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage1(temp);
            }
        });
    }

    function updatePage1(data) {
    	
        let obj = JSON.parse(data);

        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

        if (imgTarget.attr('name') === 'flag1'){
            let id = imgTarget.parent().parent().find('input[name="id"]').val();
            $.ajax({
                url: "modifyHotImage.action",
                data: {Id:id, image1URL:obj.url},
                fail:function () {
                    notify('.cont-right', '设置失败','warning');
                },
                success: function () {
                    notify('.cont-right', '设置成功','success');
                    window.location.url = '/backer/hotImage.jsp';
                }
            })
        }
    }
    
    $('.modifyImg2').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file2').click();
    });

    function upload2() {
        var fd = new FormData();
        fd.append( 'upfile2', $( '#file2' )[0].files[0] );
        $.ajax({
            url: 'ueditor/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage2(temp);
            }
        });
    }

    function updatePage2(data) {
    	
        let obj = JSON.parse(data);

        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

        if (imgTarget.attr('name') === 'flag2'){
            let id = imgTarget.parent().parent().find('input[name="id"]').val();
            $.ajax({
                url: "modifyHotImage.action",
                data: {Id:id, image2URL:obj.url},
                fail:function () {
                    notify('.cont-right', '设置失败','warning');
                },
                success: function () {
                    notify('.cont-right', '设置成功','success');
                    window.location.url = '/backer/hotImage.jsp';
                }
            })
        }
    }
    $('.modifyImg3').click(function () {
        imgTarget = $(this).next();
        inputTarget = imgTarget.next();
        $('#file3').click();
    });

    function upload3() {
        var fd = new FormData();
        fd.append( 'upfile3', $( '#file3' )[0].files[0] );
        $.ajax({
            url: 'ueditor/jsp/controller.jsp?action=uploadimage',
            data: fd,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                let temp = data;
                updatePage3(temp);
            }
        });
    }

    function updatePage3(data) {
    	
        let obj = JSON.parse(data);

        if(obj.state === "SUCCESS"){
            inputTarget.val( obj.url );
            imgTarget.attr( 'src', obj.url );
        }
        else {
            notify('#add .modal-body','上传封面失败!', 'warning');
        }

        if (imgTarget.attr('name') === 'flag3'){
            let id = imgTarget.parent().parent().find('input[name="id"]').val();
            $.ajax({
                url: "modifyHotImage.action",
                data: {Id:id, image3URL:obj.url},
                fail:function () {
                    notify('.cont-right', '设置失败','warning');
                },
                success: function () {
                    notify('.cont-right', '设置成功','success');
                    window.location.url = '/backer/hotImage.jsp';
                }
            })
        }
    }
</script>

<!-- 配置文件 -->
<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="ueditor/ueditor.all.js"></script>
<script type="text/javascript">
    $(function () {
        $(".tableButton1").mouseover(function () {
            $(this).next().show(100);
        }).mouseout(function () {
            $(this).next().hide(100);
        });
        
        $(".tableButton2").mouseover(function () {
            $(".img2").show(100);
        }).mouseout(function () {
        	$(".img2").hide(100);
        });
        
        $(".tableButton3").mouseover(function () {
            $(".img3").show(100);
        }).mouseout(function () {
        	$(".img3").hide(100);
        });
        
//         $(".tableButton3").mouseover(function () {
//             $(this).next().show(100);
//         }).mouseout(function () {
//             $(this).next().hide(100);
//         });

    });

    var ue = UE.getEditor('content', {
        autoHeightEnabled: false
    });

    function notify(container, result, modal) {
        $(container).prepend(
            '<div class="alert alert-'
            + modal +' alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> <strong>'
            + result+'</strong>&nbsp; ' + message +'</div>'
        );
    }
</script>
</body>
</html>
