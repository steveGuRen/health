package com.health.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.health.model.ThDocument;
import com.health.utils.PageHelper;

public interface ThDocumentService {

	public List<ThDocument> getDocumentAndQuotaList(ThDocument document,
			PageHelper ph);
	
	public Long getCountOfDocumentAndQuotaList(ThDocument document);
	
	public Integer updateById(ThDocument document);
	
	public Integer deleteById(ThDocument document);
	
	public Serializable add(ThDocument document);
}
