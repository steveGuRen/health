package com.health.service;

import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.health.HealthWebApplication;
import com.health.model.ThHistoryMedical;
import com.health.model.ThNotification;
import com.health.model.ThQuotaRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
public class NotificationServiceTest {
	@Autowired
	GraphService service;
	
	@Test
	@Rollback(true)
	public void test() {
		ThQuotaRecord item = new ThQuotaRecord();
		service.getAVGs();
	}
}
