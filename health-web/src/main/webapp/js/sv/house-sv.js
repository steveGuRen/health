/**
 * 房屋信息管理接口
 */

angular.module('service.house', [])
	.factory('houseSV', function($http) {
		
		
		var houseinfoListBean = {       
				premisesId: null,     
				buildId: null,      
				unitId: null,
				houseId: null,
				houseFloor: null,
				billingAreaStart: null,
				billingAreaEnd: null,
				houseType: null,
				page: null,
				rows: null,
				premisesIdList: null
		}
		
		var premiseAddBean = {
				premisesName: null,
				premisesPosition: null,
				developer: null,
				allArea: null,
				greenArea: null,
				parkingNum: null,
				premisesDescriptions: null,
				premisesCity: null

		}
		
		var premiseUpdateBean = {
				premisesId: null,
				premisesName: null,
				premisesPosition: null,
				developer: null,
				allArea: null,
				greenArea: null,
				parkingNum: null,
				premisesDescriptions: null,
				premisesCity: null,
				paramOld: null
		}
		
		var premiseDeleteBean = {
				premisesId: null,
				paramOld: null
		}
		
		var buildAddBean = {
				buildList: null

		}
		
		var buildUpdateBean = {
				buildId: null,
				buildName: null,
				buildNum: null,
				premisesId: null,
				paramOld: null

		}
		
		var buildDeleteBean = {
				buildName: null,
				buildNum: null,
				buildId: null,
				premisesId: null,
				paramOld: null

		}
		
		var unitAddBean = {
				unitList: null
		}
		
		var unitUpdateBean = {
				unitId: null,
				unitName: null,
				buildId: null,
				premisesId: null,
				paramOld: null

		}
		
		var unitDeleteBean = {
				unitId: null,
				paramOld: null
		}
		
		var housefloorAddBean = {
				houseList: null
		}
		
		var houseAddBean = {
				houseList: null
		}
		
		var houseUpdateBean = {
				premisesId: null,
				buildId: null,
				unitId: null,
				houseFloor: null,
				houseNum: null,
				houseName: null,
				houseType: null,
				houseId: null,
				houseArea: null,
				comprisingArea: null,
				billingArea: null,
				paramOld: null
		}
		
		var houseDeleteBean = {
				houseId: null,
				paramOld: null
		}
		
		var addBean = {
				premisesId: null,
				buildId: null,
				unitId: null,
				houseFloor: null,
				houseId: null,
				ownerList: null,
				houseArea: null,
				comprisingArea: null,
				houseType: null,
				billingArea: null

		}
		
		var ownerListBean = {
				houseId: null
		}
		
		var ownerAddBean = {
				premisesId: null,
				buildId: null,
				unitId: null,
				houseFloor: null,
				houseId: null,
				ownerName: null,
				ownerTel: null

		}
		
		var ownerDeleteBean = {
				ownerId: null,
				paramOld: null
		}
		
		var ownerUpdateBean = {
				premisesId: null,
				buildId: null,
				unitId: null,
				houseFloor: null,
				houseId: null,
				ownerName: null,
				ownerId: null,
				ownerTel: null,
				paramOld: null
		}
		return {
			
			houseinfoListBean: houseinfoListBean,
			premiseAddBean: premiseAddBean,
			buildAddBean: buildAddBean,
			unitAddBean: unitAddBean,
			housefloorAddBean: housefloorAddBean,
			houseAddBean: houseAddBean,
			premiseUpdateBean: premiseUpdateBean,
			premiseDeleteBean: premiseDeleteBean,
			buildUpdateBean: buildUpdateBean,
			buildDeleteBean: buildDeleteBean,
			unitUpdateBean: unitUpdateBean,
			unitDeleteBean: unitDeleteBean,
			houseUpdateBean: houseUpdateBean,
			houseDeleteBean: houseDeleteBean,
			addBean: addBean,
			ownerListBean: ownerListBean,
			ownerAddBean: ownerAddBean,
			ownerDeleteBean: ownerDeleteBean,
			ownerUpdateBean: ownerUpdateBean,
			ownerUpdate: function() {
				var promise = $http(getReqConfig(getFormDateToLong(ownerUpdateBean), contextPath + "/owner/update"));
				return promise;
			},
			ownerDelete: function() {
				var promise = $http(getReqConfig(getFormDateToLong(ownerDeleteBean), contextPath + "/owner/delete"));
				return promise;
			},
			ownerAdd: function() {
				var promise = $http(getReqConfig(getFormDateToLong(ownerAddBean), contextPath + "/owner/add"));
				return promise;
			},
			ownerList: function() {
				var promise = $http(getReqConfig(getFormDateToLong(ownerListBean), contextPath + "/owner/list"));
				return promise;
			},
			houseinfoList: function() {
				var promise = $http(getReqConfig(getFormDateToLong(houseinfoListBean), contextPath + "/house/houseinfolist"));
				return promise;
			},
		
			add: function() {
				var promise = $http(getReqConfig(getFormDateToLong(addBean), contextPath + "/house/update"));
				return promise;
			},
		
			premiseAdd: function() {
				var promise = $http(getReqConfig(getFormDateToLong(premiseAddBean), contextPath + "/premises/add"));
				return promise;
			},
		
			premiseUpdate: function() {
				var promise = $http(getReqConfig(getFormDateToLong(premiseUpdateBean), contextPath + "/premises/update"));
				return promise;
			},
		
			premiseDelete: function() {
				var promise = $http(getReqConfig(getFormDateToLong(premiseDeleteBean), contextPath + "/premises/delete"));
				return promise;
			},
		
			buildAdd: function() {
				var promise = $http(getReqConfig(getFormDateToLong(buildAddBean), contextPath + "/build/addlist"));
				return promise;
			},
		
			buildUpdate: function() {
				var promise = $http(getReqConfig(getFormDateToLong(buildUpdateBean), contextPath + "/build/update"));
				return promise;
			},
		
			buildDelete: function() {
				var promise = $http(getReqConfig(getFormDateToLong(buildDeleteBean), contextPath + "/build/delete"));
				return promise;
			},
		
			unitAdd: function() {
				var promise = $http(getReqConfig(getFormDateToLong(unitAddBean), contextPath + "/unit/addlist"));
				return promise;
			},
		
			unitUpdate: function() {
				var promise = $http(getReqConfig(getFormDateToLong(unitUpdateBean), contextPath + "/unit/update"));
				return promise;
			},
		
			unitDelete: function() {
				var promise = $http(getReqConfig(getFormDateToLong(unitDeleteBean), contextPath + "/unit/delete"));
				return promise;
			},
			housefloorAdd: function() {
				var promise = $http(getReqConfig(getFormDateToLong(housefloorAddBean), contextPath + "/house/addlist"));
				return promise;
			},
		
			houseAdd: function() {
				var promise = $http(getReqConfig(getFormDateToLong(houseAddBean), contextPath + "/house/addlist"));
				return promise;
			},
		
			houseUpdate: function() {
				var promise = $http(getReqConfig(getFormDateToLong(houseUpdateBean), contextPath + "/house/update"));
				return promise;
			},
		
			houseDelete: function() {
				var promise = $http(getReqConfig(getFormDateToLong(houseDeleteBean), contextPath + "/house/delete"));
				return promise;
			}
			
		}
	})