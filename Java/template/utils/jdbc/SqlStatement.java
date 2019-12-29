package com.vti.template.utils.jdbc;

/**
 * This class is contain sql statement
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 31, 2017
 */
public class SqlStatement {
	
	// login
	public static final String SQL_LOGIN_USER = 
		      "SELECT 	Email, FullName, Role, isBlock	"
		      + "FROM 	`User` "
		      + "WHERE 	Email = ? AND `Password` = ?";
	
	 // student
	 public static final String SELECT_ALL_STUDENT = 
		      "SELECT 	RN, Name, Age, Gender, Password "
		      + "FROM 	UserLoginInformationView";
	 
	  public static final String SQL_GET_ALL_USER_ORDER_USER = 
			  	"SELECT 	FullName, age, Email, Address "
		        +"FROM 		User "
		        +"WHERE 	Role = 'Student' "
		        +"ORDER BY ";
	 
	 public static final String SQL_CREATE_USER = 
		      "INSERT INTO 	User (ID, FullName, Email, Password, Age, PhoneNumber, Address, Role) " 
		      + "VALUES 			(?, ?, ?, ?,?,?,?,?)";
	 
	 public static final String SQL_BLOCK_USER = 
			 "UPDATE user "
			 +"SET isBlock = true "
			 +"WHERE Email = ?" ;
	 
	 public static final String SQL_DELETE_STUDENT = 
		      "DELETE " 
		      + "FROM	UserLoginInformationView "
		      + "WHERE 	RN = ?";
	 
	  public static final String SQL_EXITS_USER_BY_EMAIL = 
		      "SELECT 	1 "
		      + "FROM 	User "
		      + "WHERE 	Email = ? ";
	 
	  public static final String SQL_EXITS_STUDENT_BY_NAME = 
		      "SELECT 	RN, Name, Age, Gender, Password "
		      + "FROM 	UserLoginInformationView "
		      + "WHERE 	Name = ?";
}
