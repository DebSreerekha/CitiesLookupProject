package benchmarking;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import ds.hashtable.Entry;
import ds.hashtable.MyHashTable;


public class PerformanceBenchmarking {
	
	public static final String PATH_India = "India_Cities_States.csv";
	
	private JavaHashtableBasedDataParser javaHashtableBasedParser ;
	private MyHashtableBasedDataParser myHashtableBasedParser ;
	private ArrayListBasedDataParser listBasedParser;
	
	private Hashtable<String,String> javaHashtable ;
	private MyHashTable<String,String> myHashtable ;
	private ArrayList<Entry<String,String>> list ;
	public PerformanceBenchmarking()
	{
		javaHashtableBasedParser = new JavaHashtableBasedDataParser(PATH_India);
		myHashtableBasedParser = new MyHashtableBasedDataParser(PATH_India); 
		listBasedParser = new ArrayListBasedDataParser(PATH_India);
		
		javaHashtable = javaHashtableBasedParser.parseFile();
		myHashtable   = myHashtableBasedParser.parseFile();
		list = (ArrayList<Entry<String, String>>) listBasedParser.parseFile();
		
	}
	public long calculateFetchTimeForJavaHashtable(String Key)
	{
		Long ctime1 = System.currentTimeMillis();
		for(int i =0 ;i<100000;i++)
		{
			javaHashtable.get(Key);
		}
		Long ctime2 = System.currentTimeMillis();
		
		Long timetaken = ctime2 - ctime1 ;
		
		return timetaken.longValue() ;
		
	}
	
	public long calculateFetchTimeForMyHashtable(String Key)
	{
		Long ctime1 = System.currentTimeMillis();
		for(int i =0 ;i<100000;i++)
		{
			myHashtable.get(Key);
		}
		Long ctime2 = System.currentTimeMillis();
		
		Long timetaken = ctime2 - ctime1 ;
		
		return timetaken.longValue() ;
		
	}
	
	public long calculateFetchTimeForArrayList(String Key)
	{
		Long ctime1 = System.currentTimeMillis();
		for(int i =0 ;i<100000;i++)
		{
			Iterator iterator = list.iterator();
			ArrayList values = new ArrayList();
			while(iterator.hasNext())
			{
				Entry<String,String> nextEntry = (Entry<String, String>) iterator.next() ;
				String theKey = nextEntry.getKey();
				if(theKey.equals(Key)){
					values.add(nextEntry.getValue());
				}
			}
			
			
		}
		Long ctime2 = System.currentTimeMillis();
		
		Long timetaken = ctime2 - ctime1 ;
		
		return timetaken.longValue() ;
		
	}
	
	public static void main(String[] args){
		
		PerformanceBenchmarking pbm = new PerformanceBenchmarking();
		System.out.println("Time taken for  Java Hashtable :"+pbm.calculateFetchTimeForJavaHashtable("Andhra Pradesh") ) ;
		System.out.println("Time taken for  MyHashtable :"+pbm.calculateFetchTimeForMyHashtable("Andhra Pradesh") ) ;
		System.out.println("Time taken for  Sequential search with ArrayList :"+pbm.calculateFetchTimeForArrayList("Andhra Pradesh") ) ;
		
	}
	

}
