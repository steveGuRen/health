
'use strict';
angular.module('controller.health', [])
	.controller('healthCtrl', function($log, $scope, $location, $uibModal) {
		if(getCookieUrl('url')==null){
			$('#url').hide();
		}
	})
	