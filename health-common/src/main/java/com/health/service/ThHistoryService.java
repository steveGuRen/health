package com.health.service;

import java.util.Map;

import com.health.model.ThHistoryDisease;
import com.health.model.ThHistoryHospitalized;
import com.health.model.ThHistoryImmunization;
import com.health.model.ThHistoryInjury;
import com.health.model.ThHistoryMedical;
import com.health.model.ThHistoryOperation;
import com.health.model.ThHistoryPharmacy;
import com.health.model.ThHistoryTransfusion;
import com.health.utils.PageHelper;

public interface ThHistoryService {
	
	public Map<String, Object> saveHistoryMedical(ThHistoryMedical item);
	
	public Map<String, Object> saveHistoryDisease(ThHistoryDisease item);
	
	public Map<String, Object> saveHistoryHospitalized(ThHistoryHospitalized item);
	
	public Map<String, Object> saveHistoryImmunization(ThHistoryImmunization item);
	
	public Map<String, Object> saveHistoryInjury(ThHistoryInjury item);
	
	public Map<String, Object> saveHistoryOperation(ThHistoryOperation item);
	
	public Map<String, Object> saveHistoryPharmacy(ThHistoryPharmacy item);
	
	public Map<String, Object> saveHistoryTransfusion(ThHistoryTransfusion item);
	
	public Map<String, Object> updateHistoryMedical(ThHistoryMedical item);
	
	public Map<String, Object> updateHistoryDisease(ThHistoryDisease item);
	
	public Map<String, Object> updateHistoryHospitalized(ThHistoryHospitalized item);
	
	public Map<String, Object> updateHistoryImmunization(ThHistoryImmunization item);
	
	public Map<String, Object> updateHistoryInjury(ThHistoryInjury item);
	
	public Map<String, Object> updateHistoryOperation(ThHistoryOperation item);
	
	public Map<String, Object> updateHistoryPharmacy(ThHistoryPharmacy item);
	
	public Map<String, Object> updateHistoryTransfusion(ThHistoryTransfusion item);
	
	public Map<String, Object> queryHistoryMedical(ThHistoryMedical item, PageHelper ph);
	
	public Map<String, Object> queryHistoryDisease(ThHistoryDisease item, PageHelper ph);
	
	public Map<String, Object> queryHistoryHospitalized(ThHistoryHospitalized item, PageHelper ph);
	
	public Map<String, Object> queryHistoryImmunization(ThHistoryImmunization item, PageHelper ph);
	
	public Map<String, Object> queryHistoryInjury(ThHistoryInjury item, PageHelper ph);
	
	public Map<String, Object> queryHistoryOperation(ThHistoryOperation item, PageHelper ph);
	
	public Map<String, Object> queryHistoryPharmacy(ThHistoryPharmacy item, PageHelper ph);
	
	public Map<String, Object> queryHistoryTransfusion(ThHistoryTransfusion item, PageHelper ph);
	
}
