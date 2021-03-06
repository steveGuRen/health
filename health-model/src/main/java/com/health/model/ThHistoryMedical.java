package com.health.model;
// Generated 2017-2-13 10:27:26 by Hibernate Tools 5.0.2.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ThMedicalHistory generated by hbm2java
 */
@Entity
@Table(name = "th_history_medical", catalog = "health")
public class ThHistoryMedical implements java.io.Serializable {

	private String id;
	private String historyType;
	private String title;
	private String item;
	private String userId;
	private Date createTime;
	private Date updateTime;
	private String createUser;
	private String updateUser;

	public ThHistoryMedical() {
	}

	public ThHistoryMedical(String id) {
		this.id = id;
	}

	public ThHistoryMedical(String id, String historyType, String title, String item, String userId, Date createTime,
			Date updateTime, String createUser, String updateUser) {
		this.id = id;
		this.historyType = historyType;
		this.title = title;
		this.item = item;
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.createUser = createUser;
		this.updateUser = updateUser;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 45)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "historyType", length = 45)
	public String getHistoryType() {
		return this.historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	@Column(name = "title", length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "item", length = 45)
	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "userId", length = 45)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateTime", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "createUser", length = 45)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "updateUser", length = 45)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
