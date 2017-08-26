/**
 * 
 */
angular.module('controller.app',[])
	.controller('appCtrl', function($log, $scope, $location, initData, appSV, $uibModal, $filter) {
		$scope.result =  initData;
		$scope.objects = initData.userList;
		$scope.queryParam = appSV.getUserListBean;
		//$scope.queryParam = {};
		$scope.queryParam.pageNo = 1;
		
		$scope.result.totalPage = Math.ceil(initData.totalCount/10);
		

		$scope.selectPremises = {
				premises:null,
				premise:null
		}
		
		$scope.selectUnits = {
				units:null,
				unit:null
		}
		
		$scope.selectHouses = {
				houses:null,
				house:null
		}
		
		$scope.page = function() {  //页面切换，例如更新页跳到list页
			$scope.pageUpdate = !$scope.pageUpdate;
			$scope.pageContent = !$scope.pageContent;
			
			//if(response.data.status == 200){
				
				$scope.queryList($scope.queryParam.pageNo);
			//}
		}
		
		$scope.skipToUpdatePage = function(object) {
			$scope.object = object;
			
			if($scope.object){
				$scope.page();
				$scope.flag = 2;
				if($scope.object.roleId != 0 && !$scope.object.roleId ){
					
					$scope.object.roleId = 1;
				}
				$scope.object.roleId = $scope.object.roleId.toString();
				
				if(object.roleId=='2' || object.roleId=='3'){
					
					for(var item in $scope.selectPremises.premises){
						if(object.premiseId == $scope.selectPremises.premises[item].premisesId){
							$scope.selectPremises.premise = $scope.selectPremises.premises[item];
							$scope.selectUnit(object);
							break;
						}
					}
				}
				
			}
			else{
				if(!judgePermission("add",[0])){
					return ;
				}
				$scope.page();
				$scope.flag = 1;
				$scope.object = {};
				$scope.object.roleId = 0;
				$scope.object.roleId = $scope.object.roleId.toString();
			}
			
			
			
			
		}
		
		$scope.getExcel = function() {
			window.open(contextPath + "/statistics/getExcel");
		}
		
		$scope.queryList = function(page) {
			if(page != undefined) {
				if((page > $scope.result.totalPage) && page!=1) {
					$scope.queryParam.pageNo = $scope.result.totalPage;
					jq(showStackBottomRight("info", "亲", "已经是最后一页"));
					return;
				}
				if(page > 0) {
					var ii = layer.load('loading...');
					appSV.getUserListBean.page = page;
					appSV.getUserListBean.userLoginname = $scope.queryParam.userLoginname;
					appSV.getUserListBean.useretdTel = $scope.queryParam.useretdTel;
					appSV.getUserListBean.ownerTel = $scope.queryParam.ownerTel;
					appSV.getUserList().then(function(response) {
						$scope.result = response.data.data;
						$scope.objects = response.data.data.userList;
						$scope.queryParam.pageNo = page;
						$scope.result.totalPage = Math.ceil(response.data.data.totalCount/10);
						layer.close(ii);
					}, function(reason) {
						jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
						layer.close(ii);
					}, function(value) {
						jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
						layer.close(ii);
					})
				}else {
					$scope.queryParam.pageNo = 1;
					jq(showStackBottomRight("info", "亲", "已经是第一页"));
					return;
				}
			}else {
				var ii = layer.load('loading...');
				appSV.getUserListBean.page = 1;
				appSV.getUserListBean.userLoginname = $scope.queryParam.userLoginname;
				appSV.getUserListBean.useretdTel = $scope.queryParam.useretdTel;
				appSV.getUserListBean.ownerTel = $scope.queryParam.ownerTel;
				appSV.getUserList().then(function(response) {
					$scope.result = response.data.data;
					$scope.objects = response.data.data.userList;
					$scope.queryParam.pageNo = page;
					$scope.result.totalPage = Math.ceil(response.data.data.totalCount/10);
					layer.close(ii);
				}, function(reason) {
					jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
					layer.close(ii);
				}, function(value) {
					jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
					layer.close(ii);
				})
			}
		}
		
		
		$scope.selectPremise = function() {
			//appSV.getPremisesListBean.premisesIdList = JSON.stringify(premisesIdList);
			var promise = appSV.getPremisesList();
//			var promise = HouseService.premiseslist(csrftoken);
			promise.success(function(data) {
				$scope.selectPremises.premises = data.data.premiseslist;
				$scope.selectPremises.premise = data.data.premiseslist[0];
				$scope.selectUnit();
			}).error(function(data) {
				alert("小区选择异常，请检查网络！");
			});
		}
		
		$scope.selectUnit = function(object) {
			appSV.getUnitListBean.premisesId = $scope.selectPremises.premise.premisesId;
			var promise = appSV.getUnitList();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.selectUnits.units = data.data.unitlist;
					if(!object){
						
						$scope.selectUnits.unit = data.data.unitlist[0];
						$scope.selectHouse();
					}
					else{
						for(var item in $scope.selectUnits.units){
							if(object.unitId == $scope.selectUnits.units[item].unitId){
								$scope.selectUnits.unit = $scope.selectUnits.units[item];
								$scope.selectHouse(object);
								break;
							}
						}
						
					}
				}else {
					alert("无法选择该选项，暂无对应楼栋，请重新选择");
					$scope.selectUnits.units = null;
					$scope.selectUnits.unit = null;
					$scope.selectHouses.houses = null;
					$scope.selectHouses.house = null;
				}
			}).error(function(data) {
				alert("楼栋选择异常，请检查网络！");
			});
		}
		
		$scope.selectHouse = function(object) {
			appSV.getHouseListBean.premisesId = $scope.selectPremises.premise.premisesId;
			appSV.getHouseListBean.unitId = $scope.selectUnits.unit.unitId;
			var promise = appSV.getHouseList();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.selectHouses.houses = data.data.houselist;
					if(!object){
						
						$scope.selectHouses.house = data.data.houselist[0];
					}
					else {
						for(var item in $scope.selectHouses.houses){
							if(object.houseId == $scope.selectHouses.houses[item].houseId){
								$scope.selectHouses.house = $scope.selectHouses.houses[item];
								break;
							}
						}
					}
				}else {
					alert("无法选择该选项，暂无对应房号，请重新选择");
					$scope.selectHouses.houses = null;
					$scope.selectHouses.house = null;
					
				}
				
			}).error(function(data) {
				alert("房号选择异常，请检查网络！");
			});
		}
		
		$scope.saveAdd = function () {
			
			var reg = new RegExp("(^1[3|4|5|7|8][0-9]\\d{8}$)|(^(\\d{3,4}-)\\d{7,8}$)");
			if(!reg.test($scope.object.userLoginname)){
				jq(showStackBottomRight("error", "亲", "用户账号输入有误，请输入手机号码形式的账号！"));
				
				return;
			}
			
			if(($scope.object.roleId=='2' || $scope.object.roleId=='3') && !reg.test($scope.object.ownerTel)){
				jq(showStackBottomRight("error", "亲", "业主电话输入有误！"));
				
				return;
			}
			appSV.getUserAddBean.userLoginname = $scope.object.userLoginname;
			appSV.getUserAddBean.userNickname = $scope.object.userNickname;
			appSV.getUserAddBean.roleId = $scope.object.roleId;
			appSV.getUserAddBean.ownerTel = $scope.object.ownerTel;
			appSV.getUserAddBean.premiseId = $scope.selectPremises.premise.premisesId;
			appSV.getUserAddBean.unitId = $scope.selectUnits.unit.unitId;
			appSV.getUserAddBean.houseId = $scope.selectHouses.house.houseId;
			
			var ii = layer.load('loading...');
			appSV.getUserAdd().then(function(response) {
				
				layer.close(ii);
				if(response.data.status == 200) {
					
					$scope.page();
				}
				jq(showStackBottomRight("info", "亲,", response.data.msg));
			}, function(reason) {
				jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
				layer.close(ii);
			}, function(value) {
				jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
				layer.close(ii);
			})
		}
		
		$scope.userUpdate = function () {
			if(!judgePermission("update",[0])){
				return ;
			}
			
			var reg = new RegExp("(^1[3|4|5|7|8][0-9]\\d{8}$)|(^(\\d{3,4}-)\\d{7,8}$)");
			if(!reg.test($scope.object.userLoginname)){
				jq(showStackBottomRight("error", "亲", "用户账号输入有误，请输入手机号码形式的账号！"));
				
				return;
			}
			
			if(($scope.object.roleId=='2' || $scope.object.roleId=='3') && !reg.test($scope.object.ownerTel)){
				jq(showStackBottomRight("error", "亲", "业主电话输入有误！"));
				
				return;
			}
			
			appSV.getUserUpdateBean.userLoginname = $scope.object.userLoginname;
			appSV.getUserUpdateBean.userNickname = $scope.object.userNickname;
			appSV.getUserUpdateBean.roleId = $scope.object.roleId;
			appSV.getUserUpdateBean.ownerTel = $scope.object.ownerTel;
			appSV.getUserUpdateBean.userId = $scope.object.userId;
			if($scope.object.roleId=='2' || $scope.object.roleId=='3'){
				appSV.getUserUpdateBean.premiseId = $scope.selectPremises.premise.premisesId;
				appSV.getUserUpdateBean.unitId = $scope.selectUnits.unit.unitId;
				appSV.getUserUpdateBean.houseId = $scope.selectHouses.house.houseId;
			}
			else{
				appSV.getUserUpdateBean.premiseId = null;
				appSV.getUserUpdateBean.unitId = null;
				appSV.getUserUpdateBean.houseId = null;
			}
			
			var ii = layer.load('loading...');
			appSV.getUserUpdate().then(function(response) {
				
				layer.close(ii);
				if(response.data.status == 200) {
					
					$scope.page();
				}
				
				jq(showStackBottomRight("info", "亲,", response.data.msg));
			}, function(reason) {
				jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
				layer.close(ii);
			}, function(value) {
				jq(showStackBottomRight("error", "亲，失败了", "请刷新一下或检查网络"));
				layer.close(ii);
			})
		}
		
		$scope.styleCheck = function(str, isTrue) {
			var object = angular.element("#" + str);
			var show = angular.element("#" + str + "-show");
			if(isTrue) {
				object.css("border-color","#c5c5c5 #c5c5c5");
				show.css("display", "none");
			}else {
				object.css("border-color","#FF0000 #FF0000");
				show.css("display", "block");
			}
		}
		
		//初始化小区列表
		$scope.selectPremise();

	})