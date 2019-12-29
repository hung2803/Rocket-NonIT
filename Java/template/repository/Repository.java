package com.vti.template.repository;

import java.util.List;

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

public interface Repository<T> {
	public List<T> getAll();

	public T getByID(int id);

	public boolean create(T entity);

	public boolean update(T entity);

	public boolean delete(int id);

	public boolean exists(String email);

}
