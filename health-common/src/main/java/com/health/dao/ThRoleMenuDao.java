package com.health.dao;

import java.io.Serializable;

import com.health.model.ThRoleMenu;

public interface ThRoleMenuDao extends BaseDaoI<ThRoleMenu> {
	
	/**
	 * 添加角色与管理员的关系
	 * @param roleMenu
	 */
	public Serializable add(ThRoleMenu roleMenu);
	
	/**
	 * 删除
	 * @param roleId
	 */
	public Integer deleteByRoleId(Integer roleId);

}
