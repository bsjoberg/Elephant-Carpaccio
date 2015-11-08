Feature: Remove item(s) from the cart
	As a retail shopping user
	I want to be able to remove items from my cart
	So that I do not purchase things that I do not want.
	
Scenario: Remove the last item from the cart and see amount is adjusted
	Given I am shopping in a retail store
	And I add "item one" of 200 dollars
	And I add "item two" of 300 dollars
	When I remove the last item
	Then my subtotal value should be 200 dollars
	
Scenario: Remove the first item from the cart and see amount is adjusted
	Given I am shopping in a retail store
	And I add "item one" of 600 dollars
	And I add "item two" of 400 dollars
	When I remove the first item
	Then my subtotal value should be 400 dollars