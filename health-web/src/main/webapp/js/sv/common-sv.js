/**
 * 公共接口
 */

angular.module('service.common', [])
	.factory('commonSV', function($http) {
		var premisesListBean = {       
				premisesIdList: null
		}
		
		var buildListBean = {
				premisesId: null
		}
		
		var unitListBean = {       
				premisesId: null,     
				buildId: null
		}
		
		var housefloorListBean = {       
				premisesId: null,     
				buildId: null,
				unitId: null
		}
		
		var houseListBean = {       
				premisesId: null,     
				buildId: null,
				unitId: null,
				houseFloor: null,
				houseTypeList: null
		}
		
		return {
			premisesListBean: premisesListBean,
			buildListBean: buildListBean,
			unitListBean: unitListBean,
			housefloorListBean: housefloorListBean,
			houseListBean: houseListBean,
			premiseslist: function() {
				var promise = $http(getReqConfig(getFormDateToLong(premisesListBean), contextPath + "/house/premiseslist"));
				initBean(premisesListBean);
				return promise;
			},
			buildlist: function() {
				var promise = $http(getReqConfig(getFormDateToLong(buildListBean), contextPath + "/house/buildlist"));
				initBean(buildListBean);
				return promise;
			},
			unitlist: function() {
				var promise = $http(getReqConfig(getFormDateToLong(unitListBean), contextPath + "/house/unitlist"));
				initBean(unitListBean);
				return promise;
			},
			housefloorlist: function() {
				var promise = $http(getReqConfig(getFormDateToLong(housefloorListBean), contextPath + "/house/housefloorlist"));
				initBean(housefloorListBean);
				return promise;
			},
			houselist: function() {
				var promise = $http(getReqConfig(getFormDateToLong(houseListBean), contextPath + "/house/houselist"));
				initBean(houseListBean);
				return promise;
			}
			
		}
	})