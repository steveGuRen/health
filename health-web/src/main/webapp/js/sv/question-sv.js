/**
 * 手机端问卷调查接口
 */

angular.module('service.question',[])
	.factory('questionSV',function($http){
		var getUserListBean = {
				page:null,
				rows:null
		}
		
		var addOrUpdateUserInfoBean = {
				userId:null,
				ImgUrl:null,
				nickname:null,
				userName:null,
				gender:null,
				userAge:null,
				userIdCard:null,
				userTel:null,
				userEmail:null
		}
		
		var getUserInfoBean = {
				userId:null,
				ImgUrl:null,
				nickName:null,
				userLoginName:null,
				userName:null
		}
		
		var addBasicInfoBean = {
				userId:null,
				headPortrait:null,
				nationality:null,
				village:null,
				nation:null,
				weight:null,
				bloodType:null,
				education:null,
				residentType:null,
				emergencyContact:null,
				emergencyPerson:null,
				workUnit:null,
				gender:null,
				birthday:null,
				nativePlace:null,
				neightborhoodCommittee:null,
				height:null,
				step:null,
				RH:null,
				maritalStatus:null,
				address:null,
				occupation:null
		}
		
		var updateBasicInfoBean = {
				id:null,
				userId:null,
				headPortrait:null,
				nationality:null,
				village:null,
				nation:null,
				weight:null,
				bloodType:null,
				education:null,
				residentType:null,
				emergencyContact:null,
				emergencyPerson:null,
				workUnit:null,
				gender:null,
				birthday:null,
				nativePlace:null,
				neightborhoodCommittee:null,
				height:null,
				step:null,
				RH:null,
				maritalStatus:null,
				address:null,
				occupation:null
		}
		
		var getBasicInfoBean = {
				id:null,
				userId:null,
				headPortrait:null,
				nationality:null,
				village:null,
				nation:null,
				weight:null,
				bloodType:null,
				education:null,
				residentType:null,
				emergencyContact:null,
				emergencyPerson:null,
				workUnit:null,
				gender:null,
				birthday:null,
				nativePlace:null,
				neightborhoodCommittee:null,
				height:null,
				step:null,
				RH:null,
				maritalStatus:null,
				address:null,
				occupation:null,
				page:null,
				rows:null,
				sort:null,
				order:null
		}
		var getMedicalHistoryBean = {
				userId:null,
				historyType:null,
				title:null,
				item:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		
		var addMedicalHistoryBean = {
				userId:null,
				historyType:null,
				title:null,
				item:null,
				page:null,
				rows:null
		}
		
		var updateMedicalHistoryBean = {
				userId:null,
				id:null,
				historyType:null,
				title:null,
				item:null,
				sort:"updateTime",
				order:"desc"
		}
		
		var getDiseaseHistoryBean = {
				userId:null,
				id:null,
				disease:null,
				diagnosisTime:null,
				iscured:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		
		var addDiseaseHistoryBean = {
				userId:null,
				disease:null,
				diagnosisTime:null,
				iscured:null
		}
		
		var updateDiseaseHistoryBean = {
				id:null,
				userId:null,
				disease:null,
				diagnosisTime:null,
				iscured:null
		}
		
		var getSurgeryBean = {
				userId:null,
				operationTime:null,
				operationName:null,
				operationResult:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		
		var addSurgeryBean = {
				id:null,
				userId:null,
				operationTime:null,
				operationName:null,
				operationResult:null
		}
		
		var updateSurgeryBean = {
				id:null,
				userId:null,
				operationTime:null,
				operationName:null,
				operationResult:null
		}
		
		var addInjuryBean = {
				userId:null,
				injuryName:null,
				injuryTime:null,
				injuryDescription:null
		}
		
		var updateInjuryBean = {
				id:null,
				userId:null,
				injuryName:null,
				injuryTime:null,
				injuryDescription:null
		}
		
		var getInjuryBean = {
				userId:null,
				id:null,
				injuryTime:null,
				injuryName:null,
				injuryDescription:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		
		var addTransfusionBean = {
				userId:null,
				transfusionTime:null,
				bloodTransfusion:null,
				cause:null
		}
		
		var updateTransfusionBean = {
				id:null,
				userId:null,
				transfusionTime:null,
				bloodTransfusion:null,
				cause:null
		}
		
		var getTransfusionBean = {
				id:null,
				userId:null,
				transfusionTime:null,
				bloodTransfusion:null,
				cause:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		
		var addHospitalizedBean = {
				userId:null,
				patientId:null,
				institution:null,
				cause:null,
				hospitalInTime:null,
				hospitalOutTime:null,
				bedId:null,
				bedInstitution:null,
				bedCreateTime:null,
				bedDelTime:null
		}
		
		var updateHospitalizedBean = {
				userId:null,
				id:null,
				patientId:null,
				institution:null,
				cause:null,
				hospitalInTime:null,
				hospitalOutTime:null,
				bedId:null,
				bedInstitution:null,
				bedCreateTime:null,
				bedDelTime:null
		}
		
		var getHospitalizedBean = {
				userId:null,
				patientId:null,
				institution:null,
				cause:null,
				hospitalInTime:null,
				hospitalOutTime:null,
				bedId:null,
				bedInstitution:null,
				bedCreateTime:null,
				bedDelTime:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		
		var addImmunizationBean = {
				userId:null,
				immunizationName:null,
				immunizationDate:null,
				immunizationInstitution:null
		}
		
		var updateImmunizationBean = {
				userId:null,
				id:null,
				immunizationName:null,
				immunizationDate:null,
				immunizationInstitution:null
		}
		
		var getImmunizationBean = {
				userId:null,
				id:null,
				immunizationName:null,
				immunizationDate:null,
				immunizationInstitution:null,
				sort:"createTime",
				order:"desc",
				page:null,
				rows:null
		}
		return{
			getUserListBean:getUserListBean,
			getUserInfoBean:getUserInfoBean,
			addOrUpdateUserInfoBean:addOrUpdateUserInfoBean,
			getBasicInfoBean:getBasicInfoBean,
			addBasicInfoBean:addBasicInfoBean,
			updateBasicInfoBean:updateBasicInfoBean,
			addMedicalHistoryBean:addMedicalHistoryBean,
			getMedicalHistoryBean:getMedicalHistoryBean,
			updateMedicalHistoryBean:updateMedicalHistoryBean,
			addDiseaseHistoryBean:addDiseaseHistoryBean,
			updateDiseaseHistoryBean:updateDiseaseHistoryBean,
			getDiseaseHistoryBean:getDiseaseHistoryBean,
			addSurgeryBean:addSurgeryBean,
			updateSurgeryBean:updateSurgeryBean,
			getSurgeryBean:getSurgeryBean,
			addInjuryBean:addInjuryBean,
			updateInjuryBean:updateInjuryBean,
			getInjuryBean:getInjuryBean,
			addTransfusionBean:addTransfusionBean,
			updateTransfusionBean:updateTransfusionBean,
			getTransfusionBean:getTransfusionBean,
			addHospitalizedBean:addHospitalizedBean,
			updateHospitalizedBean:updateHospitalizedBean,
			getHospitalizedBean:getHospitalizedBean,
			addImmunizationBean:addImmunizationBean,
			updateImmunizationBean:updateImmunizationBean,
			getImmunizationBean:getImmunizationBean,
			getUserList:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getUserListBean),contextPath + "/user/getUserList"));
				return promise;
			},
			getUserInfo:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getUserInfoBean),contextPath + "/user/getUserInfo"));
				return promise;
			},
			addOrUpdateUserInfo:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addOrUpdateUserInfoBean),contextPath + "/user/updateUserInfo"));
				return promise;
			},
			getBasicInfo:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getBasicInfoBean),contextPath + "/userInfo/query"));
				return promise;
			},
			addBasicInfo:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addBasicInfoBean),contextPath + "/userInfo/add"));
				return promise;
			},
			updateBasicInfo:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateBasicInfoBean),contextPath + "/userInfo/update"));
				return promise;
			},
			getMedicalHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getMedicalHistoryBean),contextPath + "/historymedical/query"));
				return promise;
			},
			addMedicalHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addMedicalHistoryBean),contextPath + "/historymedical/add"));
				return promise;
			},
			updateMedicalHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateMedicalHistoryBean),contextPath + "/historymedical/update"));
				return promise;
			},
			addDiseaseHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addDiseaseHistoryBean),contextPath + "/historyDisease/add"));
				return promise;
			},
			updateDiseaseHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateDiseaseHistoryBean),contextPath + "/historyDisease/update"));
				return promise;
			},
			getDiseaseHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getDiseaseHistoryBean),contextPath + "/historyDisease/query"));
				return promise;
			},
			addSurgeryHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addSurgeryBean),contextPath + "/historyOperation/add"));
				return promise;
			},
			updateSurgeryHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateSurgeryBean),contextPath + "/historyOperation/update"));
				return promise;
			},
			getSurgeryHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getSurgeryBean),contextPath + "/historyOperation/query"));
				return promise;
			},
			addInjuryHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addInjuryBean),contextPath + "/historyInjury/add"));
				return promise;
			},
			updateInjuryHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateInjuryBean),contextPath + "/historyInjury/update"));
				return promise;
			},
			getInjuryHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getInjuryBean),contextPath + "/historyInjury/query"));
				return promise;
			},
			addTransfusionHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addTransfusionBean),contextPath + "/historyTransfusion/add"));
				return promise;
			},
			updateTransfusionHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateTransfusionBean),contextPath + "/historyTransfusion/update"));
				return promise;
			},
			getTransfusionHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getTransfusionBean),contextPath + "/historyTransfusion/query"));
				return promise;
			},
			addHospitalizedHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addHospitalizedBean),contextPath + "/historyHospitalized/add"));
				return promise;
			},
			updateHospitalizedHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateHospitalizedBean),contextPath + "/historyHospitalized/update"));
				return promise;
			},
			getHospitalizedHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getHospitalizedBean),contextPath + "/historyHospitalized/query"));
				return promise;
			},
			addImmunizationHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(addImmunizationBean),contextPath + "/historyImmunization/add"));
				return promise;
			},
			updateImmunizationHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(updateImmunizationBean),contextPath + "/historyImmunization/update"));
				return promise;
			},
			getImmunizationHistory:function(){
				var promise = $http(getReqConfig(getFormDateToLong(getImmunizationBean),contextPath + "/historyImmunization/query"));
				return promise;
			},
		}
  })