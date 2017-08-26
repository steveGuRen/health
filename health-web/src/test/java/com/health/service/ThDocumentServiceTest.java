package com.health.service;

import java.io.Serializable;
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
import com.health.dao.ThDocumentDao;
import com.health.model.ThDocument;
import com.health.model.ThDocumentQuota;
import com.health.utils.PageHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class ThDocumentServiceTest {
	
	@Autowired
	ThDocumentService dservice;
	@Autowired
	ThDocumentQuotaService qservice;
	
	@Rollback(false)
	@Test
	public void testlist() {
		ThDocumentQuota documentQuota = new ThDocumentQuota();
		documentQuota.setDocumentId(2);
		documentQuota.setQuotaName("尿检");
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list = qservice.getDocumentQuotaList(documentQuota, new PageHelper());
		Long count = qservice.getCountOfDocumentQuotaList(documentQuota);
		System.out.println(count);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
	}
	

//	@Rollback(false)
//	@Test
//	public void testadd() {
//		ThDocumentQuota dq = new ThDocumentQuota();
//		dq.setDocumentId(2);
//		dq.setQuotaName("体温");
//		dq.setQuotaRecordId(3);
//		dq.setCreateUser("qin");
//		
//		Serializable id = qservice.add(dq);
//		System.out.println(id);
////		System.out.println(list.toString());
//	}
	
//	@Rollback(false)
//	@Test
//	public void testupdate() {
//		ThDocumentQuota dq = new ThDocumentQuota();
//		dq.setDocumentQuotaId(7);
//		Integer id = qservice.deleteById(dq);
//		System.out.println(id);
//	}
	
}
