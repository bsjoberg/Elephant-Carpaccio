Feature: Remove an item or items from the cart
	As a retail shopping user
	I want to be able to remove items from my cart
	So that I do not purchase things that I do not want.
	
Scenario: Remove one item from the cart and see amount is adjusted
	Given I am shopping in a retail store
	And I add 2 items of 300 dollars
	When I remove one item
	Then my subtotal value should be 300 dollars
	
Scenario: Remove two items from the cart and see amount is adjusted
	Given I am shopping in a retail store
	And I add 3 items of 600 dollars
	When I remove one item
	And I remove one item
	Then my subtotal value should be 600 dollars
	
Scenario: I cannot remove an item if I do not have any in my shopping cart