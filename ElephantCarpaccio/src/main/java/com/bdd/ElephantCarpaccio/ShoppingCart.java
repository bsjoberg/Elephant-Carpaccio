package com.bdd.ElephantCarpaccio;

public class ShoppingCart {
	private float runningTotal = 0;
	private int numberOfItems = 0;
	
	public void add(String itemName, float itemOnePrice) {
		runningTotal += itemOnePrice;
		numberOfItems++;
	}

	public float getTotal() {
		return runningTotal;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void removeItem() {
		// TODO Auto-generated method stub
		
	}

}
