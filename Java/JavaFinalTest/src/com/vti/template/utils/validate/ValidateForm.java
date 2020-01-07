package com.vti.template.utils.validate;

import com.vti.template.form.CandidateForm;
import com.vti.template.form.ExperienceCandidateForm;
import com.vti.template.form.FresherCandidateForm;

/**
 * This class is validateForm.
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Dec 31, 2019
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Dec 31, 2019
 */
public class ValidateForm {

	public boolean isRegister(CandidateForm form) {
		if (form == null) {
			return false;
		}
		if (!Validate.isFirstName(form.getFirstName())) {
			return false;
		}
		if (!Validate.isLastName(form.getLastName())) {
			return false;
		}
		if (!Validate.isPhone(form.getPhone())) {
			return false;
		}
		if (!Validate.isEmail(form.getEmail())) {
			return false;
		}
		if (!Validate.isPassword(form.getPassword())) {
			return false;
		}

		if (form instanceof FresherCandidateForm) {
			if (!Validate.isGraduationRank(((FresherCandidateForm) form).getGraduationRank())) {
				return false;
			}
		} else {
			if (!Validate.isExpInYear(((ExperienceCandidateForm) form).getExpInYear())) {
				return false;
			}
		}

		return true;
	}
}
