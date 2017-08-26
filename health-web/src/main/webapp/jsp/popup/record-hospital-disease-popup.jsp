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

					<label class="fn-title control-label">疾病名称</label>
					<div class="col-xs-6">
						
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='高血压';" ng-checked = "object.disease == '高血压';"
									id="pb-rd-hypertension" name="pb-rd-hypertension"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-hypertension"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">高血压</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='糖尿病';" ng-checked = "object.disease == '糖尿病';"
										id="pb-rd-diabetes" name="pb-rd-diabetes"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-diabetes"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">糖尿病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='冠心病';" ng-checked = "object.disease == '冠心病';"
									id="pb-rd-heartDisease" name="pb-rd-heartDisease"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-heartDisease"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">冠心病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='慢性阻塞性肺疾病';" ng-checked = "object.disease == '慢性阻塞性肺疾病';"
									id="pb-rd-lung" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-lung"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">慢性阻塞性肺疾病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='恶性肿瘤';" ng-checked = "object.disease == '恶性肿瘤';"
									id="pb-rd-cancer" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-cancer"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">恶性肿瘤</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='脑卒中';" ng-checked = "object.disease == '脑卒中';"
									id="pb-rd-stroke" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-stroke"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">脑卒中</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='重性精神疾病';" ng-checked = "object.disease == '重性精神疾病';"
									id="pb-rd-mental" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-mental"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">重性精神疾病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='结核病';" ng-checked = "object.disease == '结核病';"
									id="pb-rd-tuberculosis" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-tuberculosis"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">结核病</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='肝炎';" ng-checked = "object.disease == '肝炎';"
									id="pb-rd-hepatitis" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-hepatitis"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">肝炎</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='先天畸形';" ng-checked = "object.disease == '先天畸形';"
									id="pb-rd-abnormality" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-abnormality"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">先天畸形</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.disease='其他';" 
									id="pb-rd-other" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-other"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">其他</div>
								
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style = "width: 100%">
									<input ng-model="object.disease" type="text" class="form-control" placeholder="">
								</div>
							</div>
						</div>
					</div>
					<label class="fn-title control-label" style = "margin-top: 16px" >确诊时间</label>
					<div class="col-xs-6" style = "margin-top: 16px">
						<div style="display: block; float: left; width: 200px;">
							<div style = "width: 100%">
								<input type="text" ng-model="object.diagnosisTime" class="form-control" id="one-datePay"
								uib-datepicker-popup="yyyy-MM-dd" is-open="isopen3" ng-click="isopen3=!isopen3">
							</div>
						</div>
					</div>
					<label class="fn-title control-label" style = "margin-top: 16px" >是否痊愈</label>
					<div class="col-xs-6" style = "margin-top: 16px">
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.iscured = '是';"
									id="pb-rd-cured" name="pb-rd-cured"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-cured"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">是</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.iscured = '否';"
										id="pb-rd-uncured" name="pb-rd-cured"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-uncured"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">否</div>
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