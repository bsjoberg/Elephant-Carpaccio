package com.bdd.ElephantCarpaccio;

import java.text.DecimalFormat;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartSteps {
	private RetailStore store = new RetailStore();

	@Then("^the order value should be (\\d+)\\.(\\d+)$")
	public void theOrderValueShouldBe(int integerAmt, int fractionAmt) throws Throwable {
		float cartValue = parseIntoFloat(integerAmt, fractionAmt);
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

	@When("^I apply a sales tax of (\\d+)\\.(\\d+)%$")
	public void iApplyASalesTaxOf(int integerAmt, int fractionAmt) throws Throwable {
		float taxRate = parseIntoFloat(integerAmt, fractionAmt);
		store.getCart().setTaxes(taxRate);
	}

	@Then("^my total value should be (\\d+)\\.(\\d+) dollars$")
	public void myTotalValueShouldBeDollars(int integerAmt, int fractionAmt) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	private Float parseIntoFloat(int integerAmt, int fractionAmt) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		String stringDecimal = Integer.toString(integerAmt) + "." + Integer.toString(fractionAmt);
		Float parseFloat = Float.parseFloat(stringDecimal);
		return parseFloat;
	}
}