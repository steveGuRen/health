package com.health.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.health.dao.ThUserAddressDao;
import com.health.model.ThUser;
import com.health.model.ThUserAddress;

@Repository
public class ThUserAddressDaoImpl extends BaseDaoImpl<ThUserAddress> implements ThUserAddressDao{

	@Override
	public ThUserAddress saveUserAddress(ThUserAddress userAddress) {
		save(userAddress);
		return userAddress;
	}

	@Override
	public String deleteUserAddress(ThUserAddress userAddress) {
		String addressId = userAddress.getAddressId().toString();
		String hql = " delete ThUserAddress t where t.addressId = :addressId ";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter("addressId", addressId);
		q.executeUpdate();
		return addressId;
	}

	@Override
	public Integer updateAddressById(ThUserAddress userAddress) {
		if (userAddress.getAddressId() == null) {
			return null;
		}
		String hql = " update ThUserAddress t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setHql = setHql(userAddress, params);
		String whereIdHql = " where t.addressId = :addressId ";
		return executeHql(hql + setHql + whereIdHql, params);
	}

	private String setHql(ThUserAddress userAddress, Map<String, Object> params) {
		String setHql = "";		
		if (userAddress != null) {
			setHql += " set";
			if (userAddress.getAddressId() != null) {
				setHql += " t.addressId = :addressId,";
				params.put("addressId", userAddress.getAddressId());
			}
			if (userAddress.getUserId() != null) {
				setHql += " t.userId = :userId,";
				params.put("userId", userAddress.getUserId());
			}
			if (StringUtils.isNotBlank(userAddress.getName())) {
				setHql += " t.name = :name,";
				params.put("name", userAddress.getName());
			}
			if (StringUtils.isNotBlank(userAddress.getTel())) {
				setHql += " t.tel = :tel,";
				params.put("tel", userAddress.getTel());
			}
			if (StringUtils.isNotBlank(userAddress.getProvince())) {
				setHql += " t.province = :province,";
				params.put("province", userAddress.getProvince());
			}
			if (StringUtils.isNotBlank(userAddress.getCity())) {
				setHql += " t.city = :city,";
				params.put("city", userAddress.getCity());
			}
			if (StringUtils.isNotBlank(userAddress.getDistrict())) {
				setHql += " t.district = :district,";
				params.put("district", userAddress.getDistrict());
			}
			if (StringUtils.isNotBlank(userAddress.getDetailAddress())) {
				setHql += " t.detailAddress = :detailAddress,";
				params.put("detailAddress", userAddress.getDetailAddress());
			}
			if (StringUtils.isNotBlank(userAddress.getZipCode())) {
				setHql += " t.zipCode = :zipCode,";
				params.put("zipCode", userAddress.getZipCode());
			}
		}
		if (StringUtils.endsWith(setHql, ",")) {
			setHql = setHql.substring(0, setHql.length() - 1);
		}
		return setHql;
	}
}
