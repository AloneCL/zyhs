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
    <title>修改密码</title>
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
            $('#nav-ul').children('li:nth-child(5)').addClass('visiting');
        	</script>


        <div class="cont-right">
            <h3>修改密码</h3>
            <hr/>
            <form action="managerSubmitPass.action" method="post">
                <div style="margin-left: 200px">
                    请输入原密码：<input name="pass" type="password" class="form-input" required="required"/><br><br>
                    请输入新密码：<input name="pass1" type="password" id="npass1" name="password" class="form-input"
                                  required="required"/><br><br>
                    再输入新密码：<input id="npass2" type="password" class="form-input" required="required"/>
                </div>
                <hr>
                <button id="fb" type="submit" class="form-button" style="margin-left: 400px">确定</button>
            </form>
        </div>


        <c:if test="${not empty error }">
            <script type="text/javascript">
                alert('${error}')
            </script>
        </c:if>

        <script type="text/javascript">
            $("#fb").click(function () {
                var p1 = $("#npass1").val();
                var p2 = $("#npass2").val();

                if (p1 != '' && p2 != '' && p1 != p2) {
                    alert("新密码不一致");
                    p1 = $("#npass1").val("");
                    p2 = $("#npass2").val("");
                    p1.focus();
                    return false;
                }

            })
        </script>
    </div>

    <script type="text/javascript">

    </script>


</div>
</body>
</html>
