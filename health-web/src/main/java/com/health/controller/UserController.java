package com.health.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.common.SendMessage;
import com.health.model.ThNotification;
import com.health.model.ThUser;
import com.health.model.ThUserAddress;
import com.health.model.ThUserFollow;
import com.health.service.ThNotificationService;
import com.health.service.ThUserAddressService;
import com.health.service.ThUserFollowService;
import com.health.service.ThUserService;
import com.health.utils.CodeBean;
import com.health.utils.GlobalConstant;
import com.health.utils.PageHelper;
import com.health.utils.RSAUtils;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ThUserService thUserService;

	@Autowired
	ThUserFollowService thUserFollowService;

	@Autowired
	ThUserAddressService thUserAddressService;

	@Autowired
	ThNotificationService notificationService;

	@RequestMapping(value = "/register/isUserExist", method = RequestMethod.POST)
	@ResponseBody
	public String isUserExist(ThUser user, HttpServletRequest request) {
		try {
			byte[] decodedData = RSAUtils.decryptByPrivateKey(Base64.getDecoder().decode(user.getUserLoginName()),
					privateKey);// 对手机号解密
			String decodeStr = new String(decodedData);
			// 首先判断用户是否存在
			ThUser userOld = new ThUser();
			userOld.setUserLoginName(decodeStr);
			userOld = thUserService.get(userOld);
			if (userOld != null)
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "此手机号已注册", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "此手机号未注册", null),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**	 * 发送手机验证码
	 * @param telephone 手机号码
	 */
	@RequestMapping(value="/register/sendms")
	@ResponseBody
	public String setMessage(String telephone){
		try {
			byte[] decodedData = RSAUtils.decryptByPrivateKey(Base64.getDecoder().decode(telephone), privateKey);//对手机号解密
			String decodeStr = new String(decodedData);
			//判断发送短信的次数是否超限
			if(SendMessage.CODE_NUMBER.containsKey(decodeStr)){
				int number = SendMessage.CODE_NUMBER.get(decodeStr);
				if(number >= GlobalConstant.CODE_MAX_NUMBER){
					return Return2AndriodFormat.getResult(ResponseConstant.NUMBER_OUT,"短信下发超过当日发送限制",null).toString();
				}
				number=number+1;
				SendMessage.CODE_NUMBER.put(decodeStr, number);
			}else{
				SendMessage.CODE_NUMBER.put(decodeStr, 1);
			}
			HashMap<String, Object> result = SendMessage.sendCode(decodeStr);
			String result2string=result.toString();
			
			log.info("验证码是：" + SendMessage.CODE + " telephone is " + decodeStr);
			CodeBean codebean = new CodeBean();
			codebean.setCode(SendMessage.CODE);
			codebean.setCreatetime(System.currentTimeMillis());
			SendMessage.CODEMAP.put(decodeStr, codebean);		
			
			if(null==result2string || false=="000000".equals(result.get("statusCode"))){
				log.error("telephone is " + decodeStr + ".发送验证码失败！"+"错误码=" + result.get("statusCode") + " 错误信息= "+result.get("statusMsg"));
				return Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"error",null).toString();
			}
			log.info("发送验证码成功！" + "telephone is " + decodeStr);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK,"ok", null).toString();
	}

	// 注册的短信验证接口
	@RequestMapping(value = "/register/codeverification")
	@ResponseBody
	public String codeVerification(String telephone, String getcode) {
		long currenttime = System.currentTimeMillis();
		if (SendMessage.CODEMAP.containsKey(telephone)) {
			CodeBean cb = SendMessage.CODEMAP.get(telephone);
			// 判断是否超时
			if (currenttime - cb.getCreatetime() > GlobalConstant.MAXIMUM_TIME) {
				log.error("验证码超时！" + " telephone is " + telephone + ", getcode is " + getcode);
				return Return2AndriodFormat.getResult(ResponseConstant.CODE_INVALID, "验证码失效", null).toString();
			}
			// 验证成功删除该条记录
			if (cb.getCode().equals(getcode)) {
				SendMessage.CODEMAP.remove(telephone);

				log.info("验证码验证成功！" + " telephone is " + telephone + ",getcode is " + getcode);
				return Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "ok", null).toString();
			}
		}
		log.error("验证码输入错误！");
		return Return2AndriodFormat.getResult(ResponseConstant.CODE_FAILED, "验证码输入错误", null).toString();
	}

	@RequestMapping(value = "/register/addUser", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(ThUser user, ThUserAddress address, HttpServletRequest request) {
		// 首先判断用户是否存在
		ThUser userOld = new ThUser();
		userOld.setUserLoginName(user.getUserLoginName());
		userOld = thUserService.get(userOld);
		if (userOld != null)
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "此手机号已注册", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		Date currentDate = new Date();
		user.setCreatedTime(currentDate);
		user.setLastModifiedTime(currentDate);
		user.setLoginFailedTimes(0);
		user.setLastLoginFailedTime(currentDate);
		user.setLastLoginTime(currentDate);
		String userId = thUserService.saveUserAndAddress(user, address);

		JSONObject jo = new JSONObject();
		jo.put("userId", userId);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 登录接口
	 * 
	 * @param userLoginName
	 * @param authentication
	 *            (随机码+用户密码MD5)的MD5值
	 * @return
	 */
	@RequestMapping(value = "/userLogin/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String userLoginName, String authentication, HttpServletRequest request) {

		if (!thUserService.isAdminExist(userLoginName)) {
			log.info("Logining is failed. The userLoginName:" + userLoginName + " is not exist. ");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(101, "登录失败，用户名或密码错误！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		if (thUserService.isOutOfLoginTimes(userLoginName)) {
			log.info("Logining is failed. The adminName:" + userLoginName + " is out of login times. ");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(102, "登录失败，登录失败次数过多！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		if (thUserService.isAuthenticationValid(userLoginName, authentication)) {
			log.info("Logining is success. The userLoginName is:" + userLoginName + " and the authentication is "
					+ authentication);
			JSONObject data = new JSONObject();
			String accessToken = thUserService.getAccessToken(userLoginName);
			ThUser user = new ThUser();
			user.setUserLoginName(userLoginName);
			user = thUserService.get(user);
			String userId = user.getUserId();
			data.put("accessToken", accessToken);
			data.put("userId", userId);
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(100, "登录成功！", data),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		} else {
			log.info("Logining is failed. The userLoginName:" + userLoginName + " and the authentication:"
					+ authentication + "is not correct. ");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(101, "登录失败，用户名或密码错误！", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}

	}

	/**
	 * 忘记密码接口
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/register/updatePwd", method = RequestMethod.POST)
	@ResponseBody
	public String updatePassword(ThUser user, HttpServletRequest request) {
		ThUser t = new ThUser();
		t.setUserLoginName(user.getUserLoginName());
		t = thUserService.get(t);

		Date currentDate = new Date();
		user.setLastModifiedTime(currentDate);
		user.setLoginFailedTimes(0);
		user.setUserId(t.getUserId());
		if (user.getUserLoginName() != null)
			user.setUserLoginName(null);// 避免修改管理员账号

		Integer id = null;
		id = thUserService.updateById(user);

		JSONObject jo = new JSONObject();
		if (id == 0) {
			log.error("修改用户失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		}
		jo.put("userId", user.getUserId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	@RequestMapping(value = "/user/addAddress", method = RequestMethod.POST)
	@ResponseBody
	public String addAddress(ThUserAddress userAddress, HttpServletRequest request) {

		Date currentDate = new Date();
		userAddress.setCreateTime(currentDate);
		userAddress.setCreateUser(userAddress.getUserId());
		ThUserAddress userAddressNew = thUserAddressService.saveUserAddress(userAddress);

		JSONObject jo = new JSONObject();
		jo.put("addressId", userAddressNew.getAddressId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 获得所有用户列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getUserList", method = RequestMethod.POST)
	public String getUserList(ThUser user, PageHelper ph, HttpServletRequest request) {

		String userTels = request.getParameter("userTelList");
		List<String> userTelList = new ArrayList<String>();
		if (StringUtils.isNotBlank(userTels)) {
			userTelList = JSON.parseObject(userTels, new TypeReference<List<String>>() {
			});
		}
		user.setUserTels(userTelList);
		List<ThUser> resultlist = thUserService.getAdminList(user, ph);
		Long totalCount = (Long) thUserService.getCountOfAdminList(user);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("userList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 获得用户基本信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getUserInfo", method = RequestMethod.POST)
	public String getUserInfo(ThUser user, PageHelper ph, HttpServletRequest request) {
		List<Map<String, Object>> resultlist = thUserService.getUserInfo(user, ph);
		JSONObject jo = new JSONObject();
		jo.put("userList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 更新用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/user/updateUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updateAdmin(ThUser user, ThUserAddress address, HttpServletRequest request) {
		Date currentDate = new Date();
		user.setLastModifiedTime(currentDate);
		user.setLoginFailedTimes(0);
		if (user.getUserLoginName() != null)
			user.setUserLoginName(null);// 避免修改管理员账号

		String oldPassword = user.getUserPassword();
		String newPassword = request.getParameter("newPassword");
		if (StringUtils.isNotBlank(oldPassword)) {// 修改密码的时候，判断密码是否正确
			ThUser tem = new ThUser();
			tem.setUserId(user.getUserId());
			ThUser old = thUserService.get(tem);
			if (old.getUserPassword().equals(oldPassword)) {
				Integer id = null;
				if (StringUtils.isNotBlank(newPassword)) {
					user.setUserPassword(newPassword);
					;
				}
				id = thUserService.updateById(user);
				JSONObject jo = new JSONObject();
				if (id == 0) {
					log.error("修改用户密码失败");
					return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
							SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
				}
				jo.put("userId", user.getUserId());
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			} else {
				JSONObject jo = new JSONObject();
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "旧密码错误", jo),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			}
		} else {// 修改除密码外的其他用户信息
			Integer id = null;
			id = thUserService.updateById(user, address);

			JSONObject jo = new JSONObject();
			if (id == 0) {
				log.error("修改用户失败");
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

			}
			jo.put("userId", user.getUserId());
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}

	}

	/**
	 * 获得所有关注我的用户
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/getMyFollowers", method = RequestMethod.POST)
	public String getMyFollowers(ThUser user, PageHelper ph, HttpServletRequest request) {
		user.setSearchParams(request.getParameter("searchParam"));

		List<Map<String, Object>> resultlist = thUserService.getFollowMeList(user, ph);
		Long totalCount = (Long) thUserService.getCountOfFollowMeList(user);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("userList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 获得所有我关注的用户
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/followList", method = RequestMethod.POST)
	public String followList(ThUser user, PageHelper ph, HttpServletRequest request) {
		user.setSearchParams(request.getParameter("searchParam"));

		List<Map<String, Object>> resultlist = thUserService.getMyFollowList(user, ph);
		Long totalCount = (Long) thUserService.getCountOfMyFollowList(user);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("userList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 获得我未关注的用户
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/unfollowedList", method = RequestMethod.POST)
	public String unfollowedList(ThUser user, PageHelper ph, HttpServletRequest request) {
		user.setSearchParams(request.getParameter("searchParam"));

		List<Map<String, Object>> resultlist = thUserService.getUnFollowedList(user, ph);
		Long totalCount = (Long) thUserService.getCountOfUnFollowedList(user);

		JSONObject jo = new JSONObject();
		jo.put("totalCount", totalCount);
		jo.put("userList", resultlist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

	}

	/**
	 * 更新关注信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/user/editRemark", method = RequestMethod.POST)
	@ResponseBody
	public String editRemark(ThUserFollow userFollow, HttpServletRequest request) {
		userFollow.setUpdateTime(new Date());
		Integer id = null;
		id = thUserFollowService.updateFollowById(userFollow);

		JSONObject jo = new JSONObject();
		if (id == 0) {
			log.error("修改信息失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "找不到对应项，请检查参数是否正确！", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		}
		jo.put("followId", userFollow.getFollowId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	// 请求关注
	@RequestMapping(value = "/user/followApply", method = RequestMethod.POST)
	@ResponseBody
	public String followApply(ThUserFollow userFollow, HttpServletRequest request) {

		// 首先判断是否已关注用户，若已关注则返回已关注，若已请求关注则返回已请求关注，若未关注则添加关注并发送请求
		ThUserFollow userFollowOld = new ThUserFollow();
		userFollowOld.setUserId(userFollow.getUserId());
		userFollowOld.setFollowUserId(userFollow.getFollowUserId());
		userFollowOld = thUserFollowService.get(userFollowOld);

		ThUserFollow userFollowNew = new ThUserFollow();
		JSONObject jo = new JSONObject();

		ThNotification item = new ThNotification();
		item.setSummary("请求关注好友");
		item.setTitle("请求添加关注");
		item.setContentType("1");
		item.setWeight(1);
		item.setActiveTime(60);
		item.setUserId(userFollow.getFollowUserId());
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser(userFollow.getUserId());
		item.setUpdateUser(userFollow.getUserId());
		item.setType("关注");

		if (userFollowOld != null) {
			if (userFollowOld.getFlag() == 1)
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "已向该用户发送请求", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			else if (userFollowOld.getFlag() == 2)
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "已关注该用户", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			else if (userFollowOld.getFlag() == 0) {
				userFollowOld.setIsMutualFollowed(0);// 互相关注置为否
				userFollowOld.setFlag(1);
				userFollowOld.setUpdateTime(new Date());
				userFollowOld.setUpdateUser(userFollow.getUserId());
				Integer id = thUserFollowService.updateFollowById(userFollowOld);// 更新关注信息
				if (id == 0) {
					return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "失败", null),
							SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
				} else {
					notificationService.save(item);// 保存消息通知记录
					jo.put("followId", userFollowOld.getFollowId());
					return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
							SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
				}
			}

		} else {
			Date currentDate = new Date();
			userFollow.setCreateTime(currentDate);
			userFollow.setCreateUser(userFollow.getUserId());
			userFollow.setUpdateTime(currentDate);
			userFollow.setUpdateUser(userFollow.getUserId());
			userFollow.setFlag(1);// 将关联关系置为请求状态
			userFollow.setIsMutualFollowed(0);// 互相关注置为否

			userFollowNew = thUserFollowService.saveUserFollow(userFollow);// 保存关注信息
			notificationService.save(item);// 添加关注消息

			jo.put("followId", userFollowNew.getFollowId());
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "失败", null),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	// 同意关注
	@RequestMapping(value = "/user/permitFollow", method = RequestMethod.POST)
	@ResponseBody
	public String permitFollow(ThUserFollow userFollow, HttpServletRequest request) {
		// 首先判断关注请求消息是否存在
		ThUserFollow userFollowOld = new ThUserFollow();
		userFollowOld.setUserId(userFollow.getUserId());
		userFollowOld.setFollowUserId(userFollow.getFollowUserId());
		userFollowOld.setFlag(1);
		userFollowOld = thUserFollowService.get(userFollowOld);
		if (userFollowOld == null)
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "不存在该关注请求", null),
					SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);

		Date currentDate = new Date();
		userFollow.setUpdateTime(currentDate);
		userFollow.setUpdateUser(userFollow.getUserId());
		userFollow.setFlag(2);// 将关联关系置为已关注状态

		// 判断是否互相关注
		ThUserFollow t = new ThUserFollow();
		t.setUserId(userFollow.getFollowUserId());
		t.setFollowUserId(userFollow.getUserId());
		t.setFlag(2);
		t = thUserFollowService.get(t);
		if (t != null) {
			ThUserFollow tmp = new ThUserFollow();
			tmp.setFollowId(t.getFollowId());
			tmp.setIsMutualFollowed(1);
			Integer i = thUserFollowService.updateFollowById(tmp);// 若互相关注则更新相关记录的是否互相关注字段值
			if (i != 0) {
				userFollow.setIsMutualFollowed(1);
			} else {
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(201, "操作失败", null),
						SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
			}

		} else {
			userFollow.setIsMutualFollowed(0);
		}

		Integer id = thUserFollowService.updateFollowById(userFollow);// 更新关注信息

		if (id != 0) {

			ThNotification item = new ThNotification();
			item.setSummary("好友请求已同意");
			item.setTitle("添加关注请求已同意");
			item.setContentType("1");
			item.setWeight(1);
			item.setActiveTime(60);
			item.setUserId(userFollow.getFollowUserId());
			item.setCreateTime(new Date());
			item.setUpdateTime(new Date());
			item.setCreateUser(userFollow.getUserId());
			item.setUpdateUser(userFollow.getUserId());
			item.setType("关注");
			notificationService.save(item);
		}

		JSONObject jo = new JSONObject();
		jo.put("followId", userFollow.getFollowId());
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "成功", jo),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * app 登出接口
	 * 
	 * @param request
	 * @param response
	 * @param accessToken
	 */
	@RequestMapping(value = "/user/logout")
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response, String accessToken) {

		thUserService.loginOut(accessToken);

		return JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "退出成功！", null),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat).toString();

	}

	@Value("${privateKey}")
	String privateKey;

}
