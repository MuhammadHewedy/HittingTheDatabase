package com.me.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.me.model.users.User;

@Repository
@Transactional
public class HibernateUserDao implements UserDao {

	@PersistenceContext(unitName = "mainPU")
	private EntityManager em;

	@Override
	public void saveUser(User user) {
		em.persist(user);
	}

	public List<User> listUsers() {
		return em.createQuery("from User", User.class).getResultList();
	}

}
