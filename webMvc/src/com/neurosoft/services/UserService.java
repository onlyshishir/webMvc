/**
 * 
 */
package com.neurosoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.neurosoft.dao.UserDao;
import com.neurosoft.entities.User;

/**
 * @author Adnan
 * 
 */
public class UserService {

	UserDao dao;

	@Required
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public List<User> listAllUsers() {
		return dao.loadAll();
	}

	public Long addUser(User user) {
		return dao.create(user);
	}

	public void updateUser(User user) {
		dao.update(user);
	}

	public void addOrUpdateUser(User user) {
		dao.createOrUpdate(user);
	}

	public User getUser(Long id) {
		return dao.read(id);
	}

	public void deleteUser(User user) {
		dao.delete(user);
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUsername(username);
	}
}
