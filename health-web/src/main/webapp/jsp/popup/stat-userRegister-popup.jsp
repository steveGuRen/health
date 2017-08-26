<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="bootstrap-wysihtml5-insert-link-modal modal fade in"
	data-wysihtml5-dialog="createLink"
	style="display: block; padding-right: 17px;">
	<div class="modal-dialog ">
		<form class="css-form" name="addPremiseForm"
			novalidate>
		<div class="modal-content">
			<div class="modal-header skin-blue main-header navbar {{skin}}">
				<a class="close" data-dismiss="modal" ng-click="cancel();"
					style="color: #333;">×</a>
				<h3 style="text-align: center; color: #fff;">用户注册</h3>
			</div>


			
			<div class="modal-body"
				style="display: inline-block; overflow-y: scroll; height: 400px;">

				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">用户账号：</label>

					<div class="col-xs-9">
						<input required type="text" ng-model="object.premisesName" class="form-control" placeholder="请输入楼盘名称">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">用户姓名：</label>

					<div class="col-xs-9">
						<input required type="text" ng-model="object.premisesPosition" class="form-control" placeholder="请输入楼盘地址">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">密码：</label>

					<div class="col-xs-9">
						<input type="text" ng-model="object.developer" class="form-control" placeholder="请输入开发商">
					</div>
				</div>

				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">确认密码：</label>

					<div class="col-xs-9">
						<input ng-pattern="'^[0](\\.\\d{1,2})?$|^[1-9]+\\d*(\\.\\d{1,2})?$'" type="text" ng-model="object.allArea" class="form-control" placeholder="请输入占地面积">
					</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">邮箱地址：</label>

					<div class="col-xs-9">
						<input ng-pattern="'^[0](\\.\\d{1,2})?$|^[1-9]+\\d*(\\.\\d{1,2})?$'" type="text" ng-model="object.greenArea" class="form-control" placeholder="请输入绿地面积">
					</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">手机号码：</label>

					<div class="col-xs-9">
						<input ng-pattern="'^\\d+$'" type="text" ng-model="object.parkingNum" class="form-control" placeholder="请输入停车位">
					</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">所属组织：</label>

					<div class="col-xs-9">
						<input type="text" ng-model="object.premisesDescriptions" class="form-control" placeholder="请输入楼盘描述">
					</div>
				</div>
				<div class="form-group" style="width: 100%;">
					<label class="fn-title control-label" style="width: 101px;">身份证号码：</label>

					<div class="col-xs-9">
						<input required type="text" ng-model="object.premisesCity" class="form-control" placeholder="请输入楼盘描述">
					</div>
					<div class="fn-title control-label" style="width: 10px;font-weight: bold;color: red;font-size: 18px;padding-left: 0px;">*</div>
				</div>

			</div>
			
			<div class="modal-footer">
				<a class="btn btn-default" data-dismiss="modal"
					data-wysihtml5-dialog-action="cancel" href="" ng-click="cancel();">取消</a>
				<a href="" class="btn btn-primary" ng-click="confirm()">确定</a>
			</div>
		</div>
		</form>
	</div>
</div>