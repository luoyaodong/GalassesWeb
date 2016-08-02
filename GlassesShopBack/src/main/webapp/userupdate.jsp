<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($) {
		$(window).load(
				function() {

					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									//scroll-to appended content 
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});

					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>
</head>
<body>
	<!--header-->
	<header>
	<h1>
		<img src="images/admin_logo.png" />
	</h1>
	<ul class="rt_nav">
		<li><a href="#" target="_blank" class="website_icon">站点首页</a></li>
		<li><a href="#" class="admin_icon">DeathGhost</a></li>
		<li><a href="#" class="set_icon">账号设置</a></li>
		<li><a href="login.jsp" class="quit_icon">安全退出</a></li>
	</ul>
	</header>

	<!--aside nav-->
	<aside class="lt_aside_nav content mCustomScrollbar">
	<ul>
		<li>
			<dl>
				<dt>商品信息</dt>
				<!--当前链接则添加class:active-->
				<dd>
					<a href="${bathPath }/GlassesShopBack/reg" class="active">添加眼镜</a>
				</dd>
				<dd>
					<a href="${bathPath }/GlassesShopBack/page" class="active">展示眼镜</a>
				</dd>
				<dd>
					<a href="${bathPath }/GlassesShopBack/userPage" class="active">用户列表</a>
				</dd>
				<dd>
					<a href="${bathPath }/GlassesShopBack/glassesInfo" class="active">属性管理</a>
				</dd>
			</dl>
		</li>
	
		</ul>
	</aside>

	<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		
			<section>
			<h2>
				<strong style="color: grey;">分列内容布局</strong>
			</h2>
			<form action="${basePath}/GlassesShopBack/updateOneUser" method="post" >
			<ul class="ulColumn2">
			
				<li><span class="item_name" style="width: 120px;">用户姓名：</span>
					<input name="name" type="text" class="textbox textbox_295 " placeholder="${user.name }" style="width:70px" value="${user.name }"/>
					<span class="item_name" style="width: 120px;">年龄：</span>
					<input name="age" type="text" class="textbox textbox_295 " placeholder="${user.age }" style="width:70px" value="${user.age }"/>
				<span class="item_name" style="width: 120px;">用户id：</span>
					<input id="id" name="id" type="text" class="textbox textbox_295 "  style="width:40px" value="${user.id }" readonly/>
					<input name="cart.id" type="text" class="textbox textbox_295 "  style="width:40px" value="${user.cart.id }" readonly/>
					</li>
				<li>
				<span class="item_name" style="width: 120px;">电话号码：</span>
					<input name="phone" type="text" class="textbox textbox_295 " placeholder="${user.phone }" style="width:200px"/>
				<span class="item_name" style="width: 120px;">密码：</span>
					<input name="pwd" type="password" class="textbox textbox_295 " placeholder="${user.pwd }" style="width:70px"/>
				<span class="item_name" style="width: 120px;">脸型：</span>
					<select name="face.id" class="select" style="width:80px">
		    			<c:forEach items="${faces}" var="face">
        				<option value="${face.id}">${face.face}</option>
   						 </c:forEach>
		    		</select>
		    		
		    	<span class="item_name" style="width: 120px;">性别：</span>
					<select name="sex" class="select" style="width:80px">
						<option>男</option>
						<option>女</option>
				</select> 
				</li>
				<li><span class="item_name" style="width: 120px;"></span> <input
					type="submit" class="link_btn" /></li>
					
			</ul>
			</form>
				
			</section>
			<!--tabStyle-->
	
	</div>
	</section>
</body>
</html>
