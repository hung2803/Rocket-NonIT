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
	
	// FullName
	public static final String VALIDATE_FULLNAME_FORMAT = "FullName must not be empty";
	public static final String VALIDATE_FULLNAME_MAX_AND_MIN_LENGTH = "FullName must has 10 to 50 characters";
	
	// email
	public static final String VALIDATE_EMAIL_FORMAT = "Email must not be empty";
	public static final String VALIDATE_EMAIL_MAX_AND_MIN_LENGTH = "Email must has 6 to 30 characters";
	public static final String VALIDATE_EMAIL_RULE = "Email must has 6 to 30 characters and include @, lower, upper characters, ...";

	// password
	public static final String VALIDATE_PASSWORD_FORMAT = "Password must not be empty";

	// phone
	public static final String VALIDATE_PHONE_FORMAT = "Phone number must not be empty";
	public static final String VALIDATE_PHONE_MAX_AND_MIN_LENGTH = "Phone number must has 9 to 11 numbers";
	public static final String VALIDATE_PHONE_RULE = "Phone number must has 9 to 11 numbers and include 0-9";



	// age
	public static final String VALIDATE_AGE_FORMAT = "You must input age which is a number (from 7 to 21).";

	// scanner
	public static final String ERROR_VALIDATE_INT = "Invalid value, Please input interger: ";
	public static final String ERROR_VALIDATE_FLOAT = "Invalid value, Please input float: ";
	public static final String ERROR_VALIDATE_DOUBLE = "Invalid value, Please input double: ";
	public static final String ERROR_VALIDATE_STRING = "Invalid value, Please input string: ";

	// address
	public static final String VALIDATE_ADDRESS_FORMAT = "You must input address which is a city .";
	public static final String VALIDATE_ADDRESS_MAX_AND_MIN_LENGTH = "Address must has 5 to 50 characters";

	// role
	public static final String VALIDATE_ROLE_FORMAT = "You must input role which is a position .";

}
