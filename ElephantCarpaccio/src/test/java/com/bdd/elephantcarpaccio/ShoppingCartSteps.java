package com.bdd.elephantcarpaccio;

import java.text.DecimalFormat;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartSteps {
	private RetailStore store = new RetailStore();
	
	@Given("^I am shopping in a retail store$")
	public void iAmShoppingInARetailStore() throws Throwable {
	    // Store needs to be up and running.
		store = new RetailStore();
	}

	@Given("^I am shopping in a retail store in \"([^\"]*)\"$")
	public void iAmShoppingInARetailStoreIn(String stateName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    store = new RetailStore(stateName);
	}
	
	@When("^I add (\\d+) item of (\\d+) dollars$")
	public void iAddItemOfDollars(int numberItems, int itemPrice) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		store.getCart().add(numberItems, itemPrice);
	}

	@When("^I add (\\d+) item of (\\d+)\\.(\\d+) dollars$")
	public void iAddItemOfDollars(int numberOfItems, int integerAmt, int fractionAmt) throws Throwable {
		float itemPrice = parseIntoFloat(integerAmt, fractionAmt);
		store.getCart().add(numberOfItems, itemPrice);
	}

	@When("^I add (\\d+) items of (\\d+) dollars$")
	public void iAddItemsOfDollars(int numberOfItems, int value) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		store.getCart().add(numberOfItems, value);
	}
	
	@When("^I remove one item$")
	public void iRemoveTheFirstItem() throws Throwable {
		store.getCart().removeItem();
	}

	@When("^I apply a sales tax of (\\d+)\\.(\\d+)%$")
	public void iApplyASalesTaxOf(int integerAmt, int fractionAmt) throws Throwable {
		float taxRate = parseIntoFloat(integerAmt, fractionAmt);
		store.getCart().setTaxRate(taxRate);
	}

	@When("^I apply \"([^\"]*)\" sales tax$")
	public void iApplySalesTax(String stateName) throws Throwable {
		// Don't need code for now.
	}

	@Then("^my subtotal value should be (\\d+) dollars$")
	public void mySubtotalValueShouldBe(int value) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(value, store.getCart().getSubTotal(), 2);
	}

	@Then("^my subtotal value should be (\\d+)\\.(\\d+) dollars$")
	public void mySubtotalValueShouldBeDollars(int integerAmt, int fractionAmt) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		float subTotalValue = parseIntoFloat(integerAmt, fractionAmt);
		Assert.assertEquals(subTotalValue, store.getCart().getSubTotal(), 2);
	}
	
	@Then("^my total value should be (\\d+)\\.(\\d+) dollars$")
	public void myTotalValueShouldBeDollars(int integerAmt, int fractionAmt) throws Throwable {
		float cartValue = parseIntoFloat(integerAmt, fractionAmt);
	    Assert.assertEquals(cartValue, store.getCart().getTotal(), 2);
	}
	
	private Float parseIntoFloat(int integerAmt, int fractionAmt) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		String stringDecimal = Integer.toString(integerAmt) + "." + Integer.toString(fractionAmt);
		Float parseFloat = Float.parseFloat(stringDecimal);
		return parseFloat;
	}
}
