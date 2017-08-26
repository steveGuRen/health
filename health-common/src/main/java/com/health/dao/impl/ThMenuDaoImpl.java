package com.health.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThMenuDao;
import com.health.model.ThMenu;
import com.health.utils.PageHelper;

@Repository("ThMenuDaoImpl")
public class ThMenuDaoImpl extends BaseDaoImpl<ThMenu> implements ThMenuDao {

	@Override
	public List<ThMenu> getMenuList(ThMenu menu, PageHelper ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThMenu t ";
		List<ThMenu> menuList = find(hql
				+ whereHql(menu, params) + orderHql(ph), params,
				ph.getPage(), ph.getRows());

		return menuList;
	}

	@Override
	public Long getCountOfMenu(ThMenu menu) {
		String hql = "select count(*) from ThMenu t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return count(hql+whereHql(menu, params), params);
	}
	
	@Override
	public Serializable add(ThMenu menu) {
		return save(menu);
	}

	@Override
	public ThMenu get(ThMenu menu) {
		String hql = " from ThMenu t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThMenu t = get(hql+whereHql(menu, params), params);
		return t;
	}

	@Override
	public Integer updateById(ThMenu menu) {
		if(menu.getMenuId() == null ){
			return null;
		}
		String hql = " update ThMenu t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(menu,params);
		String whereIdHql = " where menuId = :menuId ";
		
		return executeHql(hql + setHql + whereIdHql,params);
	}

	private String whereHql(ThMenu menu, Map<String, Object> params) {
		String whereHql = "";
		if (menu != null) {
			whereHql += " where 1=1 ";
			if(menu.getMenuId() != null){
				whereHql += " and t.menuId = :menuId";
				params.put("menuId", menu.getMenuId());
			}
			if(menu.getTypeId() != null){
				whereHql += " and t.typeId = :typeId";
				params.put("typeId", menu.getTypeId());
			}
			if(menu.getMenuName() != null){
				whereHql += " and t.menuName = :menuName";
				params.put("menuName", menu.getMenuName());
			}
			if(StringUtils.isNotBlank(menu.getCreateUser())){
				whereHql += " and t.createUser = :createUser";
				params.put("createUser", menu.getCreateUser());
			}
			if(StringUtils.isNotBlank(menu.getUpdateUser())){
				whereHql += " and t.updataUser = :updataUser";
				params.put("updateUser", menu.getUpdateUser());
			}
			if(menu.getUrl()!= null){
				whereHql += " and t.url = :url";
				params.put("url", menu.getUrl());
			}			
		}
		return whereHql;
	}	

	private String setHql(ThMenu menu,Map<String, Object> params){
		String setHql = "";
		if (menu != null) {
			setHql += " set";
			if(menu.getMenuId() != null){
				setHql += " t.menuId = :menuId,";
				params.put("menuId", menu.getMenuId());
			}
			if(menu.getMenuName() != null){
				setHql += " t.menuName = :menuName,";
				params.put("menuName", menu.getMenuName());
			}
			if(menu.getCreateUser() != null){
				setHql += " t.createUser = :createUser,";
				params.put("createUser", menu.getCreateUser());
			}
			if(menu.getUpdateUser() != null){
				setHql += " t.updataUser = :updateUser,";
				params.put("updateUser", menu.getUpdateUser());
			}
			if(menu.getUrl() != null){
				setHql += " t.url = :url,";
				params.put("url", menu.getUrl());
			}
		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}

}
