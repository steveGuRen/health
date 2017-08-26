package com.health.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.health.dao.ThUserDao;
import com.health.model.ThUser;
import com.health.utils.PageHelper;

@Repository
public class ThUserDaoImpl extends BaseDaoImpl<ThUser> implements ThUserDao {

	@Override
	public ThUser saveUser(ThUser user) {
		user.setUserId(UUID.randomUUID().toString());
		save(user);
		return user;
	}

	@Override
	public String deleteUser(ThUser user) {
		String userId = user.getUserId();
		String hql = " delete ThUser t where t.userId = :userId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("userId", userId);
		q.executeUpdate();
		return userId;
	}

	@Override
	public Integer updateById(ThUser user) {
		if (user.getUserId() == null) {
			return null;
		}
		String hql = " update ThUser t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(user, params);
		String whereIdHql = " where t.userId = :userId ";
		return executeHql(hql + setHql + whereIdHql, params);
	}

	@Override
	public ThUser get(ThUser user) {
		String hql = "from ThUser t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThUser t = get(hql + whereHql(user, params), params);
		return t;
	}

	@Override
	public List<Map<String, Object>> getUserInfo(ThUser user, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getUserInfoSql(user, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows()); // 这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public Long getCountOfUserList(ThUser user) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = "SELECT count(*) from (" + getUserInfoSql(user, whereMap) + ") d";
		return (Long) countBySql(sql, whereMap);
	}
	
	@Override
	public List<Map<String, Object>> getFollowMeList(ThUser user, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getFollowMeSql(user, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows()); // 这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public Long getCountOfFollowMeList(ThUser user) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = "SELECT count(*) from (" + getFollowMeSql(user, whereMap) + ") d";
		return (Long) countBySql(sql, whereMap);
	}

	@Override
	public List<Map<String, Object>> getMyFollowList(ThUser user, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getMyFollowSql(user, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows()); // 这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public Long getCountOfMyFollowList(ThUser user) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = "SELECT count(*) from (" + getMyFollowSql(user, whereMap) + ") d";
		return (Long) countBySql(sql, whereMap);
	}
	

	@Override
	public List<Map<String, Object>> getUnFollowedList(ThUser user, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getUnFollowedSql(user, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows()); // 这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public Long getCountOfUnFollowedList(ThUser user) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = "SELECT count(*) from (" + getUnFollowedSql(user, whereMap) + ") d";
		return (Long) countBySql(sql, whereMap);
	}

	
	private String setHql(ThUser user, Map<String, Object> params) {
		String setHql = "";		
		if (user != null) {
			setHql += " set";
			if (user.getUserId() != null) {
				setHql += " t.userId = :userId,";
				params.put("userId", user.getUserId());
			}
			if (user.getUserLoginName() != null) {
				setHql += " t.userLoginName = :userLoginName,";
				params.put("userLoginName", user.getUserLoginName());
			}
			if (user.getUserPassword() != null) {
				setHql += " t.userPassword = :userPassword,";
				params.put("userPassword", user.getUserPassword());
			}
			if (StringUtils.isNotBlank(user.getUserName())) {
				setHql += " t.userName = :userName,";
				params.put("userName", user.getUserName());
			}
			if (user.getGender() != null) {
				setHql += " t.gender = :gender,";
				params.put("gender", user.getGender());
			}
			if (user.getUserAge() != null) {
				setHql += " t.userAge = :userAge,";
				params.put("userAge", user.getUserAge());
			}
			if (StringUtils.isNotBlank(user.getUserIdCard())) {
				setHql += " t.userIdCard = :userIdCard,";
				params.put("userIdCard", user.getUserIdCard());
			}
			if (StringUtils.isNotBlank(user.getUserTel())) {
				setHql += " t.userTel = :userTel,";
				params.put("userTel", user.getUserTel());
			}
			if (StringUtils.isNotBlank(user.getUserEmail())) {
				setHql += " t.userEmail = :userEmail,";
				params.put("userEmail", user.getUserEmail());
			}
			if (user.getNickname() != null) {
				setHql += " t.nickname = :nickname,";
				params.put("nickname", user.getNickname());
			}
			if (StringUtils.isNotBlank(user.getImgUrl())) {
				setHql += " t.imgUrl = :imgUrl,";
				params.put("imgUrl", user.getImgUrl());
			}
			if (user.getOrganizationId() != null) {
				setHql += " t.organizationId = :organizationId,";
				params.put("organizationId", user.getOrganizationId());
			}
			if (user.getFlag() != null) {
				setHql += " t.flag = :flag,";
				params.put("flag", user.getFlag());
			}
			if (user.getUserType() != null) {
				setHql += " t.userType = :userType,";
				params.put("userType", user.getUserType());
			}
			if (user.getLastModifiedTime() != null) {
				setHql += " t.lastModifiedTime = :lastModifiedTime,";
				params.put("lastModifiedTime", user.getLastModifiedTime());
			}
		}
		if (StringUtils.endsWith(setHql, ",")) {
			setHql = setHql.substring(0, setHql.length() - 1);
		}
		return setHql;
	}

	public String whereHql(ThUser user, Map<String, Object> params) {
		String queryString = "";
		if (user != null) {
			queryString += "where 1=1 ";
			if (user.getUserId() != null) {
				queryString += "and t.userId = :userId ";
				params.put("userId", user.getUserId());
			}
			if (user.getUserLoginName() != null) {
				queryString += "and t.userLoginName = :userLoginName ";
				params.put("userLoginName", user.getUserLoginName());
			}
			if (StringUtils.isNotBlank(user.getUserName())) {
				queryString += "and t.userName = :userName ";
				params.put("userName", user.getUserName());
			}
			if (user.getAccessToken() != null) {
				queryString += "and t.accessToken = :accessToken ";
				params.put("accessToken", user.getAccessToken());
			}
			if (user.getCreatedTime() != null) {
				queryString += "and t.createdTime = :createdTime ";
				params.put("createdTime", user.getCreatedTime());
			}
			if (StringUtils.isNotBlank(user.getUserTel())) {
				queryString += "and t.userTel = :userTel ";
				params.put("userTel", user.getUserTel());
			}
			if (StringUtils.isNotBlank(user.getNickname())) {
				queryString += "and t.nickname = :nickname ";
				params.put("nickname", user.getNickname());
			}
			if (StringUtils.isNotBlank(user.getUserIdCard())) {
				queryString += "and t.userIdCard = :userIdCard ";
				params.put("userIdCard", user.getUserIdCard());
			}
			if (user.getGender() != null) {
				queryString += "and t.gender = :gender ";
				params.put("gender", user.getGender());
			}
			if (user.getOrganizationId() != null) {
				queryString += "and t.organizationId = :organizationId ";
				params.put("organizationId", user.getOrganizationId());
			}
			if (user.getFlag() != null) {
				queryString += "and t.flag = :flag ";
				params.put("flag", user.getFlag());
			}
			if (user.getUserType() != null) {
				queryString += "and t.userType = :userType ";
				params.put("userType", user.getUserType());
			}
			if (user.getOrganizationIds() != null && user.getOrganizationIds().size() != 0) {
				queryString += "and t.organizationId in (:organizationIds)";
				params.put("organizationIds", user.getOrganizationIds());
			}
			// 根据电话号码列表查询对应用户
			if (user.getUserTels() != null && user.getUserTels().size() != 0) {
				queryString += "and t.userTel in (:userTels)";
				params.put("userTels", user.getUserTels());
			}
			
		}
		return queryString;
	}

	private String getUserInfoSql(ThUser user, Map<String, Object> whereMap) {
		String whereSql = whereSqlByMap(user, whereMap);
		String sql = "SELECT DISTINCT " 
	            + "t.userId, " 
				+ "t.userLoginName, " 
	            + "t.userName, " 
				+ "t.gender, "
				+ "t.userAge, " 
				+ "t.userIdCard, " 
				+ "t.userTel, " 
				+ "t.userEmail, " 
				+ "t.nickname, " 
				+ "t.imgUrl,"
				+ "a.addressId,"
				+ "a.province,"
				+ "a.city,"
				+ "a.district,"
				+ "a.detailAddress "
				+ "FROM " 
				+ "(select * from th_user t "
				+ whereSql
				+ ") t left join th_user_address a on(t.userId = a.userId)";		
		return sql;
	}
	
	public String whereSqlByMap(ThUser user, Map<String, Object> whereMap) {
		String whereSql = "";
		if (user != null) {
			whereSql += "where 1=1 ";
			if (user.getUserId() != null) {
				whereSql += "and t.userId = :userId ";
				whereMap.put("userId", user.getUserId());
			}
			if (user.getUserLoginName() != null) {
				whereSql += "and t.userLoginName = :userLoginName ";
				whereMap.put("userLoginName", user.getUserLoginName());
			}
			if (StringUtils.isNotBlank(user.getUserName())) {
				whereSql += "and t.userName = :userName ";
				whereMap.put("userName", user.getUserName());
			}
			if (user.getAccessToken() != null) {
				whereSql += "and t.accessToken = :accessToken ";
				whereMap.put("accessToken", user.getAccessToken());
			}
			if (user.getCreatedTime() != null) {
				whereSql += "and t.createdTime = :createdTime ";
				whereMap.put("createdTime", user.getCreatedTime());
			}
			if (StringUtils.isNotBlank(user.getUserTel())) {
				whereSql += "and t.userTel = :userTel ";
				whereMap.put("userTel", user.getUserTel());
			}
			if (StringUtils.isNotBlank(user.getNickname())) {
				whereSql += "and t.nickname = :nickname ";
				whereMap.put("nickname", user.getNickname());
			}
			if (StringUtils.isNotBlank(user.getUserIdCard())) {
				whereSql += "and t.userIdCard = :userIdCard ";
				whereMap.put("userIdCard", user.getUserIdCard());
			}
			if (user.getGender() != null) {
				whereSql += "and t.gender = :gender ";
				whereMap.put("gender", user.getGender());
			}
			if (user.getOrganizationId() != null) {
				whereSql += "and t.organizationId = :organizationId ";
				whereMap.put("organizationId", user.getOrganizationId());
			}
			if (user.getFlag() != null) {
				whereSql += "and t.flag = :flag ";
				whereMap.put("flag", user.getFlag());
			}
			if (user.getUserType() != null) {
				whereSql += "and t.userType = :userType ";
				whereMap.put("userType", user.getUserType());
			}			
			// 根据电话号码列表查询对应用户
			if (user.getUserTels() != null && user.getUserTels().size() != 0) {
				whereSql += "and t.userTel in (:userTels)";
				whereMap.put("userTels", user.getUserTels());
			}
		}
		return whereSql;
	}	

	public List<Map<String, Object>> getUserAddress(String userId) {
		List<Map<String, Object>> addressList = new ArrayList<Map<String,Object>>();
		if (userId == null || userId.length() == 0)
			return addressList;
		String sql = "select distinct * from th_user_address t where t.userId = :userId";
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		addressList = getInfoListBySql(sql,params);
		return addressList;
	}
	
	private String getFollowMeSql(ThUser user, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT " 
	            + "t.userId, " 
				+ "t.userLoginName, "
				+ "t.userName, "
				+ "t.gender, "
				+ "t.userAge, "
				+ "t.userIdCard, "
				+ "t.userEmail, "  
				+ "t.userTel, " 
				+ "t.nickname, " 
				+ "t.imgUrl, "
				+ "a.followId, "
				+ "a.flag, "
				+ "a.isMutualFollowed, "
				+ "a.userRemark "
				+ "FROM "
				+ "(select * from th_user_follow where userId = :userId and flag !=0) a " //获取请求和已关注我的所有用户
				+ "left join th_user t on (a.followUserId = t.userId) ";
		if (user.getUserId() != null) {
			whereMap.put("userId", user.getUserId());
		}
		String whereSql = "where 1=1 ";
		if (StringUtils.isNotBlank(user.getSearchParams())) {
			whereSql += "and (t.userTel = :searchParams or t.userLoginName = :searchParams) ";
			whereMap.put("searchParams", user.getSearchParams());
		}
		return sql+whereSql;
	}
	
	private String getMyFollowSql(ThUser user, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT " 
				+ "t.userId, " 
				+ "t.userLoginName, "
				+ "t.userName, "
				+ "t.gender, "
				+ "t.userAge, "
				+ "t.userIdCard, "
				+ "t.userEmail, "  
				+ "t.userTel, " 
				+ "t.nickname, " 
				+ "t.imgUrl, "
				+ "a.followId, "
				+ "a.flag, "
				+ "a.isMutualFollowed, "
				+ "a.followerRemark "
				+ "FROM "
				+ "(select * from th_user_follow where followUserId = :followUserId and flag = 2) a " //获取我关注成功的用户
				+ "left join th_user t on (a.userId = t.userId) ";
		if (user.getUserId() != null) {
			whereMap.put("followUserId", user.getUserId());
		}
		String whereSql = "where 1=1 ";
		if (StringUtils.isNotBlank(user.getSearchParams())) {
			whereSql += "and (t.userTel = :searchParams or t.userLoginName = :searchParams) ";
			whereMap.put("searchParams", user.getSearchParams());
		}
		return sql+whereSql;
	}
	
	private String getUnFollowedSql(ThUser user, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT " 
				+ "t.userId, " 
				+ "t.userLoginName, " 
	            + "t.userName, " 
				+ "t.gender, "
				+ "t.userAge, " 
				+ "t.userIdCard, " 
				+ "t.userTel, " 
				+ "t.userEmail, " 
				+ "t.nickname, " 
				+ "t.imgUrl, "
				+ "a.followId, "
				+ "a.flag, "
				+ "a.isMutualFollowed, "
				+ "a.userRemark "
				+ "FROM "
				+ "(select * from th_user where userId not in (:userId)) t "
				+ "left join (select * from th_user_follow where followUserId = :followUserId and flag != 0) a "
				+ "on (a.userId = t.userId) ";
		if (user.getUserId() != null) {
			whereMap.put("followUserId", user.getUserId());
			whereMap.put("userId", user.getUserId());
		}
		String whereSql = "where 1=1 ";
		if (StringUtils.isNotBlank(user.getSearchParams())) {
			whereSql += "and (t.userTel = :searchParams or t.userLoginName = :searchParams) ";
			whereMap.put("searchParams", user.getSearchParams());
		}
		return sql+whereSql;
	}

	@Override
	public List<Map<String, Object>> getAdminListMap(ThUser admin, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getAdminListSql(admin, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows()); // 这里必须使用whereMap，而不是params
		for (Map<String, Object> tem : list) {
			String userId = String.valueOf(tem.get("userId"));
			List<String> rolelist = getRoles(userId);
			List<String> organizationlist = getOrganizations(userId);
			tem.put("roleList", rolelist);
			tem.put("organizationlist", organizationlist);
		}
		return list;
	}

	@Override
	public Long getCountOfAdminList(ThUser admin) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String sql = "SELECT count(*) from (" + getAdminListSql(admin, whereMap) + ") d";
		return (Long) countBySql(sql, whereMap);
	}
	
	@Override
	public List<Map<String, Object>> getAdminListDetail(Map<String, Object> params, PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		String orderSql = orderHql(ph);
		String sql = getAdminListDetailSql(params, whereMap) + orderSql;
		List<Map<String, Object>> list = getInfoListBySql(sql, whereMap, ph.getPage(), ph.getRows()); // 这里必须使用whereMap，而不是params
		return list;
	}

	@Override
	public List<ThUser> getAdminList(ThUser admin, PageHelper ph) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThUser t ";
		List<ThUser> adminlist = find(hql + whereHql(admin, params), params, ph.getPage(), ph.getRows());
		return adminlist;
	}

	@Override
	public Long getAdminListCount(ThUser admin) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "select count(*) from ThUser t ";
		return count(hql + whereHql(admin, params), params);
	}

	// 根据adminId,menuId，organizationIds查出某管理员对于某组织的某功能（menuId）的权限列表
	@Override
	public List<Map<String, Object>> getPermissionByMenuId(String userId, Integer menuId,
			List<Integer> organizationIds) {
		List<Map<String, Object>> permissions = new ArrayList<Map<String, Object>>();
		if (userId == null || userId == null || organizationIds == null || organizationIds.size() == 0)
			return permissions;
		String sql = "select distinct a.organizationId, t.permission from th_admin_role_organization a left join th_role_menu t on (t.roleId = a.roleId) where a.userId = ? and t.menuId = ? and a.organizationId in (:organizationIds)";
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		q.setParameter(0, userId);
		q.setParameter(1, menuId);
		q.setParameterList("organizationIds", organizationIds);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		permissions = q.list();
		return permissions;
	}

	// 根据adminId和menuId查出某管理员对于某功能（menuId）的权限列表（用于添加操作鉴权）
	@Override
	public List<Map<String, Object>> getAddPermissionByMenuId(String userId, Integer menuId) {
		List<Map<String, Object>> permissions = new ArrayList<Map<String, Object>>();
		if (userId == null || menuId == null)
			return permissions;
		String sql = "select distinct a.organizationId, t.permission from th_admin_role_organization a left join th_role_menu t on (t.roleId = a.roleId) where a.userId = ? and t.menuId = ? and t.permission LIKE '%1__' ";
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		q.setParameter(0, userId);
		q.setParameter(1, menuId);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		permissions = q.list();
		return permissions;
	}

	// 根据menuId和permission查出管理员列表
	@Override
	public List<Map<String, Object>> getAdminListByPermission(Integer menuId, String action) {
		List<Map<String, Object>> adminList = new ArrayList<Map<String, Object>>();
		if (action == null || action.length() == 0 || menuId == null || menuId.SIZE == 0)
			return adminList;
		String sql = "SELECT DISTINCT " 
				+ "t.userId, " 
				+ "t.userLoginName, " 
				+ "t.userName, " 
				+ "t.gender, " 
				+ "t.userTel, "
				+ "t.imgUrl " 
				+ "FROM " 
				+ "th_user t LEFT JOIN th_admin_role_organization a ON (a.userId = t.userId) "
				+ "LEFT JOIN th_organization b ON (a.organizationId = b.organizationId) "
				+ "LEFT JOIN th_role_menu c ON (c.roleId = a.roleId) " 
				+ "WHERE c.menuId = ? and c.permission like ? ";
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		q.setParameter(0, menuId);
		String permission;
		switch (action) {
		case "select": // [查、导出]
			permission = "%1";
			break;
		case "update":
			permission = "%1_";
			break;
		case "add":
			permission = "%1__";
			break;
		case "delete":
			permission = "%1___";
			break;
		case "import": // [导入]
			permission = "%1____";
			break;
		default:
			permission = "";
			break;
		}
		q.setParameter(1, permission);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		adminList = q.list();
		return adminList;
	}
	
	private String getAdminListSql(ThUser admin, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT " 
	            + "t.userId, " 
				+ "t.userLoginName, " 
	            + "t.userName, " 
				+ "t.gender, "
				+ "t.userTel, " 
				+ "t.userIdCard, " 
				+ "t.imgUrl, " 
				+ "t.flag, " 
				+ "t.userType, "
				+ "a.organizationName, " 
				+ "t.createdTime "
				+ "FROM " 
				+ "(select t.* from th_user t "
				+ whereSqlByMap(admin, whereMap)
				+ ") t "
				+ "LEFT JOIN th_organization a ON (a.organizationId = t.organizationId) ";
		
		//如果条件查询中包含根据角色查询，则进行连表查询
		if((admin.getRoleIds() != null && admin.getRoleIds().size() != 0) || (admin.getOrganizationIds() != null && admin.getOrganizationIds().size() != 0)){
			sql += "LEFT JOIN th_admin_role_organization b ON (t.userId = b.userId) where 1=1 ";
			if (admin.getRoleIds() != null && admin.getRoleIds().size() != 0) {
				sql += "and  b.roleId in (:roleIds)";
				whereMap.put("roleIds", admin.getRoleIds());
			}
			if (admin.getOrganizationIds() != null && admin.getOrganizationIds().size() != 0) {
				sql += "and b.organizationId in (:organizationIds) ";
				whereMap.put("organizationIds", admin.getOrganizationIds());
			}
		}
		return sql;
	}
	
	public List<String> getRoles(String userId) {
		List<String> roles = new ArrayList<String>();
		if (userId == null || userId.length() == 0)
			return roles;
		String sql = "select distinct a.roleName from th_admin_role_organization t JOIN th_role a ON (t.roleId = a.roleId) where t.userId =?";
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		q.setParameter(0, userId);
		roles = q.list();
		return roles;
	}
	
	public List<String> getOrganizations(String userId) {
		List<String> organizations = new ArrayList<String>();
		if (userId == null || userId.length() == 0)
			return organizations;
		String sql = "select distinct a.organizationName from th_admin_role_organization t JOIN th_organization a ON (t.organizationId = a.organizationId) where t.userId =?";
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		q.setParameter(0, userId);
		organizations = q.list();
		return organizations;
	}
	
	/**
	 * 拼接ThUser， ThRole， ThOrganization三张表的查询sql字符串
	 * 
	 * @param params
	 * @return
	 */
	private String getAdminListDetailSql(Map<String, Object> params, Map<String, Object> whereMap) {
		String sql = "SELECT DISTINCT " 
				+ "t.userId, " 
				+ "t.userLoginName, " 
				+ "t.userName, " 
				+ "t.userTel, "
				+ "t.gender, " 
				+ "t.userIdCard, " 
				+ "t.createdTime, " 
				+ "b.roleId, "
				+ "b.roleName, " 
				+ "a.organizationId, " 
				+ "c.typeId, " 
				+ "d.organizationName " 
				+ "FROM "
				+ "th_user t LEFT JOIN th_admin_role_organization a ON (a.userId = t.userId) "
				+ "LEFT JOIN th_role b ON (a.roleId = b.roleId) " 
				+ "LEFT JOIN th_role_menu c ON (a.roleId = c.roleId) "
				+ "LEFT JOIN th_organization d ON (a.organizationId = d.organizationId) ";
		String whereSql = whereSqlByMapDetail(params, whereMap);
		return sql + whereSql;
	}
	
	public String whereSqlByMapDetail(Map<String, Object> params, Map<String, Object> whereMap) {
		String whereSql = "";
		if (params != null && !params.isEmpty()) {
			whereSql += "where 1=1 ";
			for (String key : params.keySet()) {
				// 发布信息表的内容

				if (StringUtils.equals(key, "userId") && params.get(key) != null) {
					whereSql += "and t.userId = :userId ";
					whereMap.put(key, params.get(key));
				}
				if (StringUtils.equals(key, "userLoginName") && StringUtils.isNotBlank((String) params.get(key))) {
					whereSql += "and t.userLoginName = :userLoginName ";
					whereMap.put(key, params.get(key));
				}
				if (StringUtils.equals(key, "userName") && StringUtils.isNotBlank((String) params.get(key))) {
					whereSql += "and t.userName = :userName ";
					whereMap.put(key, params.get(key));
				}
				if (StringUtils.equals(key, "userTel") && params.get(key) != null) {
					whereSql += "and t.userTel = :userTel ";
					whereMap.put(key, params.get(key));
				}
				if (StringUtils.equals(key, "createdTime") && StringUtils.isNotBlank((String) params.get(key))) {
					whereSql += "and t.createdTime = :createdTime ";
					whereMap.put(key, params.get(key));
				}
				if (StringUtils.equals(key, "roleName") && StringUtils.isNotBlank((String) params.get(key))) {
					whereSql += "and b.roleName = :roleName ";
					whereMap.put(key, params.get(key));
				}
				if (StringUtils.equals(key, "organizationName") && StringUtils.isNotBlank((String) params.get(key))) {
					whereSql += "and d.organizationName = :organizationName ";
					whereMap.put(key, params.get(key));
				}
			}
		}
		return whereSql;
	}

	@Override
	public List<Integer> getOrganizationIds(String adminId, Integer menuId) {
		List<Integer> organizationIds = new ArrayList<Integer>();
		if (adminId == null || adminId.length() == 0 || menuId == null || menuId.SIZE == 0)
			return organizationIds;
		String sql = "select distinct t.organizationId from th_admin_role_organization t LEFT JOIN th_role_menu a ON (t.roleId = a.roleId) where t.userId =? and a.menuId = ? and a.permission like '%1' ";
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		q.setParameter(0, adminId);
		q.setParameter(1, menuId);
		organizationIds = q.list();
		return organizationIds;
	}

}
