package edu.berkeley.bid.cs160.opus;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;

public class TabuApplication extends Application{
	private HashMap<String, HashMap<String, Boolean>> CountryLevels;
	
	@Override
	public void onCreate() {
	        //reinitialize variable
	  this.CountryLevels= new HashMap<String, HashMap<String, Boolean>>();
	  String[] countries= {"Afghanistan", "Argentina", "Brazil", "Bangladesh", "Belize", "Chile", "China", "Canada", "Denmark", "Egypt", "France", "Greece", "Haiti", "India"};
//	  String[] levels= {"INTRO", "AIRPORT", "SHOPPING", "HOTEL"};
	  String[] levels= {"HOTEL" ,"SHOPPING",  "AIRPORT","INTRO"};
	  for(String country : countries)
	  {
		  this.CountryLevels.put(country, new HashMap<String, Boolean>());
		  for (String level: levels)
		  {
			  if (level.contentEquals("INTRO"))
				  this.CountryLevels.get(country).put(level, true);
			  else
				  this.CountryLevels.get(country).put(level, false);
		  }
	  }
	}
	public HashMap<String, HashMap<String, Boolean>> getStructure(){
		return this.CountryLevels;
	}
	@Override
	public void onTerminate() {
		  //reinitialize variable
		  //this.CountryLevels.clear();
	}
	

}
