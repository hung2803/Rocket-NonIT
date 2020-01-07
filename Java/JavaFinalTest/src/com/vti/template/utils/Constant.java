package com.vti.template.utils;

/**
 * This class is constant.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 6, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 6, 2019
 */
public class Constant {

	// JDBC
	// Tutorial:
	// https://o7planning.org/vi/10227/thu-vien-dieu-khien-cac-loai-co-so-du-lieu-khac-nhau-trong-java
	// download driver here:
	// https://mvnrepository.com/artifact/mysql/mysql-connector-java

	// SQL Server
	// public static final String CONNECTION_STRING =
	// "jdbc:sqlserver://localhost;databasename=JavaFinalTest;integratedSecurity=true;CharacterSet=UTF-8;";
	// public static final String DRIVER_SQL_NAME =
	// "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	// MySQL
	public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/Quanlythisinh?autoReconnect=true&useSSL=false&characterEncoding=latin1&relaxAutoCommit=true";
	public static final String DRIVER_SQL_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String DATABASE_USERNAME = "root";
	public static final String DATABASE_PASSWORD = "root";

	// declare message for connect database
	public static final String ERROR_CONNECT_DATABASE_STR = "Error! connect database.";
	public static final String ERROR_DISCONNECT_DATABASE_STR = "Error! disconnect database.";
	public static final int ERROR_CONNECT_DATABASE_INT = -1;
	public static final int ERROR_SQL_EXCEPTION_INT = -2;
	public static final String ERROR_DRIVER_NAME = "Error! driver name.";
	public static final String SUCCESS = "Success!";
	public static final String ERROR = "Error";

	// scanner
	public static final String ERROR_VALIDATE_INT = "Invalid value, Please input interger: ";
	public static final String ERROR_VALIDATE_FLOAT = "Invalid value, Please input float: ";
	public static final String ERROR_VALIDATE_DOUBLE = "Invalid value, Please input double: ";
	public static final String ERROR_VALIDATE_STRING = "Invalid value, Please input string: ";

	// validate by regular expression
	public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String PATTERN_PASSWORD = "[A-z0-9@#$!^&%* `\\\\/-_]{6,30}";
	public static final String PATTERN_STRING = "[A-z0-9]{1,}";
	public static final String PATTERN_DATE = "\\d{4}-[01]";
	public static final String PATTERN_PHONE = "^[0-9]{11,}$";
	// firstName
	public static final String PATTERN_FIRSTNAME = "[A-Z][a-z]*";
	// lastName
	public static final String PATTERN_LASTNAME = "[A-Z]+([ '-][a-zA-Z]+)*";

	// abc

}
