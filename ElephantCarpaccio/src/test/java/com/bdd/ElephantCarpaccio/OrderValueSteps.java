package com.bdd.ElephantCarpaccio;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderValueSteps {
	private String itemOneName = "";
	private float itemOnePrice = 0;
	private ShoppingCart cart = new ShoppingCart();
	
	@Given("^The price of \"([^\"]*)\" is (\\d+)$")
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

	@Then("^the order value should be (\\d+)$")
	public void theOrderValueShouldBe(int cartValueInt) throws Throwable {
	    float cartValue = Float.parseFloat(Integer.toString(cartValueInt));
		Assert.assertEquals(cartValue, cart.getTotal(), 2);
	}
	
	@Given("^The price of \"([^\"]*)\" is (\\d+)\\.(\\d+)$")
	public void thePriceOfItemIs(String itemName, @Transform(MoneyConverter.class)Money amount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    itemOneName = itemName;
	    itemOnePrice = Float.parseFloat(amount.toString());
	}

	@Then("^the order value should be (\\d+)\\.(\\d+)$")
	public void theOrderValueShouldBe(@Transform(MoneyConverter.class) Money amount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Float cartValue = Float.parseFloat(amount.toString());
	    Assert.assertEquals(cartValue, cart.getTotal(), 2);
	}
}
