package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThHistoryPharmacyDao;
import com.health.model.ThHistoryPharmacy;
import com.health.utils.PageHelper;

@Repository
public class ThHistoryPharmacyDaoImpl extends BaseDaoImpl<ThHistoryPharmacy> implements ThHistoryPharmacyDao{

	@Override
	public List<ThHistoryPharmacy> getObjects(ThHistoryPharmacy item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThHistoryPharmacy t ";
		List<ThHistoryPharmacy> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThHistoryPharmacy item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThHistoryPharmacy item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThHistoryPharmacy get(ThHistoryPharmacy item) {
		// TODO Auto-generated method stub
		String hql = " from ThHistoryPharmacy t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThHistoryPharmacy result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThHistoryPharmacy item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThHistoryPharmacy t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String getListSql(ThHistoryPharmacy item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.medicalName, "
				+ "t.way, "
				+ "t.dosage, "
				+ "t.drugDependence, "
				+ "t.medicationTime, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_history_pharmacy t ";
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
	
	private String whereSql(ThHistoryPharmacy item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getMedicalName())) {
				whereSql += " and t.medicalName = :medicalName ";
				params.put("medicalName", item.getMedicalName());
			}
			if(StringUtils.isNotBlank(item.getWay())) {
				whereSql += " and t.way = :way ";
				params.put("way", item.getWay());
			}
			if(StringUtils.isNotBlank(item.getDosage())) {
				whereSql += " and t.dosage = :dosage ";
				params.put("dosage", item.getDosage());
			}
			if(StringUtils.isNotBlank(item.getDrugDependence())) {
				whereSql += " and t.drugDependence = :drugDependence ";
				params.put("drugDependence", item.getDrugDependence());
			}
			if(StringUtils.isNotBlank(item.getMedicationTime())) {
				whereSql += " and t.medicationTime = :medicationTime ";
				params.put("medicationTime", item.getMedicationTime());
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
	
	private String setSql(ThHistoryPharmacy item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getMedicalName() != null) {
				setSql += " t.medicalName = :medicalNameNew,";
				params.put("medicalNameNew", item.getMedicalName());
			}
			if(item.getWay() != null) {
				setSql += " t.way = :wayNew,";
				params.put("wayNew", item.getWay());
			}
			if(item.getDosage() != null) {
				setSql += " t.dosage = :dosageNew,";
				params.put("dosageNew", item.getDosage());
			}
			if(item.getDrugDependence() != null) {
				setSql += " t.drugDependence = :drugDependenceNew,";
				params.put("drugDependenceNew", item.getDrugDependence());
			}
			if(item.getMedicationTime() != null) {
				setSql += " t.medicationTime = :medicationTimeNew,";
				params.put("medicationTimeNew", item.getMedicationTime());
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
