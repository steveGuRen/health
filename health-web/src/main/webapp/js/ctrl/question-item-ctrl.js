'use strict';
/**
 * 手机问卷调查controller
 */
angular.module('question', ['ui.bootstrap','service.question'])
	.controller('questionItemCtrl', function($log, $scope, $location, $timeout,questionSV) {
		
		$scope.queryParam = {};
		$scope.queryParam.currentPage = 1;
		$scope.basicInfoUpdate = false;
		//列表页显示控制
	    $scope.listPage = false;
	    //问卷详情显示控制
		$scope.userIdDetail = false;
		$scope.userId = userId;
		$scope.success = false;
		$scope.successCount = 0;
		$scope.fail = false;
	
		//返回列表页
		$scope.skipToAdd = function(title){
			if (title == '父亲患病情况'){
				$scope.father = {};
			} else if (title == '母亲患病情况'){
				$scope.mother = {};
			} else if (title == '兄弟姐妹患病情况'){
				$scope.brother = {};
			} else if (title == '疾病史'){
				$scope.disease = {};
			} else if (title == '手术史'){
				$scope.surgery = {};
			} else if (title == '外伤史'){
				$scope.injury = {};
			} else if (title == '药物过敏史'){
				$scope.allergy = {};
			} else {
				$scope.recordDetail = !$scope.recordDetail;
				$scope.listPage = !$scope.listPage;
				$scope.queryParam.currentPage = 1;
			}
		};
		
		//手机问卷list列表点击事件
		$scope.clickList = function(itemName){
			if (itemName == '家族史'){
				$scope.father = {};
				$scope.mother = {};
				$scope.brother = {};
				$scope.children = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 3;
//				$scope.queryMedicalHistory("家族史","父亲患病情况","1");
//				$scope.queryMedicalHistory("家族史","母亲患病情况","1");
//				$scope.queryMedicalHistory("家族史","兄弟姐妹患病情况","1");
//				$scope.queryMedicalHistory("家族史","子女患病情况","1");
			} else if (itemName == '遗传病史'){
				$scope.genetic = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 4;
//				$scope.queryMedicalHistory("遗传病史",null,"1");
			} else if (itemName == '既往史'){
				$scope.disease = {};
				$scope.surgery = {};
				$scope.injury = {};
				$scope.transfusion = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 5;
//				$scope.queryDiseaseHistory("1");
//				$scope.querySurgeryHistory("1");
//				$scope.queryInjuryHistory("1");
//				$scope.queryTransfusionHistory("1");
			} else if (itemName == '残疾情况'){
				$scope.disability = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 6;
//				$scope.queryMedicalHistory("残疾情况",null,"1");
			} else if (itemName == '过敏史'){
				$scope.allergy = {};
				$scope.allergen = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 7;
//				$scope.queryMedicalHistory("过敏史","药物过敏史","1");
//				$scope.queryMedicalHistory("过敏史","其他过敏史","1");
			} else if (itemName == '住院史'){
				$scope.hospital = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 10;
//				$scope.queryHospitalizedHistory("1");
			} else if (itemName == '非免疫预防接种史'){
				$scope.immunization = {};
				$scope.listPage = !$scope.listPage;
				$scope.recordDetail = !$scope.recordDetail;
				$scope.selectedTag = 11;
//				$scope.queryImmunizationHistory("1");
			}
			
		}
		
		//保存按钮
		$scope.update = function(type,title){
			if (type == '家族史' && title == '父亲患病情况'){
				questionSV.addMedicalHistoryBean.historyType = type;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.title = title;
				if ($scope.father.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.father.otherDisease;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.father.item;
				}
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
				    if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							   $scope.success = !$scope.success;
							   $timeout(function(){
									$scope.success = !$scope.success;
								},1000);
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '家族史' && title == '母亲患病情况') {
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.historyType = type;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.title = title;
				if ($scope.mother.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.mother.otherDisease;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.mother.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
							if(response.data.status==200||response.data.status=='200'){
								 $scope.success = !$scope.success;
								 $timeout(function(){
									$scope.success = !$scope.success;
								},1000);
							}
					}else {
						$scope.fail = !$scope.fail;
						$timeout(function(){
							$scope.fail = !$scope.fail;
						},1000);
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '家族史' && title == '兄弟姐妹患病情况'){
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.historyType = type;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.title = title;
				if ($scope.brother.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.brother.otherDisease;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.brother.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;	
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
							   $scope.success = !$scope.success;
							},1000);
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
						    	$scope.fail = !$scope.fail;
							},1000);
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '家族史' && title == '子女患病情况'){
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.historyType = type;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.title = title;
				if ($scope.children.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.children.otherDisease;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.children.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
						    $scope.success = !$scope.success;
						    $timeout(function(){
							  $scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '遗传病史'){
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.historyType = "遗传病史";
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.title = "遗传病史";
				if ($scope.genetic.item == '其他'){
					$scope.genetic.otherDisease = '其他';
					questionSV.addMedicalHistoryBean.item = $scope.genetic.otherDisease;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.genetic.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '疾病史') {
				//疾病史
				$scope.loading = !$scope.loading;
				questionSV.addDiseaseHistoryBean.userId = $scope.userId;
				if ($scope.disease.item == '其他'){
					questionSV.addDiseaseHistoryBean.disease = $scope.disease.otherDisease;
				} else {
					questionSV.addDiseaseHistoryBean.disease = $scope.disease.item;
				}
				questionSV.addDiseaseHistoryBean.diagnosisTime = $("#one-datePay").val()+ " 00:00:00";
				questionSV.addDiseaseHistoryBean.iscured = $scope.disease.iscured;
				questionSV.addDiseaseHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '手术史'){
				//手术史
				$scope.loading = !$scope.loading;
				questionSV.addSurgeryBean.userId = $scope.userId;
				questionSV.addSurgeryBean.operationTime = $("#two-datePay").val() + " 00:00:00";
				questionSV.addSurgeryBean.operationName = $scope.surgery.operationName;
				questionSV.addSurgeryBean.operationResult = $scope.surgery.operationResult;
				questionSV.addSurgeryHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '外伤史'){
				//外伤史
				$scope.loading = !$scope.loading;
				questionSV.addInjuryBean.userId = $scope.userId;
				questionSV.addInjuryBean.injuryName = $scope.injury.injuryName;
				questionSV.addInjuryBean.injuryTime = $("#three-datePay").val()+ " 00:00:00";
				questionSV.addInjuryBean.injuryDescription = $scope.injury.injuryDescription;
				questionSV.addInjuryHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '输血史') {
				//输血史
				$scope.loading = !$scope.loading;
				questionSV.addTransfusionBean.userId = $scope.userId;
				questionSV.addTransfusionBean.transfusionTime = $("#four-datePay").val()+ " 00:00:00";
				questionSV.addTransfusionBean.bloodTransfusion = $scope.transfusion.bloodTransfusion;
				questionSV.addTransfusionBean.cause = $scope.transfusion.cause;
				questionSV.addTransfusionHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '残疾情况'){
				//残疾情况
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.historyType = "残疾情况";
				questionSV.addMedicalHistoryBean.title = "残疾情况";
				if ($scope.disability.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.disability.otherDisease;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.disability.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '过敏史' && title == '药物过敏史'){
				//药物过敏史
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.historyType = "过敏史";
				questionSV.addMedicalHistoryBean.title = "药物过敏史";
				if ($scope.allergy.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.allergy.otherItem;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.allergy.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '过敏史' && title == '其他过敏史') {
				//其他过敏史
				$scope.loading = !$scope.loading;
				questionSV.addMedicalHistoryBean.userId = $scope.userId;
				questionSV.addMedicalHistoryBean.historyType = "过敏史";
				questionSV.addMedicalHistoryBean.title = "其他过敏史";
				if ($scope.allergen.item == '其他'){
					questionSV.addMedicalHistoryBean.item = $scope.allergen.otherItem;
				} else {
					questionSV.addMedicalHistoryBean.item = $scope.allergen.item;
				}
				questionSV.addMedicalHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '住院史'){
				$scope.loading = !$scope.loading;
				questionSV.addHospitalizedBean.userId = $scope.userId;
				questionSV.addHospitalizedBean.patientId = $scope.hospital.patientId;
				questionSV.addHospitalizedBean.institution = $scope.hospital.institution;
				questionSV.addHospitalizedBean.cause = $scope.hospital.cause;
				questionSV.addHospitalizedBean.hospitalInTime = $("#hospital-in-date").val()+ " 00:00:00";
				questionSV.addHospitalizedBean.hospitalOutTime = $("#hospital-out-date").val()+ " 00:00:00";
				questionSV.addHospitalizedBean.bedId = $scope.hospital.bedId;
				questionSV.addHospitalizedBean.bedInstitution = $scope.hospital.bedInstitution;
				questionSV.addHospitalizedBean.bedCreateTime = $("#bed-create-date").val()+ " 00:00:00";
				questionSV.addHospitalizedBean.bedDelTime = $("#bed-del-date").val()+ " 00:00:00";
				questionSV.addHospitalizedHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			} else if (type == '非免疫预防接种史'){
				$scope.loading = !$scope.loading;
				questionSV.addImmunizationBean.userId = $scope.userId;
				questionSV.addImmunizationBean.immunizationName = $scope.immunization.immunizationName;
				questionSV.addImmunizationBean.immunizationDate = $("#immunization").val() + " 00:00:00";
				questionSV.addImmunizationBean.immunizationInstitution = $scope.immunization.immunizationInstitution;
				questionSV.addImmunizationHistory().then(function(response){
					$scope.loading = !$scope.loading;
					if (response.data && response.data.data){
						if(response.data.status==200||response.data.status=='200'){
							$scope.success = !$scope.success;
							$timeout(function(){
								$scope.success = !$scope.success;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						} else {
							$scope.fail = !$scope.fail;
							$timeout(function(){
								$scope.fail = !$scope.fail;
							},1000);
							$scope.recordDetail = !$scope.recordDetail;
							$scope.listPage = !$scope.listPage;
						}
					}
				},function(reason){
					$scope.loading = !$scope.loading;
					alert(reason);
				},function(value){
					$scope.loading = !$scope.loading;
					alert(value);
				});
			}
			
			
		}
		
		
		$scope.queryMedicalHistory = function(type,title,page){
			if ($scope.userId != null){
				questionSV.getMedicalHistoryBean.userId = $scope.userId;
				questionSV.getMedicalHistoryBean.historyType = type;
				questionSV.getMedicalHistoryBean.page = page;
				questionSV.getMedicalHistoryBean.rows = 10;
				questionSV.getMedicalHistoryBean.title = title;
				var ii = layer.load('loading...');
				if (type == "家族史"){
					if (title == "父亲患病情况"){
						questionSV.getMedicalHistory().then(function(response){
							layer.close(ii);
							if (response.data.data && response.data.status == 200){
								$scope.father = response.data.data.list[0];
							}
						},function(reason){
							layer.close(ii);
						},function(value){
							layer.close(ii);
						});
						
					} else if (title == "母亲患病情况"){
						questionSV.getMedicalHistory().then(function(response){
							layer.close(ii);
							if (response.data && response.data.status == 200){
								$scope.mother = response.data.data.list[0];
							}
						},function(reason){
							layer.close(ii);
						},function(value){
							layer.close(ii);
						});
					} else if (title == "兄弟姐妹患病情况"){
						questionSV.getMedicalHistory().then(function(response){
							layer.close(ii);
							if (response.data && response.data.status == 200){
								$scope.brother = response.data.data.list[0];
							}
						},function(reason){
							layer.close(ii);
						},function(value){
							layer.close(ii);
						});
					} else if (title == "子女患病情况"){
						questionSV.getMedicalHistory().then(function(response){
							layer.close(ii);
							if (response.data && response.data.status == 200){
								$scope.children = response.data.data.list[0];
							}
						},function(reason){
							layer.close(ii);
						},function(value){
							layer.close(ii);
						});
					}
				} else if (type == "遗传病史"){
					questionSV.getMedicalHistory().then(function(response){
						layer.close(ii);
						if (response.data && response.data.status == 200){
							$scope.genetic = response.data.data.list[0];
						}
					},function(reason){
						layer.close(ii);
					},function(value){
						layer.close(ii);
					});
				} else if (type == "过敏史"){
					if (title == "药物过敏史"){
						questionSV.getMedicalHistory().then(function(response){
							layer.close(ii);
							if (response.data && response.data.status == 200){
								$scope.allergy = response.data.data.list[0];
							}
						},function(reason){
							layer.close(ii);
						},function(value){
							layer.close(ii);
						});
					} else if (title == "其他过敏史"){
						questionSV.getMedicalHistory().then(function(response){
							layer.close(ii);
							if (response.data && response.data.status == 200){
								$scope.allergen = response.data.data.list[0];
							}
						},function(reason){
							layer.close(ii);
						},function(value){
							layer.close(ii);
						});
					}
				} else if (type == "残疾情况"){
					questionSV.getMedicalHistory().then(function(response){
						layer.close(ii);
						if (response.data && response.data.status == 200){
							$scope.disability = response.data.data.list[0];
						}
					},function(reason){
						layer.close(ii);
					},function(value){
						layer.close(ii);
					});
				}
					
				
			}
			
		}
		
		$scope.queryDiseaseHistory = function(page){
			questionSV.getDiseaseHistoryBean.userId = $scope.userId;
			questionSV.getDiseaseHistoryBean.page = page;
			questionSV.getDiseaseHistoryBean.rows = 10;
			var ii = layer.load('loading...');
			questionSV.getDiseaseHistory().then(function(response){
				layer.close(ii);
				if (response.data && response.data.status == 200){
					$scope.disease = response.data.data.list[0];
				}
			},function(reason){
				layer.close(ii);
			},function(value){
				layer.close(ii);
			});
		}
		
		$scope.querySurgeryHistory = function(page){
			questionSV.getSurgeryBean.page = page;
			questionSV.getSurgeryBean.userId = $scope.userId;
			questionSV.getSurgeryBean.rows = 10;
			var ii = layer.load('loading...');
			questionSV.getSurgeryHistory().then(function(response){
				layer.close(ii);
				if (response.data && response.data.status == 200){
					$scope.surgery = response.data.data.list[0];
				}
			},function(reason){
				layer.close(ii);
			},function(value){
				layer.close(ii);
			});
		}
		
		$scope.queryInjuryHistory = function(page){
			questionSV.getInjuryBean.userId = $scope.userId;
			questionSV.getInjuryBean.page = page;
			questionSV.getInjuryBean.rows = 10;
			var ii = layer.load('loading...');
			questionSV.getInjuryHistory().then(function(response){
				layer.close(ii);
				if (response.data && response.data.status == 200){
					$scope.injury = response.data.data.list[0];
				}
			},function(reason){
				layer.close(ii);
			},function(value){
				layer.close(ii);
			});
		}
		
		$scope.queryTransfusionHistory = function(page){
			questionSV.getTransfusionBean.userId = $scope.userId;
			questionSV.getTransfusionBean.page = page;
			questionSV.getTransfusionBean.rows = 10;
			var ii = layer.load('loading...');
			questionSV.getTransfusionHistory().then(function(response){
				layer.close(ii);
				if (response.data && response.data.status == 200){
					$scope.transfusion = response.data.data.list[0];
				}
			},function(reason){
				layer.close(ii);
			},function(value){
				layer.close(ii);
			});
		}
		
		$scope.queryHospitalizedHistory = function(page){
			questionSV.getHospitalizedBean.userId = $scope.userId;
			questionSV.getHospitalizedBean.page = page;
			questionSV.getHospitalizedBean.rows = 10;
			var ii = layer.load('loading...');
			questionSV.getHospitalizedHistory().then(function(response){
				layer.close(ii);
				if (response.data && response.data.status == 200){
					$scope.hospital = response.data.data.list[0];
				}
			},function(reason){
				layer.close(ii);
			},function(value){
				layer.close(ii);
			});
		}
		
		$scope.queryImmunizationHistory = function(page){
			questionSV.getImmunizationBean.userId = $scope.userId;
			questionSV.getImmunizationBean.page = page;
			questionSV.getImmunizationBean.rows = 10;
			var ii = layer.load('loading...');
			questionSV.getImmunizationHistory().then(function(response){
				layer.close(ii);
				if (response.data && response.data.status == 200){
					$scope.immunization = response.data.data.list[0];
				}
			},function(reason){
				layer.close(ii);
			},function(value){
				layer.close(ii);
			});
		}
		
		$scope.getAccountNumberInfo = function(){
			$scope.selectedTag = 1;
			$scope.queryUserInfo();
		};
		
		$scope.getBasicInfo = function(){
			$scope.selectedTag = 2;
			$scope.queryBasicInfo();
		};
		
		$scope.getTabFamilyHistory = function(){
			$scope.selectedTag = 3;
			$scope.queryMedicalHistory("家族史","父亲患病情况","1");
			$scope.queryMedicalHistory("家族史","母亲患病情况","1");
			$scope.queryMedicalHistory("家族史","兄弟姐妹患病情况","1");
			$scope.queryMedicalHistory("家族史","子女患病情况","1");
		};
		
		$scope.getTabGeneticDiseaseHistory = function(){
			$scope.selectedTag = 4;
			$scope.queryMedicalHistory("遗传病史",null,"1");
		};
		
		$scope.getTabPastHistory = function(){
			$scope.selectedTag = 5;
			$scope.queryDiseaseHistory("1");
			$scope.querySurgeryHistory("1");
			$scope.queryInjuryHistory("1");
			$scope.queryTransfusionHistory("1");
		};
		
		$scope.getTabDisabilitySituation = function(){
			$scope.selectedTag = 6;
			$scope.queryMedicalHistory("残疾情况",null,"1");
		};
		
		$scope.getTabAllergyHistory = function(){
			$scope.selectedTag = 7;
			$scope.queryMedicalHistory("过敏史","药物过敏史","1");
			$scope.queryMedicalHistory("过敏史","其他过敏史","1");
		};
				
		$scope.getTabStayhospitalHistory = function(){
			$scope.selectedTag = 10;
			$scope.queryHospitalizedHistory("1");
		};
		
		$scope.getTabVaccinatesss = function(){
			$scope.selectedTag = 11;
			$scope.queryImmunizationHistory("1");
		};
		
		$scope.getTabHealthassess = function(){
			$scope.selectedTag = 12;
		};
		
		
	})
	
	