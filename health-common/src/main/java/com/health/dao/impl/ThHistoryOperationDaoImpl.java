package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThHistoryOperationDao;
import com.health.model.ThHistoryOperation;
import com.health.model.ThHistoryOperation;
import com.health.utils.PageHelper;

@Repository
public class ThHistoryOperationDaoImpl extends BaseDaoImpl<ThHistoryOperation> implements ThHistoryOperationDao{

	@Override
	public List<ThHistoryOperation> getObjects(ThHistoryOperation item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThHistoryOperation t ";
		List<ThHistoryOperation> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThHistoryOperation item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThHistoryOperation item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThHistoryOperation get(ThHistoryOperation item) {
		// TODO Auto-generated method stub
		String hql = " from ThHistoryOperation t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThHistoryOperation result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThHistoryOperation item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThHistoryOperation t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String getListSql(ThHistoryOperation item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.operationName, "
				+ "t.operationTime, "
				+ "t.operationResult, "
				+ "t.userId, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser "
				+ "FROM "
				+ "th_history_operation t ";
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
	
	private String whereSql(ThHistoryOperation item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getOperationName())) {
				whereSql += " and t.operationName = :operationName ";
				params.put("operationName", item.getOperationName());
			}
			if(item.getOperationTime() != null) {
				whereSql += " and t.operationTime = :operationTime ";
				params.put("operationTime", item.getOperationTime());
			}
			if(StringUtils.isNotBlank(item.getOperationResult())) {
				whereSql += " and t.operationResult = :operationResult ";
				params.put("operationResult", item.getOperationResult());
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
	
	private String setSql(ThHistoryOperation item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getOperationName() != null) {
				setSql += " t.operationName = :operationNameNew,";
				params.put("operationNameNew", item.getOperationName());
			}
			if(item.getOperationTime() != null) {
				setSql += " t.operationTime = :operationTimeNew,";
				params.put("operationTimeNew", item.getOperationTime());
			}
			if(item.getOperationResult() != null) {
				setSql += " t.operationResult = :operationResultNew,";
				params.put("operationResultNew", item.getOperationResult());
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
