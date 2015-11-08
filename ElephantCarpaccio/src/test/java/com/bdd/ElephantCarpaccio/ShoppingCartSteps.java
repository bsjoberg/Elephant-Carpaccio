package com.bdd.ElephantCarpaccio;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartSteps {
	private RetailStore store = new RetailStore();

	@Then("^the order value should be (\\d+)\\.(\\d+)$")
	public void theOrderValueShouldBe(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		Float cartValue = Float.parseFloat(amount.toString());
	    Assert.assertEquals(cartValue, store.getCart().getTotal(), 2);
	}
	
	@Given("^I am shopping in a retail store$")
	public void iAmShoppingInARetailStore() throws Throwable {
	    // Store needs to be up and running.
		store = new RetailStore();
	}

	@When("^I add \"([^\"]*)\" of (\\d+) dollars$")
	public void iAddItemOfDollarValue(String itemName, int value) throws Throwable {
		store.getCart().add(itemName, value);
	}

	@Then("^my checkout value should be (\\d+) dollars$")
	public void myCheckoutValueShouldBe(int value) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(value, store.getCart().getTotal(), 2);
	}
	
	@When("^I remove the last item$")
	public void iRemoveTheLastItem() throws Throwable {
		store.getCart().removeLastItem();
	}

}
