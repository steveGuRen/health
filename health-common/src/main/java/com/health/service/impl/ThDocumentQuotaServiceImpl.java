package com.health.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThDocumentQuotaDao;
import com.health.model.ThDocumentQuota;
import com.health.service.ThDocumentQuotaService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThDocumentQuotaServiceImpl implements ThDocumentQuotaService {

	@Autowired
	ThDocumentQuotaDao documentQuotaDao;
	
	@Override
	public Integer deleteById(ThDocumentQuota documentQuota) {
		// TODO Auto-generated method stub
		return documentQuotaDao.deleteById(documentQuota);
	}

	@Override
	public Serializable add(ThDocumentQuota documentQuota) {
		// TODO Auto-generated method stub
		Date date = new Date();
		documentQuota.setCreateTime(date);
		return documentQuotaDao.save(documentQuota);
	}

	@Override
	public List<Map<String, Object>> getDocumentQuotaList(ThDocumentQuota documentQuota, PageHelper ph) {
		// TODO Auto-generated method stub
		return documentQuotaDao.getDocumentQuotaList(documentQuota, ph);
	}

	@Override
	public Long getCountOfDocumentQuotaList(ThDocumentQuota documentQuota) {
		// TODO Auto-generated method stub
		return documentQuotaDao.getCountOfDocumentQuotaList(documentQuota);
	}

}
