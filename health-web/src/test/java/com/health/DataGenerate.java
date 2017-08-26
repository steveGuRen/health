package com.health;

import java.text.DecimalFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.health.dao.ThUserInfoDao;
import com.health.model.ThQuotaRecord;
import com.health.model.ThUser;
import com.health.service.ThQuotaRecordService;
import com.health.service.ThUserAddressService;
import com.health.service.ThUserInfoService;
import com.health.service.ThUserService;
import com.health.utils.PageHelper;
import com.health.utils.QuotaResultCalculation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
@Transactional
public class DataGenerate {

	@Autowired
	ThUserService userService;
	@Autowired
	ThUserInfoService userInfoService;
	@Autowired
	ThUserAddressService userAddressService;
	@Autowired
	ThQuotaRecordService quotaRecordService;
	@Autowired
	ThUserInfoDao userInfoDao;

	//尿检
//		@Rollback(false)
//		@Test
//		public void testadd() {
//			List<ThUserInfo> list = userInfoDao.getObjects(new ThUserInfo(), new PageHelper());
//			String [] genders = {"男","女"};
//			for(int i=0; i<list.size(); i++){
//				ThUserInfo user = new ThUserInfo();
//				user.setId(list.get(i).getId());
//				int gender = getRandomValue(2,0);
//				String g = genders[gender];
//				user.setGender(g);
//				userInfoDao.updateById(user);
//			}
////			System.out.println(list.size());
//		}
	
//	//尿检
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.0");
//		DecimalFormat df3 = new DecimalFormat("0.000");
//		DecimalFormat df5 = new DecimalFormat("0.00");
//		String[] jiance = {"阴性","阳性"};
//		String[] yanse = {"浅黄色","深黄色"};
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
//			int situation = 0;
//			double shu = Double.parseDouble(df.format(getRandomValue(100, 50) + Math.random()));
//			double shou = Double.parseDouble(df.format(getRandomValue(170, 80) + Math.random()));
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
////			1尿白细胞(U—LEU) 正常参考值：<5个/HP
//			double value1 = Double.parseDouble(df.format(getRandomValue(10, 0) + Math.random()));
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("尿检");
//			record.setSecondQuotaName("尿白细胞");
//			record.setQuotaType(7);
//			record.setValue(value1);
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(record.getUserAge(), record.getGender(), situation, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
////			2尿胆原(URO或UBG) <16
//			double value2 = Double.parseDouble(df.format(getRandomValue(30, 0) + Math.random()));
//			ThQuotaRecord record2 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record2);
//			record2.setSecondQuotaName("尿胆原");
//			record2.setValue(value2);
//			String result2 = QuotaResultCalculation.getResult(record2.getUserAge(), record2.getGender(), situation, record2.getQuotaType(), record2.getSecondQuotaName(), record2.getValue(),record2.getResult());
//			record2.setResult(result2);
//			quotaRecordService.add(record2);
////			3尿比重(SG)  1.015－1.025
//			double value3 = Double.parseDouble(df3.format(getRandomValue(33, 8)/10000 + 1));
//			ThQuotaRecord record3 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record3);
//			record3.setSecondQuotaName("尿比重");
//			record3.setValue(value3);
//			String result3 = QuotaResultCalculation.getResult(record3.getUserAge(), record3.getGender(), situation, record3.getQuotaType(), record3.getSecondQuotaName(), record3.getValue(),record3.getResult());
//			record3.setResult(result3);
//			quotaRecordService.add(record3);
////			4尿酸碱度  4.6~8.0（平均值6.0）
//			double value4 = Double.parseDouble(df.format(getRandomValue(10, 0) + Math.random()));
//			ThQuotaRecord record4 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record4);
//			record4.setSecondQuotaName("尿比重");
//			record4.setValue(value4);
//			String result4 = QuotaResultCalculation.getResult(record4.getUserAge(), record4.getGender(), situation, record4.getQuotaType(), record4.getSecondQuotaName(), record4.getValue(),record4.getResult());
//			record4.setResult(result4);
//			quotaRecordService.add(record4);
////			5尿肌酐  男性8.4—13.25mmol/d  女性7～18mmol/d。或是男女：40-130 mg/dl。
//			double value5 = Double.parseDouble(df5.format(getRandomValue(22, 4) + Math.random()));
//			ThQuotaRecord record5 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record5);
//			record5.setSecondQuotaName("尿肌酐");
//			record5.setValue(value5);
//			String result5 = QuotaResultCalculation.getResult(record5.getUserAge(), record5.getGender(), situation, record5.getQuotaType(), record5.getSecondQuotaName(), record5.getValue(),record5.getResult());
//			record5.setResult(result5);
//			quotaRecordService.add(record5);
////			6尿蛋白（PR0） 阴性或仅有微量
//			ThQuotaRecord record6 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record6);
//			record6.setSecondQuotaName("尿蛋白");
//			String result6 = jiance[getRandomValue(2,0)];
//			record6.setResult(result6);
//			record6.setValue(null);
//			quotaRecordService.add(record6);
////			7尿酮体(U-Ket)  阴性（-）
//			ThQuotaRecord record7 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record7);
//			record7.setSecondQuotaName("尿酮体");
//			String result7 = jiance[getRandomValue(2,0)];
//			record7.setResult(result7);
//			record7.setValue(null);
//			quotaRecordService.add(record7);
////			8尿亚硝酸盐(NIT)  阴性（-）
//			ThQuotaRecord record8 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record8);
//			record8.setSecondQuotaName("尿亚硝酸盐");
//			String result8 = jiance[getRandomValue(2,0)];
//			record8.setResult(result8);
//			record8.setValue(null);
//			quotaRecordService.add(record8);
////			9尿胆红素(U-BIL)  阴性（-）
//			ThQuotaRecord record9 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record9);
//			record9.setSecondQuotaName("尿胆红素");
//			String result9 = jiance[getRandomValue(2,0)];
//			record9.setResult(result9);
//			record9.setValue(null);
//			quotaRecordService.add(record9);
////			10蛋白尿（PRO）  阴性
//			ThQuotaRecord record10 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record10);
//			record10.setSecondQuotaName("蛋白尿");
//			String result10 = jiance[getRandomValue(2,0)];
//			record10.setResult(result10);
//			record10.setValue(null);
//			quotaRecordService.add(record10);
////			11尿糖（GLU）  阴性
//			ThQuotaRecord record11 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record11);
//			record11.setSecondQuotaName("尿糖");
//			String result11 = jiance[getRandomValue(2,0)];
//			record11.setResult(result11);
//			record11.setValue(null);
//			quotaRecordService.add(record11);
////			12隐血BLO  阴性（-）
//			ThQuotaRecord record12 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record12);
//			record12.setSecondQuotaName("隐血");
//			String result12 = jiance[getRandomValue(2,0)];
//			record12.setResult(result12);
//			record12.setValue(null);
//			quotaRecordService.add(record12);
////			13酮体（KET）  阴性（-）
//			ThQuotaRecord record13 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record13);
//			record13.setSecondQuotaName("酮体");
//			String result13 = jiance[getRandomValue(2,0)];
//			record13.setResult(result13);
//			record13.setValue(null);
//			quotaRecordService.add(record13);
////			14尿红细胞（RBC）  阴性（-）
//			ThQuotaRecord record14 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record14);
//			record14.setSecondQuotaName("尿红细胞");
//			String result14 = jiance[getRandomValue(2,0)];
//			record14.setResult(result14);
//			record14.setValue(null);
//			quotaRecordService.add(record14);
////			15尿液颜色（GOL） 浅黄色至深黄色
//			ThQuotaRecord record15 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record15);
//			record15.setSecondQuotaName("尿液颜色");
//			String result15 = yanse[getRandomValue(2,0)];
//			record15.setResult(result15);
//			record15.setValue(null);
//			quotaRecordService.add(record15);
////			16维C  阴性
//			ThQuotaRecord record16 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record16);
//			record16.setSecondQuotaName("维C");
//			String result16 = jiance[getRandomValue(2,0)];
//			record16.setResult(result16);
//			record16.setValue(null);
//			quotaRecordService.add(record16);
//			
//			
//		}
//	}
	
////	血压
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.0");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
//			int situation = 0;
//			double shu = Double.parseDouble(df.format(getRandomValue(100, 50) + Math.random()));
//			double shou = Double.parseDouble(df.format(getRandomValue(170, 80) + Math.random()));
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("血压");
//			record.setSecondQuotaName("舒张压");
//			record.setQuotaType(2);
//			record.setValue(shu);
//			record.setStatus(1);
//
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(record.getUserAge(), record.getGender(), situation, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
//			
//			ThQuotaRecord record2 = new ThQuotaRecord();
//			BeanUtils.copyProperties(record, record2);
//			record2.setValue(shou);
//			record2.setSecondQuotaName("收缩压");
//			String result2 = QuotaResultCalculation.getResult(record2.getUserAge(), record2.getGender(), situation, record2.getQuotaType(), record2.getSecondQuotaName(), record2.getValue(),record2.getResult());
//			record2.setResult(result2);
//			quotaRecordService.add(record2);
//		}
//	}
	
////	脂肪率
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.0");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
//			int situation = 0;
//			double weight = getRandomValue(90, 40) + Math.random();
//			double height = (getRandomValue(185, 149) + Math.random())/100;
//			double BMI = weight / (height * height);
//			double BMIResult = Double.parseDouble(df.format(BMI));
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("脂肪率");
//			record.setQuotaType(6);
//			record.setValue(BMIResult);
//			record.setStatus(1);
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(record.getUserAge(), record.getGender(), situation, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
//		}
//	}
	
//	心率
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.0");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
//			int situation = 0;
//			Double xinlv = (double) getRandomValue(200, 30);
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("心率");
//			record.setQuotaType(5);
//			record.setValue(xinlv);
//			record.setStatus(1);
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(user.getUserAge(), user.getGender(), situation, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
//		}
//	}
	
////	血糖
//	@Rollback(false)
//	@Test
//	public void testadd11() {
//		DecimalFormat df = new DecimalFormat("0.0");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
//			int situation = 2;
////			double weight = Double.parseDouble(df.format(getRandomValue(90, 40) + Math.random()));
//			double xuetang = Double.parseDouble(df.format(getRandomValue(120, 44)/10.0));
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("血糖");
//			record.setQuotaType(4);
////			record.setUnit("度");
//			record.setValue(xuetang);
//			record.setStatus(1);
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(user.getUserAge(), user.getGender(), situation, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			if(situation == 1){
//				record.setSecondQuotaName("空腹");
//			}
//			if(situation == 2){
//				record.setSecondQuotaName("餐后2小时");
//			}
//			quotaRecordService.add(record);
//		}
//	}
	
////	血氧
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.00");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
////			double weight = Double.parseDouble(df.format(getRandomValue(90, 40) + Math.random()));
//			double xueyang = Double.parseDouble(df.format(getRandomValue(100, 90)/100.0));
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("血氧");
//			record.setQuotaType(3);
////			record.setUnit("度");
//			record.setValue(xueyang);
//			record.setStatus(1);
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(user.getUserAge(), user.getGender(), 0, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
//		}
//	}
	
////	体温
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.0");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
////			double weight = Double.parseDouble(df.format(getRandomValue(90, 40) + Math.random()));
//			double tiwen = Double.parseDouble(df.format(getRandomValue(39, 36) + Math.random()));
//			if(tiwen < 36.5){
//				tiwen = tiwen + 0.5;
//			}
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("体温");
//			record.setQuotaType(1);
//			record.setUnit("度");
//			record.setValue(tiwen);
//			record.setStatus(1);
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(user.getUserAge(), user.getGender(), 0, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
//		}
//	}
////	体重
//	@Rollback(false)
//	@Test
//	public void testadd() {
//		DecimalFormat df = new DecimalFormat("0.00");
//		
//		List<ThUser> list = userService.getAdminList(new ThUser(), new PageHelper());
//		for(int i=0; i<list.size(); i++){
//			ThUser user = list.get(i);
//			int userAge = getRandomValue(50,20);
////			double weight = Double.parseDouble(df.format(getRandomValue(90, 40) + Math.random()));
//			double weight = getRandomValue(90, 40) + Math.random();
//			double height = (getRandomValue(180, 149) + Math.random())/100;
//			double BMI = weight / (height * height);
//			double BMIResult = Double.parseDouble(df.format(BMI));
////			0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
//			ThQuotaRecord record = new ThQuotaRecord();
//			record.setUserId(user.getUserId());
//			record.setUserName(user.getUserName());
//			record.setUserAge(userAge);
//			record.setGender(getRandomValue(2,0));
//			record.setQuotaName("体重");
//			record.setQuotaType(0);
//			record.setUnit("Kg/M^2");
//			record.setValue(BMIResult);
//			record.setQuotaId(0);
//			record.setStatus(1);
//			
//			Integer recordCount = 1;
//			List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
//			if(recordMaxCount.size() != 0){
//				recordCount = recordMaxCount.get(0).getCount() + 1;
//			}
//			record.setCount(recordCount);
//			String result = QuotaResultCalculation.getResult(user.getUserAge(), user.getGender(), 0, record.getQuotaType(), record.getSecondQuotaName(), record.getValue(),record.getResult());
//			record.setResult(result);
//			quotaRecordService.add(record);
//		}
//	}
	
//	@Rollback(false)
//	@Test
//	public void testInsert() {
//		String[][] citys = {{"天津", "天津"},
//			 {"石家庄", "河北"},
//			 {"唐山", "河北"},
//			 {"秦皇岛", "河北"},
//			 {"邯郸", "河北"},
//			 {"邢台", "河北"},
//			 {"保定", "河北"},
//			 {"张家口", "河北"},
//			 {"承德", "河北"},
//			 {"沧州", "河北"},
//			 {"廊坊", "河北"},
//			 {"衡水", "河北"},
//			 {"太原", "山西"},
//			 {"大同", "山西"},
//			 {"阳泉", "山西"},
//			 {"长治", "山西"},
//			 {"晋城", "山西"},
//			 {"朔州", "山西"},
//			 {"晋中", "山西"},
//			 {"运城", "山西"},
//			 {"忻州", "山西"},
//			 {"临汾", "山西"},
//			 {"吕梁", "山西"},
//			 {"呼和浩特", "内蒙古"},
//			 {"包头", "内蒙古"},
//			 {"乌海", "内蒙古"},
//			 {"赤峰", "内蒙古"},
//			 {"通辽", "内蒙古"},
//			 {"鄂尔多斯", "内蒙古"},
//			 {"呼伦贝尔", "内蒙古"},
//			 {"巴彦淖尔", "内蒙古"},
//			 {"乌兰察布", "内蒙古"},
//			 {"兴安", "内蒙古"},
//			 {"锡林郭勒", "内蒙古"},
//			 {"阿拉善", "内蒙古"},
//			 {"沈阳", "辽宁"},
//			 {"大连", "辽宁"},
//			 {"鞍山", "辽宁"},
//			 {"抚顺", "辽宁"},
//			 {"本溪", "辽宁"},
//			 {"丹东", "辽宁"},
//			 {"锦州", "辽宁"},
//			 {"营口", "辽宁"},
//			 {"阜新", "辽宁"},
//			 {"辽阳", "辽宁"},
//			 {"盘锦", "辽宁"},
//			 {"铁岭", "辽宁"},
//			 {"朝阳", "辽宁"},
//			 {"葫芦岛", "辽宁"},
//			 {"长春", "吉林"},
//			 {"吉林", "吉林"},
//			 {"四平", "吉林"},
//			 {"辽源", "吉林"},
//			 {"通化", "吉林"},
//			 {"白山", "吉林"},
//			 {"松原", "吉林"},
//			 {"白城", "吉林"},
//			 {"延边朝鲜族", "吉林"},
//			 {"哈尔滨", "黑龙江"},
//			 {"齐齐哈尔", "黑龙江"},
//			 {"鸡西", "黑龙江"},
//			 {"鹤岗", "黑龙江"},
//			 {"双鸭山", "黑龙江"},
//			 {"大庆", "黑龙江"},
//			 {"伊春", "黑龙江"},
//			 {"佳木斯", "黑龙江"},
//			 {"七台河", "黑龙江"},
//			 {"牡丹江", "黑龙江"},
//			 {"黑河", "黑龙江"},
//			 {"绥化", "黑龙江"},
//			 {"大兴安岭", "黑龙江"},
//			 {"上海", "上海"},
//			 {"南京", "江苏"},
//			 {"无锡", "江苏"},
//			 {"徐州", "江苏"},
//			 {"常州", "江苏"},
//			 {"苏州", "江苏"},
//			 {"南通", "江苏"},
//			 {"连云港", "江苏"},
//			 {"淮安", "江苏"},
//			 {"盐城", "江苏"},
//			 {"扬州", "江苏"},
//			 {"镇江", "江苏"},
//			 {"泰州", "江苏"},
//			 {"宿迁", "江苏"},
//			 {"杭州", "浙江"},
//			 {"宁波", "浙江"},
//			 {"温州", "浙江"},
//			 {"嘉兴", "浙江"},
//			 {"湖州", "浙江"},
//			 {"绍兴", "浙江"},
//			 {"金华", "浙江"},
//			 {"衢州", "浙江"},
//			 {"舟山", "浙江"},
//			 {"台州", "浙江"},
//			 {"丽水", "浙江"},
//			 {"合肥", "安徽"},
//			 {"芜湖", "安徽"},
//			 {"蚌埠", "安徽"},
//			 {"淮南", "安徽"},
//			 {"马鞍山", "安徽"},
//			 {"淮北", "安徽"},
//			 {"铜陵", "安徽"},
//			 {"安庆", "安徽"},
//			 {"黄山", "安徽"},
//			 {"滁州", "安徽"},
//			 {"阜阳", "安徽"},
//			 {"宿州", "安徽"},
//			 {"六安", "安徽"},
//			 {"亳州", "安徽"},
//			 {"池州", "安徽"},
//			 {"宣城", "安徽"},
//			 {"福州", "福建"},
//			 {"厦门", "福建"},
//			 {"莆田", "福建"},
//			 {"三明", "福建"},
//			 {"泉州", "福建"},
//			 {"漳州", "福建"},
//			 {"南平", "福建"},
//			 {"龙岩", "福建"},
//			 {"宁德", "福建"},
//			 {"南昌", "江西"},
//			 {"景德镇", "江西"},
//			 {"萍乡", "江西"},
//			 {"九江", "江西"},
//			 {"新余", "江西"},
//			 {"鹰潭", "江西"},
//			 {"赣州", "江西"},
//			 {"吉安", "江西"},
//			 {"宜春", "江西"},
//			 {"抚州", "江西"},
//			 {"上饶", "江西"},
//			 {"济南", "山东"},
//			 {"青岛", "山东"},
//			 {"淄博", "山东"},
//			 {"枣庄", "山东"},
//			 {"东营", "山东"},
//			 {"烟台", "山东"},
//			 {"潍坊", "山东"},
//			 {"济宁", "山东"},
//			 {"泰安", "山东"},
//			 {"威海", "山东"},
//			 {"日照", "山东"},
//			 {"莱芜", "山东"},
//			 {"临沂", "山东"},
//			 {"德州", "山东"},
//			 {"聊城", "山东"},
//			 {"滨州", "山东"},
//			 {"菏泽", "山东"},
//			 {"郑州", "河南"},
//			 {"开封", "河南"},
//			 {"洛阳", "河南"},
//			 {"平顶山", "河南"},
//			 {"安阳", "河南"},
//			 {"鹤壁", "河南"},
//			 {"新乡", "河南"},
//			 {"焦作", "河南"},
//			 {"济源", "河南"},
//			 {"濮阳", "河南"},
//			 {"许昌", "河南"},
//			 {"漯河", "河南"},
//			 {"三门峡", "河南"},
//			 {"南阳", "河南"},
//			 {"商丘", "河南"},
//			 {"信阳", "河南"},
//			 {"周口", "河南"},
//			 {"驻马店", "河南"},
//			 {"武汉", "湖北"},
//			 {"黄石", "湖北"},
//			 {"十堰", "湖北"},
//			 {"宜昌", "湖北"},
//			 {"襄阳", "湖北"},
//			 {"鄂州", "湖北"},
//			 {"荆门", "湖北"},
//			 {"孝感", "湖北"},
//			 {"荆州", "湖北"},
//			 {"黄冈", "湖北"},
//			 {"咸宁", "湖北"},
//			 {"随州", "湖北"},
//			 {"恩施", "湖北"},
//			 {"仙桃", "湖北"},
//			 {"潜江", "湖北"},
//			 {"天门", "湖北"},
//			 {"神农架", "湖北"},
//			 {"长沙", "湖南"},
//			 {"株洲", "湖南"},
//			 {"湘潭", "湖南"},
//			 {"衡阳", "湖南"},
//			 {"邵阳", "湖南"},
//			 {"岳阳", "湖南"},
//			 {"常德", "湖南"},
//			 {"张家界", "湖南"},
//			 {"益阳", "湖南"},
//			 {"郴州", "湖南"},
//			 {"永州", "湖南"},
//			 {"怀化", "湖南"},
//			 {"娄底", "湖南"},
//			 {"湘西", "湖南"},
//			 {"广州", "广东"},
//			 {"韶关", "广东"},
//			 {"深圳", "广东"},
//			 {"珠海", "广东"},
//			 {"汕头", "广东"},
//			 {"佛山", "广东"},
//			 {"江门", "广东"},
//			 {"湛江", "广东"},
//			 {"茂名", "广东"},
//			 {"肇庆", "广东"},
//			 {"惠州", "广东"},
//			 {"梅州", "广东"},
//			 {"汕尾", "广东"},
//			 {"河源", "广东"},
//			 {"阳江", "广东"},
//			 {"清远", "广东"},
//			 {"东莞", "广东"},
//			 {"中山", "广东"},
//			 {"东沙", "广东"},
//			 {"潮州", "广东"},
//			 {"揭阳", "广东"},
//			 {"云浮", "广东"},
//			 {"南宁", "广西"},
//			 {"柳州", "广西"},
//			 {"桂林", "广西"},
//			 {"梧州", "广西"},
//			 {"北海", "广西"},
//			 {"防城港", "广西"},
//			 {"钦州", "广西"},
//			 {"贵港", "广西"},
//			 {"玉林", "广西"},
//			 {"百色", "广西"},
//			 {"贺州", "广西"},
//			 {"河池", "广西"},
//			 {"来宾", "广西"},
//			 {"崇左", "广西"},
//			 {"海口", "海南"},
//			 {"三亚", "海南"},
//			 {"三沙", "海南"},
//			 {"五指山", "海南"},
//			 {"琼海", "海南"},
//			 {"儋州", "海南"},
//			 {"文昌", "海南"},
//			 {"万宁", "海南"},
//			 {"东方", "海南"},
//			 {"定安", "海南"},
//			 {"屯昌", "海南"},
//			 {"澄迈", "海南"},
//			 {"临高", "海南"},
//			 {"白沙", "海南"},
//			 {"昌江", "海南"},
//			 {"乐东", "海南"},
//			 {"陵水", "海南"},
//			 {"保亭", "海南"},
//			 {"琼中", "海南"},
//			 {"重庆", "重庆"},
//			 {"成都", "四川"},
//			 {"自贡", "四川"},
//			 {"攀枝花", "四川"},
//			 {"泸州", "四川"},
//			 {"德阳", "四川"},
//			 {"绵阳", "四川"},
//			 {"广元", "四川"},
//			 {"遂宁", "四川"},
//			 {"内江", "四川"},
//			 {"乐山", "四川"},
//			 {"南充", "四川"},
//			 {"眉山", "四川"},
//			 {"宜宾", "四川"},
//			 {"广安", "四川"},
//			 {"达州", "四川"},
//			 {"雅安", "四川"},
//			 {"巴中", "四川"},
//			 {"资阳", "四川"},
//			 {"阿坝", "四川"},
//			 {"甘孜", "四川"},
//			 {"凉山", "四川"},
//			 {"贵阳", "贵州"},
//			 {"六盘水", "贵州"},
//			 {"遵义", "贵州"},
//			 {"安顺", "贵州"},
//			 {"铜仁", "贵州"},
//			 {"黔西南", "贵州"},
//			 {"毕节", "贵州"},
//			 {"黔东南", "贵州"},
//			 {"黔南", "贵州"},
//			 {"昆明", "云南"},
//			 {"曲靖", "云南"},
//			 {"玉溪", "云南"},
//			 {"保山", "云南"},
//			 {"昭通", "云南"},
//			 {"丽江", "云南"},
//			 {"普洱", "云南"},
//			 {"临沧", "云南"},
//			 {"楚雄", "云南"},
//			 {"红河", "云南"},
//			 {"文山", "云南"},
//			 {"西双版纳", "云南"},
//			 {"大理", "云南"},
//			 {"德宏", "云南"},
//			 {"怒江", "云南"},
//			 {"迪庆", "云南"},
//			 {"拉萨", "西藏"},
//			 {"昌都", "西藏"},
//			 {"山南", "西藏"},
//			 {"日喀则", "西藏"},
//			 {"那曲", "西藏"},
//			 {"阿里", "西藏"},
//			 {"林芝", "西藏"},
//			 {"西安", "陕西"},
//			 {"铜川", "陕西"},
//			 {"宝鸡", "陕西"},
//			 {"咸阳", "陕西"},
//			 {"渭南", "陕西"},
//			 {"延安", "陕西"},
//			 {"汉中", "陕西"},
//			 {"榆林", "陕西"},
//			 {"安康", "陕西"},
//			 {"商洛", "陕西"},
//			 {"兰州", "甘肃"},
//			 {"嘉峪关", "甘肃"},
//			 {"金昌", "甘肃"},
//			 {"白银", "甘肃"},
//			 {"天水", "甘肃"},
//			 {"武威", "甘肃"},
//			 {"张掖", "甘肃"},
//			 {"平凉", "甘肃"},
//			 {"酒泉", "甘肃"},
//			 {"庆阳", "甘肃"},
//			 {"定西", "甘肃"},
//			 {"陇南", "甘肃"},
//			 {"临夏", "甘肃"},
//			 {"甘南", "甘肃"},
//			 {"西宁", "青海"},
//			 {"海东", "青海"},
//			 {"海北", "青海"},
//			 {"黄南", "青海"},
//			 {"海南藏族", "青海"},
//			 {"果洛", "青海"},
//			 {"玉树", "青海"},
//			 {"海西", "青海"},
//			 {"银川", "宁夏"},
//			 {"石嘴山", "宁夏"},
//			 {"吴忠", "宁夏"},
//			 {"固原", "宁夏"},
//			 {"中卫", "宁夏"},
//			 {"乌鲁木齐", "新疆"},
//			 {"克拉玛依", "新疆"},
//			 {"吐鲁番", "新疆"},
//			 {"哈密", "新疆"},
//			 {"昌吉", "新疆"},
//			 {"博尔塔拉", "新疆"},
//			 {"巴音郭楞", "新疆"},
//			 {"阿克苏", "新疆"},
//			 {"克孜勒苏柯尔克孜", "新疆"},
//			 {"喀什", "新疆"},
//			 {"和田", "新疆"},
//			 {"伊犁", "新疆"},
//			 {"塔城", "新疆"},
//			 {"阿勒泰", "新疆"},
//			 {"石河子", "新疆"},
//			 {"阿拉尔", "新疆"},
//			 {"图木舒克", "新疆"},
//			 {"五家渠", "新疆"},
//			 {"台北", "台湾"},
//			 {"高雄", "台湾"},
//			 {"台南", "台湾"},
//			 {"台中", "台湾"},
//			 {"金门", "台湾"},
//			 {"南投", "台湾"},
//			 {"基隆", "台湾"},
//			 {"新竹", "台湾"},
//			 {"嘉义", "台湾"},
//			 {"新北", "台湾"},
//			 {"宜兰", "台湾"},
//			 {"新竹", "台湾"},
//			 {"桃园", "台湾"},
//			 {"苗栗", "台湾"},
//			 {"彰化", "台湾"},
//			 {"嘉义", "台湾"},
//			 {"云林", "台湾"},
//			 {"屏东", "台湾"},
//			 {"台东", "台湾"},
//			 {"花莲", "台湾"},
//			 {"澎湖", "台湾"},
//			 {"连江", "台湾"},
//			 {"香港岛", "香港"},
//			 {"九龙", "香港"},
//			 {"新界", "香港"},
//			 {"澳门半岛", "澳门"},
//			 {"离岛", "澳门"}};
//		String[] race = {"汉族", "壮族", "回族", "满族", "维吾尔族", "苗族", "彝族", "土家族", "藏族", "蒙古族", "侗族", "布依族", "瑶族", "白族", "朝鲜族", "哈尼族", "黎族", "哈萨克族", "傣族", "畲族", "傈僳族", "东乡族", "仡佬族", "拉祜族", "佤族", "水族", "纳西族", "羌族", "土族", "仫佬族", "锡伯族", "柯尔克孜族", "景颇族", "达斡尔族", "撒拉族", "布朗族", "毛南族", "塔吉克族", "普米族", "阿昌族", "怒族", "鄂温克族", "京族", "基诺族", "德昂族", "保安族", "俄罗斯族", "裕固族", "乌孜别克族", "门巴族", "鄂伦春族", "独龙族", "赫哲族", "高山族", "珞巴族", "塔塔尔族"};
//		String[] bloodType = {"A","B","O","AB"};
//		Long loginName = 10000000000L;
//		for(int i=0;i<500;i++){
//			int cityV = getRandomValue(389,0);
//			int gender = new Random().nextInt(2);
//			int blood = getRandomValue(4,0);
//			int raceV = getRandomValue(56,0);
//			String city = citys[cityV][0];
//			String province = citys[cityV][1];
//			ThUser user = new ThUser();
//			user.setUserName("用户"+i);
//			user.setFlag(1);
//			user.setGender(gender);
//			user.setUserLoginName((loginName++).toString());
//			user.setUserPassword("e10adc3949ba59abbe56e057f20f883e");
//			ThUser userResult = userService.saveUser(user);
//			ThUserInfo userInfo = new ThUserInfo();
//			userInfo.setUserId(userResult.getUserId());
//			userInfo.setBloodType(bloodType[blood]);
//			if(i > 150){
//				userInfo.setNation(race[0]);
//			}else{
//				userInfo.setNation(race[raceV]);
//			}
//			userInfo.setNationality("中国");
//			userInfoService.saveUserInfo(userInfo);
//			ThUserAddress userAddress = new ThUserAddress();
//			userAddress.setCity(city);
//			userAddress.setProvince(province); 
//			userAddress.setUserId(userResult.getUserId());
//			userAddressService.saveUserAddress(userAddress);
//		}
//		
//	}
	
	private int getRandomValue(int max,int min){
		int value = (int) (Math.random()*(max - min) + min);
		return value;
	}
//	private int getRandomValue(int value){
//		int rvalue = (int) Math.random() * value ;
//		return rvalue;
//	}
}
