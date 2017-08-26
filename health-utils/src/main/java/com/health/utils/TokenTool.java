package com.health.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenTool {
	
	/**
	 * 从request中提取accessToken
	 * @param request
	 * @param response
	 * @return
	 */
	public static String extractToken(HttpServletRequest request, HttpServletResponse response) {
		boolean hasAuthorization;
		String accessToken = null;
		 //获取头部所有信息
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			if(key.trim().equals("authorization")) {
				String[] authentications = value.split(" ");
				if(authentications.length != 2) {
					hasAuthorization = false;
					break;
				}
				if(!authentications[0].trim().equals("Bearer")) {
					hasAuthorization = false;
					break;
				}
				if(!(authentications[1].trim().length() == 36)) {
					hasAuthorization = false;
					break;
				}
				accessToken = authentications[1].trim();
			}
		}
		return accessToken;
	}
}
