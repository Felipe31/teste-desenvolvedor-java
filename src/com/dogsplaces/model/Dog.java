package com.dogsplaces.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dog {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int age;
	private char gender;
	private float price;
	private String coatColor;
	private boolean sold;
	@ManyToOne
	private Breed breed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCoatColor() {
		return coatColor;
	}
	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}
	public boolean getSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public Breed getBreed() {
		return breed;
	}
	public void setBreed(Breed breed) {
		this.breed = breed;
	}
	
	
}
