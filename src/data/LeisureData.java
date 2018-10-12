package data;

import java.util.ArrayList;

public class LeisureData {
	private ArrayList<City> cities;
	
	
	public static LeisureData getLeisureData() {
		LeisureData leisureData= new LeisureData();
		leisureData.cities=new ArrayList<>();
		leisureData.cities.add(new City("Vigo", new Activities("Vela")));
		leisureData.cities.add(new City("Plasencia", new Activities("Escalada")));
		leisureData.cities.add(new City("Madrid", new Activities("Patinaje")));
		leisureData.cities.add(new City("Madrid", new Activities("Open Tenis")));
		leisureData.cities.add(new City("Madrid", new Activities("Mercado medieval")));
		return leisureData;
	}
	
}
