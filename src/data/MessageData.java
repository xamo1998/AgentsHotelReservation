package data;

import jade.util.leap.Serializable;

public class MessageData implements Serializable{
	private String cityName, type;
	private int start, end;
	public MessageData(String cityName,String type, int start, int end) {
		this.cityName = cityName;
		this.type=type;
		this.start = start;
		this.end = end;
	}
	public MessageData(String cityName,String type, int start) {
		this.cityName = cityName;
		this.type=type;
		this.start = start;
		this.end = -1;
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
