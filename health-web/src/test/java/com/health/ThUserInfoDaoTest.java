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
import com.health.dao.ThUserInfoDao;
import com.health.model.ThUserInfo;
import com.health.utils.PageHelper;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class ThUserInfoDaoTest {

	@Autowired
	ThUserInfoDao dao;
	
	@Transactional
	@Rollback(false)
	@Test
	public void testInsert() {
		ThUserInfo item = new ThUserInfo();
		item.setId("123");
		item.setHeadPortrait("/usr/local/");
		item.setNationality("中国");
		item.setVillage("深圳市学苑大道");
		item.setNation("深圳");
		item.setWeight("110");
		item.setBloodType("A型");
		item.setEducation("本科");
		item.setResidentType("常住");
		item.setEmergencyContact("18825193587");
		item.setWorkUnit("中科");
		item.setGender("男");
		item.setBirthday(new Date());
		item.setNativePlace("广东");
		item.setNeighborhoodCommittee("崇文花园居委会");
		item.setHeight("178");
		item.setStep("30");
		item.setRh("rh");
		item.setMaritalStatus("未婚");
		item.setAddress("崇文");
		item.setEmergencyPerson("紧急联系人");
		item.setOccupation("码农");
		
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
		ThUserInfo item = new ThUserInfo();
		item.setId("123");
		item.setHeadPortrait("/usr/local/");
		item.setNationality("中国");
		item.setVillage("深圳市学苑大道");
		item.setNation("深圳");
		item.setWeight("110");
		item.setBloodType("A型");
		item.setEducation("本科");
		item.setResidentType("常住");
		item.setEmergencyContact("18825193587");
		item.setWorkUnit("中科");
		item.setGender("男");
		item.setBirthday(new Date());
		item.setNativePlace("广东");
		item.setNeighborhoodCommittee("崇文花园居委会");
		item.setHeight("178");
		item.setStep("30");
		item.setRh("rh");
		item.setMaritalStatus("未婚");
		item.setAddress("崇文");
		item.setEmergencyPerson("紧急联系人");
		item.setOccupation("码农");
		
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
		ThUserInfo item = new ThUserInfo();
		item.setId("123");
		item.setHeadPortrait("/usr/local/");
		item.setNationality("中国");
		item.setVillage("深圳市学苑大道");
		item.setNation("深圳");
		item.setWeight("110");
		item.setBloodType("A型");
		item.setEducation("本科");
		item.setResidentType("常住");
		item.setEmergencyContact("18825193587");
		item.setWorkUnit("中科");
		item.setGender("男");
		item.setBirthday(new Date());
		item.setNativePlace("广东");
		item.setNeighborhoodCommittee("崇文花园居委会");
		item.setHeight("178");
		item.setStep("30");
		item.setRh("rh");
		item.setMaritalStatus("未婚");
		item.setAddress("崇文");
		item.setEmergencyPerson("紧急联系人");
		item.setOccupation("码农");
		
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
		ThUserInfo item = new ThUserInfo();
		item.setId("123");
		item.setHeadPortrait("/usr/local/");
		item.setNationality("中国");
		item.setVillage("深圳市学苑大道");
		item.setNation("深圳");
		item.setWeight("110");
		item.setBloodType("A型");
		item.setEducation("本科");
		item.setResidentType("常住");
		item.setEmergencyContact("18825193587");
		item.setWorkUnit("中科");
		item.setGender("男");
		item.setBirthday(new Date());
		item.setNativePlace("广东");
		item.setNeighborhoodCommittee("崇文花园居委会");
		item.setHeight("178");
		item.setStep("30");
		item.setRh("rh");
		item.setMaritalStatus("未婚");
		item.setAddress("崇文");
		item.setEmergencyPerson("紧急联系人");
		item.setOccupation("码农");
		
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
		ThUserInfo item = new ThUserInfo();
		item.setId("123");
		item.setHeadPortrait("/usr/local/");
		item.setNationality("中国");
		item.setVillage("深圳市学苑大道");
		item.setNation("深圳");
		item.setWeight("110");
		item.setBloodType("A型");
		item.setEducation("本科");
		item.setResidentType("常住");
		item.setEmergencyContact("18825193587");
		item.setWorkUnit("中科");
		item.setGender("男");
		item.setBirthday(new Date());
		item.setNativePlace("广东");
		item.setNeighborhoodCommittee("崇文花园居委会");
		item.setHeight("178");
		item.setStep("30");
		item.setRh("rh");
		item.setMaritalStatus("未婚");
		item.setAddress("崇文");
		item.setEmergencyPerson("紧急联系人");
		item.setOccupation("码农");
		
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
		ThUserInfo item = new ThUserInfo();
		item.setId("123");
		item.setHeadPortrait("/usr/local/");
		item.setNationality("中国");
		item.setVillage("深圳市学苑大道");
		item.setNation("深圳");
		item.setWeight("110");
		item.setBloodType("A型");
		item.setEducation("本科");
		item.setResidentType("常住");
		item.setEmergencyContact("18825193587");
		item.setWorkUnit("中科");
		item.setGender("男");
		item.setBirthday(new Date());
		item.setNativePlace("广东");
		item.setNeighborhoodCommittee("崇文花园居委会");
		item.setHeight("178");
		item.setStep("30");
		item.setRh("rh");
		item.setMaritalStatus("未婚");
		item.setAddress("崇文");
		item.setEmergencyPerson("紧急联系人");
		item.setOccupation("码农");
		
		item.setUserId("test-userId");
		item.setCreateTime(new Date());
		item.setUpdateTime(new Date());
		item.setCreateUser("test-userId");
		item.setUpdateUser("test-userId");
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", 
				dao.updateById(item)),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat));
	}
}
