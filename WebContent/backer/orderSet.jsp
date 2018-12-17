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
    <title>订单详情编辑</title>
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
            $('#nav-ul').children('li:nth-child(2)').addClass('visting');
        </script>

        <style>
            .table-input {
                width: 550px;
                border: none;
                background-color: transparent;
            }
        </style>
        <div class="cont-right">
            <h3>
                 <a href="setOrder.action">所有订单</a>-->
                                                         订单编辑--> <a href="setGood.action?blOrderId=${Order.id}">商品编辑</a>
            </h3>
            <hr/>
            <form action="submitEditOrder.action" method="post">
                <table class="table table-striped ">
                    <tr>
                        <td>id：</td>
                        <td><input name="id" id="id" type="text" value="${Order.id }" class="table-input"
                                   readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>订单编号：</td>
                       <td>${Order.orderIdentifier}</td>
                    </tr>
                    <tr>
                        <td>下单时间：</td>
                      <td>${Order.releaseTime}</td>
                    </tr>
                    <tr>
                        <td>接单时间：</td>
                       <td>${Order.orderTime}</td>
                    </tr>
                    <tr>
                        <td>完成时间：</td>
                     <td>${Order.finishTime}</td>
                    </tr>
                    <tr>
                        <td>订单状态：</td>
                        <td><select name="orderStatus" >
                              <option value="0" <c:if test="${Order.orderStatus == 0}"> selected </c:if>>待接单</option>
                              <option value="1" <c:if test="${Order.orderStatus == 1}"> selected </c:if>>进行中</option>
                              <option value="2" <c:if test="${Order.orderStatus == 2}"> selected </c:if>>已完成<option>
                              <option value="3" <c:if test="${Order.orderStatus == 3}"> selected </c:if>>已取消<option>
                        </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>价格：</td>
                        <td>${Order.orderMoney}</td>
                    </tr>
                    <tr>
                        <td>卖家昵称：</td>
                        <td>${Order.userName}</td>
                    </tr>
                    <tr>
                        <td>卖家联系方式：</td>
                        <td><input name="userTel" type = "text" value="${Order.userTel }" class="table-input"/></td>
                    </tr>
                     <tr>
                        <td>买家昵称：</td>
                        <td>${Order.orderUserName}</td>
                    </tr>
                     <tr>
                        <td>买家联系方式：</td>
                        <td><input name="orderUserTel" type = "text" value="${Order.orderUserTel }" class="table-input"/></td>
                    </tr>
                    <tr>
                        <td>取货地址：</td>
                        <td><input name="address" type="text" value="${Order.address}" class="table-input"/></td>
                    </tr>
                     <tr>
                        <td>经度：</td>
                        <td><input name="longitude" type="number" value="${Order.longitude}" class="table-input"/>(用于废品回收员导航)</td>
                        
                    </tr>
                    <tr>
                        <td>经度：</td>
                        <td><input name="latitude" type="number" value="${Order.latitude}" class="table-input"/></td>
                    </tr>
                    <%-- <tr>
                        <td>交易方式：</td>
                        <td><select name="orderManner" >
                            <option value="0" <c:if test="${Order.orderManner == 0}"> selected </c:if>>用户积分</option>
                            <option value="1" <c:if test="${Order.orderManner == 1}"> selected </c:if>>账户余额</option>
                        </select></td>
                    </tr> --%>
                     
                  
                                     
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
