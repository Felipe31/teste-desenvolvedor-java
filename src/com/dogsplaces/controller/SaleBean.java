package com.dogsplaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.DogDao;
import com.dogsplaces.model.Dog;
import com.dogsplaces.model.ItemSale;
import com.dogsplaces.model.Sale;
import com.dogsplaces.session.SessionContext;

@ManagedBean
public class SaleBean {
	
	public String addSale(Dog dog) {
		
		Sale sale;
		if (SessionContext.getInstance().getAttribute("sale") == null) {
			sale = new Sale();
		} else {
			sale = (Sale) SessionContext.getInstance().getAttribute("sale");
		}

		sale.getDogs().add(dog);
		SessionContext.getInstance().setAttribute("sale", sale);
		return "";
	}
	
	public List<Dog> getDogs() {
		
		Sale sale = (Sale) SessionContext.getInstance().getAttribute("sale");
		if (sale == null) {
			return new ArrayList<Dog>();
		}
			
		return sale.getDogs();
	}

}
