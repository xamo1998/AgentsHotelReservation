package data;

import jade.util.leap.Serializable;

public class ReservationData implements Serializable{
	private String cityName, type;
	private int start, end;
	public ReservationData(String cityName,String type, int start, int end) {
		this.cityName = cityName;
		this.start = start;
		this.end = end;
	}
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}
