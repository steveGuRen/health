package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThQuotaStandardDao;
import com.health.model.ThQuotaStandard;
import com.health.utils.PageHelper;

@Repository
public class ThQuotaStandardDaoImpl extends BaseDaoImpl<ThQuotaStandard> implements ThQuotaStandardDao {

	@Override
	public List<ThQuotaStandard> getQuotaStandardList(ThQuotaStandard quotastandard, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThQuotaStandard t ";
		List<ThQuotaStandard> quotastandardList = find(hql
				+ whereHql(quotastandard, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return quotastandardList;
	}

	@Override
	public Long getCountOfQuotaStandardList(ThQuotaStandard quotastandard) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThQuotaStandard t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return count(hql + whereHql(quotastandard, params), params);
	}

	@Override
	public Integer updateById(ThQuotaStandard quotastandard) {
		// TODO Auto-generated method stub
		if(quotastandard.getQuotaStandardId() == null ){
			return null;
		}
		String hql = " update ThQuotaStandard t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(quotastandard,params);
		String whereIdHql = " where t.quotaStandardId = :quotaStandardId ";
		
		return executeHql(hql + setHql + whereIdHql,params);
	}

	@Override
	public Integer deleteById(ThQuotaStandard quotastandard) {
		// TODO Auto-generated method stub
		if(quotastandard.getQuotaStandardId() == null ){
			return null;
		}
		String hql = " delete ThQuotaStandard t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return executeHql(hql + whereHql(quotastandard, params),params);
	}

	private String whereHql(ThQuotaStandard quotastandard, Map<String, Object> params){	
		String whereHql = "";
		if (quotastandard != null) {
			whereHql += " where 1=1 ";
			if(quotastandard.getQuotaStandardId() != null){
				whereHql += " and t.quotaStandardId = :quotaStandardId";
				params.put("quotaStandardId", quotastandard.getQuotaStandardId());
			}
			if(quotastandard.getQuotaId() != null){
				whereHql += " and t.quotaId = :quotaId";
				params.put("quotaId", quotastandard.getQuotaId());
			}
			if(quotastandard.getGender() != null){
				whereHql += " and t.gender = :gender";
				params.put("gender", quotastandard.getGender());
			}
			if(quotastandard.getAgeStart() != null){
				whereHql += " and t.ageStart = :ageStart";
				params.put("ageStart", quotastandard.getAgeStart());
			}
			if(quotastandard.getAgeEnd() != null){
				whereHql += " and t.ageEnd = :ageEnd";
				params.put("ageEnd", quotastandard.getAgeEnd());
			}
			if(quotastandard.getStandardValue() != null){
				whereHql += " and t.standardValue = :standardValue";
				params.put("standardValue", quotastandard.getStandardValue());
			}
			if(quotastandard.getCreateTime() != null){
				whereHql += " and t.createTime = :createTime";
				params.put("createTime", quotastandard.getCreateTime());
			}
			if(StringUtils.isNotBlank(quotastandard.getCreateUser())){
				whereHql += " and t.createUser = :createUser";
				params.put("createUser", quotastandard.getCreateUser());
			}
			if(quotastandard.getUpdateTime() != null){
				whereHql += " and t.updateTime = :updateTime";
				params.put("updateTime", quotastandard.getUpdateTime());
			}
			if(StringUtils.isNotBlank(quotastandard.getUpdateUser())){
				whereHql += " and t.updateUser = :updateUser";
				params.put("updateUser", quotastandard.getUpdateUser());
			}
		}
		return whereHql;
	}
	
	private String setHql(ThQuotaStandard quotastandard, Map<String, Object> params){
		String setHql = "";
		if (quotastandard != null) {
			setHql += " set";
			if(quotastandard.getQuotaStandardId() != null){
				setHql += " t.quotaStandardId = :quotaStandardId,";
				params.put("quotaStandardId", quotastandard.getQuotaStandardId());
			}
			if(quotastandard.getQuotaId() != null){
				setHql += " t.quotaId = :quotaId,";
				params.put("quotaId", quotastandard.getQuotaId());
			}
			if(quotastandard.getGender() != null){
				setHql += " t.gender = :gender,";
				params.put("gender", quotastandard.getGender());
			}
			if(quotastandard.getAgeStart() != null){
				setHql += " t.ageStart = :ageStart,";
				params.put("ageStart", quotastandard.getAgeStart());
			}
			if(quotastandard.getAgeEnd() != null){
				setHql += " t.ageEnd = :ageEnd,";
				params.put("ageEnd", quotastandard.getAgeEnd());
			}
			if(quotastandard.getStandardValue() != null){
				setHql += " t.standardValue = :standardValue,";
				params.put("standardValue", quotastandard.getStandardValue());
			}
			if(quotastandard.getCreateTime() != null){
				setHql += " t.createTime = :createTime,";
				params.put("createTime", quotastandard.getCreateTime());
			}
			if(quotastandard.getCreateUser() != null){
				setHql += " t.createUser = :createUser,";
				params.put("createUser", quotastandard.getCreateUser());
			}
			if(quotastandard.getUpdateTime() != null){
				setHql += " t.updateTime = :updateTime,";
				params.put("updateTime", quotastandard.getUpdateTime());
			}
			if(quotastandard.getUpdateUser() != null){
				setHql += " t.updateUser = :updateUser,";
				params.put("updateUser", quotastandard.getUpdateUser());
			}
		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}
}
