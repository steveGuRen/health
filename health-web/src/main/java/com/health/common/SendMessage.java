package com.health.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.health.utils.CodeBean;
import com.health.utils.Random;

public class SendMessage {
	private static Logger log = LoggerFactory.getLogger(SendMessage.class);
	
	public static String CODE;
	public static Map<String, CodeBean> CODEMAP = new HashMap<String, CodeBean>();
	public static Map<String, Integer> CODE_NUMBER = new HashMap<String, Integer>();

	
	public static HashMap<String, Object> sendCode(String telphone){
		Random rand = new Random();	
		CODE = rand.getRandom();
		HashMap<String, Object> result = null;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();	
		//生产环境，任何人的手机号都可以用
		restAPI.init("app.cloopen.com", "8883");	
		restAPI.setAccount("aaf98f894f16fdb7014f24a9c87b111a", "ce42fe0a31054a399fa3990bab242af1");	
		restAPI.setAppId("8a48b5514fb1a66a014fb635512d0a17");		
		result = restAPI.sendTemplateSMS(telphone,"35963" ,new String[]{CODE,"5"});
		return result;
		
	}
	
}
