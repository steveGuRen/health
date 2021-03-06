package com.health.model;
// Generated 2017-2-13 10:27:26 by Hibernate Tools 5.0.2.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * ThUser generated by hbm2java
 */
@Entity
@Table(name = "th_user", catalog = "health")
public class ThUser implements java.io.Serializable {

	private String userId;
	private String userLoginName;
	private String userPassword;
	private String userName;
	private Integer gender;
	private Integer userAge;
	private String userIdCard;
	private String userTel;
	private String userEmail;
	private String nickname;
	private String imgUrl;
	private Date createdTime;
	private Date lastModifiedTime;
	private Date lastLoginTime;
	private String accessToken;
	private Integer loginFailedTimes;
	private String randomCode;
	private Date lastLoginFailedTime;
	private Integer organizationId;
	private Integer flag;
	private Integer userType;
	/**
	 * 查询参数，组织列表，角色列表
	 */
	
	private List<Integer>  organizationIds = new ArrayList<Integer>();
	private List<Integer>  roleIds = new ArrayList<Integer>();
	
	/**
	 * 查询参数，电话号码列表
	 */
	
	private List<String>  userTels = new ArrayList<String>();
	
	private String  searchParams;
	/**
	 * 年龄查询参数
	 */
	private Integer userAgeStart;
	private Integer userAgeEnd;
	
	@Transient
	public Integer getUserAgeStart() {
		return userAgeStart;
	}

	public void setUserAgeStart(Integer userAgeStart) {
		this.userAgeStart = userAgeStart;
	}
	
	@Transient
	public Integer getUserAgeEnd() {
		return userAgeEnd;
	}

	public void setUserAgeEnd(Integer userAgeEnd) {
		this.userAgeEnd = userAgeEnd;
	}
	
	@Transient
	public List<String> getUserTels() {
		return userTels;
	}

	public void setUserTels(List<String> userTels) {
		this.userTels = userTels;
	}
	@Transient
	public List<Integer> getOrganizationIds() {
		return organizationIds;
	}

	public void setOrganizationIds(List<Integer> organizationIds) {
		this.organizationIds = organizationIds;
	}
	
	@Transient
	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	
	@Transient
	public String getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(String searchParams) {
		this.searchParams = searchParams;
	}

	public ThUser() {
	}

	public ThUser(String userId) {
		this.userId = userId;
	}

	public ThUser(String userId, String userLoginName, String userPassword, String userName, Integer gender,
			Integer userAge, String userIdCard, String userTel, String userEmail, String nickname, String imgUrl,
			Date createdTime, Date lastModifiedTime, Date lastLoginTime, String accessToken, Integer loginFailedTimes,
			String randomCode, Date lastLoginFailedTime, Integer organizationId, Integer flag, Integer userType) {
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userPassword = userPassword;
		this.userName = userName;
		this.gender = gender;
		this.userAge = userAge;
		this.userIdCard = userIdCard;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.nickname = nickname;
		this.imgUrl = imgUrl;
		this.createdTime = createdTime;
		this.lastModifiedTime = lastModifiedTime;
		this.lastLoginTime = lastLoginTime;
		this.accessToken = accessToken;
		this.loginFailedTimes = loginFailedTimes;
		this.randomCode = randomCode;
		this.lastLoginFailedTime = lastLoginFailedTime;
		this.organizationId = organizationId;
		this.flag = flag;
		this.userType = userType;
	}

	@Id

	@Column(name = "userId", unique = true, nullable = false, length = 50)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "userLoginName", length = 50)
	public String getUserLoginName() {
		return this.userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	@Column(name = "userPassword", length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "userAge")
	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Column(name = "userIdCard", length = 45)
	public String getUserIdCard() {
		return this.userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	@Column(name = "userTel", length = 45)
	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "userEmail", length = 45)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "nickname", length = 45)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "imgUrl", length = 1024)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdTime", length = 19)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModifiedTime", length = 19)
	public Date getLastModifiedTime() {
		return this.lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastLoginTime", length = 19)
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "accessToken", length = 45)
	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "loginFailedTimes")
	public Integer getLoginFailedTimes() {
		return this.loginFailedTimes;
	}

	public void setLoginFailedTimes(Integer loginFailedTimes) {
		this.loginFailedTimes = loginFailedTimes;
	}

	@Column(name = "randomCode", length = 45)
	public String getRandomCode() {
		return this.randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastLoginFailedTime", length = 19)
	public Date getLastLoginFailedTime() {
		return this.lastLoginFailedTime;
	}

	public void setLastLoginFailedTime(Date lastLoginFailedTime) {
		this.lastLoginFailedTime = lastLoginFailedTime;
	}
	@Column(name = "organizationId")
	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	@Column(name = "flag")
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	@Column(name = "userType")
	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "ThUser [userId=" + userId + ", userLoginName=" + userLoginName + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", gender=" + gender + ", userAge=" + userAge + ", userIdCard="
				+ userIdCard + ", userTel=" + userTel + ", userEmail=" + userEmail + ", nickname=" + nickname
				+ ", imgUrl=" + imgUrl + ", createdTime=" + createdTime + ", lastModifiedTime=" + lastModifiedTime
				+ ", lastLoginTime=" + lastLoginTime + ", accessToken=" + accessToken + ", loginFailedTimes="
				+ loginFailedTimes + ", randomCode=" + randomCode + ", lastLoginFailedTime=" + lastLoginFailedTime
				+ ", organizationId=" + organizationId + ", flag=" + flag + ", userType=" + userType
				+ ", organizationIds=" + organizationIds + ", roleIds=" + roleIds + ", userTels=" + userTels
				+ ", searchParams=" + searchParams + ", userAgeStart=" + userAgeStart + ", userAgeEnd=" + userAgeEnd
				+ "]";
	}

	
}
