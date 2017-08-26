package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThGraphTempDao;
import com.health.model.ThGraphTemp;
import com.health.model.ThNotification;
import com.health.utils.PageHelper;;

@Repository
public class ThGraphTempDaoImpl extends BaseDaoImpl<ThGraphTemp> implements ThGraphTempDao{

	@Override
	public List<ThGraphTemp> getObjects(ThGraphTemp item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThGraphTemp t ";
		List<ThGraphTemp> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThGraphTemp item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThGraphTemp item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThGraphTemp get(ThGraphTemp item) {
		// TODO Auto-generated method stub
		String hql = " from ThGraphTemp t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThGraphTemp result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThGraphTemp item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThGraphTemp t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String whereSql(ThGraphTemp item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(item.getId() != null) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getQuotaName())) {
				whereSql += " and t.quotaName = :quotaName ";
				params.put("quotaName", item.getQuotaName());
			}
			if(item.getDiff() != null) {
				whereSql += " and t.diff = :diff ";
				params.put("diff", item.getDiff());
			}
			if(StringUtils.isNotBlank(item.getSource())) {
				whereSql += " and t.source = :source ";
				params.put("source", item.getSource());
			}
			if(StringUtils.isNotBlank(item.getTarget())) {
				whereSql += " and t.target = :target ";
				params.put("target", item.getTarget());
			}
			if(item.getCompareStartTime() != null) {
				whereSql += " and t.compareStartTime = :compareStartTime ";
				params.put("compareStartTime", item.getCompareStartTime());
			}
			if(item.getCompareEndTime() != null) {
				whereSql += " and t.compareEndTime = :compareEndTime ";
				params.put("compareEndTime", item.getCompareEndTime());
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

	private String setSql(ThGraphTemp item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(StringUtils.isNotBlank(item.getQuotaName())) {
				setSql += " t.quotaName = :quotaNameNew,";
				params.put("quotaNameNew", item.getQuotaName());
			}
			if(item.getDiff() != null) {
				setSql += " t.diff = :diffNew,";
				params.put("diffNew", item.getDiff());
			}
			if(StringUtils.isNotBlank(item.getSource())) {
				setSql += " t.source = :sourceNew,";
				params.put("sourceNew", item.getSource());
			}
			if(StringUtils.isNotBlank(item.getTarget())) {
				setSql += " t.target = :targetNew,";
				params.put("targetNew", item.getTarget());
			}
			if(item.getCompareStartTime() != null) {
				setSql += " t.compareStartTime = :compareStartTimeNew,";
				params.put("compareStartTimeNew", item.getCompareStartTime());
			}
			if(item.getCompareEndTime() != null) {
				setSql += " t.compareEndTime = :compareEndTimeNew,";
				params.put("compareEndTimeNew", item.getCompareEndTime());
			}
			if(item.getCreateTime() != null) {
				setSql += " t.createTime = :createTimeNew,";
				params.put("createTimeNew", item.getCreateTime());
			}
			if(item.getUpdateTime() != null) {
				setSql += " t.updateTime = :updateTimeNew,";
				params.put("updateTimeNew", item.getUpdateTime());
			}
			if(StringUtils.isNotBlank(item.getCreateUser())) {
				setSql += " t.createUser = :createUserNew,";
				params.put("createUserNew", item.getCreateUser());
			}
			if(StringUtils.isNotBlank(item.getUpdateUser())) {
				setSql += " t.updateUser = :updateUserNew,";
				params.put("updateUserNew", item.getUpdateUser());
			}
		}
		if(StringUtils.endsWith(setSql, ",")){
			setSql = setSql.substring(0, setSql.length() - 1); 
		}
		return setSql;
	}

	private String getListSql(ThGraphTemp item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.quotaName, "
				+ "t.diff, "
				+ "t.source, "
				+ "t.target, "
				+ "t.compareStartTime, "
				+ "t.compareEndTime, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser, "
				+ "a.userName "			
				+ "FROM "
				+ "th_graph_temp t "
				+ "join th_user a on(t.target = a.userId)";
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
}
