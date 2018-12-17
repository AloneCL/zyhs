<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" href="../static/css/bootstrap-theme.min.css">
    <title>登录</title>
</head>
<style>
    * {
        font-family: "微软雅黑",sans-serif;
    }

    body {
        background: url(static/icon/back.jpg);
        background-size: cover;
        background-color: #C0C0C0;
    }

    #login {
    	position:absolute;
    	width: 500px;
        height: 270px;
        top:50%;
        left:50%;
        margin-top:-135px;
        margin-left:-250px;
        border-radius: 25px 25px 0 0;
        background-color: white;
        text-align: center;
    }
    
    #submit {
        color: white;
        font-size: 23px;
        border-radius: 0px 0px 25px 25px;
        border: 1px solid #66AFE9;
        background-color: #66AFE9;
        width: 500px;
        height: 60px;
        text-align: center;
 
    }
    
    #submit:hover{
    	background-color: #0084ff;
    	cursor:pointer;
    }

    .form-input {
        width: 300px;
        height: 40px;
        border: none;
        border-bottom: #D5D5D5 1px solid;
    }
</style>
<body>

<div class="cont" ng-app="loginApp" ng-controller="loginCtrl">
    <form class="form-inline" id="login" action="submitLogin.action" method="post">
        <div id="input">
            <br/>
            <h3>资源回收管理系统</h3>
            <hr/>
            <img src="static/icon/user.png" height="40px"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="name" type="text" class="form-input" placeholder="用户名" required><br/><br/>
            <img src="static/icon/password.png" height="40px"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="password" type="password" class="form-input" placeholder="密码" required><br/><br/>
        </div>
        <button type="submit" id="submit">登录</button>
    </form>

    <br/><br/>

</div>
</body>

<c:if test="${not empty error }">
    <script type="text/javascript">
        alert('${error}')
    </script>
</c:if>
<script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>