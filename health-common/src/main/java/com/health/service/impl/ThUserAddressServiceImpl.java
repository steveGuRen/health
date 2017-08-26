package com.health.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThUserAddressDao;
import com.health.model.ThUserAddress;
import com.health.service.ThUserAddressService;

@Service
@Transactional
public class ThUserAddressServiceImpl implements ThUserAddressService {

	@Autowired
	ThUserAddressDao userAddressDao;
	
	@Override
	public ThUserAddress saveUserAddress(ThUserAddress userAddress) {
		return userAddressDao.saveUserAddress(userAddress);
	}

	@Override
	public String deleteUserAddress(ThUserAddress userAddress) {
		return userAddressDao.deleteUserAddress(userAddress);
	}

	@Override
	public Integer updateAddressById(ThUserAddress userAddress) {
		return userAddressDao.updateAddressById(userAddress);
	}

}
