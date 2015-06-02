package lookup;
import java.util.ArrayList;
import java.util.Iterator;

import parser.CSVDataParser;
import ds.hashtable.MyHashTable;

public class CityDataManager {
	
	public static final String PATH_India = "India_Cities_States.csv";
	
	private MyHashTable<String,String> hashtable ;
	
	public CityDataManager()
	{
		hashtable = new MyHashTable<String,String>();
		CSVDataParser parser_india = new CSVDataParser(PATH_India);
		hashtable  = parser_india.parseFile() ;
	}
	
	public static void main(String []args)
	{
		CityDataManager dataManager = new CityDataManager() ;
		ArrayList<String> citiesList = dataManager.lookup("Andhra Pradesh");
		if(citiesList != null)
		{
		 Iterator<String> iterator = citiesList.iterator() ;
		 System.out.println("StateName : "+ "Andhra Pradesh");
		 System.out.println("Cities in :  Andhra Pradesh");
		 while(iterator.hasNext())
		 {
			 String cityName = iterator.next() ;
			 System.out.println(cityName);
		 }
		}
		else
		{
			System.out.println("No entries for the supplied string");

		}
		
		

	}

	public  ArrayList<String> lookup(String stateName) {
		// TODO Auto-generated method stub
		
		return hashtable.get(stateName);
		
	}

}
