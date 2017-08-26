package com.health.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author 秦召红
 * 验证码生成器
 *
 */
public class Random { 	
	private String[] beforeShuffle = new String[] {"1","2","3","4","5","6","7", "8","9"};
	
	public Random(){
		super();
	}
	public String getRandom(){	
		List list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < list.size(); i++) { 
			 sb.append(list.get(i));
		}
		String afterShuffle = sb.toString(); 
		return afterShuffle.substring(5, 9); 
	}
}