package com.health.dao;

import com.health.model.ThUserAddress;

public interface ThUserAddressDao extends BaseDaoI<ThUserAddress> {	

	public ThUserAddress saveUserAddress(ThUserAddress userAddress) ;
	
    public String deleteUserAddress(ThUserAddress userAddress) ;
    
    public Integer updateAddressById(ThUserAddress userAddress);

}
