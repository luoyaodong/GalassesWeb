<%--
  Created by IntelliJ IDEA.
  User: dengry
  Date: 2016/4/11
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link href="static/css/style.css" type="text/css" rel="stylesheet">
    <style type="text/css">
         .pager{
             text-align: center;
         }

    </style>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo">
        <img src="static/image/logo.gif" />
    </div>
    <div style="float: right;margin-top: 40px;">
        <a href="tologin">登录</a>&nbsp;&nbsp;&nbsp;<a
            href="toReg">注册</a>
    </div>

</div>

<div class="wrap">
    <table class="house-list">
        <c:forEach items="${map.houses}" var="house">
            <tr>
                <td class="house-thumb"><img src="static/image/${house.pic}"></td>
                <td>
                    <dl>
                        <dt>${house.title }</dt>
                        <dd>
                                ${house.street.district.name } 区 ${house.street.name
                                },${house.floorage }平米<br/> 联系方式： ${house.contact }
                        </dd>
                    </dl>
                </td>
                <td class="house-type">${house.houseType.name}</td>
                <td class="house-price"><span>${house.rentMoney}</span>元/月</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="pager">
    <c:forEach begin="1" end="${map.totalPage}" var="nowPage">
        <a href="/?nowPage=${nowPage}">
                <span>${nowPage}</span>
        </a>
    </c:forEach>
</div>
</body>
</html>
