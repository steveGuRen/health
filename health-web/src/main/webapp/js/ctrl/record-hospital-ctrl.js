
angular.module('controller.recordHospital', [])
	.controller('recordHospitalCtrl', function($log, $scope, $location, $uibModal) {
		$scope.title = "添加病历";
		$scope.pageAdd = false;
		$scope.pageadd = function(){
			$scope.pageAdd = !$scope.pageAdd;
			$scope.selectedTag = 1;
			$scope.pageContent = !$scope.pageContent;
		};
		$scope.update = function(){
			$scope.pageAdd = !$scope.pageAdd;
			$scope.pageContent = !$scope.pageContent;
		}
		
		
	})
	
	