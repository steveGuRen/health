package com.health.utils;

public class CodeBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private long createtime;
	
	public CodeBean() {
	}

	public CodeBean(String code, long createtime) {
		this.code = code;
		this.createtime = createtime;
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public long getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}
}
