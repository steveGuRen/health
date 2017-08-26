package com.health.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThAdminRoleOrganizationDao;
import com.health.dao.ThRoleDao;
import com.health.dao.ThRoleMenuDao;
import com.health.model.ThRole;
import com.health.model.ThRoleMenu;
import com.health.service.ThRoleService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThRoleServiceImpl implements ThRoleService {

	@Autowired
	ThRoleDao roleDao;
	@Autowired
	ThRoleMenuDao roleMenuDao;
	@Autowired
	ThAdminRoleOrganizationDao  adminRoleOrganizationDao;
	
	@Override
	public List<Map<String, Object>> getRoleList(Map<String, Object> params, PageHelper ph) {
		return roleDao.getRoleList(params, ph);
	}

	@Override
	public List<Map<String, Object>> getRoleListDetail(Map<String, Object> params, PageHelper ph) {
		return roleDao.getRoleListDetail(params, ph);
	}

	@Override
	public List<ThRole> getRoleList(ThRole role, PageHelper ph) {
		return roleDao.getRoleList(role, ph);
	}

	@Override
	public ThRole add(ThRole role) {
		return roleDao.add(role);
	}

	@Override
	public Integer saveRole(ThRole role, List<ThRoleMenu> roleMenuList) {
		ThRole newRole = roleDao.add(role);
		Integer roleId = newRole.getRoleId();
		if(roleId == 0)
			return 0;
		if(roleMenuList !=null && roleMenuList.size() != 0){
			for(ThRoleMenu tem : roleMenuList){
				tem.setRoleId(roleId);
				roleMenuDao.add(tem);
				}	
		}
		
		return roleId;
	}

	@Override
	public ThRole get(ThRole role) {
		return roleDao.get(role);
	}

	@Override
	public Integer updateById(ThRole role, List<ThRoleMenu> roleMenuList) {
		Integer id = null;
		id = roleDao.updateById(role);//id为响应结果的条数
		if(id == 0){
		 	return 0;
		 }
		Integer roleId = role.getRoleId();
		roleMenuDao.deleteByRoleId(roleId);
		for(ThRoleMenu tem : roleMenuList){
			tem.setRoleId(roleId);
			roleMenuDao.add(tem);
			}
		return id;
	}

	@Override
	public Long getCountOfRole(Map<String, Object> params) {
		return roleDao.getCountOfRole(params);
	}

	@Override
	public Integer deleteRole(ThRole role) {
		Integer id = null;
		Integer roleId = role.getRoleId();
		id = roleDao.deleteRole(role);
		roleMenuDao.deleteByRoleId(roleId);
		adminRoleOrganizationDao.deleteByRoleId(roleId);
		return id;
	}

}
