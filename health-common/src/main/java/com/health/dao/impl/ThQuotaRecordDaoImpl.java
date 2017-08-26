package com.health.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThQuotaRecordDao;
import com.health.model.ThQuotaRecord;
import com.health.model.ThQuotaStandard;
import com.health.utils.PageHelper;

@Repository
public class ThQuotaRecordDaoImpl extends BaseDaoImpl<ThQuotaRecord> implements ThQuotaRecordDao {

	@Override
	public List<ThQuotaRecord> getQuotaRecordList(ThQuotaRecord record, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThQuotaRecord t ";
		List<ThQuotaRecord> quotarecordList = find(hql
				+ whereHql(record, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return quotarecordList;
	}

	@Override
	public Long getCountOfQuotaRecordList(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThQuotaRecord t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return count(hql + whereHql(record, params), params);
	}

	@Override
	public List<Map<String, Object>> getQuotaRecordAndQuotaList(Map<String, Object> params, PageHelper ph) {
		// TODO Auto-generated method stub
		String sql = getMapSqlOfQuotaRecordAndQuota();
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String whereSql = whereSqlByMap(params,whereMap);
		String orderSql = orderHql(ph);
		sql = sql + whereSql + orderSql;
		return getInfoListBySql(sql, whereMap, ph.getPage(),ph.getRows());
	}

	@Override
	public Long getCountOfQuotaRecordAndQuotaList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		String sql = getMapSqlOfQuotaRecordAndQuota();
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String whereSql = whereSqlByMap(params,whereMap);           
		sql = "SELECT count(*) from (" + sql + whereSql + ") b";
		return (Long)countBySql(sql,whereMap);
	}

	@Override
	public Integer updateById(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		if(record.getQuotaRecordId() == null ){
			return null;
		}
		String hql = " update ThQuotaRecord t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(record,params);
		String whereIdHql = " where t.quotaRecordId = :quotaRecordId ";
		
		return executeHql(hql + setHql + whereIdHql,params);
	}

	@Override
	public Integer deleteById(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		if(record.getQuotaRecordId() == null ){
			return null;
		}
		String hql = " delete ThQuotaRecord t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return executeHql(hql + whereHql(record,params),params);
	}
	
	@Override
	public List<ThQuotaRecord> getQuotaRecordMaxCount(ThQuotaRecord record, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThQuotaRecord t ";
		List<ThQuotaRecord> quotarecordList = find(hql
				+ whereHql(record, params) + orderHql(ph), params,
				ph.getPage(), ph.getRows());
		return quotarecordList;
	}
	
	@Override
	public List<Map<String, Object>> getQuotaRecordStatisticalAnalysis(Map<String, Object> params,String StatisticType,List<String> fieldList,List<String> categoryList) {
		// TODO Auto-generated method stub
		String sql = getMapSqlOfQuotaRecordStatisticalAnalysis();
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String whereSql = whereSqlByMap(params,whereMap);
		String statisticalSql = " select b.result,count(*) as resultCount from (" + sql + whereSql + ") b group by b.result";
		String field = "";
		if(!StatisticType.equals("0")){
			//包含民族
			if(StatisticType.equals("1")){
				field = "nation";
			}
			//包含城市,计算比例
			if(StatisticType.equals("2")){
				field = "city";
			}
			String includeResultSql = " select b." + field + ",b.result,count(*) as resultCount from (" + sql + whereSql + ") b group by b." + field + ", b.result";
			String unincludeResultSql = " select b." + field + ", count(*) as resultCount from (" + sql + whereSql + ") b group by b." + field;
			statisticalSql = " select c." 
							+ field + ",c.result,c.resultCount as ccount,d.resultCount as sum,round(c.resultCount/d.resultCount,2) as ratio from (" 
							+ includeResultSql 
							+") c left join (" 
							+ unincludeResultSql 
							+ ") d on c." + field + "=d." + field;
		}
		
		return getInfoListBySql(statisticalSql, whereMap);
	}
	
	@Override
	public List<Map<String, Object>> getNationList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		String sql = getMapSqlOfQuotaRecordStatisticalAnalysis();
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String whereSql = whereSqlByMap(params,whereMap);
		String statisticalSql = " select b.nation from (" + sql + whereSql + ") b group by b.nation";
		
		return getInfoListBySql(statisticalSql, whereMap);
	}
	
	private String setHql(ThQuotaRecord record, Map<String, Object> params){
		String setHql = "";
		if (record != null) {
			setHql += " set";
			if(record.getQuotaRecordId() != null){
				setHql += " t.quotaRecordId = :quotaRecordId,";
				params.put("quotaRecordId", record.getQuotaRecordId());
			}
			if(record.getUserId() != null){
				setHql += " t.userId = :userId,";
				params.put("userId", record.getUserId());
			}
			if(record.getUserName() != null){
				setHql += " t.userName = :userName,";
				params.put("userName", record.getUserName());
			}
			if(record.getGender() != null){
				setHql += " t.gender = :gender,";
				params.put("gender", record.getGender());
			}
			if(record.getUserAge() != null){
				setHql += " t.userAge = :userAge,";
				params.put("userAge", record.getUserAge());
			}
			if(record.getQuotaId() != null){
				setHql += " t.quotaId = :quotaId,";
				params.put("quotaId", record.getQuotaId());
			}
			if(record.getQuotaType() != null){
				setHql += " t.quotaType = :quotaType,";
				params.put("quotaType", record.getQuotaType());
			}
			if(record.getQuotaName() != null){
				setHql += " t.quotaName = :quotaName,";
				params.put("quotaName", record.getQuotaName());
			}
			if(record.getSecondQuotaName() != null){
				setHql += " t.secondQuotaName = :secondQuotaName,";
				params.put("secondQuotaName", record.getSecondQuotaName());
			}
			if(record.getCount() != null){
				setHql += " t.count = :count,";
				params.put("count", record.getCount());
			}
			if(record.getValue() != null){
				setHql += " t.value = :value,";
				params.put("value", record.getValue());
			}
			if(record.getUnit() != null){
				setHql += " t.unit = :unit,";
				params.put("unit", record.getUnit());
			}
			if(record.getResult() != null){
				setHql += " t.result = :result,";
				params.put("result", record.getResult());
			}
			if(record.getDeviceId() != null){
				setHql += " t.deviceId = :deviceId,";
				params.put("deviceId", record.getDeviceId());
			}
			if(record.getDevice() != null){
				setHql += " t.device = :device,";
				params.put("device", record.getDevice());
			}
			if(record.getOrganizationId() != null){
				setHql += " t.organizationId = :organizationId,";
				params.put("organizationId", record.getOrganizationId());
			}
			if(record.getStatus() != null){
				setHql += " t.status = :status,";
				params.put("status", record.getStatus());
			}
			if(record.getCreateTime() != null){
				setHql += " t.createTime = :createTime,";
				params.put("createTime", record.getCreateTime());
			}
			if(record.getCreateUser() != null){
				setHql += " t.createUser = :createUser,";
				params.put("createUser", record.getCreateUser());
			}
			if(record.getUpdateTime() != null){
				setHql += " t.updateTime = :updateTime,";
				params.put("updateTime", record.getUpdateTime());
			}
			if(record.getUpdateUser() != null){
				setHql += " t.updateUser = :updateUser,";
				params.put("updateUser", record.getUpdateUser());
			}
		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}
	
	private String getMapSqlOfQuotaRecordAndQuota(){
		String sql = "select DISTINCT "
				+ "t.quotaRecordId,"
				+ "t.userId,"
				+ "t.userName,"
				+ "t.gender,"
				+ "t.userAge,"
				+ "t.quotaId,"
				+ "t.quotaName,"
				+ "t.quotaType,"
				+ "t.secondQuotaName,"
				+ "t.count,"
				+ "t.value,"
				+ "t.unit,"
				+ "t.result,"
				+ "t.deviceId,"
				+ "t.device,"
				+ "t.organizationId,"
		        + "t.createTime,"
		        + "t.createUser,"
		        + "t.updateTime,"
		        + "t.updateUser,"
		        + "u.userLoginname,"
		        + "u.userIdCard,"
		        + "u.userTel,"
		        + "i.nationality,"
		        + "i.village,"
		        + "i.nation,"
		        + "i.bloodType,"
		        + "i.education,"
		        + "i.workUnit,"
		        + "i.birthday,"
		        + "i.nativePlace,"
		        + "i.maritalStatus,"
		        + "a.province,"
		        + "a.city,"
		        + "a.district,"
		        + "a.detailAddress,"
		        + "d.deviceType,"
		        + "d.deviceName,"
		        + "d.connectTime,"
		        + "o.organizationName,"
		        + "o.organizationPosition,"
		        + "o.type"
		        + " from th_quota_record t "
		        + "left join th_user u on t.userId=u.userId "
		        + "left join th_user_info i on t.userId=i.userId "
		        + "left join th_user_address a on t.userId=a.userId "
		        + "left join th_device d on t.deviceId=d.deviceId "
		        + "left join th_organization o on t.organizationId=o.organizationId ";
		return sql;
	}
	private String whereSqlByMap(Map<String, Object> params,Map<String, Object> whereMap){
		String whereHql = "";
		if (params != null && !params.isEmpty()) {
			whereHql += " where 1=1 ";
			for (String key : params.keySet()) {
				if(StringUtils.equals(key, "quotaRecordId")){                        
					whereHql += " and t.quotaRecordId = :quotaRecordId";                 
					whereMap.put(key, params.get(key));                        
				}  
				if(StringUtils.equals(key, "userId")){                        
					whereHql += " and t.userId = :userId";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "quotaId")){                        
					whereHql += " and t.quotaId = :quotaId";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "quotaType")){                        
					whereHql += " and t.quotaType = :quotaType";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "count")){                        
					whereHql += " and t.count = :count";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "value")){                        
					whereHql += " and t.value = :value";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "unit")){                        
					whereHql += " and t.unit = :unit";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "result")){                        
					whereHql += " and t.result = :result";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "deviceId")){                        
					whereHql += " and t.deviceId = :deviceId";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "device")){                        
					whereHql += " and t.device = :device";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "organizationId")){                        
					whereHql += " and t.organizationId = :organizationId";                 
					whereMap.put(key, params.get(key));                        
				}
				if(StringUtils.equals(key, "status")){                        
					whereHql += " and t.status = :status";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "createTime")){                        
					whereHql += " and t.createTime = :createTime";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "createUser")){                        
					whereHql += " and t.createUser = :createUser";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "updateTime")){                        
					whereHql += " and t.updateTime = :updateTime";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "updateUser")){                        
					whereHql += " and t.updateUser = :updateUser";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userLoginname")){                        
					whereHql += " and u.userLoginname = :userLoginname";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userName")){                        
					whereHql += " and t.userName = :userName";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "gender")){                        
					whereHql += " and t.gender = :gender";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userAge")){                        
					whereHql += " and t.userAge = :userAge";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userAgeStart")){                        
					whereHql += " and t.userAge >= :userAgeStart";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userAgeEnd")){                        
					whereHql += " and t.userAge < :userAgeEnd";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userIdCard")){                        
					whereHql += " and u.userIdCard = :userIdCard";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "userTel")){                        
					whereHql += " and u.userTel = :userTel";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "nationality")){                        
					whereHql += " and i.nationality = :nationality";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "village")){                        
					whereHql += " and i.village = :village";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "nation")){                        
					whereHql += " and i.nation = :nation";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "bloodType")){                        
					whereHql += " and i.bloodType = :bloodType";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "education")){                        
					whereHql += " and i.education = :education";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "workUnit")){                        
					whereHql += " and i.workUnit = :workUnit";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "birthday")){                        
					whereHql += " and i.birthday = :birthday";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "nativePlace")){                        
					whereHql += " and i.nativePlace = :nativePlace";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "maritalStatus")){                        
					whereHql += " and i.maritalStatus = :maritalStatus";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "province")){                        
					whereHql += " and a.province = :province";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "city")){                        
					whereHql += " and a.city = :city";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "district")){                        
					whereHql += " and a.district = :district";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "detailAddress")){                        
					whereHql += " and a.detailAddress = :detailAddress";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "quotaType")){                        
					whereHql += " and t.quotaType = :quotaType";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "quotaName")){                        
					whereHql += " and t.quotaName = :quotaName";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "secondQuotaName")){                        
					whereHql += " and t.secondQuotaName = :secondQuotaName";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "deviceType")){                        
					whereHql += " and d.deviceType = :deviceType";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "deviceName")){                        
					whereHql += " and d.deviceName = :deviceName";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "connectTime")){                        
					whereHql += " and d.connectTime = :connectTime";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "organizationName")){                        
					whereHql += " and o.organizationName = :organizationName";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "organizationPosition")){                        
					whereHql += " and o.organizationPosition = :organizationPosition";                 
					whereMap.put(key, params.get(key));                        
				}
		        if(StringUtils.equals(key, "type")){                        
					whereHql += " and o.type = :type";                 
					whereMap.put(key, params.get(key));                        
				}
			}
		}
		return whereHql;
	}
	
	private String whereHql(ThQuotaRecord record, Map<String, Object> params){	
		String whereHql = "";
		if (record != null) {
			whereHql += " where 1=1 ";
			if(record.getQuotaRecordId() != null){
				whereHql += " and t.quotaRecordId = :quotaRecordId";
				params.put("quotaRecordId", record.getQuotaRecordId());
			}
			if(StringUtils.isNotBlank(record.getUserId())){
				whereHql += " and t.userId = :userId";
				params.put("userId", record.getUserId());
			}
			if(StringUtils.isNotBlank(record.getUserName())){
				whereHql += " and t.userName = :userName";
				params.put("userName", record.getUserName());
			}
			if(record.getGender() != null){
				whereHql += " and t.gender = :gender";
				params.put("gender", record.getGender());
			}
			if(record.getUserAge() != null){
				whereHql += " and t.userAge = :userAge";
				params.put("userAge", record.getUserAge());
			}
			if(record.getQuotaId() != null){
				whereHql += " and t.quotaId = :quotaId";
				params.put("quotaId", record.getQuotaId());
			}
			if(record.getQuotaType() != null){
				whereHql += " and t.quotaType = :quotaType";
				params.put("quotaType", record.getQuotaType());
			}
			if(StringUtils.isNotBlank(record.getQuotaName())){
				whereHql += " and t.quotaName = :quotaName";
				params.put("quotaName", record.getQuotaName());
			}
			if(StringUtils.isNotBlank(record.getSecondQuotaName())){
				whereHql += " and t.secondQuotaName = :secondQuotaName";
				params.put("secondQuotaName", record.getSecondQuotaName());
			}
			if(record.getCount() != null){
				whereHql += " and t.count = :count";
				params.put("count", record.getCount());
			}
			if(record.getValue() != null){
				whereHql += " and t.value = :value";
				params.put("value", record.getValue());
			}
			if(StringUtils.isNotBlank(record.getUnit())){
				whereHql += " and t.unit = :unit";
				params.put("unit", record.getUnit());
			}
			if(StringUtils.isNotBlank(record.getResult())){
				whereHql += " and t.result = :result";
				params.put("result", record.getResult());
			}
			if(record.getDeviceId() != null){
				whereHql += " and t.deviceId = :deviceId";
				params.put("deviceId", record.getDeviceId());
			}
			if(StringUtils.isNotBlank(record.getDevice())){
				whereHql += " and t.device = :device";
				params.put("device", record.getDevice());
			}
			if(record.getOrganizationId() != null){
				whereHql += " and t.organizationId = :organizationId";
				params.put("organizationId", record.getOrganizationId());
			}
			if(record.getStatus() != null){
				whereHql += " and t.status = :status";
				params.put("status", record.getStatus());
			}
			if(record.getCreateTime() != null){
				whereHql += " and t.createTime = :createTime";
				params.put("createTime", record.getCreateTime());
			}
			if(StringUtils.isNotBlank(record.getCreateUser())){
				whereHql += " and t.createUser = :createUser";
				params.put("createUser", record.getCreateUser());
			}
			if(record.getUpdateTime() != null){
				whereHql += " and t.updateTime = :updateTime";
				params.put("updateTime", record.getUpdateTime());
			}
			if(StringUtils.isNotBlank(record.getUpdateUser())){
				whereHql += " and t.updateUser = :updateUser";
				params.put("updateUser", record.getUpdateUser());
			}
		}
		return whereHql;
	}
	
	private String getMapSqlOfQuotaRecordStatisticalAnalysis(){
		String sql = "select DISTINCT "
				+ "t.quotaRecordId,"
				+ "t.userId,"
				+ "t.userName,"
		        + "t.gender,"
		        + "t.userAge,"
				+ "t.quotaId,"
				+ "t.quotaType,"
		        + "t.quotaName,"
		        + "t.secondQuotaName,"
				+ "t.count,"
				+ "t.value,"
				+ "t.unit,"
				+ "t.result,"
				+ "t.deviceId,"
				+ "t.device,"
				+ "t.organizationId,"
		        + "t.createTime,"
		        + "t.createUser,"
		        + "t.updateTime,"
		        + "t.updateUser,"
		        + "u.userLoginname,"
		        + "u.userIdCard,"
		        + "u.userTel,"
		        + "i.nationality,"
		        + "i.village,"
		        + "i.nation,"
		        + "i.bloodType,"
		        + "i.education,"
		        + "i.workUnit,"
		        + "i.birthday,"
		        + "i.nativePlace,"
		        + "i.maritalStatus,"
		        + "a.province,"
		        + "a.city,"
		        + "a.district,"
		        + "a.detailAddress"
		        + " from th_quota_record t "
		        + "left join th_user u on t.userId=u.userId "
		        + "left join th_user_info i on t.userId=i.userId "
		        + "left join th_user_address a on t.userId=a.userId ";
		return sql;
	}

}
