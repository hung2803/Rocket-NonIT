//
package com.vti.template.repository;

import java.util.List;

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
public interface Repository<T> {
	public List<T> getAll();

	public T getByID(int id);

	public boolean exists(String email);
}
