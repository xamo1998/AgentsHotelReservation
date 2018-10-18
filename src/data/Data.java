package data;

import java.util.ArrayList;


public class Data {
	private static final int SIZE_DAYS=31;
	private ArrayList<City> cities;
	public static final String ACCOMMODATION_TYPE="reserva";
	public static final String LEISURE_TYPE="ocio";
	public static final String ONTOLOGY="ontologia";
	
	public Data() {
		cities=new ArrayList<>();
		//==============================================================//
		//City Vigo
		City vigo =new City("Vigo");
		//Vigo Activities
		ArrayList<Activitie> vigoActivities = new ArrayList<>();
		vigoActivities.add(new Activitie("Vela", getCalendar(1, 31)));
		//Vigo Hotels
		ArrayList<Hotel> vigoHotels= new ArrayList<>();
		vigoHotels.add(new Hotel("Playa Samil", 2, getAvailability(2)));
		vigo.setActivities(vigoActivities);
		vigo.setHotels(vigoHotels);
		//==============================================================//
		//City Plasencia
		City plasencia =new City("Plasencia");
		//Plasencia Activities
		ArrayList<Activitie> plasenciaActivities = new ArrayList<>();
		plasenciaActivities.add(new Activitie("Escalada",getCalendar(1,31)));
		//Plasencia Hotels
		ArrayList<Hotel> plasenciaHotels= new ArrayList<>();
		plasenciaHotels.add(new Hotel("Parador", 1, getAvailability(1)));
		plasencia.setActivities(plasenciaActivities);
		plasencia.setHotels(plasenciaHotels);
		//==============================================================//
		//City Madrid
		City madrid =new City("Madrid");
		//Madrid Activities
		ArrayList<Activitie> madridActivities= new ArrayList<>();
		madridActivities.add(new Activitie("Patinaje", getCalendar(16, 31)));
		madridActivities.add(new Activitie("Open tenis", getCalendar(1, 15)));
		madridActivities.add(new Activitie("Mercado medieval", getCalendar(1, 2)));
		//Madrid Hotels
		ArrayList<Hotel>madridHotels= new ArrayList<>();
		madridHotels.add(new Hotel("Plaza Colón", 2, getAvailability(2)));
		madridHotels.add(new Hotel("Bernabeu", 1, getAvailability(1)));
		madridHotels.add(new Hotel("Cibeles", 3, getAvailability(3)));
		
		madrid.setActivities(madridActivities);
		madrid.setHotels(madridHotels);
		//Add to ArrayList
		cities.add(vigo);
		cities.add(plasencia);
		cities.add(madrid);
	}
	

	private int[] getAvailability(int rooms) {
		int availability[]=new int[SIZE_DAYS+1];
		for(int i=1; i<availability.length;i++) {
			availability[i]=rooms;
		}
		return availability;
	}
	private boolean[] getCalendar(int start, int end) {
		// TODO Auto-generated method stub
		boolean calendar[]=new boolean[SIZE_DAYS+1];
		int count=0;
		for(int i=1; i<calendar.length; i++) {
			if(i>=start && i<=end)
				calendar[i]=true;
			else
				calendar[i]=false;
		}
		return calendar;
	}



	public static String[] getCities() {
		String cities[]= {"Madrid","Plasencia","Vigo"};
		return cities;
	}
	
	public static String[] getTripIntValues(int start, int end) {
		String [] numbers = new String[SIZE_DAYS];
		int count=0;
		for(int i=start; i<=end; i++) {
			numbers[count]=String.valueOf(i);
			count++;
		} 
		return numbers;
	}

}
