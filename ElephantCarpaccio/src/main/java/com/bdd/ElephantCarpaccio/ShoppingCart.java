package com.bdd.ElephantCarpaccio;

import java.util.LinkedList;

public class ShoppingCart {
	LinkedList<Item> cart = new LinkedList<Item>();
	private float runningSubTotal = 0;
	private float taxRate = 0;
	
	public ShoppingCart()
	{
		
	}
	
	public ShoppingCart(String stateCode) {
		if (stateCode == "UT")
			setTaxRate((float)6.85);
	}

	public void add(String itemName, float itemPrice) {
		cart.add(new Item(itemName, itemPrice));
		runningSubTotal += itemPrice;
	}

	public float getSubTotal() {
		return runningSubTotal;
	}

	public int getNumberOfItems() {
		return cart.size();
	}

	public void removeLastItem() {
		float itemPrice = cart.get(cart.size() - 1).getItemPrice();
		runningSubTotal -= itemPrice;
		cart.remove();
	}
	
	public void removeFirstItem() {
		float itemPrice = cart.get(0).getItemPrice();
		runningSubTotal -= itemPrice;
		cart.remove();
	}

	public void setTaxRate(float rate) {
		taxRate = rate;
	}

	public float getTotal() {
		float total = runningSubTotal * taxRate/100 + runningSubTotal;
		return total;
	}
}
