package com.health.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.health.dao.ThRoleMenuDao;
import com.health.model.ThRoleMenu;

@Repository("ThRoleMenuDaoImpl")
public class ThRoleMenuDaoImpl extends BaseDaoImpl<ThRoleMenu> implements ThRoleMenuDao {

	@Override
	public Serializable add(ThRoleMenu roleMenu) {
		return save(roleMenu);
	}

	@Override
	public Integer deleteByRoleId(Integer roleId) {
		String hql = " delete ThRoleMenu t where t.roleId = :roleId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("roleId", roleId);
		return q.executeUpdate();
	}


}
