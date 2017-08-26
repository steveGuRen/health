<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content-controller" ng-controller="statStatisticsCtrl">
	<section class="content-header">
      <h1>数据分析
      
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="" ng-click="initData12(0);initDataEthtic(0);initDataMap(0);initDataPoint(0,'岁','kg/m','userAge','value','gender');typeClick(0,'体重');"> 体重</a></li>
        <li><a href="" ng-click="initData12(1);initDataEthtic(1);initDataMap(1);initDataPoint(1,'点','°C','updateTime','value','gender');typeClick(1,'体温');">体温</a></li>
        <li><a href="" ng-click="initData12(2);initDataEthtic(2);initDataMap(2);initDataPoint(2,'岁','mmHg','userAge','value','gender');typeClick(2,'血压');"> 血压</a></li>
        <li><a href="" ng-click="initData12(3);initDataEthtic(3);initDataMap(3);initDataPoint(3,'岁','%','userAge','value','result');typeClick(3,'血氧');">血氧</a></li>
        <li><a href="" ng-click="initData12(4);initDataEthtic(4);initDataMap(4);initDataPoint(4,'岁','mmol/L','userAge','value','result');typeClick(4,'血糖');"> 血糖</a></li>
        <li><a href="" ng-click="initData12(5);initDataEthtic(5);initDataMap(5);initDataPoint(5,'岁','次/分','userAge','value','result');typeClick(5,'心率');">心率</a></li>
        <li><a href="" ng-click="initData12(6);initDataEthtic(6);initDataMap(6);initDataPoint(6,'岁','%','userAge','value','result');typeClick(6,'脂肪率');"> 脂肪率</a></li>
        <li><a href="" ng-click="initData12(7);initDataEthtic(7);initDataMap(7);initDataPoint(7,'岁','','userAge','value','result');typeClick(7,'尿检');">尿检</a></li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-6">
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    	<!-- <div id="chart1" style="width: 600px;height:400px;"></div> -->
    	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">{{title.name1}}</h3> 

              <div class="box-tools pull-right">
              	<div ng-show="object.type==2">
              		<select
						ng-change="refreshData(object.type,object.secondType)"
						ng-model="object.secondType">
						<option value="">请选择</option>
						<option value="舒张压">舒张压</option>
						<option value="收缩压">收缩压</option>
					</select>
              	</div>
              	<div ng-show="object.type==4">
              		<select
						ng-change="refreshData(object.type,object.secondType)"
						ng-model="object.secondType">
						<option value="">请选择</option>
						<option value="空腹">空腹</option>
						<option value="餐后两小时">餐后两小时</option>
					</select>
              	</div>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <div id="chart1" style="height:400px"></div>
              </div>
            </div>
            <!-- /.box-body -->
        </div>
    	</div>
    	<div class="col-md-6">
    	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    	<!-- <div id="chart2" style="width: 600px;height:400px;"></div> -->
    	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">{{title.name2}}</h3> 

              
            </div>
            <div class="box-body">
              <div class="chart">
                <div id="chart2" style="height:400px"></div>
              </div>
            </div>
            <!-- /.box-body -->
        </div>
    	</div>
    	
    	
      </div>
      
      
      <div class="row" style="margin-top: 30px;">
      <div class="col-md-6">
    	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    	<!-- <div id="chart4" style="width: 600px;height:400px;"></div> -->
    	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">{{title.name3}}</h3> 

            </div>
            <div class="box-body">
              <div class="chart">
                <div id="chart4" style="height:400px"></div>
              </div>
            </div>
            <!-- /.box-body -->
        </div>
    	</div>
    	
    	<div class="col-md-6">
    	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    	<!-- <div id="chart3" style="width: 600px;height:400px;"></div> -->
    	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">{{title.name4}}</h3> 

              <div class="box-tools pull-right">
              	<div>
              		<select
						ng-change="initData(object.type)"
						ng-options="build.buildName for build in setBuilds.builds track by build.buildId"
						ng-model="object.build">
						<option value="">请选择</option>
					</select>
              	</div>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <div id="chart5" style="height:400px"></div>
              </div>
            </div>
            <!-- /.box-body -->
        </div>
    	</div>
    	
    	
      </div>
      
      <div class="row" style="margin-top: 30px;">
    	
    	<div class="col-md-12">
    	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    	<!-- <div id="chart3" style="width: 600px;height:400px;"></div> -->
    	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">{{title.name5}}</h3> 

              <div class="box-tools pull-right">
              	<div>
              		<!-- <select
						ng-change="initData(object.type)"
						ng-options="build.buildName for build in setBuilds.builds track by build.buildId"
						ng-model="object.build">
						<option value="">请选择</option>
					</select> -->
              	</div>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <div id="chart3" style="height:400px"></div>
              </div>
            </div>
            <!-- /.box-body -->
        </div>
    	</div>
    	
    	
      </div>
      
      <!-- <div class="row">
      	<div class="col-md-6">
    	为 ECharts 准备一个具备大小（宽高）的 DOM
    	<div id="chart4" style="width: 600px;height:400px;"></div>
    	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">{{title.name6}}</h3> 

              <div class="box-tools pull-right">
              	<div>
              		<select
						ng-change="initData(object.type)"
						ng-options="build.buildName for build in setBuilds.builds track by build.buildId"
						ng-model="object.build">
						<option value="">请选择</option>
					</select>
              	</div>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <div id="chart6" style="height:400px"></div>
              </div>
            </div>
            /.box-body
        </div>
    	</div>
      </div> -->

    </section>
  
</div>