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

public class FresherCandidate extends Candidate {
	private String graduationRank;

	/**
	 * @return the graduationRank.
	 */
	public String getGraduationRank() {
		return graduationRank;
	}

	public FresherCandidate(Candidate candidate, String graduationRank) {
		super(candidate.firstName, candidate.lastName, candidate.phone, candidate.email, candidate.password,
				candidate.idRole);
		this.graduationRank = graduationRank;
	}

}
