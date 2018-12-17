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
<title>零件编辑</title>
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

.cont-left {
	height: 100%;
	width: 150px;
	border-right: solid 1px #C7DDEF;
	float: left;
}

.cont-left ul {
	list-style-type: none;
	padding: 0px;
}

.cont-left ul li {
	text-align: center;
	height: 80px;
	font-size: 16px;
	line-height: 80px;
	border-bottom: solid 1px #C7DDEF;
}

.cont-left ul li:hover {
	color: #66AFE9;
	cursor: pointer;
}

.cont-right {
	width: 950px;
	float: left;
	color: #737373;
	padding-left: 33px;
	padding-right: 33px;
}
</style>


		<div class="questionCont">
			<jsp:include page="include-mainTab.jsp"></jsp:include>
			<script>
				$('#nav-ul').find('li:nth-child(4)').addClass('visiting');
				$('#nav-li-2').find('li:nth-child(4)').remove('visitting');
			</script>

			<style>
.table-input {
	width: 550px;
	border: none;
	background-color: transparent;
}
</style>
			<div class="cont-right">
				<br>
				<%--             <button onclick="window.location.href='scenicdetails.action?scenicid=${scenic.id }'" --%>
				<!--                     class="form-button-default2">内容管理 -->
				<!--             </button> -->
				<hr />
				<h3><a href="javascript:history.back(-1)">返回零件列表</a>-->零件编辑</h3>
				<hr />
				<form action="submitEditGoodsMissing.action" method="post">
					<table class="table table-striped ">
						<tr>
							<td>id：</td>
							<td><input name=id type="text" value="${mts.id}"
								class="table-input" readonly="readonly" required="true"/></td>
						</tr>
						<tr>
							<td>一级目录id：</td>
							<td><input name="levelId" type="text"
								value="${mts.levelId}" class="table-input"
								style="font-size: 20px; color: #66AFE9;" readonly="readonly" /></td>
						</tr>
						<tr>
							<td>商品名称：</td>
							<td><input name="toolsName" type="text"
								value="${mts.toolsName }" class="table-input"
								style="font-size: 20px; color: #66AFE9;" /></td>
						</tr>
						<tr>
							<td>商品价格：</td>
							<td><input name="toolsPrice" type="text"
								value="${mts.toolsPrice }" class="table-input" /></td>
						</tr>
						<tr>
							<td>附属类Id：</td>
							<td><input name="belongsId" type="text"
								value="${mts.belongsId }" class="table-input" readonly="readonly"/></td>
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


</body>
</html>
