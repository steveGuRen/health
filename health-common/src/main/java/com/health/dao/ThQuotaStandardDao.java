package com.health.dao;

import java.util.List;

import com.health.model.ThQuotaStandard;
import com.health.utils.PageHelper;;

public interface ThQuotaStandardDao extends BaseDaoI<ThQuotaStandard>{
	
	public List<ThQuotaStandard> getQuotaStandardList(ThQuotaStandard quotastandard,
			PageHelper ph);
	
	public Long getCountOfQuotaStandardList(ThQuotaStandard quotastandard);
	
	public Integer updateById(ThQuotaStandard quotastandard);
	
	public Integer deleteById(ThQuotaStandard quotastandard);
}
