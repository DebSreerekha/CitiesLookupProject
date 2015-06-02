package benchmarking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.StringTokenizer;

import ds.hashtable.Entry;

public class ArrayListBasedDataParser implements Parser {

	private ArrayList<Entry<String , String>>  list ;
	private  FileReader reader ; 
	
	public ArrayListBasedDataParser(String pathIndia) {
		try {
			list = new ArrayList<Entry<String,String>>();
			reader = new FileReader(new File(pathIndia)) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	@Override
	public ArrayList<Entry<String,String>> parseFile() {
		BufferedReader bufferedReader ;
	    try {
		        
		        bufferedReader = new BufferedReader(reader) ;
		        while(bufferedReader.ready()){
		            String lineRead = bufferedReader.readLine();
		            createListEntry(lineRead );
		        } 
	       
	    }
	    catch( IOException ioe ) {
	        
	        ioe.printStackTrace();
	        System.exit(0);
	    }
		return list;
	}
	
	private void createListEntry(String lineRead) {
		// TODO Auto-generated method stub
		StringTokenizer tokenizer = new StringTokenizer (lineRead,",");
		String Names [] =new String[2] ;
		int i = 0;
		while(tokenizer.hasMoreTokens())
		{
			Names[i] = tokenizer.nextToken() ;
			i++;
		}
	//	System.out.println(Names[1] + ":" +Names[0]);
		list.add (new Entry(Names[1],Names[0]));	
	}
	

}
