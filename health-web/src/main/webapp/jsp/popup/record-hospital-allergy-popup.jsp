<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="bootstrap-wysihtml5-insert-link-modal modal fade in"
	data-wysihtml5-dialog="createLink"
	style="display: block; padding-right: 17px;">
	<div class="modal-dialog ">
		<div class="modal-content">
			<div class="modal-header skin-black navbar {{skin}}">
				<a class="close" data-dismiss="modal" ng-click="cancel();"
					style="color: #333;">×</a>
				<h3 style="text-align: center; color: #fff;">{{title}}</h3>
			</div>
			<div class="modal-body"
				style="display: inline-block; overflow-y: scroll; height: 400px; width:100%" >
				<div class="form-group" >

					<label class="fn-title control-label">过敏药物</label>
					<div class="col-xs-6">
						
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='青霉素';" ng-checked = "object.item == '青霉素';"
									id="pb-rd-qing" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-qing"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">青霉素</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='磺胺';" ng-checked = "object.item == '磺胺';"
										id="pb-rd-huang" name="pb-rd-sex"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-huang"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">磺胺</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='链霉素';" ng-checked = "object.item == '链霉素';"
									id="pb-rd-lian" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-lian"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">链霉素</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='其他';"
									id="pb-rd-other" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-other"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">其他</div>
								
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style = "width: 100%">
									<input ng-model="object.item" type="text" class="form-control" placeholder="请输入过敏药物">
								</div>
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