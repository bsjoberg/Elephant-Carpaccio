Feature: Remove item from cart
	As a retail shopping user
	I want to be able to remove items from my cart
	So that I do not purchase things that I do not want.
	
Scenario: Remove one item from the cart and see amount is less
	Given I have two items in my cart that total 500 dollars
	When I remove one item of 250 dollars
	Then my cart should have a total of 250 dollars