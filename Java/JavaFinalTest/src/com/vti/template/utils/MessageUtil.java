package com.vti.template.utils;

/**
 * This class is message util.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 24, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 24, 2019
 */
public class MessageUtil {

	// validate form

	// FirstName
	public static final String VALIDATE_FIRSTNAME_FORMAT = "Firstame must not be empty";
	public static final String VALIDATE_FIRSTNAME_MAX_LENGTH = "FirstName has the most 20 characters";
	public static final String VALIDATE_FIRSTNAME_RULE = "FirstName must capitalization first characters";
	// LastName
	public static final String VALIDATE_LASTNAME_FORMAT = "LastName must not be empty";
	public static final String VALIDATE_LASTNAME_MAX_LENGTH = "LastName has the most 20 characters";
	public static final String VALIDATE_LASTNAME_RULE = "LastName must capitalization first characters";

	// email
	public static final String VALIDATE_EMAIL_FORMAT = "Email must not be empty";
	public static final String VALIDATE_EMAIL_MAX_LENGTH = "Email has the most 30 characters";
	public static final String VALIDATE_EMAIL_RULE = "Email has the most 30 characters and include @, lower, upper characters, ...";

	// password
	public static final String VALIDATE_PASSWORD_FORMAT = "Password must not be empty";
	public static final String VALIDATE_PASSWORD_MAX_AND_MIN_LENGHT = "Password must has 6 to 30 characters";
	public static final String VALIDATE_PASSWORD_RULE = "Password must contain numbers and capital letters ";
	// phone
	public static final String VALIDATE_PHONE_FORMAT = "Phone number must not be empty";
	public static final String VALIDATE_PHONE_MAX_AND_MIN_LENGTH = "Phone number must has 9 to 15 numbers";
	public static final String VALIDATE_PHONE_RULE = "Phone number must has 9 to 15 numbers and include 0-9";
	// ExpInYear
	public static final String VALIDATE_EXPINYEAR_FORMAT = "ExpInYear number must has 0 to 10 year";
	// GraduationRank
	public static final String VALIDATE_GRADUATIONRANK_FORMAT = "GraduationRank must has(Excellence, Good, Fair, Poor)";
	// scanner
	public static final String ERROR_VALIDATE_INT = "Invalid value, Please input interger: ";
	public static final String ERROR_VALIDATE_FLOAT = "Invalid value, Please input float: ";
	public static final String ERROR_VALIDATE_DOUBLE = "Invalid value, Please input double: ";
	public static final String ERROR_VALIDATE_STRING = "Invalid value, Please input string: ";

	// IDrole
	public static final String VALIDATE_ROLE_FORMAT = "You must input IDrole which is a position .";

}
