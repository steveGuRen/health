package com.health.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.health.model.ThQuotaRecord;
import com.health.utils.PageHelper;

public interface ThQuotaRecordService {

	public List<ThQuotaRecord> getQuotaRecordList(ThQuotaRecord record,
			PageHelper ph);
	
	public Long getCountOfQuotaRecordList(ThQuotaRecord record);
	
	public List<Map<String, Object>> getQuotaRecordAndQuotaList(Map<String, Object> params,
			PageHelper ph);
	
	public Long getCountOfQuotaRecordAndQuotaList(Map<String, Object> params);
	
	public Integer updateById(ThQuotaRecord record);
	
	public Integer deleteById(ThQuotaRecord record);
	
	public Serializable add(ThQuotaRecord record);
	
	public List<ThQuotaRecord> getQuotaRecordMaxCount(ThQuotaRecord record);
	
	public List<Map<String, Object>> getQuotaRecordStatisticalAnalysis(Map<String, Object> params,String StatisticType,List<String> fieldList,List<String> categoryList);
	
	public List<Map<String, Object>> getNationList(Map<String, Object> params);
}
