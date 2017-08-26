package com.health.service;

import java.util.Map;

import com.health.model.ThGraphTemp;
import com.health.utils.PageHelper;

public interface ThGraphTempService {

	public Map<String, Object> saveThGraphTemp(ThGraphTemp item);

	public Map<String, Object> updateThGraphTemp(ThGraphTemp item);

	public Map<String, Object> queryThGraphTemp(ThGraphTemp item, PageHelper ph);
}
