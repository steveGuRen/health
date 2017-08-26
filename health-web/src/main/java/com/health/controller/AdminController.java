package com.health.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThAdminRoleOrganization;
import com.health.model.ThMenu;
import com.health.model.ThOrganization;
import com.health.model.ThRole;
import com.health.model.ThRoleMenu;
import com.health.model.ThUser;
import com.health.service.ThMenuService;
import com.health.service.ThOrganizationService;
import com.health.service.ThRoleService;
import com.health.service.ThUserService;
import com.health.utils.Bean2MapUtil;
import com.health.utils.GlobalConstant;
import com.health.utils.PageHelper;
import com.health.utils.PermissionUtil;
import com.health.utils.Return2AndriodFormat;
import com.health.utils.TokenTool;

@RestController
public class AdminController {
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	ThUserService thUserService;
	
	@Autowired
	ThRoleService thRoleService;
	
	@Autowired
	ThMenuService thMenuService;
	
	@Autowired
	ThOrganizationService thOrganizationService;
	
	/**
	 * 获得ADMIN信息 {@link backend.tools.token.RolesTool}
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/getAdminInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getAdminInfo(HttpServletRequest request, HttpServletResponse response) {
		String token = TokenTool.extractToken(request, response);
		if (token == null) {
			log.info("Get AdminInfo is failed. The token is null.");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(400, "令牌失效，无权访问！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		ThUser t = new ThUser();
		t.setAccessToken(token);
		ThUser admin = thUserService.get(t);
		if (admin == null) {
			log.info("Get AdminInfo is failed. can't find admin by accessToken. token is " + token + ".");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(400, "令牌失效，无权访问！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		JSONObject data = new JSONObject();
		data.put("adminInfo", admin);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "OK！", data),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}
	
	/**
	 * 添加角色
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	@ResponseBody
	public String addRole(ThRole role, HttpServletRequest request) {
		// 首先判断角色名是否存在
		ThRole roleOld = new ThRole();
		roleOld.setRoleName(role.getRoleName());
		roleOld = thRoleService.get(roleOld);
		if (roleOld != null)
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "此角色名已存在", null),
							SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		
		String roleMenuListStr = request.getParameter("roleMenuList");
		List<ThRoleMenu> roleMenuList = null;
		if (StringUtils.isNotBlank(roleMenuListStr)) {
			roleMenuList = JSON.parseObject(roleMenuListStr, new TypeReference<List<ThRoleMenu>>() {
			});
		}
		Integer id = thRoleService.saveRole(role, roleMenuList);
		JSONObject jo = new JSONObject();
		jo.put("roleId", id);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 获得Role列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/role/list")
	@ResponseBody
	public String listRole(ThRole role, PageHelper ph, HttpServletRequest request) {

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap = Bean2MapUtil.transBean2Map(role);

		List<Map<String, Object>> resultlist = thRoleService.getRoleList(whereMap, ph);

		Long totalCount = (Long) thRoleService.getCountOfRole(whereMap);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("roleList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 根据角色名获得角色详细信息
	 * 
	 * @param roleName
	 * @return
	 */
	@RequestMapping("/role/view")
	@ResponseBody
	public String viewRole(ThRole role) {

		PageHelper ph = new PageHelper();
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap = Bean2MapUtil.transBean2Map(role);

		List<Map<String, Object>> resultlist = thRoleService.getRoleListDetail(whereMap, ph);// 角色的详细信息

		JSONObject jo = new JSONObject();
		jo.put("roleList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 删除角色列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/role/delete")
	@ResponseBody
	public String delRoleList(HttpServletRequest request, HttpServletResponse response) {
		String roleIds = request.getParameter("roleIdList");
		List<Integer> roleIdList = new ArrayList<Integer>();
		if (StringUtils.isNotBlank(roleIds)) {
			roleIdList = JSON.parseObject(roleIds, new TypeReference<List<Integer>>() {
			});
		}
		if(roleIdList.contains(0)){
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "失败！房屋信息角色不可删除！", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}else{
			for (Integer roleId : roleIdList) {
				ThRole role = new ThRole();
				role.setRoleId(roleId);
				thRoleService.deleteRole(role);
			}
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);			
		}			
	}

	/**
	 * 更新角色
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/role/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateRole(ThRole role, HttpServletRequest request) {
		String roleMenuListStr = request.getParameter("roleMenuList");
		List<ThRoleMenu> roleMenuList = null;
		if (StringUtils.isNotBlank(roleMenuListStr)) {
			roleMenuList = JSON.parseObject(roleMenuListStr, new TypeReference<List<ThRoleMenu>>() {
			});
		}
		Integer id = null;
		id = thRoleService.updateById(role, roleMenuList);
		JSONObject jo = new JSONObject();
		if (id == 0) {
			log.error("修改角色失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
							SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		jo.put("roleId", role.getRoleId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 获取菜单列表
	 * 
	 * @return
	 */
	@RequestMapping("/menu/list")
	@ResponseBody
	public String listAdminMenu(ThMenu menu, PageHelper ph) {

		List<ThMenu> allMenuList = thMenuService.getMenuList(menu, ph);
		List<ThMenu> resultlist = new ArrayList<ThMenu>();
		for (int i = 0; i < allMenuList.size(); i++) {
			ThMenu fmenu = allMenuList.get(i);
			// 如果父菜单编号为0,表示为一级菜单
			if (fmenu.getPid() == 0) {
				List<ThMenu> menu2List = new ArrayList<ThMenu>();
				// 子菜单
				for (int j = 0; j < allMenuList.size(); j++) {
					ThMenu menu2 = allMenuList.get(j);
					if (fmenu.getMenuId().equals(menu2.getPid())) {
						menu2List.add(menu2);
					}
				}
				fmenu.setAdminMenuMenu2(menu2List);
				resultlist.add(fmenu);
			}
		}
		Long totalCount = thMenuService.getCountOfMenu(menu);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("adminMenuList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}
	
	/**
	 * 添加管理员
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	@ResponseBody
	public String addAdmin(ThUser admin, HttpServletRequest request) {
		// 首先判断管理员是否存在
		ThUser adminOld = new ThUser();
		adminOld.setUserLoginName(admin.getUserLoginName());;
		adminOld = thUserService.get(adminOld);
		if (adminOld != null)
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "此手机号已注册", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		
		String adminRoleOrganizationListStr = request.getParameter("adminRoleOrganizationList");
		List<ThAdminRoleOrganization> adminRoleOrganizationList = null;
		if (StringUtils.isNotBlank(adminRoleOrganizationListStr)) {
			adminRoleOrganizationList = JSON.parseObject(adminRoleOrganizationListStr, new TypeReference<List<ThAdminRoleOrganization>>() { });
		}
		Date currentDate = new Date();
		admin.setCreatedTime(currentDate);
		admin.setLastModifiedTime(currentDate);
		admin.setLoginFailedTimes(0);		
		admin.setLastLoginFailedTime(currentDate);
		admin.setLastLoginTime(currentDate);
		String userId = thUserService.addAdmin(admin, adminRoleOrganizationList);

		JSONObject jo = new JSONObject();
		jo.put("userId", userId);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 获得所有ADMIN列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/list")
	@ResponseBody
	public String listAdmin(ThUser admin, PageHelper ph, HttpServletRequest request) {

		String organizationIds = request.getParameter("organizationIdList");
		String roleIds = request.getParameter("roleIdList");
		List<Integer> organizationIdList = new ArrayList<Integer>();
		List<Integer> roleIdList = new ArrayList<Integer>();
		if(StringUtils.isNotBlank(organizationIds)){
			organizationIdList = JSON.parseObject(organizationIds, new TypeReference<List<Integer>>(){});
		}
		if(StringUtils.isNotBlank(roleIds)){
			roleIdList = JSON.parseObject(roleIds, new TypeReference<List<Integer>>() {
					});
		}
		admin.setOrganizationIds(organizationIdList);
		admin.setRoleIds(roleIdList);
		List<Map<String, Object>> resultlist = thUserService.getAdminListMap(admin, ph);
		Long totalCount = (Long) thUserService.getCountOfAdminList(admin);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("adminList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 获得管理员详细信息
	 * 
	 * @param adminName
	 * @return
	 */
	@RequestMapping("/admin/view")
	@ResponseBody
	public String viewAdmin(ThUser admin) {

		PageHelper ph = new PageHelper();
		Map<String, Object> params = new HashMap<String, Object>();
		params = Bean2MapUtil.transBean2Map(admin);
		List<Map<String, Object>> resultlist = thUserService.getAdminListDetail(params, ph);// 管理员的详细信息

		JSONObject jo = new JSONObject();
		jo.put("adminList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 删除管理员列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping("/admin/delete")
	@ResponseBody
	public String delAdminList(HttpServletRequest request, HttpServletResponse response) {
		String adminIds = request.getParameter("adminIdList");
		List<String> adminIdList = new ArrayList<String>();
		if (StringUtils.isNotBlank(adminIds)) {
			adminIdList = JSON.parseObject(adminIds, new TypeReference<List<String>>() {
			});
		}
		for (String adminId : adminIdList) {
			ThUser admin = new ThUser();
			admin.setUserId(adminId);;
			thUserService.deleteAdmin(admin);
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", null),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 更新管理员
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/admin/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateAdmin(ThUser admin, HttpServletRequest request) {
		String adminRoleOrganizationListStr = request.getParameter("adminRoleOrganizationList");
		List<ThAdminRoleOrganization> adminRoleOrganizationList = null;
		if (StringUtils.isNotBlank(adminRoleOrganizationListStr)) {
			adminRoleOrganizationList = JSON.parseObject(adminRoleOrganizationListStr, new TypeReference<List<ThAdminRoleOrganization>>() { });
		}
		Date currentDate = new Date();
		admin.setLastModifiedTime(currentDate);
		admin.setLoginFailedTimes(0);
		if (admin.getUserLoginName() != null)
			admin.setUserLoginName(null);// 避免修改管理员账号

		Integer id = null;
		id = thUserService.updateById(admin, adminRoleOrganizationList);

		JSONObject jo = new JSONObject();
		if (id == 0) {
			log.error("修改用户失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		}
		jo.put("userId", admin.getUserId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	// 修改管理员个人信息
	@RequestMapping(value = "/admin/updateInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updateAdminInfo(ThUser admin, HttpServletRequest request) {

		Date currentDate = new Date();
		admin.setLastModifiedTime(currentDate);
		admin.setLastModifiedTime(currentDate);
		admin.setLoginFailedTimes(0);
		String oldPassword = admin.getUserPassword();
		String newPassword = request.getParameter("newPassword");
		if (StringUtils.isNotBlank(oldPassword)) {
			ThUser tem = new ThUser();
			tem.setUserId(admin.getUserId());
			ThUser old = thUserService.get(tem);
			if (old.getUserPassword().equals(oldPassword)) {
				Integer id = null;
				if (StringUtils.isNotBlank(newPassword)) {
					admin.setUserPassword(newPassword);;
				}
				id = thUserService.updateById(admin);
				JSONObject jo = new JSONObject();
				if (id == 0) {
					log.error("修改管理员失败");
					return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
							SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
				}
				jo.put("userId", admin.getUserId());
				request.getSession().setAttribute("userName", admin.getUserName());
				request.getSession().setAttribute("adminInfo", JSONObject.toJSON(admin).toString());
				request.getSession().setAttribute("adminObject", admin);
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			} else {
				JSONObject jo = new JSONObject();
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "旧密码错误", jo),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			}
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请输入密码！", null),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}
	
	// 获取组织列表
	@RequestMapping("/organization/add")
	@ResponseBody
	public String addOrganization(ThOrganization organization, HttpServletRequest request) {
		// 首先判断组织是否存在
		ThOrganization organizationOld = new ThOrganization();
		organizationOld.setOrganizationName(organization.getOrganizationName());;
		organizationOld = thOrganizationService.get(organizationOld);
		if (organizationOld != null)
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "此组织已存在", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		
		ThOrganization result = thOrganizationService.add(organization);
		JSONObject jo = new JSONObject();
		jo.put("organizationId", result.getOrganizationId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	// 获取组织列表
	@RequestMapping("/organization/getOrganizationList")
	@ResponseBody
	public String getOrganizationList(ThOrganization organization, PageHelper ph, HttpServletRequest request) {
		List<ThOrganization> resultlist = thOrganizationService.getOrganizationList(organization, ph);
		Long totalCount = thOrganizationService.getCountOfOrganization(organization);

		JSONObject jo = new JSONObject();
		jo.put("organizationList", resultlist);
		jo.put("totalCount", totalCount);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	// 获取组织列表
	@RequestMapping("/organization/update")
	@ResponseBody
	public String updateOrganization(ThOrganization organization, HttpServletRequest request) {
		Integer id = thOrganizationService.updateById(organization);

		JSONObject jo = new JSONObject();
		if (id == 0) {
			log.error("修改组织信息失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		}
		jo.put("organizationId", organization.getOrganizationId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}
	
	// 获取组织列表
	@RequestMapping("/organization/delete")
	@ResponseBody
	public String deleteOrganization(ThOrganization organization, HttpServletRequest request) {
		Integer id = thOrganizationService.deleteOrganization(organization);

		JSONObject jo = new JSONObject();
		if (id == 0) {
			log.error("删除组织信息失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		}
		jo.put("organizationId", organization.getOrganizationId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}
	

	/**
	 * 鉴权专用接口，用于左侧鉴权用
	 * @return
	 */
	@RequestMapping("authentication/left")
	@ResponseBody
	public String authenticationLeft(HttpServletRequest request) {
		String menuIdParam = request.getParameter("menuId");
        String accessToken = (String) request.getAttribute("accessToken");
		Integer menuId = null;
		if(StringUtils.isNotBlank(menuIdParam)){
			menuId = Integer.valueOf(menuIdParam);
		}
		ThUser t = new ThUser();
		t.setAccessToken(accessToken);
		ThUser admin = thUserService.get(t);
		String adminId = admin.getUserId();
		List<Integer> organizationIdList = new ArrayList<Integer>();
		organizationIdList = thUserService.getOrganizationIds(adminId, menuId);
		JSONObject jo = new JSONObject();
		jo.put("organizationIdList", organizationIdList);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}	
	
	/**
	 * 鉴权专用接口，用于右侧鉴权用
	 * 
	 * @return
	 */
	@RequestMapping("authentication/action")
	@ResponseBody
	public String authenticationAction(HttpServletRequest request) {
		JSONObject jo = new JSONObject();
		String menuIdParam = request.getParameter("menuId");
		Integer menuId = null;
		if(StringUtils.isNotBlank(menuIdParam)){
			try {
				menuId = Integer.valueOf(menuIdParam);
			} catch (NumberFormatException e) {
				menuId = null;
				e.printStackTrace();
			}
		}
		String organizationIds = request.getParameter("organizationIdList");
		String action = request.getParameter("action");
		String accessToken = (String) request.getAttribute("accessToken");
		ThUser t = new ThUser();
		t.setAccessToken(accessToken);
		ThUser admin = thUserService.get(t);
		String adminId = admin.getUserId();
		List<Integer> organizationIdList = new ArrayList<Integer>();
		if(StringUtils.isNotBlank(organizationIds)){
			organizationIdList = JSON.parseObject(organizationIds, new TypeReference<List<Integer>>(){});
		}
		//票据管理的权限需要特殊处理，前台如果是操作自己的票据传入-1，如果是全部的票据就传-2
		if(organizationIdList != null && organizationIdList.size()==1 && organizationIdList.contains(GlobalConstant.MYSELF_RESOURCES)){
			organizationIdList.add(GlobalConstant.ALL_RESOURCES);
			List<Map<String,Object>> havePerimissions = thUserService.getPermissionByMenuId(adminId, menuId, organizationIdList);
			if(PermissionUtil.getPerimissionResultOfUnion(organizationIdList, action, havePerimissions)){
				jo.put("havePermission", true);
			}else{
				jo.put("havePermission", false);
			}
		}else if(StringUtils.equals(action, "add") && (organizationIdList == null || organizationIdList.isEmpty()) ){
			List<Map<String,Object>> havePerimissions = thUserService.getAddPermissionByMenuId(adminId, menuId);
			if(havePerimissions != null && !havePerimissions.isEmpty() && havePerimissions.size()>0){
				jo.put("havePermission", true);
			}else{
				jo.put("havePermission", false);
			}
		}else{
			List<Map<String,Object>> havePerimissions = thUserService.getPermissionByMenuId(adminId, menuId, organizationIdList);
			if(PermissionUtil.getPerimissionResult(organizationIdList, action, havePerimissions)){
				jo.put("havePermission", true);
			}else{
				jo.put("havePermission", false);
			}
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	
	}
	
	
	
	/* @param args
	* @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
	
	   
	   /*
	    * 1,需求：将键盘录入的数据写入到一个文件中。 
	    * 
	    * 2,需求：将一个文本文件内容显示在控制台上。
	    * 
	    * 3,需求：将一个文件文件中的内容复制到的另一个文件中。
	    */
	   
	   BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	   
	   BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
	   
	   
	   String line = null;
	   
	   while((line=bufr.readLine())!=null){
	       if("over".equals(line))
	           break;
	       
	       bufw.write(line.toUpperCase());
	       bufw.newLine();
	       bufw.flush();
	   }
	   
	   
	}
	
}
