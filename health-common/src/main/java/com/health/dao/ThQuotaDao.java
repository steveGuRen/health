package com.health.dao;

import java.util.List;
import java.util.Map;

import com.health.model.ThQuota;
import com.health.utils.PageHelper;

public interface ThQuotaDao extends BaseDaoI<ThQuota>{
	
	public List<Map<String, Object>> getQuotaNameList(ThQuota quota, PageHelper ph);
	
	public List<ThQuota> getQuotaList(ThQuota quota,
			PageHelper ph);
	
	public Long getCountOfQuotaList(ThQuota quota);
	
	public Integer updateById(ThQuota quota);
	
	public Integer deleteById(ThQuota quota);
}
