package com.health.interceptors;

import java.util.HashMap;

import org.springframework.util.AntPathMatcher;

/**
 * 
 * @author steve
 *
 * 白名单管理
 */
public class WhiteTable {
	
	HashMap<String, String> whiteTable = new HashMap<String, String>(); 
	AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	/**
	 * 添加白名单到HASHMAP
	 * @param url 白名单URL
	 */
	public void add(String url) {
		whiteTable.put(url, url);
	}
	
	/**
	 * 判断是否有该url资源
	 * @param url url资源
	 * @return
	 */
	public boolean isWhiteTableResource(String url) {
		
		String[] splitStrings = url.split("/");
		if(whiteTable.containsKey(url)) {
			return true;
		}
		for(int length = splitStrings.length-1; length >= 1; length--) {
			String temUrl = "";
			for(int i = 1; i < length; i++) {     //i从1开始，因为split函数会出现字符串"",所以第一个不能拼
				temUrl = temUrl + "/" + splitStrings[i];
			}
			
			if(whiteTable.containsKey(temUrl + "/*")) {
				if(antPathMatcher.match(whiteTable.get(temUrl + "/*"), url)) {
					return true;
				}
			}
			
			if(whiteTable.containsKey(temUrl + "/**")) {
				if(antPathMatcher.match(whiteTable.get(temUrl + "/**"), url)) {
					return true;
				}
			}
		}
		return false;
	}

}
