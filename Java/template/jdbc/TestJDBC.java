package com.vti.template.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * This class is test JDBC Connection.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public class TestJDBC {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/JavaFinalTest?autoReconnect=true&useSSL=false&characterEncoding=latin1";

		try {
			// connect database
			// username & password
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "root");

			Class.forName("com.mysql.cj.jdbc.Driver");

			// connect
			Connection connection = DriverManager.getConnection(jdbcUrl, properties);
			System.out.println("Connect successful!");

			// close connection
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
