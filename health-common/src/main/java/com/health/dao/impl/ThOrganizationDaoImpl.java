package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.health.dao.ThOrganizationDao;
import com.health.model.ThOrganization;
import com.health.model.ThRole;
import com.health.utils.PageHelper;

@Repository("ThOrganizationDaoImpl")
public class ThOrganizationDaoImpl extends BaseDaoImpl<ThOrganization> implements ThOrganizationDao{

	@Override
	public List<ThOrganization> getOrganizationList(ThOrganization organization, PageHelper ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThOrganization t ";
		List<ThOrganization> organizationList = find(hql
				+ whereHql(organization, params) + orderHql(ph), params,
				ph.getPage(), ph.getRows());

		return organizationList;
	}

	@Override
	public Long getCountOfOrganization(ThOrganization organization) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
//		String hql1 = "select * from ThOrganization t "+ whereHql(organization, whereMap) ;
		String hql = "SELECT count(*) from ThOrganization t " + whereHql(organization, whereMap);
		return (Long)count(hql,whereMap);
	}

	@Override
	public ThOrganization add(ThOrganization organization) {
		save(organization);
		return organization;
	}

	@Override
	public ThOrganization get(ThOrganization organization) {
		String hql = " from ThOrganization t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThOrganization t = get(hql+whereHql(organization, params), params);
		return t;
	}

	@Override
	public Integer updateById(ThOrganization organization) {
		if(organization.getOrganizationId() == null ){
			return null;
		}
		String hql = " update ThOrganization t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(organization,params);
		String whereIdHql = " where t.organizationId = :organizationId ";
		
		return executeHql(hql + setHql + whereIdHql, params);
	}

	@Override
	public Integer deleteOrganization(ThOrganization organization) {
		Integer organizationId = organization.getOrganizationId();
		String hql = " delete ThOrganization t where t.organizationId = :organizationId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("organizationId", organizationId);
		return q.executeUpdate();
	}
	
	private String whereHql(ThOrganization organization, Map<String, Object> params) {
		String whereHql = "";
		if (organization != null) {
			whereHql += " where 1=1 ";
			if(organization.getOrganizationId() != null){
				whereHql += " and t.organizationId = :organizationId";
				params.put("organizationId", organization.getOrganizationId());
			}
			if(organization.getOrganizationName() != null){
				whereHql += " and t.organizationName = :organizationName";
				params.put("organizationName", organization.getOrganizationName());
			}
			if(StringUtils.isNotBlank(organization.getOrganizationPosition())){
				whereHql += " and t.organizationPosition = :organizationPosition";
				params.put("organizationPosition", organization.getOrganizationPosition());
			}
			if(StringUtils.isNotBlank(organization.getType())){
				whereHql += " and t.type = :type";
				params.put("type", organization.getType());
			}
			if(StringUtils.isNotBlank(organization.getTel())){
				whereHql += " and t.tel = :tel";
				params.put("tel", organization.getTel());
			}
			if(StringUtils.isNotBlank(organization.getFax())){
				whereHql += " and t.fax = :fax";
				params.put("fax", organization.getFax());
			}
			if(StringUtils.isNotBlank(organization.getEmail())){
				whereHql += " and t.email = :email";
				params.put("email", organization.getEmail());
			}
			if(StringUtils.isNotBlank(organization.getWeChat())){
				whereHql += " and t.weChat = :weChat";
				params.put("weChat", organization.getWeChat());
			}
			if(StringUtils.isNotBlank(organization.getQqNum())){
				whereHql += " and t.qqNum = :qqNum";
				params.put("qqNum", organization.getQqNum());
			}
			if(StringUtils.isNotBlank(organization.getOrganizationLogo())){
				whereHql += " and t.organizationLogo = :organizationLogo";
				params.put("organizationLogo", organization.getOrganizationLogo());
			}
		}
		return whereHql;
	}

	private String setHql(ThOrganization organization,Map<String, Object> params){
		String setHql = "";
		if (organization != null) {
			setHql += " set";
			if(organization.getOrganizationId() != null){
				setHql += " t.organizationId = :organizationId,";
				params.put("organizationId", organization.getOrganizationId());
			}
			if(organization.getOrganizationName() != null){
				setHql += " t.organizationName = :organizationName,";
				params.put("organizationName", organization.getOrganizationName());
			}
			if(StringUtils.isNotBlank(organization.getOrganizationPosition())){
				setHql += " t.organizationPosition = :organizationPosition,";
				params.put("organizationPosition", organization.getOrganizationPosition());
			}
			if(StringUtils.isNotBlank(organization.getType())){
				setHql += " t.type = :type,";
				params.put("type", organization.getType());
			}
			if(StringUtils.isNotBlank(organization.getTel())){
				setHql += " t.tel = :tel,";
				params.put("tel", organization.getTel());
			}
			if(StringUtils.isNotBlank(organization.getFax())){
				setHql += " t.fax = :fax,";
				params.put("fax", organization.getFax());
			}
			if(StringUtils.isNotBlank(organization.getEmail())){
				setHql += " t.email = :email,";
				params.put("email", organization.getEmail());
			}
			if(StringUtils.isNotBlank(organization.getWeChat())){
				setHql += " t.weChat = :weChat,";
				params.put("weChat", organization.getWeChat());
			}
			if(StringUtils.isNotBlank(organization.getQqNum())){
				setHql += " t.qqNum = :qqNum,";
				params.put("qqNum", organization.getQqNum());
			}
			if(StringUtils.isNotBlank(organization.getOrganizationLogo())){
				setHql += " t.organizationLogo = :organizationLogo,";
				params.put("organizationLogo", organization.getOrganizationLogo());
			}
		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}

}
