package com.health.service;

import java.util.Map;

import com.health.model.ThDevice;
import com.health.utils.PageHelper;

public interface ThDeviceService {

	public Map<String, Object> saveDevice(ThDevice item);

	public Map<String, Object> updateDevice(ThDevice item);

	public Map<String, Object> queryDevice(ThDevice item, PageHelper ph);
}
