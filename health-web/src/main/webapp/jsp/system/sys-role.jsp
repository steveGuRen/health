<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导航栏 -->
<div class="row" style="margin-left: 55%; width: 45%;">
		<button ng-show="!pageContent" ng-click="skipToAdd();" class="btn btn-info pull-right"
			style="margin: 10px;">添加</button>

		<button ng-show="!pageContent" ng-click="queryList(1);" class="btn btn-info pull-right"
			style="margin: 10px;">查询</button>
		<button ng-show="pageUpdate" ng-click="page()" class="btn jc-first-row-icon fa-hover pull-right">
			<i class="fa fa-arrow-left"></i></button>
</div>
<div id="page-content" ng-show="!pageContent">

	<div class="box box-info">

		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				<div class="form-group">
					<label class="col-xs-3 control-label">角色名称</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.roleName"
							class="form-control" placeholder="请输入要查找的角色名称">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">所属机构</label>

					<div class="col-xs-5">
						<input type="text" ng-model="queryParam.roleName"
							class="form-control" placeholder="请输入所属机构">
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
						<th class="sorting_asc">角色</th>
						<th class="sorting">角色描述</th>
						<th class="sorting">查看详情</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd" ng-repeat="object in objects">
						<td>{{object.roleName}}</td>
						<td>{{object.roleDescribe}}</td>
						<td><span class="lookInfo" ng-click="page();view(object);">查看</span>&nbsp;&nbsp;&nbsp;<span
							class="deleteInfo" ng-click="del('确认删除该数据吗？',object)">删除</span></td>
					</tr>

				</tbody>

			</table>

		</div>
	</div>

	<div class="row" id="userRolePage">
		<div style="text-align:center; ">
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
		<div class="box-header with-border">
			<h3 class="box-title">角色信息</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form class="form-horizontal css-form" name="addRoleForm" novalidate>
			<div class="box-body" style="width: 100%; display: block;">
				<div class="form-group">
					<label class="fn-title control-label">角色名称</label>

					<div class="col-xs-5">
						<input required type="text" ng-model="object.roleName" class="form-control"
							placeholder="请输入角色名称">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">所属机构</label>

					<div class="col-xs-5">
						<input type="text" ng-model="object.roleDescribe"
							class="form-control" placeholder="请输入所属机构">
					</div>
				</div>


				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label">权限类型</label>
					<div class="col-xs-10">
						<div style="float: left; display: block;">
							<div style="float: left; width: 200px;">
								<div style="display: block; float: left; padding-right: 20px;">
									<input id="pb-rd-type-0" type="radio" name="type" checked> <label
										for="pb-rd-type" style="width: 25px; height: 25px;"
										ng-click="object.typeId=0;showRoleTypeList('pb-rd-type-0')"></label>
								</div>
								<div style="margin: 5px;">业务类</div>
							</div>
							
							<div style="float: left; width: 200px;">
								<div style="display: block; float: left; padding-right: 20px;">
									<input id="pb-rd-type-1" type="radio" name="type"> <label
										ng-click="object.typeId=1;showRoleTypeList('pb-rd-type-1')"
										for="pb-rd-type" style="width: 25px; height: 25px;"></label>
								</div>
								<div style="margin: 5px;">系统类</div>
							</div>

						</div>
						<div class="clearfix"></div>
						<hr style="margin-top: 1px; margin-bottom: 1px;">
						<div id="role-type-0" style="margin-top: 20px;">
							<div ng-repeat="menu in menuList0">
								<label class="fn-title control-label" style="padding-left: 0;">{{menu.menuName}}</label>
								<div class="clearfix"></div>
								<!-- 二级菜单 -->
								<div
									style="display: block; float: left; margin-left: 45px; width: 100%;">
									<div
										style="display: block; float: left; width: 100%; padding-top: 10px;"
										ng-repeat="menu2 in menu.adminMenuMenu2">
										<div style="display: block; float: left; padding-right: 10px;">
											<input id="pb-cb-{{menu2.menuId}}"
												name="menu{{menu2.menuId}}" type="checkbox"
												ng-click="menuClick(menu2.menuId)"> <label
												style="width: 25px; height: 25px;"
												ng-click="showAction(menu2.menuId)"
												for="pb-cb-{{menu2.menuId}}"></label>
										</div>
										<div ng-click="menuClick(menu2.menuId)"
											style="padding-top: 4px;">{{menu2.menuName}}</div>
										<div id="pb-cb-{{menu2.menuId}}-action"
											style="display: block; float: left; width: 100%; padding: 10px 0 0 20px;">
											<div>
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-r"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-r')"> <label
														for="pb-cb-{{menu2.menuId}}-r"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">查询</div>
											</div>
											<div>
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-u"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-u')"> <label
														for="pb-cb-{{menu2.menuId}}-u"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">修改</div>
											</div>
											<div>
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-a"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-a')"> <label
														for="pb-cb-{{menu2.menuId}}-a"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">添加</div>
											</div>
											<div>
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-d"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-d')"> <label
														for="pb-cb-{{menu2.menuId}}-d"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">删除</div>
											</div>
											<div>
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-i"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-i')"> <label
														for="pb-cb-{{menu2.menuId}}-i"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">导入</div>
											</div>
											
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div id="role-type-1" style="display: none;">
							<div ng-repeat="menu in menuList1">
								<label class="fn-title control-label" style="padding-left: 0;">{{menu.menuName}}</label>
								<div class="clearfix"></div>
								<!-- 二级菜单 -->
								<div
									style="display: block; float: left; margin-left: 45px; width: 100%;">
									<div
										style="display: block; float: left; width: 100%; padding-top: 10px;"
										ng-repeat="menu2 in menu.adminMenuMenu2">
										<div style="display: block; float: left; padding-right: 10px;">
											<input id="pb-cb-{{menu2.menuId}}"
												name="menu{{menu2.menuId}}" type="checkbox"
												ng-click="menuClick(menu2.menuId)"> <label
												for="pb-cb-{{menu2.menuId}}"
												style="width: 25px; height: 25px;"></label>
										</div>
										<div style="padding-top: 4px;">{{menu2.menuName}}</div>
										<div id="pb-cb-{{menu2.menuId}}-action"
											style="display: block; float: left; width: 100%; padding: 10px 0 0 20px;">
											<div>
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-r"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-r')"> <label
														for="pb-cb-{{menu2.menuId}}-r"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">查询</div>
											</div>
											<div ng-if="true">
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-u"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-u')"> <label
														for="pb-cb-{{menu2.menuId}}-u"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">修改</div>
											</div>
											<div ng-if="true">
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-a"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-a')"> <label
														for="pb-cb-{{menu2.menuId}}-a"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">添加</div>
											</div>
											<div ng-if="true">
												<div style="display: block; float: left; margin-left: 10px;">
													<input id="pb-cb-{{menu2.menuId}}-d"
														name="menu{{menu2.menuId}}" type="checkbox"
														ng-click="permissionClick(menu2.menuId,'-d')"> <label
														for="pb-cb-{{menu2.menuId}}-d"
														style="width: 25px; height: 25px;"></label>
												</div>
												<div style="float: left; padding: 5px;">删除</div>
											</div>
											
											<div class="clearfix"></div>


										</div>
									</div>
								</div>
							</div>
						</div>


						<div id="permissionA-show" style="float: right; display: none;">
							<div>请至少选择一个权限</div>
						</div>

					</div>

				</div>


			</div>
			<div class="box-footer">
				<button class="btn btn-default pull-right" style="margin: 10px;"
					ng-click="page();">取消</button>
				<button ng-show="type == 'add'" ng-click="add();"
					class="btn btn-info pull-right" style="margin: 10px;">添加</button>
				<button ng-show="type == 'update'" ng-click="update();"
					class="btn btn-info pull-right" style="margin: 10px;">保存</button>
			</div>
		</form>
	</div>
</div>

