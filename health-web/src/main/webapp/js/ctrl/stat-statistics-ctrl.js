'use strict';
angular.module('controller.statstatistics', [])
	.controller('statStatisticsCtrl', function($log, $scope, $location, $uibModal, statSV) {
		$scope.title={};
		$scope.typeClick = function(type,title){
			$scope.object.type=type;
			$scope.title.name1=title+'指标柱状图';
			$scope.title.name2=title+'指标饼图';
			$scope.title.name3=title+'指标地区分布图';
			$scope.title.name4=title+'指标散点图';
			$scope.title.name5=title+'指标民族分布图';
		}
		
		$scope.separateList12 = function(){
			for(var i in $scope.responses){
				var object={};
				$scope.titles.push($scope.responses[i].result);
				$scope.datas.push($scope.responses[i].resultCount);
				object.value = $scope.responses[i].resultCount;
				object.name = $scope.responses[i].result;
				$scope.objects.push(object);
				
			}
			$scope.histogram('',$scope.titles,$scope.datas);
			$scope.pieChart('',$scope.titles,$scope.objects);
		}
		
		$scope.refreshData = function(type,secondType){
			$scope.objects = [];
			var bean = $.extend({},true,bean,statSV.getStatListBean);
			bean.quotaType = type;
			if(secondType){
				bean.secondQuotaName = secondType;
			}
			
			var ii = layer.load('loading...');
			statSV.getStatList(bean).then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data ){
					
					$scope.responses = response.data.data.list;
					$scope.titles = [];
					$scope.datas = [];
					$scope.objects = []; 
					$scope.separateList12();
					//$scope.histogram('',$scope.titles,$scope.datas);
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		//柱状图和饼图
		$scope.initData12 = function(type){
			$scope.objects = [];
			$scope.object = {};
			var bean = $.extend({},true,bean,statSV.getStatListBean);
			bean.quotaType = type;
			bean.StatisticType = 0;
			var ii = layer.load('loading...');
			statSV.getStatList(bean).then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data ){
					
					$scope.responses = response.data.data.list;
					$scope.titles = [];
					$scope.datas = [];
					$scope.objects = []; 
					$scope.separateList12();
					//$scope.click(type);
					
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		
		$scope.jsonData=function(object,name,value){ 
			/*this.name = name; 
			this.value = value;*/ 
			if(!value || value.length==0){
				return;
			}
			object[name] = value;
		} 
		
		//民族图
		$scope.initDataEthtic = function(type){
			$scope.ethtics = [];
			$scope.ethtic = {};
			var bean = $.extend({},true,bean,statSV.getStatListBean);
			bean.quotaType = type;
			bean.StatisticType = 1;
			
			var ii = layer.load('loading...');
			statSV.getStatList(bean).then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data ){
					$scope.ethtic.names = [];
					for(var i in response.data.data.nationList){
						var object={};
						$scope.ethtic.names.push(response.data.data.nationList[i].nation);
						
						
					}
					$scope.ethtic.datas = {};
					for(var j in $scope.titles){
						var dataList =[];
						for(var t in $scope.ethtic.names){
							
							for(var i=0; i< response.data.data.list.length;i++){
								if(($scope.ethtic.names[t]==response.data.data.list[i].nation) && 
										($scope.titles[j]==response.data.data.list[i].result)){
									dataList.push(response.data.data.list[i].ratio);
									i= response.data.data.list.length;
								}
								else if((i==(response.data.data.list.length-1)) && (($scope.ethtic.names[t]!=response.data.data.list[i].nation) || 
										($scope.titles[j]!=response.data.data.list[i].result))){
									dataList.push(0);
								}
							}
						}
						$scope.jsonData($scope.ethtic.datas,$scope.titles[j],dataList);
					}
					var nameList = [];
					for(var k in $scope.ethtic.names){
						if(k%2==1){
							nameList.push('\n'+$scope.ethtic.names[k]);
						}
						else nameList.push($scope.ethtic.names[k]);
					}
					$scope.ethnic('',$scope.titles,$scope.ethtic.datas,nameList);
					
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		
		
		
		//地图
		$scope.initDataMap = function(type){
			$scope.objects = [];
			$scope.object = {};
			var bean = $.extend({},true,bean,statSV.getStatListBean);
			bean.quotaType = type;
			bean.StatisticType = 2;
			var ii = layer.load('loading...');
			statSV.getStatList(bean).then(function(response) {
				layer.close(ii);
				if(response.data && response.data.data ){
					
					$scope.distribution('',response.data.data.list);
					//$scope.click(type);
					
				}
				
			}, function(reason) {
				layer.close(ii);
			}, function(value) {
				layer.close(ii);
			});
		}
		
		
		//散点图
		$scope.initDataPoint = function(type,unitx,unity,x,y,z){
			
			$scope.inputData = {};
			$scope.inputData.unitx = unitx;
			$scope.inputData.unity = unity;
			$scope.inputData.x = x;
			$scope.inputData.y = y;
			$scope.inputData.z = z;
			var bean = $.extend({},true,bean,statSV.recordlistBean);
			bean.quotaType = type;
			
			//var ii = layer.load('loading...');
			statSV.recordlist(bean).then(function(response) {
				//layer.close(ii);
				if(response.data && response.data.data ){
					$scope.pointDatas = {}; 
					$scope.pointNames=[];
					$scope.pointData={};
					for(var item of response.data.data.list){
						var type=item[$scope.inputData.z];
						var innerData = [];
						if($scope.inputData.x=='updateTime'){//24小时，检测时间
							var time = item[$scope.inputData.x].substr(11,2);
							innerData.push(time);
						}
						else{
							
							innerData.push(item[$scope.inputData.x]);
						}
						innerData.push(item[$scope.inputData.y]);
						
						if($scope.pointDatas.hasOwnProperty(type)===false){
							$scope.pointNames.push(type);
							$scope.pointData[type]=[];
							$scope.pointData[type].push(innerData);
							$scope.pointDatas[type]=$scope.pointData[type];
						}
						else{
							$scope.pointDatas[type].push(innerData);
						}
						
						
					}
					if($scope.inputData.x=='updateTime'){//24小时，检测时间
						$scope.twoPoint('',$scope.inputData.unitx,$scope.inputData.unity,$scope.pointNames,$scope.pointDatas,0,24);
					}
					else{
						
						$scope.twoPoint('',$scope.inputData.unitx,$scope.inputData.unity,$scope.pointNames,$scope.pointDatas);
					}
					
				}
				
			}, function(reason) {
				//layer.close(ii);
			}, function(value) {
				//layer.close(ii);
			});
		}
		
		$scope.initData12(0);
		$scope.initDataEthtic(0);
		$scope.initDataMap(0);
		$scope.initDataPoint(0,'岁','kg/m','userAge','value','gender');
		$scope.typeClick(0,'体重');
		
		$scope.histogram = function(title,dataTitle,datas){
			 // 基于准备好的dom，初始化echarts实例
	        var myChart = echarts.init(document.getElementById('chart1'));

	        // 指定图表的配置项和数据
	        var option = {
	            title: {
	                //text: title
	            },
	            tooltip: {},
	            legend: {
	                data:['数量']
	            },
	            xAxis: {
	                data: dataTitle
	            },
	            yAxis: {},
	            series: [{
	                name: '数量',
	                type: 'bar',
	                data: datas
	            }]
	        };

	        // 使用刚指定的配置项和数据显示图表。
	        myChart.setOption(option);
		}
		
		$scope.pieChart = function(title,dataTitle,datas){
			var myChart2 = echarts.init(document.getElementById('chart2'));
	        
	        myChart2.setOption({
	        	title: {
	                //text: title,
	                x:'center'
	            },
	            tooltip: {
	            	trigger: 'item',
	                formatter: "{a} <br/>{b} : {c} ({d}%)"
	            },
	            legend: {
	                orient: 'vertical',
	                left: 'left',
	                data: dataTitle
	            },
	            series : [
	                {
	                    name: '访问来源',
	                    type: 'pie',
	                    radius: '55%',
	                    data:datas,
	                    itemStyle: {
	                        emphasis: {
	                            shadowBlur: 10,
	                            shadowOffsetX: 0,
	                            shadowColor: 'rgba(0, 0, 0, 0.5)'
	                        }
	                    }
	                }
	            ]
	        })
		}
		

		$scope.ethnic = function(title,dataTitles,datas,names){
			var myChart = echarts.init(document.getElementById('chart3'));
			var series=[];
			for(var i in dataTitles){
				var seri = {};
				seri.name=dataTitles[i];
				seri.type='bar';
				seri.data=datas[dataTitles[i]];
				series.push(seri);
			}

			var option = {
			    /*title : {
			        text: title,
			        subtext: '纯属虚构'
			    },*/
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    legend: {
			        data:names
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			        	'type':'category',
		                'axisLabel':{'interval':0},
			            data :names,
		                splitLine: {show: false}
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : series
			    
			};
			myChart.setOption(option);
		}
		
		$scope.distribution =function(title,dataList){
			$.get('../health/common/json/china.json', function (chinaJson) {
	            echarts.registerMap('china', chinaJson);
	            var myChart4 = echarts.init(document.getElementById('chart4'));
	            $.get('../health/common/json/cityData.json',function(cityData){
	            	var convertData = function (data) {
	            	    var res = [];
	            	    for (var i = 0; i < data.length; i++) {
	            	        var geoCoord = cityData[data[i].city];
	            	        if (geoCoord) {
	            	            res.push({
	            	                name: data[i].name,
	            	                value: geoCoord.concat(data[i].ratio)
	            	            });
	            	        }
	            	    }
	            	    return res;
	            	};
	            	
	            	var option4 = {
		            	    backgroundColor: '#404a59',
		            	   /* title: {
		            	        text: title,
		            	        subtext: '',
		            	        sublink: 'http://www.pm25.in',
		            	        x:'center',
		            	        textStyle: {
		            	            color: '#fff'
		            	        }
		            	    },*/
		            	    tooltip: {
		            	        trigger: 'item',
		            	        formatter: function (params) {
		            	            return params.name + ' : ' + params.value[2];
		            	        }
		            	    },
		            	    legend: {
		            	        orient: 'vertical',
		            	        y: 'bottom',
		            	        x:'right',
		            	        data:['pm2.5'],
		            	        textStyle: {
		            	            color: '#fff'
		            	        }
		            	    },
		            	    visualMap: {
		            	    	max:1,
		            	    	min:0,
		            	        calculable: true,
		            	        inRange: {
		            	            color: ['#50a3ba', '#eac736', '#d94e5d']
		            	        },
		            	        textStyle: {
		            	            color: '#fff'
		            	        }
		            	    },
		            	    geo: {
		            	        map: 'china',
		            	        label: {
		            	            emphasis: {
		            	                show: false
		            	            }
		            	        },
		            	        itemStyle: {
		            	            normal: {
		            	                areaColor: '#323c48',
		            	                borderColor: '#111'
		            	            },
		            	            emphasis: {
		            	                areaColor: '#2a333d'
		            	            }
		            	        }
		            	    },
		            	    series: [
		            	        {
		            	            name: '',
		            	            type: 'scatter',
		            	            coordinateSystem: 'geo',
		            	            data: convertData(dataList),
		            	            symbolSize: 12,
		            	            label: {
		            	                normal: {
		            	                    show: false
		            	                },
		            	                emphasis: {
		            	                    show: false
		            	                }
		            	            },
		            	            itemStyle: {
		            	                emphasis: {
		            	                    borderColor: '#fff',
		            	                    borderWidth: 1
		            	                }
		            	            }
		            	        }
		            	    ]
		            	}
		            	myChart4.setOption(option4);
	            	
	            })
	            
	        });
		}
		
		$scope.twoPoint = function(title,unitX,unitY,serieType,serieData,minX,maxX){
			var myChart = echarts.init(document.getElementById('chart5'));
			var serieList = [];
			
			for(var i of serieType){
				var serie = {};
				serie.name=i;
				serie.type='scatter';
				serie.data=serieData[i];
				serie.symbolSize=4;
				serie.markPoint={
			                data : [
			                    {type : 'max', name: '最大值'},
			                    {type : 'min', name: '最小值'}
			                ]
			            };
				serieList.push(serie);
			}
			
			
			var option = {
				    /*title : {
				        text: title,
				        subtext: '抽样调查来自: Heinz  2003'
				    },*/
				    grid: {
				        left: '3%',
				        right: '7%',
				        bottom: '3%',
				        containLabel: true
				    },
				    tooltip : {
				        trigger: 'axis',
				        showDelay : 0,
				        formatter : function (params) {
				            if (params.value.length > 1) {
				                return params.seriesName + ' :<br/>'
				                   + params.value[0] + unitX;
				                   + params.value[1] + unitY;
				            }
				            else {
				                return params.seriesName + ' :<br/>'
				                   + params.name + ' : '
				                   + params.value + unitY;
				            }
				        },
				        axisPointer:{
				            show: true,
				            type : 'cross',
				            lineStyle: {
				                type : 'dashed',
				                width : 1
				            }
				        }
				    },
				    toolbox: {
				        feature: {
				            dataZoom: {},
				            brush: {
				                type: ['rect', 'polygon', 'clear']
				            }
				        }
				    },
				    brush: {
				    },
				    legend: {
				        data: ['女性','男性'],
				        left: 'center'
				    },
				    xAxis : [
				        {
				            type : 'value',
				            scale:true,
				            axisLabel : {
				                formatter: '{value} '+unitX
				            },
				            splitLine: {
				                show: false
				            },
				            min:minX,
				            max:maxX
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value',
				            scale:true,
				            axisLabel : {
				                formatter: '{value} '+unitY
				            },
				            splitLine: {
				                show: false
				            }
				        }
				    ],
				    series : serieList
				};
			
			myChart.setOption(option);

		}
		
	
	})