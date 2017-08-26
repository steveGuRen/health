<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="bootstrap-wysihtml5-insert-link-modal modal fade in"
	data-wysihtml5-dialog="createLink"
	style="display: block; padding-right: 17px;">
	<div class="modal-dialog " style = "margin:10px auto;padding-left:5%;padding-top:2%">
		<div class="modal-content">
			<div class="modal-header skin-black navbar {{skin}}">
				<a class="close" data-dismiss="modal" ng-click="cancel();"
					style="color: #333;">×</a>
				<h3 style="text-align: center; color: #fff;">{{title}}</h3>
			</div>
			<div class="modal-body"
				style="display: inline-block; overflow-y: scroll; height: 300px; width:100%" >
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "float: left;">外伤名称:</label>
					<div class="col-xs-8">
						<div style="float: left; display: block;width:100%">
							<div style = "width: 100%">
								<input ng-model="object.injuryName" type="text" class="form-control" placeholder="请输入外伤名称">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "margin-top: 16px;float: left;" >外伤时间:</label>
					<div class = "col-xs-8">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%">
								<input type="text" ng-model="object.injuryTime" class="form-control" id="one-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen3" ng-click="isopen3=!isopen3">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "margin-top: 16px;float: left;" >外伤描述:</label>
					<div class = "col-xs-8">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%;">
								<textarea ng-model="object.injuryDescription" type="text" rows = "6" placeholder="请输入描述" style = "width: 100%"></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<a class="btn btn-default" href="" ng-click="cancel();">取消</a>
				<a href="" class="btn btn-primary" ng-click="confirm()">确定</a>
			</div>
		</div>
	</div>
</div>