<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" style="margin-left: 55%; width: 45%;">
	<div>
	<button ng-show="!pageContent" ng-click="houseExport('确认导出所有房屋信息吗')" class="btn btn-info pull-right" style="margin: 10px;">导出</button>
	<button ng-show="!pageContent" ng-click="houseImport('房屋信息导入')" class="btn btn-info pull-right" style="margin: 10px;">导入</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="pageadd();">添加</button>
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
					<label class="fn-title control-label">档案ID</label>

					<div class="col-xs-5">
						<input ng-model="queryParam.recordId" type="text" class="form-control" placeholder="请输入档案名称">
					</div>
					
				</div>
				<div class="form-group">
					<label class="fn-title control-label">档案类型</label>

					<div class="col-xs-5">
						<select ng-model="queryParam.recordType">
						 	<option value="">---请选择档案类型---</option>
	      					<option value="0">健身</option>
	      					<option value="1">美容</option>
							<option value="2">医疗</option>
	    				</select>
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
						<th class="sorting">用户ID</th>
						<th class="sorting">姓名</th>
						<th class="sorting">创建时间</th>
						<th class="sorting">档案类型</th>
						<th class="sorting">操作</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd" ng-repeat="record in records">
						<td>{{record.userId}}</td>
						<td>{{record.userName}}</td>
						<td>{{record.createTime}}</td>
						<td>{{record.recordType}}</td>
						<td><span class="lookInfo"
							ng-click="skipToUpdate(record)">查看</span></td>
					</tr>


				</tbody>

			</table>

			
		</div>
	</div>

	<div class="row" id="recordPage">
		<div style="text-align:center; ">
			<div class="dataTables_paginate paging_simple_numbers"
				id="example1_paginate">
				<ul class="pagination">
					
					<li class="paginate_button previous "
						ng-class="{'disabled':(queryParam.currentPage==1)}"
						id="paginate_previous"
						ng-click="getUserList(queryParam.currentPage*1-1)"><a>上一页</a></li>
					<li class="paginate_button"
						ng-class="{'active':(queryParam.currentPage==displayPages[0])}"
						ng-click="getUserList(displayPages[0]);"><a>{{displayPages[0]}}</a></li>
					<li ng-show="displayPages[1]" class="paginate_button"
						ng-class="{'active':(queryParam.currentPage==displayPages[1])}"
						ng-click="getUserList(displayPages[1]);"><a>{{displayPages[1]}}</a></li>
					<li ng-show="displayPages[2]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[2])}"
						ng-click="getUserList(displayPages[2]);"><a>{{displayPages[2]}}</a></li>
					<li ng-show="displayPages[3]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[3])}"
						ng-click="getUserList(displayPages[3]);"><a>{{displayPages[3]}}</a></li>
					<li ng-show="displayPages[4]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[4])}"
						ng-click="getUserList(displayPages[4]);"><a>{{displayPages[4]}}</a></li>
					<li ng-show="displayPages[5]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[5])}"
						ng-click="getUserList(displayPages[5]);"><a>{{displayPages[5]}}</a></li>
					<li ng-show="displayPages[6]" class="paginate_button "
						ng-class="{'active':(queryParam.currentPage==displayPages[6])}"
						ng-click="getUserList(displayPages[6]);"><a>{{displayPages[6]}}</a></li>
					<li class="paginate_button next"
						ng-class="{'disabled':(queryParam.currentPage==queryParam.totalPage)}"
						id="paginate_next"
						ng-click="getUserList(queryParam.currentPage*1+1)"><a>下一页</a></li>
					<a><div style="display: inline-block; padding: 7px;">共{{queryParam.totalCount}}条</div></a>
					
				</ul>
			</div>
		</div>
	</div>

</div>

<!-- 详情页面 -->

<div ng-if="recordDetail" id="page-add">
	<div class="box box-info form-horizontal">
		<div class="box-header with-border">
			<h3 class = "box-title">{{title}}</h3>
		</div>
		<div class="box-body" style="width: 100%; display: block">
			<div class="row" style="height: 50px">
				<ul id="tabButton"> 
			        <li id="tabAccount" ng-click="getAccountNumberInfo()"
			        ng-class = "{'active-tabButton': selectedTag == 1,'non-active-tabButton': selectedTag != 1}">
						账号信息
			        </li> 
			        <li ng-click="getBasicInfo()"
			        ng-class = "{'active-tabButton': selectedTag == 2,'non-active-tabButton': selectedTag != 2}">
			        	基本信息
			        </li> 
			        <li ng-click="getTabFamilyHistory()"
			        ng-class = "{'active-tabButton': selectedTag == 3,'non-active-tabButton': selectedTag != 3}">
			        	家族史
			        </li>
			        <li ng-click="getTabGeneticDiseaseHistory()"
			        ng-class = "{'active-tabButton': selectedTag == 4,'non-active-tabButton': selectedTag != 4}">
			        	遗传病史
			        </li>
			    	<li ng-click="getTabPastHistory()"
			        ng-class = "{'active-tabButton': selectedTag == 5,'non-active-tabButton': selectedTag != 5}">
			        	既往史
			        </li>
				</ul> 
			</div>
			<div class="row" style="height: 50px;margin-bottom:5%">
				<ul id="tabButton"> 
					<li ng-click="getTabDisabilitySituation()"
			        ng-class = "{'active-tabButton': selectedTag == 6,'non-active-tabButton': selectedTag != 6}">
			        	残疾情况
			        </li>
			        <li ng-click="getTabAllergyHistory()"
			        ng-class = "{'active-tabButton': selectedTag == 7,'non-active-tabButton': selectedTag != 7}">
			        	过敏史
			        </li>
			        <!-- <li ng-click="getTabLivingEnvironment()"
				     ng-class = "{'active-tabButton': selectedTag == 8,'non-active-tabButton': selectedTag != 8}">
			        	生活环境
			        </li>
			        <li ng-click="getTabPrepareMedication()"
			         ng-class = "{'active-tabButton': selectedTag == 9,'non-active-tabButton': selectedTag != 9}">
			        	家庭常备药
			        </li> -->
			       <li ng-click="getTabStayhospitalHistory()"
			        ng-class = "{'active-tabButton': selectedTag == 10,'non-active-tabButton': selectedTag != 10}">
			        	住院史
			        </li>
			        <li ng-click="getTabVaccinatesss()"
			        ng-class = "{'active-tabButton': selectedTag == 11,'non-active-tabButton': selectedTag != 11}">
			        	非免疫预防接种史
			        </li>
			        <li ng-click="getTabHealthassess()"
			        ng-class = "{'active-tabButton': selectedTag == 12,'non-active-tabButton': selectedTag != 12}">
			        	健康评价
			        </li>
				</ul> 
			</div>
			<!-- 帐号信息 -->
			<div ng-show = "selectedTag == 1" class = "row" style = "margin-left: 20px">
				<div class = "form-group" style = "text-align:center;">
					<label class= "fn-title control-label" style = "margin-top: 10%;margin-bottom: 4px">个人头像：</label>
					<div class = "upload" >
						<input class = "upload-input" type = "file" name = "upload" id = "imageFile" >
						<img  src="" width = "120" height = "120">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">会员姓名:</label>

					<div class="col-xs-5">
						<input ng-model="account.userName" type="text" class="form-control" placeholder="请输入会员姓名">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">邮箱地址:</label>

					<div class="col-xs-5">
						<input ng-model="account.userEmail" type="text" class="form-control" placeholder="请输入邮箱地址">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">手机号码:</label>

					<div class="col-xs-5">
						<input ng-model="account.userTel" type="text" class="form-control" placeholder="请输入手机号码">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">身份证号码:</label>

					<div class="col-xs-5">
						<input ng-model="account.userIdCard" type="text" class="form-control" placeholder="请输入身份证号码">
					</div>
				</div>
			</div>
			<!-- 基本信息 -->
			<div ng-show = "selectedTag == 2" class = "row" style = "margin-left: 20px">
				
				<!-- <div class="form-group">
					<label class="fn-title control-label">昵称:</label>

					<div class="col-xs-5">
						<input ng-model="object.houseName" type="text" class="form-control" placeholder="请输入昵称">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">微信号:</label>

					<div class="col-xs-5">
						<input ng-model="object.houseName" type="text" class="form-control" placeholder="请输入微信号">
					</div>
				</div> -->
				<div class="form-group">
					<label class="fn-title control-label">性别:</label>

					<div class="col-xs-5">
						<input ng-model="basic.gender" type="text" class="form-control" placeholder="请输入性别">
					</div>
				</div>
				<div class="form-group" >
					<label class="fn-title control-label" >生日:</label>
					<div class = "col-xs-5">
						<div style="float: left; display: block;width:100%;" >
							<div style = "width: 100%">
								<input type="text" ng-model="basic.birthday" class="form-control" id="birthday"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen4" ng-click="isopen4=!isopen4">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">国籍:</label>

					<div class="col-xs-5">
						<input ng-model="basic.nationality" type="text" class="form-control" placeholder="请输入国籍">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">籍贯:</label>

					<div class="col-xs-5">
						<input ng-model="basic.nativePlace" type="text" class="form-control" placeholder="请输入籍贯">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">乡镇(街道)名称:</label>

					<div class="col-xs-5">
						<input ng-model="basic.village" type="text" class="form-control" placeholder="请输入乡镇（街道）名称">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">村(居)委会名称:</label>

					<div class="col-xs-5">
						<input ng-model="basic.neighborhoodCommittee" type="text" class="form-control" placeholder="请输入村(居)委会名称">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">民族:</label>
                    <div class = "col-xs-5">
                        <select class="form-control" ng-model="basic.nation" ng-options = "race for race in races"
                        ng-change = "selectNation(basic.nation)">
						   <option value="">请选择民族</option>
					    </select>
                    </div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">身高:(cm)</label>

					<div class="col-xs-5">
						<input ng-model="basic.height" type="text" class="form-control" placeholder="请输入身高">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">体重(kg):</label>

					<div class="col-xs-5">
						<input ng-model="basic.weight" type="text" class="form-control" placeholder="请输入体重">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">步长(cm):</label>

					<div class="col-xs-5">
						<input ng-model="basic.step" type="text" class="form-control" placeholder="请输入步长">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">血型:</label>

					<div class="col-xs-5">
						<input ng-model="basic.bloodType" type="text" class="form-control" placeholder="请输入血型">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">RH阴性血型:</label>

					<div class="col-xs-5">
						<input ng-model="basic.rh" type="text" class="form-control" placeholder="请输入RH阴性血型">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">文化程度:</label>

					<div class="col-xs-5">
						<input ng-model="basic.education" type="text" class="form-control" placeholder="请输入文化程度">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">婚姻状况:</label>

					<div class="col-xs-5">
						<input ng-model="basic.maritalStatus" type="text" class="form-control" placeholder="请输入婚姻状况">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">常住类型:</label>

					<div class="col-xs-5">
						<input ng-model="basic.residentType" type="text" class="form-control" placeholder="请输入常住类型">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">住址:</label>

					<div class="col-xs-5">
						<input ng-model="basic.address" type="text" class="form-control" placeholder="请输入住址">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">紧急联系人:</label>

					<div class="col-xs-5">
						<input ng-model="basic.emergencyPerson" type="text" class="form-control" placeholder="请输入紧急联系人">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">紧急联系人电话:</label>

					<div class="col-xs-5">
						<input ng-model="basic.emergencyContact" type="text" class="form-control" placeholder="请输入紧急联系人电话">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">工作单位:</label>

					<div class="col-xs-5">
						<input ng-model="basic.workUnit" type="text" class="form-control" placeholder="请输入工作单位">
					</div>
				</div>
				<div class="form-group">
					<label class="fn-title control-label">职业:</label>

					<div class="col-xs-5">
						<input ng-model="basic.occupation" type="text" class="form-control" placeholder="请输入职业">
					</div>
				</div>
			</div>
			<!-- 家族史 -->
			<div class = "row" ng-show = "selectedTag == 3">
				<div class = "col-sm-12" style = "margin-top: 20px">
					<div class="box-footer">
						<h4 class = "box-title" style = "float: left;">父亲患病情况</h4>
						<button ng-click="add('家族史','父亲患病情况','11');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">母亲患病情况</h4>
						<button ng-click="add('家族史','母亲患病情况','12');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">兄弟姐妹患病情况</h4>
					    <button ng-click="add('家族史','兄弟姐妹患病情况','13');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">子女患病情况</h4>
					    <button ng-click="add('家族史','子女患病情况','14');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">遗传病史</h4>
					    <button ng-click="add('遗传病史','遗传病史','15');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">疾病史</h4>
						<button ng-click="add('疾病史','疾病史','19');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">手术史</h4>
						<button ng-click="add('手术史','手术史','20');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">外伤史</h4>
					    <button ng-click="add('外伤史','外伤史','21');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">输血史</h4>
					    <button ng-click="add('输血史','输血史','22');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">残疾情况</h4>
					    <button ng-click="add('残疾情况','残疾情况','16');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">药物过敏史</h4>
					    <button ng-click="add('过敏史','药物过敏史','17');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">其他过敏史</h4>
					    <button ng-click="add('过敏史','其他过敏史','18');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
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
						<h4 class = "box-title" style = "float: left;">住院史</h4>
					    <button ng-click="add('住院史','住院史','23');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
		            </div>
					<table id="disability"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">病案号</th>
								<th class="sorting">医疗机构名称</th>
								<th class="sorting">住院原因</th>
								<th class="sorting">入院时间</th>	
								<th class="sorting">出院时间</th>
								<th class="sorting">病床号</th>
								<th class="sorting">病床医疗机构名称</th>
								<th class="sorting">建床时间</th>
								<th class="sorting">撤床时间</th>
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
								<td>{{object.bedId}}</td>
								<td>{{object.bedInstitution}}</td>
								<td>{{object.bedCreateTime}}</td>
								<td>{{object.bedDelTime}}</td>
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
						<h4 class = "box-title" style = "float: left;">非免疫预防接种史</h4>
					    <button ng-click="add('非免疫预防接种史','非免疫预防接种史','24');" class="btn btn-info pull-right"
						style="margin: 10px;">新增</button>
		            </div>
					<table id="disability"
					    class="table table-bordered table-hover dataTable" role="grid"
						aria-describedby="example2_info">
						<thead>
							<tr role="row">
								<th class="sorting">非免疫预防接种史名称</th>
								<th class="sorting">非免疫预防接种史日期</th>
								<th class="sorting">非免疫预防接种史机构</th>
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

        <div style="height: 800px; margin-left: auto; margin-right: auto; ">
        		<div style="height: 30px;">
        			<div style="float: left; margin-left: 20px;"><h3 class="box-title ng-binding">相似度分析</h3></div>
        		</div>
        		<div style="width: 100%; height: 750px; display: block;margin-left: auto; margin-right:auto;" id="cy">
        			
        		</div>
        </div>
        
</div>

