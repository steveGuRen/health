package com.health.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.mortbay.log.Log;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GenerateTXT {
	
	private String connectionUrl;
	private String filePath;
	private String sqlStr;
	
	public GenerateTXT() {
		
	}
	public GenerateTXT(String connectionUrl, String filePath, String sqlStr) {
		this.connectionUrl = connectionUrl;
		this.filePath = filePath;
		this.sqlStr = sqlStr;
	}
	
	public GenerateTXT configConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
		return this;
	}
	
	public GenerateTXT configFilePath(String filePath) {
		this.filePath = filePath;
		return this;
	}
	
	public GenerateTXT configSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
		return this;
	}
	
	public GenerateTXT generate() {
		if(this.connectionUrl == null) {
			throw new NullPointerException("connectionUrl is null");
		}
		if(this.filePath == null) {
			throw new NullPointerException("filePath is null");
		}
		if(this.sqlStr == null) {
			throw new NullPointerException("tableName is null");
		}
		//获得字段名
		Connection conn = null;
		Statement stmt = null;
		
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
            }
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file));
			BufferedWriter writer = new BufferedWriter(write);
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection(connectionUrl);
			stmt = (Statement) conn.createStatement();
			ResultSet rsCount = stmt.executeQuery("select count(*) as maxnum from (" + sqlStr + ") t");
			rsCount.next();
			Long count = rsCount.getLong("maxnum");    //表数据量
			long limit = 50000;    //每次从数据库表拿过来的数据以及每次写入到文件的条数
			long repeat = count / limit + 1;    //遍历标志
			
			for(long i = 0; i < repeat; i++) {
				String sql = "select * from (" + sqlStr + ") t limit " + new Long(i * limit) + "," + limit; 
				Log.info(sql);
				ResultSet set = stmt.executeQuery(sql);
				while(set.next()) {//遍历每一行
					ResultSetMetaData data = set.getMetaData();
					for(int j = 0; j < data.getColumnCount(); j++) {//遍历每一列的值
						String tem = set.getString(j + 1);
						if(tem == null) {
							writer.write("NULL");
						} else {
							writer.write(tem);
						}
						if(j != data.getColumnCount() - 1) {
							writer.write(",");
						}
					}
					writer.write("\n");
				}
				writer.flush();
			}
			writer.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
}
