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

					<div class="col-xs-3">
						
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item= '高血压';" ng-checked = "object.item == '高血压';"
									id="pb-rd-hypertension" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-hypertension"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">高血压</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='糖尿病';" ng-checked = "object.item == '糖尿病';"
										id="pb-rd-diabetes" name="pb-rd-sex"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-diabetes"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">糖尿病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='冠心病';" ng-checked = "object.item == '冠心病';"
									id="pb-rd-heartDisease" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-heartDisease"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">冠心病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='慢性阻塞性肺疾病';" ng-checked = "object.item == '慢性阻塞性肺疾病';"
									id="pb-rd-lung" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-lung"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">慢性阻塞性肺疾病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='恶性肿瘤';" ng-checked = "object.item == '恶性肿瘤';"
									id="pb-rd-cancer" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-cancer"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">恶性肿瘤</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='脑卒中';" ng-checked = "object.item == '脑卒中';"
									id="pb-rd-stroke" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-stroke"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">脑卒中</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='重性精神疾病';" ng-checked = "object.item == '重性精神疾病';"
									id="pb-rd-mental" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-mental"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">重性精神疾病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='结核病';" ng-checked = "object.item == '结核病';"
									id="pb-rd-tuberculosis" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-tuberculosis"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">结核病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='肝炎';"
									id="pb-rd-hepatitis" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-hepatitis"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">肝炎</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='先天畸形';" ng-checked = "object.item == '先天畸形';"
									id="pb-rd-abnormality" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-abnormality"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">先天畸形</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style = "width: 100%">
									<input ng-model="object.item" type="text" class="form-control" placeholder="请输入疾病名称">
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