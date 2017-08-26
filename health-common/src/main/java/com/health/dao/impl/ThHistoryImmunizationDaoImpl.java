package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThHistoryImmunizationDao;
import com.health.model.ThHistoryImmunization;
import com.health.model.ThHistoryMedical;
import com.health.utils.PageHelper;

@Repository
public class ThHistoryImmunizationDaoImpl extends BaseDaoImpl<ThHistoryImmunization> implements ThHistoryImmunizationDao{

	@Override
	public List<ThHistoryImmunization> getObjects(ThHistoryImmunization item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThHistoryImmunization t ";
		List<ThHistoryImmunization> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThHistoryImmunization item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThHistoryImmunization item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThHistoryImmunization get(ThHistoryImmunization item) {
		// TODO Auto-generated method stub
		String hql = " from ThHistoryImmunization t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThHistoryImmunization result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThHistoryImmunization item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThHistoryImmunization t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	
	private String getListSql(ThHistoryImmunization item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.immunizationName, "
				+ "t.immunizationDate, "
				+ "t.immunizationInstitution, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_history_immunization t ";
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
	
	private String whereSql(ThHistoryImmunization item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getImmunizationName())) {
				whereSql += " and t.immunizationName = :immunizationName ";
				params.put("immunizationName", item.getImmunizationName());
			}
			if(item.getImmunizationDate() != null) {
				whereSql += " and t.immunizationDate = :immunizationDate ";
				params.put("immunizationDate", item.getImmunizationDate());
			}
			if(StringUtils.isNotBlank(item.getImmunizationInstitution())) {
				whereSql += " and t.immunizationInstitution = :immunizationInstitution ";
				params.put("immunizationInstitution", item.getImmunizationInstitution());
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
	
	private String setSql(ThHistoryImmunization item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getImmunizationName() != null) {
				setSql += " t.immunizationName = :immunizationNameNew,";
				params.put("immunizationNameNew", item.getImmunizationName());
			}
			if(item.getImmunizationDate() != null) {
				setSql += " t.immunizationDate = :immunizationDateNew,";
				params.put("immunizationDateNew", item.getImmunizationDate());
			}
			if(item.getImmunizationInstitution() != null) {
				setSql += " t.immunizationInstitution = :immunizationInstitutionNew,";
				params.put("immunizationInstitutionNew", item.getImmunizationInstitution());
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
