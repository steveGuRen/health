package com.health.service;

import com.health.model.ThUserFollow;

public interface ThUserFollowService {
	
	public ThUserFollow get(ThUserFollow userFollow);

	public ThUserFollow saveUserFollow(ThUserFollow userFollow);
	
    public String deleteUserFollow(ThUserFollow userFollow);
    
    public Integer updateFollowById(ThUserFollow userFollow);
}
