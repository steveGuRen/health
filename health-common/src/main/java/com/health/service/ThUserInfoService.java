package com.health.service;

import java.util.Map;

import com.health.model.ThUserInfo;
import com.health.utils.PageHelper;

public interface ThUserInfoService {
	
	public Map<String, Object> saveUserInfo(ThUserInfo item);
	
	public Map<String, Object> updateUserInfo(ThUserInfo item);
	
	public Map<String, Object> queryUserInfo(ThUserInfo item, PageHelper ph);
	
}
