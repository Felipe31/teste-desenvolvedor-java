package com.dogsplaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.DogDao;
import com.dogsplaces.model.Dog;
import com.dogsplaces.model.ItemSale;
import com.dogsplaces.session.SessionContext;

@ManagedBean
public class SaleBean {
	
	
	public String addSale(ItemSale itemSale) {
		
		List<ItemSale> itemsSale;
		if (SessionContext.getInstance().getItemsSale() == null) {
			itemsSale = new ArrayList<ItemSale>();
		} else {
			itemsSale = SessionContext.getInstance().getItemsSale();
		}
//		ItemSale itemSale = new ItemSale();
		itemsSale.add(itemSale);
		SessionContext.getInstance().setAttribute("itemsSale", itemsSale);
		return "";
	}
	private List<Dog> dogs = null;
	
	public List<Dog> getDogs() {
		if (dogs != null) return dogs;
		
		List<ItemSale> itemsSale;
		if (SessionContext.getInstance().getItemsSale() == null) {
			itemsSale = new ArrayList<ItemSale>();
		} else {
			itemsSale = SessionContext.getInstance().getItemsSale();
		}
		
		
		dogs = new ArrayList<Dog>();
		DogDao dogDao = new DogDao();
		for (ItemSale itemSale : itemsSale) {
			dogs.add(dogDao.getDog(itemSale.getDogId()));
		}

//		dogs.add(new Dog());		
//		dogs.add(new Dog());		
//		dogs.add(new Dog());		
//		dogs.add(new Dog());
		
		return dogs;
		
	}
	
	
//	private SaleDao dao;
//
//	public Sale getSale() {
//		return dao.select();
//	}
//
//	public void setSale(Sale sale) {
//		this.dao.update(sale);
//	}
//	
//	public void insertItem(Dog dog) {
//		this.dao.insert(dog);
//	}
//	
//	public void removeItem(Dog dog) {
//		this.dao.remove(dog);
//	}
//	
//	public float getTotalPrice() {
//		float totalPrice = 0;
//		for (Dog dog : this.dao.getListItemSaleDao) {
//			totalPrice += dog.getPrice();
//		}
//		return totalPrice;
//	}
//	
//	public int getTotalItens() {
//		int totalItens = 0;
//		for (Dog dog : this.dao.getListItemSaleDao) {
//			totalPrice += 1;
//		}
//		return totalItens;
//	}
}
