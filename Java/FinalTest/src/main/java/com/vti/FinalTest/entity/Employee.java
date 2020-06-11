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

public class Employee extends User {
	private int id;
	private String projectName;
	private String ProSkill;

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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the proSkill
	 */
	public String getProSkill() {
		return ProSkill;
	}

	/**
	 * @param proSkill the proSkill to set
	 */
	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	public Employee(String firstName, String lasttName, String password, String phone, String email, String projectName,
			String proSkill) {
		super(firstName, lasttName, password, phone, email);
		this.projectName = projectName;
		ProSkill = proSkill;
	}

	/**
	 * Constructor for class Employee.
	 * 
	 * @Description: .
	 * @author: NTHUNG
	 * @create_date: Apr 12, 2020
	 * @version: 1.0
	 * @modifer: NTHUNG
	 * @modifer_date: Apr 12, 2020
	 * @param entityCreate
	 * @param projectName2
	 * @param proSkill2
	 */

	public Employee(User user, String projectName, String proSkill) {
		super(user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhone(), user.getEmail());
		projectName = projectName;
		ProSkill = proSkill;
	}
}
