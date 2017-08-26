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
import com.health.dao.ThHistoryImmunizationDao;
import com.health.model.ThHistoryImmunization;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class ThHistoryImmunizationDaoTest {

	@Autowired
	ThHistoryImmunizationDao dao;
	
	@Transactional
	@Rollback(false)
	@Test
	public void testInsert() {
		ThHistoryImmunization item = new ThHistoryImmunization();
		item.setId("123");
		item.setImmunizationName("immunizationName");
		item.setImmunizationDate(new Date());
		item.setImmunizationInstitution("immunizationInstitution");
		
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
		ThHistoryImmunization item = new ThHistoryImmunization();
		item.setId("123");
		item.setImmunizationName("immunizationName");
		item.setImmunizationDate(new Date());
		item.setImmunizationInstitution("immunizationInstitution");
		
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
		ThHistoryImmunization item = new ThHistoryImmunization();
		item.setId("123");
		item.setImmunizationName("immunizationName");
		item.setImmunizationDate(new Date());
		item.setImmunizationInstitution("immunizationInstitution");
		
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
		ThHistoryImmunization item = new ThHistoryImmunization();
		item.setId("123");
		item.setImmunizationName("immunizationName");
		item.setImmunizationDate(new Date());
		item.setImmunizationInstitution("immunizationInstitution");
		
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
		ThHistoryImmunization item = new ThHistoryImmunization();
		item.setId("123");
		item.setImmunizationName("immunizationName");
		item.setImmunizationDate(new Date());
		item.setImmunizationInstitution("immunizationInstitution");
		
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
		ThHistoryImmunization item = new ThHistoryImmunization();
		item.setId("123");
		item.setImmunizationName("immunizationName");
		item.setImmunizationDate(new Date());
		item.setImmunizationInstitution("immunizationInstitution");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.updateById(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
}
