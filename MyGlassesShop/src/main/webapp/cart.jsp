<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>主页</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
</head>
<body>
	<div class="header-top">
		<div class="wrap">
			<div class="header-top-left">
				<div class="clear"></div>
			</div>
			<div class="cssmenu">
				<ul>
					<c:if test="${username!=null}">
						<li><a>欢迎你:${username }</a></li>
						<li><a href="/MyGlassesShop/quit">退出</a></li>
						<li><a href="/MyGlassesShop/regUser">注 册</a></li>
					</c:if>
					<c:if test="${username==null }">
						<li><a href="login.jsp">登 录</a></li>
						<li><a href="/MyGlassesShop/regUser">注 册</a></li>
					</c:if>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
					<a href="index.jsp"><img src="images/logo.png" alt="" /></a>
				</div>
				<div class="menu">
					<ul class="megamenu skyblue">
						<li class="active grid"><a href="/MyGlassesShop/showGlasses">主页</a></li>
						<li><a class="color4" href="/MyGlassesShop/womenSelect">女款</a></li>
						<li><a class="color5" href="/MyGlassesShop/manSelect">男款</a></li>
						<li><a class="color6" href="/MyGlassesShop/imgShow">适配</a></li>
						<li><a class="color7" href="/MyGlassesShop/checkCameraLogin">拍照</a></li>
						<li><a class="color6" href="/MyGlassesShop/checkImage">检测头像</a></li>
					</ul>
				</div>
			</div>
			<div class="header-bottom-right">
				<div class="search">
					<input type="text" name="s" class="textbox" value="Search"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search';}"> <input
						type="submit" value="Subscribe" id="submit" name="submit">
					<div id="response"></div>
				</div>
				<div class="tag-list">
					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c1" href="#"> </a>
							<ul class="sub-icon1 list">
								<li><h3>sed diam nonummy</h3> <a href=""></a></li>
							</ul></li>
					</ul>
					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c2" href="/MyGlassesShop/showCart"> </a>
							<ul class="sub-icon1 list">
								<li><h3>No Products</h3> <a href=""></a></li>
							</ul></li>
					</ul>
					<ul class="last">
						<li><a href="/MyGlassesShop/showCart">购物车</a></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="mens">
		<div class="main">
			<div class="wrap">
				<div class="cont span_2_of_3">
					<h2 class="head">眼镜主页</h2>
					<div class="mens-toolbar">
						<div class="sort">
							<div class="sort-by">
								<label>Sort By</label> <select>
									<option value="">Position</option>
									<option value="">Name</option>
									<option value="">Price</option>
								</select> <a href=""><img src="images/arrow2.gif" alt=""
									class="v-middle"></a>
							</div>
						</div>
						<div class="pager">
							<div class="limiter visible-desktop">
								<label>一页展示</label>
							</div>
							<ul class="dc_pagination dc_paginationA dc_paginationA06">
							</ul>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
					
					<div class="top-box">
						<c:forEach items="${glasses }" var="glasse">
							<div class="col_1_of_3 span_1_of_3">

								<a href="/MyGlassesShop/single?glasseId=${glasse.id}">
									<div class="inner_content clearfix">
										<div class="product_image">
											<img src="img/${glasse.image }" />
										</div>
										<div class="sale-box1">
											<span class="on_sale title_shop">sale</span>
										</div>
										<div class="price">
											<div class="cart-left">
												<p class="title">商品名称:${glasse.name }</p>
												<div class="price1">
												<span class="actual">商品价格:${glasse.price }</span>
												</div>
											</div>
											<a href="/MyGlassesShop/deleteCartInfo?glasseId=${glasse.id}">
											<span class="actual">删除</span>
											</a>
											<div class="clear"></div>
										</div>
									</div>
								</a>

							</div>
						</c:forEach>

						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="rsidebar span_1_of_left">
				<h5 class="m_1">分类</h5>
					<div class="col col-4">
					<c:forEach items="${types }" var="type">
					<ul><a href="/MyGlassesShop/typeSelect?type=${type.id}"><h2 class="m_2">${type.type}</h2></a></ul>	
					</c:forEach>
				</div>
				<section class="sky-form">
				<h4>价格</h4>
					<div class="col col-4">
					<ul><a href="/MyGlassesShop/priceSelect?bottom=100&&top=200"><h2 class="m_2">100-200</h2></a></ul>
					<ul><a href="/MyGlassesShop/priceSelect?bottom=200&&top=300"><h2 class="m_2">200-300</h2></a></ul>
					<ul><a href="/MyGlassesShop/priceSelect?bottom=300&&top=400"><h2 class="m_2">300-400</h2></a></ul>
					<ul><a href="/MyGlassesShop/priceSelect?bottom=500&&top=600"><h2 class="m_2">500-600</h2></a></ul>
					</div>
				</section>
				<section class="sky-form">
				<h4>品牌</h4>
				<div class="col col-4">
					<c:forEach items="${brands }" var="brand">
					<ul><a href="/MyGlassesShop/typeSelect?type=${brand.id}"><h2 class="m_2">${brand.brand}</h2></a></ul>	
					</c:forEach>
				</div>
				</section>
				<section class="sky-form">
				<h4>材质</h4>
				<div class="col col-4">
					<c:forEach items="${materials }" var="material">
					<ul><a href="/MyGlassesShop/typeSelect?type=${material.id}"><h2 class="m_2">${material.material}</h2></a></ul>	
					</c:forEach>
				</div>
				</section>
				<section class="sky-form">
				<h4>材质</h4>
				<div class="col col-4">
					<c:forEach items="${colors }" var="color">
					<ul><a href="/MyGlassesShop/typeSelect?type=${color.id}"><h2 class="m_2">${color.color}</h2></a></ul>	
					</c:forEach>
				</div>
				</section>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	</div>
	<script src="js/jquery.easydropdown.js"></script>
	<div class="footer">
		<div class="footer-top">
			<div class="wrap">
				<div class="section group example">
					<div class="col_1_of_2 span_1_of_2">
						<ul class="f-list">
							<li><img src="images/2.png"><span class="f-text">Free
									Shipping on orders over $ 100</span>
								<div class="clear"></div></li>
						</ul>
					</div>
					<div class="col_1_of_2 span_1_of_2">
						<ul class="f-list">
							<li><img src="images/3.png"><span class="f-text">Call
									us! toll free-222-555-6666 </span>
								<div class="clear"></div></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="wrap">
				<div class="copy">
					<p>Copyright &copy; 2016.Company name All rights reserved.</p>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div style="display: none"></div>
</body>
</html>