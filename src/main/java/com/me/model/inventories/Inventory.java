package com.me.model.inventories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORIES")
public class Inventory {

	@Id
	@GeneratedValue
	private long id;
	private String type;
	private long count;

	public Inventory() {
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public void incrCount() {
		this.count += 1;
	}

}
