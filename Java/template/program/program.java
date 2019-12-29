package com.vti.template.program;

import java.util.Scanner;

import com.vti.template.utils.ScannerUtil;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Dec 25, 2019
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Dec 25, 2019
 */

public class program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Function function = new Function();
		String activityList = null;
		while (activityList == null) {
			System.out.println("Bạn muốn thao tác nào 1: register,  2: Login,  3: ListStudent");
			int activityInput = ScannerUtil.readInt(scanner);
			switch (activityInput) {
			case 1:
				function.register();
				break;
			case 2:
				function.Login();
				break;
			case 3:
				function.ListStudent();
				break;
			default:
				System.out.println("Mời bạn nhập lại");
				break;
			}

		}
	}
}
