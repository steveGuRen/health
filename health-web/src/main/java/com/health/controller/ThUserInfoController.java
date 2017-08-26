package com.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThHistoryMedical;
import com.health.model.ThUserInfo;
import com.health.service.ThUserInfoService;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
@RequestMapping("/")
public class ThUserInfoController {

	@Autowired
	ThUserInfoService thUserInfoService;
	
	@RequestMapping("/userInfo/add")
	public String historyMedicalAdd(ThUserInfo item) {
		Map<String, Object> result = thUserInfoService.saveUserInfo(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/userInfo/update")
	public String historyMedicalUpdate(ThUserInfo item) {
		Map<String, Object> result = thUserInfoService.updateUserInfo(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/userInfo/query")
	public String historyMedicalQuery(ThUserInfo item, PageHelper ph) {
		Map<String, Object> result = thUserInfoService.queryUserInfo(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
}
