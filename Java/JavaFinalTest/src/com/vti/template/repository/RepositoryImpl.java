package com.vti.template.repository;

import com.vti.template.utils.jdbc.JdbcUtil;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 * @param <T>
 */
public abstract class RepositoryImpl<T> implements Repository<T> {
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
	public RepositoryImpl() {
		jdbc = JdbcUtil.getInstance();
	}

	/**
	 * @return the jdbc
	 */
	protected JdbcUtil getJdbc() {
		return jdbc;
	}

}
