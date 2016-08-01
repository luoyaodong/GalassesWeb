<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>

<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
<script src="js/jquery.js"></script>
<script src="js/cascade.js"></script>
<script src="js/ccv.js"></script>
<script src="js/jquery.facedetection.js"></script>
    <script>
        $(function(){
            $('#picture').faceDetection({
                complete: function (faces) {
                    console.log(faces);
                    for (var i = 0; i < faces.length; i++) {
                        $('<div>', {
                            'class':'face',
                            'css': {
                                'position': 'absolute',
                                'left':     (faces[i].x * faces[i].scaleX+90) + 'px',
                                'top':      (faces[i].y * faces[i].scaleY+200) + 'px',
                                'width':    faces[i].width  * faces[i].scaleX + 'px',
                                'height':   faces[i].height * faces[i].scaleY + 'px'
                            }
                        })
                                .insertAfter(this);
                        if(faces[i].width<=200||faces[i].width>=300){
                        	alert("检测不合格，请重拍");
                        }else{
                        	alert("检测合格");
                        }
                        $('#info').html("脸部宽度:"+faces[i].width);
                        $('#info1').html("脸部高度:"+faces[i].height);
                    }
                },
                error: function(code, message) {
                    alert('Error: ' + message);
                    console.warn("无法分析图片");
                }
            });
        });

    </script>
    <style>
        .face {
            position: absolute;
            border: 2px solid #FFF;
        }
    </style>
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
								<li><h3>消费记录</h3>
									<a href=""></a></li>

							</ul></li>
					</ul>
					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c2" href="/MyGlassesShop/showCart"> </a>
							<ul class="sub-icon1 list">
								<li><h3>没有物品</h3>
									<a href=""></a></li>

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
	<div class="login">
          	<div class="wrap">
				<div class="col_1_of_login span_1_of_login">
					<img id="picture" src="img/${imageName }">
					<div class="clear"></div>
				</div>
				<div class="col_1_of_login span_1_of_login">
					<p>头像信息展示：</p>
					<p id="info"></p>
					<p id="info1"></p>
			    </div>
			</div>
				<div class="clear"></div>
			</div>
	<div class="footer">
		<div class="footer-top">
			<div class="wrap">
				<div class="section group example">
					<div class="col_1_of_2 span_1_of_2">
						<ul class="f-list">
							<li><img src="images/2.png"><span class="f-text">免费配送
									100￥</span>
							<div class="clear"></div></li>
						</ul>
					</div>
					<div class="col_1_of_2 span_1_of_2">
						<ul class="f-list">
							<li><img src="images/3.png"><span class="f-text">电话号码：
									88888888 </span>
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