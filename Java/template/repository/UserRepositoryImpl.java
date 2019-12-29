package com.vti.template.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.template.entity.User;
import com.vti.template.entity.view.UserLoginInformationView;
import com.vti.template.utils.jdbc.SqlParameter;
import com.vti.template.utils.jdbc.SqlStatement;

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

public class UserRepositoryImpl extends RepositoryImpl<User> implements UserRepository {

	/*
	 * @see com.vti.template.repository.Repository#getAll()
	 */

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.template.repository.Repository#getByID(int)
	 */

	@Override
	public User getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.template.repository.Repository#create(java.lang.Object)
	 */

	@Override
	public boolean create(User entity) {
		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getID()));
		params.add(new SqlParameter(2, entity.getFullname()));
		params.add(new SqlParameter(3, entity.getEmail()));
		params.add(new SqlParameter(4, entity.getPassword()));
		params.add(new SqlParameter(5, entity.getAge()));
		params.add(new SqlParameter(6, entity.getPhoneNumber()));
		params.add(new SqlParameter(7, entity.getAddress()));
		params.add(new SqlParameter(8, entity.getRole()));
		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_USER, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}
		return false;

	}

	/*
	 * @see com.vti.template.repository.Repository#update(java.lang.Object)
	 */

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.vti.template.repository.Repository#delete(int)
	 */

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see com.vti.template.repository.Repository#exists(int)
	 */

	@Override
	public boolean exists(String email) {
		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, email));

		// execute query
		ResultSet result = getJdbc().selectPreparationStatement(SqlStatement.SQL_EXITS_USER_BY_EMAIL, params);

		// check result is null
		if (null == result) {
			getJdbc().disconnect();
			return false;
		}

		// get result
		try {
			while (result.next()) {
				getJdbc().disconnect();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getJdbc().disconnect();
		return false;

	}

	@Override
	public UserLoginInformationView login(String email, String password) {
		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, email));
		params.add(new SqlParameter(2, password));

		// execute query
		ResultSet result = getJdbc().selectPreparationStatement(SqlStatement.SQL_LOGIN_USER, params);

		// check result is null
		if (null == result) {
			getJdbc().disconnect();
			return null;
		}

		// get result
		try {
			while (result.next()) {
				UserLoginInformationView entity;
				entity = new UserLoginInformationView(result.getString("Email"), result.getString("fullName"),
						result.getString("Role"), result.getBoolean("isBlock"));
				getJdbc().disconnect();
				return entity;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		getJdbc().disconnect();
		return null;
	}

	/*
	 * @see
	 * com.vti.template.repository.UserRepository#blockUser(java.lang.String)
	 */

	@Override
	public boolean blockUser(String email) {
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, email));
		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_BLOCK_USER, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.template.repository.UserRepository#getAllStudentOrderBy(java.lang
	 * .String)
	 */

	@Override
	public List<User> getAllStudentOrderBy(String column) {

		List<User> entities = new ArrayList<>();

		// execute query
		ResultSet result = getJdbc().selectStatement(SqlStatement.SQL_GET_ALL_USER_ORDER_USER + column);

		// check result is null
		if (null == result) {
			getJdbc().disconnect();
			return null;
		}

		// get result
		try {
			while (result.next()) {
				entities.add(new User(result.getString("Fullname"), 
										result.getString("Email"), 
										result.getInt("Age"),
										result.getString("Address")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getJdbc().disconnect();
		return entities;
	}
}