package com.me.service;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.dao.UserDao;
import com.me.model.User;

@Service
public class UserService {

	@Inject
	private UserDao userDao;

	public void addUser(User user) {
		user.setPassword(UUID.randomUUID().toString());
		userDao.saveUser(user);
	}

	public List<User> listUsers() {
		return userDao.listUsers();
	}
}
