package com.health.utils;


public final class GlobalConstant {
	
	public final static String YES="YES";	
	
	//有效
	public final static Integer AVAILABLE = 1;
	//无效
	public final static Integer INVALID = 0;
	//私有
	public final static Integer INDIVIDUAL = 1;
	//非私有
	public final static Integer NOT_INDIVIDUAL = 0;
	
	public final static Integer IS_PUBLISHED = 1;
	
	public final static Integer NOT_PUBLISHED = 0;
	
	public final static Integer IS_TRANSACTION = 1;
	
	public final static Integer NOT_TRANSACTION = 0;
	public final static Integer MYSELF_RESOURCES = -1;
	public final static Integer ALL_RESOURCES = -2;
	
	//tb_file表的type字段取值
	public final static Integer HOUSERESOURCE_TYPE = 1; //房源
	public final static Integer HOUSESERVICE_TYPE = 2; //家政
	
	//短信验证半小时常量
	public final static long MAXIMUM_TIME = 1000*60*30;
	//每人每天可以发送的最大短信数
	public final static long CODE_MAX_NUMBER = 100;
	
	
	
}
