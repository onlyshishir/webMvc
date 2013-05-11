/**
 * 
 */
package com.neurosoft.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.neurosoft.dao.UserDao;
import com.neurosoft.entities.User;

/**
 * @author Adnan
 * 
 */
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		User u = null;
		List<User> users = null;
		DetachedCriteria dt = DetachedCriteria.forClass(User.class);
		dt.add(Property.forName("username").eq(username));
		users = getHibernateTemplate().findByCriteria(dt);
		if ((users != null) && (!users.isEmpty())) {
			u = users.get(0);
		}
		return u;
	}

}
