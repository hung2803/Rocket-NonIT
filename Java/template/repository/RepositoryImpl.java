package com.vti.template.repository;

import com.vti.template.utils.jdbc.JdbcUtil;

/**
 * This class is implement repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public abstract class RepositoryImpl<T> implements Repository<T> {
	private JdbcUtil jdbc;

	/**
	 * Constructor for class RepositoryImpl.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
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
