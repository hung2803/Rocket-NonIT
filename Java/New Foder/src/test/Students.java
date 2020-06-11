package test;

import java.util.ArrayList;

/**
 * 
 */

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHUNG
 * @create_date: Apr 30, 2020
 * @version: 1.0
 * @modifer: NTHUNG
 * @modifer_date: Apr 30, 2020
 */

public class Students {
	public int id;
	public String name;
	public int age;

	public Gender gender;

	public String school;
	public String phone;
	public String adress;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Students(int id, String name, int age, Gender gender, String school, String phone, String adress) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.school = school;
		this.phone = phone;
		this.adress = adress;
	}

	public static ArrayList<Students> getStudent() {
		ArrayList<Students> abc = new ArrayList<Students>();
		Students student1 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student2 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student3 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student4 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student5 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student6 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student7 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student8 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student9 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");
		Students student10 = new Students(1, "Nguyễn Văn A", 20, Gender.MALE, "Đại Hoc 1", "0978967886", "Nam Định");

		abc.add(student1);
		abc.add(student2);
		abc.add(student3);
		abc.add(student4);
		abc.add(student5);
		abc.add(student6);
		abc.add(student7);
		abc.add(student8);
		abc.add(student9);
		abc.add(student10);

		return abc;
	}
}