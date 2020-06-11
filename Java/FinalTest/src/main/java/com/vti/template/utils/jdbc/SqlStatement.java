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
	 public static final String SQL_LOGIN = 
		      "SELECT 	`Account`, `FullName`, `Role` "
		      + "FROM 	`User` "
		      + "WHERE 	`Account` = ? AND `Password` = ?";
	
	 // user	 
	 public static final String SQL_CREATE_USER = 
		      "INSERT INTO 	User (FirstName, LastName, password, Phone, email ) " 
		      + "VALUES 			(?, ?, ?, ? ,?)";
	 public static final String SQL_CREATE_MANAGER = 
		      "INSERT INTO 	Manager (expInYear) " 
		      + "VALUES 			(?)";
	 public static final String SQL_CREATE_EMPLOYEE = 
		      "INSERT INTO 	Employee (projectName , ProSkill) " 
		      + "VALUES 			(	?, 				?)";
	 public static final String SQL_EXITS_USER_BY_EMAIL = 
			 "SELECT 	1 " + "FROM 	User "
				+ "WHERE 	Email = ? ";
}
