package com.bdd.ElephantCarpaccio;

public class Item {
	String itemName;
	float itemPrice;
	
	public Item (String name, float price)
	{
		itemName = name;
		itemPrice = price;
	}

	public float getItemPrice() {
		return itemPrice;
	}
}
