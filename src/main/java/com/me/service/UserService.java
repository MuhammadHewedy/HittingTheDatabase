package com.me.service;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.dao.UserDao;
import com.me.model.users.User;

@Service
@Transactional
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

	public void throwingExcpetionAfterInsert() {
		userDao.throwingExcpetionAfterInsert();
	}
}
