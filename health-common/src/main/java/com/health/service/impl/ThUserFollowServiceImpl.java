package com.health.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThUserFollowDao;
import com.health.model.ThUserFollow;
import com.health.service.ThUserFollowService;

@Service
@Transactional
public class ThUserFollowServiceImpl implements ThUserFollowService {

	@Autowired
	ThUserFollowDao userFollowDao;
	
	@Override
	public ThUserFollow saveUserFollow(ThUserFollow userFollow) {
		return userFollowDao.saveUserFollow(userFollow);
	}

	@Override
	public String deleteUserFollow(ThUserFollow userFollow) {
		return userFollowDao.deleteUserFollow(userFollow);
	}

	@Override
	public Integer updateFollowById(ThUserFollow userFollow) {
		return userFollowDao.updateFollowById(userFollow);
	}

	@Override
	public ThUserFollow get(ThUserFollow userFollow) {
		return userFollowDao.get(userFollow);
	}

}
