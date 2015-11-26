package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sumeru.dao.AbstractDao;
import com.websystique.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	public User findById(long id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id",id));
		return (User) criteria.uniqueResult();
	}

	public User findByName(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username",username));
		return (User) criteria.uniqueResult();
	}

	public void saveUser(User user) {
		persist(user);

	}

	public void updateUser(User user) {
		getSession().update(user);

	}

	public void deleteUserById(long id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id",id));
		User user = (User) criteria.uniqueResult();
		
		getSession().delete(user);
	}

	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub

	}

	public boolean isUserExist(User user) {
		User user1 = findById(user.getId());
		
		if (user1 == null )
			return false;
		else return true ;
	}

}
