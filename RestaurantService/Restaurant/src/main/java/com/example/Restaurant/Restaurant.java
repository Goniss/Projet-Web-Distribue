package com.example.Restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	
	@Id
	private long id;
	private String name;
	private String categorie;
	private String description;
	
	public Restaurant()
	{
		name="";
	}
	public Restaurant(String name) {
		super();
		this.name = name;
	}
	public Restaurant(long id, String name, String categorie, String description) {
		super();
		this.id=id;
		this.name = name;
		this.categorie = categorie;
		this.description = description;
	}
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", categorie=" + categorie + "]";
	}

	
	
	
	
	
	

}
