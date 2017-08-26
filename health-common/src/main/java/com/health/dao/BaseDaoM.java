package com.health.dao;

import java.util.List;
import java.util.Map;

import com.health.utils.PageHelper;
//import com.jeocloud.fn.model.FnChargeItem;
//import com.jeocloud.fn.utils.PageHelper;
/**
 * 定义了基本的DAO接口方法
 * @author steve
 *
 * @param <T>
 */
public interface BaseDaoM<T> {
	
	public List<T> getObjects(T item, PageHelper ph);
	
	/**
	 * 分页查询列表
	 * @param item
	 * @param ph
	 * @return
	 */
	public List<Map<String, Object>> getList(T item, PageHelper ph);
	/**
	 * 获得列表的总个数
	 * @param item
	 * @return
	 */
	public Long getListCount(T item);
	
	/**
	 * 返回单个记录
	 * @param item
	 * @return
	 */
	public T get(T item);
	/**
	 * 返回更新次数
	 * @param item
	 * @return
	 */
	public Integer updateById(T item);
	
}