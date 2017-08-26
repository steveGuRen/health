package com.health.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;

public class PermissionUtil {
	
	private static HashMap<String, String> whiteTableForPermission = null;
	private static AntPathMatcher antPathMatcher = null;
	static {
		whiteTableForPermission = new HashMap<String, String>();
		whiteTableForPermission.put("/", "/");
		whiteTableForPermission.put("", "");
		whiteTableForPermission.put("/index","/index");
		whiteTableForPermission.put("/index.jsp", "/index.jsp");
		whiteTableForPermission.put("/jsp/**","/jsp/**");
		antPathMatcher = new AntPathMatcher(); 
	}
	
	
	/**
	 * @param primises  action havePerimissions
	 * @return boolen
	 * @since 2.0
	 */
public static boolean isWhiteTableForPermission(String url) {
		
		String[] splitStrings = url.split("/");
		if(whiteTableForPermission.containsKey(url)) {
			return true;
		}
		for(int length = splitStrings.length-1; length >= 1; length--) {
			String temUrl = "";
			for(int i = 1; i < length; i++) {     //i从1开始，因为split函数会出现字符串"",所以第一个不能拼
				temUrl = temUrl + "/" + splitStrings[i];
			}
			
			if(whiteTableForPermission.containsKey(temUrl + "/*")) {
				if(antPathMatcher.match(whiteTableForPermission.get(temUrl + "/*"), url)) {
					return true;
				}
			}
			
			if(whiteTableForPermission.containsKey(temUrl + "/**")) {
				if(antPathMatcher.match(whiteTableForPermission.get(temUrl + "/**"), url)) {
					return true;
				}
			}
		}
		return false;
	}
	
    /**
     * @param primises  action havePerimissions
     * @return boolen
     * @since 2.0
     */
	 public static boolean getPerimissionResult(List<Integer> organizations ,String action, List<Map<String, Object>> havePerimissions){
		//"0000"是没有权限
		boolean result = false;
		if(organizations != null && !organizations.isEmpty() && havePerimissions != null && !havePerimissions.isEmpty()){
//			int permissionForAll = 0;
			for(int i = 0; i<organizations.size(); i++){
				String permissionResult = "000000";
				Integer organization = organizations.get(i);
				//15是表示二进制1111，表示有权限
				int permissionForOne = 0;
				if( organization != null ){
					for(int j= 0;j<havePerimissions.size();j++){
						Map<String, Object> havePerimission = havePerimissions.get(j);
						if( havePerimission != null ){
							//0是表示无权限，内部是求并集
							if(organization == havePerimission.get("organizationId")){
								String permission = (String)havePerimission.get("permission");
								if(StringUtils.isNotBlank(permission) ){
									permissionForOne |= Integer.valueOf(permission, 2);
								}
							}
						}
					}
				}
				permissionResult =  "000000" + Integer.toBinaryString(permissionForOne);
				if(!judgePermissionSuccsess(action, permissionResult)){
					return false;
				}
			}
			return true;
		}
		return result;
	}
	 
	 /**
	  * @param 票据鉴权与其它点不一样,-2标识全部，-1标识只是自己的,如果判断自己操作的权限，只要一个满足就okay
	  * @return boolen
	  * @since 2.0
	  */
	 public static boolean getPerimissionResultOfUnion(List<Integer> organizations ,String action, List<Map<String, Object>> havePerimissions){
		 //"0000"是没有权限
		 boolean result = false;
		 if(organizations != null && !organizations.isEmpty() && havePerimissions != null && !havePerimissions.isEmpty()){
//			int permissionForAll = 0;
			 for(int i = 0; i<organizations.size(); i++){
				 String permissionResult = "000000";
				 Integer organization = organizations.get(i);
				 //15是表示二进制1111，表示有权限
				 int permissionForOne = 0;
				 if( organization != null ){
					 for(int j= 0;j<havePerimissions.size();j++){
						 Map<String, Object> havePerimission = havePerimissions.get(j);
						 if( havePerimission != null ){
							 //0是表示无权限，内部是求并集
							 if(organization == havePerimission.get("organizationId")){
								 String permission = (String)havePerimission.get("permission");
								 if(StringUtils.isNotBlank(permission) ){
									 permissionForOne |= Integer.valueOf(permission, 2);
								 }
							 }
						 }
					 }
				 }
				 permissionResult =  "000000" + Integer.toBinaryString(permissionForOne);
				 if(judgePermissionSuccsess(action, permissionResult)){
					 return true;
				 }
			 }
			 return false;
		 }
		 return result;
	 }

	 /**
	  * @param 根据动作
	  * @return boolen
	  * @since 2.0
	  */
	private static boolean judgePermissionSuccsess(String action, String permissionResult) {
		boolean result = false;
		switch (action) {
		case "select":// [查、导出]
			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-1, permissionResult.length()), "1")){
				result = true;
			} 
			break;
		case "update":
			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-2, permissionResult.length()-1), "1")){
				result = true;
			} 
			break;
		case "add":
			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-3, permissionResult.length()-2), "1")){
				result = true;
			} 
			break;
		case "delete":
			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-4, permissionResult.length()-3), "1")){
				result = true;
			} 
			break;
		case "import": // [导入]
			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-5, permissionResult.length()-4), "1")){
				result = true;
			} 
			break;
//		case "pay":// [付费、生费、收费]
//			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-6, permissionResult.length()-5), "1")){
//				result = true;
//			} 
//			break;
//		case "distribute":// [回收、分配（票据）]
//			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-7, permissionResult.length()-6), "1")){
//				result = true;
//			} 
//			break;
//		case "operateOfBill":// [红冲、废票、换发票]
//			if(StringUtils.equals(permissionResult.substring(permissionResult.length()-8, permissionResult.length()-7), "1")){
//				result = true;
//			} 
//			break;
		default:
			break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
