package com.health.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThMenuDao;
import com.health.model.ThMenu;
import com.health.service.ThMenuService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThMenuServiceImpl implements ThMenuService {

	@Autowired
	ThMenuDao menuDao;
	
	@Override
	public List<ThMenu> getMenuList(ThMenu menu, PageHelper ph) {
		return menuDao.getMenuList(menu, ph);
	}

	@Override
	public Serializable add(ThMenu menu) {
		return menuDao.add(menu);
	}

	@Override
	public ThMenu get(ThMenu menu) {
		return menuDao.get(menu);
	}

	@Override
	public Integer updateById(ThMenu menu) {
		return menuDao.updateById(menu);
	}

	@Override
	public Long getCountOfMenu(ThMenu menu) {
		return menuDao.getCountOfMenu(menu);
	}

}
