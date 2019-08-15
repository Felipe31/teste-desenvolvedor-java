package com.dogsplaces.model;

public class Breed {

	private int id;
	private String name;
	private String description;
	private String coatLength;
	private float height;
	private float weight;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoatLength() {
		return coatLength;
	}
	public void setCoatLength(String coatLength) {
		this.coatLength = coatLength;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float width) {
		this.weight = width;
	}
	
}
