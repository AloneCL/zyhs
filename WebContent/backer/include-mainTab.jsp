<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<div class="cont-left">
    <ul id="nav-ul">
        <li>数据字典</li>
        <li>订单管理</li>
        <li>轮播图片</li>
        <li id="nav-il-1-par">用户管理 ⊽ 
        	<ul id="nav-il-1" class="display">
        		<li>普通用户</li>
        		<li>废品回收员</li>
        		<li>管理员</li>
        	</ul>
        </li>
        <li id="nav-il-2-par">物品管理 ⊽ 
        	<ul id="nav-il-2" class="display">
        		<li>杂物</li>
        		<li>缺失零件</li>
        		<li>冰箱</li>
        		<li>电视机/电脑</li>
        		<li>小电器</li>
        		<li>洗衣机</li>
        		<li>空调</li>
        		<li>废旧车辆</li>
        	</ul>
        </li>
    </ul>
</div>
<style>
	.cont-left {height: 100%;width: 150px;border-right: solid 1px #C7DDEF;float: left;list-style-type:nono;}
        .cont-left ul {list-style-type: none;padding: 0;}
        .cont-left ul li {
            text-align: center;
            height: 80px;
            font-size: 16px;
            line-height: 80px;
            border-bottom: solid 1px #C7DDEF;
        }
        .cont-left ul li:hover {color: #66AFE9;cursor: pointer;background-color: #ffffff;}
               
        .cont-left ul li ul li{
        	text-align: center;
            height: 80px;
            font-size: 16px;
            line-height: 80px;
            border-bottom: solid 1px #C7DDEF;
        }
        .cont-left ul li ul li:hover{color: #66AFE9;cursor: pointer;}
        .visiting{background-color: #66AFE9;color: #ffffff;}
        .onplay{display: block;}
        .display{display: none;}
</style>
<script type="text/javascript">
	$("#nav-il-1-par").click(function(){
		if($("#nav-il-1").hasClass("display")){
			$("#nav-il-1").removeClass("display");
			$("#nav-il-1").addClass("onplay");
			$("#nav-il-2-par").css({'position':'absolute','top':'640px','text-align':'center','width':'149.2px'});
		}
		else if($("#nav-il-1").hasClass("onplay")){
			$("#nav-il-1").removeClass("onplay");
			$("#nav-il-1").addClass("display");
			$("#nav-il-2-par").css({'position':'absolute','top':'400px','text-align':'center','width':'149.2px'});
		}
	});
	$("#nav-il-2-par").click(function(){
		if($("#nav-il-2").hasClass("display")){
			$("#nav-il-2").removeClass("display");
			$("#nav-il-2").addClass("onplay");
		}
		else if($("#nav-il-2").hasClass("onplay")){
			$("#nav-il-2").removeClass("onplay");
			$("#nav-il-2").addClass("display");
		}
	});
    $("#nav-ul").find("li").click(function () {
        if ($(this).index() === 0)
            $(window).attr('location', 'setGoodsLevel.action');
        else if ($(this).index() === 1)
        	$(window).attr('location', 'setOrder.action');
        else if ($(this).index() === 2)
        	$(window).attr('location', 'setHotImage.action');
    });
    $("#nav-il-1").find("li").click(function(){
    	if($(this).index()===0){
			$(window).attr('location','setUser.action?identity=0');
    	}
    	else if($(this).index()===1){
			$(window).attr('location','setUser.action?identity=1');
    	}
    	else if($(this).index()===2){
    		$(window).attr('location','managerSet.action');
    	}
    });
    $("#nav-il-2").find("li").click(function(){
		if($(this).index()===0)
			$(window).attr('location', 'setCommonGoods.action');
		else if($(this).index()===1)
			$(window).attr('location', 'setMissTools.action');
		else if($(this).index()===2)
			$(window).attr('location', 'setRefrigerator.action');
		else if($(this).index()===3)
			$(window).attr('location', 'setTelevision.action');
		else if($(this).index()===4)
			$(window).attr('location', 'setSmallAppliances.action');
		else if($(this).index()===5)
			$(window).attr('location', 'setWashing.action');
		else if($(this).index()===6)
			$(window).attr('location', 'setAirCondition.action');
		else if($(this).index()===7)
			$(window).attr('location', 'setCars.action');
	});
    
</script>
