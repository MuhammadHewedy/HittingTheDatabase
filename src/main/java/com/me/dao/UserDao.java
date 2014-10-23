package com.me.dao;

import java.util.List;

import com.me.model.users.User;

public interface UserDao {

	void saveUser(User user);

	List<User> listUsers();

	void throwingExcpetionAfterInsert();
}
