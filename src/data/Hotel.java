package data;

import jade.util.leap.Serializable;

public class Hotel implements Serializable{
	private String name;
	private int rooms, calendar[];
	public Hotel(String name, int rooms, int[] calendar) {
		super();
		this.name = name;
		this.rooms = rooms;
		this.calendar = calendar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public int[] getCalendar() {
		return calendar;
	}
	public void setCalendar(int[] calendar) {
		this.calendar = calendar;
	}
	
	
	

}
