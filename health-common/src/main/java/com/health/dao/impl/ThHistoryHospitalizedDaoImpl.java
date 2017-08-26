package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThHistoryHospitalizedDao;
import com.health.model.ThHistoryHospitalized;
import com.health.model.ThHistoryMedical;
import com.health.utils.PageHelper;

@Repository
public class ThHistoryHospitalizedDaoImpl extends BaseDaoImpl<ThHistoryHospitalized> implements ThHistoryHospitalizedDao{

	@Override
	public List<ThHistoryHospitalized> getObjects(ThHistoryHospitalized item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThHistoryHospitalized t ";
		List<ThHistoryHospitalized> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThHistoryHospitalized item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThHistoryHospitalized item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThHistoryHospitalized get(ThHistoryHospitalized item) {
		// TODO Auto-generated method stub
		String hql = " from ThHistoryHospitalized t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThHistoryHospitalized result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThHistoryHospitalized item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThHistoryHospitalized t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	
	private String getListSql(ThHistoryHospitalized item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.patientId, "
				+ "t.institution, "
				+ "t.cause, "
				+ "t.hospitalInTime, "
				+ "t.hospitalOutTime, "
				+ "t.bedId, "
				+ "t.bedInstitution, "
				+ "t.bedCreateTime, "
				+ "t.bedDelTime, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_history_hospitalized t ";
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
	
	private String whereSql(ThHistoryHospitalized item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getPatientId())) {
				whereSql += " and t.patientId = :patientId ";
				params.put("patientId", item.getPatientId());
			}
			if(StringUtils.isNotBlank(item.getInstitution())) {
				whereSql += " and t.institution = :institution ";
				params.put("institution", item.getInstitution());
			}
			if(StringUtils.isNotBlank(item.getCause())) {
				whereSql += " and t.cause = :cause ";
				params.put("cause", item.getCause());
			}
			if(item.getHospitalInTime() != null) {
				whereSql += " and t.hospitalInTime = :hospitalInTime ";
				params.put("hospitalInTime", item.getHospitalInTime());
			}
			if(item.getHospitalOutTime() != null) {
				whereSql += " and t.hospitalOutTime = :hospitalOutTime ";
				params.put("hospitalOutTime", item.getHospitalOutTime());
			}
			if(StringUtils.isNotBlank(item.getBedId())) {
				whereSql += " and t.bedId = :bedId ";
				params.put("bedId", item.getBedId());
			}
			if(StringUtils.isNotBlank(item.getBedInstitution())) {
				whereSql += " and t.bedInstitution = :bedInstitution ";
				params.put("bedInstitution", item.getBedInstitution());
			}
			if(item.getBedCreateTime() != null) {
				whereSql += " and t.bedCreateTime = :bedCreateTime ";
				params.put("bedCreateTime", item.getBedCreateTime());
			}
			if(item.getBedDelTime() != null) {
				whereSql += " and t.bedDelTime = :bedDelTime ";
				params.put("bedDelTime", item.getBedDelTime());
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
	
	private String setSql(ThHistoryHospitalized item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getPatientId() != null) {
				setSql += " t.patientId = :patientIdNew,";
				params.put("patientIdNew", item.getPatientId());
			}
			if(item.getInstitution() != null) {
				setSql += " t.institution = :institutionNew,";
				params.put("institutionNew", item.getInstitution());
			}
			if(item.getCause() != null) {
				setSql += " t.cause = :causeNew,";
				params.put("causeNew", item.getCause());
			}
			if(item.getHospitalInTime() != null) {
				setSql += " t.hospitalInTime = :hospitalInTimeNew,";
				params.put("hospitalInTimeNew", item.getHospitalInTime());
			}
			if(item.getHospitalOutTime() != null) {
				setSql += " t.hospitalOutTime = :hospitalOutTimeNew,";
				params.put("hospitalOutTimeNew", item.getHospitalOutTime());
			}
			if(item.getBedId() != null) {
				setSql += " t.bedId = :bedIdNew,";
				params.put("bedIdNew", item.getBedId());
			}
			if(item.getBedInstitution() != null) {
				setSql += " t.bedInstitution = :bedInstitutionNew,";
				params.put("bedInstitutionNew", item.getBedInstitution());
			}
			if(item.getBedCreateTime() != null) {
				setSql += " t.bedCreateTime = :bedCreateTimeNew,";
				params.put("bedCreateTimeNew", item.getBedCreateTime());
			}
			if(item.getBedDelTime() != null) {
				setSql += " t.bedDelTime = :bedDelTimeNew,";
				params.put("bedDelTimeNew", item.getBedDelTime());
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
