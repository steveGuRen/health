package com.health.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThGraphTempDao;
import com.health.model.ThGraphTemp;
import com.health.service.ThGraphTempService;
import com.health.utils.PageHelper;

@Service
public class ThGraphTempServiceImpl implements ThGraphTempService{
	@Autowired
	ThGraphTempDao dao;

	@Transactional
	@Override
	public Map<String, Object> saveThGraphTemp(ThGraphTemp item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = dao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateThGraphTemp(ThGraphTemp item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = dao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryThGraphTemp(ThGraphTemp item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = dao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = dao.getList(item, ph);
		result.put("list", list);
		return result;
	}
}
