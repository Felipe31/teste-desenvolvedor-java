package com.dogsplaces.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sale {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int buyerId;
	private boolean finished;
	
	@ManyToOne
	private Buyer buyer;
	
	@OneToMany(mappedBy="sale")
	private	List<Dog> dogs;
	
	
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public List<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	
}
