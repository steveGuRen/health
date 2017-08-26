
'use strict';
angular.module('controller.statTestdata', [])
	.controller('statTestdataCtrl', function($log, $scope, $location, $uibModal, statSV) {
		$scope.queryParam = {};
		
		$scope.object = {};
		$scope.queryParam.currentPage = 1;
		$scope.quotaType=0;
		$scope.classChange = function(){
			$('#tabButton li').css({
				'background': "#2c3b41",
				'color':'#b8c7ce'
			})
			$('#quotaType'+$scope.quotaType).css({
				'background':"#33CC99",
				'color':"#fff"
			});
		}
		$scope.classChange();
		
		
		$scope.getQuatos = function(){
			
			
			var ii = layer.load('loading...');
			statSV.quotalist().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data ){
					
					$scope.quotalist = response.data.data.quotalist;
					
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.getQuatos();
		
		$scope.skipToAdd = function() {
			$scope.pageContent = !$scope.pageContent;
			$scope.pageAdd = !$scope.pageAdd;
			$scope.object = {};
			$scope.object.quota = {};
			$scope.object.hasUser = true;
			$scope.object.urine = [{secondQuotaName:'尿蛋白'},{secondQuotaName:'尿白细胞',unit:'个'},{secondQuotaName:'尿酮体'}
			,{secondQuotaName:'尿亚硝酸盐'},{secondQuotaName:'尿胆原'},{secondQuotaName:'尿胆红素'}
			,{secondQuotaName:'蛋白尿'},{secondQuotaName:'尿糖'},{secondQuotaName:'尿比重'}
			,{secondQuotaName:'尿酸碱度'},{secondQuotaName:'隐血BLO'},{secondQuotaName:'酮体'}
			,{secondQuotaName:'尿红细胞'},{secondQuotaName:'尿液颜色'},{secondQuotaName:'维C'}
			,{secondQuotaName:'尿肌酐',unit:'mmol/d'}];
			$scope.object.blodPress = [{secondQuotaName:'收缩压',unit:'mmHg'},{secondQuotaName:'舒张压',unit:'mmHg'}];
		}
		
		$scope.queryList = function(page,name){
			var pagin = ispage($scope.queryParam.totalPage,page)
			
			if(!pagin.status && page!=1){
				$(showStackBottomRight("error", "亲", pagin.msg));
				return;
			}
			$scope.quotaName=name;
			
			var bean = $.extend({},true,bean,statSV.recordlistBean);
			bean.page = page;
			bean.rows = rows;
			bean.quotaName = name;
			bean.userName = $scope.queryParam.userName;
			bean.gender = $scope.queryParam.gender;
			var ii = layer.load('loading...');
			statSV.recordlist(bean).then(function(response) {
				
				if(response.data && response.data.data){
					layer.close(ii);
					$scope.objects = response.data.data.list;
					$scope.queryParam.totalPage = Math.ceil(response.data.data.count/rows);
					$scope.queryParam.totalCount = response.data.data.count;
					$scope.queryParam.currentPage = page;
					if($scope.queryParam.totalPage==0){
						$scope.queryParam.currentPage = 1;
					}
					//分页
					pagination($scope.queryParam.totalPage, $scope.queryParam.currentPage, 'tstDataPage', $scope);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.queryList(1,'体重');
		
		$scope.validateUserName = function(){
			if(!$.trim($scope.object.userName)){
				return;
			}
			var getUserInfoBean = $.extend({},true,getUserInfoBean,statSV.getUserInfoBean);
			getUserInfoBean.userName = $scope.object.userName;
			
			var ii = layer.load('loading...');
			statSV.getUserInfo(getUserInfoBean).then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data && response.data.data.userList){
					
					if(response.data.data.userList.length==0){
						$scope.noticeUser="用户名不存在，请先添加用户."
						$scope.object.hasUser = false;
					}
					else{
						$scope.object.gender = response.data.data.userList[0].gender;
						$scope.object.userAge = response.data.data.userList[0].userAge;
						$scope.object.userId = response.data.data.userList[0].userId;
						$scope.object.hasUser = true;
					}
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		
		
		$scope.add = function() {
			if(!$.trim($scope.object.userName)){
				
				$scope.noticeUser="用户姓名不能为空."
				$scope.object.hasUser = false;
				return;
			}
			var addBean = $.extend({},true,addBean,statSV.recordaddBean);
			addBean.userName = $scope.object.userName;
			addBean.gender = $scope.object.gender;
			addBean.userAge = $scope.object.userAge;
			addBean.userId = $scope.object.userId;
			addBean.situation = $scope.object.situation;
			if($scope.object.quota.quotaType=='7'){
				var urineList = [];
				for(var i in $scope.object.urine){
					if(!$scope.object.urine[i].value && !$scope.object.urine[i].result){
						continue;
					}
					else{
						$scope.object.urine[i].quotaType = $scope.object.quota.quotaType;
						$scope.object.urine[i].quotaName = $scope.object.quota.quotaName;
						$scope.object.urine[i].deviceId = $scope.object.deviceId;
						$scope.object.urine[i].device = $scope.object.device;
						$scope.object.urine[i].createUser = 'yanglei';
						urineList.push($scope.object.urine[i]);
					}
				}
				addBean.recordList = JSON.stringify(urineList);
			}
			else if($scope.object.quota.quotaType=='2'){
				var blodPress = [];
				for(var i in $scope.object.blodPress){
					if(!$scope.object.blodPress[i].value && !$scope.object.blodPress[i].result){
						continue;
					}
					else{
						$scope.object.blodPress[i].quotaType = $scope.object.quota.quotaType;
						$scope.object.blodPress[i].quotaName = $scope.object.quota.quotaName;
						$scope.object.blodPress[i].deviceId = $scope.object.deviceId;
						$scope.object.blodPress[i].device = $scope.object.device;
						$scope.object.blodPress[i].createUser = 'yanglei';
						blodPress.push($scope.object.blodPress[i]);
					}
				}
				addBean.recordList = JSON.stringify(blodPress);
			}
			else{
				var record, recordList;
				record = {};
				recordList = [];
				
				record.quotaType = $scope.object.quota.quotaType;
				record.quotaName = $scope.object.quota.quotaName;
				record.deviceId = $scope.object.deviceId;
				record.device = $scope.object.device;
				record.unit = $scope.object.unit;
				record.value = $scope.object.value;
				record.createUser = 'yanglei';
				recordList.push(record);
				addBean.recordList = JSON.stringify(recordList);
			}
			

			var ii = layer.load('loading...');
			statSV.recordadd(addBean).then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data){
					
					
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.userRegister = function() {
			
			window.location=window.location.origin+window.location.pathname+'#/record-info';
			
		}
		
		/*$scope.userRegisterPop = function(){
			$scope.updateUnit = function(object){
				
				 var modalInstance = $uibModal.open({
						animation: true,
						templateUrl: "../health/jsp/popup/stat-userRegister-popup.jsp",
						controller: 'userRegisterCtrl',
						size: "lg",
						resolve: {
							object: function () {
								return object;
							}
						}
					});
					
					//回调方法，从子弹框关闭的时候传递object值到主页面中
					modalInstance.result.then(function(){
						
					});
			}
		}*/
	})
	/*.controller('userRegisterCtrl', function ($scope, $uibModalInstance, object, statSV) {
		$scope.object = object;
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if(!$scope.addPremiseForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据格式错误哦"));
				   return;
			    }
			 houseSV.premiseAddBean.premisesName = $scope.object.premisesName;
			 houseSV.premiseAddBean.premisesPosition = $scope.object.premisesPosition;
			 houseSV.premiseAddBean.developer = $scope.object.developer;
			 houseSV.premiseAddBean.allArea = $scope.object.allArea;
			 houseSV.premiseAddBean.greenArea = $scope.object.greenArea;
			 houseSV.premiseAddBean.parkingNum = $scope.object.parkingNum;
			 houseSV.premiseAddBean.premisesDescriptions = $scope.object.premisesDescriptions;
			 houseSV.premiseAddBean.premisesCity = $scope.object.premisesCity;
			 var ii = layer.load('loading...');
			 houseSV.premiseAdd().then(function(response) {
				 layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						$uibModalInstance.close();
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		
	})*/
	