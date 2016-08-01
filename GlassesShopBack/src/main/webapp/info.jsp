<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <h2><strong style="color:grey;">眼镜商品信息展示</strong></h2>
      <div class="page_title">
       <h2 class="fl">用户信息</h2>
       <a href="${bathPath }/GlassesShopBack/glassesInfo" class="fr top_rt_btn" >查询按钮</a>
      </div>
      <table class="table">
       <tr>
        <th>品牌id</th>
        <th>品牌名字</th>
        <th>操作</th>
       </tr>
       <c:forEach items="${brands }" var="brand">
       <tr>
        <td style="width:50px;">${brand.id }</td>
        <td>${brand.brand }</td>
        <td>
         <a href="${bathPath }/GlassesShopBack/deleteBrand?nowId=${brand.id}" class="inner_btn">删除</a>
        </td>
       </tr>
       </c:forEach>
       <tr>
        <th>颜色id</th>
        <th>颜色名字</th>
        <th>操作</th>
       </tr>
       <c:forEach items="${colors }" var="color">
       <tr>
        <td style="width:50px;">${color.id }</td>
        <td>${color.color }</td>
        <td>
         <a href="${bathPath }/GlassesShopBack/deleteColor?nowId=${color.id}" class="inner_btn">删除</a>
        </td>
       </tr>
       </c:forEach>
       <tr>
        <th>材质id</th>
        <th>材质名字</th>
        <th>操作</th>
       </tr>
       <c:forEach items="${materials }" var="material">
       <tr>
        <td style="width:50px;">${material.id }</td>
        <td>${material.material }</td>
        <td>
         <a href="${bathPath }/GlassesShopBack/deleteMaterial?nowId=${material.id}" class="inner_btn">删除</a>
        </td>
       </tr>
       </c:forEach>
       
        <tr>
        <th>类型id</th>
        <th>类型名字</th>
        <th>操作</th>
       </tr>
       <c:forEach items="${types }" var="type">
       <tr>
        <td style="width:50px;">${type.id }</td>
        <td>${type.type }</td>
        <td>
         <a href="${bathPath }/GlassesShopBack/deleteType?nowId=${type.id}" class="inner_btn">删除</a>
        </td>
       </tr>
       </c:forEach>
      </table>
      
      
      <form action="${basePath}/GlassesShopBack/addBrand" method="post" >
			<ul class="ulColumn2">
				<li><span class="item_name" style="width: 120px;">品牌名称：</span>
					<input name="brand" type="text" class="textbox textbox_295 "  style="width:70px" />
				<li><span class="item_name" style="width: 120px;"></span> <input
					type="submit" class="link_btn" /></li>
			</ul>
	  </form>
	  
	  <form action="${basePath}/GlassesShopBack/addColor" method="post" >
			<ul class="ulColumn2">
				<li><span class="item_name" style="width: 120px;">颜色名称：</span>
					<input name="color" type="text" class="textbox textbox_295 "  style="width:70px" />
				<li><span class="item_name" style="width: 120px;"></span> <input
					type="submit" class="link_btn" /></li>
			</ul>
	  </form>
	  
	  <form action="${basePath}/GlassesShopBack/addType" method="post" >
			<ul class="ulColumn2">
				<li><span class="item_name" style="width: 120px;">类型名称：</span>
					<input name="type" type="text" class="textbox textbox_295 "  style="width:70px" />
				<li><span class="item_name" style="width: 120px;"></span> <input
					type="submit" class="link_btn" /></li>
			</ul>
	  </form>
	  
	  <form action="${basePath}/GlassesShopBack/addMaterial" method="post" >
			<ul class="ulColumn2">
				<li><span class="item_name" style="width: 120px;">材质名称：</span>
					<input name="material" type="text" class="textbox textbox_295 "  style="width:70px" />
				<li><span class="item_name" style="width: 120px;"></span> <input
					type="submit" class="link_btn" /></li>
			</ul>
	  </form>
	  
     </section>	
	</div>
	</section>
</body>
</html>
