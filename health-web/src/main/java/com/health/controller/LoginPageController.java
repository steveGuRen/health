package com.health.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThUser;
import com.health.service.ThUserService;
import com.health.utils.CreateImageCode;
import com.health.utils.Return2AndriodFormat;
@Controller
public class LoginPageController {
	
	/**
	 * web端登录页面URL
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String loginSuccessDefaultPage(Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) {
		model.put("contextPath", contextPath);
		response.setHeader("redirectUrl", "/login");
		return "/jsp/login";
	}	
	
	/**
	 * 获得验证码
	 * 
	 * @param adminName
	 * @return
	 */	
	@RequestMapping("/adminLogin/identifycode/image")
	@ResponseBody
	public void checkCode(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException  {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        
        CreateImageCode vCode = new CreateImageCode(100,30,4,5);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        
	}

	/**
	 * 获得随机码
	 * 
	 * @param adminName
	 * @return
	 */
	@RequestMapping(value = "/adminLogin/getRandomCode", method = RequestMethod.GET)
	@ResponseBody
	public String getRandomCode(String adminName) {
		log.info("GetRandomCode interface is visited. AdminName is " + adminName);
		String randomCode = userService.getRandomCode(adminName);
		JSONObject data = new JSONObject();
		data.put("randomCode", randomCode);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", data),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 登录接口
	 * 
	 * @param adminName
	 * @param authentication
	 *            (随机码+用户密码MD5)的MD5值
	 * @return
	 */
	@RequestMapping(value = "/adminLogin/admin-login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String adminName, String authentication, String code, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("code");
		if(code==null || sessionCode==null || !code.trim().equals(sessionCode.trim())){
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(104, "验证码错误！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		if (!userService.isAdminExist(adminName)) {
			log.info("Logining is failed. The adminName:" + adminName + " is not exist. ");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(101, "登录失败，用户名或密码错误！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		if (userService.isOutOfLoginTimes(adminName)) {
			log.info("Logining is failed. The adminName:" + adminName + " is out of login times. ");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(102, "登录失败，登录失败次数过多！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		if (userService.isAuthenticationValid(adminName, authentication)) {
			log.info("Logining is success. The adminName is:" + adminName + " and the authentication is "
					+ authentication);
			JSONObject data = new JSONObject();
			String accessToken = userService.getAccessToken(adminName);
			data.put("accessToken", accessToken);
			//将accessToken保存到session中
			request.getSession().setAttribute("accessToken", accessToken);
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(100, "登录成功！", data),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		else {
			log.info("Logining is failed. The adminName:" + adminName + " and the authentication:" + authentication
					+ "is not correct. ");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(101, "登录失败，用户名或密码错误！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}

	}

	/**
	 * WEB GET 方法登录URL
	 * @param accessToken
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adminLogin/loginProcess", method = RequestMethod.GET)
	public String  adminLogin(String accessToken, HttpServletRequest request, Map<String, Object> model){

		HttpServletRequest httpServletRequest = (HttpServletRequest)request;	
		boolean tokenIsValid = userService.hasAccessToken(accessToken);
		if(tokenIsValid == true) {
			ThUser t = new ThUser();
			t.setAccessToken(accessToken);
			ThUser admin = userService.get(t);
			
			if(admin == null) {
				log.info("In web login process, can't not find admin by accessToken :" + accessToken);
				return "redirect:" + "/web/errorPage";
			}
			request.getSession().setAttribute("accessToken", accessToken);
			request.getSession().setAttribute("userLoginName", admin.getUserLoginName());
			request.getSession().setAttribute("userId", admin.getUserId());
			request.getSession().setAttribute("userName", admin.getUserName());
			request.getSession().setAttribute("adminInfo", JSONObject.toJSON(admin).toString());
			request.getSession().setAttribute("adminObject", admin);
			return "redirect:/index";
		}
		else {
			model.put("message", "你无权访问该网页");
			return "/error";
		}
		
	}
	
	/**
	 * WEB 主页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String indexPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		String accessToken = (String) request.getSession().getAttribute("accessToken");
		if(accessToken == null){
			return "redirect:/login";
		}
		String adminName = (String) request.getSession().getAttribute("adminName");
		String adminId = (String) request.getSession().getAttribute("adminId");
		String realName = (String) request.getSession().getAttribute("realName");
		String info = (String) request.getSession().getAttribute("adminInfo");
		ThUser adminInfo = (ThUser) request.getSession().getAttribute("adminObject");
		model.put("contextPath", contextPath);
		model.put("accessToken", accessToken);
		/*在HTML模板上标志accessToken*/
		model.put("_csrf.token", accessToken);
		/*在HTML上标志AdminId*/
		model.put("adminName", adminName);
		model.put("adminId", adminId);
		model.put("realName", realName);
		model.put("adminInfo", info);
		model.put("adminObject", adminInfo);
		return "/index";
	}

	/**
	 * 无权限访问， 返回JSON 错误
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/web/error")
	public void errorJSON(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(401);
		Writer w = response.getWriter();
		String str = JSONObject.toJSONString(Return2AndriodFormat.getResult(400, "令牌失效，无权访问！", null),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat).toString();
		w.write(str);
		w.flush();
		w.close();
	}
	
	/**
	 * WEB 无权限网页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/web/errorPage")
	public String errorPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws IOException {
		model.put("message", "你无权访问该网页");
		return "/error";
	}
	
	/**
	 * WEB 登出接口
	 * @param request
	 * @param response
	 * @param accessToken
	 */
	@RequestMapping(value = "/admin/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response, String accessToken) {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		request.getSession().removeAttribute("accessToken");
		request.getSession().removeAttribute("adminName");
		request.getSession().removeAttribute("adminId");
		request.getSession().removeAttribute("realName");
		request.getSession().removeAttribute("adminInfo");
		Writer w;
		try {
			userService.loginOut(accessToken);
			w = response.getWriter();
			String str = JSONObject.toJSONString(Return2AndriodFormat.getResult(103, "注销成功！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat).toString();
			w.write(str);
			w.flush();
			w.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 用来设置页面CSS,JS等的路径，以跟部署时项目URL路径一样。
	 */
	@Value("${server.context-path}")
	String contextPath;
	
	@Autowired
	private ThUserService userService;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
}
