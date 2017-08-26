angular.module('finance.filters',[])
	.filter('brString',function() { //很长的内容分段显示
		return function(string) {
			var result = "";
			var length = string.length;
			var brLength = 40;
			var brSize = length / brLength;
			var yushu = length % brLength;
			var br = "\n";
			var i = 0;
			for(; i < brSize; i++) {
				var subString = string.substr(i * brLength, brLength);
				result = result + subString + br;
			}
			return result;
		}
	})
	.filter('cutString',function() { //很长的内容只显示部分
		return function(string) {
			if(string.length>40) {
				return string.substr(0, 20) + "......";
			}
			return string;
		}
	})
	.filter('cutString10',function() { //很长的内容只显示部分
		return function(string) {
			if(string.length>10) {
				return string.substr(0, 10) + "...";
			}
			return string;
		}
	})
	.filter('cutString20',function() { //很长的内容只显示部分
		return function(string) {
			if(string.length>20) {
				return string.substr(0, 19) + "...";
			}
			return string;
		}
	})
	.filter('cutString16',function() { //很长的内容只显示部分
		return function(string) {
			if(string.length>16) {
				return string.substr(0, 15) + "...";
			}
			return string;
		}
	})
	.filter('percentage',function() { //将小数转为百分数
		return function(number) {
			if(number) {
				return number*100;
			}
		}
	})
	.filter('houseTotalReceive',function() { //按房屋缴费应收金额计算
		return function(object) {
			if((object.total.toFixed(1)*100-object.prepayAmount.toFixed(1)*100)/100 > 0) {
				return ((object.total.toFixed(1)*100-object.prepayAmount.toFixed(1)*100)/100).toFixed(1);
			}
			else{
				return 0;
			}
		}
	})
	.filter('formatStrDate',function(){//yyyy-mm-dd hh-mm-ss to yyyy-mm-dd
		return function(input,strDate){
			if(isEmpty(strDate)){
				return '';
			}else{
				return strDate.split(" ")[0];
			}
		}
	})
	.filter('strDateFilter',function() { 
		return function(date) {
			if(date){
				
				return date.substring(0,10);
			}
			else{
				return '';
			}
		}
	})
	.filter('receiveNameFilter',function() { 
		return function(object) {
			if(!object.name){
				return object.ownerNames;
			}
			else {
				return object.name;
			}
		}
	})
	.filter('itemNameFilter',function() { 
		return function(object) {
			if(!object.itemCount && object.itemCount != 0){
				return (object.itemName+'(历史欠费)');
			}
			else {
				return object.itemName;
			}
		}
	})
	.filter('addressFilter',function() { 
		return function(object) {
			var premisesId = null;
			var buildId = null;
			var unitId = null;
			var houseFloor = null;
			var houseId = null;
			var address = '';
			if(object.premisesName){
				
				address += object.premisesName;
			}
			if(object.buildName){
				
				address += object.buildName;
			}
			if(object.unitName){
				
				address += object.unitName;
			}
			if(object.houseFloor){
				
				address = address + object.houseFloor + '层';
			}
			if(object.houseNum){
				
				address = address + object.houseNum +'号';
			}
			
			return address;
		}
	})
	.filter('feeTypeFilter',function() { //进度显示
		return function(str) {
			var result = "";
			switch(str){
				case 1: result = "周期费项";
						break;
				case 2: result = "临时费项";
						break;
				
				case "1": result = "周期费项";
						break;
				case "2": result = "临时费项";
						break;
				
				default: result = str;
			}
			return result;
		}
	})
	.filter('houseTypeFilter',function() { //进度显示
		return function(str) {
			var result = "";
			switch(str){
				case 0: result = "普通住房";
						break;
				case 1: result = "商用住房";
						break;
				case 2: result = "空置";
						break;
				case 3: result = "虚拟";
						break;
				
				case "0": result = "普通住房";
						break;
				case "1": result = "商用住房";
						break;
				case "2": result = "空置";
						break;
				case "3": result = "虚拟";
						break;
				
				default: result = str;
			}
			return result;
		}
	})
	.filter('roleListCutFilter',function() { //用户身份
		return function(roleList) {
			if(!roleList || roleList==''){
				return "";
			}
			if(roleList.length>1){
				
				var result = roleList.join('，');
			}
			else{
				var result = roleList[0];
			}
			if(result.length>20) {
				return result.substr(0, 20) + "...";
			}
			return result;
		}
	})
	.filter('premiseListCutFilter',function() { //用户身份
		return function(premiseList) {
			if(!premiseList || premiseList==''){
				return "";
			}
			if(premiseList.length>1){
				
				var result = premiseList.join('，');
			}
			else{
				var result = premiseList[0];
			}
			if(result.length>20) {
				return result.substr(0, 20) + "...";
			}
			return result;
		}
	})
	.filter('itemvalueFilter',function(){
		return function(input,item) { 
			 return item.name;
		    }
		})
	.filter('formularFilter',function(){
		return function(formular,expressionList) {
				if(!expressionList){
					return '';
				}
				else{
					//var form;
					for(var i=0; i < expressionList.length;i++){
						formular=formular.replace(expressionList[i].variable,expressionList[i].colName) ;
					}
					return formular;
				}
		    } 
		})
	.filter('receiveTypeFilter',function() { //收款方式
		return function(number) {
			var typeName='';
			switch (number) {
			case 0:
				typeName='现金'; 
				break;
			case 1:
				typeName='刷卡'; 
				break;
			case 2:
				typeName='转账'; 
				break;
			case 3:
				typeName='微信'; 
				break;
			case 4:
				typeName='支付宝'; 
				break;
			case 5:
				typeName='红冲返还'; 
				break;
			case 6:
				typeName='置废票返还'; 
				break;
			default:
				break;
			}
			return typeName;
		}
	})
	.filter('billStatusFilter',function(){
		return function(number){
			var billStatusName='';
			switch (number) {
			case 0:
				billStatusName='废票';
				break;
			case 1:
				billStatusName='正常';
				break;
			case 2:
				billStatusName='红冲';
				break;
			case 3:
				billStatusName='换发票';
				break;
			case 4:
				billStatusName='部分红冲';
				break;
			default:
				break;
			}
			return billStatusName;
		}
	})
	.filter('prefixIntegerFilter',function(){
		return function(num){
			if(isEmpty(num)){
				return '';
			}
			return ( "0000000" + num ).substr(-7);
		}
	})
	.filter('numToCnyFilter',function(){
		return function(n){
			var fraction = [ '角', '分' ];
			var digit = [ '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒',
					'捌', '玖' ];
			var unit = [ [ '元', '万', '亿' ], [ '', '拾', '佰', '仟' ] ];
			var head = n < 0 ? '负' : '';
			n = Math.abs(n);
			var s = '';
			for (var i = 0; i < fraction.length; i++) {
				var a=Math.pow(10, i);
				var b=Math.floor(n * 10 * Math.pow(10, i));
				s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i])
						.replace(/零./, '');
			}
			s = s || '整';
			n = Math.floor(n);
			for (var i = 0; i < unit[0].length && n > 0; i++) {
				var p = '';
				for (var j = 0; j < unit[1].length && n > 0; j++) {
					p = digit[n % 10] + unit[1][j] + p;
					n = Math.floor(n / 10);
				}
				s = p.replace(/(零.)*零$/, '').replace(/^$/, '零')
						+ unit[0][i] + s;
			}
			return head + s.replace(/(零.)*零元/, '元').replace(/(零.)+/g,
							'零').replace(/^整$/, '零元整');
		}
	})
	.filter('currencyFilter',function($filter){//数字货币格式化
		return function(n){
			var a='';
			if(n<0){
				return '-'+$filter('currency')(Math.abs(n),'');
			}else{
				return $filter('currency')(n,'');
			}
		}
	})