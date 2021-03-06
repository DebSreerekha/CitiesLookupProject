package benchmarking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

import ds.hashtable.*;

public class JavaHashtableBasedDataParser implements Parser{
		
		private Hashtable<String , String>  hashtable ;
		private  FileReader reader ; 
		
		public JavaHashtableBasedDataParser(String path){
			try {
				hashtable = new Hashtable<String,String>();
				reader = new FileReader(new File(path)) ;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
		}
		@Override
		public Hashtable<String,String> parseFile(){
			BufferedReader bufferedReader ;
		    try {
			        
			        bufferedReader = new BufferedReader(reader) ;
			        while(bufferedReader.ready()){
			            String lineRead = bufferedReader.readLine();
			            createHashTableEntry(lineRead );
			        } 
		       
		    }
		    catch( IOException ioe ) {
		        
		        ioe.printStackTrace();
		        System.exit(0);
		    }
			return hashtable;
		}

		private void createHashTableEntry(String lineRead) {
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
			hashtable.put(Names[1],Names[0]);	
		}
		

	}


