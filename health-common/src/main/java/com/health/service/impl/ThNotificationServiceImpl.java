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

import com.health.dao.ThNotificationDao;
import com.health.model.ThNotification;
import com.health.service.ThNotificationService;
import com.health.utils.PageHelper;

@Service
public class ThNotificationServiceImpl implements ThNotificationService {

	@Autowired
	ThNotificationDao notificationDao;
	
	@Transactional
	@Override
	public Map<String, Object> save(ThNotification item) {
		Map<String, Object> result = new HashMap<>();
		Serializable id = notificationDao.save(item);
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateNotification(ThNotification item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = notificationDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryNotifications(ThNotification item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = notificationDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = notificationDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> delNotification(ThNotification item) {
		// TODO Auto-generated method stub
		
		Map<String, Object> result = new HashMap<>();
		if(item.getNotificationId() == null) {
			result.put("log", "id为空，无法删除");
			return result;
		}
		notificationDao.delete(item);
		return result;
	}

}
