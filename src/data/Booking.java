package data;

public class Booking {
	private String hotelName, cityName;
	private int start, end;
	
	
	public Booking(String hotelName, String cityName, int start, int end) {
		super();
		this.hotelName = hotelName;
		this.cityName = cityName;
		this.start = start;
		this.end = end;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
