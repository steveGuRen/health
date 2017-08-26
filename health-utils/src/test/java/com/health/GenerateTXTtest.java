package com.health;

import org.junit.Test;

import com.health.utils.GenerateTXT;

public class GenerateTXTtest {
	
	@Test
	public void test() {
		GenerateTXT txt = new GenerateTXT();
		txt.configConnectionUrl("jdbc:mysql://210.75.252.49:3306/health?user=root&password=zhongkjy")
		.configFilePath("C:/Users/steve/Downloads/txttest.txt")
		.configSqlStr("select * from th_role");
		txt.generate();
	}
}
