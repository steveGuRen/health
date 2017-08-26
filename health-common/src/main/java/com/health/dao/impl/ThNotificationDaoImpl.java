package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThNotificationDao;
import com.health.model.ThNotification;
import com.health.utils.PageHelper;

@Repository
public class ThNotificationDaoImpl extends BaseDaoImpl<ThNotification> implements ThNotificationDao {

	@Override
	public List<ThNotification> getObjects(ThNotification item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThNotification t ";
		List<ThNotification> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThNotification item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThNotification item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThNotification get(ThNotification item) {
		// TODO Auto-generated method stub
		String hql = " from ThNotification t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThNotification result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThNotification item) {
		// TODO Auto-generated method stub
		if(item.getNotificationId() == null) {
			return null;
		}
		String hql = "update ThNotification t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.notificationId = :notificationId";
		params.put("notificationId", item.getNotificationId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String getListSql(ThNotification item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.notificationId, "
				+ "t.summary, "
				+ "t.title, "
				+ "t.content, "
				+ "t.contentType, "
				+ "t.action, "
				+ "t.weight, "
				+ "t.activeTime, "
				+ "t.templateUrl, "
				+ "t.type, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_notification t ";
		String orderString  = "";
		if (ph !=null && StringUtils.isNotBlank(ph.getSort()) && StringUtils.isNotBlank(ph.getOrder())) {
			orderString = " order by " + ph.getSort() + " " + ph.getOrder();
		}
		String limitString = "";
		if(ph != null && ph.getRows() > 0 && ph.getPage() > 0) {
			Integer index =  (ph.getPage() - 1)*ph.getRows();
			limitString = " limit " + index + "," + new Integer(ph.getRows()); 
		} 
		return sql + whereSql(item, params) + orderString +  limitString;
	}
	
	private String whereSql(ThNotification item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(item.getNotificationId() != null) {
				whereSql += " and t.notificationId = :notificationId ";
				params.put("notificationId", item.getNotificationId());
			}
			if(StringUtils.isNotBlank(item.getSummary())) {
				whereSql += " and t.summary = :summary ";
				params.put("summary", item.getSummary());
			}
			if(StringUtils.isNotBlank(item.getTitle())) {
				whereSql += " and t.title = :title ";
				params.put("title", item.getTitle());
			}
			if(StringUtils.isNotBlank(item.getContent())) {
				whereSql += " and t.content = :content ";
				params.put("content", item.getContent());
			}
			if(StringUtils.isNotBlank(item.getContentType())) {
				whereSql += " and t.contentType = :contentType ";
				params.put("contentType", item.getContentType());
			}
			if(StringUtils.isNotBlank(item.getAction())) {
				whereSql += " and t.action = :action ";
				params.put("action", item.getAction());
			}
			if(item.getWeight() != null) {
				whereSql += " and t.weight = :weight ";
				params.put("weight", item.getWeight());
			}
			if(item.getActiveTime() != null) {
				whereSql += " and t.activeTime = :activeTime ";
				params.put("activeTime", item.getActiveTime());
			}
			if(StringUtils.isNotBlank(item.getTemplateUrl())) {
				whereSql += " and t.templateUrl = :templateUrl ";
				params.put("templateUrl", item.getTemplateUrl());
			}
			if(StringUtils.isNotBlank(item.getType())) {
				whereSql += " and t.type = :type ";
				params.put("type", item.getType());
			}
			if(StringUtils.isNotBlank(item.getUserId())) {
				whereSql += " and t.userId = :userId ";
				params.put("userId", item.getUserId());
			}
			if(item.getCreateTime() != null) {
				whereSql += " and t.createTime = :createTime ";
				params.put("createTime", item.getCreateTime());
			}
			if(item.getUpdateTime() != null) {
				whereSql += " and t.updateTime = :updateTime ";
				params.put("updateTime", item.getUpdateTime());
			}
			if(StringUtils.isNotBlank(item.getCreateUser())) {
				whereSql += " and t.createUser = :createUser ";
				params.put("createUser", item.getCreateUser());
			}
			if(StringUtils.isNotBlank(item.getUpdateUser())) {
				whereSql += " and t.updateUser = :updateUser ";
				params.put("updateUser", item.getUpdateUser());
			}
			
		}
		return whereSql;
	}
	
	private String setSql(ThNotification item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getNotificationId() != null) {
				setSql += " t.notificationId = :notificationIdNew,";
				params.put("notificationIdNew", item.getNotificationId());
			}
			if(item.getSummary() != null) {
				setSql += " t.summary = :summaryNew,";
				params.put("summaryNew", item.getSummary());
			}
			if(item.getTitle() != null) {
				setSql += " t.title = :titleNew,";
				params.put("titleNew", item.getTitle());
			}
			if(item.getContent() != null) {
				setSql += " t.content = :contentNew,";
				params.put("contentNew", item.getContent());
			}
			if(item.getContentType() != null) {
				setSql += " t.contentType = :contentTypeNew,";
				params.put("contentTypeNew", item.getContentType());
			}
			if(item.getAction() != null) {
				setSql += " t.action = :actionNew,";
				params.put("actionNew", item.getAction());
			}
			if(item.getWeight() != null) {
				setSql += " t.weight = :weightNew,";
				params.put("weightNew", item.getWeight());
			}
			if(item.getActiveTime() != null) {
				setSql += " t.activeTime = :activeTimeNew,";
				params.put("activeTimeNew", item.getActiveTime());
			}
			if(item.getTemplateUrl() != null) {
				setSql += " t.templateUrl = :templateUrlNew,";
				params.put("templateUrlNew", item.getTemplateUrl());
			}
			if(item.getType() != null) {
				setSql += " t.type = :typeNew,";
				params.put("typeNew", item.getType());
			}
			if(item.getUserId() != null) {
				setSql += " t.userId = :userIdNew,";
				params.put("userIdNew", item.getUserId());
			}
			if(item.getCreateTime() != null) {
				setSql += " t.createTime = :createTimeNew,";
				params.put("createTimeNew", item.getCreateTime());
			}
			if(item.getUpdateTime() != null) {
				setSql += " t.updateTime = :updateTimeNew,";
				params.put("updateTimeNew", item.getUpdateTime());
			}
			if(item.getCreateUser() != null) {
				setSql += " t.createUser = :createUserNew,";
				params.put("createUserNew", item.getCreateUser());
			}
			if(item.getUpdateUser() != null) {
				setSql += " t.updateUser = :updateUserNew,";
				params.put("updateUserNew", item.getUpdateUser());
			}
		}
		if(StringUtils.endsWith(setSql, ",")){
			setSql = setSql.substring(0,setSql.length()-1); 
		}
		return setSql;
	}
}
