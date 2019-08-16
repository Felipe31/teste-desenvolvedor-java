package com.dogsplaces.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.dogsplaces.dao.DogDao;
import com.dogsplaces.model.Dog;
import com.dogsplaces.session.SessionContext;

@ManagedBean
public class DogBean {
	private DogDao dao = new DogDao();
	private List<Dog> dogs;
	private Dog dog;
	private String searchString = "";
	
	public String viewDetail(Dog dog) {
		SessionContext.getInstance().setAttribute("dogDetail", dog);
		return "dog?faces-redirect=true";
	}
	
	public String searchDog() {
		dogs = dao.searchDog(searchString);
		SessionContext.getInstance().setAttribute("search", dogs);
		return "search?faces-redirect=true";
	}

	public List<Dog> getDogs() {
		if(dogs == null) {
			if(SessionContext.getInstance().getAttribute("search") != null) {
				dogs = (List<Dog>) SessionContext.getInstance().getAttribute("search");
			} else {
				dogs = dao.getDogList();
			}
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

	public Dog getDog() {
		if(dog == null) {
			if(SessionContext.getInstance().getAttribute("dogDetail") != null) {
				setDog((Dog) SessionContext.getInstance().getAttribute("dogDetail"));
			}
		}
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
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
