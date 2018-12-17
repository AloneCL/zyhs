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
<script type="text/javascript" src="static/js/tooltip.js"></script>
<script type="text/javascript" src="static/js/popover.js"></script>
<title>废弃车辆编辑</title>
</head>
<body style="background-color: #E5E5E5; padding: 0px;">
	<jsp:include page="include-mainNavbar.jsp"></jsp:include>
	<div>
		<style>
* {
	color: #262626;
}

.questionCont {
	border-radius: 5px;
	margin-top: 20px;
	width: 1100px;
	margin-left: auto;
	margin-right: auto;
	background-color: white;
	height: 1120px;
}


.cont-right {
	width: 950px;
	float: left;
	color: #737373;
	padding-left: 33px;
	padding-right: 33px;
}
.tableImg {display: none;position: absolute;}
</style>


		<div class="questionCont">
			<jsp:include page="include-mainTab.jsp"></jsp:include>
			<script>
			$("#nav-il-2").children('li:nth-child(8)').addClass("visiting");
			$("#nav-il-2").removeClass("display");
			$("#nav-il-2").addClass("onplay");
			</script>

<style>
.table-input {
	width: 550px;
	border: none;
	background-color: transparent;
}
</style>
			<div class="cont-right">
			<h3>物品编辑--><a href="setGoodsMissing.action?level=${cars.goodsLevelId}&bl=${cars.id}">包含缺件</a></h3>
				<br>
				<%--             <button onclick="window.location.href='scenicdetails.action?scenicid=${scenic.id }'" --%>
				<!--                     class="form-button-default2">内容管理 -->
				<!--             </button> -->
				<hr />
				<h3>物品编辑</h3>
				<hr />
				<form action="submitEditCars.action" method="post">
					<table class="table table-striped ">
						<tr>
							<td>id：</td>
							<td><input name="id" id="id" type="text" value="${cars.id}"
								class="table-input" readonly="readonly" required="true" /></td>
						</tr>
						<tr>
							<td>商品上级分类：</td>
							<td><span style="font-size: 20px; color: #66AFE9;">${catalog.levelName}</span></td>
						</tr>
						<tr>
							<td>商品名称：</td>
							<td><input name="goodsType" type="text"
								value="${cars.goodsType }" class="table-input"
								style="font-size: 20px; color: #66AFE9;" /></td>
						</tr>
						<tr>
							<td>商品价格：</td>
							<td><input name="goodsPrice" type="text"
								value="${cars.goodsPrice }" class="table-input" /></td>
						</tr>
						<tr>
							<td>车辆类型(单位):</td>
							<td><select name="carType">
									<option value="0" <c:if test="${cars.carType == 0}">selected</c:if>>摩托车/其他(元)</option>
									<option value="1" <c:if test="${cars.carType == 1}">selected</c:if>>根据单价(元/t)</option>
							</select></td>
						</tr>
						<tr>
							<td>商品介绍：</td>
							<td><input name="introduce" type="text"
								value="${cars.introduce }" class="table-input" /></td>
						</tr>
						<tr>
							<td>详情图片：</td>
							<td><input type="button" value="详情图片1" class="tableButton" id="uploadButton1"> 
								<img src="${cars.imageUrl1}" alt=""name="flag1" class="tableImg" width="200" height="130">
								 <input type="text" name="imageUrl1" id="imgurl1" value="${cars.imageUrl1}" hidden>
								 <input type="button" value="详情图片2" class="tableButton" id="uploadButton2">
								 <img
								src="${cars.imageUrl2}" alt="" name="flag2" class="tableImg"
								width="200" height="130"> <input type="text"
								name="imageUrl2" id="imgurl2" value="${cars.imageUrl2}" hidden>

								<input type="button" value="详情图片3" class="tableButton"
								id="uploadButton3"> <img src="${cars.imageUrl3}" alt=""
								name="flag3" class="tableImg" width="200" height="130"> <input
								type="text" name="imageUrl3" id="imgurl3"
								value="${cars.imageUrl3}" hidden></td>
						</tr>

					</table>
					<script type="text/javascript">
						$(function() {
							$('[data-toggle="tooltip"]').tooltip()
						})
					</script>
					<hr>
					<input type="submit" class="form-button"
						style="margin-left: 400px;" value="提交" />
				</form>
			</div>
		</div>

	</div>

	<div hidden>
		<input type="file" name="upfile1" id="file1" accept="image/*"
			onchange="upload1()">
	</div>

	<div hidden>
		<input type="file" name="upfile2" id="file2" accept="image/*"
			onchange="upload2()">
	</div>

	<div hidden>
		<input type="file" name="upfile3" id="file3" accept="image/*"
			onchange="upload3()">
	</div>

	<script>
		var imgTarget;
		var inputTarget;

		$('#uploadButton1').click(function() {
			imgTarget = $(this).next();
			inputTarget = $('#imgurl1');
			$('#file1').click();
		});
		$('#uploadButton2').click(function() {
			imgTarget = $(this).next();
			inputTarget = $('#imgurl2');
			$('#file2').click();
		});
		$('#uploadButton3').click(function() {
			imgTarget = $(this).next();
			inputTarget = $('#imgurl3');
			$('#file3').click();
		});

		function upload1() {
			var fd = new FormData();
			fd.append('upfile1', $('#file1')[0].files[0]);
			$.ajax({
				url : 'ueditor/jsp/controller.jsp?action=uploadimage',
				data : fd,
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					let temp = data;
					updatePage1(temp);
				}
			});
		}

		function upload2() {
			var fd = new FormData();
			fd.append('upfile2', $('#file2')[0].files[0]);
			$.ajax({
				url : 'ueditor/jsp/controller.jsp?action=uploadimage',
				data : fd,
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					let temp = data;
					updatePage2(temp);
				}
			});
		}

		function upload3() {
			var fd = new FormData();
			fd.append('upfile3', $('#file3')[0].files[0]);
			$.ajax({
				url : 'ueditor/jsp/controller.jsp?action=uploadimage',
				data : fd,
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					let temp = data;
					updatePage3(temp);
				}
			});
		}

		function updatePage1(data) {
			let obj = JSON.parse(data);
			if (obj.state === "SUCCESS") {
				inputTarget.val(obj.url);
				imgTarget.attr('src', obj.url);
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

			if (imgTarget.attr('name') === 'flag1') {
				let id = $('#id').val();
				$.ajax({
					url : "modifyCars.action",
					data : {
						id : id,
						imageUrl1 : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						window.location.url = '/backer/airConditionSet.jsp';
					}
				})
			}
		}
		function updatePage2(data) {
			let obj = JSON.parse(data);
			if (obj.state === "SUCCESS") {
				inputTarget.val(obj.url);
				imgTarget.attr('src', obj.url);
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

			if (imgTarget.attr('name') === 'flag2') {
				let id = $('#id').val();
				$.ajax({
					url : "modifyCars.action",
					data : {
						id : id,
						imageUrl2 : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						window.location.url = '/backer/airConditionSet.jsp';
					}
				})
			}
		}
		function updatePage3(data) {
			let obj = JSON.parse(data);
			if (obj.state === "SUCCESS") {
				inputTarget.val(obj.url);
				imgTarget.attr('src', obj.url);
			} else {
				notify('#add .modal-body', '上传封面失败!', 'warning');
			}

			if (imgTarget.attr('name') === 'flag3') {
				let id = $('#id').val();
				$.ajax({
					url : "modifyCars.action",
					data : {
						id : id,
						imageUrl3 : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						window.location.url = '/backer/airConditionSet.jsp';
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

		});

		var ue = UE.getEditor('content', {
			autoHeightEnabled : false
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
