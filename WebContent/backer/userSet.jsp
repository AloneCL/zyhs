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
    <script type="text/javascript" src="static/js/tooltip.js"></script>
    <script type="text/javascript" src="static/js/popover.js"></script>
    <title>用户管理</title>
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
    </style>


    <div class="questionCont">
        <jsp:include page="include-mainTab.jsp"></jsp:include>
        <script>
            $('#nav-ul').children('li:nth-child(4)').addClass('visiting');
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
            <hr/>
            <h3>用户编辑</h3>
            <hr/>
            <form action="submitEditUser.action" method="post">
                <table class="table table-striped ">
                    <tr>
                        <td>id：</td>
                        <td><input name=id type="text" value="${user.id }" class="table-input"
                                   readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>用户名：</td>
                        <td><input name="userName" type="text" value="${user.userName }" class="table-input"
                        style="font-size: 20px; color: #66AFE9;"/></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input name="userPass" type="text" value="${user.userPass }" class="table-input"/></td>
                    </tr>

                    <tr>
                        <td>手机号码：</td>
                        <td><input name="userTel" type="text" value="${user.userTel }" class="table-input"/></td>
                    </tr>
                    <tr>
                        <td>地区：</td>
                        <td><input name="address" type="text" value="${user.address }" class="table-input"/> (请填写用户的详细住址)</td>
                    </tr>
                     <tr>
                        <td>支付密码：</td>
                        <td><input name="payPass" type="text" value="${user.payPass }" class="table-input"/></td>
                    </tr> <tr>
                        <td>余额：</td>
                        <td><input name="balance" type="text" value="${user.balance }" class="table-input"/></td>
                    </tr>
                    <tr>
                        <td>积分：</td>
                        <td><input name="integral" type="text" value="${user.integral }" class="table-input"/></td>
                    </tr> 
                    <tr>
                        <td>
                         <c:choose>
                             <c:when test="${user.identity==1}">
                                                          负责区域：<td><input name="recoverArea" type="text" value="${user.recoverArea}" class="table-input"/></td>
                             </c:when>
                         </c:choose>
                        </td>
                    </tr>
                </table>
                <script type="text/javascript">
                    $(function () {
                        $('[data-toggle="tooltip"]').tooltip()
                    })
                </script>
                <hr>
                <input type="submit" class="form-button" style="margin-left: 400px;" value="提交"/>
            </form>
        </div>
    </div>

</div>


</body>
</html>
