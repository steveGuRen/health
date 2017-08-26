package com.health.service;

import com.health.model.ThUserAddress;

public interface ThUserAddressService {

	public ThUserAddress saveUserAddress(ThUserAddress userAddress) ;
	
    public String deleteUserAddress(ThUserAddress userAddress) ;
    
    public Integer updateAddressById(ThUserAddress userAddress);

}
