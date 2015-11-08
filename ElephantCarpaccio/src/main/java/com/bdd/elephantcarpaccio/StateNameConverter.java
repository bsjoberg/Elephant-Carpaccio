package com.bdd.elephantcarpaccio;

public class StateNameConverter {
	
	public static String convertStateName(String stateName) {
		String stateCode = "";
		
		if (("Utah").equals(stateName))
			stateCode = "UT";
		else if (("Nevada").equals(stateName))
			stateCode = "NV";
		return stateCode;
	}

}
