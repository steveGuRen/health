package com.health.dao;

import com.health.model.ThUserFollow;

public interface ThUserFollowDao extends BaseDaoI<ThUserFollow> {
	
	public ThUserFollow get(ThUserFollow userFollow);
	
	public ThUserFollow saveUserFollow(ThUserFollow userFollow);
	
    public String deleteUserFollow(ThUserFollow userFollow);
    
    public Integer updateFollowById(ThUserFollow userFollow);

}
