Feature: Charge taxes on shopping cart
	As a retail shopper
	I want to be charged taxes for the items in my shopping cart
	So that the state can fund important projects that help community

Scenario: Allow checkout person to manually enter a sales tax amount
	Given I am shopping in a retail store
	And I add 2 items of 250 dollars
	When I apply a sales tax of 6.85%
	Then my total value should be 534.25 dollars
	
Scenario: Apply Utah tax rate to my purchase
	Given I am shopping in a retail store in "Utah"
	And I add 2 items of 550 dollars
	When I apply "Utah" sales tax
	Then my total value should be 1174.8 dollars
	
Scenario: Apply Nevada tax rate to my purchase
	Given I am shopping in a retail store in "Nevada"
	And I add 2 items of 550 dollars
	When I apply "Nevada" sales tax
	Then my total value should be 1188.00 dollars
	