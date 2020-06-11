/**
 * 
 */
package com.vti.FinalTest.Repository;

import java.sql.SQLException;

import com.vti.FinalTest.entity.Employee;
import com.vti.FinalTest.entity.Manager;
import com.vti.FinalTest.entity.User;

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

public interface UserRepository {
	public boolean createUser(User entity) throws SQLException;

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NTHUNG
	 * @create_date: Apr 12, 2020
	 * @version: 1.0
	 * @modifer: NTHUNG
	 * @modifer_date: Apr 12, 2020
	 * @param entity
	 * @return
	 */

	public boolean createUser(Manager entity) throws SQLException;

	public boolean createUser(Employee entity) throws SQLException;

	public boolean exists(String email) throws SQLException;

}
