package com.vti.template.utils.jdbc;

/**
 * This class is model of 1 param in statement query.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public class SqlParameter {

	private int number;
	private Object values;

	/**
	 * Constructor for class SqlParameter.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param number
	 *            - number of field
	 * @param values
	 *            - value for field
	 */
	public SqlParameter(int number, Object values) {
		this.number = number;
		this.values = values;
	}

	public int getNumber() {
		return number;
	}

	public Object getValues() {
		return values;
	}

}
