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
					<label class="fn-title control-label" style = "float: left;">住院病案:</label>
					<div class="col-xs-8">
						<div style="float: left; display: block;width:100%">
							<div style = "width: 100%">
								<input ng-model="object.patientId" type="text" class="form-control" placeholder="请输入住院病案号">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "float: left;">医疗机构:</label>
					<div class="col-xs-8">
						<div style="float: left; display: block;width:100%">
							<div style = "width: 100%">
								<input ng-model="object.institution" type="text" class="form-control" placeholder="请输入医疗机构名称">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "margin-top: 16px;float: left;" >入院时间:</label>
					<div class = "col-xs-8">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%">
								<input type="text" ng-model="object.hospitalInTime" class="form-control" id="hospital-in-date"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen1" ng-click="isopen1=!isopen1">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "float: left;margin-top: 16px" >出院时间:</label>
					<div class = "col-xs-8">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%">
								<input type="text" ng-model="object.hospitalOutTime" class="form-control" id="hospital-out-date"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen2" ng-click="isopen2=!isopen2">
							</div>
						</div>
					</div>
				</div>
				<div class="form-group" style = "width:100%">
					<label class="fn-title control-label" style = "margin-top: 16px;float: left;" >住院原因:</label>
					<div class = "col-xs-8">
						<div style="float: left; display: block;width:100%;margin-top: 16px" >
							<div style = "width: 100%;">
								<textarea ng-model="object.cause" type="text" rows = "6" placeholder="请输入住院原因" style = "width: 100%"></textarea>
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