angular.module('service.staff', [])
	.factory('staffSV', function($http) {
		var listBean = {       
				adminName: null,
				realName: null,
				roleIdList: null,
				premisesIdList: null,
				adminTel: null,
				position: null,
				/*sort: 'roleId',      
				order: 'asc',*/
				page: null,
				rows: null
		}
		
		var addBean = {
				userName: null,
				userLoginName: null,
				userTel: null,
				userIdCard: null,
				gender: null,
				// adminRolePremisesList: null,
                adminRoleOrganizationList: null,
				userPassword: "123456"
		}
		
		var viewBean = {
				adminName: null,
				adminId: null
		}
		
		var delBean = {
				adminIdList: null
		}
		
		var updateBean = {
				userId: null,
				userName: null,
				userLoginName: null,
				userTel: null,
				userIdCard: null,
				gender: null,
				adminRoleOrganizationList: null
		}
		var positionBean = {
				
		}
		
		
		return {
			listBean: listBean,
			addBean: addBean,
			viewBean: viewBean,
			delBean: delBean,
			updateBean: updateBean,
			positionBean: positionBean,
			
			list: function() {
				var promise = $http(getReqConfig(getFormDateToLong(listBean), contextPath + "/admin/list"));
				return promise;
			},
			add: function() {
				var promise = $http(getReqConfig(getFormDateToLong(addBean), contextPath + "/admin/add"));
				return promise;
			},
			view: function() {
				var promise = $http(getReqConfig(getFormDateToLong(viewBean), contextPath + "/admin/view"));
				return promise;
			},
			del: function() {
				var promise = $http(getReqConfig(getFormDateToLong(delBean), contextPath + "/admin/delete"));
				return promise;
			},
			update: function() {
				var promise = $http(getReqConfig(getFormDateToLong(updateBean), contextPath + "/admin/update"));
				return promise;
			},
			position: function() {
				var promise = $http(getReqConfig(getFormDateToLong(positionBean), contextPath + "/admin/position"));
				return promise;
			}
			
		}
	})