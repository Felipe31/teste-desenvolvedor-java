package com.dogsplaces.controller;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.BuyerDao;
import com.dogsplaces.model.Buyer;
import com.dogsplaces.session.SessionContext;

@ManagedBean
public class BuyerBean {
	private Buyer buyer;
	
	public BuyerBean() {
		buyer = new Buyer();
	}

	public Buyer getBuyer() {
		return buyer;
	}
	
	public String submit() {

		try {
			
			BuyerDao buyerDao = new BuyerDao();
			buyerDao.addBuyer(buyer);
			
			SessionContext.getInstance().finishSession();
			
		} catch (Exception e) {
			return "";
		}
		
		return "index?faces-redirect=true";
	}
}
