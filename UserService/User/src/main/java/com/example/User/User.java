package com.example.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class User {

	@Id
	long id;
	String name;
	String adresse;
	String telephone;
	
	public User()
	{
		name="";
		adresse="";
		telephone="";
	}
	
	public User(String name) {
		super();
		this.name = name;
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
	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
	
}
