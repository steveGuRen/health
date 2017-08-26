
'use strict';
angular.module('controller.sysrole', [])
	.controller('sysroleCtrl', function($log, $scope, $location, $uibModal,userRoleSV,initData) {
		$scope.queryParam = {};
		$scope.objects = initData.roleList;
		$scope.object = {};
		$scope.queryParam.currentPage = 1;
		$scope.queryParam.totalPage = Math.ceil(initData.totalCount/10);
		$scope.queryParam.totalCount = initData.totalCount;
		
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
			$scope.object.typeId=0;
			
			$("#role-type-0 input").prop("checked", false);
			$("#role-type-1 input").prop("checked", false);
			/*$("#role-type-2 input").prop("checked", false);*/
			$("#pb-rd-type-0").prop("checked", true);
			$("#role-type-0").css("display", "block");
			$("#role-type-1").css("display", "none");
		}
		
		//分页
		pagination($scope.queryParam.totalPage, $scope.queryParam.currentPage, 'userRolePage', $scope);
		
		$scope.queryList = function(page) {
			
			var pagin = ispage($scope.queryParam.totalPage,page)
			
			if(!pagin.status && page!=1){
				$(showStackBottomRight("error", "亲", pagin.msg));
				return;
			}
			
			userRoleSV.listBean.roleName = $scope.queryParam.roleName;
			userRoleSV.listBean.page = page;
			userRoleSV.listBean.rows = 10;
			var ii = layer.load('loading...');
			userRoleSV.list().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data){
					
					$scope.objects = response.data.data.roleList;
					$scope.queryParam.totalPage = Math.ceil(response.data.data.totalCount/10);
					$scope.queryParam.currentPage = page;
					$scope.queryParam.totalCount = response.data.data.totalCount;
					if($scope.queryParam.totalPage==0){
						$scope.queryParam.currentPage = 1;
					}
					//分页
					pagination($scope.queryParam.totalPage, $scope.queryParam.currentPage, 'userRolePage', $scope);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}	
		
		
		
		$scope.menulist = function(){
				userRoleSV.menulist().then(function(response) {
				
				if(response.data && response.data.data){
					
						var menuList = response.data.data.adminMenuList;
						
						$scope.menuList0 = [];
						$scope.menuList1 = [];
						$scope.menuList2 = [];
						for(var i = 0; i < menuList.length; i++) {
							if(menuList[i].typeId == 0) {
								$scope.menuList0.push(menuList[i]);
							}
							if(menuList[i].typeId == 1) {
								$scope.menuList1.push(menuList[i]);
							}
							if(menuList[i].typeId == 2) {
								$scope.menuList2.push(menuList[i]);
							}
							
						}
					}
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		$scope.menulist();
	 
		$scope.clearCheck =function() {
			for(var i = 0; i < menuList.length; i++) {
				
			}
		}
		
		$scope.showRoleTypeList = function(id) {
			if(id == "pb-rd-type-0") {
				$("#pb-rd-type-0").prop("checked", true);
				$("#pb-rd-type-1").prop("checked", false);
				$("#pb-rd-type-1").prop("checked", false);
				$("#role-type-0").css("display", "block");
				$("#role-type-1").css("display", "none");
				/*$("#role-type-2").css("display", "none");*/
				$("#role-type-0 input").prop("checked", false);
				$("#role-type-1 input").prop("checked", false);
				/*$("#role-type-2 input").prop("checked", false);*/
			}else if(id == "pb-rd-type-1") {
				$("#pb-rd-type-0").prop("checked", false);
				$("#pb-rd-type-1").prop("checked", true);
				/*$("#pb-rd-type-2").prop("checked", false);*/
				$("#role-type-0").css("display", "none");
				$("#role-type-1").css("display", "block");
				//$("#role-type-2").css("display", "none");
				$("#role-type-0 input").prop("checked", false);
				$("#role-type-1 input").prop("checked", false);
				$("#role-type-1 input").prop("checked", false);
				
			}/*else if(id == "pb-rd-type-2") {
				$("#pb-rd-type-0").prop("checked", false);
				$("#pb-rd-type-1").prop("checked", false);
				$("#pb-rd-type-2").prop("checked", true);
				$("#role-type-0").css("display", "none");
				$("#role-type-1").css("display", "none");
				$("#role-type-2").css("display", "block");
				$("#role-type-0 input").prop("checked", false);
				$("#role-type-1 input").prop("checked", false);
				$("#role-type-1 input").prop("checked", false);
				
			}*/
		}
		
		$scope.menuClick = function(menuId){
			var str = "#pb-cb-";
			if($(str + menuId).prop("checked")) {
				$(str + menuId + "-action input").prop("checked", true);
			}else {
				$(str + menuId + "-action input").prop("checked", false);
			}
		}
	
		$scope.permissionClick = function(menuId,type) {
			var str = "#pb-cb-";
			if($(str + menuId + type).prop("checked")) {
				$(str + menuId).prop("checked",true);
			}
			else{
				var list = $(str + menuId + "-action input");
				var flag = false;
				for(var i=0;i<list.length;i++){
					if($(list[i]).prop("checked"))
					{
						flag = true;
						break;
					}
				}
				
				if(!flag){
					$(str + menuId).prop("checked",false);
				}
			}
		}
		
		$scope.add = function(){
			 if(!$scope.addRoleForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据没有填完整哦"));
				   return;
			   }
			userRoleSV.addBean.roleName = $scope.object.roleName;
			userRoleSV.addBean.roleDescribe = $scope.object.roleDescribe;
			//角色菜单权限
			var roleList = [];
			if($scope.object.typeId==0){
				$scope.menuList = $scope.menuList0;
			}
			else if($scope.object.typeId==1){
				$scope.menuList = $scope.menuList1;
			}
			else if($scope.object.typeId==2){
				$scope.menuList = $scope.menuList2;
			}
			/*$scope.menuList.push($scope.menuList0);
			$scope.menuList.push($scope.menuList1);*/
			for(var i = 0; i < $scope.menuList.length; i++) {		
				var menu = $scope.menuList[i];
				for(var j = 0; j < menu.adminMenuMenu2.length; j++ ) {
					var roleMenu = {
							id: null,
							roleId: null,
							menuId: null,
							permission: null,
							typeId: null
					}
					var menuId = menu.adminMenuMenu2[j].menuId;
					var permission = "";
					
					if($("#pb-cb-" + menuId + "-r").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-u").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-a").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-d").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-i").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-p").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-di").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-o").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					roleMenu.menuId = menuId;
					var tem = "";
					for(var k  = permission.length - 1; k  >=0; k --) {
						tem = tem + permission.substring(k ,k + 1);
					}
					roleMenu.permission = tem;
					roleMenu.typeId = menu.adminMenuMenu2[j].typeId;
					var pattern = new RegExp("^[0]+$");
					if(!pattern.test(roleMenu.permission)){
						roleList.push(roleMenu);
					}
				}
			}
			userRoleSV.addBean.roleMenuList = JSON.stringify(roleList);
			userRoleSV.addBean.typeId = $scope.object.typeId;
			var ii = layer.load('loading...');
			userRoleSV.add().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data){
					
					$(showStackBottomRight("info", "亲", response.data.msg));

					if(response.data.status==200||response.data.status=='200'){
						$scope.page();
						$scope.queryList($scope.queryParam.currentPage);
					}
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.view = function (object) {
			
			$("#role-type-0 input").prop("checked", false);
			$("#role-type-1 input").prop("checked", false);
			/*$("#role-type-2 input").prop("checked", false);*/
			
			$scope.type = 'update';
			$scope.object = $.extend({},$scope.object,object);
			userRoleSV.viewBean.roleId = object.roleId;
			var ii = layer.load('loading...');
			userRoleSV.view().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data && response.data.data.roleList){
					
					for(var i in response.data.data.roleList){
							var roleList = response.data.data.roleList;
							if(roleList.length > 0) {
								if(roleList[0].typeId == 0 || roleList[0].typeId == null) {
									$("#role-type-0").css("display", "block");
									$("#role-type-1").css("display", "none");
									//$("#role-type-2").css("display", "none");
									$("#pb-rd-type-0").prop("checked", true);
									$("#pb-rd-type-1").prop("checked", false);
									$scope.object.typeId=0;
									//$("#pb-rd-type-2").prop("checked", false);
								}else if(roleList[0].typeId == 1) {
									$("#role-type-0").css("display", "none");
									$("#role-type-1").css("display", "block");
									//$("#role-type-2").css("display", "none");
									$("#pb-rd-type-0").prop("checked", false);
									$("#pb-rd-type-1").prop("checked", true);
									$scope.object.typeId=1;
									//$("#pb-rd-type-2").prop("checked", false);
								
								}/*else if(roleList[0].typeId == 2) {
									$("#role-type-0").css("display", "none");
									$("#role-type-1").css("display", "none");
									$("#role-type-2").css("display", "block");
									$("#pb-rd-type-0").prop("checked", false);
									$("#pb-rd-type-1").prop("checked", false);
									$("#pb-rd-type-2").prop("checked", true);
								
								}*/
							for(var i = 0; i < roleList.length; i++) {
								$("#pb-cb-" + roleList[i].menuId).prop("checked", true);
								var tem = "";
								if(!roleList[i].permission){
									tem = tem + roleList[i].permission;
								}
								else{
									
									for(var k = roleList[i].permission.length - 1; k  >=0; k --) {
										tem = tem + roleList[i].permission.substring(k , k + 1);
									}
								}
								if(tem.charAt(0) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-r").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-r").prop("checked", false);
								}
								if(tem.charAt(1) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-u").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-u").prop("checked", false);
								}
								if(tem.charAt(2) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-a").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-a").prop("checked", false);
								}
								if(tem.charAt(3) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-d").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-d").prop("checked", false);
								}
								
								if(tem.charAt(4) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-i").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-i").prop("checked", false);
								}
								if(tem.charAt(5) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-p").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-p").prop("checked", false);
								}
								if(tem.charAt(6) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-di").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-di").prop("checked", false);
								}
								if(tem.charAt(7) == "1") {
									$("#pb-cb-" + roleList[i].menuId + "-o").prop("checked", true);
								}else {
									$("#pb-cb-" + roleList[i].menuId + "-o").prop("checked", false);
								}
								
							}
						}
					}
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.update = function (){
			 if(!judgePermission('update',organizationIdList)){
			 	return;
			 }
			 if(!$scope.addRoleForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据没有填完整哦"));
				   return;
			   }
			userRoleSV.updateBean.roleId = $scope.object.roleId;
			userRoleSV.updateBean.roleName = $scope.object.roleName;
			userRoleSV.updateBean.roleDescribe = $scope.object.roleDescribe;
			//角色菜单权限
			var roleList = [];
			if($scope.object.typeId==0){
				$scope.menuList = $scope.menuList0;
			}
			else if($scope.object.typeId==1){
				$scope.menuList = $scope.menuList1;
			}
			else if($scope.object.typeId==2){
				$scope.menuList = $scope.menuList2;
			}
			/*$scope.menuList.push($scope.menuList0);
			$scope.menuList.push($scope.menuList1);*/
			for(var i = 0; i < $scope.menuList.length; i++) {		
				var menu = $scope.menuList[i];
				for(var j = 0; j < menu.adminMenuMenu2.length; j++ ) {
					var roleMenu = {
							id: null,
							roleId: null,
							menuId: null,
							permission: null,
							typeId: null
					}
					var menuId = menu.adminMenuMenu2[j].menuId;
					var permission = "";
					
					
					if($("#pb-cb-" + menuId + "-r").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-u").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-a").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-d").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-i").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-p").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-di").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					if($("#pb-cb-" + menuId + "-o").prop("checked")) {
						permission = permission + 1;
					}else {
						permission = permission + 0;
					}
					roleMenu.menuId = menuId;
					var tem = "";
					for(var k  = permission.length - 1; k  >=0; k --) {
						tem = tem + permission.substring(k ,k + 1);
					}
					roleMenu.permission = tem;
					roleMenu.typeId = menu.adminMenuMenu2[j].typeId;
					var pattern = new RegExp("^[0]+$");
					if(!pattern.test(roleMenu.permission)){
						roleList.push(roleMenu);
					}
				}
			}
			userRoleSV.updateBean.roleMenuList = JSON.stringify(roleList);
			userRoleSV.updateBean.typeId = $scope.object.typeId;
			var ii = layer.load('loading...');
			userRoleSV.update().then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data){
					
					$(showStackBottomRight("info", "亲", response.data.msg));

					if(response.data.status==200||response.data.status=='200'){
						$scope.page();
						$scope.queryList($scope.queryParam.currentPage);
					}
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.del = function(title,object){
			 if(!judgePermission('delete',organizationIdList)){
			 	return;
			 }
			   var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../health/jsp/popup/confirm-popup.jsp",
					controller: 'usRoleDelCtrl',
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
.controller('usRoleDelCtrl', function ($scope, $uibModalInstance, title, object, userRoleSV) {
		$scope.title = title;
		
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			 var list = [];
			 list.push(object.roleId);
			 userRoleSV.delBean.roleIdList = JSON.stringify(list);
			 var ii = layer.load('loading...');
			 userRoleSV.del().then(function(response) {
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