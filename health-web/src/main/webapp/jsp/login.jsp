<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html ng-app="loginApp" xmlns="http://www.w3.org/1999/xhtml"
	style="height: 100%;  background: -webkit-linear-gradient(#66B3FF, #004B97);">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit" />
<link rel="shortcut icon" href="../finance/common/img/finance.ico"/>
<link href="${contextPath}/common/css/pnotify.custom.min.css" rel="stylesheet">
<%
    pageContext.setAttribute("contextPath",request.getContextPath());
%>
<script>
    var contextPath="<%=request.getContextPath()%>";
</script>

<title>登录</title>
<style type="text/css">

#apDiv1 {
	position: absolute;
	left: 34%;
	top: 153px;
	width: 552px;
	height: 420px;
	z-index: 1;
	border: 5px solid #6CF;
}

#top {
	font-size: 36px;
	line-height: 30px;
	font-weight: bold;
	color: #FFF;
	background-color: #004B97;
	text-align: center;
	padding-top: 40px;
	padding-bottom: 40px;
}

#mid {
	text-align: center;
	height: 280px;
}

.tb {
	color: #004B97;
	background-color: #F0F0F0;
	font-weight: bold;
	padding-top: 30px;
	padding-right: 10px;
	padding-left: 20px;
	font-size: 24px;
}

.input1 {
	text-align: center;
	width: 300px;
	height: 40px;
	border-radius: 2px;
	background-color: #fff;
	border: 0px;
}

.input2 {
	text-align: center;
	width: 120px;
	height: 40px;
	border-radius: 4px;
	background-color: #fff;
	border: 0px;
	float: left;
}

#button {
	font-size: 24px;
	color: #FFF;
	background-color: #004B97;
	width:120px;
	border-radius: 10px;
}

#loginlabel {
    display: block;
    width: 360px;
    height: 50px;
    font-size: 20px;
    color: #FFFFFF;
    background-color: #3EACF3;
    border-radius: 4px;
    text-align: center;
}

#apDiv2 {
	position: absolute;
	left: 690px;
	top: 622px;
	width: 396px;
	height: 23px;
	z-index: 2;
	font-family: "Menlo, Monaco, Consolas, "Courier New", monospace";
	color: #FFF;
	text-align: center;
	font-size: 18px;
}
#div4 {
    display: block;
    width: 360px;
    display: block;
    margin: 10px auto;
}
</style>

</head>

<body  ng-controller="LoginController">
	<div id="apDiv1">
		<div id="top">康云健康管理系统V1.0</div>
		
		<div class="tb" id="mid">
		<form action="${contextPath}/authentication/login-process"
			method="post">
				<div style="margin: 10px 10px 10px 30px; width: 100%;height:60px;">
					<div style="width:120px;float:left;">登录名</div>
					<div style="width:300px;float:left;">
						<input type="text" class="input1" ng-model="adminName" />
					</div>
				</div>
				<div style="margin: 10px 10px 10px 30px; width: 100%;height:60px;">
					<div style="width:120px;float:left;">密 码</div>
					<div style="width:300px;float:left;">
						<input type="password" class="input1" ng-model="adminPassword" />
					</div>
				</div>
				<div style="margin: 10px 10px 10px 30px; width: 100%;height:60px;">
					<div style="width:120px;float:left;">验证码</div>
					<div style="width:300px;float:left;">
						<input id="code" type="text" class="input2" ng-model="code"/>
						<a href="" ng-click="refreshImage($event);">
							<img src="${contextPath}/adminLogin/identifycode/image"  width='100px' height=30px style="float:right;margin:5px;">
						</a>
					</div>
				</div>
				<div style="margin: 10px 10px 10px 0px; width: 100%;height:60px;">
					<div id="div4">
						<label id="loginlabel" for="login">
				 			<div style="display: block;width: 50px; height: 30px;margin-left: auto;margin-right: auto;padding-top: 10px;cursor: pointer">登录</div>
				 		</label>
						<input style="display: none;;" ng-click="login();" type="button" id="login">
					</div>
				</div>
		</form>
		</div>
	
	</div>
	<div id="apDiv2">版权所有 深圳中科捷云科技有限公司</div>


</body>
<script src="${contextPath}/common/js/app.js"></script>
<script src="${contextPath}/js/login.js"></script>
<script src="${contextPath}/common/js/angular-md5.min.js"></script>
<script src="${contextPath}/common/win_layer/win_layer.js"></script>
<script src="${contextPath}/common/win_layer/extend/layer.ext.js"></script>
<script src="${contextPath}/js/common/common.js"></script>
<script src="${contextPath}/common/js/pnotify.custom.min.js"></script>
</html>
