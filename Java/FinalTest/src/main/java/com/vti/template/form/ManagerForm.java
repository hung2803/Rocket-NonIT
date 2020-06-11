package com.vti.template.form;

import com.vti.FinalTest.entity.Employee;
import com.vti.FinalTest.entity.Manager;
import com.vti.FinalTest.entity.User;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 7, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 7, 2020
 */

public class ManagerForm extends UserForm {
	private int ExpInYear;

	/**
	 * @return the expInYear
	 */
	public int getExpInYear() {
		return ExpInYear;
	}

	/**
	 * @param expInYear the expInYear to set
	 */
	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}
	

	public ManagerForm( int expInYear) {
		super();
		ExpInYear = expInYear;
	}

	@Override
	public Manager toEntityCreate() {
		return new Manager(super.toEntityCreate(), this.ExpInYear);
	}

}
