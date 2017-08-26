<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" style="margin-left: 55%; width: 45%;">
	<div>
	<button ng-show="!pageContent" ng-click="houseExport('确认导出所有房屋信息吗')" class="btn btn-info pull-right" style="margin: 10px;">导出</button>
	<button ng-show="!pageContent" ng-click="houseImport('房屋信息导入')" class="btn btn-info pull-right" style="margin: 10px;">导入</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="pageadd();skipToUpdate();">添加</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="queryList(1);">查询</button>
	</div>
</div>
<!-- 导航栏 -->


<div id="page-content" ng-show="!pageContent">

	<div class="box box-info">

		<!-- form start -->
		
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">设备名称</label>

					<div class="col-xs-5">
						<input id="deviceName" ng-model="queryParam.deviceName" type="text" class="form-control" placeholder="请输入设备名称">
					</div>
					
				</div>
				<div class="form-group">
					<label class="fn-title control-label">所属组织</label>

					<div class="col-xs-5">
						<select ng-model="queryParam.institution">
						 	<option value="">---请选择所属组织---</option>
	      					<option value="0">正常</option>
	      					<option value="1">空置</option>
							<option value="2">虚拟</option>
	    				</select>
					</div>
				</div>


			</div>
		</form>
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">设备ID</label>

					<div class="col-xs-5">
						<input id="deviceName" ng-model="queryParam.id" type="text" class="form-control" placeholder="请输入设备ID">
					</div>
					
				</div>
				<div class="form-group">
					<label class="fn-title control-label">Mac地址</label>

					<div class="col-xs-5">
						<input id="deviceName" ng-model="queryParam.Mac" type="text" class="form-control" placeholder="请输入Mac地址">
					</div>
					
				</div>


			</div>
		</form>
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group" >
					<label class="fn-title control-label" style = "margin-top: 16px" >起始时间:</label>
					<div class = "col-xs-5">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%">
								<input type="text" ng-model="object.startTime" class="form-control" id="one-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen1" ng-click="isopen1=!isopen1">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" >
					<label class="fn-title control-label" style = "margin-top: 16px" >截止时间:</label>
					<div class = "col-xs-5">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%">
								<input type="text" ng-model="object.endTime" class="form-control" id="one-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen2" ng-click="isopen2=!isopen2">
							</div>
						</div>
					</div>
				</div>


			</div>
		</form>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">设备名称</th>
						<th class="sorting">设备IP</th>
						<th class="sorting">Mac地址</th>
						<th class="sorting">入库时间</th>
						<th class="sorting">设备状态</th>
						<th class="sorting">所属组织</th>
						<th class="sorting">操作</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd" ng-repeat="object in objects">
						<td>{{object.name}}</td>
						<td>{{object.houseType}}</td>
						<td>{{object.houseArea}}</td>
						<td>{{object.comprisingArea}}</td>
						<td>{{object.billingArea}}</td>
						<td>{{object.houseName}}</td>
						<td><span class="lookInfo"
							ng-click="pageupdate();skipToUpdate(object)">查看</span></td>
					</tr>


				</tbody>

			</table>

			
		</div>
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

<!-- 详情页面 -->

<div ng-if="pageAdd" id="page-add">
	

</div>


