package com.health.interceptors;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.service.ThUserService;
import com.health.utils.Return2AndriodFormat;

/**
 * 
 * @author steve
 *
 * accessToken 拦截器，判断http报文头里面保存的accessToken是否有效，拦截无效的请求
 */
@Component
public class AccessTokenInterceptor implements Interceptor {

	@Override
	public void doInterceptor(ServletRequest request, ServletResponse response,
			InterceptorChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		request.setCharacterEncoding("UTF-8");
		
		boolean hasAuthorization = true;
		String accessToken = null;
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
				accessToken = authentications[1].trim();
			}
		}
		if(accessToken == null) {
			log.info("AccessTokenInterceptor is running. Invalid accessToke:" + accessToken);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			Writer w = response.getWriter();
			String str = JSONObject.toJSONString(Return2AndriodFormat.getResult(400, "令牌失效，无权访问！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat).toString();
			w.write(str);
			w.flush();
			w.close();
			return;
		} else {
			boolean isValidToken = adminService.hasAccessToken(accessToken);
			request.setAttribute("accessToken", accessToken);
			if(isValidToken != true) {
				log.info("AccessTokenInterceptor is running. Invalid accessToke:" + accessToken);
				response.setCharacterEncoding("UTF-8");
				Writer w = response.getWriter();
				String str = JSONObject.toJSONString(Return2AndriodFormat.getResult(400, "令牌失效，无权访问！", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat).toString();
				w.write(str);
				w.flush();
				w.close();
				return;
			}
		}
/*------------------------------------------权限模块start--------------------------------------------------------------*/
//		String location = request.getParameter("location");
//		String menuIdParam = request.getParameter("menuId");
//		Integer menuId = Integer.valueOf(menuIdParam);
//		TbAdmin admin = adminService.findAdminByAccessToken(accessToken);
//		String adminId = admin.getAdminId();
//		if(StringUtils.equals(location, "left")){
//			//表示是左侧列表的点击事件，需要根据adminId、menuId获取有查看权限的小区
//			List<Integer> premisesIdList = adminServiceI.getPremises(adminId, menuId);
//			//以便contorl中获取小区信息
//			if(premisesIdList == null || premisesIdList.isEmpty()){
//				//TODO 跳转到无权限页面
//				return;
//			}
//			request.setAttribute("premisesIds",premisesIdList);
//			
//		}else{
//			String premisesIds = request.getParameter("premisesIdList");
//			String action = request.getParameter("action");
//			List<Integer> premisesIdList = new ArrayList<Integer>();
//			if(StringUtils.isNotBlank(premisesIds)){
//				premisesIdList = JSON.parseObject(premisesIds, new TypeReference<List<Integer>>(){});
//			}
//			List<Map<String,Object>> havePerimissions = adminServiceI.getPermissionByMenuId(adminId, menuId, premisesIdList);
//			if(!PermissionUtil.getPerimissionResult(premisesIdList, action, havePerimissions)){
//				//TODO 提示无法删除
//				return ;
//			};
//		}
/*------------------------------------------权限模块end--------------------------------------------------------------*/
		chain.doInterceptor(httpServletRequest, httpServletResponse);
	}
	
	
	@Autowired
	ThUserService adminService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
}
