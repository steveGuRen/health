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
				<h3 style="color: #fff;">提示</h3>
			</div>
			<div class="modal-body" style="display: inline-block;padding-left: 20%;width:100%;">
				<label class="fn-title control-label" style="width: 80%;font-size:22px;text-align:center;">{{title}}</label>
			</div>
			<div class="modal-footer">
				<div>
					<a class="btn btn-default"  href="" ng-click="cancel();">取消</a>
					<a class="btn btn-primary"  href="" ng-click="confirm();">确定</a>
				</div>
			</div>
		</div>
	</div>
</div>