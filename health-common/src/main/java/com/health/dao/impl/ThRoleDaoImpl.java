package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.health.dao.ThRoleDao;
import com.health.model.ThRole;
import com.health.utils.PageHelper;


@Repository("ThRoleDaoImpl")
public class ThRoleDaoImpl extends BaseDaoImpl<ThRole> implements ThRoleDao {

	@Override
	public List<Map<String, Object>> getRoleList(Map<String, Object> params, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getRoleListSql(params, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows());     //这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public List<Map<String, Object>> getRoleListDetail(Map<String, Object> params, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getRoleListDetailSql(params, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows());     //这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public List<ThRole> getRoleList(ThRole role, PageHelper ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThRole t ";
		List<ThRole> roleList = find(hql
				+ whereHql(role, params) + orderHql(ph), params,
				ph.getPage(), ph.getRows());

		return roleList;
	}

	@Override
	public ThRole add(ThRole role) {
		save(role);
		return role;
	}

	@Override
	public ThRole get(ThRole role) {
		String hql = " from ThRole t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThRole t = get(hql+whereHql(role, params), params);
		return t;
	}

	@Override
	public Integer updateById(ThRole role) {
		if(role.getRoleId() == null ){
			return null;
		}
		String hql = " update ThRole t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(role,params);
		String whereIdHql = " where roleId = :roleId ";
		
		return executeHql(hql + setHql + whereIdHql, params);
	}

	@Override
	public Long getCountOfRole(Map<String, Object> params) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = "SELECT count(*) from (" + getRoleListSql(params,whereMap) + ") b";
		return (Long)countBySql(sql,whereMap);
	}

	@Override
	public Integer deleteRole(ThRole role) {
		Integer roleId = role.getRoleId();
		String hql = " delete ThRole t where t.roleId = :roleId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("roleId", roleId);
		return q.executeUpdate();
	}

	private String getRoleListSql(Map<String, Object> params, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT "
				+ "t.roleId, "
				+ "t.roleName, "
				+ "t.roleDescribe, "
				+ "a.typeId "
				+ "FROM "
				+ "th_role t "
				+ "LEFT JOIN th_role_menu a ON (a.roleId = t.roleId) "
				+ "LEFT JOIN th_menu b ON (a.menuId = b.menuId) ";
		String whereSql = whereSqlByMap(params, whereMap);
		return sql + whereSql;
	}
	
	public String whereSqlByMap(Map<String, Object> params, Map<String, Object> whereMap) {
		String whereSql = "";
		if (params != null && !params.isEmpty()) {
			whereSql += "where 1=1 ";
			for (String key : params.keySet()) {
				//查询参数

				if(StringUtils.equals(key, "roleId") && params.get(key) != null){                        
					whereSql += "and t.roleId = :roleId ";                 
					whereMap.put(key, params.get(key));                        
				}                                                                
				if(StringUtils.equals(key, "roleName") && StringUtils.isNotBlank((String) params.get(key))){                     
					whereSql += "and t.roleName like :roleName ";           
					whereMap.put(key, "%"+params.get(key)+"%");                        
				}        
				if(StringUtils.equals(key, "menuId") && params.get(key) != null){                        
					whereSql += "and b.menuId = :menuId ";                 
					whereMap.put(key, params.get(key));                        
				}    
				if(StringUtils.equals(key, "menuName") && StringUtils.isNotBlank((String) params.get(key))){                     
					whereSql += "and b.menuName = :menuName ";           
					whereMap.put(key, params.get(key));                        
				}    
				if(StringUtils.equals(key, "permission") && StringUtils.isNotBlank((String) params.get(key))){                     
					whereSql += "and a.permission = :permission ";           
					whereMap.put(key, params.get(key));                        
				}
			}                                                                      	
		}
		return whereSql;
	}
	
	/**
	 * 拼接ThRole， ThRoleMenu， ThMenu三张表的查询sql字符串
	 * @param params
	 * @return
	 */
	private String getRoleListDetailSql(Map<String, Object> params, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT "
				+ "t.roleId, "
				+ "t.roleName, "
				+ "t.roleDescribe, "
				+ "b.typeId, "
				+ "b.menuId, "
				+ "b.menuName, "
				+ "a.permission "
				+ "FROM "
				+ "th_role t LEFT JOIN th_role_menu a ON (a.roleId = t.roleId) "
				+ "LEFT JOIN th_menu b ON (a.menuId = b.menuId) ";
		String whereSql = whereSqlByMapDetail(params, whereMap);
		return sql + whereSql;
	}
	
	public String whereSqlByMapDetail(Map<String, Object> params, Map<String, Object> whereMap) {
		String whereSql = "";
		if (params != null && !params.isEmpty()) {
			whereSql += "where 1=1 ";
			for (String key : params.keySet()) {
				//查询参数

				if(StringUtils.equals(key, "roleId") && params.get(key) != null){                        
					whereSql += "and t.roleId = :roleId ";                 
					whereMap.put(key, params.get(key));                        
				}                                                                
				if(StringUtils.equals(key, "roleName") && StringUtils.isNotBlank((String) params.get(key))){                     
					whereSql += "and t.roleName = :roleName ";           
					whereMap.put(key, params.get(key));                        
				}        
				if(StringUtils.equals(key, "menuId") && params.get(key) != null){                        
					whereSql += "and b.menuId = :menuId ";                 
					whereMap.put(key, params.get(key));                        
				}    
				if(StringUtils.equals(key, "menuName") && StringUtils.isNotBlank((String) params.get(key))){                     
					whereSql += "and b.menuName = :menuName ";           
					whereMap.put(key, params.get(key));                        
				}    
				if(StringUtils.equals(key, "permission") && StringUtils.isNotBlank((String) params.get(key))){                     
					whereSql += "and a.permission = :permission ";           
					whereMap.put(key, params.get(key));                        
				}
			}                                                                      	
		}
		return whereSql;
	}
	
	private String whereHql(ThRole role, Map<String, Object> params) {
		String whereHql = "";
		if (role != null) {
			whereHql += " where 1=1 ";
			if(role.getRoleId() != null){
				whereHql += " and t.roleId = :roleId";
				params.put("roleId", role.getRoleId());
			}
			if(role.getRoleName() != null){
				whereHql += " and t.roleName = :roleName";
				params.put("roleName", role.getRoleName());
			}
			if(StringUtils.isNotBlank(role.getRoleDescribe())){
				whereHql += " and t.roleDescribe = :roleDescribe";
				params.put("roleDescribe", role.getRoleDescribe());
			}
		}
		return whereHql;
	}
	
	private String setHql(ThRole role,Map<String, Object> params){
		String setHql = "";
		if (role != null) {
			setHql += " set";
			if(role.getRoleId() != null){
				setHql += " t.roleId = :roleId,";
				params.put("roleId", role.getRoleId());
			}
			if(role.getRoleName() != null){
				setHql += " t.roleName = :roleName,";
				params.put("roleName", role.getRoleName());
			}
			if(role.getRoleDescribe() != null){
				setHql += " t.roleDescribe = :roleDescribe,";
				params.put("roleDescribe", role.getRoleDescribe());
			}		}
		if(StringUtils.endsWith(setHql, ",")){
			setHql = setHql.substring(0,setHql.length()-1); 
		}
		return setHql;
	}
}
