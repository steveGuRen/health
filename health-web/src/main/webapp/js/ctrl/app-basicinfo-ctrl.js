
'use strict';
angular.module('controller.appBasicInfo', [])
	.controller('appBasicInfoCtrl', function($log, $scope, $location, $uibModal) {
		$scope.skipToAdd = function() {
			$scope.pageContent = !$scope.pageContent;
			$scope.pageAdd = !$scope.pageAdd;
		}
	})
	