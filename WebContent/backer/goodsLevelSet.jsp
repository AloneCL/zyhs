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
<title>目录编辑</title>
</head>
<body style="background-color: #E5E5E5;padding: 0px;">
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
            $('#nav-ul').children('li:nth-child(1)').addClass('visting');
        </script>

        <style>
            .table-input {
                width: 550px;
                border: none;
                background-color: transparent;
            }
        </style>
        <div class="cont-right">
				
				<%--             <button onclick="window.location.href='scenicdetails.action?scenicid=${scenic.id }'" --%>
				<!--                     class="form-button-default2">内容管理 -->
				<!--             </button> -->
				<hr />
				<h3>物品编辑</h3>
				<hr />
				<form action="submitEditGoodsLevel.action" method="post">
					<table class="table table-striped ">
						<tr>
							<td>id：</td>
							<td><input name=id type="text" value="${gls.id}"
								class="table-input" readonly="readonly" required="true"/></td>
						</tr>
						<tr>
							<td>目录级别：</td>
							<td><input name="level" type="text"
								value="${gls.level}" class="table-input"
								style="font-size: 20px; color: #66AFE9;"  /></td>
						</tr>
						<tr>
							<td>分类名称：</td>
							<td><input name="levelName" type="text"
								value="${gls.levelName }" class="table-input"
								style="font-size: 20px; color: #66AFE9;" /></td>
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
