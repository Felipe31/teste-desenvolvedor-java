package com.dogsplaces.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.DogDao;
import com.dogsplaces.model.Dog;

@ManagedBean
public class DogBean {
	private DogDao dao = new DogDao();
	private List<Dog> dogs;
	private String searchString = "";
	
	public void searchDog() {
		dogs = dao.searchDog(searchString);
	}

	public List<Dog> getDogs() {
		if(dogs == null) {
			dogs = dao.getDogList();
		}

		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

//	public Dog getDog() {
//		return dao.select(); Select em um catioro
//	}

//	public void setDog(Dog dog) {
//		this.dao.update(dog); Update em um catioro
//	}
	
//	public List<Dog> getDogs() {
//		return dao.selectAsteriscoFromDog()
//	}
}
