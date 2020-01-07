package com.vti.template.service;

import com.vti.template.form.ExperienceCandidateForm;
import com.vti.template.form.FresherCandidateForm;

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

public interface CandidateSevice {
	public boolean registerExperienceCandidate(ExperienceCandidateForm form);

	public boolean registerFresherCandidate(FresherCandidateForm form);

}
