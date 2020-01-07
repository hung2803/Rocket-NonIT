package com.vti.template.controller;

import com.vti.template.form.CandidateForm;
import com.vti.template.form.ExperienceCandidateForm;
import com.vti.template.form.FresherCandidateForm;
import com.vti.template.service.CandidateServiceImpl;
import com.vti.template.service.CandidateSevice;
import com.vti.template.utils.validate.ValidateForm;

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

public class CandidateController {
	private CandidateSevice service;
	private ValidateForm validate;

	/**
	 * Constructor for class CandidateController.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 */

	public CandidateController() {
		service = new CandidateServiceImpl();
		validate = new ValidateForm();
	}

	public boolean registerCandidate(CandidateForm form) {
		if (validate.isRegister(form)) {
			if (form instanceof ExperienceCandidateForm) {
				return service.registerExperienceCandidate((ExperienceCandidateForm) form);
			} else {
				return service.registerFresherCandidate((FresherCandidateForm) form);
			}
		}
		return false;

	}
}
