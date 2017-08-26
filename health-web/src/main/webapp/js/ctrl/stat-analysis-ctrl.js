'use strict';
angular.module('controller.statanalysis', [])
	.controller('statAnalysisCtrl', function($log, $scope, $location, $uibModal, statSV) {
		
		//myChart.showLoading();
		var myChart1 = echarts.init(document.getElementById('chart1'));
		$.getJSON('../health/common/json/analysisText.json', function (json) {
		    //myChart.hideLoading();
		    var option = {
		        title: {
		            text: 'NPM Dependencies'
		        },
		        animationDurationUpdate: 1500,
		        animationEasingUpdate: 'quinticInOut',
		        series : [
		            {
		                type: 'graph',
		                layout: 'none',
		                // progressiveThreshold: 700,
		                data: json.nodes.map(function (node) {
		                    return {
		                        x: node.x,
		                        y: node.y,
		                        id: node.id,
		                        name: node.label,
		                        symbolSize: node.size,
		                        itemStyle: {
		                            normal: {
		                                color: node.color
		                            }
		                        }
		                    };
		                }),
		                edges: json.edges.map(function (edge) {
		                    return {
		                        source: edge.sourceID,
		                        target: edge.targetID
		                    };
		                }),
		                label: {
		                    emphasis: {
		                        position: 'right',
		                        show: true
		                    }
		                },
		                roam: true,
		                edgeSymbol: ['circle', 'arrow'],
			            edgeSymbolSize: [2, 5],
		                focusNodeAdjacency: true,
		                lineStyle: {
		                    normal: {
		                        width: 0.5,
		                        curveness: 0.3,
		                        opacity: 0.7
		                    }
		                }
		            }
		        ]
		    }
		    
		    myChart1.setOption(option);
		});
	})
	.controller('statAnalysisCtrl2', function($log, $scope, $location, $uibModal, statSV) {
//		var myChart = echarts.init(document.getElementById('graph-container'));
//		myChart.showLoading();
//		$.getJSON('../health/common/json/data.json', function (json) {
//		    myChart.hideLoading();
//		    var option = {}
//		    myChart.setOption(option = {
//		        title: {
//		            text: 'NPM Dependencies'
//		        },
//		        animationDurationUpdate: 1500,
//		        animationEasingUpdate: 'quinticInOut',
//		        series : [
//		            {
//		                type: 'graph',
//		                layout: 'none',
//		                // progressiveThreshold: 700,
//		                data: json.nodes.map(function (node) {
//		                    return {
//		                        x: node.x,
//		                        y: node.y,
//		                        id: node.id,
//		                        name: node.label,
//		                        symbolSize: node.size,
//		                        itemStyle: {
//		                            normal: {
//		                                color: node.color
//		                            }
//		                        }
//		                    };
//		                }),
//		                edges: json.edges.map(function (edge) {
//		                    return {
//		                        source: edge.source,
//		                        target: edge.target
//		                    };
//		                }),
//		                label: {
//		                    emphasis: {
//		                        position: 'right',
//		                        show: true
//		                    }
//		                },
//		                roam: true,
//		                focusNodeAdjacency: true,
//		                lineStyle: {
//		                    normal: {
//		                        width: 0.5,
//		                        curveness: 0.3,
//		                        opacity: 0.7
//		                    }
//		                }
//		            }
//		        ]
//		    }, true);
//		});
		var ii = layer.load('loading...');
		sigma.parsers.json('../health/common/json/data10.json', {
			  renderer: {
			    container: document.getElementById('graph-container'),
			    type: 'canvas'
			  },
			  settings: {
			 	minNodeSize: 2,
		        maxNodeSize: 40,
			    doubleClickEnabled: false,
			    minEdgeSize: 0.1,
			    maxEdgeSize: 1,
			    enableEdgeHovering: true,
			    edgeHoverColor: 'edge',
			    defaultEdgeHoverColor: '#F00',
			    edgeHoverSizeRatio: 1,
			    edgeHoverExtremities: true, 
			  }
			}, function(sig) {
				setTimeout(function() {
					layer.close(ii);
				},500); 
				sig.bind("clickNode", function (event) {
					var graph = sig.graph;
					var node = event.data.node;
					var relatedNodes = 
					console.log(event);
				});

				// Initialize the dragNodes plugin:
				var dragListener = sigma.plugins.dragNodes(sig, sig.renderers[0]);

				dragListener.bind('startdrag', function(event) {
				  console.log(event);
				});
				dragListener.bind('drag', function(event) {
				  console.log(event);
				});
				dragListener.bind('drop', function(event) {
				  console.log(event);
				});
				dragListener.bind('dragend', function(event) {
				  console.log(event);
				});
			});
	})
