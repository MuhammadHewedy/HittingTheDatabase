package com.me.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.dao.InventoryDao;

@Service
public class InventoryService {

	@Inject
	private InventoryDao inventoryDao;

	public void incrementUsersCount() {
		inventoryDao.incrementUsersCount();
	}

	public long getTotalUsersCount() {
		return inventoryDao.getTotalUsersCount();
	}
}
