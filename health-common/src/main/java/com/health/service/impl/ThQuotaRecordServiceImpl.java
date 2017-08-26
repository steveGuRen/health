package com.health.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThQuotaRecordDao;
import com.health.model.ThQuotaRecord;
import com.health.service.ThQuotaRecordService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThQuotaRecordServiceImpl implements ThQuotaRecordService {

	@Autowired
	ThQuotaRecordDao recordDao;
	
	@Override
	public List<ThQuotaRecord> getQuotaRecordList(ThQuotaRecord record, PageHelper ph) {
		// TODO Auto-generated method stub
		return recordDao.getQuotaRecordList(record, ph);
	}

	@Override
	public Long getCountOfQuotaRecordList(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		return recordDao.getCountOfQuotaRecordList(record);
	}

	@Override
	public List<Map<String, Object>> getQuotaRecordAndQuotaList(Map<String, Object> params, PageHelper ph) {
		// TODO Auto-generated method stub
		return recordDao.getQuotaRecordAndQuotaList(params, ph);
	}

	@Override
	public Long getCountOfQuotaRecordAndQuotaList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return recordDao.getCountOfQuotaRecordAndQuotaList(params);
	}

	@Override
	public Integer updateById(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		Date date = new Date();
		record.setUpdateTime(date);
		return recordDao.updateById(record);
	}

	@Override
	public Integer deleteById(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		return recordDao.deleteById(record);
	}

	@Override
	public Serializable add(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		Date date = new Date();
		record.setCreateTime(date);
		record.setUpdateTime(date);
		return recordDao.save(record);
	}
	
	@Override
	public List<ThQuotaRecord> getQuotaRecordMaxCount(ThQuotaRecord record) {
		// TODO Auto-generated method stub
		PageHelper ph = new PageHelper();
		ph.setOrder("desc");
		ph.setSort("count");
		return recordDao.getQuotaRecordMaxCount(record, ph);
	}

	@Override
	public List<Map<String, Object>> getQuotaRecordStatisticalAnalysis(Map<String, Object> params,String StatisticType,List<String> fieldList,List<String> categoryList) {
		// TODO Auto-generated method stub
		return recordDao.getQuotaRecordStatisticalAnalysis(params, StatisticType, fieldList, categoryList);
	}

	@Override
	public List<Map<String, Object>> getNationList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return recordDao.getNationList(params);
	}

}
