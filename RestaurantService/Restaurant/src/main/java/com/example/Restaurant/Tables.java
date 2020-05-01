package com.example.Restaurant;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Tables {

	@Id
	private long     id;
	private int      capacity;
	private boolean  reserve;
	private String restaurant;

	
	public Tables()
	{
		capacity=0;
		reserve=false;
		restaurant="";
	}
	
	public Tables(int capacity, boolean reserve, String restaurant)
	{
		this.capacity = capacity;
		this.reserve=reserve;
		this.restaurant=restaurant;
		
	}
	public Tables(long id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
		reserve=false;
	}

	@GeneratedValue(strategy= GenerationType.AUTO)
	public long getId() {
		return id;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}	


	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Table [capacity=" + capacity + ", reserve=" + reserve + "]";
	}
	
	
}
