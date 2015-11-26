package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao ;
	
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
	
	public User findById(long id) {
		return dao.findById(id);
	}
	
	public User findByName(String name) {
		return dao.findByName(name);
	}
	
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public void deleteUserById(long id) {
		dao.deleteUserById(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		//users.clear();
	}

//	private static List<User> populateDummyUsers(){
//		List<User> users = new ArrayList<User>();
//		users.add(new User(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
//		users.add(new User(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
//		users.add(new User(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
//		return users;
//	}

}
