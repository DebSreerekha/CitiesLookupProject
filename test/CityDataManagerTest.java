import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import lookup.CityDataManager;

import org.junit.Test;


public class CityDataManagerTest {

	@Test 
	public void checkFetchForAState(){
		CityDataManager dataManager = new CityDataManager() ;
		String expectedResults[] = { "Adoni","Amalapuram","Anakapalle","Anantapur",	"Bapatla","Bheemunipatnam",	"Bhimavaram","Bobbili","Chilakaluripet",
				 "Chirala","Chittoor","Dharmavaram","Eluru","Gooty","Gudivada","Gudur","Guntakal","Guntur","Hindupur","Jaggaiahpet","Jammalamadugu",
				 "Kadapa","Kadiri","Kakinada","Kandukur","Kavali","Kovvur","Kurnool","Macherla","Machilipatnam","Madanapalle","Mandapeta","Markapur",
				 "Nagari","Naidupet","Nandyal","Narasapuram","Narasaraopet","Narsipatnam","Nellore","Nidadavole","Nuzvid","Ongole","Palacole","Palasa Kasibugga",
			     "Parvathipuram","Pedana","Peddapuram","Pithapuram","Ponnur","Proddatur","Punganur","Puttur","Rajahmundry","Rajam","Rajampet","Ramachandrapuram",
			     "Rayachoti","Rayadurg","Renigunta","Repalle","Salur","Samalkot","Sattenapalle","Srikakulam","Srikalahasti","Srisailam Project (Right Flank Colony) Township",
			     "Sullurpeta","Tadepalligudem","Tadpatri","Tanuku","Tenali","Tirupati","Tiruvuru","Tuni","Uravakonda","Venkatagiri","Vijayawada","Vinukonda",
			     "Visakhapatnam","Vizianagaram","Yemmiganur","Yerraguntla"
				};
		
		String actualResults[] = new String[expectedResults.length];

		ArrayList<String> citiesList = dataManager.lookup("Andhra Pradesh");
		if(citiesList != null)
		{
		 Iterator<String> iterator = citiesList.iterator() ;
		 System.out.println("StateName : "+ "Andhra Pradesh");
		 System.out.println("Cities in :  Andhra Pradesh");
		 int index = 0;
		 while(iterator.hasNext())
		 {
			 String cityName = iterator.next() ;
			 actualResults[index] = cityName;
			 index++;
			
		 }
		 
		 assertArrayEquals(expectedResults, actualResults);
		}
		else
		{
			System.out.println("No entries for the supplied string");

		}
		
	}

}
