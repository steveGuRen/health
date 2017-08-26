package com.health.dao;

import java.util.List;
import java.util.Map;

import com.health.model.ThDocument;
import com.health.utils.PageHelper;

public interface ThDocumentDao extends BaseDaoI<ThDocument>{
	
	public List<ThDocument> getDocumentAndQuotaList(ThDocument document,
			PageHelper ph);
	
	public Long getCountOfDocumentAndQuotaList(ThDocument document);
	
	public Integer updateById(ThDocument document);
	
	public Integer deleteById(ThDocument document);
}
