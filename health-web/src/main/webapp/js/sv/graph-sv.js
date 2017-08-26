/**
 * 
 */
angular.module('graph', [])
.factory('graphSV', function($http) {
		
	
	
		var listBean = {       
				/*sort: 'roleId',      
				order: 'asc',*/
				source: null,
				page: 1,
				rows: 10
		}
		
		
		var test = function($scope, userId) {
			if(!userId) {
				return;
			}
			listBean.source = userId;
			console.log(userId)
			var promise = $http(getReqConfig(getFormDateToLong(listBean), contextPath + "/thGraphTemp/query"));
			promise.then(function(value) {
				var nodeList = []
				var edgeList = []
				var textList = {}
				var length =  value.data.data.list.length;
				nodeList.push({
					data:{
						id : value.data.data.list[0].source,
						label: "你本人"
					}
				})
				for(var i = 0; i < length; i++) {
					textList[value.data.data.list[i].target] = {
							  str: value.data.data.list[i].compareEndTime
//							  ,
//							  x: evtTarget.position("x"),
//							  y: evtTarget.position("y")
					 }
					var tem = {
						data: {
							id : value.data.data.list[i].target,
							name: value.data.data.list[i].userName,
							label: "开始时间:"+ value.data.data.list[i].compareStartTime 
							+ "\n\n结束时间:" + value.data.data.list[i].compareEndTime 
							+ "\n\n" + value.data.data.list[i].userName
						},
						classes: 'multiline-manual'
					}
					var temEdge = {
						data: {
							source: value.data.data.list[i].source,
							target: value.data.data.list[i].target,
							name: "相似度" + value.data.data.list[i].diff
						}
					}
					if(value.data.data.list[i].target != userId) {						
						nodeList.push(tem);
						edgeList.push(temEdge);
					} 
				}
				var cy;
				$(function(){ // on dom ready

				cy = cytoscape({
//				  userPanningEnabled: false,
				    userZoomingEnabled: false,	
				  container: document.getElementById('cy'),
				  style: cytoscape.stylesheet()
				    .selector('node')
				      .css({
//				        'text-valign': 'center',
				        'background-color': 'rgb(247,150,70)',
				        'color': 'white',
				        'text-outline-width': 3,
				        'text-outline-color': 'rgb(247,150,70)',
				        'width': 80,
				        'height': 80,
				        'label': 'data(label)'
				      })
				    .selector('edge')
				      .css({
				        'content': 'data(name)',
				        'width': 8,
				        'line-color': 'rgb(147,205,221)',
				        'target-arrow-color': '#888',
				        'source-arrow-color': '#888',
				        'target-arrow-shape': 'triangle'
				      })
				      .selector('.multiline-manual')
				      .css({
				    	  'text-wrap': 'wrap'
				      }),
				  elements: {
				    nodes: nodeList,
				    edges: edgeList 
				  },
				  
				  layout: {
				    name: 'random'
				  }
				});

				}); 
				for(var i = 0; i < length - 1;i++) {
					if(value.data.data.list[i].target == userId) {						
						cy.style().selector("#" + value.data.data.list[i].target).style({
							width: 35 + 1 * 75, 
							height: 35 + 1 * 75 
						}).update();
					} else {						
						cy.style().selector("#" + value.data.data.list[i].target).style({
							"width": 35 + value.data.data.list[i].diff * 75,
							"height": 35 + value.data.data.list[i].diff * 75
						}).update();
					}
				}
//				cy.onRender(handler =function() {
//					var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//					for(var key in textList) {
//						var strInfo = textList[key];
//						ctx.fillText(strInfo.str, strInfo.x, strInfo.y);
//					}
//				});
//				
//				cy.on('position', function(event){
//					var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//					  var evtTarget = event.cyTarget;
//					  if( evtTarget === cy ){
//					      console.log('tap on background');
//					  } else {
//						  textList[evtTarget._private.data.id] = {
//								  str: textList[evtTarget._private.data.id].str,
//								  x: evtTarget.position("x"),
//								  y: evtTarget.position("y")
//						  }
//					  }
//				});
//				cy.on('free', function(event){
//					var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//					  var evtTarget = event.cyTarget;
//					  if( evtTarget === cy ){
//					      console.log('tap on background');
//					  } else {
//						  textList[evtTarget._private.data.id] = {
//								  str: textList[evtTarget._private.data.id].str,
//								  x: evtTarget.position("x"),
//								  y: evtTarget.position("y")
//						  }
//					  }
//					  var handler;
//						cy.onRender(handler =function() {
//							var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//							for(var key in textList) {
//								var strInfo = textList[key];
//								ctx.fillText(strInfo.str, strInfo.x, strInfo.y);
//							}
//							cy.offRender(handler);
//						});
//				});
//				cy.on('tap', function(event){//点击
//					  var evtTarget = event.cyTarget;
//					  if( evtTarget === cy ){
//					      console.log('tap on background');
//					  } else {
//					    console.log('tap on some element');
//					  }
//					  var handler;
//						cy.onRender(handler =function() {
//							var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//							for(var key in textList) {
//								var strInfo = textList[key];
//								ctx.fillText(strInfo.str, strInfo.x, strInfo.y);
//							}
//							cy.offRender(handler);
//						});
//				});
//				cy.on('pan', function(event){//平移
//					var evtTarget = event.cyTarget;
//					if( evtTarget === cy ){
//						console.log('tap on background');
//					} else {
//						console.log('tap on some element');
//					}
//					var handler;
//					cy.onRender(handler =function() {
//						var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//						for(var key in textList) {
//							var strInfo = textList[key];
//							ctx.fillText(strInfo.str, strInfo.x, strInfo.y);
//						}
//						cy.offRender(handler);
//					});
//				});
//				cy.on('layoutstop', function(event){//平移
//					var evtTarget = event.cyTarget;
//					if( evtTarget === cy ){
//						console.log('tap on background');
//					} else {
//						console.log('tap on some element');
//					}
//					var handler;
//					cy.onRender(handler =function() {
//						var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//						cy.nodes().forEach(function( ele ){
//							textList[ele.id()] = {
//									  str: textList[ele.id()].str,
//									  x: ele.position("x"),
//									  y: ele.position("y")
//							 }
//						});
//						cy.offRender(handler);
//					});
//				});
//				
//				(function(){
//					cy.nodes().forEach(function( ele ){
//						textList[ele.id()] = {
//								  str: textList[ele.id()].str,
//								  x: ele.position("x"),
//								  y: ele.position("y")
//						 }
//					});
//				})();
//				
//				//初始化
//				cy.onRender(handler =function() {
//					var ctx = document.getElementsByTagName("canvas")[2].getContext("2d");
//					for(var key in textList) {
//						var strInfo = textList[key];
//						ctx.fillText(strInfo.str, strInfo.x, strInfo.y);
//					}
//					setTimeout(function() {
//						cy.offRender(handler);
//					}, 1000)
//				})
			}, function(reason) {
				
			}, function(value) {
				
			})
		}	
		 
		return {
			test: test
		}

})