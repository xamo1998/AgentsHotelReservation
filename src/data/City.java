package data;

import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList<Activitie> activities;
	private ArrayList<Hotel> hotels;
	
	

	public City(String name) {
		this.name = name;

	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<Activitie> getActivities() {
		return activities;
	}



	public void setActivities(ArrayList<Activitie> activities) {
		this.activities = activities;
	}



	public ArrayList<Hotel> getHotels() {
		return hotels;
	}



	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}

	
	
}
