package com.vti.template.service;

import java.util.ArrayList;
import java.util.List;

import com.vti.template.Dto.UserDto;
import com.vti.template.Dto.UserLoginInformationDto;
import com.vti.template.entity.User;
import com.vti.template.entity.view.UserLoginInformationView;
import com.vti.template.repository.UserRepository;
import com.vti.template.repository.UserRepositoryImpl;
import com.vti.template.utils.form.CreateForm;
import com.vti.template.utils.form.LoginForm;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Dec 24, 2019
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Dec 24, 2019
 */

public class UserSeviceImpl implements UserSevice {

	private UserRepository repository;

	public UserSeviceImpl() {
		repository = new UserRepositoryImpl();

	}

	/*
	 * @see com.vti.template.service.UserSevice#getAllUser()
	 */

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.template.service.UserSevice#getUserByID(int)
	 */

	@Override
	public UserDto getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.template.service.UserSevice#updateUser(com.vti.template.Dto.
	 * UserDto)
	 */

	@Override
	public boolean updateUser(CreateForm dto) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.vti.template.service.UserSevice#deleteUser(int)
	 */

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.vti.template.service.UserSevice#existsUser(int)
	 */

	@Override
	public boolean existsUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.vti.template.service.UserSevice#existsUser(java.lang.String)
	 */

	@Override
	public boolean existsUser(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.vti.template.service.UserSevice#createUser(com.vti.template.Dto.
	 * UserDto)
	 */

	@Override
	public boolean createUser(CreateForm form) {
		// if name exist then return false
		if (repository.exists(form.getEmail())) {
			return false;
		}

		// create
		return repository.create(form.toEntityCreate());
	}

	@Override
	public UserLoginInformationDto login(LoginForm form) {
		UserLoginInformationView entity = repository.login(form.getEmail(), form.getPassword());
		if (null != entity) {
			if (entity.isBlock()) {
				return new UserLoginInformationDto(true);
			} else {
				// convert entity to dto
				return new UserLoginInformationDto(entity);
			}
		}
		return null;
	}

	/*
	 * @see com.vti.template.service.UserSevice#blockUser(java.lang.String)
	 */

	@Override
	public boolean blockUser(String email) {
		if (!repository.exists(email)) {
			return false;
		}
		return repository.blockUser(email);
	}

	/*
	 * @see com.vti.template.service.UserSevice#getAllStudentOrderBy()
	 */

	@Override
	public List<UserDto> getAllStudentOrderBy(String column) {

		List<UserDto> userDtos = new ArrayList<>();

		List<User> users = repository.getAllStudentOrderBy(column);

		if (users != null) {
			// convert to dto
			for (int i = 0; i < users.size(); i++) {
				userDtos.add(new UserDto(users.get(i)));
			}
		}
		return userDtos;
	}
}