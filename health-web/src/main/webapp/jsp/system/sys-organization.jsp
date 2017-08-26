<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导航栏 -->
<div class="row" style="margin-left: 55%; width: 45%;">
		<button ng-show="!pageContent" ng-click="skipToAdd();" class="btn btn-info pull-right"
			style="margin: 10px;">添加</button>

		<button ng-show="!pageContent" ng-click="queryList(1);" class="btn btn-info pull-right" style="margin: 10px;">查询</button>
		<button ng-show="pageUpdate" ng-click="page()" class="btn jc-first-row-icon fa-hover pull-right">
			<i class="fa fa-arrow-left"></i></button>
</div>

<div id="page-content" ng-show="!pageContent">

	<div class="box box-info">

		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				<div class="form-group">
					<label class="col-xs-3 control-label">组织名称</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.organizationName" class="form-control" placeholder="请输入组织名称">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">组织地址</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.organizationPosition" class="form-control" placeholder="请输入组织地址">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">组织类型</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.type" class="form-control" placeholder="请输入组织类型">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">组织电话</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.tel" class="form-control" placeholder="请输入组织电话">
					</div>
				</div>
				<!--<div class="form-group">
					<label class="col-xs-3 control-label">员工角色</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryRoles.names" class="form-control" placeholder="请选择员工角色" ng-click="popupRoles('选择角色')">
					</div>
				</div>-->
				<!--<div class="form-group">
					<label class="col-xs-3 control-label">员工职务</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="queryParam.position"
							ng-options="position for position in positions">
							<option value="">全部</option>
						</select>
					</div>
				</div>-->
				<!--<div class="form-group">
					<label class="col-xs-3 control-label">小区名称</label>

					<div class="col-xs-5">
						<input type="text" class="form-control" ng-model="queryPremises.names" ng-click="popupPremises('小区选择');"
							placeholder="请选择小区名称">
					</div>
				</div>-->
			</div>
			<!-- /.box-body -->

		</form>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting" style="width:8%;">组织名称</th>
						<th class="sorting" style="width:8%;">组织地址</th>
						<th class="sorting" style="width:8%;">组织类型</th>
						<th class="sorting" style="width:8%;">组织电话</th>
						<th class="sorting" style="width:8%;">组织传真</th>
						<th class="sorting" style="width:8%;">组织邮件</th>
						<th class="sorting" style="width:8%;">组织微信</th>
						<th class="sorting" style="width:8%;">组织qq</th>
						<th class="sorting">查看详情</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" ng-repeat="object in objects">
						<!-- <td style="width:10%;">{{object.adminId}}</td> -->
						<td style="width:8%;">{{object.organizationName}}</td>
						<td style="width:8%;">{{object.organizationPosition}}</td>
						<td style="width:8%;">{{object.type}}</td>
						<td style="width:8%;">{{object.tel}}</td>
						<td style="width:8%;">{{object.fax}}</td>
						<td style="width:8%;">{{object.email}}</td>
						<td style="width:8%;">{{object.weChat}}</td>
						<td style="width:8%;">{{object.qqNum}}</td>
						<td style="width:8%;"><span class="deleteInfo" ng-click="del('确认删除该数据吗？',object)">删除</span></td>
					</tr>

				</tbody>

			</table>
			
		</div>
	</div>

	<div class="row" id="userStaffPage">
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
	</div>

</div>

<!-- 详情页面 -->

<div ng-show="pageUpdate" id="page-update" class="jc-update">
	<div class="box box-info">
		
		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal css-form" name="addOrganization" novalidate>
			<div class="box-body" style="width: 100%; display: block;">

				<div class="form-group">
					<label class="fn-title control-label">组织名称</label>

					<div class="col-xs-5">
						<input required  type="text" ng-model="object.organizationName" class="form-control" placeholder="请输入组织名称">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织地址</label>

					<div class="col-xs-5">
						<input required  type="text" ng-model="object.organizationPosition" class="form-control" placeholder="请输入组织地址">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织类型</label>

					<div class="col-xs-5">
						<input required  type="text" ng-model="object.type" class="form-control" placeholder="请输入组织类型">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织电话</label>

					<div class="col-xs-5">
						<input required ng-pattern="'(^1[0-9]\\d{9}$)|(^(\\d{3,4}-)\\d{7,8}$)'" type="text" ng-model="object.tel" class="form-control" placeholder="请输入组织电话">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织传真</label>

					<div class="col-xs-5">
						<input required  type="text" ng-model="object.fax" class="form-control" placeholder="请输入组织传真">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织邮件</label>

					<div class="col-xs-5">
						<input required  type="text" ng-model="object.email" class="form-control" placeholder="请输入组织邮件">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织微信</label>

					<div class="col-xs-5">
						<input required  type="text" ng-model="object.weChat" class="form-control" placeholder="请输入组织微信">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">组织qq</label>

					<div class="col-xs-5">
						<input id="realName" required type="text" ng-model="object.qqNum" class="form-control" placeholder="请输入组织qq">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button class="btn btn-default pull-right" style="margin: 10px;"
					ng-click="page();">取消</button>
				<button ng-show="type == 'add'" ng-click="add();" class="btn btn-info pull-right" style="margin: 10px;">添加</button>
				<button ng-show="type == 'update'" ng-click="update();" class="btn btn-info pull-right" style="margin: 10px;">保存</button>
			</div>
			<!-- /.box-footer -->
		</form>
	</div>
</div>

