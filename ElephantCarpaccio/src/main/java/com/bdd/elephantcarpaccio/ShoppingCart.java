package com.bdd.elephantcarpaccio;

import java.util.LinkedList;

public class ShoppingCart {
	private LinkedList<Float> cart;
	private float runningSubTotal;
	private float taxRate;
	
	public ShoppingCart()
	{
		cart = new LinkedList<Float>();
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

	public void add(int numberOfItems, float itemPrice)
	{
		for (int i = 0; i < numberOfItems; i++)
		{
			add(itemPrice);
		}
	}
	
	public void add(float itemPrice) {
		cart.add(itemPrice);
		runningSubTotal += itemPrice;
	}

	public float getSubTotal() {
		return runningSubTotal;
	}

	public int getNumberOfItems() {
		return cart.size();
	}

	public void removeItem() 
	{
		runningSubTotal -= cart.getFirst().floatValue();
		cart.remove();
	}

	public void setTaxRate(float rate) {
		taxRate = rate;
	}

	public float getTotal() {
		return runningSubTotal * taxRate / 100 + runningSubTotal;
	}
}
