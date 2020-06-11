package com.vti.template.service;

import java.sql.SQLException;

import com.vti.FinalTest.Repository.UserRepository;
import com.vti.FinalTest.Repository.UserRepositoryImpl;
import com.vti.template.form.EmployeeForm;
import com.vti.template.form.ManagerForm;

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

public class UserServiceImpl implements UserSevice {
	private UserRepository repository;

	public UserServiceImpl() {
		repository = new UserRepositoryImpl();
	}
	/*
	 * @see com.vti.template.service.CandidateSevice#rigister(com.vti.template.form.
	 * RegisterForm)
	 */

	@Override
	public boolean registerEmployee(EmployeeForm form) throws SQLException {
		// if name exist then return false
		if (repository.exists(form.getEmail())) {
			return false;
		}

		// create
		return repository.createUser(form.toEntityCreate());
	}

	/*
	 * @see
	 * com.vti.template.service.CandidateSevice#rigisterFresher(com.vti.template
	 * .form.RegisterForm)
	 */

	@Override
	public boolean registerManager(ManagerForm form) throws SQLException {
		// if name exist then return false
		if (repository.exists(form.getEmail())) {
			return false;
		}

		// create
		return repository.createUser(form.toEntityCreate());
	}

}
