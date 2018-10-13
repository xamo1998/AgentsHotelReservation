package data;

public class Data {
	private static final int SIZE_DAYS=31;
	public static final String ACCOMMODATION_TYPE="reserva";
	public static final String LEISURE_TYPE="ocio";
	public static String[] getCities() {
		String cities[]= {"Madrid","Plasencia","Vigo"};
		return cities;
	}
	
	public static String[] getTripIntValues(int start, int end) {
		String [] numbers = new String[SIZE_DAYS];
		int contador=0;
		for(int i=start; i<=end; i++) {
			numbers[contador]=String.valueOf(i);
			contador++;
		} 
		return numbers;
	}

}
