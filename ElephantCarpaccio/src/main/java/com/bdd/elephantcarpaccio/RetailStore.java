package com.bdd.elephantcarpaccio;

import java.util.Scanner;

public class RetailStore {
	private static ShoppingCart cart = null;
	
	public RetailStore ()
	{
		cart = new ShoppingCart();
	}
	
	public RetailStore(String stateName) {
		String stateCode = StateNameConverter.convertStateName(stateName);
		cart = new ShoppingCart(stateCode);
	}

	public static void main(String[] args) throws UnknownError {
		String stateName = "Utah";
		RetailStore store = new RetailStore(stateName);
		Scanner reader = new Scanner (System.in);
		
		System.out.println("Welcome to our " + stateName + " retail store");
		
		store.provideOptionsToCustomer(reader);
			
		System.out.println("Your order value is: $" + cart.getTotal());
		reader.close();
	}

	private void provideOptionsToCustomer(Scanner reader) {
		String input = "";
		
		while (!("c").equals(input))
		{
			// Ask what the customer would like to do (add, checkout)
			System.out.println("Current Subtotal: $" + getCart().getSubTotal());
			System.out.println("What would you like to do?");
			System.out.println("(a)dd item, (r)emove last item, set (t)axes, (c)heckout");
			input = reader.nextLine();
			
			if (("a").equals(input))
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
			else if (("r").equals(input))
			{
				getCart().removeLastItem();
			}
			else if (("t").equals(input))
			{
				System.out.println("Enter tax rate: ");
				float rate = reader.nextFloat();
				getCart().setTaxRate(rate);
				
				// I had to put this in because the reader has some 
				// information on it that causes it to loop again.
				reader.nextLine();
			}
			else if (("c").equals(input))
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
