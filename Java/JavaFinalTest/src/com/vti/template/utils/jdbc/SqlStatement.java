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
			"SELECT 	 FirstName, LastName" + "FROM 	`User` "
			+ "WHERE 	Email = ? AND `Password` = ? ";

	public static final String SQL_CREATE_CANDIDATE = 
			"INSERT INTO 	Candidate (FirstName,lastName, Email, Password, Phone,IDRole) "
			+ "VALUES 			(?,?,?,?,?,?)";

	public static final String SQL_CREATE_EXPERIENCE_CANDIDATE = 
			"INSERT INTO 	ExperienceCandidate (IDCandidate, ExpInYear,ProSkill) "
					+"SELECT 	IDCandidate, ? ,? "
					+"FROM 		Candidate " ;
	
	public static final String SQL_CREATE_FRESHER_CANDIDATE = 
			"INSERT INTO FresherCandidate (IDCandidate,		GraduationRank) " 
			+"SELECT 	IDCandidate, ? AS  GraduationRank "
			+"FROM 		Candidate "
			+"WHERE 	Email = ?";
	
	
	public static final String SQL_EXITS_CANDIDATE_BY_EMAIL = "SELECT 	1 " + "FROM 	Candidate "
			+ "WHERE 	Email = ? ";

}
