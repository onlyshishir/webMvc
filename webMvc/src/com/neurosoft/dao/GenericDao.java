/**
 * 
 */
package com.neurosoft.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Adnan
 * 
 */
public interface GenericDao<T, PK extends Serializable> {
	PK create(T o);

	T read(PK id);

	List<T> loadAll();

	void update(T o);

	void delete(T o);

	void createOrUpdate(T o);
}
