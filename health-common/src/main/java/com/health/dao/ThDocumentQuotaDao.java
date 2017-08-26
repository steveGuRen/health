package com.health.dao;

import java.util.List;
import java.util.Map;

import com.health.model.ThDocumentQuota;
import com.health.utils.PageHelper;

public interface ThDocumentQuotaDao extends BaseDaoI<ThDocumentQuota>{
	
	public Integer deleteById(ThDocumentQuota documentQuota);
	
	public List<Map<String, Object>> getDocumentQuotaList(ThDocumentQuota documentQuota,
			PageHelper ph);
	
	public Long getCountOfDocumentQuotaList(ThDocumentQuota documentQuota);
	
}
