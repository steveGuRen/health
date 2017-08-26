package com.health.manager;

import java.util.List;
import java.util.Map;

public interface RedisObjectCmd {
	
	public void set(String key, Object value);
	public void set(String key, Object value, long timeout);
	
	public Object get(String key);
}
