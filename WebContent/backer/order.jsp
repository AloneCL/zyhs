<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="zhumeng.zyhs.ssm.pojo.Orders"%>
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

<title>订单管理</title>
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
            $('#nav-ul').children('li:nth-child(2)').addClass('visiting');
        </script>

			<div class="cont-right">
				<h3>
					<a href="setOrder.action">所有订单</a>
				</h3>
				<hr />
				<div class="test-button">
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
				<%-- var maxx = ${maxpage}; --%> 
				<form action="deleteOrder.action" id="form" method="post">
					<table class="table table-striped ">
						<thead style="font-weight: bold;">
							<td></td>
							<td>订单ID</td>
							<td>下单时间</td>
							<td>订单总价</td>
							<td>订单状态</td>
							<td>图片</td>
							<td>编辑</td>
						</thead>
						<c:forEach items="${Order}" var="orders">
							<tr>
								<td><input name="id" type="checkbox" value="${orders.id}" /></td>
								<%-- <td><fmt:formatDate value='${orders.releaseTime}'
										pattern='yyyy-MM-dd HH:mm:ss' /></td> --%>
								<td>${orders.id}</td>
								<td>${orders.releaseTime}</td>
								<%-- <td><fmt:formatDate value='${orders.orderTime}'
										pattern='yyyy-MM-dd HH:mm:ss' /></td>
								<td><fmt:formatDate value='${orders.finishTime}'
										pattern='yyyy-MM-dd HH:mm:ss' /></td>--%>
								<td>${orders.orderMoney}</td>
								<td><c:choose>
										<c:when test="${orders.orderStatus==0}">待接单</c:when>
										<c:when test="${orders.orderStatus==1}">进行中</c:when>
										<c:when test="${orders.orderStatus==2}">已完成</c:when>
										<c:when test="${orders.orderStatus==3}">已取消</c:when>
										<c:otherwise>待选</c:otherwise>
									</c:choose></td>
								<%-- <td><c:choose>
										<c:when test="${orders.orderManner==0}">用户积分</c:when>
										<c:when test="${orders.orderManner==1}">账户余额</c:when>
										<c:otherwise>待选</c:otherwise>
									</c:choose></td> --%>
								<td><input type="button"
									class="modifyImg form-button2 tableButton" value="设置封面" /> <img
									class="tableImg" src="${orders.imageUrl}" width="200"
									height="130" name="flag" /> <input type="text" name="imgurl"
									hidden></td>
								<td><input
									onclick="window.location.href='editOrder.action?id=${orders.id}'"
									type="button" class="form-button2" value="详情编辑" /></td>
							</tr>
						</c:forEach>
					</table>
					<tr align="center" valign="top">

						<td colspan="11">共${maxpage}页&nbsp;共${sum}有条记录&nbsp;当前是第<%=num %>页&nbsp;
						<c:choose>
								<c:when test="<%=num > 1%>">
									<a href="setOrder.action?page=<%=num - 1%>">上一页</a>
								</c:when>
								<c:otherwise>
							            下一页
							   </c:otherwise>
							</c:choose> &nbsp; 
							<c:choose>
								<c:when test="${hasNext}">
									<a href="setOrder.action?page=<%=num + 1%>">下一页</a>
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
					url : "modifyOrder.action",
					data : {
						id : id,
						imageUrl : obj.url
					},
					fail : function() {
						notify('.cont-right', '设置失败', 'warning');
					},
					success : function() {
						notify('.cont-right', '设置成功', 'success');
						window.location.url = '/backer/order.jsp';
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
			$('#addButton')
					.click(
							function() {
								if (document.getElementById("addGoodsType").value.length == 0
										|| document
												.getElementById("addGoodsPrice").value.length == 0) {
									alert("These inputs can not be empty!!");
									//document.focus();
									return false;
								} else
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
