/**
 * 统计分析接口
 */

angular.module('service.stat',[])
	.factory('statSV',function($http){
		var quotalistBean = {
				quotaId:null,
				quotaType:null,
				quotaName:null,
				secondQuotaName:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		var quotaaddBean = {
				createUser:null,
				quotaType:null,
				quotaName:null,
				secondQuotaName:null
		}
		var quotaupdateBean = {
				quotaId:null,
				quotaType:null,
				quotaName:null,
				secondQuotaName:null,
				updateUser:null
		}
		var quotadeleteBean = {
				quotaId:null,
				updateUser:null
		}
		var recordlistBean = {
				quotaRecordId:null,
				userLoginName:null,
				gender:null,
				userName:null,
				userTel:null,
				nationality:null,
				village:null,
				nation:null,
				bloodType:null,
				education:null,
				province:null,
				city:null,
				district:null,
				quotaName:null,
				secondQuotaName:null,
				value:null,
				deviceName:null,
				organizationName:null,
				type:null,
				createTime:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null

		}
		var recordaddBean = {
				userId:null,
				createUser:null,
				gender:null,
				userAge:null,
				situation:null,
				recordList:null

		}
		var recordupdate = {
				quotaRecordId:null,
				userId:null,
				quotaId:null,
				quotaName:null,
				value:null,
				unit:null,
				result:null,
				deviceId:null,
				device:null,
				createUser:null

		}
		var recorddeleteBean = {
				quotaRecordId: null
		}
		
		var getUserListBean = {
				userLoginName: null
		}
		
		var getUserInfoBean = {
				userName:null,
				gender:null,
				userAge:null,
				userIdCard:null,
				userTel:null,
				userEmail:null,
				addressList:null,
				name:null,
				userTel:null,
				province:null,
				city:null,
				district:null,
				detailAddress:null,
				zipCode:null,
				userId:null

		}
		
		var getStatListBean = {
				quotaType:null,
				quotaName:null,
				secondQuotaName:null,
				StatisticType:null,
				gender:null,
				ageStart:null,
				ageEnd:null,
				nation:null,
				city:null,
				standardValue:null

		}
	
		return{
			
			quotalist:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quota/list"));
				return promise;
			},
			quotaadd:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quota/add"));
				return promise;
			},
			quotaupdate:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quota/update"));
				return promise;
			},
			quotadelete:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quota/delete"));
				return promise;
			},
			recordlist:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quotarecord/list2"));
				return promise;
			},
			recordadd:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quotarecord/add"));
				return promise;
			},
			recordupdate:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quotarecord/update"));
				return promise;
			},
			recorddelete:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quotarecord/delete"));
				return promise;
			},
			getUserList:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/user/getUserList"));
				return promise;
			},
			getUserInfo:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/user/getUserInfo"));
				return promise;
			},
			getStatList:function(bean){
				var promise = $http(getReqConfig(getFormDateToLong(bean),contextPath + "/quotastatistical/list"));
				return promise;
			}
		
	}
})