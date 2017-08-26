package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThDocumentDao;
import com.health.model.ThDocument;
import com.health.model.ThQuota;
import com.health.utils.PageHelper;

@Repository
public class ThDocumentDaoImpl extends BaseDaoImpl<ThDocument> implements ThDocumentDao{

	@Override
	public List<ThDocument> getDocumentAndQuotaList(ThDocument document, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThDocument t ";
		List<ThDocument> documentList = find(hql
				+ whereHql(document, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return documentList;
		
//		String hql = getMapSqlOfDocumentAndQuota();
//		Map<String, Object> whereMap = new HashMap<String, Object>();
//		String whereHql = whereHql(document,whereMap);
//		String orderSql = orderHql(ph);
//		hql = hql + whereHql + orderSql;
//		return getInfoListBySql(hql, whereMap, ph.getPage(),ph.getRows());
	}

	@Override
	public Long getCountOfDocumentAndQuotaList(ThDocument document) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ThDocument t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return count(hql + whereHql(document, params), params);
		
//		String hql = getMapSqlOfDocumentAndQuota();
//		Map<String, Object> whereMap = new HashMap<String, Object>();
//		String whereHql = whereHql(document,whereMap);           
//		hql = "SELECT count(*) from (" + hql + whereHql + ") b";
//		return (Long)countBySql(hql,whereMap);
	}

	@Override
	public Integer updateById(ThDocument document) {
		// TODO Auto-generated method stub
		if(document.getDocumentId() == null ){
			return null;
		}
		String hql = " update ThDocument t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(document,params);
		String whereIdHql = " where t.documentId = :documentId ";
		
		return executeHql(hql + setHql + whereIdHql,params);
	}

	@Override
	public Integer deleteById(ThDocument document) {
		// TODO Auto-generated method stub
		if(document.getDocumentId() == null ){
			return null;
		}
		String hql = " delete ThDocument t ";
		Map<String, Object> params = new HashMap<String, Object>();
		return executeHql(hql + whereHql(document,params),params);
	}
	
	private String setHql(ThDocument document, Map<String, Object> params){
		String setHql = "";
		if (document != null) {
			setHql += " set";
			if(document.getDocumentId() != null){
				setHql += " t.documentId = :documentId,";
				params.put("documentId", document.getDocumentId());
			}
			if(document.getUserId() != null){
				setHql += " t.userId = :userId,";
				params.put("userId", document.getUserId());
			}
			if(document.getName() != null){
				setHql += " t.name = :name,";
				params.put("name", document.getName());
			}
			if(document.getDocumentType() != null){
				setHql += " t.documentType = :documentType,";
				params.put("documentType", document.getDocumentType());
			}
			if(document.getHealthTip() != null){
				setHql += " t.healthTip = :healthTip,";
				params.put("healthTip", document.getHealthTip());
			}
			if(document.getQuotaNames() != null){
				setHql += " t.quotaNames = :quotaNames,";
				params.put("quotaNames", document.getQuotaNames());
			}
			if(document.getCreateTime() != null){
				setHql += " t.createTime = :createTime,";
				params.put("createTime", document.getCreateTime());
			}
			if(document.getUpdateTime() != null){
				setHql += " t.updateTime = :updateTime,";
				params.put("updateTime", document.getUpdateTime());
			}
			if(document.getCreateUser() != null){
				setHql += " t.createUser = :createUser,";
				params.put("createUser", document.getCreateUser());
			}
			if(document.getUpdateUser() != null){
				setHql += " t.updateUser = :updateUser,";
				params.put("updateUser", document.getUpdateUser());
			}
		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}
	
	private String getMapSqlOfDocumentAndQuota(){
		String sql = "select distinct "
				+ "t.documentId,"
				+ "t.userId,"
				+ "t.name,"
				+ "t.documentType,"
				+ "t.healthTip,"
				+ "t.createTime,"
				+ "t.updateTime,"
				+ "t.createUser,"
				+ "d.quotaNames"
				+ " from th_document t"
				+ " left join"
				+ " (select q.documentId,group_concat(distinct q.quotaName) as quotaNames from th_document_quota q group by q.documentId) d"
				+ " on t.documentId = d.documentId";
		return sql;
	}

	private String whereHql(ThDocument document, Map<String, Object> params){	
		String whereHql = "";
		if (document != null) {
			whereHql += " where 1=1 ";
			if(document.getDocumentId() != null){
				whereHql += " and t.documentId = :documentId";
				params.put("documentId", document.getDocumentId());
			}
			if(StringUtils.isNotBlank(document.getUserId())){
				whereHql += " and t.userId = :userId";
				params.put("userId", document.getUserId());
			}
			if(StringUtils.isNotBlank(document.getName())){
				whereHql += " and t.name = :name";
				params.put("name", document.getName());
			}
			if(document.getDocumentType() != null){
				whereHql += " and t.documentType = :documentType";
				params.put("documentType", document.getDocumentType());
			}
			if(StringUtils.isNotBlank(document.getHealthTip())){
				whereHql += " and t.healthTip = :healthTip";
				params.put("healthTip", document.getHealthTip());
			}
			if(StringUtils.isNotBlank(document.getQuotaNames())){
				whereHql += " and t.quotaNames = :quotaNames";
				params.put("quotaNames", document.getQuotaNames());
			}
			if(document.getCreateTime() != null){
				whereHql += " and t.createTime = :createTime";
				params.put("createTime", document.getCreateTime());
			}
			if(document.getUpdateTime() != null){
				whereHql += " and t.updateTime = :updateTime";
				params.put("updateTime", document.getUpdateTime());
			}
			if(StringUtils.isNotBlank(document.getCreateUser())){
				whereHql += " and t.createUser = :createUser";
				params.put("createUser", document.getCreateUser());
			}
			if(StringUtils.isNotBlank(document.getUpdateUser())){
				whereHql += " and t.updateUser = :updateUser";
				params.put("updateUser", document.getUpdateUser());
			}
		}
		return whereHql;
	}
	
}
