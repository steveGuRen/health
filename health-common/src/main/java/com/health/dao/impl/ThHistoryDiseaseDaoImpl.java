package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThHistoryDiseaseDao;
import com.health.model.ThHistoryDisease;
import com.health.model.ThHistoryMedical;
import com.health.utils.PageHelper;

@Repository
public class ThHistoryDiseaseDaoImpl extends BaseDaoImpl<ThHistoryDisease> implements ThHistoryDiseaseDao{

	@Override
	public List<ThHistoryDisease> getObjects(ThHistoryDisease item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThHistoryDisease t ";
		List<ThHistoryDisease> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThHistoryDisease item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThHistoryDisease item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThHistoryDisease get(ThHistoryDisease item) {
		// TODO Auto-generated method stub
		String hql = " from ThHistoryDisease t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThHistoryDisease result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThHistoryDisease item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThHistoryDisease t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String getListSql(ThHistoryDisease item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.disease, "
				+ "t.diagnosisTime, "
				+ "t.iscured, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_history_disease t ";
		String orderString  = "";
		if (ph !=null && StringUtils.isNotBlank(ph.getSort()) && StringUtils.isNotBlank(ph.getOrder())) {
			orderString = " order by " + ph.getSort() + " " + ph.getOrder();
		}
		String limitString = "";
		if(ph != null && ph.getRows() > 0 && ph.getPage() > 0) {
			Integer index =  (ph.getPage() - 1)*ph.getRows();
			limitString = " limit " + index + "," + new Integer(ph.getRows()); 
		} 
		return sql + whereSql(item, params) + orderString +  limitString;
	}
	
	private String whereSql(ThHistoryDisease item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getDisease())) {
				whereSql += " and t.disease = :disease ";
				params.put("disease", item.getDisease());
			}
			if(StringUtils.isNotBlank(item.getDiagnosisTime())) {
				whereSql += " and t.diagnosisTime = :diagnosisTime ";
				params.put("diagnosisTime", item.getDiagnosisTime());
			}
			if(StringUtils.isNotBlank(item.getIscured())) {
				whereSql += " and t.iscured = :iscured ";
				params.put("iscured", item.getIscured());
			}
			if(StringUtils.isNotBlank(item.getUserId())) {
				whereSql += " and t.userId = :userId ";
				params.put("userId", item.getUserId());
			}
			if(item.getCreateTime() != null) {
				whereSql += " and t.createTime = :createTime ";
				params.put("createTime", item.getCreateTime());
			}
			if(item.getUpdateTime() != null) {
				whereSql += " and t.updateTime = :updateTime ";
				params.put("updateTime", item.getUpdateTime());
			}
			if(StringUtils.isNotBlank(item.getCreateUser())) {
				whereSql += " and t.createUser = :createUser ";
				params.put("createUser", item.getCreateUser());
			}
			if(StringUtils.isNotBlank(item.getUpdateUser())) {
				whereSql += " and t.updateUser = :updateUser ";
				params.put("updateUser", item.getUpdateUser());
			}
		}
		return whereSql;
	}
	
	private String setSql(ThHistoryDisease item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getDisease() != null) {
				setSql += " t.disease = :diseaseNew,";
				params.put("diseaseNew", item.getDisease());
			}
			if(item.getDiagnosisTime() != null) {
				setSql += " t.diagnosisTime = :diagnosisTimeNew,";
				params.put("diagnosisTimeNew", item.getDiagnosisTime());
			}
			if(item.getIscured() != null) {
				setSql += " t.iscured = :iscuredNew,";
				params.put("iscuredNew", item.getIscured());
			}
			if(item.getUserId() != null) {
				setSql += " t.userId = :userIdNew,";
				params.put("userIdNew", item.getUserId());
			}
			if(item.getCreateTime() != null) {
				setSql += " t.createTime = :createTimeNew,";
				params.put("createTimeNew", item.getCreateTime());
			}
			if(item.getUpdateTime() != null) {
				setSql += " t.updateTime = :updateTimeNew,";
				params.put("updateTimeNew", item.getUpdateTime());
			}
			if(item.getCreateUser() != null) {
				setSql += " t.createUser = :createUserNew,";
				params.put("createUserNew", item.getCreateUser());
			}
			if(item.getUpdateUser() != null) {
				setSql += " t.updateUser = :updateUserNew,";
				params.put("updateUserNew", item.getUpdateUser());
			}
		}
		if(StringUtils.endsWith(setSql, ",")){
			setSql = setSql.substring(0,setSql.length()-1); 
		}
		return setSql;
	}
}
