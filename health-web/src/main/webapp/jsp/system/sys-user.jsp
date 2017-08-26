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
					<label class="col-xs-3 control-label">用户姓名</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.realName" class="form-control" placeholder="请输入用户姓名">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">联系方式</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.adminTel" class="form-control" placeholder="请输入联系方式">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">员工角色</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryRoles.names" class="form-control" placeholder="请选择员工角色" ng-click="popupRoles('选择角色')">
					</div>
				</div>
				<!--<div class="form-group">
					<label class="col-xs-3 control-label">员工职务</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="queryParam.position"
							ng-options="position for position in positions">
							<option value="">全部</option>
						</select>
					</div>
				</div>-->
				<div class="form-group">
					<label class="col-xs-3 control-label">组织名称</label>

					<div class="col-xs-5">
						<input type="text" class="form-control" ng-model="queryPremises.names" ng-click="popupPremises('小区选择');"
							placeholder="请选择组织名称">
					</div>
				</div>
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
						<!-- <th class="sorting" style="width:10%;">员工编号</th> -->
						<th class="sorting" style="width:8%;">登录账号</th>
						<th class="sorting" style="width:8%;">姓名</th>
						<th class="sorting" style="width:8%;">电话</th>
						<th class="sorting" style="width:30%;">组织</th>
						<th class="sorting" style="width:20%;">角色</th>
						<th class="sorting" style="width:8%;">查看详情</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" ng-repeat="object in objects">
						<!-- <td style="width:10%;">{{object.adminId}}</td> -->
						<td style="width:8%;">{{object.userLoginName}}</td>
						<td style="width:8%;">{{object.userName}}</td>
						<td style="width:8%;">{{object.userTel}}</td>
						<td style="width:30%;">{{object.organizationlist|organizationListCutFilter}}</td>
						<td style="width:20%;">{{object.roleList|roleListCutFilter}}</td>
						<td style="width:8%;"><span class="lookInfo"
							ng-click="page();skipToUpdate(object)">查看</span>&nbsp;&nbsp;&nbsp;<span
							class="deleteInfo" ng-click="del('确认删除该数据吗？',object)">删除</span></td>
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
		<form class="form-horizontal css-form" name="addStaffForm" novalidate>
			<div class="box-body" style="width: 100%; display: block;">
				<div class="form-group">
					<label class="fn-title control-label">登录账号</label>

					<div class="col-xs-5">
						<input required id="admin-name" type="text" ng-model="object.userLoginName" class="form-control" placeholder="请输入登录账号">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">用户姓名</label>

					<div class="col-xs-5">
						<input id="realName" required type="text" ng-model="object.userName" class="form-control" placeholder="请输入用户姓名">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">

					<label class="fn-title control-label">用户性别</label>
					<div class="col-xs-5">
						
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 50%;">
							<div style="display: block; float: left;">
								<input ng-click="object.gender=0;"
									id="pb-rd-man" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-man"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">男</div>
							</div>
							<div style="display: block; float: left; width: 50%;">
								<div style="display: block; float: left;">
									<input ng-click="object.gender=1;"
										id="pb-rd-woman" name="pb-rd-sex"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-woman"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">女</div>
							</div>
							
						</div>
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">联系方式</label>

					<div class="col-xs-5">
						<input required ng-pattern="'(^1[0-9]\\d{9}$)|(^(\\d{3,4}-)\\d{7,8}$)'" type="text" ng-model="object.userTel" class="form-control" placeholder="请输入联系方式">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>

				<!--<div class="form-group">
					<label class="fn-title control-label">所属部门</label>

					<div class="col-xs-5">
						<input required type="text" ng-model="object.department" class="form-control" placeholder="请输入所属部门">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>-->
				<!--<div class="form-group">
					<label class="fn-title control-label">员工职务</label>

					<div class="col-xs-5">
						<input required type="text" ng-model="object.position" class="form-control" placeholder="请输入员工职务">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>-->
				<div class="form-group" style="clear: both;">
					<label class="fn-title control-label">选择角色</label>
				</div>
				<div id="role-premises">
				<div class="form-group" style="clear: both;margin-left: 50px;">
					<label class="fn-title control-label">业务类</label>
				</div>
				<div class="form-group" style="margin-left: 100px;width: 100%;" ng-repeat="role in roleList0">
					
					<label class="fn-title control-label" style="width: 200px;">
					<!-- <i id="{{role.roleId}}" class="fa fa-angle-down" style="width:10px;padding-right:5px;cursor: pointer;" ng-click="angleClick(role)"></i> -->
					{{role.roleName}}
					
					</label>
					<div style="float: left; width: 130px; margin-left: 0;">
						<div style="display: block; float: left; padding-right: 20px;">
							<input id="pb-cb-{{role.roleId}}" type="checkbox" ng-click="allClick(role.roleId)"> <label
								for="pb-cb-{{role.roleId}}" style="width: 25px; height: 25px;"
								></label>
						</div>
						<div style="margin: 5px;">全选</div>
					</div>
					
					<div id="{{role.roleId}}-action" class="col-xs-10" style="margin-top: 20px;">
						<div style="display: block; float: left; width: 250px;"
							ng-repeat="item in selectPremises.premises">
							<div style="display: block; float: left;">
								<input ng-click="checkClick($index)"
									id="pb-cb-{{role.roleId}}-{{item.organizationId}}" name="pb-cb-{{role.roleId}}"
									class="jc-query-param-checkbox" type="checkbox"> <label
									for="pb-cb-{{role.roleId}}-{{item.organizationId}}"
									style="width: 25px; height: 25px;"></label>
							</div>
							<div style="float: left; font-size: 14px; padding: 0px 20px;">{{item.organizationName}}</div>
						</div>
					</div>
				</div>
				
				<div class="form-group" style="clear: both;margin-left: 50px;">
					<label class="fn-title control-label">系统类</label>
				</div>
				<div class="form-group" style="margin-left: 100px;width: 100%;" ng-repeat="role in roleList1">
					<div style="float: left; width: 50px;">
						<div style="display: block; float: left; padding-right: 20px;">
							<input id="pb-cb-{{role.roleId}}" type="checkbox" name="pb-cb-{{role.roleId}}" ng-click="allClick(role.roleId)"> <label
								for="pb-cb-{{role.roleId}}" style="width: 25px; height: 25px;" 
								></label>
						</div>
						
					</div>
					<label class="fn-title control-label">{{role.roleName}}</label>
					
					
				</div>
				
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

