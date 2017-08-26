package com.health.service;

import java.io.Serializable;
import java.util.List;

import com.health.model.ThMenu;
import com.health.utils.PageHelper;

public interface ThMenuService {
	/**
	 * 获取菜单列表
	 * @param menu
	 * @param ph
	 * @return
	 */
	public List<ThMenu> getMenuList(ThMenu menu,PageHelper ph);
	
	/**
	 * 添加菜单
	 * @param menu
	 */
	public Serializable add(ThMenu menu);
	
	/** 获取FnMenu
	 * @param menu
	 * @return
	 */
	public ThMenu get(ThMenu menu);
	
	/**
	 * 修改FnMenu
	 * @param menu
	 * @return
	 */
	public Integer updateById(ThMenu menu);
	
	
	public Long getCountOfMenu(ThMenu menu);

}
