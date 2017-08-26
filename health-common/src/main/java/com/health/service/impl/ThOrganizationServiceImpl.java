package com.health.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ThOrganizationDao;
import com.health.model.ThOrganization;
import com.health.service.ThOrganizationService;
import com.health.utils.PageHelper;

@Service
@Transactional
public class ThOrganizationServiceImpl implements ThOrganizationService {

	@Autowired
	ThOrganizationDao organizationDao;
	
	@Override
	public List<ThOrganization> getOrganizationList(ThOrganization organization, PageHelper ph) {
		return organizationDao.getOrganizationList(organization, ph);
	}

	@Override
	public Long getCountOfOrganization(ThOrganization organization) {
		return organizationDao.getCountOfOrganization(organization);
	}

	@Override
	public ThOrganization add(ThOrganization organization) {
		return organizationDao.add(organization);
	}

	@Override
	public ThOrganization get(ThOrganization organization) {
		return organizationDao.get(organization);
	}

	@Override
	public Integer updateById(ThOrganization organization) {
		return organizationDao.updateById(organization);
	}

	@Override
	public Integer deleteOrganization(ThOrganization organization) {
		return organizationDao.deleteOrganization(organization);
	}

}
