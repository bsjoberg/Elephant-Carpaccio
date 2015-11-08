package com.bdd.ElephantCarpaccio;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderValueSteps {
	private String itemOneName = "";
	private int itemOnePrice = 0;
	private ShoppingCart cart = new ShoppingCart();
	
	
	@Given("^The price of \"([^\"]*)\" is \\$(\\d+)$")
	public void thePriceOfIs$(String itemName, int price) throws Throwable {
		itemOneName = itemName;
		itemOnePrice = price;
	}

	@When("^I add \"([^\"]*)\" to my cart$")
	public void iAddToMyCart(String itemName) throws Throwable {
		if (itemName.equals(itemOneName))
			cart.add(itemOneName, itemOnePrice);
		else
			throw new UnknownError("Didn't recognize item name");
	}

	@Then("^the order value should be \\$(\\d+)$")
	public void theOrderValueShouldBe$(int cartValue) throws Throwable {
	    Assert.assertEquals(cartValue, cart.getTotal());
	}
}
