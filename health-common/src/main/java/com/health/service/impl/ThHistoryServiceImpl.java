package com.health.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThHistoryDiseaseDao;
import com.health.dao.ThHistoryHospitalizedDao;
import com.health.dao.ThHistoryImmunizationDao;
import com.health.dao.ThHistoryInjuryDao;
import com.health.dao.ThHistoryMedicalDao;
import com.health.dao.ThHistoryOperationDao;
import com.health.dao.ThHistoryPharmacyDao;
import com.health.dao.ThHistoryTransfusionDao;
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

@Service
public class ThHistoryServiceImpl implements ThHistoryService{

	@Autowired
	ThHistoryMedicalDao thHistoryMedicalDao;
	
	@Autowired
	ThHistoryDiseaseDao thHistoryDiseaseDao;
	
	@Autowired
	ThHistoryHospitalizedDao thHistoryHospitalizedDao;
	
	@Autowired
	ThHistoryImmunizationDao thHistoryImmunizationDao;
	
	@Autowired
	ThHistoryInjuryDao thHistoryInjuryDao;
	
	@Autowired
	ThHistoryOperationDao thHistoryOperationDao;
	
	@Autowired
	ThHistoryPharmacyDao thHistoryPharmacyDao;
	
	@Autowired
	ThHistoryTransfusionDao thHistoryTransfusionDao;
	
	@Transactional
	@Override
	public Map<String, Object> saveHistoryMedical(ThHistoryMedical item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryMedicalDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryDisease(ThHistoryDisease item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryDiseaseDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryHospitalized(ThHistoryHospitalized item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryHospitalizedDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryImmunization(ThHistoryImmunization item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryImmunizationDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryInjury(ThHistoryInjury item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryInjuryDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryOperation(ThHistoryOperation item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryOperationDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryPharmacy(ThHistoryPharmacy item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryPharmacyDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> saveHistoryTransfusion(ThHistoryTransfusion item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		item.setId(UUID.randomUUID().toString());
		Date current = new Date();		
		item.setCreateTime(current);
		item.setUpdateTime(current);
		Serializable id = thHistoryTransfusionDao.save(item);
		result.put("id", id);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryMedical(ThHistoryMedical item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryMedicalDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryDisease(ThHistoryDisease item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryDiseaseDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryHospitalized(ThHistoryHospitalized item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryHospitalizedDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryImmunization(ThHistoryImmunization item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryImmunizationDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryInjury(ThHistoryInjury item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryInjuryDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryOperation(ThHistoryOperation item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryOperationDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryPharmacy(ThHistoryPharmacy item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryPharmacyDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> updateHistoryTransfusion(ThHistoryTransfusion item) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Date current = new Date();		
		item.setUpdateTime(current);
		Serializable updateCount = thHistoryTransfusionDao.updateById(item);
		if(updateCount == null) {
			updateCount = 0;
		}
		result.put("updateCount", updateCount);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryMedical(ThHistoryMedical item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryMedicalDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryMedicalDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryDisease(ThHistoryDisease item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryDiseaseDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryDiseaseDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryHospitalized(ThHistoryHospitalized item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryHospitalizedDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryHospitalizedDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryImmunization(ThHistoryImmunization item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryImmunizationDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryImmunizationDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryInjury(ThHistoryInjury item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryInjuryDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryInjuryDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryOperation(ThHistoryOperation item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryOperationDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryOperationDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryPharmacy(ThHistoryPharmacy item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryPharmacyDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryPharmacyDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> queryHistoryTransfusion(ThHistoryTransfusion item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Long totalCount = thHistoryTransfusionDao.getListCount(item);
		result.put("totalCount", totalCount);
		if(totalCount.equals(0)) {
			return result;
		}
		List<Map<String, Object>> list = thHistoryTransfusionDao.getList(item, ph);
		result.put("list", list);
		return result;
	}

}
