package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThDeviceDao;
import com.health.model.ThDevice;
import com.health.model.ThNotification;
import com.health.utils.PageHelper;

@Repository
public class ThDeviceDaoImpl extends BaseDaoImpl<ThDevice> implements ThDeviceDao{

	@Override
	public List<ThDevice> getObjects(ThDevice item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThDevice t ";
		List<ThDevice> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThDevice item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThDevice item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThDevice get(ThDevice item) {
		// TODO Auto-generated method stub
		String hql = " from ThDevice t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThDevice result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThDevice item) {
		// TODO Auto-generated method stub
		if(item.getDeviceId() == null) {
			return null;
		}
		String hql = "update ThDevice t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.deviceId = :deviceId";
		params.put("deviceId", item.getDeviceId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	private String whereSql(ThDevice item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getDeviceId())) {
				whereSql += " and t.deviceId = :deviceId ";
				params.put("deviceId", item.getDeviceId());
			}
			if(StringUtils.isNotBlank(item.getDeviceType())) {
				whereSql += " and t.deviceType = :deviceType ";
				params.put("deviceType", item.getDeviceType());
			}
			if(StringUtils.isNotBlank(item.getDeviceName())) {
				whereSql += " and t.deviceName = :deviceName ";
				params.put("deviceName", item.getDeviceName());
			}
			if(item.getConnectTime() != null) {
				whereSql += " and t.connectTime = :connectTime ";
				params.put("connectTime", item.getConnectTime());
			}
			if(item.getTransportTime() != null) {
				whereSql += " and t.transportTime = :transportTime ";
				params.put("transportTime", item.getTransportTime());
			}
			if(item.getBluetoothSupport() != null) {
				whereSql += " and t.bluetoothSupport = :bluetoothSupport ";
				params.put("bluetoothSupport", item.getBluetoothSupport());
			}
			if(item.getMicroUsbsupport() != null) {
				whereSql += " and t.microUsbsupport = :microUsbsupport ";
				params.put("microUsbsupport", item.getMicroUsbsupport());
			}
			if(item.getUsbTypeCsupport() != null) {
				whereSql += " and t.usbTypeCsupport = :usbTypeCsupport ";
				params.put("usbTypeCsupport", item.getUsbTypeCsupport());
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
			if(StringUtils.isNotBlank(item.getSn())) {
				whereSql += " and t.sn = :sn ";
				params.put("sn", item.getSn());
			}
			if(StringUtils.isNotBlank(item.getDeviceStatus())) {
				whereSql += " and t.deviceStatus = :deviceStatus ";
				params.put("deviceStatus", item.getDeviceStatus());
			}
			if(StringUtils.isNotBlank(item.getMac())) {
				whereSql += " and t.mac = :mac ";
				params.put("mac", item.getMac());
			}
			if(StringUtils.isNotBlank(item.getImei())) {
				whereSql += " and t.imei = :imei ";
				params.put("imei", item.getImei());
			}
		}
		return whereSql;
	}

	private String setSql(ThDevice item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getDeviceId() != null) {
				setSql += " t.deviceId = :deviceIdNew,";
				params.put("deviceIdNew", item.getDeviceId());
			}
			if(item.getDeviceType() != null) {
				setSql += " t.deviceType = :deviceTypeNew,";
				params.put("deviceTypeNew", item.getDeviceType());
			}
			if(item.getDeviceName() != null) {
				setSql += " t.deviceName = :deviceNameNew,";
				params.put("deviceNameNew", item.getDeviceName());
			}
			if(item.getConnectTime() != null) {
				setSql += " t.connectTime = :connectTimeNew,";
				params.put("connectTimeNew", item.getConnectTime());
			}
			if(item.getTransportTime() != null) {
				setSql += " t.transportTime = :transportTimeNew,";
				params.put("transportTimeNew", item.getTransportTime());
			}
			if(item.getBluetoothSupport() != null) {
				setSql += " t.bluetoothSupport = :bluetoothSupportNew,";
				params.put("bluetoothSupportNew", item.getBluetoothSupport());
			}
			if(item.getMicroUsbsupport() != null) {
				setSql += " t.microUsbsupport = :microUsbsupportNew,";
				params.put("microUsbsupportNew", item.getMicroUsbsupport());
			}
			if(item.getUsbTypeCsupport() != null) {
				setSql += " t.usbTypeCsupport = :usbTypeCsupportNew,";
				params.put("usbTypeCsupportNew", item.getUsbTypeCsupport());
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
			if(item.getSn() != null) {
				setSql += " t.sn = :snNew,";
				params.put("snNew", item.getSn());
			}
			if(item.getDeviceStatus() != null) {
				setSql += " t.deviceStatus = :deviceStatusNew,";
				params.put("deviceStatusNew", item.getDeviceStatus());
			}
			if(item.getMac() != null) {
				setSql += " t.mac = :macNew,";
				params.put("macNew", item.getMac());
			}
			if(item.getImei() != null) {
				setSql += " t.imei = :imeiNew,";
				params.put("imeiNew", item.getImei());
			}
		}
		if(StringUtils.endsWith(setSql, ",")){
			setSql = setSql.substring(0,setSql.length()-1); 
		}
		return setSql;
	}

	private String getListSql(ThDevice item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.deviceId, "
				+ "t.deviceType, "
				+ "t.deviceName, "
				+ "t.connectTime, "
				+ "t.transportTime, "
				+ "t.bluetoothSupport, "
				+ "t.microUsbsupport, "
				+ "t.usbTypeCsupport, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser, "
				+ "t.sn, "
				+ "t.deviceStatus, "
				+ "t.mac, "
				+ "t.imei "
				+ "FROM "
				+ "th_device t ";
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
