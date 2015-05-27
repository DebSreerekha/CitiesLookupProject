package lookup;

import ds.hashtable.MyHashTable;
import lookup.parser.CSVDataParser;

public class CityStateDataManager {
	
	public static final String PATH = "India_Cities_States.csv";
	private MyHashTable<String,String> hashtable ;
	
	public CityStateDataManager()
	{
		CSVDataParser parser = new CSVDataParser(PATH);
		hashtable  = parser.parseFile() ;
	}
	
	public static void main(String []args)
	{
		CityStateDataManager dataManager = new CityStateDataManager() ;
	}

}
