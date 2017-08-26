package com.health.service;

import java.io.Serializable;
import java.util.Map;

import com.health.model.ThNotification;
import com.health.utils.PageHelper;

public interface ThNotificationService {
	
	public Map<String, Object> save(ThNotification item);
	
	public Map<String, Object> updateNotification(ThNotification item);
	
	public Map<String, Object> queryNotifications(ThNotification item, PageHelper ph);
	
	public Map<String, Object> delNotification(ThNotification item);
}
