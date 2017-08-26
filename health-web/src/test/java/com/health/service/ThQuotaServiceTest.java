package com.health.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.health.HealthWebApplication;
import com.health.model.ThQuota;
import com.health.utils.PageHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
public class ThQuotaServiceTest {

	@Autowired
	ThQuotaService service;
	
//	@Rollback(false)
//	@Test
//	public void testGet() {
//		ThQuota quota = new ThQuota();
//		quota.setQuotaName("尿检");
//		quota.setQuotaType(6);
//		quota.setSecondQuotaName("尿蛋白");
//		quota.setCreateUser("秦召红");
//		service.add(quota);
//	}
	
//	@Rollback(false)
//	@Test
//	public void testUpdate() {
//		ThQuota quota = new ThQuota();
//		quota.setQuotaId(3);
//		quota.setQuotaType(7);
//		quota.setUpdateUser("秦召红");
//		service.updateById(quota);
//	}
	
//	@Rollback(false)
//	@Test
//	public void testget() {
//		ThQuota quota = new ThQuota();
////		quota.setQuotaId(3);
////		quota.setQuotaType(7);
////		quota.setUpdateUser("秦召红");
//		List<ThQuota> list = new ArrayList<ThQuota>();
//		list = service.getQuotaList(quota, new PageHelper());
//		System.out.println(list.size()+ ":" +list.toString());
//	}
	
//	@Rollback(false)
//	@Test
//	public void testdelete() {
//		ThQuota quota = new ThQuota();
//		quota.setQuotaId(4);
//		service.deleteById(quota);
////		System.out.println(list.size()+ ":" +list.toString());
//	}
	
	@Test
	public void testdelete() {
		int a = 1;
		int b = 7;
		System.out.println(a/b);
		System.out.println(((double)a)/((double)b));
		System.out.println(((double)a)/b);
	}
}
