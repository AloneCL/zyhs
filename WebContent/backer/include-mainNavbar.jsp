<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    * {
        font-family: "微软雅黑";
        margin: 0px;
        padding: 0px;
    }

    .userSet {
        display: none;
        background-color: white;
        border: solid 1px #CCCCCC;
        position: absolute;
        list-style-type: none;
        padding: 0px;
        width: 100px;
        margin-top: 15px;
    }

    .userSet li {
        text-align: center;
        padding: 2px;
    }

    .userSet li:hover {
        background-color: #D4D4D4;
        cursor: pointer;
    }
    #bs-example-navbar-collapse-1 > ul.nav.navbar-nav.navbar-right > li > a > font:hover{
        color: #66AFE9 !important;
    }
</style>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="#"><img src="static/icon/testlogo.png" height="20px"/></a>
            <a class="navbar-brand" href="#"><font style="color:#66AFE9;">资源回收管理系统</font></a>
            <div class="navbar-brand">|</div>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">你好，管理员</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="logout.action" class="userCenter">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        &nbsp;
                        <font color="#9D9D9D">注销登录</font>
                    </a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<c:if test="${empty sessionScope.manager}">
    <script>
        $(window).attr('location', 'login.action');
    </script>
</c:if>

<script>
    $(".userCenter").mousemove(function (e) {
        $(".userSet").fadeIn()
    });
    $(".userCenter").mouseleave(function (e) {
        $(".userSet").fadeOut()
    });
</script>

