package com.health.service;

import java.util.Map;

import com.health.model.ThHistoryMedical;
import com.health.model.ThQuotaRecord;

public interface GraphService {
	
	public Map<String, Object> getItems(ThHistoryMedical item);
	
	public Map<String, Object> getStarGraph(ThHistoryMedical item);
	
	public Map<String, Object> getByWeight(ThQuotaRecord user);
	
	public Map<String, Object> getGroups(ThQuotaRecord item);
	
	public Map<String, Object> getAVGs();
	
	public Map<String, Object> delAll();
}
