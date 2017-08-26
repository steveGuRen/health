<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<meta name="full-screen" content="yes">
<link href="<%=request.getContextPath()%>/common/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/common/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/example.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/weui.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/phone.css"
	rel="stylesheet">
<title>个人病史</title>

<style type="text/css">
@charset "UTF-8";
[ng\:cloak],
[ng-cloak],[data-ng-cloak],
[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide
:not(.ng-hide-animate){
display:none!important;
}
</style>
<style type="text/css">
.page {
	width: 100%;
	height: 100%;
	margin-left: 16px;
	margin-right: 16px;
}

.wximg {
	background: url(/images/weixin/wxicon1.png) no-repeat;
	width: 38px;
	text-align: left;
	display: inline-table;
	font-size: 14px;
	height: 31px;
	background-size: cover;
	float: left;
	margin: 2px 8px 0 0;
}

.wxtxt {
	text-align: left;
	display: block;
	font-size: 14px;
	height: 31px;
	padding-left: 5px;
}

.pop-content {
	padding: 0 25px;
	margin: auto;
}

.pop-content1 {
	padding: 0 10px;
	position: relative;
}

.pop-title {
	padding: 15px 0;
	font-size: 18px;
	color: #222222;
	text-align: center;
	font-family: 'Microsoft Yahei';
}

.con_p {
	color: #666666;
	margin: 0;
	padding: 0 18px;
}

.popup {
	width: 300px;
	background-color: #fff;
	border-radius: 4px;
	margin: auto;
	position: absolute;
	z-index: 9999;
	overflow: hidden;
	padding-bottom: 20px;
}

.login {
	text-align: center;
	background-color: #42B917;
	border-radius: 3px;
	font-size: 18px;
	line-height: 24px;
	padding: 11px 0;
	display: block;
	width: 100%;
	text-decoration: none;
	position: relative;
	z-index: 9999;
	vertical-align: middle;
}

.login p {
	margin: auto;
	width: 150px;
	display: block;
}

.login i {
	width: 31px;
	height: 25px;
	background: url(/images/weixin/wxicon.png) 0 0 no-repeat;
	display: inline-table;
	background-size: cover;
	margin-right: 5px;
	float: left;
}

.login span {
	height: 24px;
	display: block;
	color: #fff !important;
}

.jump {
	text-decoration: none;
	color: #666666;
	text-align: right;
	display: block;
	font-size: 16px;
	padding: 20px 0 0 0;
	cursor: pointer;
}
</style>
</head>
<body style = "background:#ffffff;" ng-app="question" ng-controller="questionItemCtrl">
		<div class="row" style="padding-right: 30px">
			<div class="page" style="font-family: Microsoft YaHei;">
				<div id="page-content" ng-show="!listPage">
					<div class="weui_cells">

						<div class="weui_cell" ng-click="clickList('家族史')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>家族史</p>
							</div>
							<div class="weui_cell_ft">
								<p></p>
							</div>
						</div>
						<div class="weui_cell" ng-click="clickList('遗传病史')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>遗传病史</p>
							</div>
							<div class="weui_cell_ft">
								<p></p>
							</div>
						</div>
						<div class="weui_cell" ng-click="clickList('既往史')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>既往史</p>
							</div>
							<div class="weui_cell_ft">
								<p></p>
							</div>
						</div>
						<div class="weui_cell" ng-click="clickList('残疾情况')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>残疾情况</p>
							</div>
							<div class="weui_cell_ft">
								<p></p>
							</div>
						</div>
						<div class="weui_cell" ng-click="clickList('过敏史')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>过敏史</p>
							</div>
							<div class="weui_cell_ft">
								<p></p>
							</div>
						</div>
						<div class="weui_cell" ng-click="clickList('住院史')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>住院史</p>
							</div>
							<div class="weui_cell_ft" >
								<p></p>
							</div>
						</div>
						<div class="weui_cell" ng-click="clickList('非免疫预防接种史')">
							<div class="weui_cell_bd weui_cell_primary">
								<p>非免疫预防接种史</p>
							</div>
							<div class="weui_cell_ft" >
								<p></p>
							</div>
						</div>
					</div>
				</div>
				<div ng-if="recordDetail" id="page-add" ng-cloak>
					<div class="box box-info form-horizontal">

						<div class="box-body" style="width: 100%; display: block">
							<!-- 家族史 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 3">
							<div class="field-label">
								1. 父亲患病情况 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio ">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='高血压';" ng-checked = "father.item == '高血压';"
										value="1" id="pb-hypertension-1" name="q2"  /></span> <label
										for="pb-hypertension-1">高血压</label>
								</div>
								
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='糖尿病';" ng-checked = "father.item == '糖尿病';"
										value="2" id="pb-rd-diabetes-1" name="q2"  /></span> <label for="pb-rd-diabetes-1">糖尿病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='冠心病';" 
									ng-checked = "father.item == '冠心病'" value="3" id="pb-rd-heartDisease-1" name="q2"  /></span> <label for="pb-rd-heartDisease-1">冠心病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='慢性阻塞性肺疾病';" ng-checked = "father.item == '慢性阻塞性肺疾病';"
										value="3" id="pb-rd-lung-1" name="q2"    
										  > </span> <label for="pb-rd-lung-1">慢性阻塞性肺疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='恶性肿瘤';" ng-checked = "father.item == '恶性肿瘤'"
										value="3" id="pb-rd-cancer-1" name="q2"    
										  > </span> <label for="pb-rd-cancer-1">恶性肿瘤</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='脑卒中';" ng-checked = "father.item == '脑卒中'"
										value="3" id="pb-rd-stroke-1" name="q2"    
										  > </span> <label for="pb-rd-stroke-1">脑卒中</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='重性精神疾病'" ng-checked = "father.item == '重性精神疾病'"
										value="3" id="pb-rd-mental-1" name="q2"    
										  > </span> <label for="pb-rd-mental-1">重性精神疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='结核病'" ng-checked = "father.item == '结核病'"
										value="3" id="pb-rd-tuberculosis-1" name="q2"    
										  > </span> <label for="pb-rd-tuberculosis-1">结核病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='肝炎'" ng-checked = "father.item == '肝炎'"
										value="3" id="pb-rd-hepatitis-1" name="q2"    
										  ng-click = "father.item ='肝炎'" ng-checked = "father.item == '肝炎'"> </span> <label for="pb-rd-hepatitis-1">肝炎</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio" ng-click = "father.item ='先天畸形'" ng-checked = "father.item == '先天畸形'"
										value="3" id="pb-rd-abnormality-1" name="q2"    
										  > </span> <label for="pb-rd-abnormality-1">先天畸形</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
									ng-click = "father.item = '其他';father.otherDisease = '其他';" ng-checked = "father.item == '其他'"
										value="4" id="pb-rd-other-1" name="q2" rel="tqq2_4"
										   
										> </span> <label for="pb-rd-other-1"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" id="tqq2_4"
											class="OtherRadioText" ng-model = "father.otherDisease"/>
									</div>
									<br />
								</div>
								<div class="ui-radio">
								<button ng-click="skipToAdd('父亲患病情况');"
									class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
								<button ng-click="update('家族史','父亲患病情况');" class="btn btn-info pull-right"
									style="margin: 10px;">保存</button>
								<br />
						    </div>
							</div>
                            
							<div class="field-label">
								2. 母亲患病情况 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-hypertension-2" name="q2"    
										class="jqradio jqchecked" ng-click = "mother.item ='高血压' " ng-checked = "mother.item =='高血压'"> </span> <label
										for="pb-hypertension-2">高血压</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-diabetes-2" name="q2"    
										  ng-click = "mother.item ='糖尿病'" ng-checked = "mother.item == '糖尿病'"> </span> <label for="pb-rd-diabetes-2">糖尿病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-heartDisease-2" name="q2"    
										  ng-click = "mother.item ='冠心病'" ng-checked = "mother.item == '冠心病'"> </span> <label for="pb-rd-heartDisease-2">冠心病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-lung-2" name="q2"    
										  ng-click = "mother.item ='慢性阻塞性肺疾病'" ng-checked = "mother.item == '慢性阻塞性肺疾病'"> </span> <label for="pb-rd-lung-2">慢性阻塞性肺疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-cancer-2" name="q2"    
										  ng-click = "mother.item ='恶性肿瘤'" ng-checked = "mother.item == '恶性肿瘤'"> </span> <label for="pb-rd-cancer-2">恶性肿瘤</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-stroke-2" name="q2"    
										  ng-click = "mother.item ='脑卒中'" ng-checked = "mother.item == '脑卒中'"> </span> <label for="pb-rd-stroke-2">脑卒中</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mental-2" name="q2"    
										  ng-click = "mother.item ='重性精神疾病'" ng-checked = "mother.item == '重性精神疾病'"> </span> <label for="pb-rd-mental-2">重性精神疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-tuberculosis-2" name="q2"    
										  ng-click = "mother.item ='结核病'" ng-checked = "mother.item == '结核病'"> </span> <label for="pb-rd-tuberculosis-2">结核病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-hepatitis-2" name="q2"    
										  ng-click = "mother.item ='肝炎'" ng-checked = "mother.item == '肝炎'"> </span> <label for="pb-rd-hepatitis-2">肝炎</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-abnormality-2" name="q2"    
										  ng-click = "mother.item ='先天畸形'" ng-checked = "mother.item == '先天畸形'"> </span> <label for="pb-rd-abnormality-2">先天畸形</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-2" name="q2" rel="tqq2_4"
										   
										ng-click = "mother.item = '其他';mother.otherDisease = '其他';" ng-checked = "mother.item == '其他'"> </span> <label for="pb-rd-other-2"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" id="tqq2_4"
											class="OtherRadioText" ng-model = "mother.otherDisease"/>
									</div>
									<br />
								</div>
								<div class="ui-radio">
									<button ng-click="skipToAdd('母亲患病情况');"
										class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
									<button ng-click="update('家族史','母亲患病情况');"
										class="btn btn-info pull-right" style="margin: 10px;">保存</button>
								</div>
							</div>
							
							<div class="field-label">
								3. 兄弟姐妹患病情况 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-hypertension-3" name="q2"    
										class="jqradio jqchecked" ng-click = "brother.item ='高血压' " ng-checked = "brother.item =='高血压'"> </span> <label
										for="pb-hypertension-3">高血压</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-diabetes-3" name="q2"    
										  ng-click = "brother.item ='糖尿病'" ng-checked = "brother.item == '糖尿病'"> </span> <label for="pb-rd-diabetes-3">糖尿病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-heartDisease-3" name="q2"    
										  ng-click = "brother.item ='冠心病'" ng-checked = "brother.item == '冠心病'"> </span> <label for="pb-rd-heartDisease-3">冠心病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-lung-3" name="q2"    
										  ng-click = "brother.item ='慢性阻塞性肺疾病'" ng-checked = "brother.item == '慢性阻塞性肺疾病'"> </span> <label for="pb-rd-lung-3">慢性阻塞性肺疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-cancer-3" name="q2"    
										  ng-click = "brother.item ='恶性肿瘤'" ng-checked = "brother.item == '恶性肿瘤'"> </span> <label for="pb-rd-cancer-3">恶性肿瘤</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-stroke-3" name="q2"    
										  ng-click = "brother.item ='脑卒中'" ng-checked = "brother.item == '脑卒中'"> </span> <label for="pb-rd-stroke-3">脑卒中</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mental-3" name="q2"    
										  ng-click = "brother.item ='重性精神疾病'" ng-checked = "brother.item == '重性精神疾病'"> </span> <label for="pb-rd-mental-3">重性精神疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-tuberculosis-3" name="q2"    
										  ng-click = "brother.item ='结核病'" ng-checked = "brother.item == '结核病'"> </span> <label for="pb-rd-tuberculosis-3">结核病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-hepatitis-3" name="q2"    
										  ng-click = "brother.item ='肝炎'" ng-checked = "brother.item == '肝炎'"> </span> <label for="pb-rd-hepatitis-3">肝炎</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-abnormality-3" name="q2"    
										  ng-click = "brother.item ='先天畸形'" ng-checked = "brother.item == '先天畸形'"> </span> <label for="pb-rd-abnormality-3">先天畸形</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-3" name="q2" rel="tqq2_4"
										   
										ng-click = "brother.item = '其他';brother.otherDisease = '其他'" ng-checked = "brother.item == '其他'"> </span> <label for="pb-rd-other-3"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" id="tqq2_4"
											class="OtherRadioText" ng-model = "brother.otherDisease"/>
									</div>
									<br />
								</div>
								<div class="ui-radio">
									<button ng-click="skipToAdd('兄弟姐妹患病情况');"
										class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
									<button ng-click="update('家族史','兄弟姐妹患病情况');"
										class="btn btn-info pull-right" style="margin: 10px;">保存</button>
								</div>
							</div>
							
							<div class="field-label">
								4. 子女患病情况 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-hypertension-4" name="q2"    
										class="jqradio jqchecked" ng-click = "children.item ='高血压' " ng-checked = "children.item =='高血压'"> </span> <label
										for="pb-hypertension-4">高血压</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-diabetes-4" name="q2"    
										  ng-click = "children.item ='糖尿病'" ng-checked = "children.item == '糖尿病'"> </span> <label for="pb-rd-diabetes-4">糖尿病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-heartDisease-4" name="q2"    
										  ng-click = "children.item ='冠心病'" ng-checked = "children.item == '冠心病'"> </span> <label for="pb-rd-heartDisease-4">冠心病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-lung-4" name="q2"    
										  ng-click = "children.item ='慢性阻塞性肺疾病'" ng-checked = "children.item == '慢性阻塞性肺疾病'"> </span> <label for="pb-rd-lung-4">慢性阻塞性肺疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-cancer-4" name="q2"    
										  ng-click = "children.item ='恶性肿瘤'" ng-checked = "children.item == '恶性肿瘤'"> </span> <label for="pb-rd-cancer-4">恶性肿瘤</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-stroke-4" name="q2"    
										  ng-click = "children.item ='脑卒中'" ng-checked = "children.item == '脑卒中'"> </span> <label for="pb-rd-stroke-4">脑卒中</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mental-4" name="q2"    
										  ng-click = "children.item ='重性精神疾病'" ng-checked = "children.item == '重性精神疾病'"> </span> <label for="pb-rd-mental-4">重性精神疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-tuberculosis-4" name="q2"    
										  ng-click = "children.item ='结核病'" ng-checked = "children.item == '结核病'"> </span> <label for="pb-rd-tuberculosis-4">结核病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-hepatitis-4" name="q2"    
										  ng-click = "children.item ='肝炎'" ng-checked = "children.item == '肝炎'"> </span> <label for="pb-rd-hepatitis-4">肝炎</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-abnormality-4" name="q2"    
										  ng-click = "children.item ='先天畸形'" ng-checked = "children.item == '先天畸形'"> </span> <label for="pb-rd-abnormality-4">先天畸形</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-4" name="q2" rel="tqq2_4"
										ng-click = "children.item = '其他';children.otherDisease = '其他'" ng-checked = "children.item == '其他'"> </span> <label for="pb-rd-other-4"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" id="tqq2_4"
											class="OtherRadioText" ng-model = "children.otherDisease"/>
									</div>
									<br />
								</div>
								<div class="ui-radio">
									<button ng-click="skipToAdd();"
										class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
									<button ng-click="update('家族史','子女患病情况');"
										class="btn btn-info pull-right" style="margin: 10px;">保存</button>
								</div>
							</div>
						</div>
						<!-- 遗传病史 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 4">
							<div class="field-label">
								1. 遗传病史 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-hypertension-5" name="q2"    
										class="jqradio jqchecked" ng-click = "genetic.item ='高血压' " ng-checked = "genetic.item =='高血压'"> </span> <label
										for="pb-hypertension-5">高血压</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-diabetes-5" name="q2"    
										  ng-click = "genetic.item ='糖尿病'" ng-checked = "genetic.item == '糖尿病'"> </span> <label for="pb-rd-diabetes-5">糖尿病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-heartDisease-5" name="q2"    
										  ng-click = "genetic.item ='冠心病'" ng-checked = "genetic.item == '冠心病'"> </span> <label for="pb-rd-heartDisease-5">冠心病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-lung-5" name="q2"    
										  ng-click = "genetic.item ='慢性阻塞性肺疾病'" ng-checked = "genetic.item == '慢性阻塞性肺疾病'"> </span> <label for="pb-rd-lung-5">慢性阻塞性肺疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-cancer-5" name="q2"    
										  ng-click = "genetic.item ='恶性肿瘤'" ng-checked = "genetic.item == '恶性肿瘤'"> </span> <label for="pb-rd-cancer-5">恶性肿瘤</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-stroke-5" name="q2"    
										  ng-click = "genetic.item ='脑卒中'" ng-checked = "genetic.item == '脑卒中'"> </span> <label for="pb-rd-stroke-5">脑卒中</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mental-5" name="q2"    
										  ng-click = "genetic.item ='重性精神疾病'" ng-checked = "genetic.item == '重性精神疾病'"> </span> <label for="pb-rd-mental-5">重性精神疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-tuberculosis-5" name="q2"    
										  ng-click = "genetic.item ='结核病'" ng-checked = "genetic.item == '结核病'"> </span> <label for="pb-rd-tuberculosis-5">结核病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-hepatitis-5" name="q2"    
										  ng-click = "genetic.item ='肝炎'" ng-checked = "genetic.item == '肝炎'"> </span> <label for="pb-rd-hepatitis-5">肝炎</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-abnormality-5" name="q2"    
										  ng-click = "genetic.item ='先天畸形'" ng-checked = "genetic.item == '先天畸形'"> </span> <label for="pb-rd-abnormality-5">先天畸形</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-5" name="q2" rel="tqq2_4"
										   
										ng-click = "genetic.item = '其他';genetic.otherDisease = '其他'" ng-checked = "genetic.item == '其他'"> </span> <label for="pb-rd-other-5"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" id="tqq2_4"
											class="OtherRadioText" ng-model = "genetic.otherDisease"/>
									</div>
									<br />
								</div>
								<div class="ui-radio">
									<button ng-click="skipToAdd();"
										class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
									<button ng-click="update('遗传病史','遗传病史');"
										class="btn btn-info pull-right" style="margin: 10px;">保存</button>
								</div>
							</div>
						</div>
						<!-- 既往史 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 5">
							<h1 class="field-label">疾病史</h1>
							<div class="field-label">
								1. 疾病名称 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio ">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-hypertension-6" name="q2"    
										class="jqradio jqchecked" ng-click = "disease.item ='高血压' " ng-checked = "disease.item =='高血压'"> </span> <label
										for="pb-hypertension-6">高血压</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-diabetes-6" name="q2"    
										  ng-click = "disease.item ='糖尿病'" ng-checked = "disease.item == '糖尿病'"> </span> <label for="pb-rd-diabetes-6">糖尿病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-heartDisease-6" name="q2"    
										  ng-click = "disease.item ='冠心病'" ng-checked = "disease.item == '冠心病'"> </span> <label for="pb-rd-heartDisease-6">冠心病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-lung-6" name="q2"    
										  ng-click = "disease.item ='慢性阻塞性肺疾病'" ng-checked = "disease.item == '慢性阻塞性肺疾病'"> </span> <label for="pb-rd-lung-6">慢性阻塞性肺疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-cancer-6" name="q2"    
										  ng-click = "disease.item ='恶性肿瘤'" ng-checked = "disease.item == '恶性肿瘤'"> </span> <label for="pb-rd-cancer-6">恶性肿瘤</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-stroke-6" name="q2"    
										  ng-click = "disease.item ='脑卒中'" ng-checked = "disease.item == '脑卒中'"> </span> <label for="pb-rd-stroke-6">脑卒中</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mental-6" name="q2"    
										  ng-click = "disease.item ='重性精神疾病'" ng-checked = "disease.item == '重性精神疾病'"> </span> <label for="pb-rd-mental-6">重性精神疾病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-tuberculosis-6" name="q2"    
										  ng-click = "disease.item ='结核病'" ng-checked = "disease.item == '结核病'"> </span> <label for="pb-rd-tuberculosis-6">结核病</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-hepatitis-6" name="q2"    
										  ng-click = "disease.item ='肝炎'" ng-checked = "disease.item == '肝炎'"> </span> <label for="pb-rd-hepatitis-6">肝炎</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-abnormality-6" name="q2"    
										  ng-click = "disease.item ='先天畸形'" ng-checked = "disease.item == '先天畸形'"> </span> <label for="pb-rd-abnormality-6">先天畸形</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-6" name="q2" rel="tqq2_4"
										ng-click = "disease.item = '其他';disease.otherDisease = '其他';" ng-checked = "disease.item == '其他'"> </span> <label for="pb-rd-other-6"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" id="tqq2_4"
											class="OtherRadioText" ng-model = "disease.otherDisease"/>
									</div>
									<br />
								</div>
							</div>
							<div class="field-label">
								2. 疾病确诊时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="disease.diagnosisTime"
									class="form-control" id="one-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen1"
									ng-click="isopen1=!isopen1">
							</div>
							<div class="field-label">
								3. 是否痊愈 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="q9_1" name="q9"    
										class="jqradio jqchecked" ng-click = "disease.iscured = '是'" ng-checked = "disease.iscured == '是'"> </span> <label
										for="q9_1">是</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="q9_2" name="q9"    
										  ng-click = "disease.iscured = '否'" ng-checked = "disease.iscured == '否'"> </span> <label for="q9_2">否</label>
								</div>
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd('疾病史');"
									class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
								<button ng-click="update('疾病史','疾病史');"
									class="btn btn-info pull-right" style="margin: 10px;">保存</button>
							</div>
							<h1 class="field-label" style = "margin-top:48px">手术史</h1>
							<div class="field-label">
								1. 手术名称 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model = "surgery.operationName" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								2. 手术时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="surgery.operationTime"
									class="form-control" id="two-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen2"
									ng-click="isopen2=!isopen2">
							</div>
							<div class="field-label">
								3. 诊断结果 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<textarea rows="5" style="max-height: 100px;" id="q8" name="q8"
									ng-model = "surgery.operationResult"></textarea>
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd('手术史');"
									class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
								<button ng-click="update('手术史','手术史');" class="btn btn-info pull-right"
									style="margin: 10px;">保存</button>
						    </div>
							<h1 class="field-label" style = "margin-top:48px">外伤史</h1>
							<div class="field-label">
								1. 外伤名称 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model = "injury.injuryName" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								2. 外伤时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="injury.injuryTime"
									class="form-control" id="three-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen3"
									ng-click="isopen3=!isopen3">
							</div>
							<div class="field-label">
								3. 外伤描述 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<textarea rows="5" style="max-height: 100px;" id="q8" name="q8"
									ng-model ="injury.injuryDescription"></textarea>
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd('外伤史');"
									class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
								<button ng-click="update('外伤史','外伤史');" class="btn btn-info pull-right"
									style="margin: 10px;">保存</button>
						    </div>
							<h1 class="field-label" style = "margin-top:48px">输血史</h1>
							<div class="field-label">
								1. 输血量(ml) <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model = "transfusion.bloodTransfusion" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								2. 输血时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="transfusion.transfusionTime"
									class="form-control" id="four-datePay"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen4"
									ng-click="isopen4=!isopen4">
							</div>
							<div class="field-label">
								3. 输血原因 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<textarea rows="5" style="max-height: 100px;" id="q8" name="q8"
									ng-model = "transfusion.cause"></textarea>
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd();"
									class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
								<button ng-click="update('输血史','输血史');" class="btn btn-info pull-right"
									style="margin: 10px;">保存</button>
						     </div>
						</div>
						
						<!-- 残疾情况 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 6">
							<h1 class="field-label">残疾情况</h1>
							<div class="field-label">
								1. 残疾情况 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-rd-eye" name="q2"    
										ng-click="disability.item = '视力残疾';" ng-checked = "disability.item == '视力残疾';"> </span> <label
										for="pb-rd-eye">视力残疾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-ear" name="q2"    
										  ng-click="disability.item = '听力残疾';" ng-checked = "disability.item == '听力残疾';"> </span> <label for="pb-rd-ear">听力残疾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-talk" name="q2"    
										  ng-click="disability.item = '言语残疾';" ng-checked = "disability.item == '言语残疾';"> </span> <label for="pb-rd-talk">言语残疾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-body" name="q2"    
										  ng-click="disability.item = '肢体残疾';" ng-checked = "disability.item == '肢体残疾';"> </span> <label for="pb-rd-body">肢体残疾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-inteligent" name="q2"    
										  ng-click="disability.item = '智力残疾';" ng-checked = "disability.item == '智力残疾';"> </span> <label for="pb-rd-inteligent">智力残疾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-spirit" name="q2"    
										  ng-click="disability.item = '精神残疾';" ng-checked = "disability.item == '精神残疾';"> </span> <label for="pb-rd-spirit">精神残疾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-disability" name="q2" rel="tqq2_4"
										ng-click="disability.item = '其他';disability.otherDisease = '其他';" ng-checked = "disability.item == '其他';"> </span> <label for="pb-rd-other-disability"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text"   id="tqq2_4"
											class="OtherRadioText" ng-model = "disability.otherDisease"/>
									</div>
									<br />
								</div>
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd();"
									class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
								<button ng-click="update('残疾情况','残疾情况');" class="btn btn-info pull-right"
									style="margin: 10px;">保存</button>
						     </div>
						</div>
					
						<!-- 过敏史 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 7">
							<h1 class="field-label">过敏史</h1>
							<div class="field-label">
								1. 过敏药物 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-rd-qing" name="q2"    
										class="jqradio jqchecked" ng-click="allergy.item='青霉素';" ng-checked = "allergy.item == '青霉素';"> </span> <label
										for="pb-rd-qing">青霉素</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-huang" name="q2"    
										  ng-click="allergy.item='磺胺';" ng-checked = "allergy.item == '磺胺';"> </span> <label for="pb-rd-huang">磺胺</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-lian" name="q2"    
										  ng-click="allergy.item='链霉素';" ng-checked = "allergy.item == '链霉素';"> </span> <label for="pb-rd-lian">链霉素</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-allergy" name="q2" rel="tqq2_4"
										ng-click="allergy.item='其他';allergy.otherItem = '其他';" ng-checked = "allergy.item == '其他';"> </span> <label for="pb-rd-other-allergy"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text" ng-model = "allergy.otherItem" id="tqq2_4"
											class="OtherRadioText" />
									</div>
									<br />
								</div>
							</div>
							<div class="ui-radio" style = "margin-bottom:48px">
								<button ng-click="skipToAdd('药物过敏史');"
									class="btn btn-cancel pull-right" style="margin: 10px;">取消</button>
								<button ng-click="update('过敏史','药物过敏史');"
									class="btn btn-info pull-right" style="margin: 10px;">保存</button>
							</div>
							<div class="field-label" >
								2. 过敏物质 <span class="req">*</span>
							</div>
							<div class="ui-controlgroup">
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="1" id="pb-rd-seafood" name="q2"    
										class="jqradio jqchecked" ng-click="allergen.item='海鲜';" ng-checked = "allergen.item == '海鲜';"> </span> <label
										for="pb-rd-seafood">海鲜</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="2" id="pb-rd-fish" name="q2"    
										  ng-click="allergen.item='鱼虾';" ng-checked = "allergen.item == '鱼虾';"> </span> <label for="pb-rd-fish">鱼虾</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-pork" name="q2"    
										  ng-click="allergen.item='猪肉';" ng-checked = "allergen.item == '猪肉';"> </span> <label for="pb-rd-pork">猪肉</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-beef" name="q2"    
										  ng-click="allergen.item='牛羊肉';" ng-checked = "allergen.item == '牛羊肉';"> </span> <label for="pb-rd-beef">牛羊肉</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-chocolate" name="q2"    
										  ng-click="allergen.item='巧克力';" ng-checked = "allergen.item == '巧克力';"> </span> <label for="pb-rd-chocolate">巧克力</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-pineapple" name="q2"    
										  ng-click="allergen.item='菠萝';" ng-checked = "allergen.item == '菠萝';"> </span> <label for="pb-rd-pineapple">菠萝</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-pawpaw" name="q2"    
										  ng-click="allergen.item='木瓜';" ng-checked = "allergen.item == '木瓜';"> </span> <label for="pb-rd-pawpaw">木瓜</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-buckwheat" name="q2"    
										  ng-click="allergen.item='荞麦';" ng-checked = "allergen.item == '荞麦';"> </span> <label for="pb-rd-buckwheat">荞麦</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-sunflower" name="q2"    
										  ng-click="allergen.item='葵花籽';" ng-checked = "allergen.item == '葵花籽';"> </span> <label for="pb-rd-sunflower">葵花籽</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mango" name="q2"    
										  ng-click="allergen.item='芒果';" ng-checked = "allergen.item == '芒果';"> </span> <label for="pb-rd-mango">芒果</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mustard" name="q2"    
										  ng-click="allergen.item='芥末';" ng-checked = "allergen.item == '芥末';"> </span> <label for="pb-rd-mustard">芥末</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-peanuts" name="q2"    
										  ng-click="allergen.item='花生';" ng-checked = "allergen.item == '花生';"> </span> <label for="pb-rd-peanuts">花生</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-milk" name="q2"    
										  ng-click="allergen.item='牛奶';" ng-checked = "allergen.item == '牛奶';"> </span> <label for="pb-rd-milk">牛奶</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-egg" name="q2"    
										  ng-click="allergen.item='鸡蛋';" ng-checked = "allergen.item == '鸡蛋';"> </span> <label for="pb-rd-egg">鸡蛋</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-tomatoes" name="q2"    
										  ng-click="allergen.item='番茄';" ng-checked = "allergen.item == '番茄';"> </span> <label for="pb-rd-tomatoes">番茄</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-alcohol" name="q2"    
										  ng-click="allergen.item='酒精';" ng-checked = "allergen.item == '酒精';"> </span> <label for="pb-rd-alcohol">酒精</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-paint" name="q2"    
										  ng-click="allergen.item='油漆';" ng-checked = "allergen.item == '油漆';"> </span> <label for="pb-rd-paint">油漆</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-pollen" name="q2"    
										  ng-click="allergen.item='花粉';" ng-checked = "allergen.item == '花粉';"> </span> <label for="pb-rd-pollen">花粉</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-dust" name="q2"    
										  ng-click="allergen.item='粉尘';" ng-checked = "allergen.item == '粉尘';"> </span> <label for="pb-rd-dust">粉尘</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="3" id="pb-rd-mycete" name="q2"    
										  ng-click="allergen.item='霉菌';" ng-checked = "allergen.item == '霉菌';"> </span> <label for="pb-rd-mycete">霉菌</label>
								</div>
								<div class="ui-radio">
									<span class="jqradiowrapper"><input class = "jc-query-param-checkbox" type="radio"
										value="4" id="pb-rd-other-allergen" name="q2" rel="tqq2_4"
										ng-click="allergen.item='其他';allergen.otherItem = '其他';" ng-checked = "allergen.item == '其他';"> </span> <label for="pb-rd-other-allergen"
										style="border-bottom: none;">其他</label>
									<div class="ui-text">
										<input type="text"   id="tqq2_4"
											class="OtherRadioText" ng-model = "allergen.otherItem" />
									</div>
									<br />
								</div>
							</div>
	                        <div class="ui-radio">
								<button ng-click="skipToAdd();"
									class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
								<button ng-click="update('过敏史','其他过敏史');"
									class="btn btn-info pull-right" style="margin: 10px;">保存</button>
							</div>
						</div>
						
						<!-- 住院史 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 10">
							<h1 class="field-label">住院史</h1>
							<div class="field-label">
								1. 住院病案号 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model="hospital.patientId" rel="q7_4" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								2. 医疗机构名称 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model="hospital.institution" rel="q7_4" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								3. 入院时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="hospital.hospitalInTime"
									class="form-control" id="hospital-in-date"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen5"
									ng-click="isopen5=!isopen5">
							</div>
							<div class="field-label">
								4. 出院时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="hospital.hospitalOutTime"
									class="form-control" id="hospital-out-date"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen6"
									ng-click="isopen6=!isopen6">
							</div>
							<div class="field-label">
								5. 病床病案号 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model="hospital.bedId" rel="q7_4" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								6. 建床医疗机构名称 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model="hospital.bedInstitution" rel="q7_4" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								7. 建床时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="hospital.bedCreateTime"
									class="form-control" id="bed-create-date"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen7"
									ng-click="isopen7=!isopen7">
							</div>
							<div class="field-label">
								8. 撤床时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="hospital.bedDelTime"
									class="form-control" id="bed-del-date"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen8"
									ng-click="isopen8=!isopen8">
							</div>
							<div class="field-label">
								9. 住院原因 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<textarea rows="5" ng-model="hospital.cause" style="max-height: 100px;" id="q8" name="q8"
									value=""></textarea>
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd();"
									class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
								<button ng-click="update('住院史','住院史');"
									class="btn btn-info pull-right" style="margin: 10px;">保存</button>
							</div>
						</div>
						
						<!-- 非免疫预防接种史 -->
						<div class="field ui-field-contain" ng-show="selectedTag == 11">
							<h1 class="field-label">非免疫预防接种史</h1>
							<div class="field-label">
								1. 非免疫规划预防接种名称 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model="immunization.immunizationName" rel="q7_4" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="field-label">
								2. 非免疫规划预防接种时间 <span class="req">*</span>
							</div>
							<div class="input-group">
								<input type="text" ng-model="immunization.immunizationDate"
									class="form-control" id="immunization"
									uib-datepicker-popup="yyyy-MM-dd" is-open="isopen9"
									ng-click="isopen9=!isopen9">
							</div>
							<div class="field-label">
								3. 非免疫规划预防接种机构 <span class="req">*</span>
							</div>
							<div class="ui-input-text">
								<input type="text" ng-model="immunization.immunizationInstitution" rel="q7_4" id="tqq7_4" class="OtherRadioText" />
							</div>
							<div class="box-footer">
								<button ng-click="skipToAdd();"
									class="btn btn-cancel pull-right" style="margin: 10px;">返回</button>
								<button ng-click="update('非免疫预防接种史','非免疫预防接种史');"
									class="btn btn-info pull-right" style="margin: 10px;">保存</button>
							</div>
						</div>
						
						</div>
					</div>
				</div>
			<div id="toast" ng-if="success" ng-cloak>
				<div class="weui_mask_transparent"></div>
				<div class="weui_toast">
					<i class="weui_icon_toast"></i>
					<p class="weui_toast_content">已完成</p>
				</div>
			</div>
			<div id="toast" ng-if="fail" ng-cloak>
				<div class="weui_mask_transparent"></div>
				<div class="weui_toast_forbidden">
					<i class="weui_icon_toast"></i>
					<p class="weui_toast_content">请求失败</p>
				</div>
			</div>
			<!-- 弹出提交数据loading toast -->
			<div id="loadingToast" class="weui_loading_toast"  ng-if = "loading" ng-cloak>
    			<div class="weui_mask"></div>
    			<div class="weui_toast">
        			<div class="weui_loading">
            			<div class="weui_loading_leaf weui_loading_leaf_0"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_1"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_2"></div>
           				<div class="weui_loading_leaf weui_loading_leaf_3"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_4"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_5"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_6"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_7"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_8"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_9"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_10"></div>
            			<div class="weui_loading_leaf weui_loading_leaf_11"></div>
        			</div>
        			<p class="weui_toast_content">提交中</p>
    			</div>
			</div>
		</div>
	

	<script src="<%=request.getContextPath()%>/common/js/angular.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/common/js/ui-bootstrap-tpls.min.js"></script>
	<script src="<%=request.getContextPath()%>/common/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/common/js/pnotify.custom.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/common/win_layer/win_layer.js"></script>
	<script
		src="<%=request.getContextPath()%>/common/win_layer/extend/layer.ext.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/common.js"></script>
	<script
		src="<%=request.getContextPath()%>/js/ctrl/question-item-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/question-index.js"></script>
	<script src="<%=request.getContextPath()%>/js/ctrl/question-ctrl.js"></script>
	<script src="<%=request.getContextPath()%>/js/sv/question-sv.js"></script>
	<script src="<%=request.getContextPath()%>/js/common/filters.js"></script>

<script>
    var contextPath="<%=request.getContextPath()%>";
	var userId = "${userId}";
	var accessToken='${accessToken}';
</script>

</body>
</html>