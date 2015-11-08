package com.bdd.elephantcarpaccio;

public class Item {
	private String itemName;
	private float itemPrice;
	
	public Item (String name, float price)
	{
		itemName = name;
		itemPrice = price;
	}

	public float getItemPrice() 
	{
		return itemPrice;
	}
	
	public String getItemName()
	{
		return itemName;
	}
}
