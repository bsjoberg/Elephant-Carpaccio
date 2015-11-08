Feature: Hello World
	As a retail shopper
	I want to see that the setup for retail calculator is working
	So that I have some confidence that the developer will be able to deliver this
	
Scenario: Display Hello World
	Given My environment is configured
	When I run HelloWorld
	Then I should see the words HelloWorld displayed