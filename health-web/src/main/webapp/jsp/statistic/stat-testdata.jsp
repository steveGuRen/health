
  <div class="content-controller" ng-controller="statTestdataCtrl">
    

    
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" style="margin-left: 55%; width: 45%;">
	<div>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="skipToAdd()">新增</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="queryList(1,quotaName);">查询</button>
	</div>
</div>
<!-- 导航栏 -->


<div id="page-content" ng-show="!pageContent">

	
	<div class="box box-info">
	
		

		<!-- form start -->
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="row" style="height: 50px;">
				<ul id="tabButton" style="padding-left:0;"> 
			         <li id="quotaType0" ng-click="quotaType=0;classChange();queryList(1,'体重');"  class='non-active-tabButton' style="cursor:pointer;">
						体重BMI
			        </li> 
			        <li id="quotaType1" ng-click="quotaType=1;classChange();queryList(1,'体温');"  class='non-active-tabButton' style="cursor:pointer;">
			        	体温
			        </li> 
			        <li id="quotaType2" ng-click="quotaType=2;classChange();queryList(1,'血压');"  class='non-active-tabButton' style="cursor:pointer;">
			        	血压
			        </li>
			        <li id="quotaType3" ng-click="quotaType=3;classChange();queryList(1,'血氧');"  class='non-active-tabButton' style="cursor:pointer;">
			        	血氧
			        </li>
			        <li id="quotaType4" ng-click="quotaType=4;classChange();queryList(1,'血糖');"  class='non-active-tabButton' style="cursor:pointer;">
			        	血糖
			        </li>
			        <li id="quotaType5" ng-click="quotaType=5;classChange();queryList(1,'心率');"  class='non-active-tabButton' style="cursor:pointer;">
			        	心率
			        </li>
			        <li id="quotaType6" ng-click="quotaType=6;classChange();queryList(1,'脂肪率');"  class='non-active-tabButton' style="cursor:pointer;">
			        	脂肪率
			        </li>
			        <li id="quotaType7" ng-click="quotaType=7;classChange();queryList(1,'尿检');"  class='non-active-tabButton' style="cursor:pointer;">
			        	尿检
			        </li>
			        
			       
				</ul> 
			</div>


			</div>
			
			<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				
				
				<div class="form-group">
					<label class="fn-title control-label">用户姓名</label>

					<div class="col-xs-5">
						<input ng-model="queryParam.userName" type="text" class="form-control" placeholder="请输入用户姓名">
					</div>
				</div>

				<div class="form-group">
					<label class="fn-title control-label">用户性别</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="queryParam.gender">
							<option value=''>请选择用户性别</option>
							<option value='1'>男</option>
							<option value="0">女</option>
						</select>
					</div>
					
				</div>

			</div>
		</form>
		</form>
	</div>

	<div class="row">
		
		<div class="col-sm-12">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">指标名称</th>
						<th class="sorting">检测值</th>
						<th class="sorting">检测时间</th>
						<th class="sorting">用户名</th>
						<th class="sorting">性别</th>
						<th class="sorting">年龄</th>
						<th class="sorting">检测结果</th>
						<th class="sorting">设备号</th>
						<!-- <th class="sorting">操作</th> -->
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd" ng-repeat="object in objects">
						<td>{{object.quotaName}}</td>
						<td>{{object.value}}</td>
						<td>{{object.createTime}}</td>
						<td>{{object.userName}}</td>
						<td>{{object.gender|genderFilter}}</td>
						<td>{{object.userAge}}L</td>
						<td>{{object.result}}</td>
						<td>{{object.device}}</td>
						<!-- <td><span class="lookInfo"
							ng-click="skipToUpdate(object)">查看</span></td> -->
					</tr>

				</tbody>

			</table>
			
		</div>
	</div>
	
	<div class="row" id="tstDataPage">
		<div style="text-align:center; ">
			<div class="dataTables_paginate paging_simple_numbers"
				id="example1_paginate">
				<ul class="pagination">
					
					<li class="paginate_button previous "
						ng-class="{'disabled':(queryParam.currentPage==1)}"
						id="paginate_previous"
						ng-click="queryList((queryParam.currentPage*1-1),quotaName)"><a>上一页</a></li>
					<li class="paginate_button"
						ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
						ng-click="queryList(displayPages[0],quotaName);"><a>{{displayPages[0]}}</a></li>
					<li ng-show="displayPages[1]" class="paginate_button"
						ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
						ng-click="queryList(displayPages[1],quotaName);"><a>{{displayPages[1]}}</a></li>
					<li ng-show="displayPages[2]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
						ng-click="queryList(displayPages[2],quotaName);"><a>{{displayPages[2]}}</a></li>
					<li ng-show="displayPages[3]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
						ng-click="queryList(displayPages[3],quotaName);"><a>{{displayPages[3]}}</a></li>
					<li ng-show="displayPages[4]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
						ng-click="queryList(displayPages[4],quotaName);"><a>{{displayPages[4]}}</a></li>
					<li ng-show="displayPages[5]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
						ng-click="queryList(displayPages[5],quotaName);"><a>{{displayPages[5]}}</a></li>
					<li ng-show="displayPages[6]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
						ng-click="queryList(displayPages[6],quotaName);"><a>{{displayPages[6]}}</a></li>
					<li class="paginate_button next"
						ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
						id="paginate_next"
						ng-click="queryList((queryParam.currentPage*1+1),quotaName)"><a>下一页</a></li>
					<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
				</ul>
			</div>
		</div>
	</div>

</div>

<!-- <form data-toggle="validator" role="form"> -->
<div ng-if="pageAdd" id="page-add">
	
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="form-group">
					<label class="fn-title control-label">用户姓名：</label>

					<div class="col-xs-5">
						
						<input type="text" class="form-control" ng-model="object.userName" ng-blur="validateUserName();" required/>
  
					</div>
					<div style="padding-top: 7px;color:red;" ng-show="!object.hasUser">{{noticeUser}}</div> 	
				</div>
				<div class="form-group">
					<label class="fn-title control-label">指标名称：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.quota"
						ng-options="quota.quotaName for quota in quotalist track by quota.quotaType">
							<option value="">请选择指标</option>
							<!-- <option value="1">体温</option>
							<option value="2">血压</option>
							<option value="3">血氧</option>
							<option value="4">血糖</option>
							<option value="5">心率</option>
							<option value="6">脂肪率</option>
							<option value="7">尿检</option> -->
						</select>
					</div>
				</div>
				
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType==2)">
					<label class="fn-title control-label">舒张压：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.blodPress[0].value"/>
					</div>mmHg
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType==2)">
					<label class="fn-title control-label">收缩压：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.blodPress[1].value"/>
					</div>mmHg
				</div>
				
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[0].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[0].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
							
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[1].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.urine[1].value"/>
					</div>个
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[2].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[2].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
							
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[3].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[3].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
							
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[4].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.urine[4].value"/>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[5].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[5].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
							
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[6].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[6].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
							
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[7].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[7].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
							
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[8].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.urine[8].value"/>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[9].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="urine[9].value"/>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[10].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[10].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[11].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[11].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
						</select>
					</div>
				</div>
				
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[12].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[12].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[13].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.urine[13].result"/>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')" style="clear:both;">
					<label class="fn-title control-label">{{object.urine[14].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<select class="form-control" ng-model="object.urine[14].result">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
						</select>
					</div>
				</div>
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType=='7')">
					<label class="fn-title control-label">{{object.urine[15].secondQuotaName}}：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.urine[15].value"/>
					</div>mmol/d
				</div>
				
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType!='7') && (object.quota.quotaType!='2')">
					<label class="fn-title control-label">指标值：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.value"/>
					</div>
				</div>
				
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType!='7') && (object.quota.quotaType!='2')">
					<label class="fn-title control-label">单位：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.unit"/>
					</div>
				</div>
				
				<div class="form-group" style="clear:both;">
					<label class="fn-title control-label">设备号：</label>

					<div class="col-xs-5">
						
						<input class="form-control" ng-model="object.deviceId"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="fn-title control-label">设备ID：</label>

					<div class="col-xs-5">
						<input class="form-control" ng-model="object.device"/>
					</div>
				</div>
				
				<div class="form-group" ng-show="object.quota && (object.quota.quotaType==4)">
					<label class="fn-title control-label">测量场景：</label>

					<div class="col-xs-5">
						 <select class="form-control" ng-model="object.situation">
							<option value="阴性">阴性</option>
							<option value="阳性">阳性</option>
						</select>
					</div>
				</div>
				
				
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			
			<button ng-click="skipToAdd();" class="btn btn-cancel pull-right"
				style="margin: 10px;">取消</button>
			<button ng-click="add();" class="btn btn-info pull-right"
				style="margin: 10px;">保存</button>
			<button ng-click="userRegister();" class="btn btn-info pull-right"
				style="margin: 10px;">注册用户</button>
		</div>
	</div>

</div>
<!-- </form> -->
  