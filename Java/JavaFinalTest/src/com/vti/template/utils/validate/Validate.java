package com.vti.template.utils.validate;

import com.mysql.cj.util.StringUtils;
import com.vti.template.utils.Constant;
import com.vti.template.utils.MessageUtil;
import com.vti.template.utils.MethodUtil;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 */
public class Validate {

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 * @param input
	 * @return
	 */
	public static boolean isFirstName(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_FIRSTNAME_FORMAT);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 20)) {
			showError(MessageUtil.VALIDATE_FIRSTNAME_MAX_LENGTH);
			return false;
		}
		/*
		 * // regular expression boolean result =
		 * MethodUtil.checkRegularExpression(input, Constant.PATTERN_FIRSTNAME);
		 * if (!result) { showError(MessageUtil.VALIDATE_FIRSTNAME_RULE); }
		 * return result;
		 */
		return true;
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 * @param input
	 * @return
	 */
	public static boolean isLastName(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_LASTNAME_FORMAT);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 20)) {
			showError(MessageUtil.VALIDATE_LASTNAME_MAX_LENGTH);
			return false;
		}
		/*
		 * // regular expression boolean result =
		 * MethodUtil.checkRegularExpression(input, Constant.PATTERN_LASTNAME);
		 * if (!result) { showError(MessageUtil.VALIDATE_LASTNAME_RULE); }
		 * return result;
		 */
		return true;
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 * @param input
	 * @return
	 */
	public static boolean isEmail(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_EMAIL_FORMAT);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 30)) {
			showError(MessageUtil.VALIDATE_EMAIL_MAX_LENGTH);
			return false;
		}
		/*
		 * // regular expression boolean result =
		 * MethodUtil.checkRegularExpression(input, Constant.PATTERN_EMAIL); if
		 * (!result) { showError(MessageUtil.VALIDATE_EMAIL_RULE); } return
		 * result;
		 */
		return true;
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 * @param input
	 * @return
	 */
	public static boolean isPassword(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_PASSWORD_FORMAT);
			return false;
		}
		// max length, min length
		if (!isSatisfyMaxLength(input, 30) || !isSatisfyMinLength(input, 6)) {
			showError(MessageUtil.VALIDATE_PASSWORD_MAX_AND_MIN_LENGHT);
			return false;
		}
		// regular expression
		boolean result = MethodUtil.checkRegularExpression(input, Constant.PATTERN_PASSWORD);
		if (!result) {
			showError(MessageUtil.VALIDATE_PASSWORD_RULE);
		}
		return result;
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Dec 31, 2019
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Dec 31, 2019
	 * @param input
	 * @return
	 */
	public static boolean isPhone(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_PHONE_FORMAT);
			return false;
		}

		/*
		 * // max length, min length if (!isSatisfyMaxLength(input, 15) ||
		 * !isSatisfyMinLength(input, 9)) {
		 * showError(MessageUtil.VALIDATE_PHONE_MAX_AND_MIN_LENGTH); return
		 * false; }
		 */

		/*
		 * // regular expression boolean result =
		 * MethodUtil.checkRegularExpression(input, Constant.PATTERN_PHONE); if
		 * (!result) { showError(MessageUtil.VALIDATE_PHONE_RULE); } return
		 * result;
		 */
		return true;

	}

	public static boolean isExpInYear(final int input) {
		// empty
		if (input < 0 || input > 10) {
			showError(MessageUtil.VALIDATE_EXPINYEAR_FORMAT);
			return false;
		}
		return true;
	}

	public static boolean isGraduationRank(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_GRADUATIONRANK_FORMAT);
			return false;
		}
		return true;
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
