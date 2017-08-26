<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" style="margin-left: 55%; width: 45%;">
	<div>
	<button ng-show="!pageContent" ng-click="houseExport('确认导出所有房屋信息吗')" class="btn btn-info pull-right" style="margin: 10px;">导出</button>
	<button ng-show="!pageContent" ng-click="houseImport('房屋信息导入')" class="btn btn-info pull-right" style="margin: 10px;">导入</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="pageadd();skipToAdd();">添加</button>
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
					<label class="fn-title control-label">账号</label>

					<div class="col-xs-5">
						<input ng-model="queryParam.billingAreaStart" type="text" class="form-control" placeholder="请输入最小计费面积">
					</div>
					
				</div>
				<div class="form-group">
					<label class="fn-title control-label">姓名</label>

					<div class="col-xs-5">
						<input ng-model="queryParam.billingAreaStart" type="text" class="form-control" placeholder="请输入最小计费面积">
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
						<th class="sorting">账号</th>
						<th class="sorting">姓名</th>
						<th class="sorting">邮箱地址</th>
						<th class="sorting">手机号码</th>
						<th class="sorting">所属组织</th>
						<th class="sorting">身份证号码</th>
						<th class="sorting">健康档案编号</th>
						<th class="sorting">操作</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd" ng-repeat="object in objects">
						<td>{{object}}</td>
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
	
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">昵称：</label>

					<div class="col-xs-5">
						
						<input class="form-control" ng-model="object.premisesName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">性别：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.buildName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">生日：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.unitName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">文化程度：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">婚姻状况：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseNum"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">常住类型：</label>

					<div class="col-xs-5">
						
						<input class="form-control" ng-model="object.premisesName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">住址：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.buildName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">微信号：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.unitName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">紧急联系人：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">紧急联系人电话：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">国籍：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseNum"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">籍贯：</label>

					<div class="col-xs-5">
						
						<input class="form-control" ng-model="object.premisesName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">工作单位：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.buildName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">职业：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.unitName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">职业分类：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">乡镇（街道）名称：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">村（居）委会名称：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseNum"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">暴露史：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">民族：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">健康卡号：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">身高：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">体重：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">步长：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">血型：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">RH阴性血型：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">社保卡号：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">医保类型：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">医疗费用支付方式：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor"/>
					</div>
				</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			
			<button ng-click="update();" class="btn btn-info pull-right"
				style="margin: 10px;">保存</button>
		</div>
	</div>
		
	
</div>


