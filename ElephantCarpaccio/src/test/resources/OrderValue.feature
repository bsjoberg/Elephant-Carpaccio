Feature: Display Order Value after Item Added
	As a retail shopper 
	I want to add items and get the total value 
	So that I know how much my stuff will cost before taxes
	
Scenario Outline: Shopping in a retail store and want to know subtotal 
		one item for different dollar amounts
	Given I am shopping in a retail store
	When I add "item one" of <price> dollars
	Then my subtotal value should be <total> dollars
	
	Examples: 
	| price		| total		|
	| 400		| 400		|
	| 300		| 300 		|
	| 255.53	| 255.53	|
	
Scenario: Shopping in a retail store and want to know subtotal two items different price
	Given I am shopping in a retail store
	When I add "item one" of 300 dollars
	And I add "item two" of 400 dollars
	Then my subtotal value should be 700 dollars
	
Scenario: Subtotal one item for 255.53 dollars
	Given I am shopping in a retail store
	When I add "item one" of 255.53 dollars
	Then my subtotal value should be 255.53 dollars
	
Scenario: Subtotal two items of same price
	Given I am shopping in a retail store
	When I add "item one" of 300 dollars
	And I add "item two" of 300 dollars
	Then my subtotal value should be 600 dollars