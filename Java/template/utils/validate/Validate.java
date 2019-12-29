package com.vti.template.utils.validate;

import com.mysql.cj.util.StringUtils;
import com.vti.template.utils.Constant;
import com.vti.template.utils.MessageUtil;
import com.vti.template.utils.MethodUtil;

/**
 * This class is validate .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 6, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 6, 2019
 */
public class Validate {

	/**
	 * This method is check validate fullname.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 * @param input
	 * @return
	 */
	public static boolean isFullName(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_FULLNAME_FORMAT);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 50) || !isSatisfyMinLength(input, 10)) {
			showError(MessageUtil.VALIDATE_FULLNAME_MAX_AND_MIN_LENGTH);
			return false;
		}
		return true;
	}

	/**
	 * This method is check validate email.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param input
	 *            - input from user
	 * @return boolean
	 */
	public static boolean isEmail(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_EMAIL_FORMAT);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 30) || !isSatisfyMinLength(input, 6)) {
			showError(MessageUtil.VALIDATE_EMAIL_MAX_AND_MIN_LENGTH);
			return false;
		}

		// regular expression
		boolean result = MethodUtil.checkRegularExpression(input, Constant.PATTERN_EMAIL);
		if (!result) {
			showError(MessageUtil.VALIDATE_EMAIL_RULE);
		}
		return result;
	}

	/**
	 * This method is check validate email.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param input
	 *            - input from user
	 * @return boolean
	 */
	public static boolean isPassword(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_PASSWORD_FORMAT);
			return false;
		}

		return true;
	}

	/**
	 * 
	 * This method is check validate age.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 * @param input
	 * @return
	 */
	public static boolean isAge(final int input) {
		// empty
		if (input < 7 || 21 < input) {
			showError(MessageUtil.VALIDATE_AGE_FORMAT);
			return false;
		}

		return true;
	}

	/**
	 * 
	 * This method is check validate address .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 * @param input
	 * @return
	 */
	public static boolean isAddress(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_ADDRESS_FORMAT);
			return false;
		}
		if (!isSatisfyMaxLength(input, 50) || !isSatisfyMinLength(input, 5)) {
			showError(MessageUtil.VALIDATE_ADDRESS_MAX_AND_MIN_LENGTH);
			return false;
		}

		return true;
	}

	/**
	 * This method is check validate role.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 25, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 25, 2019
	 * @param input
	 * @return
	 */
	public static boolean isRole(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_ROLE_FORMAT);
			return false;
		}

		return true;
	}

	/**
	 * This method is check validate phone.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param input
	 *            - input from user
	 * @return
	 */
	public static boolean isPhone(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_PHONE_FORMAT);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 11) || !isSatisfyMinLength(input, 9)) {
			showError(MessageUtil.VALIDATE_PHONE_MAX_AND_MIN_LENGTH);
			return false;
		}

		// regular expression
		boolean result = MethodUtil.checkRegularExpression(input, Constant.PATTERN_PHONE);
		if (!result) {
			showError(MessageUtil.VALIDATE_PHONE_RULE);
		}
		return result;

	}

	/**
	 * This method validate max length of String .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 24, 2019
	 * @param input
	 *            - input String
	 * @param maxLength
	 *            - Max length of String
	 * @return boolean
	 */
	public static boolean isSatisfyMaxLength(String input, int maxLength) {
		if (!StringUtils.isNullOrEmpty(input) && input.length() <= maxLength) {
			return true;
		}
		return false;
	}

	/**
	 * This method validate min length of String .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 24, 2019
	 * @param input
	 *            - input String
	 * @param minLength
	 *            - Min length of String
	 * @return boolean
	 */
	public static boolean isSatisfyMinLength(String input, int minLength) {
		if (!StringUtils.isNullOrEmpty(input) && input.length() >= minLength) {
			return true;
		}
		return false;
	}

	/**
	 * This method show error message when validating.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 24, 2019
	 * @param message
	 *            - Error message
	 */
	public static void showError(String message) {
		System.out.println("Error: " + message);
	}

	/**
	 * This method show success when validating.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 24, 2019
	 * @param message
	 *            - success message
	 */
	public static void showSuccess(String message) {
		System.out.println("Success: " + message);
	}

}
