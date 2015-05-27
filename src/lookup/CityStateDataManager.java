package lookup;

import java.util.ArrayList;
import java.util.Iterator;

import ds.hashtable.MyHashTable;
import lookup.parser.CSVDataParser;

public class CityStateDataManager {
	
	public static final String PATH = "India_Cities_States.csv";
	private MyHashTable<String,String> hashtable ;
	
	public CityStateDataManager()
	{
		//hashtable = new MyHashTable<String,String>();
		CSVDataParser parser = new CSVDataParser(PATH);
		hashtable  = parser.parseFile() ;
	}
	
	public static void main(String []args)
	{
		CityStateDataManager dataManager = new CityStateDataManager() ;
		ArrayList<String> citiesList = dataManager.lookup("Andhra Pradesh");
		if(citiesList != null)
		{
		 Iterator<String> iterator = citiesList.iterator() ;
		 System.out.println("StateName : "+ "Andhra Pradesh");
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
