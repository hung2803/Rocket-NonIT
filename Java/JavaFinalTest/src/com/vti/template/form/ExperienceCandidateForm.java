package com.vti.template.form;

import com.vti.template.entity.ExperienceCandidate;

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

public class ExperienceCandidateForm extends CandidateForm {
	private int expInYear;
	private String proSkill;

	/**
	 * @return the expInYear.
	 */
	public int getExpInYear() {
		return expInYear;
	}

	/**
	 * @return the proSkill.
	 */
	public String getProSkill() {
		return proSkill;
	}

	public ExperienceCandidateForm(String firstName, String lastName, String phone, String email, String password,
			String roleName, int expInYear, String proSkill) {
		super(firstName, lastName, phone, email, password, roleName);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	@Override
	public ExperienceCandidate toEntityCreate() {
		return new ExperienceCandidate(super.toEntityCreate(), this.expInYear, this.proSkill);
	}
}
