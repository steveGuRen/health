
'use strict';
angular.module('controller.sysuser', [])
	.controller('sysuserCtrl', function($log, $scope, $location, $uibModal,initData,organizationSV,staffSV,userRoleSV) {
		
		$scope.queryParam = {};
		$scope.objects = initData.adminList;
		$scope.object = {};
		$scope.queryParam.currentPage = 1;
		$scope.queryPremises = {};
		$scope.queryRoles = {};
		$scope.queryParam.totalCount = initData.totalCount;
		$scope.queryParam.totalPage = Math.ceil(initData.totalCount/10);
		pagination($scope.queryParam.totalPage, 1, 'userStaffPage', $scope);
		$scope.getRoleList = function(){
			userRoleSV.listBean.page = null;
			userRoleSV.listBean.rows = null;
			userRoleSV.listBean.roleName = null;
			var ii = layer.load('loading...');
			userRoleSV.list().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data){
					
					$scope.roleList = response.data.data.roleList;
					$scope.roleList0 = [];
					$scope.roleList1 = [];
					$scope.roleList2 = [];
					for(var i = 0; i < $scope.roleList.length; i++) {
						if($scope.roleList[i].typeId == 0) {
							$scope.roleList0.push($scope.roleList[i]);
						}
						if($scope.roleList[i].typeId == 1) {
							$scope.roleList1.push($scope.roleList[i]);
						}
						if($scope.roleList[i].typeId == 2) {
							$scope.roleList2.push($scope.roleList[i]);
						}
					}
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.getRoleList();
		
		
		$scope.selectPremises = {
				premises:null,
				premise:null
		}
		
		$scope.selectPremise = function() {
			// organizationSV.listBean.premisesIdList = null;
			var ii = layer.load('loading...');
			var promise = organizationSV.list();
			promise.success(function(data) {
				layer.close(ii);
				$scope.selectPremises.premises = data.data.organizationList;
				
			}).error(function(data) {
				layer.close(ii);
				alert("小区选择异常，请检查网络！");
			});
		}
		//初始化项目
		$scope.selectPremise();
		
		$scope.selectPosition = function() {
			
			// var position = staffSV.position();
			// var ii = layer.load('loading...');
			// position.success(function(data) {
			// 	layer.close(ii);
			// 	$scope.positions = data.data.positionList;
				
			// }, function(reason) {
			// 	layer.close(ii);
			// }, function(value) {
			// 	layer.close(ii);
			// })
		}
		//初始化职位
		$scope.selectPosition();
		
		$scope.page = function(){
			$scope.pageUpdate = !$scope.pageUpdate;
			$scope.pageContent = !$scope.pageContent;
		}
		
		$scope.skipToAdd = function() {
			if(!judgePermission('add',organizationIdList)){
		 		return;
		    }
			$scope.page();
			$scope.object = {};
			$scope.type = 'add';
			$("#realName").prop("disabled", false);//将姓名改为可填
			$("#role-premises input").prop("checked", false);
			$("#admin-name").prop("readonly",false);
			$("#pb-rd-woman").prop("checked", false);
			$("#pb-rd-man").prop("checked", true);	
			$scope.object.gender=0;
		}
		
		$scope.skipToUpdate = function(object) {
			$scope.object = object;
			$scope.type = 'update';
			$("#role-premises input").prop("checked", false);
			$("#admin-name").prop("readonly",true);
			staffSV.viewBean.userId = object.userId;
			var ii = layer.load('loading...');
			staffSV.view().then(function(response) {
				layer.close(ii);
				$("#realName").prop("disabled", true);//将姓名改为不能修改
				$scope.object = response.data.data.adminList[0];
				if($scope.object.gender == 0) {
					$("#pb-rd-woman").prop("checked", false);
					$("#pb-rd-man").prop("checked", true);
				}else {
					$("#pb-rd-woman").prop("checked", true);
					$("#pb-rd-man").prop("checked", false);		
				}
				for(var i = 0; i < response.data.data.adminList.length; i++) {
					if(response.data.data.adminList[i].roleId != null) {
						
						if(response.data.data.adminList[i].typeId == 0) {
							$("#pb-cb-" + response.data.data.adminList[i].roleId + "-" + response.data.data.adminList[i].organizationId).prop("checked", true);
						}else if(response.data.data.adminList[i].typeId == 1) {
							$("#pb-cb-" + response.data.data.adminList[i].roleId).prop("checked", true);
						}else if(response.data.data.adminList[i].typeId == 2) {
							if(response.data.data.adminList[i].organizationId == -1) {//自己
								$("#pb-rd-" + response.data.data.adminList[i].roleId + "-0").prop("checked", true);
							}else if(response.data.data.adminList[i].organizationId == -2) {//全部
								$("#pb-rd-" + response.data.data.adminList[i].roleId + "-1").prop("checked", true);
							}
						}
					}
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		/*$scope.angleClick = function (role){
			role.show = !role.show;
			if(!role.show){
				$('#'+role.roleId).removeClass('fa-angle-left');
				$('#'+role.roleId).addClass('fa-angle-down');
				$('#'+role.roleId+'-action').css('display','none');
			}
			else{
				$('#'+role.roleId).removeClass('fa-angle-down');
				$('#'+role.roleId).addClass('fa-angle-left');
				$('#'+role.roleId+'-action').css('display','block');
			}
			
		}*/
		
		$scope.adminRoleOrganizationList = function(){
			var list = [];
			var str = "#pb-cb-";
			for(var i =0;i<$scope.roleList.length;i++){
				
				if($scope.roleList[i].typeId==0){
					
					for(var j =0;j<$scope.selectPremises.premises.length;j++){
						var item = {};
						if($(str+$scope.roleList[i].roleId+'-'+$scope.selectPremises.premises[j].organizationId).prop("checked")){
							item.roleId = $scope.roleList[i].roleId;
							item.organizationId = $scope.selectPremises.premises[j].organizationId;
							list.push(item);
						}
					}
				}
				else if($scope.roleList[i].typeId==1){
					var item = {};
					if($(str+$scope.roleList[i].roleId).prop("checked")){
						item.roleId = $scope.roleList[i].roleId;
						item.organizationId = 0;
						list.push(item);
					}
				}
				
				else if($scope.roleList[i].typeId==2){
					var item = {};
					if($("#pb-rd-"+$scope.roleList[i].roleId+'-0').prop("checked")){
						item.roleId = $scope.roleList[i].roleId;
						item.organizationId = -1;
						list.push(item);
					}
					else if($("#pb-rd-"+$scope.roleList[i].roleId+'-1').prop("checked")){
						item.roleId = $scope.roleList[i].roleId;
						item.organizationId = -2;
						list.push(item);
					}
				}
			}
			
			return list;
		}
		
		$scope.queryList = function(page) {
			
			var pagin = ispage($scope.queryParam.totalPage,page)
			
			if(!pagin.status && page!=1){
				$(showStackBottomRight("error", "亲", pagin.msg));
				return;
			}
			
			staffSV.listBean.userLoginName = $scope.queryParam.adminName;
			staffSV.listBean.userName = $scope.queryParam.realName;
			staffSV.listBean.organizationIdList = JSON.stringify($scope.queryPremises.idList);
			staffSV.listBean.roleIdList = JSON.stringify($scope.queryRoles.idList);
			staffSV.listBean.userTel = $scope.queryParam.adminTel;
			staffSV.listBean.page = page;
			staffSV.listBean.rows = 10;
			var ii = layer.load('loading...');
			staffSV.list().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data){
					
					$scope.objects = response.data.data.adminList;
					$scope.queryParam.totalPage = Math.ceil(response.data.data.totalCount/10);
					$scope.queryParam.currentPage = page;
					$scope.queryParam.totalCount = response.data.data.totalCount;
					if($scope.queryParam.totalPage==0){
						$scope.queryParam.currentPage = 1;
					}
					//分页
					pagination($scope.queryParam.totalPage, $scope.queryParam.currentPage, 'userStaffPage', $scope);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}	
		
		$scope.allClick = function(roleId){
			var str = "#pb-cb-";
			if($(str + roleId).prop("checked")) {
				$("#"+roleId + "-action input").prop("checked", true);
			}else {
				$("#"+ roleId + "-action input").prop("checked", false);
			}
		}
		
		$scope.add = function(){
			if(!$scope.addStaffForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据没有填完整哦"));
				   return;
			   }
			staffSV.addBean.userName = $scope.object.userName;
			staffSV.addBean.userLoginName = $scope.object.userLoginName;
			staffSV.addBean.userTel = $scope.object.userTel;
			staffSV.addBean.userIdCard = $scope.object.userIdCard;
			staffSV.addBean.gender = $scope.object.gender;
			staffSV.addBean.adminRoleOrganizationList = JSON.stringify($scope.adminRoleOrganizationList());
			var ii = layer.load('loading...');
			staffSV.add().then(function(response) {
				layer.close(ii);
				$(showStackBottomRight("info", "亲", response.data.msg));

				if(response.data.status==200||response.data.status=='200'){
					$scope.page();
					$scope.queryList($scope.queryParam.currentPage);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.update = function(){
			 if(!judgePermission('update',organizationIdList)){
			 	return;
			 }
			if(!$scope.addStaffForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据没有填完整哦"));
				   return;
			   }
			staffSV.updateBean.userId = $scope.object.userId;
			staffSV.updateBean.userIdCard = $scope.object.userIdCard;
			staffSV.updateBean.gender = $scope.object.gender;
			staffSV.updateBean.userName = $scope.object.userName;
			staffSV.updateBean.userLoginName = $scope.object.userLoginName;
			staffSV.updateBean.adminRoleOrganizationList = JSON.stringify($scope.adminRoleOrganizationList());
			staffSV.updateBean.userTel = $scope.object.userTel;
			var ii = layer.load('loading...');
			staffSV.update().then(function(response) {
				layer.close(ii);
				$(showStackBottomRight("info", "亲", response.data.msg));

				if(response.data.status==200||response.data.status=='200'){
					$scope.page();
					$scope.queryList($scope.queryParam.currentPage);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.popupPremises = function(title){
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: "../health/jsp/popup/selectProject-popup.jsp",
				controller: 'staffCheckCtrl',
				size: "lg",
				resolve: {
					title: function () {
						return title;
					},
					projects: function () {
						return $scope.selectPremises.premises;
					},
					queryPremises : function() {
						
							return $scope.queryPremises;
						
					}
				}
			});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(queryPremises){
					
					$scope.queryPremises = queryPremises;
					
				});
		 }

		$scope.popupRoles = function(title){
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: "../health/jsp/popup/selectRoles-popup.jsp",
				controller: 'staffRolesCtrl',
				size: "lg",
				resolve: {
					title: function () {
						return title;
					},
					roles: function () {
						return $scope.roleList;
					},
					queryRoles : function() {
						
							return $scope.queryRoles;
						
					}
				}
			});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(queryRoles){
					$scope.queryRoles = queryRoles;
				});
		 }
		
		$scope.del = function(title,object){
			 if(!judgePermission('delete',organizationIdList)){
			 	return;
			 }
			   var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../health/jsp/popup/confirm-popup.jsp",
					controller: 'usStaffDelCtrl',
					size: "lg",
					resolve: {
						title: function () {
							return title;
						},
						object: function () {
							return object;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					
					$scope.queryList($scope.queryParam.currentPage);
					
				});
				
			  
		   }
		
	})
	.controller('usStaffDelCtrl', function ($scope, $uibModalInstance, title, object, staffSV) {
		$scope.title = title;
		
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			 var list = [];
			 list.push(object.userId);
			 staffSV.delBean.adminIdList = JSON.stringify(list);
			 var ii = layer.load('loading...');
			 staffSV.del().then(function(response) {
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
		
		
	})
	.controller('staffCheckCtrl', function ($scope, $uibModalInstance, title, projects,queryPremises) {
		$scope.title = title;
		$scope.projects = projects;
		$scope.selectPremises = $.extend(true,{}, $scope.selectPremises ,queryPremises) || null;
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		//选择项目
		$scope.confirm = function() {
			$uibModalInstance.close($scope.selectPremises);
		};
		$scope.checkClick = function(index) {
			$scope.selectPremises.idList =[];
			$scope.selectPremises.names='';
			for (var j = 0; j < $scope.projects.length; j++) {
				if ($('#pb-cb-service' + j).prop('checked')) {
					//$scope.selectPremises.list.push($scope.projects[j]);
					$scope.selectPremises.idList.push(projects[j].organizationId);
					if($scope.selectPremises.names.length==0){
						$scope.selectPremises.names=$scope.projects[j].organizationName;
						
					}else{
						$scope.selectPremises.names=$scope.selectPremises.names+'、'+$scope.projects[j].organizationName;
					}
				}
			}
		}
		
		
	})
	.controller('staffRolesCtrl', function ($scope, $uibModalInstance, title, roles,queryRoles) {
		$scope.title = title;
		$scope.roles = roles;
		$scope.selectRoles = $.extend(true,{},$scope.queryRoles,queryRoles)||null;
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		//选择项目
		$scope.confirm = function() {
			$uibModalInstance.close($scope.selectRoles);
		};
		$scope.checkClick = function(index) {
			$scope.selectRoles.idList =[];
			$scope.selectRoles.names='';
			for (var j = 0; j < $scope.roles.length; j++) {
				if ($('#pb-cb-service' + j).prop('checked')) {
					$scope.selectRoles.idList.push($scope.roles[j].roleId);
					if($scope.selectRoles.names.length==0){
						$scope.selectRoles.names=$scope.roles[j].roleName;
					}else{
						$scope.selectRoles.names=$scope.selectRoles.names+'、'+$scope.roles[j].roleName;
					}
				}
			}
		}
		
	})