Feature: Charge taxes on shopping cart
	As a retail shopper
	I want to be charged taxes for the items in my shopping cart
	So that the state can fund important projects that help community

Scenario: Allow checkout person to manually enter a sales tax amount
	Given I am shopping in a retail store
	And I add "item one" of 200 dollars
	And I add "item two" of 300 dollars
	When I apply a sales tax of 6.85%
	Then my total value should be 534.25 dollars