/**
 * 控制手机端question跳转
 * **/
var app = angular.module("questionRoute",[]);

app.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise("/question/mobile-question-main");
	
	$stateProvider.state('question',{
		url: "/question/mobile-question-main",
		views : {
			'title' : {
				template : ""
			},
			'container' : {
				templateUrl : "../../health/jsp/question/mobile-question-list.jsp",
				controller: "questionItemCtrl"
			}
		}
	})
	
	
})