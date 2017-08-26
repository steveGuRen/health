package com.health.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThQuotaDao;
import com.health.model.ThQuota;
import com.health.service.ThQuotaService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThQuotaServiceImpl implements ThQuotaService{

	@Autowired
	ThQuotaDao quotaDao;
	
	@Override
	public List<Map<String, Object>> getQuotaNameList(ThQuota quota) {
		// TODO Auto-generated method stub
		return quotaDao.getQuotaNameList(quota, new PageHelper());
	}
	
	@Override
	public List<ThQuota> getQuotaList(ThQuota quota, PageHelper ph) {
		// TODO Auto-generated method stub
		return quotaDao.getQuotaList(quota, ph);
	}

	@Override
	public Long getCountOfQuotaList(ThQuota quota) {
		// TODO Auto-generated method stub
		return quotaDao.getCountOfQuotaList(quota);
	}

	@Override
	public Integer updateById(ThQuota quota) {
		// TODO Auto-generated method stub
		Date date = new Date();
		quota.setUpdateTime(date);
		return quotaDao.updateById(quota);
	}

	@Override
	public Integer deleteById(ThQuota quota) {
		// TODO Auto-generated method stub
		return quotaDao.deleteById(quota);
	}

	@Override
	public Serializable add(ThQuota quota) {
		// TODO Auto-generated method stub
		Date date = new Date();
		quota.setCreateTime(date);
		quota.setUpdateTime(date);
		return quotaDao.save(quota);
	}

}
