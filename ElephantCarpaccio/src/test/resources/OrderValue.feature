Feature: Display Order Value after Item Added
	As a retail shopper 
	I want to add items and get the total value 
	So that I know how much my stuff will cost before taxes
	
Scenario Outline: Shopping in a retail store and checkout 
		one item for different dollar amounts
	Given I am shopping in a retail store
	When I add "item one" of <price> dollars
	Then my checkout value should be <total>
	
	Examples: 
	| price		| total		|
	| 400		| 400		|
	| 300		| 300 		|
#	| 255.53	| 255.53	|
	
Scenario: Shopping in a retail store and checkout two items different price
	Given I am shopping in a retail store
	When I add "item one" of 300 dollars
	And I add "item two" of 400 dollars
	Then my checkout value should be 700
	
#Scenario: Checkout one item for 255.53 dollars
#	Given The price of "item one" is 255.53
#	When I add "item one" to my cart
#	Then the order value should be 255.53
	
#Scenario: Checkout two items of same price
#	Given The price of "item one" is $300
#	When I add "item one" to my cart
#	And I add "item two" to my cart
#	Then the order value should be $600