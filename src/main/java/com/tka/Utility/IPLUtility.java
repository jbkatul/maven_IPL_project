package com.tka.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class IPLUtility {

	Connection conn=null;
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/AdvBatch226db";
	String user="root";
	String password="Vaibhavi@2004";
	public Connection connect() {
		try {
			Class.forName(path);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("Connected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}