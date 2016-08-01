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
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script type="text/javascript">
	$(function(){
		$("#name").blur(function(){
			var n=$("#name").val();
			$.post("checkName",{name:n},function(data){
				if(data=="true"){
					$("#info").html("用户名可以注册");
				}else{
					$("#info").html("此用户已经注册");
				}
			});
		});
	})
</script>
<script type="text/javascript">
	$(function(){
		for(var n=10;n<100;n++){$("#age").append('<option>'+n+'</option>');}
		
	})
</script>
<script src="js/jquery.easydropdown.js"></script>
</head>
<body> 
	<div class="header-top">
			<div class="wrap"> 
			  <div class="header-top-left">
   				    <div class="clear"></div>
   			 </div>
			 <div class="cssmenu">
				<ul>
					<li><a href="login.jsp">登 录</a></li> |
					<li><a href="/MyGlassesShop/regUser">注 册</a></li>
				</ul>
			</div>
			<div class="clear"></div>
 		</div>
	</div>
	 <div class="header-bottom">
	    <div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
					<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
				</div>
				<div class="menu">
	            <ul class="megamenu skyblue">
			<li class="active grid"><a href="/MyGlassesShop/showGlasses">主页</a></li>
			<li><a class="color4" href="#">女款</a>
				</li>				
				<li><a class="color5" href="#">男款</a>
				</li>
				<li><a class="color6" href="index.jsp">适配</a></li>
				<li><a class="color7" href="index.jsp">拍照</a></li>
			</ul>
			</div>
		</div>
	   <div class="header-bottom-right">
         <div class="search">	  
				<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		 </div>
	  <div class="tag-list">
	    <ul class="icon1 sub-icon1 profile_img">
			<li><a class="active-icon c1" href="#"> </a>
				<ul class="sub-icon1 list">
					<li><h3>消费记录</h3><a href=""></a></li>

				</ul>
			</li>
		</ul>
		<ul class="icon1 sub-icon1 profile_img">
			<li><a class="active-icon c2" href="/MyGlassesShop/showCart"> </a>
				<ul class="sub-icon1 list">
					<li><h3>没有商品</h3><a href=""></a></li>

				</ul>
			</li>
		</ul>
	    <ul class="last"><li><a href="#">购物车</a></li></ul>
	  </div>
    </div>
     <div class="clear"></div>
     </div>
	</div>
          <div class="register_account">
          	<div class="wrap">
    	      <h4 class="title">创建用户</h4>
    		   <form action="${basePath}/MyGlassesShop/register" method="post">
    			 <div class="col_1_of_2 span_1_of_2">
		   			 <div><input id="name" name="name" type="text" value="姓名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '姓名';}"></div><div id="info" style="display:inline;"></div>
		    			<div><input name="pwd" type="text" value="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码';}"></div>
		    			<div><input name="phone" type="text" value="电话号码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '电话号码';}"></div>
		    			<div><select id="age" name="age">
		    			</select></div>
		    	 </div>
		    	  <div class="col_1_of_2 span_1_of_2">	
		    		<div><select name="sex">
		    			<option>男</option>
		    			<option>女</option>
		    		</select></div>
		          </div>
		          <div class="col_1_of_2 span_1_of_2">	
		    		<div><select name="face.id">
		    			<c:forEach items="${faces}" var="face">
        				<option value="${face.id}">${face.face}</option>
   						 </c:forEach>
		    		</select></div>
		          </div>
		      <button class="grey" style="margin-left: 20px;" >注册</button>
		    <div class="clear"></div>
		    </form>
    	</div>
    </div>
    <div class="footer">
		<div class="footer-top">
			<div class="wrap">
			  <div class="section group example">
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
					  <li><img src="images/2.png"><span class="f-text">免费配送 100￥</span><div class="clear"></div></li>
					</ul>
				</div>
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
					  <li><img src="images/3.png"><span class="f-text">电话号码： 88888888</span><div class="clear"></div></li>
					</ul>
				</div>
				<div class="clear"></div>
		      </div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="wrap">
	            <div class="copy">
			           <p>Copyright &copy; 2016.Company name All rights reserved.6</p>
		       </div>
				<div class="clear"></div>
		      </div>
			</div>
		</div>
<div style="display:none"></div>
</body>
</html>