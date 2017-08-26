<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="bootstrap-wysihtml5-insert-link-modal modal fade in"
	data-wysihtml5-dialog="createLink"
	style="display: block; padding-right: 17px;">
	<div class="modal-dialog ">
		<div class="modal-content">
			<div class="modal-header skin-blue main-header navbar {{skin}}">
				<a class="close" data-dismiss="modal" ng-click="cancel();"
					style="color: #333;">×</a>
				<h3 style="text-align: center; color: #fff;">{{title}}</h3>
			</div>
			<div class="modal-body" style="display: inline-block;width: 100%; overflow-y: scroll; height: 300px;">
				<div class="form-group" style="width: 100%; padding-left: 40px;">
					<div style="display: block; float: left; width: 50%;"
						ng-repeat="item in roles">
						<div ng-if="!selectRoles.idList || selectRoles.idList.indexOf(item.roleId)==-1" >
							<div style="display: block; float: left;">
								<input ng-click="checkClick($index)"
									id="pb-cb-service{{$index}}" name="service"
									class="jc-query-param-checkbox" type="checkbox"/> <label
									for="pb-cb-service{{$index}}"
									style="width: 30px; height: 30px;"></label>
							</div>
							<div
								style="float: left; font-size: 14px; padding: 0px 20px; font-weight: bold;">{{item.roleName}}</div>
						</div>
						<div ng-if="selectRoles.idList && selectRoles.idList.indexOf(item.roleId)!=-1">
							<div style="display: block; float: left;">
								<input ng-click="checkClick($index)"
									id="pb-cb-service{{$index}}" name="service"
									class="jc-query-param-checkbox" type="checkbox" checked/> <label
									for="pb-cb-service{{$index}}"
									style="width: 30px; height: 30px;"></label>
							</div>
							<div
								style="float: left; font-size: 14px; padding: 0px 20px; font-weight: bold;">{{item.roleName}}</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a class="btn btn-default" data-dismiss="modal"
					data-wysihtml5-dialog-action="cancel" href="" ng-click="cancel();">取消</a>
				<a href="" class="btn btn-primary" data-dismiss="modal"
					data-wysihtml5-dialog-action="save" ng-click="confirm();">确定</a>
			</div>
		</div>
	</div>
</div>