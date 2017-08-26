
'use strict';
angular.module('controller.statTestinfo', [])
	.controller('statTestinfoCtrl', function($log, $scope, $location, $uibModal) {
		$scope.quotaType = 0;
		
		$scope.classChange = function(){
			$('#tabButton li').css({
				'background': "#2c3b41",
				'color':'#b8c7ce'
			})
			$('#quotaType'+$scope.quotaType).css({
				'background':"#33CC99",
				'color':"#fff"
			});
		}
	})
	