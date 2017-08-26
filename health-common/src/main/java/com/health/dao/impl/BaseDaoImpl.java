package com.health.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.health.dao.BaseDaoI;
import com.health.utils.PageHelper;

@Repository("healthBaseDaoImpl")
public class BaseDaoImpl<T> implements BaseDaoI<T> {
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	//供旧接口使用
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void persist(T o) {
		// TODO Auto-generated method stub
		if (o != null) {
			this.getCurrentSession().persist(o);
		}
	}
	@Override
	public Serializable save(T o) {
		if (o != null) {
			return this.getCurrentSession().save(o);
		}
		return null;
	}
	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}
	@Override
	public T get(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}
	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
				
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}
	@Override
	public void delete(T o) {
		if (o != null) {
			this.getCurrentSession().delete(o);
		}
	}
	@Override
	public void update(T o) {
		if (o != null) {
			this.getCurrentSession().update(o);
		}
	}
	@Override
	public void saveOrUpdate(T o) {
		if (o != null) {
			this.getCurrentSession().saveOrUpdate(o);
		}
	}
	@Override
	public List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	@Override
	public Long count(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		BigInteger bi = (BigInteger) q.uniqueResult();
		return bi.longValue();
	}
	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		Long bi = (Long) q.uniqueResult();
		return bi;
	}
	@Override
	public int executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}
	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.executeUpdate();
	}
	
	@Override
	public List<Object[]> findBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.list();
	}
	@Override
	public List<Object[]> findBySql(String sql, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.list();
	}
	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	@Override
	public int executeSql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}
	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.executeUpdate();
	}
	@Override
	public Long countBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		BigInteger bi = (BigInteger) q.uniqueResult();
		return bi.longValue();
	}
	@Override
	public Long countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		BigInteger bi = (BigInteger) q.uniqueResult();
		return bi.longValue();
	}
	@Override
	public List<Map<String, Object>> getInfoListBySql(String sql,
			Map<String, Object> params, int page, int rows) {
        Query q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        q.setFirstResult((page - 1) * rows);
        q.setMaxResults(rows);
        List<Map<String, Object>> list = q.list();
        return list;
	}
	@Override
	public List<Map<String, Object>> getInfoListBySqlForExcel(String sql,
			Map<String, Object> params, int page,int pageEnd, int rows) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.setFirstResult((page - 1) * rows);
		q.setMaxResults((pageEnd-page+1)*rows);
		List<Map<String, Object>> list = q.list();
		return list;
	}
	@Override
	public List<Map<String, Object>> getInfoListBySql(String sql,
			Map<String, Object> params) {
        Query q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if(params.get(key) instanceof Collection) {
					q.setParameterList(key, (Collection) params.get(key));
				}else {
					q.setParameter(key, params.get(key));
				}
			}
		}
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return q.list();
	}
	
	@Override
	public List<Map<String, Object>> getInfoListBySql(String sql) {
        Query q = this.getCurrentSession().createSQLQuery(sql);
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return q.list();
	}
	@Override
	public List<Map<String, Object>> getInfoListBySql(String sql, int page,
			int rows) {
		Query q = this.getCurrentSession().createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	public String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph !=null && StringUtils.isNotBlank(ph.getSort()) && StringUtils.isNotBlank(ph.getOrder())) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}
	
	public String orderHqlByNum(PageHelper ph) {
		String orderString = "";
		if (ph !=null && StringUtils.isNotBlank(ph.getSort()) && StringUtils.isNotBlank(ph.getOrder())) {
			orderString = " order by t." + ph.getSort() + "+0 " + ph.getOrder();
		}
		return orderString;
	}
	public String orderBySql(PageHelper ph) {
		String orderString = "";
		if (ph !=null && StringUtils.isNotBlank(ph.getSort()) && StringUtils.isNotBlank(ph.getOrder())) {
			orderString = " order by " + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}
	
	
}