package com.health.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.health.dao.ThUserInfoDao;
import com.health.dao.ThUserInfoDao;
import com.health.model.ThUserInfo;
import com.health.model.ThUserInfo;
import com.health.utils.PageHelper;

@Repository
public class ThUserInfoDaoImpl extends BaseDaoImpl<ThUserInfo> implements ThUserInfoDao{

	@Override
	public List<ThUserInfo> getObjects(ThUserInfo item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from ThUserInfo t ";
		List<ThUserInfo> list = find(hql
				+ whereSql(item, params) + orderHql(ph) , params,
				ph.getPage(), ph.getRows());
		return list;
	}

	@Override
	public List<Map<String, Object>> getList(ThUserInfo item, PageHelper ph) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> list = getInfoListBySql(getListSql(item, params, ph), params);
		return list;
	}

	@Override
	public Long getListCount(ThUserInfo item) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "select count(*) from ("
				+ getListSql(item, params, null)
				+ ") count";
		return countBySql(sql, params);
	}

	@Override
	public ThUserInfo get(ThUserInfo item) {
		// TODO Auto-generated method stub
		String hql = " from ThUserInfo t ";
		Map<String, Object> params = new HashMap<String, Object>();
		ThUserInfo result = get(hql + whereSql(item,  params), params);
		return item;
	}

	@Override
	public Integer updateById(ThUserInfo item) {
		// TODO Auto-generated method stub
		if(item.getId() == null) {
			return null;
		}
		String hql = "update ThUserInfo t ";
		Map<String, Object> params = new HashMap<String, Object>();
		String setSql = setSql(item, params);
		String whereIdHql = " where t.id = :id";
		params.put("id", item.getId());
		return executeHql(hql + setSql + whereIdHql, params);
	}

	
	private String whereSql(ThUserInfo item, Map<String, Object> params) {
		String whereSql = "";
		whereSql += " where 1=1 ";
		if(item != null) {
			if(StringUtils.isNotBlank(item.getId())) {
				whereSql += " and t.id = :id ";
				params.put("id", item.getId());
			}
			if(StringUtils.isNotBlank(item.getHeadPortrait())) {
				whereSql += " and t.headPortrait = :headPortrait ";
				params.put("headPortrait", item.getHeadPortrait());
			}
			if(StringUtils.isNotBlank(item.getNationality())) {
				whereSql += " and t.nationality = :nationality ";
				params.put("nationality", item.getNationality());
			}
			if(item.getVillage() != null) {
				whereSql += " and t.village = :village ";
				params.put("village", item.getVillage());
			}
			if(item.getNation() != null) {
				whereSql += " and t.nation = :nation ";
				params.put("nation", item.getNation());
			}
			if(item.getWeight() != null) {
				whereSql += " and t.weight = :weight ";
				params.put("weight", item.getWeight());
			}
			if(item.getBloodType() != null) {
				whereSql += " and t.bloodType = :bloodType ";
				params.put("bloodType", item.getBloodType());
			}
			if(item.getEducation() != null) {
				whereSql += " and t.education = :education ";
				params.put("education", item.getEducation());
			}
			if(StringUtils.isNotBlank(item.getResidentType())) {
				whereSql += " and t.residentType = :residentType ";
				params.put("residentType", item.getResidentType());
			}
			if(StringUtils.isNotBlank(item.getEmergencyContact())) {
				whereSql += " and t.emergencyContact = :emergencyContact ";
				params.put("emergencyContact", item.getEmergencyContact());
			}
			if(StringUtils.isNotBlank(item.getWorkUnit())) {
				whereSql += " and t.workUnit = :workUnit ";
				params.put("workUnit", item.getWorkUnit());
			}
			if(StringUtils.isNotBlank(item.getGender())) {
				whereSql += " and t.gender = :gender ";
				params.put("gender", item.getGender());
			}
			if(item.getBirthday() != null) {
				whereSql += " and t.birthday = :birthday ";
				params.put("birthday", item.getBirthday());
			}
			if(StringUtils.isNotBlank(item.getNativePlace())) {
				whereSql += " and t.nativePlace = :nativePlace ";
				params.put("nativePlace", item.getNativePlace());
			}
			if(StringUtils.isNotBlank(item.getNeighborhoodCommittee())) {
				whereSql += " and t.neighborhoodCommittee = :neighborhoodCommittee ";
				params.put("neighborhoodCommittee", item.getNeighborhoodCommittee());
			}
			if(StringUtils.isNotBlank(item.getHeight())) {
				whereSql += " and t.height = :height ";
				params.put("height", item.getHeight());
			}
			if(StringUtils.isNotBlank(item.getStep())) {
				whereSql += " and t.step = :step ";
				params.put("step", item.getStep());
			}
			if(StringUtils.isNotBlank(item.getRh())) {
				whereSql += " and t.rh = :rh ";
				params.put("rh", item.getRh());
			}
			if(StringUtils.isNotBlank(item.getMaritalStatus())) {
				whereSql += " and t.maritalStatus = :maritalStatus ";
				params.put("maritalStatus", item.getMaritalStatus());
			}
			if(StringUtils.isNotBlank(item.getAddress())) {
				whereSql += " and t.address = :address ";
				params.put("address", item.getAddress());
			}
			if(StringUtils.isNotBlank(item.getEmergencyPerson())) {
				whereSql += " and t.emergencyPerson = :emergencyPerson ";
				params.put("emergencyPerson", item.getEmergencyPerson());
			}
			if(StringUtils.isNotBlank(item.getOccupation())) {
				whereSql += " and t.occupation = :occupation ";
				params.put("occupation", item.getOccupation());
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

	private String setSql(ThUserInfo item, Map<String, Object> params) {
		String setSql = "";
		if(item != null) {
			setSql += " set ";
			if(item.getId() != null) {
				setSql += " t.id = :idNew,";
				params.put("idNew", item.getId());
			}
			if(item.getHeadPortrait() != null) {
				setSql += " t.headPortrait = :headPortraitNew,";
				params.put("headPortraitNew", item.getHeadPortrait());
			}
			if(item.getNationality() != null) {
				setSql += " t.nationality = :nationalityNew,";
				params.put("nationalityNew", item.getNationality());
			}
			if(item.getVillage() != null) {
				setSql += " t.village = :villageNew,";
				params.put("villageNew", item.getVillage());
			}
			if(item.getNation() != null) {
				setSql += " t.nation = :nationNew,";
				params.put("nationNew", item.getNation());
			}
			if(item.getWeight() != null) {
				setSql += " t.weight = :weightNew,";
				params.put("weightNew", item.getWeight());
			}
			if(item.getBloodType() != null) {
				setSql += " t.bloodType = :bloodTypeNew,";
				params.put("bloodTypeNew", item.getBloodType());
			}
			if(item.getEducation() != null) {
				setSql += " t.education = :educationNew,";
				params.put("educationNew", item.getEducation());
			}
			if(item.getResidentType() != null) {
				setSql += " t.residentType = :residentTypeNew,";
				params.put("residentTypeNew", item.getResidentType());
			}
			if(item.getEmergencyContact() != null) {
				setSql += " t.emergencyContact = :emergencyContactNew,";
				params.put("emergencyContactNew", item.getEmergencyContact());
			}
			if(item.getWorkUnit() != null) {
				setSql += " t.workUnit = :workUnitNew,";
				params.put("workUnitNew", item.getWorkUnit());
			}
			if(item.getGender() != null) {
				setSql += " t.gender = :genderNew,";
				params.put("genderNew", item.getGender());
			}
			if(item.getBirthday() != null) {
				setSql += " t.birthday = :birthdayNew,";
				params.put("birthdayNew", item.getBirthday());
			}
			if(item.getNativePlace() != null) {
				setSql += " t.nativePlace = :nativePlaceNew,";
				params.put("nativePlaceNew", item.getNativePlace());
			}
			if(item.getNeighborhoodCommittee() != null) {
				setSql += " t.neighborhoodCommittee = :neighborhoodCommitteeNew,";
				params.put("neighborhoodCommitteeNew", item.getNeighborhoodCommittee());
			}
			if(item.getHeight() != null) {
				setSql += " t.height = :heightNew,";
				params.put("heightNew", item.getHeight());
			}
			if(item.getStep() != null) {
				setSql += " t.step = :stepNew,";
				params.put("stepNew", item.getStep());
			}
			if(item.getRh() != null) {
				setSql += " t.rh = :rhNew,";
				params.put("rhNew", item.getRh());
			}
			if(item.getMaritalStatus() != null) {
				setSql += " t.maritalStatus = :maritalStatusNew,";
				params.put("maritalStatusNew", item.getMaritalStatus());
			}
			if(item.getAddress() != null) {
				setSql += " t.address = :addressNew,";
				params.put("addressNew", item.getAddress());
			}
			if(item.getEmergencyPerson() != null) {
				setSql += " t.emergencyPerson = :emergencyPersonNew,";
				params.put("emergencyPersonNew", item.getEmergencyPerson());
			}
			if(item.getOccupation() != null) {
				setSql += " t.occupation = :occupationNew,";
				params.put("occupationNew", item.getOccupation());
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

	private String getListSql(ThUserInfo item, Map<String, Object> params, PageHelper ph) {
		String sql = "SELECT "
				+ "t.id, "
				+ "t.headPortrait, "
				+ "t.nationality, "
				+ "t.village, "
				+ "t.nation, "
				+ "t.weight, "
				+ "t.bloodType, "
				+ "t.education, "
				+ "t.residentType, "
				+ "t.emergencyContact, "
				+ "t.workUnit, "
				+ "t.gender, "
				+ "t.birthday, "
				+ "t.nativePlace, "
				+ "t.neighborhoodCommittee, "
				+ "t.height, "
				+ "t.step, "
				+ "t.rh, "
				+ "t.maritalStatus, "
				+ "t.address, "
				+ "t.emergencyPerson, "
				+ "t.occupation, "
				+ "t.createTime, "
				+ "t.updateTime, "
				+ "t.createUser, "
				+ "t.updateUser, "
				+ "t.userId "
				+ "FROM "
				+ "th_user_info t ";
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
