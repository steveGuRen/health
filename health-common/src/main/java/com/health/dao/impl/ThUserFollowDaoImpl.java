package com.health.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.health.dao.ThUserFollowDao;
import com.health.model.ThUser;
import com.health.model.ThUserFollow;

@Repository
public class ThUserFollowDaoImpl extends BaseDaoImpl<ThUserFollow> implements ThUserFollowDao {

	@Override
	public ThUserFollow saveUserFollow(ThUserFollow userFollow) {		
		save(userFollow);
		return userFollow;
	}

	@Override
	public String deleteUserFollow(ThUserFollow userFollow) {
		String followId = userFollow.getFollowId().toString();
		String hql = " delete ThUserFollow t where t.followId = :followId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("followId", followId);
		q.executeUpdate();
		return followId;
	}

	@Override
	public Integer updateFollowById(ThUserFollow userFollow) {
		if (userFollow.getFollowId() == null) {
			return null;
		}
		String hql = " update ThUserFollow t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(userFollow, params);
		String whereIdHql = " where t.followId = :followId ";
		return executeHql(hql + setHql + whereIdHql, params);
	}

	private String setHql(ThUserFollow userFollow, Map<String, Object> params) {
		String setHql = "";		
		if (userFollow != null) {
			setHql += " set";
			if (userFollow.getFollowId() != null) {
				setHql += " t.followId = :followId,";
				params.put("followId", userFollow.getFollowId());
			}
			if (userFollow.getUserId() != null) {
				setHql += " t.userId = :userId,";
				params.put("userId", userFollow.getUserId());
			}
			if (StringUtils.isNotBlank(userFollow.getFollowUserId())) {
				setHql += " t.followUserId = :followUserId,";
				params.put("followUserId", userFollow.getFollowUserId());
			}
			if (userFollow.getQuotaId() != null) {
				setHql += " t.quotaId = :quotaId,";
				params.put("quotaId", userFollow.getQuotaId());
			}
			if (StringUtils.isNotBlank(userFollow.getUserRemark())) {
				setHql += " t.userRemark = :userRemark,";
				params.put("userRemark", userFollow.getUserRemark());
			}
			if (StringUtils.isNotBlank(userFollow.getFollowerRemark())) {
				setHql += " t.followerRemark = :followerRemark,";
				params.put("followerRemark", userFollow.getFollowerRemark());
			}
			if(StringUtils.isNotBlank(userFollow.getUpdateUser())){
				setHql += " t.updateUser = :updateUser,";
				params.put("updateUser", userFollow.getUpdateUser());
			}
			if(userFollow.getUpdateTime() != null){
				setHql += " t.updateTime = :updateTime,";
				params.put("updateTime", userFollow.getUpdateTime());
			}
			if (userFollow.getFlag() != null) {
				setHql += "t.flag = :flag,";
				params.put("flag", userFollow.getFlag());
			}
			if (userFollow.getIsMutualFollowed() != null) {
				setHql += "t.isMutualFollowed = :isMutualFollowed,";
				params.put("isMutualFollowed", userFollow.getIsMutualFollowed());
			}
		}
		if (StringUtils.endsWith(setHql, ",")) {
			setHql = setHql.substring(0, setHql.length() - 1);
		}
		return setHql;
	}

	@Override
	public ThUserFollow get(ThUserFollow userFollow) {
		String hql = "from ThUserFollow t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThUserFollow t = get(hql + whereHql(userFollow, params), params);
		return t;
	}
	
	public String whereHql(ThUserFollow userFollow, Map<String, Object> params) {
		String queryString = "";
		if (userFollow != null) {
			queryString += "where 1=1 ";
			if (userFollow.getFollowId() != null) {
				queryString += "and t.followId = :followId ";
				params.put("followId", userFollow.getFollowId());
			}
			if (userFollow.getUserId() != null) {
				queryString += "and t.userId = :userId ";
				params.put("userId", userFollow.getUserId());
			}
			if (StringUtils.isNotBlank(userFollow.getFollowUserId())) {
				queryString += "and t.followUserId = :followUserId ";
				params.put("followUserId", userFollow.getFollowUserId());
			}
			if (userFollow.getQuotaId() != null) {
				queryString += "and t.quotaId = :quotaId ";
				params.put("quotaId", userFollow.getQuotaId());
			}
			if (StringUtils.isNotBlank(userFollow.getUserRemark())) {
				queryString += "and t.userRemark = :userRemark ";
				params.put("userRemark", userFollow.getUserRemark());
			}
			if (StringUtils.isNotBlank(userFollow.getFollowerRemark())) {
				queryString += "and t.followerRemark = :followerRemark ";
				params.put("followerRemark", userFollow.getFollowerRemark());
			}
			if (userFollow.getFlag() != null) {
				queryString += "and t.flag = :flag ";
				params.put("flag", userFollow.getFlag());
			}
			if (userFollow.getIsMutualFollowed() != null) {
				queryString += "and t.isMutualFollowed = :isMutualFollowed ";
				params.put("isMutualFollowed", userFollow.getIsMutualFollowed());
			}
		}
		return queryString;
	}

}
