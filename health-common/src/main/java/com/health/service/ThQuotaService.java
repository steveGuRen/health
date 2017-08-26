package com.health.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.health.model.ThQuota;
import com.health.utils.PageHelper;

public interface ThQuotaService {

	public List<Map<String, Object>> getQuotaNameList(ThQuota quota);
	
	public List<ThQuota> getQuotaList(ThQuota quota,
			PageHelper ph);
	
	public Long getCountOfQuotaList(ThQuota quota);
	
	public Integer updateById(ThQuota quota);
	
	public Integer deleteById(ThQuota quota);
	
	public Serializable add(ThQuota quota);
}
