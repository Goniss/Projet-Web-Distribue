package com.example.Reservation;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	long     id;
	String   restaurant;
	String   name;
	int      nbrClients;
	Date     DateReservation;
	int      HeureReservation;
	

	public Reservation() {
		super();
		restaurant="";
		name="";
		nbrClients = 0;
	}
	
	
	public Reservation(String restaurant, String name, int nbrClients, Date dateReservation, int heureReservation) {
		super();
		this.restaurant = restaurant;
		this.name = name;
		this.nbrClients = nbrClients;
		DateReservation = dateReservation;
		HeureReservation = heureReservation;
	}



	public long getId() {
		return id;
	}
	
	public String getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	public int getNbrClients() {
		return nbrClients;
	}

	public void setNbrClients(int nbrClients) {
		this.nbrClients = nbrClients;
	}

	
	public Date getDateReservation() {
		return DateReservation;
	}


	public void setDateReservation(Date dateReservation) {
		DateReservation = dateReservation;
	}


	public int getHeureReservation() {
		return HeureReservation;
	}


	public void setHeureReservation(int heureReservation) {
		HeureReservation = heureReservation;
	}


	@Override
	public String toString() {
		return "Reservation [restaurant=" + restaurant + ", Name=" + name + ", nbrClients=" + nbrClients + "]";
	}

	
	

}
