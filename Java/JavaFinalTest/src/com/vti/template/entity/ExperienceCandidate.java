package com.vti.template.entity;

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

public class ExperienceCandidate extends Candidate {
	private int ExpInYear;
	private String ProSkill;

	/**
	 * @return the expInYear.
	 */
	public int getExpInYear() {
		return ExpInYear;
	}

	/**
	 * @return the proSkill.
	 */
	public String getProSkill() {
		return ProSkill;
	}

	public ExperienceCandidate(Candidate candidate, int expInYear, String proSkill) {
		super(candidate.firstName, candidate.lastName, candidate.phone, candidate.email, candidate.password,
				candidate.idRole);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}

	public ExperienceCandidate(int expInYear, String proSkill) {
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}

}
