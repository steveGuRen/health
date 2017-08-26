package com.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThNotification;
import com.health.service.ThNotificationService;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
@RequestMapping("/")
public class ThNotificationController {
	
	@Autowired
	ThNotificationService notificationService;
	
	@RequestMapping("/notification/query")
	public String notificatinQuery(ThNotification item, PageHelper ph) {
		Map<String, Object> result = notificationService.queryNotifications(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/notification/add")
	public String notificationAdd(ThNotification item) {
		Map<String, Object> result = notificationService.save(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/notification/update")
	public String notificationUpdate(ThNotification item) {
		Map<String, Object> result = notificationService.updateNotification(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/notification/del")
	public String notificationDel(ThNotification item) {
		Map<String, Object> result = notificationService.delNotification(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
}
