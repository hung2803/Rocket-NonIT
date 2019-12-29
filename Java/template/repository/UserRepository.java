package com.vti.template.repository;

import java.util.List;

import com.vti.template.entity.User;
import com.vti.template.entity.view.UserLoginInformationView;

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

public interface UserRepository extends Repository<User> {
	public UserLoginInformationView login(String email, String password);

	public boolean blockUser(String email);

	public List<User> getAllStudentOrderBy(String Role);
}
