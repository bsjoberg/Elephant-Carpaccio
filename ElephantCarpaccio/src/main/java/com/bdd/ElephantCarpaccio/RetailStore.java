package com.bdd.ElephantCarpaccio;

import java.util.Scanner;

public class RetailStore {

	public static void main(String[] args) {
		Scanner reader = new Scanner (System.in);
		System.out.println("Enter item name: ");
		String itemName = reader.nextLine();
		System.out.println("Enter item price: ");
		int itemPrice = reader.nextInt();
		
		ShoppingCart cart = new ShoppingCart();
		cart.add(itemName, itemPrice);
		
		System.out.println("Your order value is: $" + cart.getTotal());
		reader.close();
	}

}
