package com.health;

import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.dao.ThNotificationDao;
import com.health.model.ThNotification;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class NotificationDaoTest {

	@Autowired
	ThNotificationDao NotificationDao;
	
	@Transactional
	@Test
	public void testInsert() {
		ThNotification notification = new ThNotification();
		notification.setAction("");
		notification.setActiveTime(60);
		notification.setContent("");
		notification.setContentType("1");
		Date currentTime = new Date();
		notification.setCreateTime(currentTime);
		notification.setUpdateTime(currentTime);
		notification.setCreateUser("");
		notification.setUpdateUser("");
		notification.setTemplateUrl("");
		notification.setTitle("");
		notification.setType("");
		notification.setUserId("");
		notification.setWeight(1);
		Serializable id = NotificationDao.save(notification);
		assertNotNull(id);
		
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQuery() {
		ThNotification item = new ThNotification();
		item.setNotificationId(2);
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(10);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				NotificationDao.getList(item, ph)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQuery2() {
		ThNotification item = new ThNotification();
		item.setNotificationId(1);
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(10);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				NotificationDao.getObjects(item, ph)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQueryCount() {
		ThNotification item = new ThNotification();
		item.setNotificationId(1);
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(10);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				NotificationDao.getListCount(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQuery3() {
		ThNotification item = new ThNotification();
		item.setNotificationId(1);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				NotificationDao.get(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testUpdate() {
		ThNotification item = new ThNotification();
		item.setNotificationId(1);
		item.setUpdateTime(new Date());
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				NotificationDao.updateById(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
}
