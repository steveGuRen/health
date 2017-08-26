'use strict';
/**
 * 健康档案controller
 */
angular.module('controller.recordInfo', [])
		.controller(
				'recordInfoCtrl',
				function($log, $scope, $location, $uibModal, recordSV, graphSV,
						initData) {
					$scope.title = "添加档案";
                   
					$scope.races = [ "汉族", "壮族", "回族", "满族", "维吾尔族", "苗族",
							"彝族", "土家族", "藏族", "蒙古族", "侗族", "布依族", "瑶族", "白族",
							"朝鲜族", "哈尼族", "黎族", "哈萨克族", "傣族", "畲族", "傈僳族",
							"东乡族", "仡佬族", "拉祜族", "佤族", "水族", "纳西族", "羌族", "土族",
							"仫佬族", "锡伯族", "柯尔克孜族", "景颇族", "达斡尔族", "撒拉族", "布朗族",
							"毛南族", "塔吉克族", "普米族", "阿昌族", "怒族", "鄂温克族", "京族",
							"基诺族", "德昂族", "保安族", "俄罗斯族", "裕固族", "乌孜别克族", "门巴族",
							"鄂伦春族", "独龙族", "赫哲族", "高山族", "珞巴族", "塔塔尔族" ];
                    
					$scope.queryParam = {};
					$scope.queryParam.currentPage = 1;
					$scope.queryParam.totalPage = Math
							.ceil(initData.totalCount / 10);
					$scope.queryParam.totalCount = initData.totalCount;
					if ($scope.queryParam.totalPage == 0) {
						$scope.queryParam.currentPage = 1;
					}
					pagination($scope.queryParam.totalPage,
							$scope.queryParam.currentPage, 'recordPage', $scope);
					// 档案记录
					$scope.records = initData.userList;
					$scope.record = {};
					$scope.basicInfoUpdate = false;

					$scope.recordDetail = false;

					$scope.pageadd = function() {

					}
                    //查看详情
					$scope.skipToAdd = function() {
						$scope.recordDetail = !$scope.recordDetail;
						$scope.pageContent = !$scope.pageContent;
						$scope.queryParam.currentPage = 1;
						$scope.getUserList(1);
					}
                    //选择民族
					$scope.selectNation = function(nation) {
						$scope.basic.nation = nation;
					}

					// 保存按钮
					$scope.update = function() {
						switch ($scope.selectedTag) {
						case 1:
							recordSV.addOrUpdateUserInfoBean.userId = $scope.record.userId;
							recordSV.addOrUpdateUserInfoBean.userName = $scope.account.userName;
							recordSV.addOrUpdateUserInfoBean.userEmail = $scope.account.userEmail;
							recordSV.addOrUpdateUserInfoBean.userTel = $scope.account.userTel;
							recordSV.addOrUpdateUserInfoBean.userIdCard = $scope.account.userIdCard;
							var ii = layer.load('loading...');
							recordSV.addOrUpdateUserInfo()
									.then(
											function(response) {
												layer.close(ii);
												if (response.data
														&& response.data.data) {
													$(showStackBottomRight(
															"info", "亲",
															response.data.msg));
												}
											}, function(reason) {
												layer.close(ii);
											}, function(value) {
												layer.close(ii);
											});
							break;
						case 2:
							if ($scope.basicInfoUpdate) {
								recordSV.updateBasicInfoBean.userId = $scope.record.userId;
								recordSV.updateBasicInfoBean.id = $scope.basic.id;
								recordSV.updateBasicInfoBean.gender = $scope.basic.gender;
								recordSV.updateBasicInfoBean.birthday = $(
										"#birthday").val()
										+ " 00:00:00";
								recordSV.updateBasicInfoBean.nationality = $scope.basic.nationality;
								recordSV.updateBasicInfoBean.nativePlace = $scope.basic.nativePlace;
								recordSV.updateBasicInfoBean.village = $scope.basic.village;
								recordSV.updateBasicInfoBean.neighborhoodCommittee = $scope.basic.neighborhoodCommittee;
								recordSV.updateBasicInfoBean.nation = $scope.basic.nation;
								recordSV.updateBasicInfoBean.weight = $scope.basic.weight;
								recordSV.updateBasicInfoBean.bloodType = $scope.basic.bloodType;
								recordSV.updateBasicInfoBean.education = $scope.basic.education;
								recordSV.updateBasicInfoBean.residentType = $scope.basic.residentType;
								recordSV.updateBasicInfoBean.emergencyContact = $scope.basic.emergencyContact;
								recordSV.updateBasicInfoBean.emergencyPerson = $scope.basic.emergencyPerson;
								recordSV.updateBasicInfoBean.workUnit = $scope.basic.workUnit;
								recordSV.updateBasicInfoBean.height = $scope.basic.height;
								recordSV.updateBasicInfoBean.step = $scope.basic.step;
								recordSV.updateBasicInfoBean.rh = $scope.basic.rh;
								recordSV.updateBasicInfoBean.maritalStatus = $scope.basic.maritalStatus;
								recordSV.updateBasicInfoBean.address = $scope.basic.address;
								recordSV.updateBasicInfoBean.occupation = $scope.basic.occupation;
								var ii = layer.load('loading...');
								recordSV
										.updateBasicInfo()
										.then(
												function(response) {
													layer.close(ii);
													if (response.data
															&& response.data.data) {
														$(showStackBottomRight(
																"info",
																"亲",
																response.data.msg));
													}
												}, function(reason) {
													layer.close(ii);
												}, function(value) {
													layer.close(ii);
												});
								break;
							} else {
								recordSV.addBasicInfoBean.userId = $scope.record.userId;
								recordSV.addBasicInfoBean.gender = $scope.basic.gender;
								recordSV.addBasicInfoBean.birthday = $(
										"#birthday").val()
										+ " 00:00:00";
								recordSV.addBasicInfoBean.nationality = $scope.basic.nationality;
								recordSV.addBasicInfoBean.nativePlace = $scope.basic.nativePlace;
								recordSV.addBasicInfoBean.village = $scope.basic.village;
								recordSV.addBasicInfoBean.neightborhoodCommittee = $scope.basic.neightborhoodCommittee
								recordSV.addBasicInfoBean.nation = $scope.basic.nation;
								recordSV.addBasicInfoBean.weight = $scope.basic.weight;
								recordSV.addBasicInfoBean.bloodType = $scope.basic.bloodType;
								recordSV.addBasicInfoBean.education = $scope.basic.education;
								recordSV.addBasicInfoBean.residentType = $scope.basic.residentType;
								recordSV.addBasicInfoBean.emergencyContact = $scope.basic.emergencyContact;
								recordSV.addBasicInfoBean.emergencyPerson = $scope.basic.emergencyPerson;
								recordSV.addBasicInfoBean.workUnit = $scope.basic.workUnit;
								recordSV.addBasicInfoBean.height = $scope.basic.height;
								recordSV.addBasicInfoBean.step = $scope.basic.step;
								recordSV.addBasicInfoBean.RH = $scope.basic.RH;
								recordSV.addBasicInfoBean.maritalStatus = $scope.basic.maritalStatus;
								recordSV.addBasicInfoBean.address = $scope.basic.address;
								recordSV.addBasicInfoBean.occupation = $scope.basic.occupation;
								var ii = layer.load('loading...');
								recordSV
										.addBasicInfo()
										.then(
												function(response) {
													layer.close(ii);
													if (response.data
															&& response.data.data) {
														$(showStackBottomRight(
																"info",
																"亲",
																response.data.msg));
													}
												}, function(reason) {
													layer.close(ii);
												}, function(value) {
													layer.close(ii);
												});
								break;
							}

						}
						$scope.recordDetail = !$scope.recordDetail;
						$scope.pageContent = !$scope.pageContent;
						$scope.queryParam.currentPage = 1;
						$scope.getUserList(1);
					}

					$scope.getUserList = function(page) {
						recordSV.getUserListBean.page = page;
						recordSV.getUserListBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV
								.getUserList()
								.then(
										function(response) {
											layer.close(ii);
											if (response.data
													&& response.data.status == 200) {
												$scope.records = response.data.data.userList;
												$scope.queryParam.totalPage = Math
														.ceil(response.data.data.totalCount / 10);
												$scope.queryParam.totalCount = response.data.data.totalCount;
												$scope.queryParam.currentPage = page;
												if ($scope.queryParam.totalPage == 0) {
													$scope.queryParam.currentPage = 1;
												}
												pagination(
														$scope.queryParam.totalPage,
														$scope.queryParam.currentPage,
														'recordPage', $scope);
											}
										});

					}

					$scope.skipToUpdate = function(record) {
						$scope.record = record;
						$scope.recordDetail = !$scope.recordDetail;
						$scope.selectedTag = 1;
						$scope.pageContent = !$scope.pageContent;
						$scope.queryUserInfo();

						graphSV.test($scope, $scope.record.userId);
					}

					$scope.queryUserInfo = function() {
						if ($scope.record && $scope.record.userId != null) {
							recordSV.getUserInfoBean.userId = $scope.record.userId;
							var ii = layer.load('loading...');
							recordSV
									.getUserInfo()
									.then(
											function(response) {
												layer.close(ii);
												if (response.data
														&& response.data.status == 200) {
													if (response.data.data.userList.length > 0) {
														$scope.account = response.data.data.userList[0];
													} else {
														$scope.account = {};
													}

												}
											}, function(reason) {
												layer.close(ii);
											}, function(value) {
												layer.close(ii);
											});
						}
					}

					$scope.queryBasicInfo = function() {
						if ($scope.record && $scope.record.userId != null) {
							recordSV.getBasicInfoBean.userId = $scope.record.userId;
							recordSV.getBasicInfoBean.page = 1;
							recordSV.getBasicInfoBean.rows = 1;
							recordSV.getBasicInfoBean.sort = "updateTime";
							recordSV.getBasicInfoBean.order = "desc";
							var ii = layer.load('loading...');
							recordSV
									.getBasicInfo()
									.then(
											function(response) {
												layer.close(ii);
												if (response.data.data
														&& response.data.status == 200) {
													if (response.data.data.list.length > 0) {
														$scope.basicInfoUpdate = true;
														$scope.basic = response.data.data.list[0];
													} else {
														$scope.basicInfoUpdate = false;
														$scope.basic = {};
													}

												}
											}, function(reason) {
												layer.close(ii);
											}, function(value) {
												layer.close(ii);
											})
						}
					}

					$scope.queryMedicalHistory = function(type, title, page) {
						if ($scope.record && $scope.record.userId != null) {
							recordSV.getMedicalHistoryBean.userId = $scope.record.userId;
							recordSV.getMedicalHistoryBean.historyType = type;
							recordSV.getMedicalHistoryBean.page = page;
							recordSV.getMedicalHistoryBean.rows = 10;
							recordSV.getMedicalHistoryBean.title = title;
							var ii = layer.load('loading...');
							if (type == "家族史") {
								if (title == "父亲患病情况") {
									recordSV
											.getMedicalHistory()
											.then(
													function(response) {
														layer.close(ii);
														if (response.data.data
																&& response.data.status == 200) {
															$scope.fathers = response.data.data.list;
														}
													}, function(reason) {
														layer.close(ii);
													}, function(value) {
														layer.close(ii);
													});

								} else if (title == "母亲患病情况") {
									recordSV
											.getMedicalHistory()
											.then(
													function(response) {
														layer.close(ii);
														if (response.data
																&& response.data.status == 200) {
															$scope.mothers = response.data.data.list;
														}
													}, function(reason) {
														layer.close(ii);
													}, function(value) {
														layer.close(ii);
													});
								} else if (title == "兄弟姐妹患病情况") {
									recordSV
											.getMedicalHistory()
											.then(
													function(response) {
														layer.close(ii);
														if (response.data
																&& response.data.status == 200) {
															$scope.brothers = response.data.data.list;
														}
													}, function(reason) {
														layer.close(ii);
													}, function(value) {
														layer.close(ii);
													});
								} else if (title == "子女患病情况") {
									recordSV
											.getMedicalHistory()
											.then(
													function(response) {
														layer.close(ii);
														if (response.data
																&& response.data.status == 200) {
															$scope.children = response.data.data.list;
														}
													}, function(reason) {
														layer.close(ii);
													}, function(value) {
														layer.close(ii);
													});
								}
							} else if (type == "遗传病史") {
								recordSV
										.getMedicalHistory()
										.then(
												function(response) {
													layer.close(ii);
													if (response.data
															&& response.data.status == 200) {
														$scope.genetics = response.data.data.list;
													}
												}, function(reason) {
													layer.close(ii);
												}, function(value) {
													layer.close(ii);
												});
							} else if (type == "过敏史") {
								if (title == "药物过敏史") {
									recordSV
											.getMedicalHistory()
											.then(
													function(response) {
														layer.close(ii);
														if (response.data
																&& response.data.status == 200) {
															$scope.allergys = response.data.data.list;
														}
													}, function(reason) {
														layer.close(ii);
													}, function(value) {
														layer.close(ii);
													});
								} else if (title == "其他过敏史") {
									recordSV
											.getMedicalHistory()
											.then(
													function(response) {
														layer.close(ii);
														if (response.data
																&& response.data.status == 200) {
															$scope.allergens = response.data.data.list;
														}
													}, function(reason) {
														layer.close(ii);
													}, function(value) {
														layer.close(ii);
													});
								}
							} else if (type == "残疾情况") {
								recordSV
										.getMedicalHistory()
										.then(
												function(response) {
													layer.close(ii);
													if (response.data
															&& response.data.status == 200) {
														$scope.objects = response.data.data.list;
													}
												}, function(reason) {
													layer.close(ii);
												}, function(value) {
													layer.close(ii);
												});
							}

						}

					}

					$scope.queryDiseaseHistory = function(page) {
						recordSV.getDiseaseHistoryBean.userId = $scope.record.userId;
						recordSV.getDiseaseHistoryBean.page = page;
						recordSV.getDiseaseHistoryBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV.getDiseaseHistory().then(function(response) {
							layer.close(ii);
							if (response.data && response.data.status == 200) {
								$scope.diseases = response.data.data.list;
							}
						}, function(reason) {
							layer.close(ii);
						}, function(value) {
							layer.close(ii);
						});
					}

					$scope.querySurgeryHistory = function(page) {
						recordSV.getSurgeryBean.page = page;
						recordSV.getSurgeryBean.userId = $scope.record.userId;
						recordSV.getSurgeryBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV.getSurgeryHistory().then(function(response) {
							layer.close(ii);
							if (response.data && response.data.status == 200) {
								$scope.operations = response.data.data.list;
							}
						}, function(reason) {
							layer.close(ii);
						}, function(value) {
							layer.close(ii);
						});
					}

					$scope.queryInjuryHistory = function(page) {
						recordSV.getInjuryBean.userId = $scope.record.userId;
						recordSV.getInjuryBean.page = page;
						recordSV.getInjuryBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV.getInjuryHistory().then(function(response) {
							layer.close(ii);
							if (response.data && response.data.status == 200) {
								$scope.injuries = response.data.data.list;
							}
						}, function(reason) {
							layer.close(ii);
						}, function(value) {
							layer.close(ii);
						});
					}

					$scope.queryTransfusionHistory = function(page) {
						recordSV.getTransfusionBean.userId = $scope.record.userId;
						recordSV.getTransfusionBean.page = page;
						recordSV.getTransfusionBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV
								.getTransfusionHistory()
								.then(
										function(response) {
											layer.close(ii);
											if (response.data
													&& response.data.status == 200) {
												$scope.transfusions = response.data.data.list;
											}
										}, function(reason) {
											layer.close(ii);
										}, function(value) {
											layer.close(ii);
										});
					}

					$scope.queryHospitalizedHistory = function(page) {
						recordSV.getHospitalizedBean.userId = $scope.record.userId;
						recordSV.getHospitalizedBean.page = page;
						recordSV.getHospitalizedBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV
								.getHospitalizedHistory()
								.then(
										function(response) {
											layer.close(ii);
											if (response.data
													&& response.data.status == 200) {
												$scope.objects = response.data.data.list;
											}
										}, function(reason) {
											layer.close(ii);
										}, function(value) {
											layer.close(ii);
										});
					}

					$scope.queryImmunizationHistory = function(page) {
						recordSV.getImmunizationBean.userId = $scope.record.userId;
						recordSV.getImmunizationBean.page = page;
						recordSV.getImmunizationBean.rows = 10;
						var ii = layer.load('loading...');
						recordSV
								.getImmunizationHistory()
								.then(
										function(response) {
											layer.close(ii);
											if (response.data
													&& response.data.status == 200) {
												$scope.objects = response.data.data.list;
											}
										}, function(reason) {
											layer.close(ii);
										}, function(value) {
											layer.close(ii);
										});
					}

					$scope.add = function(type, title, id) {
						if (id == "11" || id == "12" || id == "13"
								|| id == "14" || id == "15") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-genetic-popup.jsp",
										controller : 'addGeneticCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});

							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, title, 1);

							});
						} else if (id == "16") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-disability-popup.jsp",
										controller : 'addDisabilityCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, null, 1);
							});
						} else if (id == "17") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-allergy-popup.jsp",
										controller : 'addAllergyCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, "药物过敏史", 1);
							});
						} else if (id == "18") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-allergen-popup.jsp",
										controller : 'addAllergenCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, "其他过敏史", 1);
							});
						} else if (id == "19") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-disease-popup.jsp",
										controller : 'addDiseaseCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryDiseaseHistory(1);
							});
						} else if (id == "20") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-surgery-popup.jsp",
										controller : 'addSurgeryCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.querySurgeryHistory(1);
							});
						} else if (id == "21") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-injury-popup.jsp",
										controller : 'addInjuryCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryInjuryHistory(1);
							});
						} else if (id == "22") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-transfusion-popup.jsp",
										controller : 'addTransfusionCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryTransfusionHistory(1);
							});
						} else if (id == "23") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-hospitalized-popup.jsp",
										controller : 'addHospitalizedCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryHospitalizedHistory(1);
							});
						} else if (id == "24") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-immunization-popup.jsp",
										controller : 'addImmunizationCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryImmunizationHistory(1);
							});
						}
					};

					$scope.modify = function(type, title, id, object) {
						if (id == "11" || id == "12" || id == "13"
								|| id == "14" || id == "15") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-genetic-popup.jsp",
										controller : 'updateGeneticCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});

							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, title, 1);

							});
						} else if (id == "16") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-disability-popup.jsp",
										controller : 'updateDisabilityCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, null, 1);
							});
						} else if (id == "17") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-allergy-popup.jsp",
										controller : 'updateAllergyCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, "药物过敏史", 1);
							});
						} else if (id == "18") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-allergen-popup.jsp",
										controller : 'updateAllergenCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryMedicalHistory(type, "其他过敏史", 1);
							});
						} else if (id == "19") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-disease-popup.jsp",
										controller : 'updateDiseaseCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryDiseaseHistory(1);
							});
						} else if (id == "20") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-surgery-popup.jsp",
										controller : 'updateSurgeryCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.querySurgeryHistory(1);
							});
						} else if (id == "21") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-injury-popup.jsp",
										controller : 'updateInjuryCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryInjuryHistory(1);
							});
						} else if (id == "22") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-transfusion-popup.jsp",
										controller : 'updateTransfusionCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryTransfusionHistory(1);
							});
						} else if (id == "23") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-hospitalized-popup.jsp",
										controller : 'updateHospitalizedCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryHospitalizedHistory(1);
							});
						} else if (id == "24") {
							var modalInstance = $uibModal
									.open({
										animation : true,
										templateUrl : "../health/jsp/popup/record-hospital-immunization-popup.jsp",
										controller : 'updateImmunizationCtrl',
										size : "lg",
										resolve : {
											title : function() {
												return title;
											},
											id : function() {
												return id;
											},
											type : function() {
												return type;
											},
											object : function() {
												return object;
											},
											record : function() {
												return $scope.record;
											}
										}
									});
							modalInstance.result.then(function() {
								$scope.queryImmunizationHistory(1);
							});
						}
					}
                    //查看用户信息
					$scope.getAccountNumberInfo = function() {
						$scope.selectedTag = 1;
						$scope.queryUserInfo();
					};
					//查看基本扩展信息
					$scope.getBasicInfo = function() {
						$scope.selectedTag = 2;
						$scope.queryBasicInfo();
					};
					//查看家族史
					$scope.getTabFamilyHistory = function() {
						$scope.selectedTag = 3;
						$scope.queryMedicalHistory("家族史", "父亲患病情况", "1");
						$scope.queryMedicalHistory("家族史", "母亲患病情况", "1");
						$scope.queryMedicalHistory("家族史", "兄弟姐妹患病情况", "1");
						$scope.queryMedicalHistory("家族史", "子女患病情况", "1");
					};
					//查看遗传病史
					$scope.getTabGeneticDiseaseHistory = function() {
						$scope.selectedTag = 4;
						$scope.queryMedicalHistory("遗传病史", null, "1");
					};
					//查看既往史
					$scope.getTabPastHistory = function() {
						$scope.selectedTag = 5;
						$scope.queryDiseaseHistory("1");
						$scope.querySurgeryHistory("1");
						$scope.queryInjuryHistory("1");
						$scope.queryTransfusionHistory("1");
					};
					//查看残疾情况
					$scope.getTabDisabilitySituation = function() {
						$scope.selectedTag = 6;
						$scope.queryMedicalHistory("残疾情况", null, "1");
					};
					//查看用户信息过敏史
					$scope.getTabAllergyHistory = function() {
						$scope.selectedTag = 7;
						$scope.queryMedicalHistory("过敏史", "药物过敏史", "1");
						$scope.queryMedicalHistory("过敏史", "其他过敏史", "1");
					};
					//查看住院史
					$scope.getTabStayhospitalHistory = function() {
						$scope.selectedTag = 10;
						$scope.queryHospitalizedHistory("1");
					};
					//查看非免疫预防接种史
					$scope.getTabVaccinatesss = function() {
						$scope.selectedTag = 11;
						$scope.queryImmunizationHistory("1");
					};

					$scope.getTabHealthassess = function() {
						$scope.selectedTag = 12;
					};

				})
		.controller(
				'addUserCtrl',
				function($scope, $uibModalInstance, title, id, record, recordSV) {

				})
		.controller(
				'addGeneticCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.object = {};
					$scope.skin = getCookie("skin");
					$scope.confirm = function() {
						recordSV.addMedicalHistoryBean.historyType = type;
						recordSV.addMedicalHistoryBean.userId = record.userId;
						recordSV.addMedicalHistoryBean.title = title;
						recordSV.addMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.addMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateGeneticCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateMedicalHistoryBean.userId = record.userId;
						recordSV.updateMedicalHistoryBean.historyType = type;
						recordSV.updateMedicalHistoryBean.id = temp.id;
						recordSV.updateMedicalHistoryBean.title = title;
						recordSV.updateMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.updateMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addDisabilityCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addMedicalHistoryBean.userId = record.userId;
						recordSV.addMedicalHistoryBean.historyType = type;
						recordSV.addMedicalHistoryBean.title = title;
						recordSV.addMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.addMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateDisabilityCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateMedicalHistoryBean.userId = record.userId;
						recordSV.updateMedicalHistoryBean.historyType = type;
						recordSV.updateMedicalHistoryBean.id = temp.id;
						recordSV.updateMedicalHistoryBean.title = title;
						recordSV.updateMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.updateMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addAllergyCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addMedicalHistoryBean.userId = record.userId;
						recordSV.addMedicalHistoryBean.historyType = type;
						recordSV.addMedicalHistoryBean.title = title;
						recordSV.addMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.addMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateAllergyCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateMedicalHistoryBean.userId = record.userId;
						recordSV.updateMedicalHistoryBean.historyType = type;
						recordSV.updateMedicalHistoryBean.id = temp.id;
						recordSV.updateMedicalHistoryBean.title = title;
						recordSV.updateMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.updateMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addAllergenCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addMedicalHistoryBean.userId = record.userId;
						recordSV.addMedicalHistoryBean.historyType = type;
						recordSV.addMedicalHistoryBean.title = title;
						recordSV.addMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.addMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateAllergenCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateMedicalHistoryBean.userId = record.userId;
						recordSV.updateMedicalHistoryBean.historyType = type;
						recordSV.updateMedicalHistoryBean.id = temp.id;
						recordSV.updateMedicalHistoryBean.title = title;
						recordSV.updateMedicalHistoryBean.item = $scope.object.item;
						recordSV
								.updateMedicalHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addDiseaseCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addDiseaseHistoryBean.userId = record.userId;
						recordSV.addDiseaseHistoryBean.disease = $scope.object.disease;
						recordSV.addDiseaseHistoryBean.diagnosisTime = $(
								"#one-datePay").val()
								+ " 00:00:00";
						recordSV.addDiseaseHistoryBean.iscured = $scope.object.iscured;
						recordSV
								.addDiseaseHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateDiseaseCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateDiseaseHistoryBean.userId = record.userId;
						recordSV.updateDiseaseHistoryBean.disease = $scope.object.disease;
						recordSV.updateDiseaseHistoryBean.id = temp.id;
						recordSV.updateDiseaseHistoryBean.diagnosisTime = $(
								"#one-datePay").val()
								+ " 00:00:00";
						recordSV.updateDiseaseHistoryBean.iscured = $scope.object.iscured;
						recordSV
								.updateDiseaseHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addSurgeryCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addSurgeryBean.userId = record.userId;
						recordSV.addSurgeryBean.operationTime = $(
								"#one-datePay").val()
								+ " 00:00:00";
						recordSV.addSurgeryBean.operationName = $scope.object.operationName;
						recordSV.addSurgeryBean.operationResult = $scope.object.operationResult;
						recordSV
								.addSurgeryHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});

					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateSurgeryCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateSurgeryBean.userId = record.userId;
						recordSV.updateSurgeryBean.id = temp.id;
						recordSV.updateSurgeryBean.operationTime = $(
								"#one-datePay").val()
								+ " 00:00:00";
						recordSV.updateSurgeryBean.operationName = $scope.object.operationName;
						recordSV.updateSurgeryBean.operationResult = $scope.object.operationResult;
						recordSV
								.updateSurgeryHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addInjuryCtrl',
				function($scope, $uibModalInstance, title, type, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addInjuryBean.userId = record.userId;
						recordSV.addInjuryBean.injuryName = $scope.object.injuryName;
						recordSV.addInjuryBean.injuryTime = $("#one-datePay")
								.val()
								+ " 00:00:00";
						recordSV.addInjuryBean.injuryDescription = $scope.object.injuryDescription;
						recordSV
								.addInjuryHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateInjuryCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateInjuryBean.userId = record.userId;
						recordSV.updateInjuryBean.id = temp.id;
						recordSV.updateInjuryBean.injuryName = $scope.object.injuryName;
						recordSV.updateInjuryBean.injuryTime = $("#one-datePay")
								.val()
								+ " 00:00:00";
						recordSV.updateInjuryBean.injuryDescription = $scope.object.injuryDescription;
						recordSV
								.updateInjuryHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addTransfusionCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addTransfusionBean.userId = record.userId;
						recordSV.addTransfusionBean.transfusionTime = $(
								"#one-datePay").val()
								+ " 00:00:00";
						recordSV.addTransfusionBean.bloodTransfusion = $scope.object.bloodTransfusion;
						recordSV.addTransfusionBean.cause = $scope.object.cause;
						recordSV
								.addTransfusionHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateTransfusionCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateTransfusionBean.userId = record.userId;
						recordSV.updateTransfusionBean.id = temp.id;
						recordSV.updateTransfusionBean.transfusionTime = $(
								"#one-datePay").val()
								+ " 00:00:00";
						recordSV.updateTransfusionBean.bloodTransfusion = $scope.object.bloodTransfusion;
						recordSV.updateTransfusionBean.cause = $scope.object.cause;
						recordSV
								.updateTransfusionHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addHospitalizedCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addHospitalizedBean.userId = record.userId;
						recordSV.addHospitalizedBean.patientId = $scope.object.patientId;
						recordSV.addHospitalizedBean.institution = $scope.object.institution;
						recordSV.addHospitalizedBean.cause = $scope.object.cause;
						recordSV.addHospitalizedBean.hospitalInTime = $(
								"#hospital-in-date").val()
								+ " 00:00:00";
						recordSV.addHospitalizedBean.hospitalOutTime = $(
								"#hospital-out-date").val()
								+ " 00:00:00";
						recordSV.addHospitalizedBean.bedId = $scope.object.bedId;
						recordSV.addHospitalizedBean.bedInstitution = $scope.object.bedInstitution;
						recordSV.addHospitalizedBean.bedCreateTime = $(
								"#bed-create-date").val()
								+ " 00:00:00";
						recordSV.addHospitalizedBean.bedDelTime = $(
								"#bed-del-date").val()
								+ " 00:00:00";
						recordSV
								.addHospitalizedHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateHospitalizedCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateHospitalizedBean.userId = record.userId;
						recordSV.updateHospitalizedBean.id = temp.id;
						recordSV.updateHospitalizedBean.patientId = $scope.object.patientId;
						recordSV.updateHospitalizedBean.institution = $scope.object.institution;
						recordSV.updateHospitalizedBean.cause = $scope.object.cause;
						recordSV.updateHospitalizedBean.hospitalInTime = $(
								"#hospital-in-date").val()
								+ " 00:00:00";
						recordSV.updateHospitalizedBean.hospitalOutTime = $(
								"#hospital-out-date").val()
								+ " 00:00:00";
						recordSV.updateHospitalizedBean.bedId = $scope.object.bedId;
						recordSV.updateHospitalizedBean.bedInstitution = $scope.object.bedInstitution;
						recordSV.updateHospitalizedBean.bedCreateTime = $(
								"#bed-create-date").val()
								+ " 00:00:00";
						recordSV.updateHospitalizedBean.bedDelTime = $(
								"#bed-del-date").val()
								+ " 00:00:00";
						recordSV
								.updateHospitalizedHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										});
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'addImmunizationCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					$scope.object = {};
					$scope.confirm = function() {
						recordSV.addImmunizationBean.userId = record.userId;
						recordSV.addImmunizationBean.immunizationName = $scope.object.immunizationName;
						recordSV.addImmunizationBean.immunizationDate = $(
								"#immunization").val()
								+ " 00:00:00";
						recordSV.addImmunizationBean.immunizationInstitution = $scope.object.immunizationInstitution;
						recordSV
								.addImmunizationHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										})
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				})
		.controller(
				'updateImmunizationCtrl',
				function($scope, $uibModalInstance, type, title, id, record,
						object, recordSV) {
					$scope.title = title;
					$scope.skin = getCookie("skin");
					var temp = deepCopy(object);
					$scope.object = temp;
					$scope.confirm = function() {
						recordSV.updateImmunizationBean.userId = record.userId;
						recordSV.updateImmunizationBean.id = temp.id;
						recordSV.updateImmunizationBean.immunizationName = $scope.object.immunizationName;
						recordSV.updateImmunizationBean.immunizationDate = $(
								"#immunization").val()
								+ " 00:00:00";
						recordSV.updateImmunizationBean.immunizationInstitution = $scope.object.immunizationInstitution;
						recordSV
								.updateImmunizationHistory()
								.then(
										function(response) {
											if (response.data
													&& response.data.data) {
												$(showStackBottomRight("info",
														"亲", response.data.msg));
												if (response.data.status == 200
														|| response.data.status == '200') {
													$uibModalInstance.close();
												}
											}
										})
					};
					$scope.cancel = function() {
						$uibModalInstance.dismiss('cancel');
					};
				});
