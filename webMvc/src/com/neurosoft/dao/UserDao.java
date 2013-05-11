/**
 * 
 */
package com.neurosoft.dao;

import com.neurosoft.entities.User;

/**
 * @author Adnan
 * 
 */
public interface UserDao extends GenericDao<User, Long> {

	User getUserByUsername(String username);

}
