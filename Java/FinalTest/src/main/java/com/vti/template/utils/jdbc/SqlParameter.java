package com.vti.template.utils.jdbc;

/**
 * This class is model of 1 parameter in statement query.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 7, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 7, 2019
 */
public class SqlParameter {

	private int index;
	private Object value;

	/**
	 * Constructor for class SqlParameter.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @param index
	 *            - index of field
	 * @param value
	 *            - value for field
	 */
	public SqlParameter(int index, Object value) {
		this.index = index;
		this.value = value;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

}
