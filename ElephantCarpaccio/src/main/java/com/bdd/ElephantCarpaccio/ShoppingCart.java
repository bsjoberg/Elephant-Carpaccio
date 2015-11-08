package com.bdd.ElephantCarpaccio;

public class ShoppingCart {
	private float runningTotal = 0;
	
	public void add(String itemName, float itemOnePrice) {
		runningTotal += itemOnePrice;
	}

	public float getTotal() {
		return runningTotal;
	}

}
