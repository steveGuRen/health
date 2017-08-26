package com.health.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.health.HealthWebApplication;
import com.health.utils.QuotaResultCalculation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class ThQuotaRecordServiceTest {
	

	@Autowired
	ThQuotaRecordService service;
	
	
	@Rollback(false)
	@Test
	public void tests() {
		
		String result = QuotaResultCalculation.getResult(24, 1, 0, 2, "舒张压", 60,"正常");
		System.out.println(result);
	}
	
//	@Rollback(false)
//	@Test
//	public void tests() {
//		
//		
//		List<ThQuotaRecord> list = service.getQuotaRecordMaxCount(new ThQuotaRecord());
//		System.out.println(list.get(0).toString());
//	}
	
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		ThQuotaRecord record = new ThQuotaRecord();
//		record.setDevice("体温计");
//		record.setQuotaId(2);
//		record.setValue(36.8d);
//		record.setResult("度");
//		record.setUnit("kg");
//		record.setStatus(1);
//		record.setCreateUser("秦召红");
//		service.add(record);
//	}
	
//	@Rollback(false)
//	@Test
//	public void testupdate() {
//		ThQuotaRecord record = new ThQuotaRecord();
//		record.setQuotaRecordId(2);
////		record.setDevice("体温计");
////		record.setQuotaId(2);
//		record.setValue(300d);
////		record.setResult("度");
//		record.setUnit("");
//		record.setStatus(1);
//		record.setCreateUser("秦召红");
//		service.updateById(record);
//	}
	
//	@Rollback(false)
//	@Test
//	public void testget() {
//		ThQuotaRecord record = new ThQuotaRecord();
//		List<ThQuotaRecord> list = new ArrayList<ThQuotaRecord>();
//		list = service.getQuotaRecordList(record, new PageHelper());
//		Long num = service.getCountOfQuotaRecordList(record);
//		System.out.println(list.size()+"  "+num);
//	}
	
//	@Rollback(false)
//	@Test
//	public void testget() {
//		ThQuotaRecord record = new ThQuotaRecord();
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("quotaRecordId", 3);
//		list = service.getQuotaRecordAndQuotaList(map, new PageHelper());
//		Long num = service.getCountOfQuotaRecordAndQuotaList(map);
//		System.out.println(list.size()+"  "+num);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
//	}
	
//	@Rollback(false)
//	@Test
//	public void testdelete() {
//		ThQuotaRecord record = new ThQuotaRecord();
//		record.setQuotaRecordId(4);
//		service.deleteById(record);
//		
////		System.out.println(list.size());
//	}
}
