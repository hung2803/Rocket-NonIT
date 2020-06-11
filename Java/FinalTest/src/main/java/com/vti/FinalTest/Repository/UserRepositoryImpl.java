/**
 * 
 */
package com.vti.FinalTest.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.FinalTest.entity.Employee;
import com.vti.FinalTest.entity.Manager;
import com.vti.FinalTest.entity.User;
import com.vti.template.utils.jdbc.JdbcUtil;
import com.vti.template.utils.jdbc.SqlParameter;
import com.vti.template.utils.jdbc.SqlStatement;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHUNG
 * @create_date: Apr 12, 2020
 * @version: 1.0
 * @modifer: NTHUNG
 * @modifer_date: Apr 12, 2020
 */

public class UserRepositoryImpl implements UserRepository {

	private JdbcUtil jdbc;

	/**
	 * Constructor for class RepositoryImpl.
	 * 
	 * @Description: .
	 * @author: NTHung
	 * @create_date: Jan 6, 2020
	 * @version: 1.0
	 * @modifer: NTHung
	 * @modifer_date: Jan 6, 2020
	 */
	public UserRepositoryImpl() {
		jdbc = JdbcUtil.getInstance();
	}

	/**
	 * @return the jdbc
	 */
	protected JdbcUtil getJdbc() {
		return jdbc;
	}

	@Override
	public boolean exists(String email) throws SQLException {
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

	/*
	 * @see com.vti.FinalTest.Repository.UserRepository#createUser()
	 */
	public boolean createUser(User entity) throws SQLException {
		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getFirstName()));
		params.add(new SqlParameter(2, entity.getLastName()));
		params.add(new SqlParameter(3, entity.getPassword()));
		params.add(new SqlParameter(4, entity.getPhone()));
		params.add(new SqlParameter(5, entity.getEmail()));

		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_USER, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean createUser(Manager entity) throws SQLException {

		if (!createUser((User) entity)) {
			return false;
		}

		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getExpInYear()));

		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_MANAGER, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}

		return false;
	}

	/*
	 * @see
	 * com.vti.FinalTest.Repository.UserRepository#createUser(com.vti.FinalTest.
	 * entity.Employee)
	 */

	@Override
	public boolean createUser(Employee entity) throws SQLException {
		if (!createUser((User) entity)) {
			return false;
		}

		// init list parameters
		List<SqlParameter> params = new ArrayList<>();
		params.add(new SqlParameter(1, entity.getProjectName()));
		params.add(new SqlParameter(1, entity.getProSkill()));

		// execute query
		int result = getJdbc().updatePreparationStatement(SqlStatement.SQL_CREATE_EMPLOYEE, params);
		getJdbc().disconnect();

		// return result
		if (result == 1) {
			return true;
		}

		return false;
	}
}
