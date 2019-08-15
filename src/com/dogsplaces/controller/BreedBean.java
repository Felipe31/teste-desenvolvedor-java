package com.dogsplaces.controller;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.BreedDao;
import com.dogsplaces.model.Breed;

@ManagedBean
public class BreedBean {

	public Breed getBreed(int id) {
		BreedDao breedDao = new BreedDao(null);
		return breedDao.getBreed(id);
	}
}
