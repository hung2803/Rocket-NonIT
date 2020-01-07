package com.vti.template.form;

import com.vti.template.entity.FresherCandidate;

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

public class FresherCandidateForm extends CandidateForm {
	private String GraduationRank;

	/**
	 * @return the graduationRank.
	 */
	public String getGraduationRank() {
		return GraduationRank;
	}

	public FresherCandidateForm(String firstName, String lastName, String phone, String email, String password,
			String roleName, String graduationRank) {
		super(firstName, lastName, phone, email, password, roleName);
		GraduationRank = graduationRank;
	}

	@Override
	public FresherCandidate toEntityCreate() {
		return new FresherCandidate(super.toEntityCreate(), this.GraduationRank);
	}
}
