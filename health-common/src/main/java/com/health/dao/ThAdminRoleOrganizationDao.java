package com.health.dao;

import java.io.Serializable;

import com.health.model.ThAdminRoleOrganization;

public interface ThAdminRoleOrganizationDao extends BaseDaoI<ThAdminRoleOrganization> {
	
	/**
	 * 添加管理员与管理组、小区的关系
	 * @param adminOrganizationPremises
	 */
	public Serializable add(ThAdminRoleOrganization adminRolePremises);
	
	/**
	 * 根据管理员Id删除
	 * @param aminId
	 */
	public Integer deleteByAdminId(String userId);
	
	/**
	 * 根据角色Id删除
	 * @param roleId
	 */
	public Integer deleteByRoleId(Integer roleId);

}
