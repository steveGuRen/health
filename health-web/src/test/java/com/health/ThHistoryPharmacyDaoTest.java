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
import com.health.dao.ThHistoryPharmacyDao;
import com.health.model.ThHistoryPharmacy;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class ThHistoryPharmacyDaoTest {

	@Autowired
	ThHistoryPharmacyDao dao;
	
	@Transactional
	@Rollback(false)
	@Test
	public void testInsert() {
		ThHistoryPharmacy item = new ThHistoryPharmacy();
		item.setId("123");
		item.setMedicalName("medicalName");
		item.setWay("way");
		item.setDosage("dosage");
		item.setDrugDependence("drugDependence");
		item.setMedicationTime("medicationTime");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		Serializable id = dao.save(item);
		assertNotNull(id);
		
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQuery() { 
		ThHistoryPharmacy item = new ThHistoryPharmacy();
		item.setId("123");
		item.setMedicalName("medicalName");
		item.setWay("way");
		item.setDosage("dosage");
		item.setDrugDependence("drugDependence");
		item.setMedicationTime("medicationTime");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(10);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.getList(item, ph)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQuery2() {
		ThHistoryPharmacy item = new ThHistoryPharmacy();
		item.setId("123");
		item.setMedicalName("medicalName");
		item.setWay("way");
		item.setDosage("dosage");
		item.setDrugDependence("drugDependence");
		item.setMedicationTime("medicationTime");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(10);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.getObjects(item, ph)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQueryCount() {
		ThHistoryPharmacy item = new ThHistoryPharmacy();
		item.setId("123");
		item.setMedicalName("medicalName");
		item.setWay("way");
		item.setDosage("dosage");
		item.setDrugDependence("drugDependence");
		item.setMedicationTime("medicationTime");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		PageHelper ph = new PageHelper();
		ph.setPage(1);
		ph.setRows(10);
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.getListCount(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testQuery3() {
		ThHistoryPharmacy item = new ThHistoryPharmacy();
		item.setId("123");
		item.setMedicalName("medicalName");
		item.setWay("way");
		item.setDosage("dosage");
		item.setDrugDependence("drugDependence");
		item.setMedicationTime("medicationTime");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.get(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
	
	@Transactional
	@Rollback(false)
	@Test
	public void testUpdate() {
		ThHistoryPharmacy item = new ThHistoryPharmacy();
		item.setId("123");
		item.setMedicalName("medicalName");
		item.setWay("way");
		item.setDosage("dosage");
		item.setDrugDependence("drugDependence");
		item.setMedicationTime("medicationTime");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.updateById(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
}
