package com.vti.template.service;

import java.sql.SQLException;

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

public interface UserSevice {
	public boolean registerEmployee(EmployeeForm form) throws SQLException;

	public boolean registerManager(ManagerForm form) throws SQLException;

}
