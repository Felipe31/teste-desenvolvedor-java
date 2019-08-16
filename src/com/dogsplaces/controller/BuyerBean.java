package com.dogsplaces.controller;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.BuyerDao;
import com.dogsplaces.dao.SaleDao;
import com.dogsplaces.model.Buyer;
import com.dogsplaces.model.Sale;
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

		BuyerDao buyerDao = new BuyerDao();
		buyerDao.addBuyer(buyer);
		
		if (SessionContext.getInstance().getAttribute("sale") != null) {
			Sale sale = (Sale) SessionContext.getInstance().getAttribute("sale");
			SaleDao saleDao = new SaleDao();
			saleDao.addSale(sale);
		}
			
		SessionContext.getInstance().finishSession();

		
		return "index?faces-redirect=true";
	}
}
