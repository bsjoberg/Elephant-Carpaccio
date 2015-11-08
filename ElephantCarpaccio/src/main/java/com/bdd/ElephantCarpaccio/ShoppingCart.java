package com.bdd.ElephantCarpaccio;

import java.util.LinkedList;

public class ShoppingCart {
	LinkedList<Item> cart = new LinkedList<Item>();
	private float runningTotal = 0;
	
	public void add(String itemName, float itemPrice) {
		cart.add(new Item(itemName, itemPrice));
		runningTotal += itemPrice;
	}

	public float getTotal() {
		return runningTotal;
	}

	public int getNumberOfItems() {
		return cart.size();
	}

	public void removeItem() {
		float itemPrice = cart.get(cart.size() - 1).getItemPrice();
		runningTotal -= itemPrice;
		cart.remove();
	}

}
