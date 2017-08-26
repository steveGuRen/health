package com.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThGraphTemp;
import com.health.service.ThGraphTempService;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
@RequestMapping("/")
public class ThGraphTempController {
	@Autowired
	ThGraphTempService ThGraphTempService;
	
	@RequestMapping("/thGraphTemp/add")
	public String ThGraphTempAdd(ThGraphTemp item) {
		Map<String, Object> result = ThGraphTempService.saveThGraphTemp(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "???", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/thGraphTemp/update")
	public String ThGraphTempUpdate(ThGraphTemp item) {
		Map<String, Object> result = ThGraphTempService.updateThGraphTemp(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "???", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/thGraphTemp/query")
	public String ThGraphTempQuery(ThGraphTemp item, PageHelper ph) {
		Map<String, Object> result = ThGraphTempService.queryThGraphTemp(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "???", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
}
