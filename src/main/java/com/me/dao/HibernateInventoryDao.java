package com.me.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.me.model.inventories.Inventory;

@Repository
public class HibernateInventoryDao implements InventoryDao {

	@PersistenceContext(unitName = "inventoryPU")
	private EntityManager em;

	@Override
	public void incrementUsersCount() {

		List<Inventory> resultList = em.createQuery(
				"from Inventory where type='users'", Inventory.class)
				.getResultList();

		if (resultList.isEmpty()) {
			System.out.println("Creating...");
			createNewUserInventory();
		} else {
			System.out.println("Merging...");
			Inventory inv = resultList.get(0);
			inv.incrCount();
			em.merge(inv);
		}
	}

	@Override
	public long getTotalUsersCount() {
		try {
			return em
					.createQuery("from Inventory where type='users'",
							Inventory.class).getSingleResult().getCount();
		} catch (NoResultException ex) {
			return -1;
		}
	}

	@Override
	public void createNewUserInventory() {
		Inventory inventory = new Inventory();
		inventory.setCount(1);
		inventory.setType("users");
		em.persist(inventory);
	}

}
