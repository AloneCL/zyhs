<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="static/css/testOnline-programmer.css" />
<script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>废旧小电器管理</title>
</head>
<body style="background-color: #E5E5E5; padding: 0px;">
	<jsp:include page="include-mainNavbar.jsp" />
	<div>
		<style>
* {
	color: #262626;
}

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

.test:hover {
	background-color: #66AFE9;
	color: white;
	cursor: pointer;
}

.test-button {
	margin-top: 10px;
	font-size: 17px;
	height: 70px;
}

.tableImg {
	display: none;
	position: absolute;
}

#edui1_iframeholder, #edui1 {
	width: 100% !important;
}

#add>div>div>div.modal-body>form>table>tbody>tr>td:nth-child(1) {
	width: 100px
}
</style>
		<div class="questionCont">
			<jsp:include page="include-mainTab.jsp" />
			<script>
			$("#nav-il-2").children('li:nth-child(5)').addClass("visiting");
			$("#nav-il-2").removeClass("display");
			$("#nav-il-2").addClass("onplay");
			</script>

			<div class="cont-right">
				<div class="test-button">
					<div class="test" data-target="#add" data-toggle="modal">
						<img src="static/icon/question-add.png" /><br />添加
					</div>
					<div class="test" data-toggle="modal" data-target="#delete">
						<img src="static/icon/question-delete.png" /><br />删除
					</div>
				</div>
				<hr />
				<!-- <input type="text" class="form-input" placeholder="关键字"/>
            <button class="form-button">搜索</button>
            <button class="form-button-default">重置</button>
            <hr /> -->

				<form action="deleteSmallAppliances.action" id="form" method="post">
					<table class="table table-striped ">
						<thead style="font-weight: bold;">
							<td></td>
							<td>商品名称</td>
							<td>商品价格</td>
							<td>商品介绍</td>
							<td>是否完整</td>
							<td>图片</td>
							<td>编辑</td>
						</thead>
						<c:forEach items="${smallgoods}" var="goods">
							<tr>
								<td><input name="id" id="id" type="checkbox" value="${goods.id}" /></td>
								<td>${goods.goodsType}</td>
								<td>${goods.goodsPrice}</td>
								<td>${goods.introduce}</td>
								<td><c:choose>
										<c:when test="${goods.complete==0}">&nbsp;&nbsp;否</c:when>
										<c:when test="${goods.complete==1}">&nbsp;&nbsp;是</c:when>
										<c:otherwise>未选择</c:otherwise>
									</c:choose></td>
								<td><input type="button"
									class="modifyImg form-button2 tableButton" value="设置封面" /> <img
									class="tableImg" src="${goods.imageUrl1}" width="200"
									height="130" name="flag" /> <input type="text" name="imgurl"
									hidden></td>
								<td><input
									onclick="window.location.href='editSmallAppliances.action?id=${goods.id}'"
									type="button" class="form-button2" value="编辑" /></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>


	</div>

	<!-- delete -->
	<div class="modal fade" id="delete" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">删除确认</h3>
				</div>
				<div class="modal-body" style="font-size: 16px;">
					<font id="desc" style="color: #999999;"> 确定删除所选记录? </font>
				</div>
				<div class="modal-footer">
					<button type="button" class="form-button-default"
						data-dismiss="modal">关闭</button>
					<button type="button" class="form-button" id="YButton">确定</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="addModalLabel">添加商品</h3>
				</div>
				<div class="modal-body">
					<form action="addSmallAppliances.action" method="post" id="addForm">
						<table class="table table-striped">
							<tr>
								<td>商品名称</td>
								<td><input name="goodsType" class="table-input"
									required="true" id="addGoodsType" /> <input type="button"
									value="设置封面" class="tableButton" id="uploadButton"> <img
									src="" alt="" class="tableImg" width="200" height="130">
									<input type="text" name="imageUrl1" id="imgurl" hidden/><span style="color:red">(必填)</span></td>
							</tr>
							<tr>
								<td>商品价格：</td>
								<td><input name="goodsPrice" class="table-input"
									type="text" required="required" id="addGoodsPrice"/><span style="color:red">(必填)</span></td>
							</tr>
							<tr>
								<td>一级目录：</td>
								<td><select name="goodsLevelId" class="table-input"
									 id="addGoodsLevelId">
									 <c:forEach items="${goodsLevel}" var="level">
									    <option value="${level.id}">${level.levelName}</option>
									 </c:forEach>
									</select></td>
							</tr>

							<tr>
								<td>商品介绍：</td>
								<td><input name="introduce" class="table-input" type="text"
									required="required" /></td>
							</tr>

							<tr>
								<td>是否完整：</td>
								<td><select name="complete">
										<option value="0">否</option>
										<option value="1">是</option>
								</select></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="form-button-default"
						data-dismiss="modal">取消</button>
					<button type="button" class="form-button" id="addButton">添加</button>
				</div>
			</div>
		</div>
	</div>

	<div hidden>
		<!--    input[file]标签的accept属性可用于指定上传文件的 MIME类型 。 -->
		<input type="file" name="upfile" id="file" accept="image/*"
			onchange="upload()">
	</div>

	<script>
		var imgTarget;
		var inputTarget;

		$('#uploadButton').click(function() {
			imgTarget = $(this).next();
			inputTarget = $('#imgurl');
			$('#file').click();
		});
		$('.modifyImg').click(function() {
			imgTarget = $(this).next();
			inputTarget = imgTarget.next();
			$('#file').click();
		});

		function upload() {
			var fd = new FormData();
			fd.append('upfile', $('#file')[0].files[0]);
			$.ajax({
				url : 'ueditor/jsp/controller.jsp?action=uploadimage',
				data : fd,
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					let temp = data;
					updatePage(temp);
				}
			});
		}

		function updatePage(data) {
			//     	var path = System.getProperty("evan.webapp");

			let obj = JSON.parse(data);
			//         var url = path+"/"+obj.url;
			if (obj.state === "SUCCESS") {
				inputTarget.val(obj.url);
				imgTarget.attr('src', obj.url);
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

			if (imgTarget.attr('name') === 'flag') {
				//         	let scenicid = imgTarget.parent().parent().find('input[name="scenicid"]').val();
				let id = imgTarget.parent().parent().find('input[name="id"]')
						.val();
				$.ajax({
					url : "modifySmallAppliances.action",
					data : {
						id : id,
						imageUrl1 : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						window.location.url = '/backer/smallAppliances.jsp';
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
		$(function() {
			$(".tableButton").mouseover(function() {
				$(this).next().show(100);
			}).mouseout(function() {
				$(this).next().hide(100);
			});

			$("#YButton").click(function() {
				$("#form").submit();
			});
			$('#addButton').click(function() {
				if (document.getElementById("addGoodsType").value.length == 0||
						document.getElementById("addGoodsPrice").value.length == 0||
						document.getElementById("addGoodsLevelId").value.length == 0){
					alert("These inputs can not be empty!!");
					//document.focus();
					return false;
				}
				else 
				$('#addForm').submit();
			});
		});

		var ue = UE.getEditor('content', {
			autoHeightEnabled : false
		});

		function notify(container, result, modal) {
			$(container)
					.prepend(
							'<div class="alert alert-'
            + modal +' alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> <strong>'
									+ result
									+ '</strong>&nbsp; '
									+ message
									+ '</div>');
		}
	</script>
</body>
</html>
