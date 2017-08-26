package com.health;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.manager.RedisCmd;
import com.health.manager.RedisObjectCmd;
import com.health.utils.Return2AndriodFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthWebApplication.class)
public class RedisTest {
	
	@Autowired
	RedisCmd cmd;
	
	@Autowired
	RedisObjectCmd ocmd;
	
	public void test() throws InterruptedException {

		cmd.SET("test", "helloworld");
		System.out.println(cmd.GET("test") + "denghuizhi");
	}
	
	@Test
	public void test2() throws InterruptedException, UnsupportedEncodingException {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("str", "aaaa");
		map.put("double", 2.0);
		list.add(map);
		ocmd.set("listmap", list);
		
		List<Map<String, Object>> result = (List<Map<String, Object>>) ocmd.get("listmap");
		
		ocmd.set("test", "denghuizhi");
		String test = (String) ocmd.get("test");
		String test2 = cmd.GET("test");
		System.out.println(JSONObject.toJSONString(Return2AndriodFormat.getResult(200, "令牌失效，无权访问！", result),
				SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat));
		
	}
	
	public void test3() throws UnsupportedEncodingException {
		System.out.println(new String("test").getBytes("UTF-8"));
		JdkSerializationRedisSerializer s = new JdkSerializationRedisSerializer();
		byte[] bbb = s.serialize("test");
		System.out.println(s.deserialize(bbb));
	}
}
