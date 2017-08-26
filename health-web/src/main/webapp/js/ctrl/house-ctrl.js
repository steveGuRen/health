
'use strict';
angular.module('controller.house', [])
	.controller('houseCtrl', function($log, $scope, $location, $uibModal, initHouseData, commonSV, houseSV) {
		
		$scope.queryParam = {};
		$scope.objects = initHouseData.houseInfoList;
		$scope.object = {};
		$scope.queryParam.currentPage = 1;
		$scope.queryParam.totalCount = initHouseData.count;
		$scope.queryParam.totalPage = Math.ceil(initHouseData.count/rows);
		$scope.pageadd = function(){
			if(!judgePermission('add',[])){
				return;
			}
			$scope.pageAdd = !$scope.pageAdd;
			$scope.pageContent = !$scope.pageContent;
		}
		
		$scope.pageupdate = function(){
			
			$scope.pageUpdate = !$scope.pageUpdate;
			$scope.pageContent = !$scope.pageContent;
		}
		
		
		$scope.skipToUpdate = function(object) {
			
			if(!object){
				$scope.object = {};
				$scope.object.ownerList = [];
				$scope.object.build = null;
				$scope.object.unit = null;
				$scope.object.floor = null;
				$scope.object.house = null;
				$scope.setBuilds.builds = null;
				$scope.setUnits.units = null;
				$scope.setFloors.floors = null;
				$scope.setHouses.houses = null;
				
			}
			else{
				$scope.object = $.extend(true,{},$scope.object,object);
				$scope.objectOld = $.extend(true,{},$scope.objectOld,object);
				$scope.object.houseType = $scope.object.houseType+'';
				
				$scope.object.ownerList = [];
				houseSV.ownerListBean.houseId= object.houseId;
				var ii = layer.load('loading...');
				houseSV.ownerList().then(function(response) {
					layer.close(ii);
					if(response.data && response.data.data){
						
						$scope.object.ownerList = $.extend(true,[],$scope.object.ownerList,response.data.data.ownerList);
						$scope.object.ownerListOld = $.extend(true,[],$scope.object.ownerListOld,response.data.data.ownerList);
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
			}
			
		}
		
		
		
		//分页
		pagination($scope.queryParam.totalPage, $scope.queryParam.currentPage, 'housePage', $scope);
		
		$scope.selectPremises = {
				premises:null,
				premise:null
		}
		
		$scope.selectBuilds = {
				builds:null,
				build:null
		}
		
		$scope.selectUnits = {
				units:null,
				unit:null
		}
		
		$scope.selectFloors = {
				floors:null,
				floor:null
		}
		
		$scope.selectHouses = {
				houses:null,
				house:null
		}
		$scope.selectPremise = function() {
			getAllPremises();
			$scope.selectPremises.premises=[];
			for(var x in premisesIdList){
				for(var y in allPremises){
					if(premisesIdList[x]==allPremises[y].premisesId){
						$scope.selectPremises.premises.push(allPremises[y]);
						break;
					}
				}
			}
			if($scope.selectPremises.premises!=null&&$scope.selectPremises.premises.length>0){
				$scope.queryParam.premise=$scope.selectPremises.premises[0];
				$scope.selectBuild($scope.queryParam.premise.premisesId);
			}
		}
		
		$scope.selectBuild = function(premisesId) {
			if(!premisesId){
				$scope.queryParam.build = null;
				$scope.queryParam.unit = null;
				$scope.queryParam.floor = null;
				$scope.queryParam.house = null;
				$scope.selectBuilds.builds = null;
				$scope.selectUnits.units = null;
				$scope.selectFloors.floors = null;
				$scope.selectHouses.houses = null;
				return;
			}
			commonSV.buildListBean.premisesId = premisesId;
			var promise = commonSV.buildlist(premisesId);
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.selectBuilds.builds = data.data.buildList ;
					$scope.queryParam.build = null;
					$scope.queryParam.unit = null;
					$scope.queryParam.floor = null;
					$scope.queryParam.house = null;
					$scope.selectUnits.units = null;
					$scope.selectFloors.floors = null;
					$scope.selectHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		$scope.selectUnit = function(premisesId,buildId) {
			if(!buildId){
				$scope.queryParam.unit = null;
				$scope.queryParam.floor = null;
				$scope.queryParam.house = null;
				$scope.selectUnits.units = null;
				$scope.selectFloors.floors = null;
				$scope.selectHouses.houses = null;
				return;
			}
			commonSV.unitListBean.premisesId = premisesId;
			commonSV.unitListBean.buildId = buildId;
			var promise = commonSV.unitlist();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.selectUnits.units = data.data.unitList ;
					$scope.queryParam.unit = null;
					$scope.queryParam.floor = null;
					$scope.queryParam.house = null;
					$scope.selectFloors.floors = null;
					$scope.selectHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		$scope.selectFloor = function(premisesId,buildId,unitId) {
			if(!unitId){
				$scope.queryParam.floor = null;
				$scope.queryParam.house = null;
				$scope.selectFloors.floors = null;
				$scope.selectHouses.houses = null;
				return;
			}
			commonSV.housefloorListBean.premisesId = premisesId;
			commonSV.housefloorListBean.buildId = buildId;
			commonSV.housefloorListBean.unitId = unitId;
			var promise = commonSV.housefloorlist();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.selectFloors.floors = data.data.houseFloorList;
					$scope.queryParam.floor = null;
					$scope.queryParam.house = null;
					$scope.selectHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		$scope.selectHouse = function(premisesId,buildId,unitId,houseFloor) {
			if(!houseFloor){
				$scope.selectHouses.houses = null;
				$scope.queryParam.house = null;
				return;
			}
			commonSV.houseListBean.premisesId = premisesId;
			commonSV.houseListBean.buildId = buildId;
			commonSV.houseListBean.unitId = unitId;
			commonSV.houseListBean.houseFloor = houseFloor;
			commonSV.houseListBean.houseTypeList = null;
			var promise = commonSV.houselist();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.selectHouses.houses = data.data.houseList;
					$scope.queryParam.house = null;
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		$scope.selectPremise();
		
		$scope.setPremises = {
				premises:null,
				premise:null
		}
		
		$scope.setBuilds = {
				builds:null,
				build:null
		}
		
		$scope.setUnits = {
				units:null,
				unit:null
		}
		
		$scope.setFloors = {
				floors:null,
				floor:null
		}
		
		$scope.setHouses = {
				houses:null,
				house:null
		}
		
		$scope.setPremise = function(change) {
			commonSV.premisesListBean.premisesIdList=null;
			var promise = commonSV.premiseslist();
			promise.success(function(data) {
				$scope.setPremises.premises = data.data.premisesList;
				//所有小区列表  与现有小区列表  对比有共同的标志为myFlag=true;
				for(var x in $scope.setPremises.premises){
					$scope.setPremises.premises[x].myFlag=false;
					for(var y in premisesIdList){
						if($scope.setPremises.premises[x].premisesId==premisesIdList[y]){
							$scope.setPremises.premises[x].myFlag=true;
							break;
						}
					}
				}
				if(change){
					$scope.object.selectPremiseName='';
					$scope.object.premise = null;
					$scope.object.build = null;
					$scope.object.unit = null;
					$scope.object.floor = null;
					$scope.object.house = null;
					$scope.setBuilds.builds = null;
					$scope.setUnits.units = null;
					$scope.setFloors.floors = null;
					$scope.setHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		$scope.setBuild = function(premisesName) {
			var premisesId=null;
			$scope.object.premise=null;
			for(var x in $scope.setPremises.premises){
				if($scope.setPremises.premises[x].premisesName==premisesName){
					premisesId=$scope.setPremises.premises[x].premisesId;
					$scope.object.premise=$scope.setPremises.premises[x];
					break;
				}
			}
			if(!premisesId){
				$scope.object.build = null;
				$scope.object.unit = null;
				$scope.object.floor = null;
				$scope.object.house = null;
				$scope.setBuilds.builds = null;
				$scope.setUnits.units = null;
				$scope.setFloors.floors = null;
				$scope.setHouses.houses = null;
				return;
			}
			commonSV.buildListBean.premisesId = premisesId;
			var promise = commonSV.buildlist(premisesId);
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.setBuilds.builds = data.data.buildList 
					$scope.object.build = null;
					$scope.object.unit = null;
					$scope.object.floor = null;
					$scope.object.house = null;
					$scope.setUnits.units = null;
					$scope.setFloors.floors = null;
					$scope.setHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			})
		}
		
		$scope.setUnit = function(premisesId,buildId) {
			if(!buildId){
				$scope.object.unit = null;
				$scope.object.floor = null;
				$scope.object.house = null;
				$scope.setUnits.units = null;
				$scope.setFloors.floors = null;
				$scope.setHouses.houses = null;
				return;
			}
			commonSV.unitListBean.premisesId = premisesId;
			commonSV.unitListBean.buildId = buildId;
			var promise = commonSV.unitlist();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.setUnits.units = data.data.unitList ;
					$scope.object.unit = null;
					$scope.object.floor = null;
					$scope.object.house = null;
					$scope.setFloors.floors = null;
					$scope.setHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.setFloor = function(premisesId,buildId,unitId) {
			if(!unitId){
				$scope.object.floor = null;
				$scope.object.house = null;
				$scope.setFloors.floors = null;
				$scope.setHouses.houses = null;
				return;
			}
			commonSV.housefloorListBean.premisesId = premisesId;
			commonSV.housefloorListBean.buildId = buildId;
			commonSV.housefloorListBean.unitId = unitId;
			var promise = commonSV.housefloorlist();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.setFloors.floors = data.data.houseFloorList;
					$scope.object.floor = null;
					$scope.object.house = null;
					$scope.setHouses.houses = null;
				}
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.setHouse = function(premisesId,buildId,unitId,houseFloor) {
			if(!houseFloor){
				$scope.setHouses.houses = null;
				$scope.object.house = null;
				return;
			}
			commonSV.houseListBean.premisesId = premisesId;
			commonSV.houseListBean.buildId = buildId;
			commonSV.houseListBean.unitId = unitId;
			commonSV.houseListBean.houseFloor = houseFloor;
			commonSV.houseListBean.houseTypeList = null;
			var promise = commonSV.houselist();
			promise.success(function(data) {
				if(data.status == 200) {
					$scope.setHouses.houses = data.data.houseList;
					$scope.object.house = null;
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.setPremise();
		
		$scope.queryList = function(page) {
			
			var pagin = ispage($scope.queryParam.totalPage,page)
			
			if(!pagin.status && page!=1){
				$(showStackBottomRight("error", "亲", pagin.msg));
				return;
			}
			
		
			houseSV.houseinfoListBean.page = page;
			houseSV.houseinfoListBean.rows = rows;
			if($scope.queryParam.premise){
				
				houseSV.houseinfoListBean.premisesId = $scope.queryParam.premise.premisesId;     
			}
			else{
				houseSV.houseinfoListBean.premisesId = null;
			}
			if($scope.queryParam.build){
				
				houseSV.houseinfoListBean.buildId = $scope.queryParam.build.buildId;      
			}
			else{
				houseSV.houseinfoListBean.buildId = null;
			}
			if($scope.queryParam.unit){
				
				houseSV.houseinfoListBean.unitId= $scope.queryParam.unit.unitId;
			}
			else{
				houseSV.houseinfoListBean.unitId= null;
			}
			if($scope.queryParam.floor){
				
				houseSV.houseinfoListBean.houseFloor= $scope.queryParam.floor.houseFloor;
			}
			else{
				houseSV.houseinfoListBean.houseFloor= null;
			}
			if($scope.queryParam.house){
				
				houseSV.houseinfoListBean.houseId= $scope.queryParam.house.houseId;
			}
			else{
				houseSV.houseinfoListBean.houseId= null;
			}
			houseSV.houseinfoListBean.billingAreaStart= $scope.queryParam.billingAreaStart;
			houseSV.houseinfoListBean.billingAreaEnd= $scope.queryParam.billingAreaEnd;
			houseSV.houseinfoListBean.houseType= $scope.queryParam.houseType;
			var ii = layer.load('loading...');
			houseSV.houseinfoList().then(function(response) {
				
				if(response.data && response.data.data){
					layer.close(ii);
					$scope.objects = response.data.data.houseInfoList;
					$scope.queryParam.totalPage = Math.ceil(response.data.data.count/rows);
					$scope.queryParam.totalCount = response.data.data.count;
					$scope.queryParam.currentPage = page;
					if($scope.queryParam.totalPage==0){
						$scope.queryParam.currentPage = 1;
					}
					//分页
					pagination($scope.queryParam.totalPage, $scope.queryParam.currentPage, 'housePage', $scope);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		$scope.addPremise = function(title,object){
			if(!judgePermission('add',[])){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-premise-popup.jsp",
					controller: 'addPremiseCtrl',
					size: "lg",
					resolve: {
						title: function () {
							return title;
						},
						object: function () {
							return object;
						},
					
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					$.ajax({
						type : "POST",
						async : false,
						url : "authentication/left",
						dataType:"json",
						data : {menuId:10},
						headers: {
							'Content-Type': 'application/x-www-form-urlencoded',
							'Authorization': "Bearer "  + accessToken
						},
						success : function(ajaxData) {
							if (ajaxData && ajaxData.data && ajaxData.data.premisesIdList
									&& ajaxData.data.premisesIdList.length > 0) {
								premisesIdList = ajaxData.data.premisesIdList;
								$scope.setPremise();
								$scope.selectPremise();
							} else {
								layer.alert("对不起，没有权限，请联系管理员");
								result = false;
							}
						},
						error : function() {
							//layer.close(ii);
							window.location.href="login";
						}
					});	
				});
		}
		
		$scope.updatePremise = function(title,object){
			var premisesId = [];
			premisesId.push(object.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-premise-popup.jsp",
					controller: 'updatePremiseCtrl',
					size: "lg",
					resolve: {
						title: function () {
							return title;
						},
						object: function () {
							return object;
						},
					
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					$scope.setPremise(true);
					$scope.selectPremise();
					
				});
		}
		
		$scope.deletePremise = function(title,object){
			var premisesId = [];
			premisesId.push(object.premisesId);
			if(!judgePermission('delete',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/confirm-popup.jsp",
					controller: 'deletePremiseCtrl',
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
					$scope.setPremise();
					$scope.selectPremise();
					
				});
		}
		
		$scope.addBuild = function(){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('add',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-build-popup.jsp",
					controller: 'addBuildCtrl',
					size: "lg",
					resolve: {
						
						object: function () {
							return $scope.object;
						},
						list: function(){
							return $scope.setBuilds.builds;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					
					$scope.setBuild($scope.object.premise.premisesName);
					
				});
		}

		$scope.updateBuild = function(object){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-build-update-popup.jsp",
					controller: 'updateBuildCtrl',
					size: "lg",
					resolve: {
						object: function () {
							return object;
						},
						list: function(){
							return $scope.setBuilds.builds;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(build){
					$scope.setBuild($scope.object.premise.premisesName);
					//$scope.object.build = build;
					
					
				});
		}
		
		$scope.deleteBuild = function(title,object){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('delete',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/confirm-popup.jsp",
					controller: 'deleteBuildCtrl',
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
					$scope.setBuild($scope.object.premise.premisesName);
					
					
				});
		}
		$scope.addUnit = function(){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('add',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-unit-popup.jsp",
					controller: 'addUnitCtrl',
					size: "lg",
					resolve: {
						
						object: function () {
							return $scope.object;
						},
						list: function(){
							return $scope.setUnits.units;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					
					$scope.setUnit($scope.object.premise.premisesId,$scope.object.build.buildId);
					
				});
		}
		
		$scope.updateUnit = function(object){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-unit-update-popup.jsp",
					controller: 'updateUnitCtrl',
					size: "lg",
					resolve: {
						object: function () {
							return object;
						},
						list: function(){
							return $scope.setUnits.units;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					$scope.setUnit($scope.object.premise.premisesId,$scope.object.build.buildId);
				});
		}
		
		$scope.deleteUnit = function(title,object){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('delete',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/confirm-popup.jsp",
					controller: 'deleteUnitCtrl',
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
					$scope.setUnit($scope.object.premise.premisesId,$scope.object.build.buildId);
				});
		}
		
		$scope.addFloor = function(){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('add',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-floor-popup.jsp",
					controller: 'addFloorCtrl',
					size: "lg",
					resolve: {
						
						object: function () {
							return $scope.object;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					
					$scope.setFloor($scope.object.premise.premisesId,$scope.object.build.buildId,$scope.object.unit.unitId);
					
				});
		}
		
		$scope.addHouse = function(){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('add',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-house-popup.jsp",
					controller: 'addHouseCtrl',
					size: "lg",
					resolve: {
						
						object: function () {
							return $scope.object;
						},
						list: function(){
							return $scope.setHouses.houses;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					
					$scope.setHouse($scope.object.premise.premisesId,$scope.object.build.buildId,$scope.object.unit.unitId,
							 $scope.object.floor.houseFloor);
					
				});
		}

		$scope.updateHouse = function(object){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/house-house-update-popup.jsp",
					controller: 'updateHouseCtrl',
					size: "lg",
					resolve: {
						object: function () {
							return object;
						},
						list: function(){
							return $scope.setHouses.houses;
						}
					}
				});
				
				//回调方法，从子弹框关闭的时候传递object值到主页面中
				modalInstance.result.then(function(){
					$scope.setHouse($scope.object.premise.premisesId,$scope.object.build.buildId,$scope.object.unit.unitId,
							 $scope.object.floor.houseFloor);
				});
		}
		
		$scope.deleteHouse = function(title,object){
			var premisesId = [];
			premisesId.push($scope.object.premise.premisesId);
			if(!judgePermission('delete',premisesId)){
				return;
			}
			 var modalInstance = $uibModal.open({
					animation: true,
					templateUrl: "../finance/jsp/popup/confirm-popup.jsp",
					controller: 'deleteHouseCtrl',
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
					$scope.setHouse($scope.object.premise.premisesId,$scope.object.build.buildId,$scope.object.unit.unitId,
							 $scope.object.floor.houseFloor);
				});
		}
		
		$scope.addOwner = function(){
			var owner = {};
			$scope.object.ownerList.push(owner);
		}
		
		$scope.deleteOwner = function(index){
			
			$scope.object.ownerList.splice(index,1);
		}
		
		$scope.updateOwner = function(){
			var premisesId = [];
			premisesId.push($scope.object.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: "../finance/jsp/popup/house-owneradd-popup.jsp",
				controller: 'ownerAddCtrl',
				size: "lg",
				resolve: {
					object: function () {
						return $scope.object;
					},
				}
			});
			
			//回调方法，从子弹框关闭的时候传递object值到主页面中
			modalInstance.result.then(function(){
				$scope.object.ownerList = [];
				houseSV.ownerListBean.houseId= $scope.object.houseId;
				var ii = layer.load('loading...');
				houseSV.ownerList().then(function(response) {
					layer.close(ii);
					if(response.data && response.data.data){
						
						$scope.object.ownerList = $.extend(true,[],$scope.object.ownerList,response.data.data.ownerList);
						$scope.object.ownerListOld = $.extend(true,[],$scope.object.ownerListOld,response.data.data.ownerList);
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
			});
		}
		
		$scope.updateOwnerDelete = function(title,item,index){
			var premisesId = [];
			premisesId.push($scope.object.premisesId);
			if(!judgePermission('delete',premisesId)){
				return;
			}
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: "../finance/jsp/popup/confirm-popup.jsp",
				controller: 'ownerDeleteCtrl',
				size: "lg",
				resolve: {
					title: function () {
						return title;
					},
					object: function () {
						return item;
					},
					objectOld: function() {
						return $scope.object.ownerListOld[index];
					}
				}
			});
			
			//回调方法，从子弹框关闭的时候传递object值到主页面中
			modalInstance.result.then(function(status){
				if(status==200 || status == '200'){
					$scope.object.ownerList.splice(index,1);
				}
			});
		}
		
		$scope.ownerUpdate = function(item, index){ 
			var premisesId = [];
			premisesId.push($scope.object.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			if($scope.object.ownerList && $scope.object.ownerList.length>0){
				for(var i=0;i<$scope.object.ownerList.length;i++){
					if(($scope.object.ownerList[i].ownerTel==item.ownerTel) && (i!=index)){
						$(showStackBottomRight("info", "亲", "不能添加重复的业主信息"));
						   return;
					}
				}
			}
			if(!$scope.updateOwnerForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据没有填完整哦"));
				   return;
			   }
			
			 /*if(!item.ownerName || !item.ownerTel){
				 $(showStackBottomRight("info", "亲", "请输入业主名和业主联系方式"));
				 return;
			 }*/
				 
			 houseSV.ownerUpdateBean.premisesId = $scope.object.premisesId;
			 houseSV.ownerUpdateBean.buildId = $scope.object.buildId;
			 houseSV.ownerUpdateBean.unitId = $scope.object.unitId;
			 houseSV.ownerUpdateBean.houseFloor = $scope.object.houseFloor;
			 houseSV.ownerUpdateBean.houseId = $scope.object.houseId;
			 houseSV.ownerUpdateBean.ownerName = item.ownerName;
			 houseSV.ownerUpdateBean.ownerId = item.ownerId;
			 houseSV.ownerUpdateBean.ownerTel = item.ownerTel;
			 houseSV.ownerUpdateBean.paramOld = JSON.stringify($scope.object.ownerListOld[index]);
			 var ii = layer.load('loading...');
			 houseSV.ownerUpdate().then(function(response) {
				    layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		
		$scope.add = function(){ 
			var premisesId = [];
			premisesId.push($scope.object.premisesId);
			if(!judgePermission('add',premisesId)){
				return;
			}
			 if($scope.object.ownerList.length>0){
				 for(var i=0;i<$scope.object.ownerList.length;i++){
					 if(!$scope.object.ownerList[i].ownerName || !$scope.object.ownerList[i].ownerTel){
						 $(showStackBottomRight("info", "亲", "请输入业主名和业主联系方式"));
						 return;
					 }
				 }
			 }
			 
			 if($scope.object.premise){
				
				houseSV.addBean.premisesId = $scope.object.premise.premisesId;     
			 }
			 else{
				houseSV.addBean.premisesId = null;
				$(showStackBottomRight("info", "亲", "请输入所属项目"));
				return;
			 }
			 if($scope.object.build){
				
				houseSV.addBean.buildId = $scope.object.build.buildId;      
			 }
			 else{
				houseSV.addBean.buildId = null;
				$(showStackBottomRight("info", "亲", "请输入所属楼栋"));
				return;
			 }
			 if($scope.object.unit){
				
				houseSV.addBean.unitId= $scope.object.unit.unitId;
			 }
			 else{
				houseSV.addBean.unitId= null;
				$(showStackBottomRight("info", "亲", "请输入所属单元"));
				return;
			 }
			 if($scope.object.floor){
				
				houseSV.addBean.houseFloor= $scope.object.floor.houseFloor;
			 }
			 else{
				houseSV.addBean.houseFloor= null;
				$(showStackBottomRight("info", "亲", "请输入所属楼层"));
				return;
			 }
			 if($scope.object.house){
				
				houseSV.addBean.houseId= $scope.object.house.houseId;
			 }
			 else{
				houseSV.addBean.houseId= null;
				$(showStackBottomRight("info", "亲", "请输入所属房号"));
				return;
			 }
		 
			 houseSV.addBean.houseType = $scope.object.house.houseType;
			 houseSV.addBean.ownerList = JSON.stringify($scope.object.ownerList);
			 houseSV.addBean.houseArea = $scope.object.houseArea;
			 houseSV.addBean.comprisingArea = $scope.object.comprisingArea;
			 houseSV.addBean.billingArea = $scope.object.billingArea;
			 var ii = layer.load('loading...');
			 houseSV.add().then(function(response) {
				    layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						$scope.pageadd();
						$scope.queryList($scope.queryParam.currentPage);
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		$scope.update = function(){
			var premisesId = [];
			premisesId.push($scope.object.premisesId);
			if(!judgePermission('update',premisesId)){
				return;
			}
			if(!$scope.updateHouseForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据没有填完整哦"));
				   return;
			   }
			houseSV.houseUpdateBean.houseFloor = $scope.object.houseFloor;
			houseSV.houseUpdateBean.houseNum = $scope.object.houseNum;
			houseSV.houseUpdateBean.houseName = $scope.object.houseName;
			houseSV.houseUpdateBean.houseType = $scope.object.houseType;
			houseSV.houseUpdateBean.houseId = $scope.object.houseId;
			houseSV.houseUpdateBean.unitId = $scope.object.unitId;
			houseSV.houseUpdateBean.buildId = $scope.object.buildId;
			houseSV.houseUpdateBean.premisesId = $scope.object.premisesId;
			if($scope.objectOld.houseArea && $scope.object.houseArea==''){
				$(showStackBottomRight("info", "亲", "建筑面积不能改成空"));
				return;
			}
			if($scope.objectOld.comprisingArea && $scope.object.comprisingArea==''){
				$(showStackBottomRight("info", "亲", "套内面积不能改成空"));
				return;
			}
			if($scope.objectOld.billingArea && $scope.object.billingArea==''){
				$(showStackBottomRight("info", "亲", "计费面积不能改成空"));
				return;
			}
			houseSV.houseUpdateBean.houseArea = $scope.object.houseArea;
			houseSV.houseUpdateBean.comprisingArea = $scope.object.comprisingArea;
			houseSV.houseUpdateBean.billingArea = $scope.object.billingArea;
			houseSV.houseUpdateBean.paramOld = JSON.stringify($scope.objectOld);
			var ii = layer.load('loading...');
			houseSV.houseUpdate().then(function(response) {
				layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						$scope.pageupdate();
						$scope.queryList($scope.queryParam.currentPage);
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		

		$scope.houseImport = function(title){
			
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: "../finance/jsp/popup/import-popup.jsp",
				controller: 'houseImportCtrl',
				size: "lg",
				resolve: {
					title: function () {
						return title;
					}
				}
			});
			
			//回调方法，从子弹框关闭的时候传递object值到主页面中
			modalInstance.result.then(function(){
				$scope.queryList($scope.queryParam.currentPage);
			});
		}
		
		$scope.houseExport = function(title){
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: "../finance/jsp/popup/confirm-popup.jsp",
				controller: 'houseExportCtrl',
				size: "lg",
				resolve: {
					title: function () {
						return title;
					},
					object: function () {
						return $scope.queryParam;
					}
				}
			});
			
			//回调方法，从子弹框关闭的时候传递object值到主页面中
			modalInstance.result.then(function(){
			});
		}
	})
	.controller('houseExportCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			 var premisesId=null;
			 var buildId=null;
			 var unitId=null;
			 var houseId=null;
			 var houseFloor=null;
			 
			 if(object.premise){
				 premisesId = object.premise.premisesId;
			 }
			 if(object.build){
				 buildId = object.build.buildId;
			 }
			 if(object.unit){
				 unitId = object.unit.unitId;
			 }
			 if(object.floor){
				 houseFloor = object.floor.houseFloor;
			 }
			 if(object.house){
				 houseId = object.premise.houseId;
			 }
			 
			 
			 var urlParams =  strcat([	
			                           {page: 1},
				                       {rows: 20000},
				                       {premisesId: premisesId},
				                       {buildId: buildId},
				                       {unitId: unitId},
				                       {houseId: houseId},
				                       {houseFloor: houseFloor},
				                       {billingAreaStart: object.billingAreaStart||null},
				                       {billingAreaEnd: object.billingAreaEnd||null},
				                       {houseType: object.houseType||null},
				                       {accessToken: accessToken}
				                       ]);
			
			window.open(contextPath + "/house/getExcel?" + urlParams);
			$scope.cancel();
		}
	})
	.controller('houseImportCtrl', function ($scope, $uibModalInstance, title, FileUploader, houseSV) {
		$scope.title = title;
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.uploader = new FileUploader({
			url: "house/importExcel",
			queueLimit: 1,   //文件个数 
			autoUpload: false,
			headers:{
				'Authorization': "Bearer "  + accessToken
			}
		})
		//house/premisesIdList
		$scope.uploader.onCompleteItem  = function(item, response, status, headers) {
			$(showStackBottomRight("info", "亲", response.msg));
			item.remove();
			$scope.uploader.clearQueue();
	    }
		
		$scope.uploader.onAfterAddingFile = function(){
			
		}
		
		/*$scope.onSuccess = function(){
			
		}
		*/
		$scope.confirm = function () {
			$scope.uploader.uploadAll();
			
			 
			$uibModalInstance.close();
			//document.import.submit();
			//window.open(contextPath + '/index#/house');
		}
	})
	.controller('ownerAddCtrl', function ($scope, $uibModalInstance, object, houseSV) {
		$scope.object = object;
		$scope.owner = {};
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if(!$scope.addOwnerForm.$valid) {
				   $(showStackBottomRight("info", "亲", "请输入业主名和正确的联系方式"));
				   return;
			   }
			/*
			 if(!$scope.owner.ownerName || !$scope.owner.ownerTel){
				 $(showStackBottomRight("info", "亲", "请输入业主名和业主联系方式"));
				 return;
			 }*/
			if($scope.object.ownerList && $scope.object.ownerList.length>0){
				for(var i=0;i<$scope.object.ownerList.length;i++){
					if($scope.object.ownerList[i].ownerTel==$scope.owner.ownerTel){
						$(showStackBottomRight("info", "亲", "不能添加重复的业主信息"));
						   return;
					}
				}
			}
			 houseSV.ownerAddBean.premisesId = $scope.object.premisesId;
			 houseSV.ownerAddBean.buildId = $scope.object.buildId;
			 houseSV.ownerAddBean.unitId = $scope.object.unitId;
			 houseSV.ownerAddBean.houseFloor = $scope.object.houseFloor;
			 houseSV.ownerAddBean.houseId = $scope.object.houseId;
			 houseSV.ownerAddBean.ownerName = $scope.owner.ownerName;
			 houseSV.ownerAddBean.ownerTel = $scope.owner.ownerTel;
			 var ii = layer.load('loading...');
			 houseSV.ownerAdd().then(function(response) {
				 layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						if(response.data.status==200 || response.data.status=='200'){
							$scope.object.ownerList.push($scope.owner);
						}
						$uibModalInstance.close();
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		
	})
	.controller('ownerDeleteCtrl', function ($scope, $uibModalInstance, title, object, houseSV, objectOld) {
		$scope.title = title;
		
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			houseSV.ownerDeleteBean.ownerId = object.ownerId;
			houseSV.ownerDeleteBean.paramOld = JSON.stringify(objectOld);
			var ii = layer.load('loading...');
			houseSV.ownerDelete().then(function(response) {
				layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						$uibModalInstance.close(response.data.status);
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		
	})
	.controller('addPremiseCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
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
		
		
	})
	.controller('updatePremiseCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
		$scope.object = $.extend(true,{},$scope.object,object);
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if(!$scope.addPremiseForm.$valid) {
				   $(showStackBottomRight("info", "亲", "有些数据格式错误哦"));
				   return;
			    }
			 houseSV.premiseUpdateBean.premisesId = $scope.object.premisesId;
			 houseSV.premiseUpdateBean.premisesName = $scope.object.premisesName;
			 houseSV.premiseUpdateBean.premisesPosition = $scope.object.premisesPosition;
			 houseSV.premiseUpdateBean.developer = $scope.object.developer;
			 houseSV.premiseUpdateBean.allArea = $scope.object.allArea;
			 houseSV.premiseUpdateBean.greenArea = $scope.object.greenArea;
			 houseSV.premiseUpdateBean.parkingNum = $scope.object.parkingNum;
			 houseSV.premiseUpdateBean.premisesDescriptions = $scope.object.premisesDescriptions;
			 houseSV.premiseUpdateBean.premisesCity = $scope.object.premisesCity;
			 houseSV.premiseUpdateBean.paramOld = JSON.stringify(object);
			 var ii = layer.load('loading...');
			 houseSV.premiseUpdate().then(function(response) {
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
	.controller('deletePremiseCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
		
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			houseSV.premiseDeleteBean.premisesId = object.premisesId;
			houseSV.premiseDeleteBean.paramOld = JSON.stringify(object);
			var ii = layer.load('loading...');
			houseSV.premiseDelete().then(function(response) {
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
	.controller('addBuildCtrl', function ($scope, $uibModalInstance, object, list, houseSV) {
		$scope.object = object;
		$scope.object.number = 0;
		$scope.object.addList = [];
		$scope.builds = "";
		if(list.length>0){
			
			for(var i=0;i<list.length;i++){
				if(i==0){
					$scope.builds = $scope.builds + list[i].buildName;
				}
				else{
					
					$scope.builds = $scope.builds + ',' + list[i].buildName;
				}
			}
		}
		
		$scope.minus = function(){
			if($scope.object.number >= 1){
				$scope.object.number = $scope.object.number - 1;
			}
			else {
				$(showStackBottomRight("error", "亲", "不能增加小于零的个数"));
			}
		}
		
		$scope.plus = function(){
			if($scope.object.number >= 0){
				$scope.object.number = $scope.object.number*1 + 1;
			}
			
		}
		
		$scope.addList = function (){
			var n = $scope.object.number - $scope.object.addList.length;
			if(n>0){
				for(var i=1; i<= n;i++){
					var item = {};
					$scope.object.addList.push(item);
				}
			} else if (n<0){
				$scope.object.addList.splice($scope.object.addList.length+n,-n);
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if(list.length>0){
				for(var i=0;i<list.length;i++){
					for(var j=0;j<$scope.object.addList.length;j++){
						
						if(list[i].buildNum==$scope.object.addList[j].buildNum){
							$(showStackBottomRight("error", "亲", $scope.object.addList[j].buildNum+"栋已存在"));
							return;
						} else if ($scope.object.addList[j].buildNum == null
								|| $scope.object.addList[j].buildNum == ""){
							$(showStackBottomRight("error", "亲", "不能添加空楼栋"));
							return;
						}
					}
				}
			} else {
				if ($scope.object.addList.length == 0){
					$(showStackBottomRight("error", "亲", "不能添加空楼栋"));
					return;
				} else {
					for (var i=0;i<$scope.object.addList.length;i++){
						if ($scope.object.addList[i].buildNum == null
								|| $scope.object.addList[i].buildNum == ""){
							$(showStackBottomRight("error", "亲", "不能添加空楼栋"));
							return;
						}
					}
				}
			}
		
			 
			 var addList = [];
			 if($scope.object.addList.length>0){
				 for(var i=0;i<$scope.object.addList.length;i++){
					 var build={};
					 if(addList.length==0){
						 build.buildName = $scope.object.addList[i].buildNum+'栋';
						 build.buildNum = $scope.object.addList[i].buildNum;
						 build.premisesId = $scope.object.premise.premisesId;
						 addList.push(build);
					 }
					 else{
						 for(var j=0;j<addList.length;j++){
							 if(addList[j].buildNum==$scope.object.addList[i].buildNum){
									$(showStackBottomRight("error", "亲", '不能重复添加'));
									return;
								}
								
						    }
						 build.buildName = $scope.object.addList[i].buildNum+'栋';
						 build.buildNum = $scope.object.addList[i].buildNum;
						 build.premisesId = $scope.object.premise.premisesId;
						 addList.push(build);
					 }
					 
				 }
			 }
			 
			 houseSV.buildAddBean.buildList = JSON.stringify(addList);
			 var ii = layer.load('loading...');
			 houseSV.buildAdd().then(function(response) {
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
	.controller('updateBuildCtrl', function ($scope, $uibModalInstance, list, object, houseSV) {
		$scope.object = $.extend(true,$scope.object,object);
		$scope.list = $.extend(true,$scope.list,list);
		$scope.listLength = list.length;
		$scope.builds = "";
		if(list.length>0){
			
			for(var i=0;i<list.length;i++){
				if(i==0){
					$scope.builds = $scope.builds + list[i].buildName;
				}
				else{
					
					$scope.builds = $scope.builds + ',' + list[i].buildName;
				}
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if($scope.listLength>0){
				
				for(var i=0;i<$scope.listLength;i++){
					if($scope.object.build.buildNum == $scope.list[i].buildNum){
						$(showStackBottomRight("error", "亲", $scope.list[i].buildNum+"栋已存在"));
						return;
					} else if ($scope.object.build.buildNum == "" ||
							$scope.object.build.buildNum == null){
						$(showStackBottomRight("error", "亲", "楼栋名不能为空"));
						return;
					}
				}
			 } else {
				 if ($scope.object.build.buildNum == "" ||
							$scope.object.build.buildNum == null){
						$(showStackBottomRight("error", "亲", "楼栋名不能为空"));
						return;
					}
			 }
			 $scope.object.build.buildName = $scope.object.build.buildNum + '栋';
			 houseSV.buildUpdateBean.buildId = $scope.object.build.buildId;
			 houseSV.buildUpdateBean.buildName = $scope.object.build.buildName;
			 houseSV.buildUpdateBean.buildNum = $scope.object.build.buildNum;
			 houseSV.buildUpdateBean.premisesId = $scope.object.premise.premisesId;
			 houseSV.buildUpdateBean.paramOld = JSON.stringify(object);
			 var ii = layer.load('loading...');
			 houseSV.buildUpdate().then(function(response) {
				 layer.close(ii);
					if(response.data && response.data.data){
						$(showStackBottomRight("info", "亲", response.data.msg));
						$uibModalInstance.close($scope.object.build);
						
					}
					
				}, function(reason) {
					layer.close(ii);
				}, function(value) {
					layer.close(ii);
				});
		}
		
		
	})
	.controller('deleteBuildCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
		
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			houseSV.buildDeleteBean.buildId = object.buildId;
			houseSV.buildDeleteBean.paramOld = JSON.stringify(object);
			var ii = layer.load('loading...');
			houseSV.buildDelete().then(function(response) {
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
	.controller('addUnitCtrl', function ($scope, $uibModalInstance, object, list, houseSV) {
		$scope.object = object;
		$scope.object.number = 0;
		$scope.object.addList = [];
		$scope.units = "";
		if(list.length>0){
			
			for(var i=0;i<list.length;i++){
				if(i==0){
					$scope.units = $scope.units + list[i].unitName;
				}
				else{
					
					$scope.units = $scope.units + ',' + list[i].unitName;
				}
			}
		}
		
		$scope.minus = function(){
			if($scope.object.number >= 1){
				$scope.object.number = $scope.object.number - 1;
			}
			else {
				$(showStackBottomRight("error", "亲", "不能增加小于零的个数"));
			}
		}
		
		$scope.plus = function(){
			if($scope.object.number >= 0){
				$scope.object.number = $scope.object.number*1 + 1;
			}
			
		}
		
		$scope.addList = function (){
			var n = $scope.object.number - $scope.object.addList.length;
			if(n>0){
				for(var i=1; i<= n;i++){
					var item = {};
					$scope.object.addList.push(item);
				}
			}else if (n<0){
				$scope.object.addList.splice($scope.object.addList.length+n,-n);
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if(list.length>0){
				
				for(var i=0;i<list.length;i++){
					for(var j=0;j<$scope.object.addList.length;j++){
						
						if(list[i].unitName==$scope.object.addList[j].unitName+'单元'){
							$(showStackBottomRight("error", "亲", $scope.object.addList[j].unitName+"已存在"));
							return;
						} else if ($scope.object.addList[j].unitName == null ||
								$scope.object.addList[j].unitName == ""){
							$(showStackBottomRight("error", "亲", "不能添加空单元"));
							return;
						}
					}
				}
			} else {
				if ($scope.object.addList.length == 0){
					$(showStackBottomRight("error", "亲", "不能添加空单元"));
					return;
				} else {
					for (var i=0;i<$scope.object.addList.length;i++){
						if ($scope.object.addList[i].unitName == null
								|| $scope.object.addList[i].unitName == ""){
							$(showStackBottomRight("error", "亲", "不能添加空单元"));
							return;
						}
					}
				}
			}
			 
			 var addList = [];
			 if($scope.object.addList.length>0){
				 for(var i=0;i<$scope.object.addList.length;i++){
					 var unit={};
					 if(addList.length==0){
						 
						 unit.unitName = $scope.object.addList[i].unitName+'单元';
						 unit.buildId = $scope.object.build.buildId;
						 unit.premisesId = $scope.object.premise.premisesId;
						 addList.push(unit);
					 }
					 else{
						 for(var j=0;j<addList.length;j++){
							 if(addList[j].unitName==$scope.object.addList[i].unitName+'单元'){
									$(showStackBottomRight("error", "亲", '不能添加重复数据'));
									return;
								}
							 
						 }
						 unit.unitName = $scope.object.addList[i].unitName+'单元';
						 unit.buildId = $scope.object.build.buildId;
						 unit.premisesId = $scope.object.premise.premisesId;
						 addList.push(unit);
					 }
				 }
			 }
			 
			 houseSV.unitAddBean.unitList = JSON.stringify(addList);
			 var ii = layer.load('loading...');
			 houseSV.unitAdd().then(function(response) {
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
	.controller('updateUnitCtrl', function ($scope, $uibModalInstance, list, object, houseSV) {
		$scope.object = $.extend(true,$scope.object,object);
		$scope.list = $.extend(true,$scope.list,list);
		$scope.listLength = list.length;
		$scope.units = "";
		if(list.length>0){
			
			for(var i=0;i<list.length;i++){
				if(i==0){
					$scope.units = $scope.units + list[i].unitName;
				}
				else{
					
					$scope.units = $scope.units + ',' + list[i].unitName;
				}
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if($scope.listLength>0){
				
				for(var i=0;i<$scope.listLength;i++){
					if($scope.object.unit.unitName == $scope.list[i].unitName){
						$(showStackBottomRight("error", "亲", $scope.object.unit.unitName+"已存在"));
						return;
					}else if ($scope.object.unit.unitName == null ||
							$scope.object.unit.unitName == ""){
						$(showStackBottomRight("error", "亲", "不能添加空单元"));
						return;
					}
				}
			 }
			
			 houseSV.unitUpdateBean.unitId = $scope.object.unit.unitId;
			 houseSV.unitUpdateBean.unitName = $scope.object.unit.unitName;
			 houseSV.unitUpdateBean.buildId = $scope.object.build.buildId;
			 houseSV.unitUpdateBean.premisesId = $scope.object.premise.premisesId;
			 houseSV.unitUpdateBean.paramOld = JSON.stringify(object);
			 var ii = layer.load('loading...');
			 houseSV.unitUpdate().then(function(response) {
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
	.controller('deleteUnitCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
		
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			houseSV.unitDeleteBean.unitId = object.unitId;
			houseSV.unitDeleteBean.paramOld = JSON.stringify(object);
			var ii = layer.load('loading...');
			houseSV.unitDelete().then(function(response) {
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
	.controller('addFloorCtrl', function ($scope, $uibModalInstance, object, houseSV, commonSV) {
		$scope.object = object;
		$scope.house = {};
		$scope.floor = {};
		$scope.floor.number = 0;
		$scope.house.number = 0;
		$scope.object.houseType = '0';
		$scope.object.addList = [];
		commonSV.houseListBean.premisesId = object.premise.premisesId;
		commonSV.houseListBean.buildId = object.build.buildId;
		commonSV.houseListBean.unitId = object.unit.unitId;
		commonSV.houseListBean.houseFloor = null;
		var promise = commonSV.houselist();
		promise.success(function(data) {
			if(data.status == 200) {
				$scope.list = data.data.houseList;
				
			}
			
		}, function(reason) {
			layer.close(ii);
		}, function(value) {
			layer.close(ii);
		});
		
		$scope.minus = function(obj){
			if(obj.number >= 1){
				obj.number = obj.number - 1;
				
			}
			else {
				$(showStackBottomRight("error", "亲", "不能增加小于零的个数"));
			}
			return obj.number;
		}
		
		$scope.plus = function(obj){
			if(obj.number >= 0){
				obj.number = obj.number*1 + 1;
			}
			return obj.number;
			
		}
		
		$scope.addList = function (){
			$scope.object.addList = [];
			var n = $scope.floor.number;
			var m = $scope.house.number;
			if(n>0 && m>0 ){
				for(var i=1; i<= n;i++){
					for(var j=1; j<= m;j++){
						
						var item = {};
						item.houseFloor = i;
						if(j<10){
							
							item.houseNum = i+'0'+j;
						}
						else{
							item.houseNum = i+''+j;
						}
						$scope.object.addList.push(item);
					}
				}
			}  else{
				$(showStackBottomRight("error", "亲", "请输入楼层数和每层户数"));
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if($scope.object.addList.length==0){
				$(showStackBottomRight("error", "亲", "请添加新增楼层和房屋信息"));
				return;
			}
			if ($scope.object.houseType == null){
				$(showStackBottomRight("error", "亲", "请添加房屋类型"));
				return;
			}
			
			if($scope.list.length>0 && $scope.object.addList.length>0){
				
				for(var i=0;i<$scope.list.length;i++){
					for(var j=0;j<$scope.object.addList.length;j++){
						
						if($scope.list[i].houseNum==$scope.object.addList[j].houseNum && $scope.list[i].houseFloor==$scope.object.addList[j].houseFloor){
							$(showStackBottomRight("error", "亲", $scope.object.addList[j].houseNum+"已存在"));
							return;
						} else if ($scope.object.addList[j].houseNum == null || 
								$scope.object.addList[j].houseNum == "" || $scope.object.addList[j].houseFloor == null
								|| $scope.object.addList[j].houseFloor == ""){
							$(showStackBottomRight("error", "亲", "楼层和房号不能为空"));
							return;
						}
					}
				}
			} else if ($scope.object.addList.length>0 && $scope.list.length == 0){
				for (var i=0;i<$scope.object.addList.length;i++){
					if ($scope.object.addList[i].houseNum == null || 
							$scope.object.addList[i].houseNum == "" || 
							$scope.object.addList[i].houseFloor == null
							|| $scope.object.addList[i].houseFloor == ""){
						$(showStackBottomRight("error", "亲", "楼层和房号不能为空"));
						return;
					}
				}
			}
			 
			 var addList = [];
			 if($scope.object.addList.length>0){
				 for(var i=0;i<$scope.object.addList.length;i++){
					 var house={};
					 if(addList.length==0){
						 house.houseFloor = $scope.object.addList[i].houseFloor;
						 house.houseNum = $scope.object.addList[i].houseNum;
						 house.houseName = $scope.object.addList[i].houseName;
						 house.houseType = $scope.object.houseType;
						 house.unitId = $scope.object.unit.unitId;
						 house.buildId = $scope.object.build.buildId;
						 house.premisesId = $scope.object.premise.premisesId;
						 addList.push(house);
					 }
					 else{
						 for(var j=0;j<addList.length;j++){
							 if(addList[j].houseNum==$scope.object.addList[i].houseNum && addList[j].houseFloor==$scope.object.addList[i].houseFloor){
								 $(showStackBottomRight("error", "亲", "不能添加重复数据"));
									return;
							 }
						 }
						 house.houseFloor = $scope.object.addList[i].houseFloor;
						 house.houseNum = $scope.object.addList[i].houseNum;
						 house.houseName = $scope.object.addList[i].houseName;
						 house.houseType = $scope.object.houseType;
						 house.unitId = $scope.object.unit.unitId;
						 house.buildId = $scope.object.build.buildId;
						 house.premisesId = $scope.object.premise.premisesId;
						 addList.push(house);
					 }
					 
				 }
			 }
			 
			 houseSV.housefloorAddBean.houseList = JSON.stringify(addList);
			 var ii = layer.load('loading...');
			 houseSV.housefloorAdd().then(function(response) {
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
	.controller('addHouseCtrl', function ($scope, $uibModalInstance, object, list, houseSV) {
		$scope.object = object;
		$scope.object.number = 0;
		$scope.object.addList = [];
		$scope.object.houseType = '0';
		$scope.houses = "";
		if(list.length>0){
			
			for(var i=0;i<list.length;i++){
				if(i==0){
					$scope.houses = $scope.houses + list[i].houseNum+'号';
				}
				else{
					
					$scope.houses = $scope.houses + ',' + list[i].houseNum+'号';
				}
			}
		}
		
		$scope.minus = function(){
			if($scope.object.number >= 1){
				$scope.object.number = $scope.object.number - 1;
			}
			else {
				$(showStackBottomRight("error", "亲", "不能增加小于零的个数"));
			}
		}
		
		$scope.plus = function(){
			if($scope.object.number >= 0){
				$scope.object.number = $scope.object.number*1 + 1;
			}
			
		}
		
		$scope.addList = function (){
			var n = $scope.object.number - $scope.object.addList.length;
			if(n>0){
				for(var i=1; i<= n;i++){
					var item = {};
					$scope.object.addList.push(item);
				}
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if(list.length>0){
				
				for(var i=0;i<list.length;i++){
					for(var j=0;j<$scope.object.addList.length;j++){
						
						if(list[i].houseNum==$scope.object.addList[j].houseNum){
							$(showStackBottomRight("error", "亲", $scope.object.addList[j].houseNum+"已存在"));
							return;
						}
					}
				}
			}
			
			 var addList = [];
			 if($scope.object.addList.length>0){
				 for(var i=0;i<$scope.object.addList.length;i++){
					 if(!$scope.object.addList[i].houseNum || $scope.object.addList[i].houseNum==''){
						 $(showStackBottomRight("error", "亲", "请填写所有新增房号"));
							return;
					 }
					 var house={};
					 if(addList.length==0){
						 house.houseFloor = $scope.object.floor.houseFloor;
						 house.houseNum = $scope.object.addList[i].houseNum;
						 house.houseName = $scope.object.addList[i].houseName;
						 house.houseType = $scope.object.houseType;
						 house.unitId = $scope.object.unit.unitId;
						 house.buildId = $scope.object.build.buildId;
						 house.premisesId = $scope.object.premise.premisesId;
						 addList.push(house);
					 }
					 else{
						 for(var j=0;j<addList.length;j++){
							 if(addList[j].houseNum==$scope.object.addList[i].houseNum){
								 $(showStackBottomRight("error", "亲", "不能添加重复数据"));
									return;
							 }
						 }
						 house.houseFloor = $scope.object.floor.houseFloor;
						 house.houseNum = $scope.object.addList[i].houseNum;
						 house.houseName = $scope.object.addList[i].houseName;
						 house.houseType = $scope.object.houseType;
						 house.unitId = $scope.object.unit.unitId;
						 house.buildId = $scope.object.build.buildId;
						 house.premisesId = $scope.object.premise.premisesId;
						 addList.push(house);
					 }
					 
				 }
			 }
			 
			 houseSV.houseAddBean.houseList = JSON.stringify(addList);
			 var ii = layer.load('loading...');
			 houseSV.houseAdd().then(function(response) {
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
	.controller('updateHouseCtrl', function ($scope, $uibModalInstance, list, object, houseSV) {
		$scope.object = $.extend(true,$scope.object,object);
		$scope.list = $.extend(true,$scope.list,list);
		$scope.listLength = list.length;
		$scope.houses = "";
		$scope.object.houseType = object.house.houseType+'';
		
		if(list.length>0){
			
			for(var i=0;i<list.length;i++){
				if(i==0){
					$scope.houses = $scope.houses + list[i].houseNum +'号';
				}
				else{
					
					$scope.houses = $scope.houses + ',' + list[i].houseNum+'号';
				}
			}
		}
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			if($scope.listLength>0){
				
				for(var i=0;i<$scope.listLength;i++){
					if($scope.object.house.houseNum == $scope.list[i].houseNum && $scope.object.house.houseId != $scope.list[i].houseId){
						$(showStackBottomRight("error", "亲", $scope.object.house.houseNum+"已存在"));
						return;
					} else if ($scope.object.house.houseNum == null ||
							$scope.object.house.houseNum == ""){
						$(showStackBottomRight("error", "亲", "房号不能为空"));
						return;
					}
				}
			 }
			
			houseSV.houseUpdateBean.houseFloor = $scope.object.floor.houseFloor;
			houseSV.houseUpdateBean.houseNum = $scope.object.house.houseNum;
			houseSV.houseUpdateBean.houseName = $scope.object.house.houseName;
			houseSV.houseUpdateBean.houseType = $scope.object.houseType;
			houseSV.houseUpdateBean.houseId = $scope.object.house.houseId;
			houseSV.houseUpdateBean.unitId = $scope.object.unit.unitId;
			houseSV.houseUpdateBean.buildId = $scope.object.build.buildId;
			houseSV.houseUpdateBean.premisesId = $scope.object.premise.premisesId;
			houseSV.houseUpdateBean.houseArea = null;
			houseSV.houseUpdateBean.comprisingArea = null;
			houseSV.houseUpdateBean.billingArea = null;
			houseSV.houseUpdateBean.paramOld = JSON.stringify(object);
			var ii = layer.load('loading...');
			houseSV.houseUpdate().then(function(response) {
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
	.controller('deleteHouseCtrl', function ($scope, $uibModalInstance, title, object, houseSV) {
		$scope.title = title;
		
		$scope.skin = getCookie("skin");
		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};
		
		$scope.confirm = function () {
			houseSV.houseDeleteBean.houseId = object.houseId;
			houseSV.houseDeleteBean.paramOld = JSON.stringify(object);
			var ii = layer.load('loading...');
			houseSV.houseDelete().then(function(response) {
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