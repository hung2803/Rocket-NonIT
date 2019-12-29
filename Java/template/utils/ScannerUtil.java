package com.vti.template.utils;

import java.util.Scanner;

import com.mysql.cj.util.StringUtils;
import com.vti.template.utils.validate.Validate;

/**
 * This class is enter input from User
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 06, 2019
 */

public class ScannerUtil {

	/**
	 * This method is enter input Integer.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param scanner
	 *            - use Scanner to enter
	 * @param errorMessage
	 *            - Error Message
	 * @return int - it is a number from user input
	 */
	public static int readInt(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				Validate.showError(errorMessage);
			}
		}
	}
	
	public static int readInt(Scanner scanner) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println(Constant.ERROR_VALIDATE_INT);
			}
		}
	}


	/**
	 * This method is enter input float.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param scanner
	 *            - use Scanner to enter
	 * @param errorMessage
	 *            - Error Message
	 * @return double - it is a number from user input
	 */
	public static double readDouble(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (Exception e) {
				Validate.showError(errorMessage);
			}
		}
	}

	/**
	 * This method is enter input float.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param scanner
	 *            - use Scanner to enter
	 * @param errorMessage
	 *            - Error Message
	 * @return float - it is a number from user input
	 */
	public static float readFloat(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine());
			} catch (Exception e) {
				Validate.showError(errorMessage);
			}
		}
	}

	/**
	 * This method is enter input String.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param scanner
	 *            - use Scanner to enter
	 * @param errorMessage
	 *            - Error Message
	 * @return String - it is a number from user input
	 */
	public static String readString(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				String result = scanner.nextLine().trim();
				if (!StringUtils.isNullOrEmpty(result)) {
					return result;
				}
			} catch (Exception e) {
				Validate.showError(errorMessage);
			}
		}
	}

}
