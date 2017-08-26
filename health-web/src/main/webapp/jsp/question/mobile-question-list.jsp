<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<meta name="full-screen" content="yes">
<link href="<%=request.getContextPath()%>/common/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/common/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href= "<%=request.getContextPath()%>/css/example.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/weui.min.css" rel="stylesheet">
<title>个人病史</title>

<script>
    var contextPath="<%=request.getContextPath()%>";
    var userId="${userId}";
</script>
<style type="text/css">
@charset "UTF-8";
[ng\:cloak],[ng-cloak],
[data-ng-cloak],[x-ng-cloak],.ng-cloak,
.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none!important;}
</style>
<style type = "text/css">
  .home,.view{
  	position: absolute;
  	width: 100%;
  	height: 100%;
  	left: 0;
  	top: 0;
  	z-index: 1;
  }
  
  .view{
  	left: 0px;
  	background: #ffffff;
  	z-index: 2;
  	height: 100%;
  	width: 100%;
  }
  
   .page {
  	width: 100%;
  	height: 100%;
  	margin-left:16px;
  	margin-right:16px;
  }
  
</style>
</head>
<body class = "home" ng-app = "question" ng-controller = "questionItemCtrl">
  <div class = "view" >
     <div class = "row" style = "padding-right:30px">
        <div class = "page" style = "font-family: Microsoft YaHei;">
           <div id="page-content" ng-show="!listPage">
                 <div class="weui_cells" >
	
					<div class="weui_cell" ng-click = "clickList('家族史')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>家族史</p>
						</div>
						<div class = "weui_cell_ft">
							<p></p>
						</div>
					</div>
					<div class="weui_cell" ng-click = "clickList('遗传病史')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>遗传病史</p>
						</div>
						<div class = "weui_cell_ft">
							<p></p>
						</div>
					</div>
					<div class="weui_cell" ng-click = "clickList('既往史')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>既往史</p>
						</div>
						<div class = "weui_cell_ft">
							<p></p>
						</div>
					</div>
					<div class="weui_cell" ng-click = "clickList('残疾情况')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>残疾情况</p>
						</div>
						<div class = "weui_cell_ft" >
							<p></p>
						</div>
					</div>
					<div class="weui_cell" ng-click = "clickList('过敏史')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>过敏史</p>
						</div>
						<div class = "weui_cell_ft" >
							<p></p>
						</div>
					</div>
					<div class="weui_cell" ng-click = "clickList('住院史')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>住院史</p>
						</div>
						<div class = "weui_cell_ft" ng-model = meter.currentConsumption>
							<p></p>
						</div>
					</div>
					<div class="weui_cell" ng-click = "clickList('非免疫预防接种史')">
						<div class="weui_cell_bd weui_cell_primary">
							<p>非免疫预防接种史</p>
						</div>
						<div class = "weui_cell_ft" ng-model = meter.currentConsumption>
							<p></p>
						</div>
					</div>
				</div>
           </div>
         <div ng-if="recordDetail" id="page-add" ng-cloak>
	      <div class="box box-info form-horizontal">
		   <div class="box-header with-border">
			  <h3 class = "box-title"></h3>
		   </div>
		    <div class="box-body" style="width: 100%; display: block">
			<!-- 家族史 -->
			 <div class = "row" ng-show = "selectedTag == 3">
				<div class = "col-sm-12" style = "margin-top: 20px;">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">父亲患病情况</h4>
						<button ng-click="add('家族史','父亲患病情况','11');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
					</div>
					<table id="father"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">疾病名称</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="father in fathers">
								<td>{{father.item}}</td>
								<td>{{father.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('家族史','父亲患病情况','11',father)">修改</span></td>
							</tr>
						</tbody>
					</table>
					
				</div>
				<!-- <div class="row" id="housePage">
					<div class="col-sm-4"></div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example1_paginate">
								<ul class="pagination">
					
									<li class="paginate_button previous "
									ng-class="{'disabled':(queryParam.currentPage==1)}"
									id="paginate_previous"
									ng-click="queryList(queryParam.currentPage*1-1)"><a>上一页</a></li>
									<li class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
									ng-click="queryList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
									<li ng-show="displayPages[1]" class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
									ng-click="queryList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
									<li ng-show="displayPages[2]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
									ng-click="queryList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
									<li ng-show="displayPages[3]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
									ng-click="queryList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
									<li ng-show="displayPages[4]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
									ng-click="queryList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
									<li ng-show="displayPages[5]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
									ng-click="queryList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
									<li ng-show="displayPages[6]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
									ng-click="queryList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
									<li class="paginate_button next"
									ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
									id="paginate_next"
									ng-click="queryList(queryParam.currentPage*1+1)"><a>下一页</a></li>
									<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
								</ul>
							</div>
						</div>
					</div> -->
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">母亲患病情况</h4>
						<button ng-click="add('家族史','母亲患病情况','12');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
					</div>
					<table id="mother"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">疾病名称</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="mother in mothers">
								<td>{{mother.item}}</td>
								<td>{{mother.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('家族史','母亲患病情况','12',mother)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- <div class="row" id="housePage">
					<div class="col-sm-4"></div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example1_paginate">
								<ul class="pagination">
					
									<li class="paginate_button previous "
									ng-class="{'disabled':(queryParam.currentPage==1)}"
									id="paginate_previous"
									ng-click="queryList(queryParam.currentPage*1-1)"><a>上一页</a></li>
									<li class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
									ng-click="queryList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
									<li ng-show="displayPages[1]" class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
									ng-click="queryList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
									<li ng-show="displayPages[2]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
									ng-click="queryList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
									<li ng-show="displayPages[3]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
									ng-click="queryList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
									<li ng-show="displayPages[4]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
									ng-click="queryList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
									<li ng-show="displayPages[5]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
									ng-click="queryList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
									<li ng-show="displayPages[6]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
									ng-click="queryList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
									<li class="paginate_button next"
									ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
									id="paginate_next"
									ng-click="queryList(queryParam.currentPage*1+1)"><a>下一页</a></li>
									<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
								</ul>
							</div>
						</div>
					</div> -->
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">兄弟姐妹患病情况</h4>
					    <button ng-click="add('家族史','兄弟姐妹患病情况','13');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="brother"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">疾病名称</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="brother in brothers">
								<td>{{brother.item}}</td>
								<td>{{brother.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('家族史','兄弟姐妹患病情况','13',brother)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- <div class="row" id="housePage">
					<div class="col-sm-4"></div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example1_paginate">
								<ul class="pagination">
					
									<li class="paginate_button previous "
									ng-class="{'disabled':(queryParam.currentPage==1)}"
									id="paginate_previous"
									ng-click="queryList(queryParam.currentPage*1-1)"><a>上一页</a></li>
									<li class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
									ng-click="queryList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
									<li ng-show="displayPages[1]" class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
									ng-click="queryList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
									<li ng-show="displayPages[2]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
									ng-click="queryList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
									<li ng-show="displayPages[3]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
									ng-click="queryList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
									<li ng-show="displayPages[4]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
									ng-click="queryList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
									<li ng-show="displayPages[5]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
									ng-click="queryList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
									<li ng-show="displayPages[6]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
									ng-click="queryList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
									<li class="paginate_button next"
									ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
									id="paginate_next"
									ng-click="queryList(queryParam.currentPage*1+1)"><a>下一页</a></li>
									<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
								</ul>
							</div>
						</div>
					</div> -->
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">子女患病情况</h4>
					    <button ng-click="add('家族史','子女患病情况','14');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="children"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">疾病名称</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="child in children">
								<td>{{child.item}}</td>
								<td>{{child.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('家族史','子女患病情况','14',child)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- <div class="row" id="housePage">
					<div class="col-sm-4"></div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example1_paginate">
								<ul class="pagination">
					
									<li class="paginate_button previous "
									ng-class="{'disabled':(queryParam.currentPage==1)}"
									id="paginate_previous"
									ng-click="queryList(queryParam.currentPage*1-1)"><a>上一页</a></li>
									<li class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
									ng-click="queryList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
									<li ng-show="displayPages[1]" class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
									ng-click="queryList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
									<li ng-show="displayPages[2]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
									ng-click="queryList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
									<li ng-show="displayPages[3]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
									ng-click="queryList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
									<li ng-show="displayPages[4]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
									ng-click="queryList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
									<li ng-show="displayPages[5]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
									ng-click="queryList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
									<li ng-show="displayPages[6]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
									ng-click="queryList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
									<li class="paginate_button next"
									ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
									id="paginate_next"
									ng-click="queryList(queryParam.currentPage*1+1)"><a>下一页</a></li>
									<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
								</ul>
							</div>
						</div>
					</div> -->
			</div>
			
			<!-- 遗传病史 -->
			<div class = "row" ng-show = "selectedTag == 4">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">遗传病史</h4>
					    <button ng-click="add('遗传病史','遗传病史','15');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="Genetic"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">疾病名称</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="genetic in genetics">
								<td>{{genetic.item}}</td>
								<td>{{genetic.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('遗传病史','遗传病史','15',genetic)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- <div class="row" id="housePage">
					<div class="col-sm-4"></div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example1_paginate">
								<ul class="pagination">
					
									<li class="paginate_button previous "
									ng-class="{'disabled':(queryParam.currentPage==1)}"
									id="paginate_previous"
									ng-click="queryList(queryParam.currentPage*1-1)"><a>上一页</a></li>
									<li class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
									ng-click="queryList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
									<li ng-show="displayPages[1]" class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
									ng-click="queryList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
									<li ng-show="displayPages[2]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
									ng-click="queryList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
									<li ng-show="displayPages[3]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
									ng-click="queryList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
									<li ng-show="displayPages[4]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
									ng-click="queryList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
									<li ng-show="displayPages[5]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
									ng-click="queryList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
									<li ng-show="displayPages[6]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
									ng-click="queryList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
									<li class="paginate_button next"
									ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
									id="paginate_next"
									ng-click="queryList(queryParam.currentPage*1+1)"><a>下一页</a></li>
									<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
								</ul>
							</div>
						</div>
					</div> -->
			</div>
			<!-- 既往史 -->
			<div class = "row" ng-show = "selectedTag == 5">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">疾病史</h4>
						<button ng-click="add('疾病史','疾病史','19');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
					</div>
					<table id="disease"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">疾病名称</th>
								<th class="sorting">确诊时间</th>
								<th class="sorting">是否已痊愈</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="disease in diseases">
								<td>{{disease.disease}}</td>
								<td>{{disease.diagnosisTime}}</td>
								<td>{{disease.iscured}}</td>
								<td>{{disease.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('疾病史','疾病史','19',disease)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- <div class="row" id="housePage">
					<div class="col-sm-4"></div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="example1_paginate">
								<ul class="pagination">
					
									<li class="paginate_button previous "
									ng-class="{'disabled':(queryParam.currentPage==1)}"
									id="paginate_previous"
									ng-click="queryList(queryParam.currentPage*1-1)"><a>上一页</a></li>
									<li class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
									ng-click="queryList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
									<li ng-show="displayPages[1]" class="paginate_button"
									ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
									ng-click="queryList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
									<li ng-show="displayPages[2]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
									ng-click="queryList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
									<li ng-show="displayPages[3]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
									ng-click="queryList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
									<li ng-show="displayPages[4]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
									ng-click="queryList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
									<li ng-show="displayPages[5]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
									ng-click="queryList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
									<li ng-show="displayPages[6]" class="paginate_button "
									ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
									ng-click="queryList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
									<li class="paginate_button next"
									ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
									id="paginate_next"
									ng-click="queryList(queryParam.currentPage*1+1)"><a>下一页</a></li>
									<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
								</ul>
							</div>
						</div>
					</div> -->
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">手术史</h4>
						<button ng-click="add('手术史','手术史','20');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
					</div>
					<table id="surgery"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">手术名称</th>
								<th class="sorting">手术时间</th>
								<th class="sorting">诊断结果</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="operation in operations">
								<td>{{operation.operationName}}</td>
								<td>{{operation.operationTime}}</td>
								<td>{{operation.operationResult}}</td>
								<td>{{operation.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('手术史','手术史','20',operation)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">外伤史</h4>
					    <button ng-click="add('外伤史','外伤史','21');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="injury"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">外伤名称</th>
								<th class="sorting">外伤时间</th>
								<th class="sorting">描述</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="injury in injuries">
								<td>{{injury.injuryName}}</td>
								<td>{{injury.injuryTime}}</td>
								<td>{{injury.injuryDescription}}</td>
								<td>{{injury.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('外伤史','外伤史','21',injury)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">输血史</h4>
					    <button ng-click="add('输血史','输血史','22');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="blood"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">输血时间</th>
								<th class="sorting">输血量(cc)</th>
								<th class="sorting">原因</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="transfusion in transfusions">
								<td>{{transfusion.transfusionTime}}</td>
								<td>{{transfusion.bloodTransfusion}}</td>
								<td>{{transfusion.cause}}</td>
								<td>{{transfusion.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('输血史','输血史','22',transfusion)">查看</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 残疾情况 -->
			<div class = "row" ng-show = "selectedTag == 6">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">残疾情况</h4>
					    <button ng-click="add('残疾情况','残疾情况','16');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="disability"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">残疾情况</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="object in objects">
								<td>{{object.item}}</td>
								<td>{{object.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('残疾情况','残疾情况','16',object)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 过敏史 -->
			<div class = "row" ng-show = "selectedTag == 7">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">药物过敏史</h4>
					    <button ng-click="add('过敏史','药物过敏史','17');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="pillAllergy"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">过敏药物</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="allergy in allergys">
								<td>{{allergy.item}}</td>
								<td>{{allergy.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('过敏史','药物过敏史','17',allergy)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">其他过敏史</h4>
					    <button ng-click="add('过敏史','其他过敏史','18');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="otherAllergy"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">过敏物质</th>
								<th class="sorting">入库时间</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="allergen in allergens">
								<td>{{allergen.item}}</td>
								<td>{{allergen.createTime}}</td>
								<td><span class="lookInfo"
									ng-click="modify('过敏史','其他过敏史','18',allergen)">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 住院史 -->
			<div class = "row" ng-show = "selectedTag == 10">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">住院史</h4>
					    <button ng-click="add('住院史','住院史','23');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="disability"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">病案编号</th>
								<th class="sorting">机构名称</th>
								<th class="sorting">住院原因</th>
								<th class="sorting">入院时间</th>	
								<th class="sorting">出院时间</th>
								<!-- <th class="sorting">病床号</th>
								<th class="sorting">病床医疗机构名称</th>
								<th class="sorting">建床时间</th>
								<th class="sorting">撤床时间</th> -->
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="object in objects">
								<td>{{object.patientId}}</td>
								<td>{{object.institution}}</td>
								<td>{{object.cause}}</td>
								<td>{{object.hospitalInTime}}</td>
								<td>{{object.hospitalOutTime}}</td>
								<!-- <td>{{object.bedId}}</td>
								<td>{{object.bedInstitution}}</td>
								<td>{{object.bedCreateTime}}</td>
								<td>{{object.bedDelTime}}</td> -->
								<td><span class="lookInfo"
									ng-click="modify('住院史','住院史','23',object);">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 非免疫预防接种史 -->
			<div class = "row" ng-show = "selectedTag == 11">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;margin-left:10px;margin-top:10px">非免疫预防接种史</h4>
					    <button ng-click="add('非免疫预防接种史','非免疫预防接种史','24');" class="btn btn-info pull-right"
						style="margin-left: 10px;margin-right:20px; margin-top:10px; margin-bottom: 10px">新增</button>
		            </div>
					<table id="disability"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">接种名称</th>
								<th class="sorting">接种日期</th>
								<th class="sorting">接种机构</th>
								<th class="sorting">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd" ng-repeat="object in objects">
								<td>{{object.immunizationName}}</td>
								<td>{{object.immunizationDate}}</td>
								<td>{{object.immunizationInstitution}}</td>
								<td><span class="lookInfo"
									ng-click="modify('非免疫预防接种史','非免疫预防接种史','24',object);">修改</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="box-footer">
				<button ng-click="skipToAdd();" class="btn btn-cancel pull-right"
				style="margin: 10px;">取消</button>
				<button ng-click="update();" class="btn btn-info pull-right"
				style="margin: 10px;">保存</button>
			</div>
		</div>
	</div>
  </div>
        </div>
     </div>
  </div>
  
  <script src="<%=request.getContextPath()%>/common/js/angular.min.js"></script>
  <script src="<%=request.getContextPath()%>/common/js/ui-bootstrap-tpls.min.js"></script>
  <script src="<%=request.getContextPath()%>/common/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/common/js/pnotify.custom.min.js"></script>
  <script src="<%=request.getContextPath()%>/common/win_layer/win_layer.js"></script>
	<script src="<%=request.getContextPath()%>/common/win_layer/extend/layer.ext.js"></script>
  <script src="<%=request.getContextPath()%>/js/common/common.js"></script>
  <script src="<%=request.getContextPath()%>/js/ctrl/question-item-ctrl.js"></script>
    <script src="<%=request.getContextPath()%>/js/question-index.js"></script>
    <script src="<%=request.getContextPath()%>/js/ctrl/question-ctrl.js"></script>
    <script src="<%=request.getContextPath()%>/js/sv/question-sv.js"></script>
    <script src="<%=request.getContextPath()%>/js/common/filters.js"></script>
</body>
</html>