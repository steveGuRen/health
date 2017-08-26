package com.health.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThAdminRoleOrganizationDao;
import com.health.dao.ThUserAddressDao;
import com.health.dao.ThUserDao;
import com.health.model.ThAdminRoleOrganization;
import com.health.model.ThUser;
import com.health.model.ThUserAddress;
import com.health.service.ThUserService;
import com.health.utils.MD5;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThUserServiceImpl implements ThUserService {

	@Autowired
	ThUserDao userDao;
	@Autowired
	ThUserAddressDao userAddressDao;
	@Autowired
	ThAdminRoleOrganizationDao adminRoleOrganizationDao;
	
	/**
	 * 一天的时间，单位为微秒
	 */
	public final static long DATE_TIME = 86400000;
	
	/*
	 * --------------------------------------------------- 登录相关逻辑开始
	 * ---------------------------------------------------
	 */
	@Override
	public String getRandomCode(String adminName) {
		ThUser admin = new ThUser();
		admin.setUserLoginName(adminName);
		String code = UUID.randomUUID().toString();
		ThUser t = userDao.get(admin);
		if (t == null) {
			return code;
		}
		t.setRandomCode(code);
		userDao.updateById(t);
		return code;
	}

	@Override
	public boolean isAdminExist(String adminName) {
		ThUser admin = new ThUser();
		admin.setUserLoginName(adminName);
		ThUser t = userDao.get(admin);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isOutOfLoginTimes(String adminName) {
		ThUser admin = new ThUser();
		admin.setUserLoginName(adminName);;
		ThUser t = userDao.get(admin);
		if (t == null) {
			return true;
		}
		Date lastLoginFailedTime = t.getLastLoginFailedTime();
		if(lastLoginFailedTime == null){
			t.setLastLoginFailedTime(new Date()); // 更新登录时间
			t.setLoginFailedTimes(0);
			userDao.updateById(t);
			return false;
		}
		Date currentTime = new Date();
		long minus = currentTime.getTime() - lastLoginFailedTime.getTime();
		if (minus >= DATE_TIME) {
			t.setLastLoginFailedTime(new Date()); // 超过一天，刷新失败登录时间
			t.setLoginFailedTimes(0);
			userDao.updateById(t);
			return false;
		}
		if (t.getLoginFailedTimes() < 10) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isAuthenticationValid(String adminName, String authentication) {
		ThUser admin = new ThUser();
		admin.setUserLoginName(adminName);
		ThUser t = userDao.get(admin);
		if (t == null || t.getRandomCode() == null) {
			return false;
		} else {
			String randomCode = t.getRandomCode();
			String password = t.getUserPassword();
			String md5Authentication = MD5.getMD5Code(randomCode + password);
			if (md5Authentication.equals(authentication)) {
				return true;
			} else {
				t.setLoginFailedTimes(t.getLoginFailedTimes() + 1);
				t.setLastLoginFailedTime(new Date());
				userDao.updateById(t);
				return false;
			}
		}
	}

	@Override
	public String getAccessToken(String adminName) {
		ThUser admin = new ThUser();
		admin.setUserLoginName(adminName);;
		ThUser t = userDao.get(admin);
		if (t == null) {
			return null;
		} else {
			String accessToken = UUID.randomUUID().toString();
			t.setAccessToken(accessToken);
			t.setRandomCode(UUID.randomUUID().toString());
			t.setLastLoginTime(new Date());
			t.setLoginFailedTimes(0);
			userDao.updateById(t);
			return accessToken;
		}
	}

	@Override
	public void loginOut(String accessToken) {
		ThUser admin = new ThUser();
		admin.setAccessToken(accessToken);
		ThUser t = userDao.get(admin);
		if (t == null) {
			return;
		} else {
			t.setAccessToken(null);
			userDao.updateById(t);
		}
	}

	@Override
	public boolean hasAccessToken(String accessToken) {
		ThUser admin = new ThUser();
		admin.setAccessToken(accessToken);
		ThUser t = userDao.get(admin);
		if(t != null) {
			long minus = new Date().getTime() - t.getLastLoginTime().getTime();
			if(minus > DATE_TIME) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	/*
	 * --------------------------------------------------- 登录相关逻辑结束
	 * ---------------------------------------------------
	 */
	
	@Override
	public ThUser saveUser(ThUser user) {
		return userDao.saveUser(user);
	}

	@Override
	public String saveUserAndAddress(ThUser user, ThUserAddress address) {
		ThUser newUser = userDao.saveUser(user);
		String userId = newUser.getUserId();
		if (userId == null) {
			return null;
		}
		if(address != null){
			address.setUserId(userId);
			address.setCreateTime(new Date());
			address.setUpdateTime(new Date());
			userAddressDao.saveUserAddress(address);
		}
		return userId;
	}
	
	@Override
	public String deleteUser(ThUser user) {
		return userDao.deleteUser(user);
	}

	@Override
	public Integer updateById(ThUser user) {
		return userDao.updateById(user);
	}
	
	@Override
	public Integer updateById(ThUser user, ThUserAddress address) {
		Integer id = null;
		id = userDao.updateById(user);
		if (id == 0) {
			return 0;
		}
		if(address != null && address.getAddressId() != null){
			address.setUpdateTime(new Date());
			userAddressDao.updateAddressById(address);
		}else if(address != null && address.getAddressId() == null){
			address.setCreateTime(new Date());
			userAddressDao.saveUserAddress(address);
		}
		return id;
	}

	@Override
	public ThUser get(ThUser user) {
		return userDao.get(user);
	}

	@Override
	public List<Map<String, Object>> getUserInfo(ThUser user, PageHelper ph) {
		return userDao.getUserInfo(user, ph);
	}	

	@Override
	public Long getCountOfUserList(ThUser user) {
		return userDao.getCountOfUserList(user);
	}

	@Override
	public List<Map<String, Object>> getFollowMeList(ThUser user, PageHelper ph) {
		return userDao.getFollowMeList(user, ph);
	}

	@Override
	public Long getCountOfFollowMeList(ThUser user) {
		return userDao.getCountOfFollowMeList(user);
	}

	@Override
	public List<Map<String, Object>> getMyFollowList(ThUser user, PageHelper ph) {
		return userDao.getMyFollowList(user, ph);
	}

	@Override
	public Long getCountOfMyFollowList(ThUser user) {
		return userDao.getCountOfMyFollowList(user);
	}

	@Override
	public List<Map<String, Object>> getAdminListMap(ThUser admin, PageHelper ph) {
		return userDao.getAdminListMap(admin, ph);
	}

	@Override
	public List<Map<String, Object>> getAdminListDetail(Map<String, Object> params, PageHelper ph) {
		return userDao.getAdminListDetail(params, ph);
	}

	@Override
	public List<ThUser> getAdminList(ThUser admin, PageHelper ph) {
		return userDao.getAdminList(admin, ph);
	}

	@Override
	public Long getAdminListCount(ThUser admin) {
		return userDao.getAdminListCount(admin);
	}

	@Override
	public Long getCountOfAdminList(ThUser admin) {
		return userDao.getCountOfAdminList(admin);
	}

	@Override
	public Integer updateById(ThUser admin, List<ThAdminRoleOrganization> adminRoleOrganizationList) {
		Integer id = null;
		id = userDao.updateById(admin);
		if (id == 0) {
			return 0;
		}
		if(adminRoleOrganizationList != null && adminRoleOrganizationList.size() != 0){
			String userId = admin.getUserId();
			adminRoleOrganizationDao.deleteByAdminId(userId);
			for (ThAdminRoleOrganization tem : adminRoleOrganizationList) {
				tem.setUserId(userId);
				adminRoleOrganizationDao.add(tem);
			}
		}		
		return id;
	}

	@Override
	public String addAdmin(ThUser admin, List<ThAdminRoleOrganization> adminRoleOrganizationList) {
		ThUser adminNew = userDao.saveUser(admin);
		String userId = adminNew.getUserId();
		if (userId == null) {
			return null;
		}
		if(adminRoleOrganizationList != null && adminRoleOrganizationList.size() != 0){
			for (ThAdminRoleOrganization tem : adminRoleOrganizationList) {
				tem.setUserId(userId);;
				adminRoleOrganizationDao.add(tem);
			}
		}
		return userId;
	}

	@Override
	public void deleteAdmin(ThUser admin) {
		String userId = admin.getUserId();
		userDao.deleteUser(admin);
		adminRoleOrganizationDao.deleteByAdminId(userId);		
	}

	@Override
	public List<Map<String, Object>> getPermissionByMenuId(String userId, Integer menuId,
			List<Integer> organizationIds) {
		return userDao.getPermissionByMenuId(userId, menuId, organizationIds);
	}

	@Override
	public List<Map<String, Object>> getAddPermissionByMenuId(String userId, Integer menuId) {
		return userDao.getAddPermissionByMenuId(userId, menuId);
	}

	@Override
	public List<Map<String, Object>> getAdminListByPermission(Integer menuId, String action) {
		return userDao.getAdminListByPermission(menuId, action);
	}

	@Override
	public List<Integer> getOrganizationIds(String adminId, Integer menuId) {
		return userDao.getOrganizationIds(adminId, menuId);
	}

	@Override
	public List<Map<String, Object>> getUnFollowedList(ThUser user, PageHelper ph) {
		return userDao.getUnFollowedList(user, ph);
	}

	@Override
	public Long getCountOfUnFollowedList(ThUser user) {
		return userDao.getCountOfUnFollowedList(user);
	}


}
