package com.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.model.ThHistoryDisease;
import com.health.model.ThHistoryHospitalized;
import com.health.model.ThHistoryImmunization;
import com.health.model.ThHistoryInjury;
import com.health.model.ThHistoryMedical;
import com.health.model.ThHistoryOperation;
import com.health.model.ThHistoryPharmacy;
import com.health.model.ThHistoryTransfusion;
import com.health.service.ThHistoryService;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RestController
@RequestMapping("/")
public class ThHistoryController {
	
	@Autowired
	ThHistoryService thHistoryService;
	
	/* 家族史、遗传病史、残疾情况、过敏史添加  */
	@RequestMapping("/historymedical/add")
	public String historyMedicalAdd(ThHistoryMedical item) {
		Map<String, Object> result = thHistoryService.saveHistoryMedical(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historymedical/update")
	public String historyMedicalUpdate(ThHistoryMedical item) {
		Map<String, Object> result = thHistoryService.updateHistoryMedical(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historymedical/query")
	public String historyMedicalQuery(ThHistoryMedical item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryMedical(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	/* 4.5.1	疾病史 */
	@RequestMapping("/historyDisease/add")
	public String historyDiseaseAdd(ThHistoryDisease item) {
		Map<String, Object> result = thHistoryService.saveHistoryDisease(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyDisease/update")
	public String historyDiseaseUpdate(ThHistoryDisease item) {
		Map<String, Object> result = thHistoryService.updateHistoryDisease(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyDisease/query")
	public String historyDiseaseQuery(ThHistoryDisease item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryDisease(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	/*4.6	住院史*/
	@RequestMapping("/historyHospitalized/add")
	public String historyHospitalizedAdd(ThHistoryHospitalized item) {
		Map<String, Object> result = thHistoryService.saveHistoryHospitalized(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyHospitalized/update")
	public String historyHospitalizedUpdate(ThHistoryHospitalized item) {
		Map<String, Object> result = thHistoryService.updateHistoryHospitalized(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyHospitalized/query")
	public String historyHospitalizedQuery(ThHistoryHospitalized item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryHospitalized(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	/*4.7	非免疫预防接种史*/
	@RequestMapping("/historyImmunization/add")
	public String historyImmunizationAdd(ThHistoryImmunization item) {
		Map<String, Object> result = thHistoryService.saveHistoryImmunization(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyImmunization/update")
	public String historyImmunizationUpdate(ThHistoryImmunization item) {
		Map<String, Object> result = thHistoryService.updateHistoryImmunization(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyImmunization/query")
	public String historyImmunizationQuery(ThHistoryImmunization item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryImmunization(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	
	/*4.5.8	外伤史*/
	@RequestMapping("/historyInjury/add")
	public String historyInjuryAdd(ThHistoryInjury item) {
		Map<String, Object> result = thHistoryService.saveHistoryInjury(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyInjury/update")
	public String historyInjuryUpdate(ThHistoryInjury item) {
		Map<String, Object> result = thHistoryService.updateHistoryInjury(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyInjury/query")
	public String historyInjuryQuery(ThHistoryInjury item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryInjury(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	/*4.5.4	手术史*/
	@RequestMapping("/historyOperation/add")
	public String historyOperationAdd(ThHistoryOperation item) {
		Map<String, Object> result = thHistoryService.saveHistoryOperation(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyOperation/update")
	public String historyOperationUpdate(ThHistoryOperation item) {
		Map<String, Object> result = thHistoryService.updateHistoryOperation(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyOperation/query")
	public String historyOperationQuery(ThHistoryOperation item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryOperation(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	/*4.8	主要用药*/
	@RequestMapping("/historyPharmacy/add")
	public String historyPharmacyAdd(ThHistoryPharmacy item) {
		Map<String, Object> result = thHistoryService.saveHistoryPharmacy(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyPharmacy/update")
	public String historyPharmacyUpdate(ThHistoryPharmacy item) {
		Map<String, Object> result = thHistoryService.updateHistoryPharmacy(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyPharmacy/query")
	public String historyPharmacyQuery(ThHistoryPharmacy item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryPharmacy(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	
	/*4.5.10	输血史*/
	@RequestMapping("/historyTransfusion/add")
	public String historyTransfusionAdd(ThHistoryTransfusion item) {
		Map<String, Object> result = thHistoryService.saveHistoryTransfusion(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyTransfusion/update")
	public String historyTransfusionUpdate(ThHistoryTransfusion item) {
		Map<String, Object> result = thHistoryService.updateHistoryTransfusion(item);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/historyTransfusion/query")
	public String historyTransfusionQuery(ThHistoryTransfusion item, PageHelper ph) {
		Map<String, Object> result = thHistoryService.queryHistoryTransfusion(item, ph);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", result),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	
	
}
