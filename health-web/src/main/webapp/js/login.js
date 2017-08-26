var URL_GET_RANDOM_CODE = contextPath + "/adminLogin/getRandomCode";
var URL_LOGIN = contextPath + "/adminLogin/admin-login";
var WEB_URL=contextPath+"/adminLogin/loginProcess";
//拼接报文函数
function strcat(list) {
	var str = "";
	for(var i = 0; i<list.length; i++) {
		for(var key in list[i]) {
			if(list[i][key]!=null) {
				str += key+"="+list[i][key]+"&" 
			}
		}
	}
	str = str.substr(0, str.length-1);
	return str;
}
angular.module('services',['angular-md5'])
	.factory('LoginService', function($http, md5) {
		  
		var loadJs=function(myurl){
			var req={
					method: 'GET',
					url:myurl,
			}
			var promise=$http(req);
			return promise;
		}

		var getRandomCode = function(adminName) {
			var req = {
					method: 'GET',
					url: URL_GET_RANDOM_CODE+ "?adminName="+adminName,
					headers: {
						'Content-Type':'application/x-www-form-urlencoded'
					}
			}
			var promise = $http(req);
			return promise;
		}
		
		var login = function(adminName, randomCode, adminPassword,code) {
			var formData = strcat([
			                       {"adminName": adminName},
			                       {"authentication": md5.createHash(randomCode + md5.createHash(adminPassword))},
			                       {"code":code}
			                       ]);
			var req = {
					method: 'POST',
					url: URL_LOGIN,
					data: formData,
					headers: {
						'Content-Type':'application/x-www-form-urlencoded'
					}
			}
			var promise = $http(req);
			return promise;
		}
		return {
			loadJs:function(myurl){
				return loadJs(myurl);
			},
			getRandomCode: function(adminName) {
				return getRandomCode(adminName);
			},
			login: function(adminName, randomCode, adminPassword,code) {
				return login(adminName, randomCode, adminPassword,code);
			}
		}
	});


angular.module('loginApp',['services'])
    .controller('LoginController', function($scope, $location,LoginService){
    	/* 换一张验证码 */  
    	$scope.refreshImage=function ($event){
    		var elid=$event.target;
    	    elid.src=elid.src + '?' + new Date().getTime();
    	}
    	$scope.login = function() {
    		if(isEmpty($scope.adminName)){
    			showStackBottomRight('error','请输入登录名！','');
    			return;
    		}
    		if(isEmpty($scope.adminPassword)){
    			showStackBottomRight('error','请输入密码！','');
    			return;
    		}
    		if(isEmpty($scope.code)){
    			showStackBottomRight('error','请输入验证码！','');
    			return;
    		}
    		var ii = layer.load('loading...');
    		var codePromise = LoginService.getRandomCode($scope.adminName);
    		codePromise.success(function(data) {
    			var loginPromise = LoginService.login($scope.adminName, data.data.randomCode, $scope.adminPassword,$scope.code.toLowerCase());
    			loginPromise.success(function(data) {
            		if(data.status == 100) {
            			window.location.assign(WEB_URL+"?accessToken="+data.data.accessToken);
            			//layer.close(ii);
            		}else {
            			layer.close(ii);
            			layer.alert(data.msg);
            		}
            	}).error(function (data){
            		layer.close(ii);
            		showStackBottomRight('error','发生异常，请重试！','');
            	});
        	})
    	}
    	
    	$('#code').keyup(function(){
    		
            if(event.keyCode == 13){
            	$scope.login();
            }
        });
    	
    	setTimeout(function() {
    		LoginService.loadJs(contextPath+'/common/js/jquery-migrate-1.1.0.js');
    		LoginService.loadJs(contextPath+'/common/js/jquery.jqprint-0.3.js');
    		LoginService.loadJs(contextPath+'/common/js/bootstrap-datetimepicker.js');
    		LoginService.loadJs(contextPath+'/common/js/ui-bootstrap-tpls.min.js');
    		LoginService.loadJs(contextPath+'/common/js/checklist-model.js');
    		LoginService.loadJs(contextPath+'/common/css/bootstrap.css');
    		LoginService.loadJs(contextPath+'/common/css/font-awesome.min.css');
    		LoginService.loadJs(contextPath+'/common/css/bootstrap-datetimepicker.min.css');
		}, 1000);
    })
    

