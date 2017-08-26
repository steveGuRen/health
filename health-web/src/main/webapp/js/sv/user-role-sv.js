angular.module('service.userRole', [])
	.factory('userRoleSV', function($http) {
		var listBean = {       
				roleName: null,     
				sort: null,      
				order: null,
				page: null,
				rows: null
		}
		
		var addBean = {
				roleName: null,
				roleDescribe: null,
				roleMenuList: null
				/*roleMenuList: {
					typeId: null,
					menuId: null,
					permission: null
				}*/
		}
		
		var viewBean = {
				roleId: null
		}
		
		var delBean = {
				roleIdList: null
		}
		
		var updateBean = {
				roleId: null,
				roleName: null,
				roleMenuList: null,
				roleDescribe: null
		}
		
		var menulistBean = {
				
		}
		
		return {
			listBean: listBean,
			addBean: addBean,
			viewBean: viewBean,
			delBean: delBean,
			updateBean: updateBean,
			menulistBean: menulistBean,
			list: function() {
				var promise = $http(getReqConfig(getFormDateToLong(listBean), contextPath + "/role/list"));
				return promise;
			},
			add: function() {
				var promise = $http(getReqConfig(getFormDateToLong(addBean), contextPath + "/role/add"));
				return promise;
			},
			view: function() {
				var promise = $http(getReqConfig(getFormDateToLong(viewBean), contextPath + "/role/view"));
				return promise;
			},
			del: function() {
				var promise = $http(getReqConfig(getFormDateToLong(delBean), contextPath + "/role/delete"));
				return promise;
			},
			update: function() {
				var promise = $http(getReqConfig(getFormDateToLong(updateBean), contextPath + "/role/update"));
				return promise;
			},
			menulist: function() {
				var promise = $http(getReqConfig(getFormDateToLong(menulistBean), contextPath + "/menu/list"));
				return promise;
			}
			
		}
	})