package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThHistoryMedicalDao;
import com.health.model.ThHistoryMedical;
import com.health.utils.PageHelper;

@Repository
public class ThHistoryMedicalDaoImpl extends BaseDaoImpl<ThHistoryMedical> implements ThHistoryMedicalDao{

	@Override
	public List<ThHistoryMedical> getObjects(ThHistoryMedical item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThHistoryMedical t ";
		List<ThHistoryMedical> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThHistoryMedical item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThHistoryMedical item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThHistoryMedical get(ThHistoryMedical item) {
		// TODO Auto-generated method stub
		String hql = " from ThHistoryMedical t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThHistoryMedical result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThHistoryMedical item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThHistoryMedical t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String getListSql(ThHistoryMedical item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.historyType, "
				+ "t.title, "
				+ "t.item, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_history_medical t ";
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
	
	private String whereSql(ThHistoryMedical item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getHistoryType())) {
				whereSql += " and t.historyType = :historyType ";
				params.put("historyType", item.getHistoryType());
			}
			if(StringUtils.isNotBlank(item.getTitle())) {
				whereSql += " and t.title = :title ";
				params.put("title", item.getTitle());
			}
			if(StringUtils.isNotBlank(item.getItem())) {
				whereSql += " and t.item = :item ";
				params.put("item", item.getItem());
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
	
	private String setSql(ThHistoryMedical item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getHistoryType() != null) {
				setSql += " t.historyType = :historyTypeNew,";
				params.put("historyTypeNew", item.getHistoryType());
			}
			if(item.getTitle() != null) {
				setSql += " t.title = :titleNew,";
				params.put("titleNew", item.getTitle());
			}
			if(item.getItem() != null) {
				setSql += " t.item = :itemNew,";
				params.put("itemNew", item.getItem());
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
