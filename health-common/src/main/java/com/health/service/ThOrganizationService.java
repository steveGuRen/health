package com.health.service;

import java.util.List;

import com.health.model.ThOrganization;
import com.health.utils.PageHelper;

public interface ThOrganizationService {
	
	/**
	 * 获取组织机构列表
	 * @param organization
	 * @param ph
	 * @return
	 */
	public List<ThOrganization> getOrganizationList(ThOrganization organization,PageHelper ph);

	public Long getCountOfOrganization(ThOrganization organization);
	
	/**
	 * 添加角色
	 * @param role
	 */
	public ThOrganization add(ThOrganization organization);
	
	/** 获取ThOrganization
	 * @param organization
	 * @return
	 */
	public ThOrganization get(ThOrganization organization);
	
	/**
	 * 修改ThOrganization
	 * @param organization
	 * @return
	 */
	public Integer updateById(ThOrganization organization);
	
	public Integer deleteOrganization(ThOrganization organization) ;

}
