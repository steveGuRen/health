package com.health.service;

import java.util.List;
import java.util.Map;

import com.health.model.ThAdminRoleOrganization;
import com.health.model.ThUser;
import com.health.model.ThUserAddress;
import com.health.utils.PageHelper;

public interface ThUserService {
	
	/*
	 * ---------------------------------------------------
	 *  登录相关逻辑
	 * ---------------------------------------------------
	 */
	
	/**
	 * 根据用户名刷新用户的随机码, 若无用户名，直接返回随机码
	 * @param adminName
	 * @return
	 */
	public String getRandomCode(String adminName);
	
	/**
	 * 根据用户名判断用户是否存在
	 * @param adminName
	 * @return 存在返回true, 否则返回false
	 */
	public boolean isAdminExist(String adminName);
	
	/**
	 * 根据用户名失败登录次数是否超过当天的次数，登录次数设定为10次
	 * @param ipAddress
	 * @return
	 */
	public boolean isOutOfLoginTimes(String adminName);
	
	/**
	 * 根据用户名找到对应的随机值， 找到密码的MD5值， 生成（随机码+密码MD5值）的MD5值， 检查是否跟前端的匹配
	 * @param authentication
	 * @return
	 */
	public boolean isAuthenticationValid(String adminName, String authentication);
	
	/**
	 * 根据用户名获得accessToken, 同时刷新最后登录时间， 刷新失败登录次数为0， 刷新随机码, 刷新验证码；使用该方法，说明所有登录信息都正确
	 * @param adminName
	 * @return
	 */
	public String getAccessToken(String adminName);
	
	/**
	 * 根据accessToken，找到对应的用户，对accessToken进行删除，来达到登出目的
	 * @param accessToken
	 */
	public void loginOut(String accessToken);
	
	/*
	 * ---------------------------------------------------
	 * 拦截器相关逻辑
	 * ---------------------------------------------------
	 */
	
	/**
	 * 判断该accessToken是否有效；如果能够查到，并且当前时间与最后一次登录的时间的差小于1天，则为有效，否则无效。
	 * @param accessToken
	 * @return
	 */
	public boolean hasAccessToken(String accessToken);

	public ThUser saveUser(ThUser user) ;
	public String saveUserAndAddress(ThUser user, ThUserAddress address) ;
	
    public String deleteUser(ThUser user) ;
    
    public Integer updateById(ThUser user); 
    
    public Integer updateById(ThUser user, ThUserAddress address);
    
	public ThUser get(ThUser user);	
	
	//普通用户相关	
	public List<Map<String, Object>> getUserInfo(ThUser user, PageHelper ph);//获取用户所有信息，包括地址
	
	public Long getCountOfUserList(ThUser user);
	
	public List<Map<String, Object>> getFollowMeList(ThUser user, PageHelper ph);//获取关注我的用户列表
	
	public Long getCountOfFollowMeList(ThUser user);
	
	public List<Map<String, Object>> getMyFollowList(ThUser user, PageHelper ph);//获取我关注的用户列表
	
	public Long getCountOfMyFollowList(ThUser user);
	
	public List<Map<String, Object>> getUnFollowedList(ThUser user, PageHelper ph);//获取未关注的用户列表
	
	public Long getCountOfUnFollowedList(ThUser user);
	
	//管理员相关	
	/**
	 * 分页查询，返回结果带ThUser, ThRole, ThOrganizationId三张表的字段
	 * 
	 * @param params 查询参列表
	 * @param ph 分页参数
	 * @return
	 */
	public List<Map<String, Object>> getAdminListMap(ThUser admin, PageHelper ph);
	
	public List<Map<String, Object>> getAdminListDetail(Map<String, Object> params, PageHelper ph);
	
	/**
	 * 通过ThUser里有的参数获得Admin列表
	 * @param admin
	 * @param ph
	 * @return
	 */
	public List<ThUser> getAdminList(ThUser admin, PageHelper ph);
	
	/**
	 * 通过getAdminList的字符串，统计总的记录数，用来分页
	 * @param params
	 * @return
	 */
	public Long getAdminListCount(ThUser admin);
	public Long getCountOfAdminList(ThUser admin);
	
	public Integer updateById(ThUser admin, List<ThAdminRoleOrganization> adminRoleOrganizationList);
	public String addAdmin(ThUser admin, List<ThAdminRoleOrganization> adminRoleOrganizationList);

	public void deleteAdmin(ThUser admin) ;
	public List<Integer> getOrganizationIds(String adminId, Integer menuId);
	public List<Map<String,Object>> getPermissionByMenuId(String userId, Integer menuId, List<Integer> organizationIds);
    public List<Map<String, Object>> getAddPermissionByMenuId(String userId, Integer menuId);    
	public List<Map<String, Object>> getAdminListByPermission(Integer menuId, String action);
}
