package com.health.manager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisObjectCmdImpl extends RedisTemplate<String, Object> implements RedisObjectCmd{

	@Override
	public void set(String key, Object value) {
		// TODO Auto-generated method stub
		try {
			opsForValue().set(key, value);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void set(String key, Object value, long timeout) {
		// TODO Auto-generated method stub
		try {
			opsForValue().set(key, value, timeout, TimeUnit.SECONDS);  			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		try {
			Object o = opsForValue().get(key);
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
