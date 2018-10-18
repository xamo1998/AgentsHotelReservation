package data;

public class Activitie {
	private String name;
	private boolean calendar[];	
	public Activitie(String name) {
		this.name=name;
	}
	
	
	
	public Activitie(String name, boolean[] calendar) {
		this.name = name;
		this.calendar = calendar;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean[] getCalendar() {
		return calendar;
	}



	public void setCalendar(boolean[] calendar) {
		this.calendar = calendar;
	}



	public String checkActivityDate(){
		String date= null;
		return date;
	}
	
}
