

var app = angular.module('app', [ 'app.ctrl', 'ui.router', 'checklist-model', 'angularFileUpload', 'ui.bootstrap', 'health.filters',
                                  'controller.health','controller.house','service.house','controller.deviceInfo',
                                  'controller.statTestinfo','controller.sysrole','controller.statanalysis','controller.recordHospital',"controller.sysuser",'controller.sysOrganization',
                                  'controller.appFollowAcc','controller.appBasicInfo','controller.recordInfo',"service.record",
                                  'controller.deviceLink','controller.devicePaper','controller.statTestdata',"service.userRole","service.staff","service.organization",'service.stat',
                                  'graph','controller.statstatistics'
		]);
app.factory('httpInterceptor', [ '$q', '$injector',function($q, $injector) { 
    var httpInterceptor = { 
    	      'responseError' : function(response) { 
    	    	  return $q.reject(response); 
    	      }, 
    	      'response' : function(response) {
    	    	  if(!isEmpty(response.headers('redirectUrl'))){
    	    		  window.location.assign(contextPath+response.headers('redirectUrl'));
    	    	  }
    	    	  return response; 
    	      }, 
    	      'request' : function(config) { 
    	    	  return config; 
    	      }, 
    	      'requestError' : function(config){ 
    	    	  return $q.reject(config); 
    	      } 
    	    } 
    	  return httpInterceptor; 
    	}]);
app.config([ '$httpProvider', function($httpProvider) { 
  $httpProvider.interceptors.push('httpInterceptor'); 
} ]);
app
.run(function($rootScope) {

	$rootScope.realName=realName;
	function gotoIndex() {
		$location.path("../jsp/finance.jsp");
	}
	/*getAllPremises();*/
	function myFunction(path){
		var result = false;
		var menuIdTemp = "";
		var select_array = "";
		var dataForAjax = {};
		if(path in location_menuId){
			menuIdTemp = location_menuId[location.hash];
			select_array = "a[menuId=" + menuIdTemp + "]"
			dataForAjax ={
					"menuId" : menuIdTemp
			}
		}
		if(path in dispatch_order){
			var menuIdForAuthe = dispatch_order[location.hash];
			menuIdTemp = menuIdForAuthe.substr(0,2);
			var action = menuIdForAuthe.substr(3);
			select_array = "a[menuId=" + menuIdForAuthe + "]"
			dataForAjax ={
					"menuId" : menuIdTemp,
					"action" : action
			}
		}
		//var ii = layer.load('loading...');
			$.ajax({
				type : "POST",
				async : false,
				url : "authentication/left",
				dataType:"json",
				data : dataForAjax,
				headers:{
					'Content-Type': 'application/x-www-form-urlencoded',
					'Authorization': "Bearer "  + accessToken
				},
				success : function(ajaxData) {
					//layer.close(ii);
					if (ajaxData && ajaxData.data && ajaxData.data.organizationIdList
							&& ajaxData.data.organizationIdList.length > 0) {
						menuId = menuIdTemp;
						organizationIdList = ajaxData.data.organizationIdList;
						result = true;
						$('.skin-blue .treeview-menu>li,.skin-blue li.treeview ').removeClass('active');
						$(select_array).parent("li").addClass('active');
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
		return result;
	}

	var location_menuId = {
			'#/sys-user':6,
			'#/sys-role':5,
			'#/sys-organization':7	
	}
	
	var dispatch_order = {
			
	}
	
	var blank_url = {
			//"#/finance" : -1
			}
	
	$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
		if((("#"+toState.url) in location_menuId) || (("#"+toState.url) in dispatch_order)) {
			if(!myFunction("#" + toState.url)) {
				event.preventDefault();
			}else{
				setCookieUrl(contextPath+"/index#" + toState.url);
			}
		}
		if(("#"+toState.url) in blank_url){
			var menuIdTemp = blank_url["#"+toState.url];
			var select_array = "a[menuId=" + menuIdTemp + "]";
			jq('#sidebar-wrapper a').removeClass('active');
			jq(select_array).addClass('active');
		}
	})

})
.config(function($stateProvider, $urlRouterProvider) {
			
		$urlRouterProvider.otherwise("/health");
		
		$stateProvider.state('health', {
			url : "/health",
			views : {
				'title' : {
					template :  ""
				},
				'container' : {
					templateUrl : "../../health/jsp/health.jsp",
					controller:"healthCtrl"
				}
			}
		})
		
		$stateProvider.state('login', {
			url : "/login",
			views : {
				'title' : {
					template :  ""
				},
				'container' : {
					templateUrl : "../../health/jsp/login.jsp",
				}
			}
		})
		$stateProvider.state('app-basicinfo', {
			url : "/app-basicinfo",
			views : {
				'title' : {
					template : "基本信息"
				},
				'container' : {
					templateUrl : "../../health/jsp/app/app-basicinfo.jsp",
					controller:"appBasicInfoCtrl",
					resolve : {
						
					}
					
				}
			}
		})
		$stateProvider.state('app-followacc', {
			url : "/app-followacc",
			views : {
				'title' : {
					template : "关注账号"
				},
				'container' : {
					templateUrl : "../../health/jsp/app/app-followacc.jsp",
					controller:"appFollowAccCtrl",
					resolve : {
						
					}
					
				}
			}
		})
		
		$stateProvider.state('record-hospital', {
			url : "/record-hospital",
			views : {
				'title' : {
					template : "医院病历"
				},
				'container' : {
					templateUrl : "../../health/jsp/record/record-hospital.jsp",
					controller:"recordHospitalCtrl",
					resolve : {
						
					}
					
				}
			}
		})
		
		$stateProvider.state('record-info', {
			url : "/record-info",
			views : {
				'title' : {
					template : "档案管理"
				},
				'container' : {
					templateUrl : "../../health/jsp/record/record-info.jsp",
					controller:"recordInfoCtrl",
					resolve : {
						initData:function(recordSV){
							recordSV.getUserListBean.page = 1;
							recordSV.getUserListBean.rows = 10;
							var ii = layer.load('loading...');
							return recordSV.getUserList().then(function(response){
								layer.close(ii);
								if(response.data && response.data.status == 200){
									return response.data.data;
								}
							},function(reason){
								layer.close(ii);
							},function(value){
								layer.close(ii);
							});
							
							
						}
					}
					
				}
			}
		})
			
		$stateProvider.state('device-info', {
			url : "/device-info",
			views : {
				'title' : {
					template : "设备信息"
				},
				'container' : {
					templateUrl : "../../health/jsp/device/device-info.jsp",
					controller:"deviceInfoCtrl",
					resolve : {
						
					}
					
				}
			}
		})
		
		$stateProvider.state('device-link', {
			url : "/device-link",
			views : {
				'title' : {
					template : "关联设备"
				},
				'container' : {
					templateUrl : "../../health/jsp/device/device-link.jsp",
					controller:"deviceLinkCtrl",
					resolve : {
						
					}
					
				}
			}
		})
		
		$stateProvider.state('device-paper', {
			url : "/device-paper",
			views : {
				'title' : {
					template : "试纸管理"
				},
				'container' : {
					templateUrl : "../../health/jsp/device/device-paper.jsp",
					controller:"devicePaperCtrl",
					resolve : {
						
					}
					
				}
			}
		})
			
		
		$stateProvider.state('sys-role', {
			url : "/sys-role",
			views : {
				'title' : {
					template : "系统角色"
				},
				'container' : {
					templateUrl : "../../health/jsp/system/sys-role.jsp",
					controller : "sysroleCtrl",
					resolve : {
						initData : function(userRoleSV){
								
								userRoleSV.listBean.page = 1;
								userRoleSV.listBean.rows = 10;
								userRoleSV.listBean.roleName = null;   
								var ii = layer.load('loading...');
								return userRoleSV.list().then(function(response) {
									layer.close(ii);
									return response.data.data;
								}, function(reason) {
									layer.close(ii);
								}, function(value) {
									layer.close(ii);
								})
							}
					}
					
				}
			}
		})	
		
		$stateProvider.state('sys-user', {
			url : "/sys-user",
				views : {
					'title' : {
						template : "用户信息"
					},
					'container' : {
						templateUrl : "../../health/jsp/system/sys-user.jsp",
						controller : "sysuserCtrl",
						resolve : {
							initData : function(staffSV){
								staffSV.listBean.page = 1;
								staffSV.listBean.rows = 10;
								staffSV.listBean.userName = null; 
								staffSV.listBean.userLoginName= null;
								staffSV.listBean.roleIdList= null;
								staffSV.listBean.organizationIdList= null;
								staffSV.listBean.userTel= null;
								var ii = layer.load('loading...');
								return staffSV.list().then(function(response) {
									layer.close(ii);
									return response.data.data;
								}, function(reason) {
									layer.close(ii);
								}, function(value) {
									layer.close(ii);
								})
							}
						}
						
					}
				}
		})	
		$stateProvider.state('sys-organization', {
			url : "/sys-organization",
				views : {
					'title' : {
						template : "组织结构"
					},
					'container' : {
						templateUrl : "../../health/jsp/system/sys-organization.jsp",
						controller : "sysOrganizationCtrl",
						resolve : {
							initData : function(organizationSV){
								organizationSV.listBean.page = 1;
								organizationSV.listBean.rows = 10;
								organizationSV.listBean.organizationId = null; 
								organizationSV.listBean.organizationName= null;
								organizationSV.listBean.organizationPosition= null;
								organizationSV.listBean.type= null;
								organizationSV.listBean.tel= null;
								organizationSV.listBean.fax= null;
								organizationSV.listBean.email= null;
								organizationSV.listBean.weChat= null;
								organizationSV.listBean.qqNum= null;
								organizationSV.listBean.organizationLogo= null;
								var ii = layer.load('loading...');
								return organizationSV.list().then(function(response) {
									layer.close(ii);
									return response.data.data;
								}, function(reason) {
									layer.close(ii);
								}, function(value) {
									layer.close(ii);
								})
							}
						}
						
					}
				}
		})	
		
		$stateProvider.state('stat-testinfo', {
			url : "/stat-testinfo",
			views : {
				'title' : {
					template : "检测指标"
				},
				'container' : {
					templateUrl : "../../health/jsp/statistic/stat-testinfo.jsp",
					controller:"statTestinfoCtrl",
					resolve : {
					}
					
				}
			}
		})
		
		$stateProvider.state('stat-testdata', {
			url : "/stat-testdata",
			views : {
				'title' : {
					template : "检测数据"
				},
				'container' : {
					templateUrl : "../../health/jsp/statistic/stat-testdata.jsp",
					//controller:"statUserinfoCtrl",
					resolve : {
						
					}
					
				}
			}
		})
			
		$stateProvider.state('stat-analysis', {
			url : "/stat-analysis",
			views : {
				'title' : {
					template : ""
				},
				'container' : {
					templateUrl : "../../health/jsp/statistic/stat-analysis.jsp",
					resolve : {
						
					}
					
				}
			}
		})
		$stateProvider.state('stat-analysis2', {
			url : "/stat-analysis2",
			views : {
				'title' : {
					template : ""
				},
				'container' : {
					templateUrl : "../../health/jsp/statistic/stat-analysis2.jsp",
					resolve : {
						
					}
				
				}
			}
		})
		
		$stateProvider.state('stat-statistics', {
			url : "/stat-statistics",
			views : {
				'title' : {
					template : ""
				},
				'container' : {
					templateUrl : "../../health/jsp/statistic/stat-statistics.jsp",
					resolve : {
						
					}
					
				}
			}
		})
});

function loginoutFunction() {
	var ii = layer.load('loading...');
	$.ajax({
		type : "POST",
		async : false,
		url : contextPath+"/admin/logout",
		data:{"accessToken" : accessToken},
		dataType:"json",
		headers:{
			'Content-Type': 'application/x-www-form-urlencoded',
			'Authorization': "Bearer "  + accessToken
		},
		success : function(ajaxData) {
			layer.close(ii);
			showStackBottomRight('success',ajaxData.msg,'');
			if(ajaxData.status==103){
				window.location.assign(contextPath+"/login");
				accessToken=null;
				adminName=null;
				adminId=null;
				realName=null;
				adminInfo=null;
			}
		},
		error : function() {
			layer.close(ii);
			window.location.assign(contextPath+"/login");
			
		}
	});
}
