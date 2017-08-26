package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThQuotaDao;
import com.health.model.ThQuota;
import com.health.utils.PageHelper;

@Repository
public class ThQuotaDaoImpl extends BaseDaoImpl<ThQuota> implements ThQuotaDao{

	@Override
	public List<Map<String, Object>> getQuotaNameList(ThQuota quota, PageHelper ph) {
		// TODO Auto-generated method stub
		String sql = getMapSqlOfQuotaName();
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String whereSql = whereHql(quota,whereMap);
		String orderSql = orderHql(ph);
		sql = sql + whereSql + orderSql;
		return getInfoListBySql(sql, whereMap, ph.getPage(),ph.getRows());
	}
	
	@Override
	public List<ThQuota> getQuotaList(ThQuota quota, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThQuota t ";
		List<ThQuota> quotaList = find(hql
				+ whereHql(quota, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return quotaList;
	}

	@Override
	public Long getCountOfQuotaList(ThQuota quota) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThQuota t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return count(hql + whereHql(quota, params), params);
	}

	@Override
	public Integer updateById(ThQuota quota) {
		// TODO Auto-generated method stub
		if(quota.getQuotaId() == null ){
			return null;
		}
		String hql = " update ThQuota t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(quota,params);
		String whereIdHql = " where t.quotaId = :quotaId ";
		
		return executeHql(hql + setHql + whereIdHql,params);
	}

	@Override
	public Integer deleteById(ThQuota quota) {
		// TODO Auto-generated method stub
		if(quota.getQuotaId() == null ){
			return null;
		}
		String hql = " delete ThQuota t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return executeHql(hql + whereHql(quota, params),params);
	}
	
	private String whereHql(ThQuota quota, Map<String, Object> params){	
		String whereHql = "";
		if (quota != null) {
			whereHql += " where 1=1 ";
			if(quota.getQuotaId() != null){
				whereHql += " and t.quotaId = :quotaId";
				params.put("quotaId", quota.getQuotaId());
			}
			if(quota.getQuotaType() != null){
				whereHql += " and t.quotaType = :quotaType";
				params.put("quotaType", quota.getQuotaType());
			}
			if(StringUtils.isNotBlank(quota.getQuotaName())){
				whereHql += " and t.quotaName = :quotaName";
				params.put("quotaName", quota.getQuotaName());
			}
			if(StringUtils.isNotBlank(quota.getSecondQuotaName())){
				whereHql += " and t.secondQuotaName = :secondQuotaName";
				params.put("secondQuotaName", quota.getSecondQuotaName());
			}
			if(quota.getCreateTime() != null){
				whereHql += " and t.createTime = :createTime";
				params.put("createTime", quota.getCreateTime());
			}
			if(StringUtils.isNotBlank(quota.getCreateUser())){
				whereHql += " and t.createUser = :createUser";
				params.put("createUser", quota.getCreateUser());
			}
			if(quota.getUpdateTime() != null){
				whereHql += " and t.updateTime = :updateTime";
				params.put("updateTime", quota.getUpdateTime());
			}
			if(StringUtils.isNotBlank(quota.getUpdateUser())){
				whereHql += " and t.updateUser = :updateUser";
				params.put("updateUser", quota.getUpdateUser());
			}
			if(StringUtils.isNotBlank(quota.getRemark())){
				whereHql += " and t.remark = :remark";
				params.put("remark", quota.getRemark());
			}
		}
		return whereHql;
	}

	private String setHql(ThQuota quota, Map<String, Object> params){
		String setHql = "";
		if (quota != null) {
			setHql += " set";
			if(quota.getQuotaId() != null){
				setHql += " t.quotaId = :quotaId,";
				params.put("quotaId", quota.getQuotaId());
			}
			if(quota.getQuotaType() != null){
				setHql += " t.quotaType = :quotaType,";
				params.put("quotaType", quota.getQuotaType());
			}
			if(quota.getQuotaName() != null){
				setHql += " t.quotaName = :quotaName,";
				params.put("quotaName", quota.getQuotaName());
			}
			if(quota.getSecondQuotaName() != null){
				setHql += " t.secondQuotaName = :secondQuotaName,";
				params.put("secondQuotaName", quota.getSecondQuotaName());
			}
			if(quota.getCreateTime() != null){
				setHql += " t.createTime = :createTime,";
				params.put("createTime", quota.getCreateTime());
			}
			if(quota.getCreateUser() != null){
				setHql += " t.createUser = :createUser,";
				params.put("createUser", quota.getCreateUser());
			}
			if(quota.getUpdateTime() != null){
				setHql += " t.updateTime = :updateTime,";
				params.put("updateTime", quota.getUpdateTime());
			}
			if(quota.getUpdateUser() != null){
				setHql += " t.updateUser = :updateUser,";
				params.put("updateUser", quota.getUpdateUser());
			}
			if(quota.getRemark() != null){
				setHql += " t.remark = :remark,";
				params.put("remark", quota.getRemark());
			}
		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}
	
	private String getMapSqlOfQuotaName(){
		String sql = "select DISTINCT "
				+ "t.quotaType,"
				+ "t.quotaName"
		        + " from th_quota t ";
		return sql;
	}
}
