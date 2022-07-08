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

public class Test_Case_1 {

	@Test
	public void verify_team_has_only_4_foreign_players() throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser jsonParser = new JSONParser();
		int countForeignPlayers=0;
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src\\test\\resources\\TeamRCB.json"));
	    JSONArray jsonArray = (JSONArray) jsonObject.get("player");
	    for(int i=0; i<jsonArray.size();i++) {
	    	JSONObject jsonobject = (JSONObject) jsonArray.get(i);
	        String country = jsonobject.get("country").toString();
	        if(country.equals("India")){}
	        else{
	        	countForeignPlayers++;
	        }
	    }	         
		Assert.assertTrue(countForeignPlayers==4);
	}
}
