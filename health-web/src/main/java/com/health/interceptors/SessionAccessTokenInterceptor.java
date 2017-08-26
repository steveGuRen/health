package com.health.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.health.model.ThUser;
import com.health.service.ThUserService;

@Component
public class SessionAccessTokenInterceptor implements Interceptor {

	@Override
	public void doInterceptor(ServletRequest request, ServletResponse response,
			InterceptorChain chain) throws IOException, ServletException {
		  HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse)response;
	        String contextPath = req.getContextPath();
	        String servletPath =req.getServletPath();
		    String accessToken = (String) req.getSession().getAttribute("accessToken");
		    request.setAttribute("accessToken", accessToken);
			HttpServletRequest httpServletRequest = (HttpServletRequest)request;
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			String agent = httpServletRequest.getHeader("User-Agent");//微信端的请求头包含MicroMessenger
			if(accessToken == null) {
				log.info("SessionAccessTokenInterceptor is running. Session is invalid !");
				if(agent.contains("MicroMessenger")){
					res.sendRedirect(contextPath + "/appLogin");
					return;
				}else{
					res.sendRedirect(contextPath + "/login");
					return;
				}
			}else if(servletPath.endsWith(".jsp")) {
				return;
			}else{
				request.setCharacterEncoding("UTF-8");
				boolean hasAuthorization = true;
				String accessToken2 = null;
				if(httpServletRequest.getMethod().equals("GET")){
					accessToken2 = httpServletRequest.getParameter("accessToken");
				}else{
					//获取头部所有信息
					Enumeration headerNames = httpServletRequest.getHeaderNames();
					while (headerNames.hasMoreElements()) {
						String key = (String) headerNames.nextElement();
						String value = httpServletRequest.getHeader(key);
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
							accessToken2 = authentications[1].trim();
						}
					}
				}
				ThUser admin = new ThUser();
				admin.setAccessToken(accessToken);
				ThUser admin2 = adminService.get(admin);
				if(!StringUtils.equals(accessToken2, accessToken) || admin2 == null) {
					log.info("SessionAccessTokenInterceptor is running. Invalid accessToke:" + accessToken2);
					if(agent.contains("MicroMessenger")){
						res.sendRedirect(contextPath + "/appLogin");
						return;
					}else{
						res.sendRedirect(contextPath + "/login");
						return;
					}
				}			
			}
/*------------------------------------------权限模块start--------------------------------------------------------------*/
//		    if(!PermissionUtil.isWhiteTableForPermission(servletPath)) {
//		    	String location = request.getParameter("location");
//				String menuIdParam = request.getParameter("menuId");
//				Integer menuId = null;
//				if(StringUtils.isNotBlank(menuIdParam)){
//					menuId = Integer.valueOf(menuIdParam);
//				}
//				TbAdmin admin = adminService.findAdminByAccessToken(accessToken);
//				String adminId = admin.getAdminId();
//				if(StringUtils.equals(location, "left")){
//					//表示是左侧列表的点击事件，需要根据adminId、menuId获取有查看权限的小区
//					List<Integer> premisesIdList = adminServiceI.getPremises(adminId, menuId);
//					//以便contorl中获取小区信息
//					if(premisesIdList == null || premisesIdList.isEmpty()){
//						res.sendRedirect(contextPath + "/nopermission");
//						//TODO 跳转到无权限页面
//						return;
//					}
//					request.setAttribute("premisesIds",premisesIdList);
//					
//				}else{
//					String premisesIds = request.getParameter("premisesIdList");
//					String action = request.getParameter("action");
//					List<Integer> premisesIdList = new ArrayList<Integer>();
//					if(StringUtils.isNotBlank(premisesIds)){
//						premisesIdList = JSON.parseObject(premisesIds, new TypeReference<List<Integer>>(){});
//					}
//					List<Map<String,Object>> havePerimissions = adminServiceI.getPermissionByMenuId(adminId, menuId, premisesIdList);
//					if(!PermissionUtil.getPerimissionResult(premisesIdList, action, havePerimissions)){
//						res.sendRedirect(contextPath + "/nopermission");
//						//TODO 提示无法删除
//						return ;
//					};
//				}
//		    }
/*------------------------------------------权限模块end--------------------------------------------------------------*/
			chain.doInterceptor(request, response);
	}
	
	@Autowired
	ThUserService adminService;
	
	
	Logger log = LoggerFactory.getLogger(this.getClass());
}
