package com.bdd.ElephantCarpaccio;

class StateNameConverter {

	public static String convertStateName(String stateName) {
		String stateCode = "";
		
		if (stateName.equals("Utah"))
			stateCode = "UT";
		else if (stateName.equals("Nevada"))
			stateCode = "NV";
		return stateCode;
	}

}
