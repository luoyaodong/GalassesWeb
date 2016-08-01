<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Single:: w3layouts</title>
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
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
<script type="text/javascript" id="sourcecode">
	$(function() {
		$('.scroll-pane').jScrollPane();
	});
</script>
<!-- start details -->
<script src="js/slides.min.jquery.js"></script>
<script>
	$(function() {
		$('#products').slides({
			preload : true,
			preloadImage : 'img/loading.gif',
			effect : 'slide, fade',
			crossfade : true,
			slideSpeed : 350,
			fadeSpeed : 500,
			generateNextPrev : true,
			generatePagination : false
		});
	});
</script>
<!-- start zoom -->
<link rel="stylesheet" href="css/zoome-min.css" />
<script type="text/javascript" src="js/zoome-e.js"></script>
<script type="text/javascript">
	$(function() {
		$('#img1,#img2,#img3,#img4').zoome({
			showZoomState : true,
			magnifierSize : [ 250, 250 ]
		});
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
					<a href="/MyGlassesShop/showGlasses"><img src="images/logo.png"
						alt="" /></a>
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
						<li><a class="active-icon c2" href="/MyGlassesShop/showCart">
						</a>
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
				<ul class="breadcrumb breadcrumb__t">眼 镜 信 息
				</ul>
				<div class="cont span_2_of_3">
					<div class="grid images_3_of_2">
						<div id="container">
							<div id="products_example">
								<div id="products">
									<div class="slides_container">

										<a href="#">
											<div class="inner_content clearfix">
												<div class="product_image">
													<img src="img/${glasse.image }" />
												</div>
												<div class="sale-box1">
													<span class="on_sale title_shop">sale</span>
												</div>
												<div class="price">
													<div class="cart-left">
														<p class="title">${glasse.name }</p>
														<div class="price1">
															<span class="reducedfrom"></span> <span class="actual">
																${glasse.price }</span>
														</div>
													</div>
													<div class="cart-right"></div>
													<div class="clear"></div>
												</div>
											</div>
										</a>

									</div>

								</div>
							</div>
						</div>
					</div>
					<div class="desc1 span_3_of_2">
						<h3 class="m_3">商品售价：${glasse.price }</h3>

						<ul class="icon1 sub-icon1 profile_img" style="float: right;">
							<li><h3 class="m_3">加入购物车</h3>
								<a class="active-icon c2"
								href="/MyGlassesShop/addCart?glasseId=${glasse.id }"> </a>
								<ul class="sub-icon1 list">
									<li><h3>No Products</h3> <a href=""></a></li>
								</ul></li>
						</ul>
						<div class="btn_form">
							<form>
								<input type="submit" value="立即购买" title="">
							</form>
						</div>
						<h3 class="m_3">添加评论</h3>
						<div class="btn_form">
							<form action="/MyGlassesShop/saveComment" method="post">
								<textarea rows="4" cols="50" name="comments"></textarea>
								<input type="text" style="display: none;" name="glassesId"
									value="${glasse.id }"> </br> </br> <input type="submit"
									value="提交评论" title="">
							</form>
						</div>
					</div>
					<div class="clear"></div>

					<div class="toogle">
						<h3 class="m_3">用户评论</h3>
						<c:forEach items="${comments }" var="comment">
							<ul class="breadcrumb breadcrumb__t">用户${comment.userId }评论:${comment.comments }
							</ul>
						</c:forEach>
					</div>
				</div>


				<div class="rsidebar span_1_of_left">
					<h5 class="m_1">类型:${type.type }</h5>
					
					<section class="sky-form">
					<h5 class="m_1">价格:${glasse.price }</h5>
					</section>
					
					<section class="sky-form"> 
					<h5 class="m_1">${glasse.sex }</h5>
					</section>
					
					<section class="sky-form">
					<h5 class="m_1">品牌:${brand.brand }</h5>
					</section>
					
					<section class="sky-form">
					<h5 class="m_1">材质:${material.material }</h5>
					</section>
					
					<section class="sky-form"> 
					<h5 class="m_1">颜色:${color.color }</h5>
					</section>
				</div>
				<script src="js/jquery.easydropdown.js"></script>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
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
					<p>
						Copyright &copy; 2014.Company name All rights reserved.<a
							target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
					</p>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div style="display: none"></div>
</body>
</html>