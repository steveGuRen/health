angular.module('service.organization', [])
	.factory('organizationSV', function($http) {
		var listBean = {       
                organizationId: null,
				organizationName: null,
				organizationPosition: null,
				type: null,
				tel: null,
				fax: null,
				email: null,
                weChat: null,
                qqNum: null,
                organizationLogo: null,
				/*sort: 'roleId',      
				order: 'asc',*/
				page: null,
				rows: null
		}
		var addBean = {
                organizationName: null,
				organizationPosition: null,
				type: null,
				tel: null,
				fax: null,
				email: null,
                weChat: null,
                qqNum: null,
                organizationLogo: null,
        }
		var delBean = {
            organizationId: null
        }
		
		
		return {
			listBean: listBean,
			addBean: addBean,
            delBean: delBean,
			list: function() {
				var promise = $http(getReqConfig(getFormDateToLong(listBean), contextPath + "/organization/getOrganizationList"));
				return promise;
			},
			add: function() {
				var promise = $http(getReqConfig(getFormDateToLong(addBean), contextPath + "/organization/add"));
				return promise;
			},
			del: function() {
				var promise = $http(getReqConfig(getFormDateToLong(delBean), contextPath + "/organization/delete"));
				return promise;
			}
		}
	})