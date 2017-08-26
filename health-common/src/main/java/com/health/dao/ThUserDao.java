package com.health.dao;

import java.util.List;
import java.util.Map;

import com.health.model.ThUser;
import com.health.utils.PageHelper;

public interface ThUserDao extends BaseDaoI<ThUser> {

	
	public ThUser saveUser(ThUser user) ;
	
    public String deleteUser(ThUser user) ;
    
    public Integer updateById(ThUser user); 
    
	public ThUser get(ThUser user);	
	
	//用户相关接口
	public List<Map<String, Object>> getUserInfo(ThUser user, PageHelper ph);//获取用户所有信息，包括地址
	
	public Long getCountOfUserList(ThUser user);
	
	public List<Map<String, Object>> getFollowMeList(ThUser user, PageHelper ph);//获取关注我的用户列表
	
	public Long getCountOfFollowMeList(ThUser user);
	
	public List<Map<String, Object>> getMyFollowList(ThUser user, PageHelper ph);//获取我关注的用户列表
	
	public Long getCountOfMyFollowList(ThUser user);

	public List<Map<String, Object>> getUnFollowedList(ThUser user, PageHelper ph);//获取未关注的用户列表
	
	public Long getCountOfUnFollowedList(ThUser user);
	
	//管理员相关接口
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
	 * 通过FnAdmin里有的参数获得Admin列表
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
	
	public List<Integer> getOrganizationIds(String adminId, Integer menuId);
	public List<Map<String,Object>> getPermissionByMenuId(String userId, Integer menuId, List<Integer> organizationIds);
    public List<Map<String, Object>> getAddPermissionByMenuId(String userId, Integer menuId);    
	public List<Map<String, Object>> getAdminListByPermission(Integer menuId, String action);
	       
}
