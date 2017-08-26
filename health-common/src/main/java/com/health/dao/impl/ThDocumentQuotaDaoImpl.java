package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThDocumentQuotaDao;
import com.health.model.ThDocumentQuota;
import com.health.utils.PageHelper;

@Repository
public class ThDocumentQuotaDaoImpl extends BaseDaoImpl<ThDocumentQuota> implements ThDocumentQuotaDao{

	@Override
	public Integer deleteById(ThDocumentQuota documentQuota) {
		// TODO Auto-generated method stub
//		if(documentQuota.getDocumentQuotaId() == null ){
//			return null;
//		}
		String hql = " delete ThDocumentQuota t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return executeHql(hql + whereHql(documentQuota, params),params);
	}
	
	@Override
	public List<Map<String, Object>> getDocumentQuotaList(ThDocumentQuota documentQuota, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = getMapSqlOfDocumentQuota(documentQuota,whereMap);
		return getInfoListBySql(sql, whereMap, ph.getPage(),ph.getRows());
	}

	@Override
	public Long getCountOfDocumentQuotaList(ThDocumentQuota documentQuota) {
		// TODO Auto-generated method stub
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = getMapSqlOfDocumentQuota(documentQuota,whereMap);
		String countsql = "SELECT count(*) from (" + sql + ") b";
		return (Long)countBySql(countsql,whereMap);
	}
	
	private String getMapSqlOfDocumentQuota(ThDocumentQuota documentQuota, Map<String, Object> params){
		
		String sql = "select distinct "
				+ "a.quotaRecordId,"
				+ "a.quotaName,"
				+ "r.userId,"
				+ "r.quotaId,"
				+ "r.count,"
				+ "r.value,"
				+ "r.unit,"
				+ "r.result,"
				+ "r.deviceId,"
				+ "r.device,"
				+ "r.organizationId,"
				+ "r.status,"
				+ "r.createTime,"
				+ "r.createUser,"
				+ "r.updateTime,"
				+ "r.updateUser"
				+ " from "
				+ "(select t.documentId,t.quotaName,t.quotaRecordId from th_document_quota t "
				+ whereHql(documentQuota,params)
				+ ") a "
				+ "left join th_quota_record r on a.quotaRecordId = r.quotaRecordId";
		return sql;
	}
	
	private String whereHql(ThDocumentQuota documentQuota, Map<String, Object> params){	
		String whereHql = "";
		if (documentQuota != null) {
			whereHql += " where 1=1 ";
			if(documentQuota.getDocumentQuotaId() != null){
				whereHql += " and t.documentQuotaId = :documentQuotaId";
				params.put("documentQuotaId", documentQuota.getDocumentQuotaId());
			}
			if(documentQuota.getDocumentId() != null){
				whereHql += " and t.documentId = :documentId";
				params.put("documentId", documentQuota.getDocumentId());
			}
			if(documentQuota.getQuotaRecordId() != null){
				whereHql += " and t.quotaRecordId = :quotaRecordId";
				params.put("quotaRecordId", documentQuota.getQuotaRecordId());
			}
			if(StringUtils.isNotBlank(documentQuota.getQuotaName())){
				whereHql += " and t.quotaName = :quotaName";
				params.put("quotaName", documentQuota.getQuotaName());
			}
			if(documentQuota.getCreateTime() != null){
				whereHql += " and t.createTime = :createTime";
				params.put("createTime", documentQuota.getCreateTime());
			}
			if(StringUtils.isNotBlank(documentQuota.getCreateUser())){
				whereHql += " and t.createUser = :createUser";
				params.put("createUser", documentQuota.getCreateUser());
			}
		}
		return whereHql;
	}
}
