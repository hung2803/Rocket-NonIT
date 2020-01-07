package com.vti.template.repository;

import com.vti.template.entity.Candidate;
import com.vti.template.entity.ExperienceCandidate;
import com.vti.template.entity.FresherCandidate;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 */

public interface CandidateRepository extends Repository<Candidate> {

	public boolean createCandidate(ExperienceCandidate entity);

	public boolean createCandidate(FresherCandidate entity);

}
