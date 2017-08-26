<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content-controller" ng-controller="statAnalysisCtrl">
	<section class="content-header">
      <h1>数据分析
      
        <small></small>
      </h1>
      
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
	       <div class="box box-primary">
	            <div class="box-header with-border">
	              <h3 class="box-title">{{title.name}}</h3> 
	
	              
	            </div>
	            <div class="box-body">
	              <div class="chart">
	                <div id="chart1" style="height:800px"></div>
	              </div>
	            </div>
	        </div>
    	
      </div>
      
    </section>
  
</div>