<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>眼镜在线试戴</title>

<link href="css/eyeglass.css" rel="stylesheet" type="text/css">

</head>

<body>

<div id="box">

    <div id="overlay"><div id="load">数据转入中...<span>0%</span><p></p></div></div>

    <div id="left">

        <div class="modelBox">

            <div class="tab">

                <ul>

                    <li class="current ico-1">我的相片</li>


                    <li class="ico-3"><a href="${bathpath }/MyGlassesShop/showGlasses">返回首页</a></li>

                </ul>

            </div>

            <div class="modelList">

                <div class="faceType">

                    <ul class="normal">

                        <li><a href="javascript:;" data-type="*">全 部</a></li>

                        <li><a href="javascript:;" data-type="0,2">椭圆脸</a></li>

                        <li><a href="javascript:;" data-type="1,3">圆形脸</a></li>

                        <li><a href="javascript:;" data-type="4,6">长形脸</a></li>

                        <li><a href="javascript:;" data-type="5,9">方形脸</a></li>

                        <li><a href="javascript:;" data-type="7,11">瓜子脸</a></li>

                        <li><a href="javascript:;" data-type="8,10">心型脸</a></li>

                    </ul>

                    <div class="active">

                        <ul>

                            <li>全 部</li>

                            <li>椭圆脸</li>

                            <li>圆形脸</li>

                            <li>长形脸</li>

                            <li>方形脸</li>

                            <li>瓜子脸</li>

                            <li>心型脸</li>

                        </ul>

                    </div>

                </div>

                <div class="content">

                    <ul>
						<c:forEach items="${images }" var="image">
                        <li><img src="img/${image.smallImg }" /></li>
                   		</c:forEach>

                    </ul>

                </div>

            </div>

        </div>

        <ul id="tools">

            <li class="open">收缩</li>

            <li class="camera">拍照</li>

            <li class="gauge">瞳距</li>

            <li class="reset">重选</li>

        </ul>

        <div class="mask"></div>

    </div>

    <div id="right">    	

        <div class="search">

            <div class="selectWrap">

                <a class="select" href="javascript:;">品牌</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">佐腾樱花</a></li>

                    <li><a href="javascript:;">毕加索</a></li>

                    <li><a href="javascript:;">沙漠之鹰</a></li>

                    <li><a href="javascript:;">蝙蝠侠</a></li>

                </ul>

            </div>

            <div class="selectWrap">

                <a class="select" href="javascript:;">款式</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">男款</a></li>

                    <li><a href="javascript:;">女款</a></li>

                    <li><a href="javascript:;">通过款</a></li>

                </ul>

            </div>

            <div class="selectWrap">

                <a class="select" href="javascript:;">脸型</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">椭圆脸</a></li>

                    <li><a href="javascript:;">长形脸</a></li>

                    <li><a href="javascript:;">方形脸</a></li>

                    <li><a href="javascript:;">瓜子脸</a></li>

                    <li><a href="javascript:;">心型脸</a></li>

                </ul>

            </div>

            <div class="selectWrap">

                <a class="select" href="javascript:;">型号</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">40-49(小码)</a></li>

                    <li><a href="javascript:;">50-53(中码)</a></li>

                    <li><a href="javascript:;">54-57(大码)</a></li>

                </ul>

            </div>

            <div class="selectWrap">

                <a class="select" href="javascript:;">框形</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">全框</a></li>

                    <li><a href="javascript:;">半框</a></li>

                    <li><a href="javascript:;">无框</a></li>

                    <li><a href="javascript:;">眉框</a></li>

                </ul>

            </div>

            <div class="selectWrap">

                <a class="select" href="javascript:;">材质</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">金属合金</a></li>

                    <li><a href="javascript:;">板材镜架</a></li>

                    <li><a href="javascript:;">铁架系列</a></li>

                    <li><a href="javascript:;">钛架系列</a></li>

                    <li><a href="javascript:;">记忆镜架</a></li>

                </ul>

            </div>

            <div class="selectWrap">

                <a class="select" href="javascript:;">价格</a>

                <ul>

                    <li class="current"><a href="javascript:;">全部</a></li>

                    <li><a href="javascript:;">50以下</a></li>

                    <li><a href="javascript:;">50-100</a></li>

                    <li><a href="javascript:;">100-150</a></li>

                    <li><a href="javascript:;">150-200</a></li>

                    <li><a href="javascript:;">200-300</a></li>

                    <li><a href="javascript:;">300以上</a></li>

                </ul>

            </div>

            <a href="javascript:;" class="btn">点击搜索</a>

        </div>

        <div class="glassList">

            <ul>        

                <li><img src="images/glass_1.jpg"><h5>佐腾樱花_ZTYH-001</h5>豹纹色</li>

                <li><img src="images/glass_2.jpg"><h5>佐腾樱花_ZTYH-010</h5>蓝色</li>

                <li><img src="images/glass_3.jpg"><h5>毕加索_55-2062 C6</h5>绅士黑</li>

                <li><img src="images/glass_4.jpg"><h5>毕加索_55-2001 C6</h5>绅士黑</li>

                <li><img src="images/glass_5.jpg"><h5>毕加索_55-2068 C11</h5>荧光红</li>

                <li><img src="images/glass_6.jpg"><h5>毕加索_55-2051 C11</h5>荧光红</li>

                <li><img src="images/glass_7.jpg"><h5>沙漠之鹰_R5152 C16</h5>绅士黑</li>

                <li><img src="images/glass_8.jpg"><h5>沙漠之鹰_R5152 CCG</h5>绅士银</li>

                <li><img src="images/glass_9.jpg"><h5>沙漠之鹰_R5137 C16</h5>绅士黑</li>  

                <li><img src="images/glass_10.jpg"><h5>蝙蝠侠_BM95002 C9D</h5>绅士黑</li>

                <li><img src="images/glass_11.jpg"><h5>蝙蝠侠_BM97004 B6</h5>绅士银</li>

                <li><img src="images/glass_12.jpg"><h5>蝙蝠侠_BM97004 B1</h5>透明黑</li>        

            </ul>

        </div>

        <div class="mask"></div>

    </div>

</div>

<script type="text/javascript" src="js/eyeglass.js"></script>
<script type="text/javascript">
//图片预加载
;(function() {

	var oLayer = fgm.$("overlay");

		oLoad = fgm.$("load"),

		oSpan = fgm.$$("span", oLoad)[0],

		oP = fgm.$$("p", oLoad)[0],

		aData = [],

		iImgcount = 0,

		iLoaded = 0,

		aImg = [].concat("btn.gif", "ico.gif", "search.png", "loading.gif");	

	for(i = 1; i <= 12; i++) aImg = aImg.concat("model_" + i + ".jpg", "big_" + i + ".jpg", "glass_" + i + ".jpg", "glass_" + i + ".png");

	for(i = 0, iImgCount = aImg.length; i < iImgCount; i++) {

		(function(i) {

			var oImg = new Image();

			oImg.onload = function() {

				oSpan.innerHTML = oP.style.width = Math.ceil(++iLoaded / iImgCount * 100) + "%";

				this.onload = null;					

				var aTmp = document.createElement("img");

				aTmp.src = this.src;

				aData[i] = aTmp;

				if(aData[i] && aData.length == iImgCount) {

					fgm.animate(oLayer, {opacity:0}, {

						callback: function() {

							fgm.css(this, {display:"none"})	

						}

					});

					complete()	

				}

			}

			oImg.src = "images/" + aImg[i];

		})(i);		

	}

})();

</script>

<!--[if IE 6]><script src="js/pngfix.js"></script><script>DD_belatedPNG.fix(".glass img");</script><![endif]-->
<div style="text-align:center;">
</div>
</body>
</html>

