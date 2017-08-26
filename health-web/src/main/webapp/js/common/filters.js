angular.module('health.filters', [])
    .filter('roleListCutFilter', function () { //用户身份
        return function (roleList) {
            if (!roleList || roleList == '') {
                return "";
            }
            if (roleList.length > 1) {

                var result = roleList.join('，');
            }
            else {
                var result = roleList[0];
            }
            if (result.length > 20) {
                return result.substr(0, 20) + "...";
            }
            return result;
        }
    })
    .filter('organizationListCutFilter', function () { //用户身份
        return function (organizationList) {
            if (!organizationList || organizationList == '') {
                return "";
            }
            if (organizationList.length > 1) {

                var result = organizationList.join('，');
            }
            else {
                var result = organizationList[0];
            }
            if (result.length > 20) {
                return result.substr(0, 20) + "...";
            }
            return result;
        }
    })
    .filter('genderFilter',function() { //性别显示
		return function(str) {
			var result = "";
			switch(str){
				case 1: result = "男";
						break;
				case 0: result = "女";
						break;
				
				case "1": result = "男";
						break;
				case "0": result = "女";
						break;
				
				default: result = str;
			}
			return result;
		}
	})