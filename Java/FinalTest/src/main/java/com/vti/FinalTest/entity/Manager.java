/**
 * 
 */
package com.vti.FinalTest.entity;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHUNG
 * @create_date: Apr 12, 2020
 * @version: 1.0
 * @modifer: NTHUNG
 * @modifer_date: Apr 12, 2020
 */

public class Manager extends User {
	private int id;
	private int ExpInYear;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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

	public Manager(String firstName, String lasttName, String password, String phone, String email, int expInYear) {
		super(firstName, lasttName, password, phone, email);
		ExpInYear = expInYear;
	}

	/**
	 * Constructor for class Manager.
	 * 
	 * @Description: .
	 * @author: NTHUNG
	 * @create_date: Apr 12, 2020
	 * @version: 1.0
	 * @modifer: NTHUNG
	 * @modifer_date: Apr 12, 2020
	 * @param entityCreate
	 * @param expInYear2
	 */

	public Manager(User user, int expInYear) {
		super(user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhone(), user.getEmail());
		this.ExpInYear = expInYear;
	}
}