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
      <h2><strong style="color:grey;">全部眼镜信息展示</strong></h2>
      <div class="page_title">
       <h2 class="fl">眼镜信息</h2>
       <a href="${bathPath }/GlassesShopBack/page" class="fr top_rt_btn" >查询按钮</a>
      </div>
      <table class="table">
       <tr>
        <th>眼镜id</th>
        <th>眼镜名字</th>
        <th>眼镜大小</th>
        <th>眼镜品牌</th>
        <th>眼镜价格</th>
        <th>眼镜颜色</th>
        <th>眼镜类型</th>
        <th>眼镜款式</th>
        <th>眼镜材料</th>
        <th>眼镜图片</th>	
        <th>操作</th>
       </tr>
       <c:forEach items="${map.glasses }" var="glasse">
       <tr>
        <td style="width:50px;">${glasse.id }</td>
        <td>${glasse.name }</td>
        <td>${glasse.size }</td>
        <td>${glasse.brand.brand }</td>
        <td>${glasse.price }</td>
        <td>${glasse.color.color }</td>
        <td>${glasse.type.type }</td>
        <td>${glasse.sex }</td>
        <td>${glasse.material.material }</td>
        <td>${glasse.image }</td>
        <td>
         <a href="${bathPath }/GlassesShopBack/delete?nowId=${glasse.id}" class="inner_btn">删除</a>
         <a href="${bathPath }/GlassesShopBack/update?nowId=${glasse.id}" class="inner_btn">修改</a>
        </td>
       </tr>
       </c:forEach>
      </table>
      <aside class="paging">
      <c:forEach begin="1" end="${map.totalPage }" var="nowPage">
      <a href="${bathPath }/GlassesShopBack/page?nowPage=${nowPage}">${nowPage }</a>
      </c:forEach>
      </aside>
     </section>	
	</div>
	</section>
</body>
</html>
