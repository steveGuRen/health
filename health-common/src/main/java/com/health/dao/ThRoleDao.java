package com.health.dao;

import java.util.List;
import java.util.Map;

import com.health.model.ThRole;
import com.health.utils.PageHelper;

public interface ThRoleDao extends BaseDaoI<ThRole> {

	/**
	 * 分页查询，返回结果带ThRole, ThRoleMenu, ThMenu三张表的字段
	 * 
	 * @param params 查询参列表
	 * @param ph 分页参数
	 * @return
	 */
	public List<Map<String, Object>> getRoleList(Map<String, Object> params, PageHelper ph);
	public List<Map<String, Object>> getRoleListDetail(Map<String, Object> params, PageHelper ph);
	
	/**
	 * 获取角色列表
	 * @param role
	 * @param ph
	 * @return
	 */
	public List<ThRole> getRoleList(ThRole role,PageHelper ph);
	
	/**
	 * 添加角色
	 * @param role
	 */
	public ThRole add(ThRole role);
	
	/** 获取FnRole
	 * @param role
	 * @return
	 */
	public ThRole get(ThRole role);
	
	/**
	 * 修改TbRole
	 * @param role
	 * @return
	 */
	public Integer updateById(ThRole role);
	
	public Long getCountOfRole(Map<String, Object> params);
	public Integer deleteRole(ThRole role) ;
}
