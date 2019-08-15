package com.dogsplaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.model.ItemSale;
import com.dogsplaces.session.SessionContext;

@ManagedBean
public class SaleBean {
	
	
	public String addSale() {
		System.out.println("sdfasdf");
		int i = 3;
		List<ItemSale> itemsSale;
		if (SessionContext.getInstance().getItemsSale() == null) {
			itemsSale = new ArrayList<ItemSale>();
			System.out.println("primeira sessao");
		} else {
			itemsSale = SessionContext.getInstance().getItemsSale();
			System.out.println("tem sessao");
			
		}
		ItemSale itemSale = new ItemSale();
		itemSale.setDogId(i);
		itemSale.setSaleId(i);
		itemsSale.add(itemSale);
		SessionContext.getInstance().setAttribute("itemsSale", itemsSale);
			
		return "checkout?faces-redirect=true";
	}
	
	public String addSale(int e) {
		System.out.println("sdfasdf");
		int i = 3;
		List<ItemSale> itemsSale;
		if (SessionContext.getInstance().getItemsSale() == null) {
			itemsSale = new ArrayList<ItemSale>();
			System.out.println("primeira sessao");
		} else {
			itemsSale = SessionContext.getInstance().getItemsSale();
			System.out.println("tem sessao");
			
		}
		ItemSale itemSale = new ItemSale();
		itemSale.setDogId(i);
		itemSale.setSaleId(i);
		itemsSale.add(itemSale);
		SessionContext.getInstance().setAttribute("itemsSale", itemsSale);
		return "";
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
