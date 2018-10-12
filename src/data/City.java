package data;

public class City {
	private String name;
	private Activities activities;
	
	public City(String name, Activities activities) {
		super();
		this.name = name;
		this.activities = activities;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Activities getActivities() {
		return activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}
	
	
}
