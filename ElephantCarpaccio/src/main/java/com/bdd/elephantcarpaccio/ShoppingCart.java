package com.bdd.elephantcarpaccio;

import java.util.LinkedList;

public class ShoppingCart {
	private LinkedList<Item> cart;
	private float runningSubTotal;
	private float taxRate;
	
	public ShoppingCart()
	{
		cart = new LinkedList<Item>();
		runningSubTotal = 0;
		taxRate = 0;
	}
	
	public ShoppingCart(String stateCode) 
	{
		this();
		if (stateCode == "UT")
			setTaxRate((float)6.85);
		else if (stateCode == "NV")
			setTaxRate((float)8.0);
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
