package com.dogsplaces.controller;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.model.Buyer;

@ManagedBean
public class BuyerBean {
	private Buyer buyer;
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public void salvar() {
		System.out.println(a);
	}
}
