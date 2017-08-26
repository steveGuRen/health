<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row" style="margin-left: 55%; width: 45%;">
	<div>
	<button ng-show="!pageContent" ng-click="houseExport('确认导出所有房屋信息吗')" class="btn btn-info pull-right" style="margin: 10px;">导出</button>
	<button ng-show="!pageContent" ng-click="houseImport('房屋信息导入')" class="btn btn-info pull-right" style="margin: 10px;">导入</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="pageadd();skipToUpdate();">添加</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="queryList(1);">查询</button>
	<!-- <button ng-show="pageAdd" class="btn btn-default pull-right" style="margin: 10px;" ng-click="pageadd();">返回</button>
	<button ng-show="pageUpdate" class="btn btn-default pull-right" style="margin: 10px;" ng-click="pageupdate();">返回</button> -->
	</div>
</div>
<!-- 导航栏 -->


<div id="page-content" ng-show="!pageContent">

	<div class="box box-info">

		<!-- form start -->
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label">房屋地址</label>
					<div class="col-xs-10" style="padding-left: 0;">
						<div class="col-xs-2">
							<select
		    					ng-change="selectBuild(queryParam.premise.premisesId)"
								ng-options="premise.premisesName for premise in selectPremises.premises track by premise.premisesId"
								ng-model="queryParam.premise">
							</select>
						</div>
						<div style="float: left;">-</div>
						<div class="col-xs-2">
							<select
		    					ng-change="selectUnit(queryParam.premise.premisesId,queryParam.build.buildId)"
								ng-options="build.buildName for build in selectBuilds.builds track by build.buildId"
								ng-model="queryParam.build">
								<option value="">请选择楼栋</option>
							</select>
						</div>
						
						<div style="float: left;">-</div>
						<div class="col-xs-2">
							<select ng-change="selectFloor(queryParam.premise.premisesId,queryParam.build.buildId,queryParam.unit.unitId)"
								ng-options="unit.unitName for unit in selectUnits.units track by unit.unitId"
								ng-model="queryParam.unit">
								<option value="">请选择单元</option>
							</select>
						</div>
						
						<div style="float: left;">-</div>
						<div class="col-xs-2">
							<select
		    					ng-change="selectHouse(queryParam.premise.premisesId,queryParam.build.buildId,queryParam.unit.unitId,queryParam.floor.houseFloor)"
								ng-options="floor.houseFloor for floor in selectFloors.floors track by floor.houseFloor"
								ng-model="queryParam.floor">
								<option value="">请选择楼层</option>
							</select>
						</div>
						<div style="float: left;">-</div>
						<div class="col-xs-2">
							<select ng-options="house.houseNum for house in selectHouses.houses track by house.houseId"
								ng-model="queryParam.house">
								<option value="">请选择房间号</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label">计费面积</label>

					<div class="col-xs-10" style="padding-left: 0;width: 51%;">
					<div class="col-xs-5">
						<input ng-model="queryParam.billingAreaStart" type="text" class="form-control" placeholder="请输入最小计费面积">
					</div>
					<div style="float: left;">-</div>
					<div class="col-xs-5">
						<input ng-model="queryParam.billingAreaEnd" type="text" class="form-control" placeholder="请输入最大计费面积">
					</div>
					</div>
				</div>
				<div class="form-group" style="clear:both;">
					<label class="fn-title control-label">房屋类型</label>

					<div class="col-xs-5">
						<select ng-model="queryParam.houseType">
						 	<option value="">---请选择房屋类型---</option>
	      					<option value="0">普通住房</option>
	      					<option value="1">商用住房</option>
	      					<option value="2">空置</option>
							<option value="3">虚拟</option>
	    				</select>
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
						<th class="sorting">房屋地址</th>
						<th class="sorting">房屋类型</th>
						<th class="sorting">建筑面积</th>
						<th class="sorting">套内面积</th>
						<th class="sorting">计费面积</th>
						<th class="sorting">房屋备注</th>
						<th class="sorting">查看详情</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd" ng-repeat="object in objects">
						<td>{{object|addressFilter}}</td>
						<td>{{object.houseType|houseTypeFilter}}</td>
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

	<div class="row" id="housePage">
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

<div ng-if="pageAdd" id="page-add">
<!-- form start -->

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">房屋地址</h3>
		</div>
		<!-- /.box-header -->
		
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">所属项目</label>

					<div class="col-xs-5">
						<select id="st-premise"
	    					ng-change="setBuild(object.selectPremiseName)"
							ng-model="object.selectPremiseName">
							<option value="">选择项目</option>
							<option ng-repeat="premise in setPremises.premises"  ng-disabled='!premise.myFlag'>{{premise.premisesName}}</option>
						</select> 
					</div>
					<button ng-show="!object.premise" ng-click="addPremise('新增楼盘信息')" class="btn btn-info" style="float: left; position: relative;">新增</button>
					<button ng-show="object.premise" ng-click="updatePremise('修改楼盘信息',object.premise)" class="btn btn-info" style="float: left; position: relative;">编辑</button>
					<button ng-show="object.premise" ng-click="deletePremise('是否删除该项目', object.premise)" class="btn btn-default" style="float: left; position: relative;margin-left:10px;">删除</button>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属楼栋</label>

					<div class="col-xs-5">
						<select
	    					ng-change="setUnit(object.premise.premisesId,object.build.buildId)"
							ng-options="build.buildName for build in setBuilds.builds"
							ng-model="object.build">
							<option value=''>选择楼栋</option>
							
						</select>
					</div>
					<button ng-show="object.premise && !object.build" ng-click="addBuild()" class="btn btn-info" style="float: left; position: relative;">新增</button>
					<button ng-show="object.premise && object.build" ng-click="updateBuild(object)" class="btn btn-info" style="float: left; position: relative;">编辑</button>
					<button ng-show="object.premise && object.build" ng-click="deleteBuild('是否删除该楼栋', object.build)" class="btn btn-default" style="float: left; position: relative;margin-left:10px;">删除</button>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属单元</label>

					<div class="col-xs-5">
						<select ng-change="setFloor(object.premise.premisesId,object.build.buildId,object.unit.unitId)"
							ng-options="unit.unitName for unit in setUnits.units"
							ng-model="object.unit">
							<option value=''>选择单元</option>
						</select>
					</div>
					<button ng-show="object.build && !object.unit" ng-click="addUnit()" class="btn btn-info" style="float: left; position: relative;">新增</button>
					<button ng-show="object.build && object.unit" ng-click="updateUnit(object)" class="btn btn-info" style="float: left; position: relative;">编辑</button>
					<button ng-show="object.build && object.unit" ng-click="deleteUnit('是否删除该单元', object.unit)" class="btn btn-default" style="float: left; position: relative;margin-left:10px;">删除</button>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属楼层</label>

					<div class="col-xs-5">
						<select
	    					ng-change="setHouse(object.premise.premisesId,object.build.buildId,object.unit.unitId,object.floor.houseFloor)"
							ng-options="floor.houseFloor for floor in setFloors.floors"
							ng-model="object.floor">
							<option value=''>选择楼层</option> 
						</select>
					</div>
					<button ng-show="object.unit && !object.floor" ng-click="addFloor()" class="btn btn-info" style="float: left; position: relative;">新增</button>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属房号</label>

					<div class="col-xs-5">
						<select ng-options="house.houseNum for house in setHouses.houses"
								ng-model="object.house">
							<option value=''>选择房号</option>
						</select>
					</div>
					<button ng-show="object.floor && !object.house" ng-click="addHouse()" class="btn btn-info" style="float: left; position: relative;">新增</button>
					<button ng-show="object.floor && object.house" ng-click="updateHouse(object)" class="btn btn-info" style="float: left; position: relative;">编辑</button>
					<button ng-show="object.floor && object.house" ng-click="deleteHouse('是否删除该房屋', object.house)" class="btn btn-default" style="float: left; position: relative;margin-left:10px;">删除</button>
				</div>
			
	</div>
	
	<!-- <div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">房屋信息</h3>
		</div>
		/.box-header
		
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">房屋类型</label>

					<div class="col-xs-5">
						<input ng-model="object.houseType" type="text" class="form-control" placeholder="请输入房屋类型">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">建筑面积</label>
					<div class="col-xs-5">
						<input ng-pattern="'(^[0]\.\d{1,2}$|^[1-9]+(\.\d{1,2})?$)'" ng-model="object.houseArea" type="text" class="form-control" placeholder="请输入建筑面积">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">套内面积</label>

					<div class="col-xs-5">
						<input ng-pattern="'(^[0]\.\d{1,2}$|^[1-9]+(\.\d{1,2})?$)'" ng-model="object.comprisingArea" type="text" class="form-control" placeholder="请输入套内面积">
					</div>
				</div>

				<div class="form-group">
					<label class="fn-title control-label">计费面积</label>

					<div class="col-xs-5">
						<input ng-pattern="'(^[0]\.\d{1,2}$|^[1-9]+(\.\d{1,2})?$)'" ng-model="object.billingArea" type="text" class="form-control" placeholder="请输入计费面积">
					</div>
				</div>
				
			</div>
			
	</div> -->
	
	<!-- <div class="box box-info"> -->
		<!-- <div class="box-header with-border">
			<h3 class="box-title">业主信息</h3>
			<button class="btn btn-info pull-right" ng-click="addOwner();">添加</button>
		</div>
			<div class="box-body" style="width: 100%; display: block;">
				<div ng-repeat="item in object.ownerList">
					<div class="form-group" style="clear:both;">
						<label class="fn-title control-label">业主姓名</label>
	
						<div class="col-xs-5">
							<input required ng-model="item.ownerName" type="text" class="form-control" placeholder="请输入业主姓名">
						</div>
					</div>
					<div class="form-group">
						<label class="fn-title control-label">联系方式</label>
	
						<div class="col-xs-5">
							<input required ng-pattern="'(^1[3|4|5|7|8][0-9]\\d{8}$)|(^(\\d{3,4}-)\\d{7,8}$)'" ng-model="item.ownerTel" type="text" class="form-control" placeholder="请输入联系方式">
						</div>
						<button ng-click="deleteOwner($index)" class="btn btn-default" style="float: left; position: relative;">删除</button>
					</div>
				</div>
			</div> -->
			<!-- /.box-body -->
			<div class="box-footer">
				<button class="btn btn-default pull-right" style="margin: 10px;"
					ng-click="pageadd();queryList(queryParam.currentPage);selectPremise()">返回</button>
				<!-- <button ng-click="add();" class="btn btn-info pull-right"
					style="margin: 10px;">添加</button> -->
			</div>
	<!-- </div> -->		
	</div>
</div>
<!-- 详情页面 -->

<div ng-show="pageUpdate" id="page-update">
<!-- form start -->

	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">房屋信息</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">所属项目</label>

					<div class="col-xs-5">
						
						<input class="form-control" ng-model="object.premisesName" readonly/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属楼栋</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.buildName" readonly/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属单元</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.unitName" readonly/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属楼层</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseFloor" readonly/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">所属房号</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.houseNum" readonly/>
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">房屋类型</label>
					<div class="col-xs-5">
						<select class="form-control" ng-model="object.houseType">
							<option value="0">普通住房</option>
							<option value="1">商用住房</option>
							<option value="2">空置</option>
							<option value="3">虚拟</option>
						</select>
					</div>
				</div>
				<form class="css-form" name="updateHouseForm" novalidate>
				<div class="form-group">
					<label class="fn-title control-label">建筑面积</label>
					<div class="col-xs-5">
						<input ng-pattern="'^[0](\\.\\d{1,2})?$|^[1-9]+\\d*(\\.\\d{1,2})?$'" ng-model="object.houseArea" type="text" class="form-control" placeholder="请输入建筑面积">
					</div>
					<a><div class="fn-title control-label" style="padding-left: 0px;">保留两位小数</div></a>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">套内面积</label>

					<div class="col-xs-5">
						<input ng-pattern="'^[0](\\.\\d{1,2})?$|^[1-9]+\\d*(\\.\\d{1,2})?$'" ng-model="object.comprisingArea" type="text" class="form-control" placeholder="请输入套内面积">
					</div>
					<a><div class="fn-title control-label" style="padding-left: 0px;">保留两位小数</div></a>
				</div>

				<div class="form-group">
					<label class="fn-title control-label">计费面积</label>

					<div class="col-xs-5">
						<input ng-pattern="'^[0](\\.\\d{1,2})?$|^[1-9]+\\d*(\\.\\d{1,2})?$'" ng-model="object.billingArea" type="text" class="form-control" placeholder="请输入计费面积">
					</div>
					<a><div class="fn-title control-label" style="padding-left: 0px;">保留两位小数</div></a>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">房屋备注</label>

					<div class="col-xs-5">
						<input ng-model="object.houseName" type="text" class="form-control" placeholder="请输入房屋备注">
					</div>
				</div>
				</form>
				
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			
			<button ng-click="update();" class="btn btn-info pull-right"
				style="margin: 10px;">保存</button>
		</div>
	</div>
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">业主信息</h3>
			<button class="btn btn-info pull-right" ng-click="updateOwner();">添加</button>
		</div>
			<div class="box-body" style="width: 100%; display: block;">
			<form class="css-form" name="updateOwnerForm" novalidate>
				<div ng-repeat="item in object.ownerList">
					<div class="form-group" style="clear:both;">
						<label class="fn-title control-label">业主姓名</label>
	
						<div class="col-xs-5">
							<input required ng-model="item.ownerName" type="text" class="form-control" placeholder="请输入业主姓名">
						</div>
					</div>
					<div class="form-group">
						<label class="fn-title control-label">联系方式</label>
	
						<div class="col-xs-5">
							<input required ng-pattern="'(^1[3|4|5|7|8][0-9]\\d{8}$)|(^(\\d{3,4}-)\\d{7,8}$)'" ng-model="item.ownerTel" type="text" class="form-control" placeholder="请输入联系方式">
						</div>
						<button ng-click="ownerUpdate(item,$index)" class="btn btn-info" style="float: left; position: relative;">保存</button>
						<button ng-click="updateOwnerDelete('确认删除该业主吗',item,$index)" class="btn btn-default" style="float: left; position: relative; margin-left: 10px;">删除</button>
					</div>
				</div>
			</form>
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button class="btn btn-default pull-right" style="margin: 10px;"
					ng-click="pageupdate();queryList(queryParam.currentPage)">返回</button>
				
			</div>
	</div>		

</div>



