package com.bdd.ElephantCarpaccio;

import org.junit.Test;

import junit.framework.TestCase;

public class ShoppingCartTest extends TestCase {
	
	@Test
	public void testCheckValueAfterAddingOneItemIntegerValue() {
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 500);
		assertEquals(500, cart.getSubTotal(), 2);
	}

	@Test
	public void testCheckValueAfterAddingOneItemDecimalValue() {
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", (float)520.10);
		assertEquals(520.10, cart.getSubTotal(), 2);
	}
	
	@Test 
	public void testCheckValueAfterAddingTwoItemsSameIntegerValue() {
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 500);
		cart.add("Item Two", 500);
		assertEquals(1000, cart.getSubTotal(), 2);
	}
	
	@Test 
	public void testCheckValueAfterAddingTwoItemsDifferentIntegerValue() {
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		cart.add("Item Two", 500);
		assertEquals(1100, cart.getSubTotal(), 2);	
	}
	
	@Test
	public void testCheckValueAfterAddingTwoItemsDifferentDecimalValue() {
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", (float)600.23);
		cart.add("Item Two", (float)500.56);
		assertEquals(1100.79, cart.getSubTotal(), 2);	
	}
	
	@Test
	public void testNumberOfItemsInCartWithOne()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		assertEquals(1, cart.getNumberOfItems());
	}
	
	@Test
	public void testNumberOfItemsInCartWithTwo()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		cart.add("Item Two", 500);
		assertEquals(2, cart.getNumberOfItems());
	}
	
	@Test
	public void testRemoveLastItemFromCartWithTwoItems()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		cart.add("Item Two", 500);
		assertEquals(2, cart.getNumberOfItems());
		cart.removeLastItem();
		assertEquals(1, cart.getNumberOfItems());
	}
	
	@Test
	public void testRemoveLastItemFromCartWithTwoItemsAndCheckValue()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		cart.add("Item Two", 500);
		assertEquals(1100, cart.getSubTotal(), 2);
		cart.removeLastItem();
		assertEquals(600, cart.getSubTotal(), 2);
	}
	
	@Test
	public void testRemoveFirstItemFromCartWithTwoItemsAndCheckValue()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		cart.add("Item Two", 500);
		assertEquals(1100, cart.getSubTotal(), 2);
		cart.removeFirstItem();
		assertEquals(500, cart.getSubTotal(), 2);
	}
	
	@Test 
	public void testApplyTaxesToCartWithOneItem() 
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 600);
		cart.setTaxes((float)6.85);
		assertEquals(641.1, cart.getTotal(), 2);
	}
	
	@Test 
	public void testApplyTaxesToCartWithTwoItems() 
	{
		ShoppingCart cart = new ShoppingCart();
		cart.add("Item One", 500);
		cart.add("Item Two", 500);
		cart.setTaxes((float)6.85);
		assertEquals(1068.50, cart.getTotal(), 2);
	}
}
