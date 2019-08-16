package com.dogsplaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.model.Dog;
import com.dogsplaces.model.Sale;
import com.dogsplaces.session.SessionContext;

@ManagedBean
public class SaleBean {
	
	public void addSale(Dog dog) {
		System.out.println("Dog added to cart");
		System.out.println(dog.getBreed().getName());
		Sale sale;
		if (SessionContext.getInstance().getAttribute("sale") == null) {
			sale = new Sale();
			sale.setDogs(new ArrayList<Dog>());
		} else {
			sale = (Sale) SessionContext.getInstance().getAttribute("sale");
			List<Dog> dogs = sale.getDogs();
			for (Dog curdog : dogs) {
				if(curdog.getId() == dog.getId())
					return;
			}
		}

		sale.getDogs().add(dog);
		SessionContext.getInstance().setAttribute("sale", sale);
	}
	
	public void removeSale(Dog dog) {
		System.out.println("Dog removed from cart");
		System.out.println(dog.getBreed().getName());
		Sale sale;
		if (SessionContext.getInstance().getAttribute("sale") == null) {
			return;
		} else {
			sale = (Sale) SessionContext.getInstance().getAttribute("sale");
		}

		sale.getDogs().remove(dog);
		SessionContext.getInstance().setAttribute("sale", sale);
	}
	
	public List<Dog> getDogs() {
		
		Sale sale = (Sale) SessionContext.getInstance().getAttribute("sale");
		if (sale == null) {
			return new ArrayList<Dog>();
		}
			
		return sale.getDogs();
	}

}
