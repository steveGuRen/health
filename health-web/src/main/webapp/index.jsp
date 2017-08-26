<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="../health/common/img/finance.ico"/>
<link href="../health/common/css/bootstrap.css" rel="stylesheet">
<link href="../health/common/css/AdminLTE.css" rel="stylesheet">
<link href="../health/common/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="../health/common/css/pnotify.custom.min.css" rel="stylesheet">
<link href="../health/common/css/zTreeStyle.css" rel="stylesheet">

<link href="../health/common/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="../health/css/health.css" rel="stylesheet" type="text/css">

<title>康云健康管理系统V1.0</title>

<script>
    var contextPath="<%=request.getContextPath()%>";
    var rows=10;
   
</script>

</head>
<body ng-controller="rootController" class="sidebar-mini">
	<div class="wrapper">

		<!-- <header class="main-header"> Logo 
		

		<nav class="navbar navbar-static-top">
		<a href="" class="logo"> 
			<span class="logo-mini"><b>A</b>LT</span> <span class="logo-lg"><b>康云健康管理系统</b></span>
		</a> 
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown messages-menu"><a href=""
					class="dropdown-toggle" data-toggle="dropdown" ng-bind="'欢迎，'+realName">欢迎，</a></li>
				<li class="dropdown messages-menu"><a href="#/set"
					class="dropdown-toggle" data-toggle="dropdown"> 个人设置 </a></li>
				<li class="dropdown messages-menu" onclick="loginoutFunction()"><a href=""
					class="dropdown-toggle" data-toggle="dropdown" > 登出系统 </a></li>
				<li class="dropdown messages-menu"><a href=""
					data-toggle="control-sidebar"><i
						class="dropdown-toggle fa fa-gears"></i></a></li>

			</ul>
		</div>
		
		

		<div class="navbar-custom-menu"></div>
		</nav>
		</header> -->
		<header class="main-header" style="margin-left:0;">
		<a href="" class="logo"> 
			<span class="logo-mini"><b>A</b>LT</span> <span class="logo-lg"><b>健康大数据</b></span>
		</a> 
		</header>
		<aside class="main-sidebar" > 
		
			<section class="sidebar" style="height: auto;">
		<ul class="sidebar-menu">

			<li class="treeview">
				<a href=""> <i class="fa fa-dashboard"></i>
					<span style="font-size: 16px; font-weight: bold;">系统管理</span> 
					<span class="pull-right-container"> 
					<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a menuId="5" href="#/sys-role"> 系统角色</a></li>
					<li><a menuId="6" href="#/sys-user"> 用户信息</a></li>
					<li><a menuId="7" href="#/sys-organization"> 组织结构</a></li>
				</ul>
			</li>
			
			<!-- <li class="treeview">
				<a href=""> <i class="fa fa-edit"></i>
					<span style="font-size: 16px; font-weight: bold;">APP用户</span> <span class="pull-right-container"> 
					 <i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a menuId="17" href="#/app-basicinfo">基本信息</a></li>
					<li><a menuId="18" href="#/app-followacc">关注账号</a></li>
				</ul>
			</li> -->
			<li class="treeview">
				<a href=""> 
					<i class="fa fa-envelope"></i>
					<span style="font-size: 16px; font-weight: bold;">用户档案</span> 
					<span class="pull-right-container"> 
					<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a menuId="3" href="#/record-info">档案管理</a></li>
					<!-- <li><a menuId="20" href="#/record-hospital">医院病历</a></li> -->
				</ul>
			</li>
			
			<li class="treeview">
				<a href=""> <i class="fa fa-calendar"></i>
					<span style="font-size: 16px; font-weight: bold;">设备管理</span> 
					<span class="pull-right-container"> 
					<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<!-- <li><a menuId="23" href="#/device-link">关联设备</a></li> -->
					<li><a menuId="11" href="#/device-info"> 设备信息</a></li>
					<li><a menuId="12" href="#/device-paper"> 试纸信息</a></li>
				</ul>
			</li>
			
			<li class="treeview">
				<a href=""> <i class="fa fa-pie-chart"></i>
					<span style="font-size: 16px; font-weight: bold;">检测数据</span> 
					<span class="pull-right-container"> 
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a menuId="13" href="#/stat-testinfo">检测指标</a></li>
					<li><a menuId="14" href="#/stat-testdata">检测数据</a></li>
					<li><a menuId="14" href="#/stat-statistics">数据统计</a></li>
					<!-- <li><a menuId="15" href="#/stat-analysis">数据分析</a></li> -->
					<li><a menuId="16" href="#/stat-analysis2">数据分析</a></li>
				</ul>
			</li>

		</ul>
		
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				
				<li class="dropdown messages-menu"><a href="#/set"
					class="dropdown-toggle" data-toggle="dropdown"> 个人设置 </a></li>
				<li class="dropdown messages-menu" onclick="loginoutFunction()"><a href=""
					class="dropdown-toggle" data-toggle="dropdown" onclick="loginoutFunction()"> 登出系统 </a></li>
				<!-- <li class="dropdown messages-menu"><a href=""
					data-toggle="control-sidebar"><i
						class="dropdown-toggle fa fa-gears"></i></a></li> -->

			</ul>
		</div>
		
		</section> 
	</aside>
	
		

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 921px;"
			id="page-content-wrapper">
			<section class="content-header" style="float: left;">
			<h1 ui-view="title" id="menu-toggle"></h1>
			</section>

			<!-- Main content -->
			<section class="content">
			<div class="row">
				<div class="col-lg-pull-12 mrg-left20">
					<div ui-view="container"></div>
				</div>
			</div>
			
            </section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!-- <footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.1
		</div>
		<strong>Copyright © 2016 深圳中科捷云科技有限公司. </strong> All rights reserved.
		</footer> -->

		<!-- Control Sidebar -->
		<%-- <aside class="control-sidebar control-sidebar-dark"
			style="position: fixed; height: auto;"> <!-- Create the tabs -->
		<ul class="nav nav-tabs nav-justified control-sidebar-tabs">

		</ul>
		
		<h3 style="text-align: center;">主题色</h3>

		<div class="box box-solid" style="max-width: 300px;">
			<div class="box-body no-padding">
				<table id="layout-skins-list"
					class="table table-striped bring-up nth-2-center">
					
					<tbody>
						<tr>
							<td><code>蓝色</code></td>
							<td><a href="" data-skin="skin-blue"
								class="btn btn-primary btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>

						<tr>
							<td><code>橙色</code></td>
							<td><a href="" data-skin="skin-yellow"
								class="btn btn-warning btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>

						<tr>
							<td><code>绿色</code></td>
							<td><a href="" data-skin="skin-green"
								class="btn btn-success btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>
						<tr>
							<td><code>浅绿色</code></td>
							<td><a href="" data-skin="skin-green-light"
								class="btn btn-success btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>
						<tr>
							<td><code>紫色</code></td>
							<td><a href="" data-skin="skin-purple"
								class="btn bg-purple btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>

						<tr>
							<td><code>红色</code></td>
							<td><a href="" data-skin="skin-red"
								class="btn btn-danger btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>
						<tr>
							<td><code>粉色</code></td>
							<td><a href="" data-skin="skin-pink"
								class="btn btn-danger btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>
						<tr>
							<td><code>灰色</code></td>
							<td><a href="" data-skin="skin-black"
								class="btn bg-black btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>
						<tr>
							<td><code>黑色</code></td>
							<td><a href="" data-skin="skin-black-deep"
								class="btn bg-black btn-xs"><i class="fa fa-eye"></i></a></td>
						</tr>

					</tbody>
				</table>
			</div>
			
		</div>
		</aside> --%>

		<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
	</div>
	
	<script src="<%=request.getContextPath()%>/common/js/app.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/jquery-migrate-1.1.0.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/jquery.jqprint-0.3.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/bootstrap-datetimepicker.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/ui-bootstrap-tpls.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/jquery.ztree.core.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/jquery.ztree.excheck.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/pnotify.custom.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/angular-file-upload.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/angular-md5.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/win_layer/win_layer.js"></script>
	<script src="<%=request.getContextPath()%>/common/win_layer/extend/layer.ext.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/checklist-model.js"></script>
	
	<script src="<%=request.getContextPath()%>/common/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/cytoscape.min.js"></script>
	
	<!-- ChartJS 1.0.1 -->
	<script src="<%=request.getContextPath()%>/common/js/Chart.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/echarts.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/app-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/ui-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/health-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/common-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/house-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/house-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/record-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/health.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/movie.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/common.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/filters.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/device-info-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/stat-testinfo-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/stat-testdata-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/sys-user-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/sys-role-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/stat-analysis-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/stat-statistics-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/app-followacc-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/app-basicinfo-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/record-hospital-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/record-info-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/device-link-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/device-paper-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/stat-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/sys-organization-ctrl.js"></script>
	
	<script src="<%=request.getContextPath()%>/js/sv/user-role-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/sys-user-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/organization-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/graph-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/filters.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/sigma/sigma.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/sigma/plugins/sigma.parsers.json.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/sigma/plugins/sigma.plugins.dragNodes.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/sigma/plugins/sigma.renderers.parallelEdges.min.js"></script>
	<script>
    	var accessToken='${accessToken}';
    	var organizationIdList = [];
    	 var menuId='';
	</script>
</body>
</html>
