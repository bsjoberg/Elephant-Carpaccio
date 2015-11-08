package com.bdd.ElephantCarpaccio;

public class ShoppingCart {
	private int runningTotal = 0;
	
	public void add(String itemName, int itemPrice) {
		runningTotal += itemPrice;
	}

	public int getTotal() {
		return runningTotal;
	}

}
