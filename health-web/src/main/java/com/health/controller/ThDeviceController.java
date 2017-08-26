package com.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThDevice;
import com.health.service.ThDeviceService;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
@RequestMapping("/")
public class ThDeviceController {
	@Autowired
	ThDeviceService thDeviceService;
	
	@RequestMapping("/device/add")
	public String historyMedicalAdd(ThDevice item) {
		Map<String, Object> result = thDeviceService.saveDevice(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/device/update")
	public String historyMedicalUpdate(ThDevice item) {
		Map<String, Object> result = thDeviceService.updateDevice(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/device/query")
	public String historyMedicalQuery(ThDevice item, PageHelper ph) {
		Map<String, Object> result = thDeviceService.queryDevice(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
}
