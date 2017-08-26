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
				<div class="form-group" >

					
					<div class="col-xs-6">
						
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='视力残疾';" ng-checked = "object.item == '视力残疾';"
									id="pb-rd-eye" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-eye"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">视力残疾</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='听力残疾';" ng-checked = "object.item == '听力残疾';"
										id="pb-rd-ear" name="pb-rd-sex"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-ear"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">听力残疾</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='言语残疾';" ng-checked = "object.item == '言语残疾';"
									id="pb-rd-talk" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-talk"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">言语残疾</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='肢体残疾';" ng-checked = "object.item == '肢体残疾';"
									id="pb-rd-body" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-body"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">肢体残疾</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='智力残疾';" ng-checked = "object.item == '智力残疾';"
									id="pb-rd-inteligent" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-inteligent"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">智力残疾</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='精神残疾';" ng-checked = "object.item == '精神残疾';"
									id="pb-rd-spirit" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-spirit"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">精神残疾</div>
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
									<input ng-model="object.item" type="text" class="form-control" placeholder="请输入残疾类型">
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