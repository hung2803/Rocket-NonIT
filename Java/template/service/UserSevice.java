package com.vti.template.service;

import java.util.List;

import com.vti.template.Dto.UserDto;
import com.vti.template.Dto.UserLoginInformationDto;
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

public interface UserSevice {
	public List<UserDto> getAllUser();

	public UserDto getUserByID(int id);

	public boolean createUser(CreateForm dto);

	public boolean updateUser(CreateForm dto);

	public boolean deleteUser(int id);

	public boolean existsUser(int id);

	public boolean existsUser(String email);

	public UserLoginInformationDto login(LoginForm form);
	
	public boolean blockUser(String email);
	
	public List<UserDto> getAllStudentOrderBy(String column);
}
