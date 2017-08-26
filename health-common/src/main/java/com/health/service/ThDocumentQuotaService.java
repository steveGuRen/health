package com.health.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.health.model.ThDocumentQuota;
import com.health.utils.PageHelper;

public interface ThDocumentQuotaService {

	public Integer deleteById(ThDocumentQuota documentQuota);
	
	public Serializable add(ThDocumentQuota documentQuota);
	
	public List<Map<String, Object>> getDocumentQuotaList(ThDocumentQuota documentQuota,
			PageHelper ph);
	
	public Long getCountOfDocumentQuotaList(ThDocumentQuota documentQuota);
	
}
