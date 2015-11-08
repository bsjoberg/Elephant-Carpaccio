package com.bdd.ElephantCarpaccio;

import java.util.Scanner;

public class RetailStore {
	private static ShoppingCart cart = null;
	
	public RetailStore ()
	{
		cart = new ShoppingCart();
	}
	
	public RetailStore(String stateName) {
		String stateCode = StateNameConverter.convertStateName(stateName);
		cart = new ShoppingCart(stateName);
	}

	public static void main(String[] args) throws UnknownError {
		RetailStore store = new RetailStore();
		Scanner reader = new Scanner (System.in);
		
		System.out.println("Welcome to our retail store");
		
		store.provideOptionsToCustomer(reader);
			
		System.out.println("Your order value is: $" + cart.getTotal());
		reader.close();
	}

	private void provideOptionsToCustomer(Scanner reader) {
		String input = "";
		
		while (!input.equals("c"))
		{
			// Ask what the customer would like to do (add, checkout)
			System.out.println("Current Subtotal: $" + getCart().getSubTotal());
			System.out.println("What would you like to do?");
			System.out.println("(a)dd item, (r)emove last item, set (t)axes, (c)heckout");
			input = reader.nextLine();
			
			if (input.equals("a"))
			{
				System.out.println("Enter item name: ");
				String itemName = reader.nextLine();
				System.out.println("Enter item price: ");
				float itemPrice = reader.nextFloat();
				getCart().add(itemName, itemPrice);
				
				// I had to put this in because the reader has some 
				// information on it that causes it to loop again.
				reader.nextLine();
			}
			else if (input.equals("r"))
			{
				getCart().removeLastItem();
			}
			else if (input.equals("t"))
			{
				System.out.println("Enter tax rate: ");
				float rate = reader.nextFloat();
				getCart().setTaxRate(rate);
				
				// I had to put this in because the reader has some 
				// information on it that causes it to loop again.
				reader.nextLine();
			}
			else if (input.equals("c"))
			{
				break;
			}
			else 
			{
				System.out.println("Didn't recognize that option, try again");
			}
		}	
	}

	public ShoppingCart getCart() {
		return cart;
	}

}
