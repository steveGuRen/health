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
import com.health.dao.ThHistoryHospitalizedDao;
import com.health.model.ThHistoryHospitalized;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class ThHistoryHospitalizedDaoTest {

	@Autowired
	ThHistoryHospitalizedDao dao;
	
	@Transactional
	@Rollback(false)
	@Test
	public void testInsert() {
		ThHistoryHospitalized item = new ThHistoryHospitalized();
		item.setId("123");
		item.setPatientId("patientId");
		item.setInstitution("institution");
		item.setCause("cause");
		item.setHospitalInTime(new Date());
		item.setHospitalOutTime(new Date());
		item.setBedId("bedId");
		item.setBedInstitution("bedInstitution");
		
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
		ThHistoryHospitalized item = new ThHistoryHospitalized();
		item.setId("123");
		item.setPatientId("patientId");
		item.setInstitution("institution");
		item.setCause("cause");
		item.setHospitalInTime(new Date());
		item.setHospitalOutTime(new Date());
		item.setBedId("bedId");
		item.setBedInstitution("bedInstitution");
		
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
		ThHistoryHospitalized item = new ThHistoryHospitalized();
		item.setId("123");
		item.setPatientId("patientId");
		item.setInstitution("institution");
		item.setCause("cause");
		item.setHospitalInTime(new Date());
		item.setHospitalOutTime(new Date());
		item.setBedId("bedId");
		item.setBedInstitution("bedInstitution");
		
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
		ThHistoryHospitalized item = new ThHistoryHospitalized();
		item.setId("123");
		item.setPatientId("patientId");
		item.setInstitution("institution");
		item.setCause("cause");
		item.setHospitalInTime(new Date());
		item.setHospitalOutTime(new Date());
		item.setBedId("bedId");
		item.setBedInstitution("bedInstitution");
		
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
		ThHistoryHospitalized item = new ThHistoryHospitalized();
		item.setId("123");
		item.setPatientId("patientId");
		item.setInstitution("institution");
		item.setCause("cause");
		item.setHospitalInTime(new Date());
		item.setHospitalOutTime(new Date());
		item.setBedId("bedId");
		item.setBedInstitution("bedInstitution");
		
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
		ThHistoryHospitalized item = new ThHistoryHospitalized();
		item.setId("123");
		item.setPatientId("patientId");
		item.setInstitution("institution");
		item.setCause("cause");
		item.setHospitalInTime(new Date());
		item.setHospitalOutTime(new Date());
		item.setBedId("bedId");
		item.setBedInstitution("bedInstitution");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.updateById(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
}
