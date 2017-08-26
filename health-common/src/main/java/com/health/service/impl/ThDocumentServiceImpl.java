package com.health.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThDocumentDao;
import com.health.model.ThDocument;
import com.health.service.ThDocumentService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThDocumentServiceImpl implements ThDocumentService {

	@Autowired
	ThDocumentDao documentDao;
	
	@Override
	public List<ThDocument> getDocumentAndQuotaList(ThDocument document, PageHelper ph) {
		// TODO Auto-generated method stub
		return documentDao.getDocumentAndQuotaList(document, ph);
	}

	@Override
	public Long getCountOfDocumentAndQuotaList(ThDocument document) {
		// TODO Auto-generated method stub
		return documentDao.getCountOfDocumentAndQuotaList(document);
	}

	@Override
	public Integer updateById(ThDocument document) {
		// TODO Auto-generated method stub
		Date date = new Date();
		document.setUpdateTime(date);
		return documentDao.updateById(document);
	}

	@Override
	public Integer deleteById(ThDocument document) {
		// TODO Auto-generated method stub
		return documentDao.deleteById(document);
	}

	@Override
	public Serializable add(ThDocument document) {
		// TODO Auto-generated method stub
		Date date = new Date();
		document.setCreateTime(date);
		document.setUpdateTime(date);
		return documentDao.save(document);
	}

}
