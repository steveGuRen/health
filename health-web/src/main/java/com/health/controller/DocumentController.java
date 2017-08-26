package com.health.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThDocument;
import com.health.model.ThDocumentQuota;
import com.health.service.ThDocumentQuotaService;
import com.health.service.ThDocumentService;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
@RequestMapping("/")
public class DocumentController {
	
	private static Logger log = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	ThDocumentQuotaService documentQuotaService;
	@Autowired
	ThDocumentService documentService;
	
	@RequestMapping("/document/list")
	public String getDocumentList(ThDocument document,PageHelper ph) {
		List<ThDocument> documentlist = new ArrayList<ThDocument>();
		documentlist = documentService.getDocumentAndQuotaList(document, ph);
		Long count = documentService.getCountOfDocumentAndQuotaList(document);
		JSONObject jo = new JSONObject();
		jo.put("documentlist", documentlist);
		jo.put("count", count);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/document/add")
	public String addDocument(ThDocument document,PageHelper ph){
		JSONObject jo = new JSONObject();
		Integer id = null;
		id = (Integer) documentService.add(document);
		if(id == null){
			log.error("添加档案失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		jo.put("id", id);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/document/update")
	public String updateDocument(ThDocument document){
		JSONObject jo = new JSONObject();
		Integer id = null;
		id = documentService.updateById(document);
		if(id == 0){
			log.error("修改档案失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		jo.put("id", id);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/document/delete")
	public String deleteDocument(HttpServletRequest request){
		String idList = request.getParameter("idList");
		List<Integer> ids = new ArrayList<Integer>();
		if(StringUtils.isNotBlank(idList)){
			ids = JSON.parseObject(idList, new TypeReference<List<Integer>>(){});
		}
		JSONObject jo = new JSONObject();
		ThDocument document = new ThDocument();
		int count = 0;
		if(ids.size() > 0){
			for(Integer i : ids){
				document.setDocumentId(i);
				Integer id = null;
				id = documentService.deleteById(document);
				if(id != 0 && id != null){
					count++;
				}
			}
		}
		jo.put("count", count);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/documentquota/add")
	public String addDocumentQuota(ThDocumentQuota documentQuota){
		JSONObject jo = new JSONObject();
		Integer id = null;
		id = (Integer) documentQuotaService.add(documentQuota);
		if(id == 0){
			log.error("添加档案指标失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		jo.put("id", id);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/documentquota/delete")
	public String deleteDocumentQuota(ThDocumentQuota documentQuota){
		JSONObject jo = new JSONObject();
		Integer id = null;
		id = documentQuotaService.deleteById(documentQuota);
		if(id == 0){
			log.error("删除档案指标失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		jo.put("id", id);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	
}



