package com.health.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.health.dao.ThAdminRoleOrganizationDao;
import com.health.model.ThAdminRoleOrganization;

@Repository("ThAdminRoleOrganizationDaoImpl")
public class ThAdminRoleOrganizationDaoImpl extends BaseDaoImpl<ThAdminRoleOrganization> implements ThAdminRoleOrganizationDao {

	@Override
	public Serializable add(ThAdminRoleOrganization adminRoleOrganization) {
		return save(adminRoleOrganization);
	}

	@Override
	public Integer deleteByAdminId(String userId) {
		String hql = " delete ThAdminRoleOrganization t where t.userId = :userId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("userId", userId);
		return q.executeUpdate();
	}

	@Override
	public Integer deleteByRoleId(Integer roleId) {
		String hql = " delete ThAdminRoleOrganization t where t.roleId = :roleId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("roleId", roleId);
		return q.executeUpdate();
	}

	
}
