package com.bdd.elephantcarpaccio;

import org.junit.Assert;

import com.bdd.elephantcarpaccio.HelloWorld;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorldSteps {
	HelloWorld helloWorld = null;
	
	@Given("^My environment is configured$")
	public void myEnvironmentIsConfigured() throws Throwable {
	    helloWorld = new HelloWorld();
	}

	@When("^I run HelloWorld$")
	public void iRunHelloWorld() throws Throwable {
	    // Nothing happening here.
	}

	@Then("^I should see the words HelloWorld displayed$")
	public void iShouldSeeTheWordsHelloWorldDisplayed() throws Throwable {
	    Assert.assertEquals("Hello World!", helloWorld.getText());
	}
}
