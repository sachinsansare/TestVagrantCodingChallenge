package testClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Case_2 {
	
	@Test
	public void verify_team_has_at_least_1_wicket_keeper() throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser jsonParser = new JSONParser();
		int countWicketKeeper=0;
		JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\test\\resources\\TeamRCB.json"));
	    JSONArray jsonArray = (JSONArray) jsonObject.get("player");
	    for(int i=0; i<jsonArray.size();i++) {
	    	JSONObject jsonobject = (JSONObject) jsonArray.get(i);
	        String country = jsonobject.get("role").toString();
	        if(country.equals("Wicket-keeper")){
	        	countWicketKeeper++;
	        }	         
		} 
		Assert.assertTrue(countWicketKeeper>=1);
	}

}
