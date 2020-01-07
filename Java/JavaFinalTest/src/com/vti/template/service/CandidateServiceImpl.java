package com.vti.template.service;

import com.vti.template.form.ExperienceCandidateForm;
import com.vti.template.form.FresherCandidateForm;
import com.vti.template.repository.CandidateRepository;
import com.vti.template.repository.CandidateRepositoryImpl;

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

public class CandidateServiceImpl implements CandidateSevice {
	private CandidateRepository repository;

	public CandidateServiceImpl() {
		repository = new CandidateRepositoryImpl();
	}
	/*
	 * @see
	 * com.vti.template.service.CandidateSevice#rigister(com.vti.template.form.
	 * RegisterForm)
	 */

	@Override
	public boolean registerExperienceCandidate(ExperienceCandidateForm form) {
		// if name exist then return false
		if (repository.exists(form.getEmail())) {
			return false;
		}

		// create
		return repository.createCandidate(form.toEntityCreate());
	}

	/*
	 * @see
	 * com.vti.template.service.CandidateSevice#rigisterFresher(com.vti.template
	 * .form.RegisterForm)
	 */

	@Override
	public boolean registerFresherCandidate(FresherCandidateForm form) {
		// if name exist then return false
		if (repository.exists(form.getEmail())) {
			return false;
		}

		// create
		return repository.createCandidate(form.toEntityCreate());
	}

}
