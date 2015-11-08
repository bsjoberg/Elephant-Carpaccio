package com.bdd.ElephantCarpaccio;

import java.util.Scanner;

public class RetailStore {
	private static ShoppingCart cart = null;
	
	public RetailStore ()
	{
		cart = new ShoppingCart();
	}
	
	public static void main(String[] args) throws UnknownError {
		Scanner reader = new Scanner (System.in);
		
		// Ask what the customer would like to do (add, remove, checkout)
		System.out.println("Welcome to our retail store");
		System.out.println("What would you like to do?");
		System.out.println("(a)dd, (r)emove, (c)heckout");
		String input = reader.nextLine();
		
		if (System.console() == null)
			System.out.println("Consule is null");
		
		if (input.equals("a"))
		{
			System.out.println("Enter item name: ");
			String itemName = reader.nextLine();
			System.out.println("Enter item price: ");
			float itemPrice = reader.nextFloat();
			cart.add(itemName, itemPrice);			
		}
		else
		{
			throw new UnknownError("Not a valid option");
		}
		
		System.out.println("Your order value is: $" + cart.getTotal());
		reader.close();
	}

	public ShoppingCart getCart() {
		return cart;
	}

}
