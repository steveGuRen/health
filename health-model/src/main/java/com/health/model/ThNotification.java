package com.health.model;
// Generated 2017-2-13 10:27:26 by Hibernate Tools 5.0.2.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ThNotification generated by hbm2java
 */
@Entity
@Table(name = "th_notification", catalog = "health")
public class ThNotification implements java.io.Serializable {

	private Integer notificationId;
	private String summary;
	private String title;
	private String content;
	private String contentType;
	private String action;
	private Integer weight;
	private Integer activeTime;
	private String templateUrl;
	private String type;
	private String userId;
	private Date createTime;
	private Date updateTime;
	private String createUser;
	private String updateUser;

	public ThNotification() {
	}

	public ThNotification(String summary, String title, String content, String contentType, String action,
			Integer weight, Integer activeTime, String templateUrl, String type, String userId, Date createTime,
			Date updateTime, String createUser, String updateUser) {
		this.summary = summary;
		this.title = title;
		this.content = content;
		this.contentType = contentType;
		this.action = action;
		this.weight = weight;
		this.activeTime = activeTime;
		this.templateUrl = templateUrl;
		this.type = type;
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.createUser = createUser;
		this.updateUser = updateUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "notificationId", unique = true, nullable = false)
	public Integer getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	@Column(name = "summary", length = 450)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "title", length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 20000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "contentType", length = 45)
	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name = "action", length = 45)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "activeTime")
	public Integer getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Integer activeTime) {
		this.activeTime = activeTime;
	}

	@Column(name = "templateUrl", length = 200)
	public String getTemplateUrl() {
		return this.templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
