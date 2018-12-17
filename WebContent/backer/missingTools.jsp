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

<title>缺失零件</title>
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
			$("#nav-il-2").children('li:nth-child(2)').addClass("visiting");
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
                <%  
				     
					int num = 1;//当前页
					int max;
					String p = request.getParameter("page");
					if (p == null || p.equals("0")) {
						num = 1;
					} else {
						num = Integer.parseInt(p);

					}
				%>
				<form action="deleteMissingTools.action" id="form" method="post">
					<table class="table table-striped ">
						<thead style="font-weight: bold;">
							<td></td>
							<td>零件名称</td>
							<td>零件价格</td>
							<td>一级目录</td>
							<td>附属类Id</td>
							<td>编辑</td>
						</thead>
						<c:forEach items="${mts}" var="goods">
							<tr>
								<td><input name="id" type="checkbox" value="${goods.id}" /></td>
								<td>${goods.toolsName}</td>
								<td>${goods.toolsPrice}</td>
								<td>${goods.levelId}</td>
								<td>${goods.belongsId}</td>
								<td><input
									onclick="window.location.href='editMissingTools.action?id=${goods.id}'"
									type="button" class="form-button2" value="编辑" /></td>
							</tr>
						</c:forEach>
					</table>
						<tr align="center" valign="top">

						<td colspan="11">共${maxpage}页&nbsp;共${sum}有条记录&nbsp;当前是第<%=num %>页&nbsp;
						<c:choose>
								<c:when test="<%=num > 1%>">
									<a href="setMissTools.action?page=<%=num - 1%>">上一页</a>
								</c:when>
								<c:otherwise>
							            下一页
							   </c:otherwise>
							</c:choose> &nbsp; 
							<c:choose>
								<c:when test="${hasNext}">
									<a href="setMissTools.action?page=<%=num + 1%>">下一页</a>
								</c:when>
								<c:otherwise>
							            下一页
							   </c:otherwise>
							</c:choose> &nbsp; 
						</td>
						</tr>
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
					<h3 class="modal-title" id="addModalLabel">添加零件</h3>
				</div>
				<div class="modal-body">
					<form action="addMissingTools.action" method="post" id="addForm">
						<table class="table table-striped">
							<tr>
								<td>零件名称</td>
								<td><input name="toolsName" class="table-input"
									required="true" id="addGoodsType" /> <span style="color:red">(必填)</span></td>
							</tr>
							<tr>
								<td>商品价格：</td>
								<td><input name="toolsPrice" class="table-input"
									type="text" required="required" id="addGoodsPrice"/><span style="color:red">(必填)</span></td>
							</tr>
							<tr>
								<td>一级目录：</td>
								<td><select name="levelId" class="table-input"
									 id="addGoodsLevelId">
									 <c:forEach items="${goodsLevel}" var="level">
									    <option value="${level.id}">${level.levelName}</option>
									 </c:forEach>
									</select></td>
							</tr>

							<tr>
								<td>附属类Id：</td>
								<td><input name="belongsId" class="table-input" type="text"
									required="required" id="addBelongs"/><span style="color:red">(必填)</span></td></td>
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
					url : "modifyMissingTools.action",
					data : {
						id : id,
						imageUrl : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						window.location.url = '/backer/missingTools.jsp';
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
						document.getElementById("addBelongs").value.length == 0){
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
