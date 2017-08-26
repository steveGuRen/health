//全局的用户信息
var accessToken=null;
var adminName=null;
var adminId=null;
var realName=null;
var adminTel=null;
var adminInfo=null;
//所有小区列表
var allPremises=[];


/**
 * 从map中获得表单数据
 * @param bean 
 * @returns {String}
 */
function getFormData(bean) {
	var str = "";
	for(var key in bean) {
		if(bean[key] != null) {
			str += key + "=" + bean[key] + "&"
		}
	}
	str = str.substr(0, str.length-1);
	return str;
} 
function getFormDataTrim(bean) {
	var str = "";
	for(var key in bean) {
		if(bean[key] != null) {
			if((bean[key] + "").trim() != "") {
				str += key + "=" + bean[key] + "&"
			}else {
				
			}
		}
	}
	str = str.substr(0, str.length-1);
	return str;
} 
function getFormDateToLong(bean) {
	var str = "";
	for(var key in bean) {
		if(bean[key] != null) {
			if(bean[key] instanceof Date) {
				str += key + "=" + bean[key].getTime() + "&"
			}else if((bean[key] + "").trim()!= "") {
				str += key + "=" + bean[key] + "&"
			}
		}
	}
	str = str.substr(0, str.length-1);
	return str;
} 

/**
 * 获得$http请求配置项
 * @param formdata
 * @param url
 */
function getReqConfig(formdata, url) {
	var config = {
		method: 'POST',
		url: url,
		data: formdata,
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
			'Authorization': "Bearer "  + accessToken
		}
	}
	return config;
}


function copyBean(source, target) {
	for(var key in target) {
		if(target[key] !== undefined) {
			target[key] = source[key]
		}
	}
	return target;
}
function copyBeanAll(source, target) {
	for(var key in target) {
		target[key] = source[key]
	}
	return target;
}
function initBean(bean) {//初始化bean里面的所有字段为null
	for(var key in bean) {
		bean[key] = null;
	}
}
function isNull(object){
	if(object==undefined||object==null){
		return true;
	}else{
		return false;
	}
}
function isEmpty(text){
	if(text==undefined||text==null||(''+text).trim()==''){
		return true;
	}else{
		return false;
	}
}

/**
 * 提示框
 */
function showStackBottomRight(type, title, text) {
    var opts = {
        title: title,
        text: text,
        timer: 10,
    	//delay: 1000
/*        addclass: "stack-bottomright",
        stack: stack_bottomright*/
    };
    switch (type) {
    case 'error':
        opts.type = "error";
        break;
    case 'info':
        opts.type = "info";
        break;
    case 'success':
        opts.type = "success";
        break;
     default:
    	 opts.type = "success";
     	break;
    }
    new PNotify(opts);
}


//判断是否可以分页
function ispage(totalPage,page){
	var pagin = {};
	if(isNaN(page)){
		pagin.status = false;
		pagin.msg='请点击页码';
		return pagin;
	}
	if(page>totalPage){
		pagin.status = false;
		pagin.msg = "已经是最后一页.";
		return pagin;
	}
	else if(page<1){
		pagin.status = false;
		pagin.msg = "已经是第一页.";
		return pagin;
	}
	else {
		pagin.status = true;
		return pagin;
	}
}

/**
 * Ajax分页功能 在需要分页的地方添加
 * <ul class="pagination">
 * </ol>
 * 作为分页组件容器元素。 pageCount 总页数 currentPage 当前页数 container 带有pagination类的ol容器元素
 * loadData 用于加载数据的函数 version 1.0
 */

function pagination(totalPage, currentPage, container, scope) {
	$scope = scope;
	
	this.minDisplayPage = 7;
	this.halfMinDisplayPage = 4;
	$scope.displayPages = [];
	var c = $('#'+container);
	var paginationLinks = "";
	if (totalPage == 0) {
		c.css({
			'visibility' : 'hidden'
		});
		return;
	}
	else if(totalPage <= this.minDisplayPage) {
		c.css({
			'visibility' : 'visible'
		});
		for(var i=1;i<=totalPage;i++){
			$scope.displayPages.push(i);
			$('#page'+i).css({'color':'black'});
		}
		$('#page'+currentPage).css({'color':'blue'});
	}
	else if (totalPage >= (this.minDisplayPage + 1) ) {
		c.css({
			'visibility' : 'visible'
		});
		if (currentPage >= this.halfMinDisplayPage && currentPage <= (totalPage-this.halfMinDisplayPage)) {
			for(var i=1;i<=this.minDisplayPage;i++){
				if(i==2 || i==6){
					$scope.displayPages.push("...");
				}
				else if(i==1){
					$scope.displayPages.push(i);
				}
				else if(i==7){
					$scope.displayPages.push(totalPage);
				}
				else if(i==3){
					$scope.displayPages.push(currentPage-1);
				}
				else if(i==4){
					$scope.displayPages.push(currentPage);
				}
				else if(i==5){
					$scope.displayPages.push(currentPage+1);
				}
			}
		}
		else if (currentPage < this.halfMinDisplayPage) {
			for(var i=1;i<=this.minDisplayPage;i++){
				if(i==6){
					$scope.displayPages.push('...');
				}
				else if(i<6){
					$scope.displayPages.push(i);
				}
				else if(i==7){
					$scope.displayPages.push(totalPage);
				}
			}
		} 
		else if(currentPage > (totalPage-this.halfMinDisplayPage)){
			for(var i=1;i<=this.minDisplayPage;i++){
				if(i==2){
					$scope.displayPages.push('...');
				}
				else if(i>2){
					$scope.displayPages.push(totalPage-(7-i));
				}
				else if(i==1){
					$scope.displayPages.push(i);
				}
			}
		}
	}
}
//table自增序号
function numberSorting(rows,page){ 
	setTimeout(function() {
		for(var i=0;i< $(".numberClass").length;i++){ 
			$(".numberClass").get(i).innerHTML = rows*(page-1)+i+1; 
		} 
	}, 100);
	
} 

/*时间插件的加载*/
function datepickerLoad(){
	$('[id^=datepicker]').datetimepicker({
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
		language: 'zh',
		 minView: "month"//表示日期选择的最小范围，默认是hour
	});
	$("input[endTimeAttr]").each(function (){
		$(this).datetimepicker({
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1,
			language: 'zh',
			minView: "month"//表示日期选择的最小范围，默认是hour
			}).on('show',function(ev){
				var value=this.attributes.endTimeAttr.value;
				$(this).datetimepicker("setStartDate",$("input[startTimeAttr="+value+"]").val());
			});
		});
	$("input[startTimeAttr]").each(function () { 
		$(this).datetimepicker({
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1,
			language: 'zh',
			minView: "month"//表示日期选择的最小范围，默认是hour
		}).on('show',function(ev){
			var value=this.attributes.startTimeAttr.value;
			$(this).datetimepicker("setEndDate",$("input[endTimeAttr="+value+"]").val());
		});
	});
	
	$("input[endTimeAttr2]").each(function (){
		$(this).datetimepicker({
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,//首先显示的视图
			forceParse : 0,
			showMeridian : 1,
			language: 'zh',
			minView: "month"//表示日期选择的最小范围，默认是hour
			}).on('show',function(ev){
				var value=this.attributes.endTimeAttr2.value;
				var df=new Date($("input[startTimeAttr2="+value+"]").val());
				$(this).datetimepicker("setStartDate",df);
			}).on('changeDate',function(ev){
				var  lastdate = new Date(ev.date.getFullYear(),ev.date.getMonth()+1,0);
				var lastdateStr= lastdate.getFullYear() + '-' + ('0'+(lastdate.getMonth()+1)).substr(-2) + '-' + lastdate.getDate();
				var value=this.attributes.endTimeAttr2.value;
				$("input[endTimeAttr2="+value+"]").val(lastdateStr);
			});
		});
	$("input[startTimeAttr2]").each(function () { 
		$(this).datetimepicker({
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			forceParse : 0,
			showMeridian : 1,
			language: 'zh',
			minView: "month"//表示日期选择的最小范围，默认是hour
		}).on('show',function(ev){
			var value=this.attributes.startTimeAttr2.value;
			var df=new Date($("input[endTimeAttr2="+value+"]").val());
			$(this).datetimepicker("setEndDate",df);
		}).on('changeDate',function(ev){
			var firstdate = ev.date.getFullYear() + '-' +('0'+(ev.date.getMonth()+1)).substr(-2) + '-01'; 
			var value=this.attributes.startTimeAttr2.value;
			$("input[startTimeAttr2="+value+"]").val(firstdate);
			$("input[startTimeAttr2="+value+"]").datetimepicker('update');
		});
	});
}

//拼接报文函数
function strcat(list) {
	var str = "";
	for(var i = 0; i<list.length; i++) {
		for(var key in list[i]) {
			if(list[i][key]!=null) {
				str += key+"="+list[i][key]+"&" 
			}
		}
	}
	str = str.substr(0, str.length-1);
	return str;
}
function setCookieUrl(url){
	var Days=30;
	var exp = new Date(); 
	exp.setTime(exp.getTime() + Days*24*60*60*1000); 
	document.cookie ="url="+ escape (url) + ";expires=" + exp.toGMTString(); 
}
function getCookieUrl(name){
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return unescape(arr[2]); 
    else 
        return null; 
}
function goUrl(){
	var url =getCookieUrl('url');
	window.location.href=url;	
}
function getAllPremises(){
	$.ajax({
		type:'POST',
		async : false,
		url:'house/premiseslist',
		dataType:'json',
		data : '',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
			'Authorization': "Bearer "  + accessToken
		},
		success : function(ajaxData) {
			if (ajaxData && ajaxData.data && ajaxData.data.premisesList
					&& ajaxData.data.premisesList.length > 0) {
				allPremises=ajaxData.data.premisesList;
			} 
		},
		error : function() {
		}
	});
}
function judgePermission(action,selectedPremisesIdList){
	if(!selectedPremisesIdList){
		selectedPremisesIdList = [];
	}
	var result = false;
	$.ajax({
		type : "POST",
		async : false,
		url : "authentication/action",
		dataType:"json",
		headers:{
			'Content-Type': 'application/x-www-form-urlencoded',
			'Authorization': "Bearer "  + accessToken
		},
		data : {
			"menuId" : menuId,
			"organizationIdList" : JSON.stringify(selectedPremisesIdList),
			"action" : action
		},
		success : function(ajaxData) {
			if (ajaxData && ajaxData.data && ajaxData.data.havePermission) {
				result =true;
			} else {
				if(action && action == "select"){//查、导出
					layer.alert("对不起,您没有权限，请联系管理员");
				}
				if(action && action == "update"){
					layer.alert("对不起,您没有修改权限，请联系管理员");
				}
				if(action && action == "add"){
					layer.alert("对不起,您没有添加权限，请联系管理员");
				}
				if(action && action == "delete"){
					layer.alert("对不起,您没有删除权限，请联系管理员");
				}
				if(action && action == "import"){//导入
					layer.alert("对不起,您没有导入权限，请联系管理员");
				}
				if(action && action == "pay"){//付费、生费、收费
					layer.alert("对不起,您没有权限，请联系管理员");
				}
				if(action && action == "distribute"){//回收、分配（票据）
					layer.alert("对不起,您没有权限，请联系管理员");
				}
				if(action && action == "operateOfBill"){//红冲、废票、换发票）
					layer.alert("对不起,您没有权限，请联系管理员");
				}
				result = false;
			}
		},
		error : function() {
			//layer.close(ii);
			window.location.href="login";
		}
	});
	return result;
}

//对象的深拷贝
function deepCopy(object){
	var copy = {};
	for (var key in object){
		copy[key] = typeof object[key] == 'object'? deepCopy(object[key]):object[key];
	}
	return copy;
}

//刷新当前页
$('.treeview-menu li a').click(function(){
	if(window.location.href==$(this).prop('href')){
		window.location.reload();
	}
	
})
